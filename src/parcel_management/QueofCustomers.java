package parcel_management;
import java.util.LinkedList;
import java.util.Queue;

public class QueofCustomers {
    private Queue<Customer> customers;

    public QueofCustomers() {
        customers = new LinkedList<>();
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public Queue<Customer> getCustomers() {
        return customers;
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
