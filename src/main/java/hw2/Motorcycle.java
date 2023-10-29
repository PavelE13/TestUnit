package hw2;

public class Motorcycle extends Vehicle {
    private String company;
    private String model;
    private int yearRelease;
    private int numWheels;
    private int speed;

    public Motorcycle(String company, String model, int yearRelease) {
        this.company = company;
        this.model = model;
        this.yearRelease = yearRelease;
        if (yearRelease < 0) {
            throw new IllegalArgumentException("Year of manufacture must be a positive");
        }
        this.numWheels = 2;
        this.speed = 0;
    }
    public void testDrive() { this.speed = 75; }
    public void park() { this.speed = 0; }
    public String getCompany() { return company; }
    public String getModel() { return model; }
    public int getYearRelease() { return yearRelease; }
    public int getNumWheels() { return numWheels; }
    public int getSpeed() {
        return speed;
    }
}
