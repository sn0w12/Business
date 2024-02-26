public class TShirt implements Observer {
    private String id;
    private String name;
    private String size;
    private int price;
    private String material;
    private String color;
    private String sleeves;
    private String neck;

    // No-argument constructor
    public TShirt() {}

    @Override
    public void update(String message) {
        System.out.println("Notification for TShirt, " + name + ": " + message);
    }

    // Getters and setters for each attribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }
}