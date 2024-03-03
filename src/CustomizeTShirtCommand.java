public class CustomizeTShirtCommand implements Command {
    private TShirt tShirt;
    private String customizationType;
    private String customizationValue;

    public CustomizeTShirtCommand(TShirt tShirt, String customizationType, String customizationValue) {
        this.tShirt = tShirt;
        this.customizationType = customizationType;
        this.customizationValue = customizationValue;
    }

    @Override
    public void execute() {
        switch (customizationType) {
            case "neck":
                tShirt.setNeck(Integer.parseInt(customizationValue));
                break;
            case "color":
                tShirt.setColor(customizationValue);
                break;
            case "material":
                tShirt.setMaterial(customizationValue);
                break;
            case "size":
                tShirt.setSize(customizationValue);
                break;
            case "sleeves":
                tShirt.setSleeves(customizationValue);
                break;
            case "price":
                tShirt.setPrice(Integer.parseInt(customizationValue));
                break;
            default:
                System.out.println("Customization type " + customizationType + " not recognized.");
                break;
        }
    }
}
