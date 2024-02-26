public class GarmentCreationSystem extends Observable {
    public Skirt createSkirt(String name, String size, String material, String color, int waistline, String pattern) {
        Skirt skirt = new Skirt.SkirtBuilder(name, size, material, color, waistline, pattern).build();
        notifyObservers("A new skirt with id " + skirt.getId() + " has been created.");
        return skirt;
    }
}
