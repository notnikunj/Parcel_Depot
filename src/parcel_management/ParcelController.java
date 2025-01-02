package parcel_management;

public class ParcelController {
    private QueofCustomers queue;
    private ParcelMap parcelMap;
    private Log applog;
    private double totalFeesCollected;

    public ParcelController(QueofCustomers queue, ParcelMap parcelMap, Log applog) {
        this.queue = queue;
        this.parcelMap = parcelMap;
        this.applog = applog;
        this.totalFeesCollected = 0.0;
    }

    public void addCustomer(int id, String name, String parcelId) {
        Customer customer = new Customer(id, name, parcelId);
        queue.addCustomer(customer);
        applog.addEvent("Customer added: ID=" + id + ", Name=" + name + ", Parcel ID=" + parcelId);
        applog.saveToFile("log.txt");
    }

    public void addParcel(String id, double weight, double length, double width, double height, String description) {
        Parcel parcel = new Parcel(id, weight, length, width, height, description);
        parcelMap.addParcel(parcel);
        applog.addEvent("Parcel added: ID=" + id);
        applog.saveToFile("log.txt");
    }

    public String processNextCustomer() {
        if (queue.isEmpty()) {
            return "No customers in the queue!";
        }

        Customer customer = queue.dequeue();
        Parcel parcel = parcelMap.getParcel(customer.getParcel_id());
        StringBuilder result = new StringBuilder("Processing Customer ID: " + customer.getId());

        if (parcel != null) {
            double fee = parcel.getWeight() * parcel.getLength() * parcel.getWidth() * parcel.getHeight() * 0.1;
            totalFeesCollected += fee;
            parcelMap.removeParcel(parcel.getId());
            applog.addEvent("Processed parcel for Customer ID=" + customer.getId() + " with fee=" + fee);
            result.append("\nParcel ID: ").append(parcel.getId())
                    .append("\nFee: $").append(fee);
        } else {
            queue.addCustomer(customer);
            applog.addEvent("No parcel found for Customer ID=" + customer.getId());
            result.append("\nNo parcel found for Customer.");
        }

        applog.saveToFile("log.txt");
        return result.toString();
    }

    public double getTotalFeesCollected() {
        return totalFeesCollected;
    }

    public String getCustomerQueue() {
        StringBuilder customerText = new StringBuilder("Customer Queue:\n");
        for (Customer customer : queue.getCustomers()) {
            customerText.append("ID: ").append(customer.getId())
                    .append(", Name: ").append(customer.getName())
                    .append(", Parcel ID: ").append(customer.getParcel_id())
                    .append("\n");
        }
        return customerText.toString();
    }

    public String getParcelList() {
        StringBuilder parcelText = new StringBuilder("Uncollected Parcels:\n");
        for (Parcel parcel : parcelMap.getAllParcels()) {
            parcelText.append(parcel).append("\n");
        }
        return parcelText.toString();
    }

    public String getLog() {
        return applog.toString();
    }
}