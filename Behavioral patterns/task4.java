import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void sendMessage(String message, Participant participant);
}

abstract class Participant {
    protected Mediator mediator;
    protected String name;

    public Participant(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void receive(String message);
}

class Client extends Participant {
    public Client(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void receive(String message) {
        System.out.println("Client " + name + " received: " + message);
    }

    public void send(String message) {
        System.out.println("Client " + name + " sends: " + message);
        mediator.sendMessage(message, this);
    }
}

class Driver extends Participant {
    public Driver(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void receive(String message) {
        System.out.println("Driver " + name + " received: " + message);
    }

    public void send(String message) {
        System.out.println("Driver " + name + " sends: " + message);
        mediator.sendMessage(message, this);
    }
}

class Dispatcher extends Participant {
    public Dispatcher(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void receive(String message) {
        System.out.println("Dispatcher " + name + " received: " + message);
    }

    public void send(String message) {
        System.out.println("Dispatcher " + name + " sends: " + message);
        mediator.sendMessage(message, this);
    }
}

class DispatcherMediator implements Mediator {
    private List<Participant> participants;

    public DispatcherMediator() {
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    @Override
    public void sendMessage(String message, Participant sender) {
        for (Participant participant : participants) {
            if (participant != sender) {
                participant.receive(message);
            }
        }
    }
}

public class TaxiMediatorSystem {
    public static void main(String[] args) {
        DispatcherMediator mediator = new DispatcherMediator();

        Client client = new Client(mediator, "John");
        Driver driver = new Driver(mediator, "Alice");
        Dispatcher dispatcher = new Dispatcher(mediator, "Central");

        mediator.addParticipant(client);
        mediator.addParticipant(driver);
        mediator.addParticipant(dispatcher);

        client.send("I need a taxi.");
        dispatcher.send("Dispatching a taxi.");
        driver.send("On my way.");
    }
}
