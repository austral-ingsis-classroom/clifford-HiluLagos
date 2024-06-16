package edu.austral.ingsis.clifford.system;

import java.util.List;

public class File implements FileSystem {

    private final String name;

    public File(String name) {
        this.name = name;
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
    public String removeChildren(String name) {
        throw new UnsupportedOperationException("Cannot remove children from a file");
    }

    @Override
    public FileSystem getChild(String name) {
        return null;
    }
}
