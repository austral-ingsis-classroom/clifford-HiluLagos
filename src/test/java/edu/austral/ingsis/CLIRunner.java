package edu.austral.ingsis;

import edu.austral.ingsis.clifford.ImplementationCLI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CLIRunner implements FileSystemRunner {
  private final ImplementationCLI cli;

  public CLIRunner(ImplementationCLI cli) {
    this.cli = cli;
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    return commands.stream()
        .map(
            command -> {
              String[] parts = command.split(" ");
              String cmd = parts[0];
              String[] args = Arrays.copyOfRange(parts, 1, parts.length);
              return cli.runCommand(cmd, args);
            })
        .collect(Collectors.toList());
  }
}
