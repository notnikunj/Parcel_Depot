package parcel_management;

public class Parcel {
    private String id;
    private double height;
    private double width;
    private double length;
    private double weight;
    private String description;
    private int days_uncollected;
    private boolean collected;

    public Parcel(String id, double height, double width, double length, double weight, String description) {
        this.id = id;
        this.height = height;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.description = description;
        this.days_uncollected = 0;
        this.collected = false;

    }

    //getters
    public String getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public double getWeight() {
        return weight;
    }
    public double getHeight() {
        return height;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
    public int getDays_uncollected() {
        return days_uncollected;
    }
    public void Dimensions(){
        System.out.println("Height: " + height + " Width: " + width + " Length: " + length);
    }
    public boolean isCollected() {
        return collected;
    }

    //setters
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCollected() {
        collected = true;
    }
    public void setDays_uncollected(int days_uncollected) {
        this.days_uncollected = days_uncollected;
    }

    public String toString() {
        return "ID=" + id +
                ", Weight=" + weight +
                ", Length=" + length +
                ", Width=" + width +
                ", Height=" + height +
                ", Description='" + description + "'";
    }
}
