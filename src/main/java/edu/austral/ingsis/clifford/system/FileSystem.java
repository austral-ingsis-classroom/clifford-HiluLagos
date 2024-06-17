package edu.austral.ingsis.clifford.system;

import java.util.List;

public interface FileSystem {

    public List<String> listChildren();

    public List<FileSystem> getChildren();

    public String getName();

    public String addChildren(FileSystem child);

    public String removeChild(String name);

    public String removeChildren();

    public FileSystem moveToParentDirectory();

    public FileSystem moveToRoot();

    public FileSystem getChild(String name);

    public FileSystem getParent();
}
