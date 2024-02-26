public class ClothingCustomizer {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void customize() {
        command.execute();
    }
}
