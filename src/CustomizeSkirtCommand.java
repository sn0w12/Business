public class CustomizeSkirtCommand implements Command {
    private Skirt skirt;
    private String customizationType;
    private String customizationValue;

    public CustomizeSkirtCommand(Skirt skirt, String customizationType, String customizationValue) {
        this.skirt = skirt;
        this.customizationType = customizationType;
        this.customizationValue = customizationValue;
    }

    @Override
    public void execute() {
        switch (customizationType) {
            case "pattern":
                skirt.setPattern(customizationValue);
                break;
            case "color":
                skirt.setColor(customizationValue);
                break;
            // Add more cases for different types of customizations
            default:
                System.out.println("Customization type " + customizationType + " not recognized.");
                break;
        }
    }
}
