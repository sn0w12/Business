import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CEO ceo = new CEO.CEOBuilder(0, "John").build();
        GarmentCreationSystem garmentCreationSystem = new GarmentCreationSystem();
        garmentCreationSystem.attach(ceo);

        boolean run = true;
        boolean isSignedIn = false;
        Customer currentCostumer;

        while(run) {
            ConsoleUI.print("Choose an option:");
            int answer = ConsoleUI.askForChoiceFromList(Arrays.asList("Sign In", "Buy pants", "Buy t-shirt", "Buy skirt", "Exit"));
            switch (answer) {
                case 1:
                    String customerName = ConsoleUI.askString("Write your name: ");
                    String customerAddress = ConsoleUI.askString("Write your address: ");
                    String customerEmail = ConsoleUI.askString("Write your email: ");
                    Customer customer = new Customer.CustomerBuilder(customerName, customerAddress, customerEmail).build();
                    currentCostumer = customer;
                    customer.update("Your account has successfully been added!");
                    break;
                case 4:
                    Skirt skirt = new Skirt();
                    garmentCreationSystem.start("skirt");

                    ConsoleUI.print("Choose skirt material:");
                    String skirtMaterial = ConsoleUI.askForChoiceFromListString(Arrays.asList("Cotton", "Nylon"));

                    ConsoleUI.print("Choose skirt size:");
                    String skirtSize = ConsoleUI.askForChoiceFromListString(Arrays.asList("Small", "Large"));

                    ConsoleUI.print("Choose skirt color:");
                    String skirtColor = ConsoleUI.askForChoiceFromListString(Arrays.asList("Black", "Purple"));

                    ConsoleUI.print("Choose waistline size:");
                    String skirtWaistline = ConsoleUI.askForChoiceFromListString(Arrays.asList("30", "35", "40"));

                    ConsoleUI.print("Choose skirt pattern:");
                    String skirtPattern = ConsoleUI.askForChoiceFromListString(Arrays.asList("Straight", "A-line", "Maxi"));

                    skirt = garmentCreationSystem.createSkirt("Name", skirtMaterial, skirtSize, skirtColor, skirtWaistline, skirtPattern);

                    ConsoleUI.print("\nReceipt:\nSize: " + skirt.getSize() + "\n" + "Material: " + skirt.getMaterial() + "\n" + "Color: " + skirt.getColor() + "\n" + "Waistline: " + skirt.getWaistline() + "\n" + "Size: " + skirt.getSize() + "\n" + "Pattern: " + skirt.getPattern() + "\n" + "Price: " + skirt.getPrice() + "Kr\n");
                    break;
                case 5:
                    run = false;
                    break;
            }
        }
    }
}