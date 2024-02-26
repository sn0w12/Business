public class Customer implements Observer {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String address;
    private String email;

    // No-argument constructor
    public Customer() {}

    @Override
    public void update(String message) {
        System.out.println("Notification for Customer, " + name + ": " + message);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class CustomerBuilder {
        private String name;
        private String address;
        private String email;

        // Constructor without parameters for initial builder setup
        public CustomerBuilder(String name, String address, String email) {
            this.name = name;
            this.address = address;
            this.email = email;
        }

        // Build method to create a new CEO instance with the specified attributes
        public Customer build() {
            Customer customer = new Customer();
            customer.setId(++idCounter);
            customer.setName(this.name);
            customer.setAddress(this.address);
            customer.setEmail(this.email);
            return customer;
        }
    }
}