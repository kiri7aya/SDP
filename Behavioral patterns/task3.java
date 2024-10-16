import java.util.List;

class Driver {
    private String name;
    private double distance;

    public Driver(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }
}

interface DriverIterator {
    boolean hasNext();
    Driver next();
}

class AvailableDriverIterator implements DriverIterator {
    private List<Driver> drivers;
    private int position = 0;

    public AvailableDriverIterator(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public boolean hasNext() {
        return position < drivers.size();
    }

    @Override
    public Driver next() {
        return drivers.get(position++);
    }
}

public class DriverIteratorSystem {
    public static void main(String[] args) {
        List<Driver> drivers = List.of(
            new Driver("John", 5.0),
            new Driver("Alice", 3.2),
            new Driver("Bob", 7.8)
        );

        DriverIterator iterator = new AvailableDriverIterator(drivers);

        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("Driver " + driver.getName() + " is " + driver.getDistance() + " km away.");
        }
    }
}
