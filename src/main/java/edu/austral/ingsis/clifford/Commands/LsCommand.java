package edu.austral.ingsis.clifford.Commands;

import edu.austral.ingsis.clifford.system.FileSystem;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LsCommand implements Command {

    private final FileSystem fileSystem;

    public LsCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }


    @Override
    public String execute(String[] args) {
        if(args.length == 0){
            return listChildrenUnsorted();
        }
        else if(args.length == 1){
            if(args[0].equals("--ord=asc")){
                return listChildrenSorted(true);
            } else if (args[0].equals("--ord=desc")) {
                return listChildrenSorted(false);
            }
            else{
                return "Invalid argument";
            }
        }
        else{
            return "Invalid number of arguments";
        }
    }

    private String listChildrenUnsorted() {
        List<String> children = fileSystem.listChildren();
        return formatChildren(children);
    }

    private String listChildrenSorted(boolean ascending) {
        List<String> children = fileSystem.listChildren();
        if (ascending) {
            Collections.sort(children);
        } else {
            Collections.sort(children, Collections.reverseOrder());
        }
        return formatChildren(children);
    }

    private String formatChildren(List<String> children) {
        StringBuilder result = new StringBuilder();
        for(String name : children){
            result.append(name).append(" ");
        }
        return result.toString();
    }
}
