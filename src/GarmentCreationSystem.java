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

    public Pants createPants(String name, String size, String material, String color, String fit, String length) {
        Pants pants = new Pants.PantsBuilder()
                .name(name)
                .size(size)
                .material(material)
                .color(color)
                .build();

        ClothingCustomizer customizer = new ClothingCustomizer();

        Command customizePantsFit = new CustomizePantsCommand(pants, "fit", fit);
        customizer.setCommand(customizePantsFit);
        customizer.customize();

        Command customizePantsLength = new CustomizePantsCommand(pants, "length", length);
        customizer.setCommand(customizePantsLength);
        customizer.customize();

        Command customizePantsPrice = new CustomizePantsCommand(pants, "price", Integer.toString(calculatePantsPrice(pants.getMaterial(), pants.getFit())));
        customizer.setCommand(customizePantsPrice);
        customizer.customize();

        notifyObservers("New pants with id " + pants.getId() + " has been created.");
        return pants;
    }

    public TShirt createTShirt(String name, String size, String material, String color, String neck, String sleeves) {
        TShirt tShirt = new TShirt.TShirtBuilder()
                .name(name)
                .size(size)
                .material(material)
                .color(color)
                .build();

        ClothingCustomizer customizer = new ClothingCustomizer();

        Command customizeTShirtNeck = new CustomizeTShirtCommand(tShirt, "neck", neck);
        customizer.setCommand(customizeTShirtNeck);
        customizer.customize();

        Command customizeTShirtSleeves = new CustomizeTShirtCommand(tShirt, "sleeves", sleeves);
        customizer.setCommand(customizeTShirtSleeves);
        customizer.customize();

        Command customizeTShirtPrice = new CustomizeTShirtCommand(tShirt, "price", Integer.toString(calculateTShirtPrice(tShirt.getMaterial(), tShirt.getSleeves())));
        customizer.setCommand(customizeTShirtPrice);
        customizer.customize();

        notifyObservers("New tShirt with id " + tShirt.getId() + " has been created.");
        return tShirt;
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

    private int calculatePantsPrice(String material, String fit) {
        int price = 0;
        switch(material) {
            case "Cotton":
                price += 100;
                break;
            case "Denim":
                price += 200;
                break;
        }
        switch (fit) {
            case "Slim":
                price += 100;
            case "Straight":
                price += 200;
            case "Baggy":
                price += 400;
        }
        // Return price - 1 to get 99 at end of price
        return --price;
    }

    private int calculateTShirtPrice(String material, String sleeves) {
        int price = 0;
        switch(material) {
            case "Cotton":
                price += 100;
                break;
            case "Polyester":
                price += 200;
                break;
        }
        switch (sleeves) {
            case "Sleeveless":
                price += 100;
            case "Short Sleeves":
                price += 200;
            case "Long sleeves":
                price += 400;
        }
        // Return price - 1 to get 99 at end of price
        return --price;
    }
}