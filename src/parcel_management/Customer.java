package parcel_management;

public class Customer {
    private int id;
    private String name;
    private String parcel_id;

    public Customer(int id, String name,  String parcel_id) {
        this.id = id;
        this.name = name;
        this.parcel_id = parcel_id;
    }

    //getter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getParcel_id() {
        return parcel_id;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }
    public void setParcel_id(String parcel_id) {
        this.parcel_id = parcel_id;
    }

}
