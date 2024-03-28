public class CustomizeTShirtCommand implements Command {
    private TShirt tShirt;
    private String customizationType;
    private String value;

    public CustomizeTShirtCommand(TShirt tShirt, String customizationType, String value) {
        this.tShirt = tShirt;
        this.customizationType = customizationType;
        this.value = value;
    }

    @Override
    public void execute() {
        switch (customizationType) {
            case "neck":
                tShirt.setNeck(Integer.parseInt(value));
                System.out.println("The neck of the t-shirt is set to " + value + ".");
                break;
            case "color":
                tShirt.setColor(value);
                System.out.println("The color of the t-shirt is set to " + value + ".");
                break;
            case "material":
                tShirt.setMaterial(value);
                System.out.println("The material of the t-shirt is set to " + value + ".");
                break;
            case "size":
                tShirt.setSize(value);
                System.out.println("The size of the t-shirt is set to " + value + ".");
                break;
            case "sleeves":
                tShirt.setSleeves(value);
                System.out.println("The sleeves of the t-shirt is set to " + value + ".");
                break;
            case "price":
                tShirt.setPrice(Integer.parseInt(value));
                System.out.println("The price of the t-shirt is set to " + value + ".");
                break;
            default:
                System.out.println("Customization type " + customizationType + " not recognized.");
                break;
        }
    }
}
