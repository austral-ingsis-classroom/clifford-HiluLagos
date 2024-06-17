package edu.austral.ingsis.clifford.Commands;

import edu.austral.ingsis.clifford.system.Directory;
import edu.austral.ingsis.clifford.system.FileSystem;
import java.util.Objects;

public class RmCommand implements Command {

  private final FileSystem fileSystem;

  public RmCommand(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public String execute(String[] args) {
    if (args.length == 0 || args.length > 2) {
      return "Invalid number of arguments";
    } else if (args.length == 1) {
      return removeFile(args[0], false);
    } else {
      if (Objects.equals(args[0], "--recursive")) {
        return removeFile(args[1], true);
      } else {
        return "Invalid first argument";
      }
    }
  }

  private String removeFile(String name, boolean recursive) {
    if (fileSystem.getChild(name) instanceof Directory && !recursive) {
      return "cannot remove " + "'" + name + "'" + ", is a directory";
    }
    FileSystem file = fileSystem.getChild(name);
    if (file == null) {
      return "File not found";
    } else {
      if (recursive) {
        file.removeChildren();
      }
      fileSystem.removeChild(name);
      return "'" + name + "' " + "removed";
    }
  }
}
