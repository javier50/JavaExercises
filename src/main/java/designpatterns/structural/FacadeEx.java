package designpatterns.structural;
/* Design pattern - FactoryMethod
 * Usage:
 * - The Facade Pattern is especially useful in your consulting work when
 *   you want to hide complexity from SMEs. For example,
 *   you could expose a simple startPOS() method that internally configures
 *   payment gateways, cloud storage, and logging without overwhelming the
 *   client with technical details.
 *
 * Key points:
 * - The Facade Pattern is a structural design pattern that provides a simplified
 *   interface to a complex subsystem.
 *   Instead of exposing many classes and methods, you create a
 *   Facade class that offers a clean, unified API.
 * */

// Subsystem 1
class DVDPlayer {
    public void on() { System.out.println("DVD Player ON"); }
    public void play(String movie) { System.out.println("Playing movie: " + movie); }
    public void off() { System.out.println("DVD Player OFF"); }
}

// Subsystem 2
class Projector {
    public void on() { System.out.println("Projector ON"); }
    public void wideScreenMode() { System.out.println("Projector in widescreen mode"); }
    public void off() { System.out.println("Projector OFF"); }
}

// Subsystem 3
class SoundSystem {
    public void on() { System.out.println("Sound System ON"); }
    public void setVolume(int level) { System.out.println("Volume set to " + level); }
    public void off() { System.out.println("Sound System OFF"); }
}

// Facade
class HomeTheaterFacade {
    private DVDPlayer dvd;
    private Projector projector;
    private SoundSystem sound;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SoundSystem sound) {
        this.dvd = dvd;
        this.projector = projector;
        this.sound = sound;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.wideScreenMode();
        sound.on();
        sound.setVolume(10);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvd.off();
        sound.off();
        projector.off();
    }
}

// Client
public class FacadeEx {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, sound);

        homeTheater.watchMovie("The Matrix");
        homeTheater.endMovie();
    }
}