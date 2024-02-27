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
            case "material":
                skirt.setMaterial(customizationValue);
                break;
            case "size":
                skirt.setSize(customizationValue);
                break;
            case "waistline":
                skirt.setWaistline(Integer.parseInt(customizationValue));
                break;
            case "price":
                skirt.setPrice(Integer.parseInt(customizationValue));
                break;
            default:
                System.out.println("Customization type " + customizationType + " not recognized.");
                break;
        }
    }
}
