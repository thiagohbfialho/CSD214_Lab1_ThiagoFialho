package lab1.q4;

import lab1.q3.Person;

import java.util.Objects;

public class Car {

    /**
     * @author thiagofialho
     * Date: 09-28-23
     * Description: This is a class for Person
     **/

    //Attributes of a car
    //Defined as instance variable
    private String make;
    private String model;
    private int year;
    private Person owner;
    private int VIN;

    //Defined as class variables
    private static int COUNT;

    public Car(String make, String model, int year, int VIN) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.VIN = VIN;
    }

    public Car(String make, String model, int year, Person owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.owner = owner;
    }

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Car(String make, String model, int year, int VIN, Person owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.VIN = VIN;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", owner=" + owner.toString() +
                ", VIN=" + VIN +
                '}';
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public static int getCOUNT() {
        return COUNT;
    }

    public static void setCOUNT(int COUNT) {
        Car.COUNT = COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return getYear() == car.getYear() && getVIN() == car.getVIN() && Objects.equals(getMake(), car.getMake()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getOwner(), car.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getYear(), getOwner(), getVIN());
    }
}
