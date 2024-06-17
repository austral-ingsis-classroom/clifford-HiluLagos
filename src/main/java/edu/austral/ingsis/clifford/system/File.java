package edu.austral.ingsis.clifford.system;

import java.util.List;

public class File implements FileSystem {

  private final String name;
  private final FileSystem parent;

  public File(String name, FileSystem parent) {
    this.name = name;
    this.parent = parent;
  }

  @Override
  public List<String> listChildren() {
    return List.of();
  }

  @Override
  public List<FileSystem> getChildren() {
    return List.of();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String addChildren(FileSystem child) {
    throw new UnsupportedOperationException("Cannot add children to a file");
  }

  @Override
  public String removeChild(String name) {
    throw new UnsupportedOperationException("Cannot remove children from a file");
  }

  @Override
  public String removeChildren() {
    return "Cannot remove children from a file";
  }

  @Override
  public FileSystem moveToParentDirectory() {
    return parent;
  }

  @Override
  public FileSystem moveToRoot() {
    FileSystem current = this;
    while (current.getParent() != null) {
      current = current.getParent();
    }
    return current;
  }

  @Override
  public FileSystem getChild(String name) {
    return null;
  }

  @Override
  public FileSystem getParent() {
    return parent;
  }
}
