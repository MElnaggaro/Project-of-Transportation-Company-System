import java.io.Serializable;

enum TripType {
    INTERNAL,
    EXTERNAL
}

public class Trip extends Vehicle implements Serializable {
    private TripType type;
    private String source;
    private String destination;
    private boolean oneWay = true;
    private int numStops;
    private int availableSeats;
    private double price;

    public Trip(int tripTypeChoice, String source, String destination, boolean oneWay, int numStops, double price) {
        switch (tripTypeChoice) {
            case 1:
                this.type = TripType.EXTERNAL;
                break;
            case 2:
                this.type = TripType.INTERNAL;
                break;
        }
        this.source = source;
        this.destination = destination;
        this.oneWay = oneWay;
        this.numStops = numStops;
        this.price = price;
    }
    public void assignDriver(String driverName) {
        System.out.println("Driver assigned for trip to " + destination + ": " + driverName);
    }
    @Override
    public String toString() {
        return "Trip Selectet: \n" +
                " Type= " + type + ", " +
                " Source= " + source + ", " +
                " Destination= '" + destination + ", " +
                " OneWay= " + oneWay + ", " +
                " NumStops= " + numStops + ", " +
                " Price= " + price;
    }

    public static void main(String[] args) {
        Main.assignTrips=Main.loadFromFileAssign();
        System.out.println(Main.assignTrips.size());
    }
}
