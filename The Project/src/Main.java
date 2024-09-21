import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Passenger> passengers = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Trip> trips = new ArrayList<>();
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Trip> assignTrips = new ArrayList<>();
    static ArrayList<Employee> drivers = new ArrayList<>();
    static File file = new File("C:\\Users\\nonok\\IdeaProjects\\Our Project\\src\\passenger.txt");
    static File file1 = new File("C:\\Users\\nonok\\IdeaProjects\\Our Project\\src\\employee.txt");
    static File file2 = new File("C:\\Users\\nonok\\IdeaProjects\\Our Project\\src\\trip.txt");
    static File file3 = new File("C:\\Users\\nonok\\IdeaProjects\\Our Project\\src\\vehicle.txt");
    static File file4 = new File("C:\\Users\\nonok\\IdeaProjects\\Our Project\\src\\assigtrips.txt");
    static File file5 = new File("C:\\Users\\nonok\\IdeaProjects\\Our Project\\src\\drivers.txt");

    static Scanner input = new Scanner(System.in);

    public static void saveToFileDriver(ArrayList<Employee> drivers) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file5));
            oos.writeObject(drivers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> loadFromFileDriver() {
        ArrayList<Employee> drivers = new ArrayList<>();
        try {
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file5));
                drivers = (ArrayList<Employee>) ois.readObject();
            } else {
                System.out.println("Driver file does not exist. Creating a new one.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return drivers;
    }


    public static void saveToFileAssign(ArrayList<Trip> trips) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file4));
            oos.writeObject(trips);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Trip> loadFromFileAssign() {
        ArrayList<Trip> assignTrips = new ArrayList<>();
        try {
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file4));
                assignTrips = (ArrayList<Trip>) ois.readObject();
            } else {
                System.out.println("Assign Trips file does not exist. Creating a new one.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return assignTrips;
    }


    public static void saveToFilePassenger(ArrayList<Passenger> passengers) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(passengers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Passenger> loadFromFilePassenger() {
        ArrayList<Passenger> passengers = new ArrayList<>();
        try {
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                passengers = (ArrayList<Passenger>) ois.readObject();
            } else {
                System.out.println("Passenger file does not exist. Creating a new one.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return passengers;
    }

    public static void saveToFileEmployee(ArrayList<Employee> employees) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file1));
            oos.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> loadFromFileEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file1));
                employees = (ArrayList<Employee>) ois.readObject();
            } else {
                System.out.println("Employee file does not exist. Creating a new one.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void saveToFileTrip(ArrayList<Trip> trips) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2));
            oos.writeObject(trips);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Trip> loadFromFileTrips() {
        ArrayList<Trip> trips = new ArrayList<>();
        try {
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file2));
                trips = (ArrayList<Trip>) ois.readObject();
                ois.close();
            } else {
                System.out.println("Trips file does not exist. Creating a new one.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return trips;
    }


    public static void saveToFileVehicle(ArrayList<Vehicle> vehicles) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file3));
            oos.writeObject(vehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Vehicle> loadFromFileVehicle() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {

            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file3));
                vehicles = (ArrayList<Vehicle>) ois.readObject();
            } else {
                System.out.println("Vehicle file does not exist. Creating a new one.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public static void main(String[] args) {
        passengers = loadFromFilePassenger();
        employees = loadFromFileEmployee();
        trips = loadFromFileTrips();
        vehicles = loadFromFileVehicle();
        assignTrips = loadFromFileAssign();
        drivers = loadFromFileDriver();


        System.out.println("===================================");
        System.out.println("1-Login");
        System.out.println("2-Register");
        System.out.println("3-Exit");
        System.out.println("===================================");
        System.out.print("Choose your option: ");
        int choice = input.nextInt();
        switch (choice) {
            /////////////////////////Login///////////////////////////////////
            case 1:
                System.out.print("Enter Username: ");
                String username = input.next();
                System.out.print("Enter Password: ");
                String password = input.next();
                System.out.println("===================================");
                System.out.print("Are you a passenger or an employee? (1-Passenger/2-Employee): ");
                int dat = input.nextInt();
                switch (dat) {
                    case 1:

                        if (Passenger.loginPassenger(username, password)) {
                            Passenger pas = new Passenger(username, password);
                            System.out.println("Login Successful.");
                            passengerMenu(pas);
                            System.out.println("===================================");
                        } else {
                            System.out.println("The passenger is not present in the data!!");
                            break;
                        }
                        break;
                    case 2:
                        ///////////Login Employee////////////////////////////////////////
                        if (Employee.loginEmployee(username, password)) {
                            Employee manager = new Employee(username, password);
                            System.out.println("Login Successful for the Manager.");
                            System.out.println("===================================");
                            managerMenu(manager, trips);
                            System.out.println("===================================");
                        } else if (Employee.loginDriver(username, password)) {
                            System.out.println("Login Successful for the Driver.");
                            Employee driver = new Employee(username, password);
                            driverMenu(driver);
                            System.out.println("===================================");
                        }
                        break;
                    default:
                        System.out.println("It's Not Ok");
                }
                break;

            //The Register/////////////////////////////////////////////////////

            case 2:
                System.out.print("Enter Username: ");
                String user = input.next();
                System.out.print("Enter Password: ");
                String pass = input.next();
                System.out.print("Confirm Password: ");
                String confPass = input.next();
                if (pass.equals(confPass)) {

                } else {
                    System.out.println("Your password is incorrect.");
                    break;
                }
                System.out.print("Are you a passenger or an employee? (passenger/employee): ");
                String userType = input.next();

                if (userType.equalsIgnoreCase("passenger")) {
                    Passenger passenger = new Passenger(user, pass);
                    Passenger.addPassenger(passenger);
                    saveToFilePassenger(passengers);
                    System.out.println("Passenger Registered successfully.");
                    Passenger.registerPassenger(user, pass);


                    ///////Register Employee//////////////////////////////////////////////////////////////

                } else if (userType.equalsIgnoreCase("employee")) {
                    System.out.println("===================================");
                    System.out.println("Select your role:");
                    System.out.println("1. Driver");
                    System.out.println("2. Manager");
                    System.out.print("Choose an option: ");
                    int numEployeeType = input.nextInt();
                    Employee.registerEmployee(user, pass, numEployeeType);
                } else {
                    System.out.println("Invalid user type.");
                }
                break;
            //The Exit/////////////////////////////////////////////////////
            case 3:
                System.out.println("The Program is Exit. ");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static void passengerMenu(Passenger passenger) {
        boolean flag = true;
        while (flag) {
            System.out.println("Passenger actions:");
            System.out.println("        1. Display Profile");
            System.out.println("        2. Select Trip");
            System.out.println("        3. Booked Ticket");
            System.out.println("        4. Review Tickets");
            System.out.println("        5. Cancel Ticket");
            System.out.println("        6. Exit");
            System.out.println("===================================");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    passenger.displayProfile();
                    break;
                case 2:
                    Main.loadFromFileAssign();
                    Main.loadFromFileTrips();
                    System.out.println(Main.trips);
                    System.out.print("Please enter the number of the trip: ");
                    int choice2 = input.nextInt();
                    passenger.selectTrip(choice2);
                    System.out.println("Trip selected successfully.");
                    break;
                case 3:
                    passenger.bookedticket(assignTrips);
                    break;
                case 4:
                    passenger.reviewticket(assignTrips);
                    break;
                case 5:
                    Main.loadFromFileAssign();
                    Main.loadFromFileTrips();
                    System.out.println(Main.assignTrips);
                    System.out.print("Please enter the number of the trip you want to cancel: ");
                    int choice3 = input.nextInt();
                    passenger.cancelticket(choice3);
                case 6:
                    System.out.println("The Program is Exit. ");
                    flag = false;
                    break;
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Done
    private static void managerMenu(Employee employee, ArrayList<Trip> tripslist) {
        boolean flag = true;
        while (flag) {
            System.out.println("===================================");
            System.out.println("Manager actions:");
            System.out.println("        1. Add Trip");
            System.out.println("        2. Remove Trip");
            System.out.println("        3. Assigned Trip to drivers");
            System.out.println("        4. Add Vehicle");
            System.out.println("        5. Remove Vehicle");
            System.out.println("        6. Exit");
            System.out.println("===================================");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    employee.addTrip(EmployeeType.MANAGER, tripslist);
                    break;
                case 2:
                    System.out.println(tripslist);
                    System.out.println("===================================");
                    System.out.println("Choose the Trip which you want to Cancel: ");
                    int choice2 = input.nextInt();
                    employee.removeTrip(EmployeeType.MANAGER, tripslist, choice2);
                    break;
                case 3:
                    System.out.println("What the trip you want: " + trips);
                    System.out.print("Choose the Trip which you want to Assingn: ");
                    int choice3 = input.nextInt();
                    employee.assignTrip(EmployeeType.MANAGER, tripslist, choice3, assignTrips);
                    break;
                case 4:
                    Vehicle.addVehicle(new Vehicle(VehicleType.BUS, 1, "ABC 517"));
                    System.out.println("Vehicle added successfully.");
                    break;
                case 5:
                    Vehicle.removeVehicle(new Vehicle(VehicleType.BUS, 1, "ABC 517"));
                    System.out.println("Vehicle removed successfully.");
                    break;
                case 6:
                    flag = false;
            }
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void driverMenu(Employee employee) {
        boolean flag = true;
        while (flag) {
            System.out.println("===================================");
            System.out.println("Driver actions:");
            System.out.println("        1-Display driver Info");
            System.out.println("        2-View assigned Trips");
            System.out.println("        3-Exit");
            System.out.println("===================================");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    employee.basicinfo();
                    break;
                case 2:
                    employee.viewAssignedTrip(EmployeeType.DRIVER, assignTrips);
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
    }
}