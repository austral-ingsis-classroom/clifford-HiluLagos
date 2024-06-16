package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.Commands.Command;
import edu.austral.ingsis.clifford.Commands.LsCommand;
import edu.austral.ingsis.clifford.system.Directory;
import edu.austral.ingsis.clifford.system.FileSystem;

import java.util.HashMap;
import java.util.Map;

public class ImplementationCLI {

    private final Map<String, Command> commands;
    private FileSystem fileSystem;

    public ImplementationCLI() {
        this.fileSystem = new Directory();
        commands = new HashMap<>();
        commands.put("ls", new LsCommand(fileSystem));
        // TODO: Add more commands
    }

    public void runCommand(String command, String[] args) {
        Command cmd = commands.get(command);
        if (cmd != null) {
            cmd.execute(args);
        } else {
            System.out.println("Command not found: " + command);
        }
    }
/*
    // Add this method to get the current directory
    public FileSystem getCurrentDirectory() {
        return fileSystem.getCurrentDirectory();
    }

 */
}
