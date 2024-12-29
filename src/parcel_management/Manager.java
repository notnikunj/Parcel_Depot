package parcel_management;

public class Manager {
    public static void main(String[] args) {
        QueofCustomers queue = new QueofCustomers();
        queue.addCustomer(new Customer(1, "Nikunj"));
        queue.addCustomer(new Customer(2, "Tanay"));
        queue.addCustomer(new Customer(25,"Meet"));

        System.out.println("Customers in Queue:");
        for (Customer c : queue.getCustomers()) {
            System.out.println("Customer ID: " + c.getId() + ", Name: " + c.getName());
        }

        // Create Parcel Map
        ParcelMap parcelMap = new ParcelMap();
        parcelMap.addParcel(new Parcel("1000", 10,15,30,22,"Electronics"));
        parcelMap.addParcel(new Parcel("1001", 9,7,12,0.5,"Clothes"));

        System.out.println("\nParcels in Map:");
        for (Parcel parcel : parcelMap.getAllParcels().values()) {
            System.out.println("Parcel ID: " + parcel.getId() + ", Description: " + parcel.getDescription());
        }
    }
}
