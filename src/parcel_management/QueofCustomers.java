package parcel_management;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueofCustomers {
    private Queue<Customer> customers;

    public QueofCustomers() {
        customers = new LinkedList<>();
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public List<Customer> getCustomers() {
        return new LinkedList<>(customers); // Convert to List for easy manipulation
    }
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
    public boolean isEmpty() {
        return customers.isEmpty();
    }
    public Customer dequeue(){
        return customers.poll();
    }
}
