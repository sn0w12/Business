public class CustomizePantsCommand implements Command {
    private Pants pants;
    private String customizationType;
    private String customizationValue;

    public CustomizePantsCommand(Pants pants, String customizationType, String customizationValue) {
        this.pants = pants;
        this.customizationType = customizationType;
        this.customizationValue = customizationValue;
    }

    @Override
    public void execute() {
        switch (customizationType) {
            case "fit":
                pants.setFit(customizationValue);
                break;
            case "color":
                pants.setColor(customizationValue);
                break;
            case "material":
                pants.setMaterial(customizationValue);
                break;
            case "size":
                pants.setSize(customizationValue);
                break;
            case "length":
                pants.setLength(Integer.parseInt(customizationValue));
                break;
            case "price":
                pants.setPrice(Integer.parseInt(customizationValue));
                break;
            default:
                System.out.println("Customization type " + customizationType + " not recognized.");
                break;
        }
    }
}
