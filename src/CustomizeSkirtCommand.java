public class CustomizeSkirtCommand implements Command {
    private Skirt skirt;
    private String customizationType;
    private String value;

    public CustomizeSkirtCommand(Skirt skirt, String customizationType, String value) {
        this.skirt = skirt;
        this.customizationType = customizationType;
        this.value = value;
    }

    @Override
    public void execute() {
        switch (customizationType) {
            case "pattern":
                skirt.setPattern(value);
                System.out.println("The pattern of the skirt is set to " + value + ".");
                break;
            case "color":
                skirt.setColor(value);
                System.out.println("The color of the skirt is set to " + value + ".");
                break;
            case "material":
                skirt.setMaterial(value);
                System.out.println("The material of the skirt is set to " + value + ".");
                break;
            case "size":
                skirt.setSize(value);
                System.out.println("The size of the skirt is set to " + value + ".");
                break;
            case "waistline":
                skirt.setWaistline(Integer.parseInt(value));
                System.out.println("The waistline of the skirt is set to " + value + ".");
                break;
            case "price":
                skirt.setPrice(Integer.parseInt(value));
                System.out.println("The price of the skirt is set to " + value + ".");
                break;
            default:
                System.out.println("Customization type " + customizationType + " not recognized.");
                break;
        }
    }
}
