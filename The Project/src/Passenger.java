import java.io.Serializable;
import java.util.ArrayList;

enum TicketType {
    ONE_WAY,
    ROUND_TRIP
}

public class Passenger implements Serializable {
    private static int idAdder = 2310;
    private String name;
    private String password;
    private static int id;

    public String getPassword() {
        return password;
    }
    public Passenger(String name, String password) {
        this.name = name;
        this.password = password;
        idAdder++;
        id = idAdder;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name= " + name +
        ", id= " + id;
    }

    public static void addPassenger(Passenger passenger) {
        Main.passengers.add(passenger);
    }

    public void selectTrip(int choice) {
        Trip selec = Main.trips.get(choice);
        Main.assignTrips.add(selec);
        Main.saveToFileAssign(Main.assignTrips);
    }

    public void bookedticket(ArrayList<Trip> Asstrips) {
        Main.loadFromFileAssign();
        if (Asstrips.size() != 0) {
            System.out.println("You have " + Asstrips.size() + " trips");
        } else {
            System.out.println("please select a trip first");
        }
    }


    public void reviewticket(ArrayList<Trip> Asstrips) {
        Main.loadFromFileAssign();
        if (Asstrips != null) {
            System.out.println("Your Trips :" + Asstrips);
        } else {
            System.out.println("no ticket booked ");
        }

    }

    public void cancelticket(int choice) {
        Main.loadFromFileTrips();
        Main.loadFromFileAssign();
        Trip selec = Main.trips.get(choice);
        Main.assignTrips.remove(selec);
        Main.saveToFileAssign(Main.assignTrips);
        System.out.println("ticket canceled already ");
    }

    public void displayProfile() {
        Main.assignTrips = Main.loadFromFileAssign();
        System.out.println("Passenger Profile:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Your Assgin Trips: \n" + Main.assignTrips);
    }

    public static boolean loginPassenger(String username, String password) {
        for (Passenger p : Main.passengers) {
            if (p.getName().equals(username) && p.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void registerPassenger(String username, String password) {
        Main.passengers.add(new Passenger(username, password));
    }

}