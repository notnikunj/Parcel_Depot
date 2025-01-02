package parcel_management;

public class Manager {
    public static void main(String[] args) {
        // Initialize core components
        QueofCustomers queue = new QueofCustomers();
        ParcelMap parcelMap = new ParcelMap();
        Log applog = Log.getInstance();

        // Load initial data (if any)
        loadCustomerData(queue);
        loadParcelData(parcelMap);

        // Initialize the controller with core components
        ParcelController controller = new ParcelController(queue, parcelMap, applog);

        // Launch the GUI
        new GUI(controller);

        System.out.println("Parcel Depot Management System started!");
    }

    private static void loadCustomerData(QueofCustomers queue) {
        System.out.println("Loading customer data...");
    }

    private static void loadParcelData(ParcelMap parcelMap) {
        System.out.println("Loading parcel data...");
    }
}