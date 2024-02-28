public class CEO implements Observer {
    private static int idCounter = 0;
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

        public CEOBuilder() {}

        public CEO.CEOBuilder name(String name) {
            this.name = name;
            return this;
        }

        // Build method to create a new CEO instance with the specified attributes
        public CEO build() {
            CEO ceo = new CEO();
            ceo.setId(++idCounter);
            ceo.setName(this.name);
            return ceo;
        }
    }
}