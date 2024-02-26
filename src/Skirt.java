public class Skirt implements Observer {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String size;
    private int price;
    private String material;
    private String color;
    private int waistline;
    private String pattern;

    // No-argument constructor
    public Skirt() {}

    @Override
    public void update(String message) {
        System.out.println("Notification for Skirt, " + name + ": " + message);
    }

    // Getters and setters for each attribute
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWaistline() {
        return waistline;
    }

    public void setWaistline(int waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    // Builder nested class
    public static class SkirtBuilder {
        private String name;
        private String size;
        private int price;
        private String material;
        private String color;
        private int waistline;
        private String pattern;

        public SkirtBuilder(String name, String size, String material, String color, int waistline, String pattern) {
            this.name = name;
            this.size = size;
            this.material = material;
            this.color = color;
            this.waistline = waistline;
            this.pattern = pattern;
        }

        public Skirt build() {
            Skirt skirt = new Skirt();
            skirt.setId(++idCounter);
            skirt.setName(this.name);
            skirt.setSize(this.size);
            skirt.setMaterial(this.material);
            skirt.setColor(this.color);
            skirt.setWaistline(this.waistline);
            skirt.setPattern(this.pattern);
            skirt.setPrice(calculatePrice(this.material, this.pattern));
            return skirt;
        }

        private int calculatePrice(String material, String pattern) {
            int price = 0;
            switch(material) {
                case "Cotton":
                    price += 50;
                    break;
                case "Nylon":
                    price += 100;
                    break;
            }
            switch (pattern) {
                case "Straight":
                    price += 50;
                case "A-line":
                    price += 100;
                case "Maxi":
                    price += 150;
            }
            return price;
        }
    }
}