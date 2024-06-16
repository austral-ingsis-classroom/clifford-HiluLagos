package edu.austral.ingsis.clifford.system;

import java.util.List;

public interface FileSystem {

    public List<String> listChildren();

    public List<FileSystem> getChildren();

    public String getName();

    public String addChildren(FileSystem child);

    public String removeChildren(String name);

    public FileSystem getChild(String name);

}
