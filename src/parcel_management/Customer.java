package parcel_management;

public class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //getter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

}
