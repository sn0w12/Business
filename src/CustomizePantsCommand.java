class CustomizePantsCommand implements Command {
    private Pants pants;
    private String attribute;
    private String value;

    public CustomizePantsCommand(Pants pants, String attribute, String value) {
        this.pants = pants;
        this.attribute = attribute;
        this.value = value;
    }

    @Override
    public void execute() {
        switch (attribute) {
            case "material":
                pants.setMaterial(value);
                System.out.println("The material of the pants is set to " + value + ".");
                break;
            case "size":
                pants.setSize(value);
                System.out.println("The size of the pants is set to " + value + ".");
                break;
            case "color":
                pants.setColor(value);
                System.out.println("The color of the pants is set to " + value + ".");
                break;
            case "fit":
                pants.setFit(value);
                System.out.println("The fit of the pants is set to " + value + ".");
                break;
            case "length":
                pants.setLength(Integer.parseInt(value));
                System.out.println("The length of the pants is set to " + value + ".");
                break;
            case "price":
                pants.setPrice(Integer.parseInt(value));
                System.out.println("The price of the pants is set to " + value + ".");
                break;
            default:
                throw new IllegalArgumentException("Unknown attribute: " + attribute);
        }
    }
}
