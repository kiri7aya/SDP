
abstract class Handler {
    protected Handler nextHandler;

    public Handler setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract void handle(Request request);
}

class Request {
    public boolean carsAvailable;
    public boolean sufficientBalance;
    public boolean locationAccessible;

    public Request(boolean carsAvailable, boolean sufficientBalance, boolean locationAccessible) {
        this.carsAvailable = carsAvailable;
        this.sufficientBalance = sufficientBalance;
        this.locationAccessible = locationAccessible;
    }
}

class CarAvailabilityHandler extends Handler {
    @Override
    public void handle(Request request) {
        if (request.carsAvailable) {
            System.out.println("Cars are available.");
            if (nextHandler != null) {
                nextHandler.handle(request);
            }
        } else {
            System.out.println("No cars available.");
        }
    }
}

class BalanceHandler extends Handler {
    @Override
    public void handle(Request request) {
        if (request.sufficientBalance) {
            System.out.println("Client has sufficient balance.");
            if (nextHandler != null) {
                nextHandler.handle(request);
            }
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class LocationHandler extends Handler {
    @Override
    public void handle(Request request) {
        if (request.locationAccessible) {
            System.out.println("Location is accessible.");
            if (nextHandler != null) {
                nextHandler.handle(request);
            }
        } else {
            System.out.println("Location is not accessible.");
        }
    }
}

public class TaxiDispatchSystem {
    public static void main(String[] args) {
        Handler carAvailabilityHandler = new CarAvailabilityHandler();
        Handler balanceHandler = new BalanceHandler();
        Handler locationHandler = new LocationHandler();

        carAvailabilityHandler.setNext(balanceHandler).setNext(locationHandler);

        Request request = new Request(true, true, true);
        
        carAvailabilityHandler.handle(request);
    }
}
