package core;

public class DependencyInjection {

    public static void main(String[] args) {
        Service service = new Service();   // Create dependency
        Client client = new Client(service); // Inject dependency
        client.doWork();
    }

}

class Service {
    public void execute() {
        System.out.println("Executing service...");
    }
}

class Client {
    private Service service;

    // Dependency injected via constructor
    public Client(Service service) {
        this.service = service;
    }

    public void doWork() {
        service.execute();
    }
}
