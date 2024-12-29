package parcel_management;
import java.util.*;

public class Worker {

    public void processCustomer(QueofCustomers queue, ParcelMap parcelMap, Log log){
        if(queue == null){
            System.out.println("No Customers in the queue");
            return;
        }

        Customer customer = queue.dequeue();
        log.addEvent("Next Customer: Customer " + customer.getId() );
        System.out.println("Customer parcel id: " + customer.getParcel_id());
        log.addEvent("Customer parcel id: " + customer.getParcel_id());

        Optional<Parcel> parcelOptional = Optional.ofNullable(parcelMap.getParcel(customer.getParcel_id()));

        if (parcelOptional.isPresent()){
            Parcel parcel = parcelOptional.get();
            double fee = calculateFee(parcel);

            System.out.println("Processing parcel " + parcel.getId() + " for customer " + customer.getId());
            log.addEvent("Processing parcel " + parcel.getId() + " for customer " + customer.getId() + " with a fee of " + fee);

            parcel.setCollected();
            log.addEvent("Parcel " + parcel.getId() + " was collected by the customer.");
            parcelMap.removeParcel(parcel.getId());
        }
        else {
            System.out.println("No Parcel found for customer " + customer.getId());
            log.addEvent("No Parcel found for customer " + customer.getId());
        }

    }
    private double calculateFee(Parcel parcel){
        return parcel.getWeight() * parcel.getHeight() * parcel.getLength() * parcel.getWidth()  * 0.1;
    }
}
