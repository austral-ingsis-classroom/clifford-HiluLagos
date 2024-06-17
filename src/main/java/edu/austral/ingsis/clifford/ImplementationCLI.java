package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.Commands.*;
import edu.austral.ingsis.clifford.system.Directory;
import edu.austral.ingsis.clifford.system.FileSystem;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ImplementationCLI {

  private final Map<String, Command> commands;
  private FileSystem fileSystem;

  public ImplementationCLI() {
    this.fileSystem = new Directory("/", null);
    commands = new HashMap<>();
    commands.put("ls", new LsCommand(fileSystem));
    commands.put("mkdir", new MkDirCommand(fileSystem));
    commands.put("rm", new RmCommand(fileSystem));
    commands.put("touch", new TouchCommand(fileSystem));
    commands.put("pwd", new PwdCommand(fileSystem));
  }

  public String runCommand(String command, String[] args) {
    if (Objects.equals(command, "cd")) {
      return handleCd(command, args);
    }
    Command cmd = commands.get(command);
    if (cmd != null) {
      String result = cmd.execute(args);
      return result;
    } else {
      return "Command not found: " + command;
    }
  }

  private String handleCd(String command, String[] args) {
    if (Objects.equals(command, "cd")) {
      CdCommand cdCommand = new CdCommand(fileSystem);
      FileSystem movedTo = cdCommand.execute(args);
      if (movedTo == null && args[0] != "/") {
        return "'" + args[0] + "' directory does not exist";
      } else {
        updateCommands(movedTo);
        return "moved to directory " + "'" + movedTo.getName() + "'";
      }
    }
    return null;
  }

  private void updateCommands(FileSystem movedTo) {
    commands.clear();
    commands.put("ls", new LsCommand(movedTo));
    commands.put("mkdir", new MkDirCommand(movedTo));
    commands.put("rm", new RmCommand(movedTo));
    commands.put("touch", new TouchCommand(movedTo));
    commands.put("pwd", new PwdCommand(movedTo));
  }

  // Add this method to get the current directory
  public FileSystem getCurrentDirectory() {
    return fileSystem;
  }
}
