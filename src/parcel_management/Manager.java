package parcel_management;

public class Manager {
    public static void main(String[] args) {
        // Test Customer
        Customer customer = new Customer(1, "Nikunj");
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());

        // Test Parcel
        Parcel parcel = new Parcel(1001, 22,30,1.3,30,"Vase");
        System.out.println("Parcel ID: " + parcel.getId());
        System.out.println("Parcel Description: " + parcel.getDescription());
        System.out.println("before collection isCollected: " + parcel.isCollected());
        parcel.setCollected();
        System.out.println("after collection: " + parcel.isCollected());
        System.out.println("Days uncollected: " + parcel.getDays_uncollected());
        parcel.setDays_uncollected(25);
        System.out.println("Days uncollected after 25 days: " + parcel.getDays_uncollected());
        parcel.Dimensions();
    }
}
