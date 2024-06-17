package edu.austral.ingsis.clifford.Commands;

import edu.austral.ingsis.clifford.system.FileSystem;
import java.util.Objects;

public class PwdCommand implements Command {

  private FileSystem fileSystem;

  public PwdCommand(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public String execute(String[] args) {
    if (args.length != 0) {
      return "Command takes no arguments";
    }
    FileSystem current = fileSystem;
    StringBuilder result = new StringBuilder();
    while (!Objects.equals(current.getName(), "/")) {
      result.insert(0, "/" + current.getName());
      current = current.getParent();
    }
    return result.toString();
  }
}
