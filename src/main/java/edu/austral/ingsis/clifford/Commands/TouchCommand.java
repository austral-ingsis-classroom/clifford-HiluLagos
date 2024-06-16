package edu.austral.ingsis.clifford.Commands;

import edu.austral.ingsis.clifford.system.File;
import edu.austral.ingsis.clifford.system.FileSystem;

public class TouchCommand implements Command{

    private final FileSystem fileSystem;

    public TouchCommand(FileSystem fileSystem){
        this.fileSystem = fileSystem;
    }

    @Override
    public String execute(String[] args) {
        if(args.length != 1){
            return "Invalid number of arguments, must be one";
        }
        else {
            if (fileSystem instanceof File) {
                return "Can not add a file to a file";
            }
            String name = args[0];
            fileSystem.addChildren(new File(name));
            return "'" + name + "' " + "file created";
        }
    }
}
