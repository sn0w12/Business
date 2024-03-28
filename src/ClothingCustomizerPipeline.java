import java.util.ArrayList;
import java.util.List;

class ClothingCustomizerPipeline {
    private List<Command> commandPipeline = new ArrayList<>();

    public void addCommand(Command command) {
        commandPipeline.add(command);
    }

    public void executeCommands() {
        for (Command command : commandPipeline) {
            command.execute();
        }
        commandPipeline.clear(); // Clear the pipeline after execution
    }
}
