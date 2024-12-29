package parcel_management;


public class Manager {
    private QueofCustomers queue;
    private ParcelMap parcelMap;
    private Worker worker;
    private Log log;

    public Manager(){
        queue = new QueofCustomers();
        parcelMap = new ParcelMap();
        worker = new Worker();
        log = Log.getInstance();
    }

    public void addCustomerToQueue(Customer customer){
        queue.addCustomer(customer);
        log.addEvent("Customer "+ customer.getId() + " added to queue" );
    }

    public void addParcelToMap(Parcel parcel){
        parcelMap.addParcel(parcel);
        log.addEvent("Parcel "+ parcel.getId() + " added to Parcel Map" );
    }

    public void startProcessing(){
        while (!queue.isEmpty()){
            worker.processCustomer(queue, parcelMap, log);
        }
        log.addEvent("Processing finished" );
    }


    public static void main(String[] args) {
        Manager manager = new Manager();
        Customer customer1 = new Customer(1,"Nikunj","1001");
        Customer customer2 = new Customer(2,"Karan","1002");
        Customer customer3 = new Customer(3,"Tanay","1003");

        Parcel parcel1 = new Parcel("1001", 20,30,10,5,"Charcoal");
        Parcel parcel2 = new Parcel("1002", 70,3,1,6,"box");

        manager.addCustomerToQueue(customer1);
        manager.addCustomerToQueue(customer2);
        manager.addCustomerToQueue(customer3);
        manager.addParcelToMap(parcel1);
        manager.addParcelToMap(parcel2);

        System.out.println("[" + manager.parcelMap.getAllParcelsString() + "]");
        System.out.println(manager.queue.getCustomers());

        manager.startProcessing();

        manager.log.saveToFile("log.txt");

        System.out.println("[" + manager.parcelMap.getAllParcelsString()+ "]");
        System.out.println(manager.queue.getCustomers());
    }
}
