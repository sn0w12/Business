public class Pants implements Observer {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String size;
    private int price;
    private String material;
    private String color;
    private String fit;
    private int length;

    // No-argument constructor
    public Pants() {}

    @Override
    public void update(String message) {
        System.out.println("Notification for Pants, " + name + ": " + message);
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

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static class PantsBuilder {
        private String name;
        private String size;
        private int price;
        private String material;
        private String color;
        private String fit;
        private int length;

        public PantsBuilder() {}

        public PantsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PantsBuilder size(String size) {
            this.size = size;
            return this;
        }

        public PantsBuilder price(int price) {
            this.price = price;
            return this;
        }

        public PantsBuilder material(String material) {
            this.material = material;
            return this;
        }

        public PantsBuilder color(String color) {
            this.color = color;
            return this;
        }

        public PantsBuilder fit(String fit) {
            this.fit = fit;
            return this;
        }

        public PantsBuilder length(int length) {
            this.length = length;
            return this;
        }

        public Pants build() {
            Pants pants = new Pants();
            pants.setId(++idCounter);
            pants.setName(this.name);
            pants.setSize(this.size);
            pants.setPrice(this.price);
            pants.setMaterial(this.material);
            pants.setColor(this.color);
            pants.setFit(this.fit);
            pants.setLength(this.length);
            return pants;
        }
    }
}