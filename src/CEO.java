public class CEO implements Observer {
    private int id;
    private String name;

    // No-argument constructor
    public CEO() {}

    @Override
    public void update(String message) {
        System.out.println("Notification for CEO, " + name + ": " + message);
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

    public static class CEOBuilder {
        private int id;
        private String name;

        // Constructor without parameters for initial builder setup
        public CEOBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // Build method to create a new CEO instance with the specified attributes
        public CEO build() {
            CEO ceo = new CEO();
            ceo.setId(this.id);
            ceo.setName(this.name);
            return ceo;
        }
    }
}