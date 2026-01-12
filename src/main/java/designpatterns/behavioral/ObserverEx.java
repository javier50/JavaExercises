// Core Idea
//   Defines a one-to-many relationship: when one object (the subject) changes state, all dependent objects (observers) are automatically notified.
//   Promotes loose coupling: the subject doesn’t need to know the details of its observers.
//
//Java Implementation
//   Subject maintains a list of observers.
//   Observers implement an update() method.
//   When the subject changes, it calls update() on each observer.
//
// Analogy:
// Think of YouTube subscriptions:
//   The channel is the subject.
//   Subscribers are observers.
//   When a new video is uploaded, all subscribers get notified.

package designpatterns.behavioral;

import java.util.*;

interface Observer {
    void update(String message);
}

class ConcreteObserver implements Observer {
    private String name;
    public ConcreteObserver(String name) { this.name = name; }
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer o) { observers.add(o); }
    public void notifyObservers(String msg) {
        for (Observer o : observers) o.update(msg);
    }
}

public class ObserverEx {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer o1 = new ConcreteObserver("Observer1");
        Observer o2 = new ConcreteObserver("Observer2");

        subject.addObserver(o1);
        subject.addObserver(o2);

        subject.notifyObservers("Event occurred!");
    }
}
