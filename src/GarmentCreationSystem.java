public class GarmentCreationSystem extends Observable {
    public Skirt createSkirt(String name, String size, String material, String color, String waistline, String pattern) {
        Skirt skirt = new Skirt.SkirtBuilder()
            .name(name)
            .size(size)
            .material(material)
            .color(color)
            .build();

        ClothingCustomizer customizer = new ClothingCustomizer();

        Command customizeSkirtWaistline = new CustomizeSkirtCommand(skirt, "waistline", waistline);
        customizer.setCommand(customizeSkirtWaistline);
        customizer.customize();

        Command customizeSkirtPattern = new CustomizeSkirtCommand(skirt, "pattern", pattern);
        customizer.setCommand(customizeSkirtPattern);
        customizer.customize();

        Command customizeSkirtPrice = new CustomizeSkirtCommand(skirt, "price", Integer.toString(calculateSkirtPrice(skirt.getMaterial(), skirt.getPattern())));
        customizer.setCommand(customizeSkirtPrice);
        customizer.customize();

        notifyObservers("A new skirt with id " + skirt.getId() + " has been created.");
        return skirt;
    }

    public void start(String type) {
        notifyObservers("A new " + type + " is being made.");
    }

    private int calculateSkirtPrice(String material, String pattern) {
        int price = 0;
        switch(material) {
            case "Cotton":
                price += 100;
                break;
            case "Nylon":
                price += 200;
                break;
        }
        switch (pattern) {
            case "Straight":
                price += 100;
            case "A-line":
                price += 200;
            case "Maxi":
                price += 400;
        }
        // Return price - 1 to get 99 at end of price
        return --price;
    }
}
