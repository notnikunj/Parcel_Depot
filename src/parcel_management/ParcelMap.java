package parcel_management;
import java.util.HashMap;


public class ParcelMap {
    private HashMap<String, Parcel> parcels;

    public ParcelMap() {
        this.parcels = new HashMap<>();
    }
    public void addParcel(Parcel parcel) {
        parcels.put(parcel.getId(), parcel);
    }
    public Parcel getParcel(String id) {
        return parcels.get(id);
    }
    public HashMap<String, Parcel> getAllParcels() {
        return parcels;
    }
    public void removeParcel(String id) {
        parcels.remove(id);
    }


    public String getAllParcelsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Parcel parcel : parcels.values()) {
            stringBuilder.append(parcel.getId());
        }
        return stringBuilder.toString();
    }

}
