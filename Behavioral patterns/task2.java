
interface Command {
    void execute();
}


class TaxiOrder {
    private String destination;

    public void createOrder(String destination) {
        this.destination = destination;
        System.out.println("Order created to " + destination);
    }

    public void cancelOrder() {
        System.out.println("Order canceled.");
    }

    public void changeDestination(String newDestination) {
        this.destination = newDestination;
        System.out.println("Order destination changed to " + newDestination);
    }
}

class CreateOrderCommand implements Command {
    private TaxiOrder taxiOrder;
    private String destination;

    public CreateOrderCommand(TaxiOrder taxiOrder, String destination) {
        this.taxiOrder = taxiOrder;
        this.destination = destination;
    }

    @Override
    public void execute() {
        taxiOrder.createOrder(destination);
    }
}


class CancelOrderCommand implements Command {
    private TaxiOrder taxiOrder;

    public CancelOrderCommand(TaxiOrder taxiOrder) {
        this.taxiOrder = taxiOrder;
    }

    @Override
    public void execute() {
        taxiOrder.cancelOrder();
    }
}

class ChangeDestinationCommand implements Command {
    private TaxiOrder taxiOrder;
    private String newDestination;

    public ChangeDestinationCommand(TaxiOrder taxiOrder, String newDestination) {
        this.taxiOrder = taxiOrder;
        this.newDestination = newDestination;
    }

    @Override
    public void execute() {
        taxiOrder.changeDestination(newDestination);
    }
}

class CommandInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

public class TaxiCommandSystem {
    public static void main(String[] args) {
        TaxiOrder order = new TaxiOrder();

        Command createOrder = new CreateOrderCommand(order, "Downtown");
        Command cancelOrder = new CancelOrderCommand(order);
        Command changeDestination = new ChangeDestinationCommand(order, "Airport");

        CommandInvoker invoker = new CommandInvoker();

        invoker.setCommand(createOrder);
        invoker.executeCommand();

        invoker.setCommand(changeDestination);
        invoker.executeCommand();

        invoker.setCommand(cancelOrder);
        invoker.executeCommand();
    }
}
