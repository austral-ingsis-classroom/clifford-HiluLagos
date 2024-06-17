package edu.austral.ingsis.clifford.system;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

    private List<FileSystem> children;
    private final String name;
    private final FileSystem parent;

    public Directory() {
        this.name = "";
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public Directory(String name, FileSystem parent) {
        this.name = name;
        this.parent = parent;
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
    public String removeChild(String name) {
        for(FileSystem child : children) {
            if(child.getName().equals(name)) {
                children.remove(child);
                return name + " removed from " + this.name;
            }
        }
        return name + " not found in " + this.name;
    }

    @Override
    public String removeChildren() {
        for(FileSystem child : children){
            child.removeChildren();
        }
        return "Children removed";
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

    @Override
    public FileSystem getParent() {
        return parent;
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
}
