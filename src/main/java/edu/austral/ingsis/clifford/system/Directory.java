package edu.austral.ingsis.clifford.system;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

    private List<FileSystem> children;
    private final String name;

    public Directory() {
        this.name = "";
        this.children = new ArrayList<>();
    }

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public List<String> listChildren() {
        List<String> names = new ArrayList<>();
        for(FileSystem child : children) {
            names.add(child.getName());
        }
        return names;
    }

    @Override
    public List<FileSystem> getChildren() {
        return children;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String addChildren(FileSystem child) {
        children.add(child);
        return child.getName() + " added to " + name;
    }

    @Override
    public String removeChildren(String name) {
        for(FileSystem child : children) {
            if(child.getName().equals(name)) {
                children.remove(child);
                return name + " removed from " + this.name;
            }
        }
        return name + " not found in " + this.name;
    }

    @Override
    public FileSystem getChild(String name) {
        for(FileSystem child : children) {
            if(child.getName().equals(name)) {
                return child;
            }
        }
        return null;
    }
}
