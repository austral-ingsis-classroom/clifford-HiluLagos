package edu.austral.ingsis.clifford.Commands;

import edu.austral.ingsis.clifford.system.Directory;
import edu.austral.ingsis.clifford.system.File;
import edu.austral.ingsis.clifford.system.FileSystem;

public class MkDirCommand implements Command {

  private final FileSystem fileSystem;

  public MkDirCommand(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public String execute(String[] args) {
    if (args.length != 1) {
      return "Invalid number of arguments, must be one";
    } else {
      if (fileSystem instanceof File) {
        return "Can not add a directory to a file";
      }
      String name = args[0];
      fileSystem.addChildren(new Directory(name, fileSystem));
      return "'" + name + "' " + "directory created";
    }
  }
}
