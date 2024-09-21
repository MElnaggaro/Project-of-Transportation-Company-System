import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

enum EmployeeType {
    DRIVER,
    MANAGER
}

public class Employee implements Serializable {
    private static int idAdder = 2319;
    private String name;
    private String password;
    private static int id;
    private EmployeeType type;


    public void viewAssignedTrip(EmployeeType employeeType,ArrayList<Trip> Asstrips) {
        if (EmployeeType.DRIVER.equals(employeeType)) {
            Main.loadFromFileAssign();
            System.out.println("Assign Trips: " + Asstrips);
        } else {
            System.out.println("Only drivers can view assigned trips.");
        }
    }

    public void addTrip(EmployeeType type, ArrayList<Trip> trips) {
        Scanner input = new Scanner(System.in);

        if (type == EmployeeType.MANAGER) {
            System.out.print(" Trip Ticket Type (1-EXTERNAL, 2-INTERNAL): ");
            int tripType = input.nextInt();
            System.out.print("Enter Trip source: ");
            String source = input.next();
            System.out.print("Enter Trip destination: ");
            String destination = input.next();
            System.out.print("Is it a one-way trip? (true/false): ");
            boolean oneWay = input.nextBoolean();
            System.out.print("Enter number of stops: ");
            int numStops = input.nextInt();
            System.out.print("Enter trip price: ");
            double price = input.nextDouble();
            Trip nEwtrip = new Trip(tripType, source, destination, oneWay, numStops, price);
            trips.add(nEwtrip);
            Main.saveToFileTrip(trips);
            System.out.println("Trip added successfully.");

        } else {
            System.out.println("Only managers can add trips.");
        }
    }

    public void removeTrip(EmployeeType type, ArrayList<Trip> trips, int tripNum) {
        Main.loadFromFileTrips();
        if (type == EmployeeType.MANAGER) {
            trips.remove(tripNum);
            Main.saveToFileTrip(trips);
            System.out.println("Trip canceled successfully.");
        } else {
            System.out.println("Only managers can cancel trips.");
        }

    }

    public void assignTrip(EmployeeType employeeType, ArrayList<Trip> trips, int numOftrips, ArrayList<Trip> Asstrips) {
        Main.loadFromFileDriver();
        Main.loadFromFileTrips();
        Main.loadFromFileAssign();
        Scanner input = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("The Drivers: "+Main.drivers);
        System.out.print("Enter Driver Name: ");
        String dName = input.next();
        for (Employee div : Main.drivers) {
            if (div.getName().equals(dName)) {
                if (employeeType == EmployeeType.MANAGER) {
                    trips.get(numOftrips).assignDriver(dName);
                    Trip selectedTrip = trips.get(numOftrips);
                    Asstrips.add(selectedTrip);
                    Main.saveToFileAssign(Asstrips);
                    System.out.println("Trip assigned successfully.");
                    System.out.println("===================================");
                }
            } else {
                System.out.println("Driver does not exist.");
            }
        }
    }

    public Employee(String name, String password) {
        this.name = name;
        this.password = password;
        idAdder++;
        id = idAdder;
    }

    @Override
    public String toString() {
        return "name= " + name +
                ", id= " + id;
    }

    public String getName() {
        return name;
    }

    public void basicinfo() {
        System.out.println("===================================");
        System.out.println("Name Of The Driver is: " + name);
        System.out.println("ID: " + id);
    }

    public String getPassword() {
        return password;
    }

    public static boolean loginEmployee(String username, String password) {
        for (Employee employee : Main.employees) {
            if (employee.getName().equals(username) && employee.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    public static boolean loginDriver(String username, String password) {
        for (Employee d : Main.drivers) {
            if (d.getName().equals(username) && d.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    public static void registerEmployee(String username, String password, int numEployeeType) {
        switch (numEployeeType) {
            case 1:
                Employee driver = new Employee(username, password);
                Main.drivers.add(driver);
                Main.saveToFileDriver(Main.drivers);
                System.out.println("Driver is Registered successfully.");
                break;
            case 2:
                Employee manager = new Employee(username, password);
                Main.employees.add(manager);
                Main.saveToFileEmployee(Main.employees);
                System.out.println("Manager is Registered successfully.");
                break;
        }
        System.out.println("===================================");
    }
}