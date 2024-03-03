public class TShirt implements Observer {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String size;
    private int price;
    private String material;
    private String color;
    private String sleeves;
    private int neck;

    // No-argument constructor
    public TShirt() {}

    @Override
    public void update(String message) {
        System.out.println("Notification for TShirt, " + name + ": " + message);
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

    public String getSleeves() {
        return sleeves;
    }

    public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }

    public Integer getNeck() {
        return neck;
    }

    public void setNeck(int neck) {
        this.neck = neck;
    }

    // ShirtBuilder static inner class
    public static class TShirtBuilder {
        private String name;
        private String size;
        private int price;
        private String material;
        private String color;
        private String sleeves;
        private int neck;

        public TShirtBuilder() {}

        public TShirtBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TShirtBuilder size(String size) {
            this.size = size;
            return this;
        }

        public TShirtBuilder price(int price) {
            this.price = price;
            return this;
        }

        public TShirtBuilder material(String material) {
            this.material = material;
            return this;
        }

        public TShirtBuilder color(String color) {
            this.color = color;
            return this;
        }

        public TShirtBuilder neck(int neck) {
            this.neck = neck;
            return this;
        }

        public TShirtBuilder sleeves(String sleeves) {
            this.sleeves = sleeves;
            return this;
        }

        public TShirt build() {
            TShirt tShirt = new TShirt();
            tShirt.setId(++idCounter);
            tShirt.setName(this.name);
            tShirt.setSize(this.size);
            tShirt.setPrice(this.price);
            tShirt.setMaterial(this.material);
            tShirt.setColor(this.color);
            tShirt.setNeck(this.neck);
            tShirt.setSleeves(this.sleeves);
            return tShirt;
        }
    }
}