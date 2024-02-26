import java.util.ArrayList;
import java.util.List;


public class Observable {
    private List<Observer> observers = new ArrayList<>();

    // Method to add an observer
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // Method to remove an observer
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers of a change
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
