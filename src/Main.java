import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CEO ceo = new CEO.CEOBuilder()
                .name("John")
                .build();
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
                    Customer customer = new Customer.CustomerBuilder()
                            .name(customerName)
                            .address(customerAddress)
                            .email(customerEmail)
                            .build();
                    currentCostumer = customer;
                    isSignedIn = true;
                    customer.update("Your account has successfully been added!");
                    break;
                case 2:
                    if (isSignedIn) {
                        Pants pants = new Pants();
                        garmentCreationSystem.start("pants");

                        ConsoleUI.print("Choose pants material:");
                        String pantsMaterial = ConsoleUI.askForChoiceFromListString(Arrays.asList("Cotton", "Denim"));

                        ConsoleUI.print("Choose pants size:");
                        String pantsSize = ConsoleUI.askForChoiceFromListString(Arrays.asList("Small", "Large"));

                        ConsoleUI.print("Choose pants color:");
                        String pantsColor = ConsoleUI.askForChoiceFromListString(Arrays.asList("Black", "Blue"));

                        ConsoleUI.print("Choose fit:");
                        String pantsFit = ConsoleUI.askForChoiceFromListString(Arrays.asList("Slim", "Straight", "Baggy"));

                        ConsoleUI.print("Choose pants length:");
                        String pantsLength = ConsoleUI.askForChoiceFromListString(Arrays.asList("30", "35", "40"));

                        pants = garmentCreationSystem.createPants("Name", pantsSize, pantsMaterial, pantsColor, pantsFit, pantsLength);
                        ConsoleUI.print("\nReceipt:\nSize: " + pants.getSize() + "\n" + "Material: " + pants.getMaterial() + "\n" + "Color: " + pants.getColor() + "\n" + "Fit: " + pants.getFit() + "\n" + "Length: " + pants.getLength() + "\n" + "Price: " + pants.getPrice() + "Kr\n");
                    } else {
                        ConsoleUI.print("You need to sign in to order.");
                    }
                    break;
                case 3:
                    if (isSignedIn) {
                        TShirt tShirt = new TShirt();
                        garmentCreationSystem.start("tshirt");

                        ConsoleUI.print("Choose tShirt material:");
                        String tShirtMaterial = ConsoleUI.askForChoiceFromListString(Arrays.asList("Cotton", "Polyester"));

                        ConsoleUI.print("Choose tShirt size:");
                        String tShirtSize = ConsoleUI.askForChoiceFromListString(Arrays.asList("Small", "Large"));

                        ConsoleUI.print("Choose tShirt color:");
                        String tShirtColor = ConsoleUI.askForChoiceFromListString(Arrays.asList("Black", "Blue"));

                        ConsoleUI.print("Choose tShirt neck:");
                        String tShirtNeck = ConsoleUI.askForChoiceFromListString(Arrays.asList("30", "35", "40"));

                        ConsoleUI.print("Choose tShirt sleeves:");
                        String tShirtSleeves = ConsoleUI.askForChoiceFromListString(Arrays.asList("Sleeveless", "Short Sleeves", "Long sleeves"));

                        tShirt = garmentCreationSystem.createTShirt("Name", tShirtSize, tShirtMaterial, tShirtColor, tShirtNeck, tShirtSleeves);
                        ConsoleUI.print("\nReceipt:\nSize: " + tShirt.getSize() + "\n" + "Material: " + tShirt.getMaterial() + "\n" + "Color: " + tShirt.getColor() + "\n" + "Neck: " + tShirt.getNeck() + "\n" + "Sleeves: " + tShirt.getSleeves() + "\n" + "Price: " + tShirt.getPrice() + "Kr\n");
                    } else {
                        ConsoleUI.print("You need to sign in to order.");
                    }
                    break;
                case 4:
                    if (isSignedIn) {
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

                        String skirtName = skirtMaterial + "-" + skirtPattern;
                        skirt = garmentCreationSystem.createSkirt(skirtName, skirtMaterial, skirtSize, skirtColor, skirtWaistline, skirtPattern);

                        ConsoleUI.print("\nReceipt:\nSize: " + skirt.getSize() + "\n" + "Material: " + skirt.getMaterial() + "\n" + "Color: " + skirt.getColor() + "\n" + "Waistline: " + skirt.getWaistline() + "\n" + "Pattern: " + skirt.getPattern() + "\n" + "Price: " + skirt.getPrice() + "Kr\n");
                    } else {
                        ConsoleUI.print("You need to sign in to order.");
                    }
                    break;
                case 5:
                    run = false;
                    break;
                default:
                    ConsoleUI.print("Input not recognised");
                    break;
            }
        }
    }
}