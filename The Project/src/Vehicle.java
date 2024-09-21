import java.io.Serializable;

enum VehicleType {
    BUS,
    MINIBUS,
    LIMOUSINE
}


public class Vehicle implements Serializable {
    private VehicleType type;
    private int capacity;
    private String licensePlate;

    public Vehicle(VehicleType type, int capacity, String licensePlate) {
        this.type = type;
        switch (capacity) {
            case 1:
                setCapacity(VehicleType.BUS);
                break;
            case 2:
                setCapacity(VehicleType.MINIBUS);
                break;
            case 3:
                setCapacity(VehicleType.LIMOUSINE);
                break;
        }
        this.licensePlate = licensePlate;
    }

    public Vehicle() {
    }

    public static void addVehicle(Vehicle vehicle) {
        Main.vehicles.add(vehicle);
        Main.saveToFileVehicle(Main.vehicles);
    }

    public static void removeVehicle(Vehicle vehicle) {
        Main.loadFromFileVehicle();
        Main.vehicles.remove(vehicle);
        Main.saveToFileVehicle(Main.vehicles);
    }

    public void setCapacity(VehicleType type) {
        if (VehicleType.BUS.equals(type)) {
            this.capacity = 25;
        } else if (VehicleType.MINIBUS.equals(type)) {
            this.capacity = 7;
        } else if (VehicleType.LIMOUSINE.equals(type)) {
            this.capacity = 5;
        }
    }

    public void displayInfo() {
        System.out.println("Vehicle Type: " + type);
        System.out.println("Capacity: " + capacity);
        System.out.println("License Plate: " + licensePlate);
    }
}
