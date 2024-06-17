package edu.austral.ingsis.clifford.Commands;

import edu.austral.ingsis.clifford.system.FileSystem;

public class PwdCommand implements Command{

    private FileSystem fileSystem;

    public PwdCommand(FileSystem fileSystem){
        this.fileSystem = fileSystem;
    }

    @Override
    public String execute(String[] args) {
        if(args.length != 0){
            return "Command takes no arguments";
        }
        FileSystem root = fileSystem.moveToRoot();
        String result = "";
        FileSystem current = root;
        while(current.getName() != fileSystem.getName()){
            result = result + "/";
            result = result + current.getName();
        }
        return result;
    }
}
