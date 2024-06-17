package edu.austral.ingsis.clifford.Commands;

import edu.austral.ingsis.clifford.system.FileSystem;

public class CdCommand{

    private final FileSystem fileSystem;

    public CdCommand(FileSystem fileSystem){
        this.fileSystem = fileSystem;
    }


    public FileSystem execute(String[] args) {
        if(args.length != 1){
            return null;
        }
        String path = args[0];
        switch (path) {
            case "..":
                return moveToParentDirectory();
            case ".":
                return stayInCurrentDirectory();
            default:
                return moveToDirectory(path);
        }
    }

    private FileSystem moveToParentDirectory() {
        return fileSystem.moveToParentDirectory();
    }

    private FileSystem stayInCurrentDirectory() {
        return fileSystem;
    }

    private FileSystem moveToDirectory(String path) {
        FileSystem current = fileSystem;
        if(path.startsWith("/")){
            current = current.moveToRoot();
            path = path.substring(1); // remove the leading "/"
        }
        String[] directories = path.split("/");
        for(String directory : directories){
            FileSystem child = current.getChild(directory);
            if(child == null) {
                return null;
            }
            current = child;
        }
        return current;
    }
}
