public class GarmentCreationSystem extends Observable {
    public Skirt createSkirt(String name, String size, String material, String color, String waistline, String pattern) {
        Skirt skirt = new Skirt.SkirtBuilder()
            .name(name)
            .size(size)
            .material(material)
            .color(color)
            .build();

        ClothingCustomizerPipeline customizer = new ClothingCustomizerPipeline();

        customizer.addCommand(new CustomizeSkirtCommand(skirt, "waistline", waistline));
        customizer.addCommand(new CustomizeSkirtCommand(skirt, "pattern", pattern));
        customizer.addCommand(new CustomizeSkirtCommand(skirt, "price", Integer.toString(calculateSkirtPrice(material, pattern))));

        customizer.executeCommands();

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

        ClothingCustomizerPipeline customizer = new ClothingCustomizerPipeline();

        customizer.addCommand(new CustomizePantsCommand(pants, "fit", fit));
        customizer.addCommand(new CustomizePantsCommand(pants, "length", length));
        customizer.addCommand(new CustomizePantsCommand(pants, "price", Integer.toString(calculatePantsPrice(material, fit))));

        customizer.executeCommands();

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

        ClothingCustomizerPipeline customizer = new ClothingCustomizerPipeline();

        customizer.addCommand(new CustomizeTShirtCommand(tShirt, "neck", neck));
        customizer.addCommand(new CustomizeTShirtCommand(tShirt, "sleeves", sleeves));
        customizer.addCommand(new CustomizeTShirtCommand(tShirt, "price", Integer.toString(calculateTShirtPrice(material, sleeves))));

        customizer.executeCommands();

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
                break;
            case "A-line":
                price += 200;
                break;
            case "Maxi":
                price += 400;
                break;
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
                break;
            case "Straight":
                price += 200;
                break;
            case "Baggy":
                price += 400;
                break;
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
                break;
            case "Short Sleeves":
                price += 200;
                break;
            case "Long sleeves":
                price += 400;
                break;
        }
        // Return price - 1 to get 99 at end of price
        return --price;
    }
}