package lab1.q4;

import lab1.q3.Person;

import java.util.Objects;

public class Car {

    /**
     * @author thiagofialho
     * Date: 09-28-23
     * Description: This is a class for a Car
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

    /**
     * Constructor of the class Car with the params below.
     * @param make
     * @param model
     * @param year
     * @param VIN
     */
    public Car(String make, String model, int year, int VIN) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.VIN = VIN;
    }

    /**
     * Constructor of the class Car with the params below.
     * @param make
     * @param model
     * @param year
     * @param owner
     */
    public Car(String make, String model, int year, Person owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.owner = owner;
    }

    /**
     * Constructor of the class Car with the params below.
     * @param make
     * @param model
     * @param year
     */
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    /**
     * Constructor of the class Car with the params below.
     * @param make
     * @param model
     * @param year
     * @param VIN
     * @param owner
     */
    public Car(String make, String model, int year, int VIN, Person owner) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.VIN = VIN;
        this.owner = owner;
    }

    /**
     * Method that put all instance variable in a String
     * @return make, model, year, owner, VIN
     */
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

    /**
     *
     * @return Make
     */
    public String getMake() {
        return make;
    }

    /**
     * Method to edit the Make
     * @param make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     *
     * @return Model
     */
    public String getModel() {
        return model;
    }

    /**
     * Method to edit Model
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * @return Year
     */
    public int getYear() {
        return year;
    }

    /**
     * Method to edit Year
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     *
     * @return Owner
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Method to edit Owner
     * @param owner
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    /**
     *
     * @return VIN
     */
    public int getVIN() {
        return VIN;
    }

    /**
     * Method to edit VIN
     * @param VIN
     */
    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    /**
     *
     * @return COUNT
     */
    public static int getCOUNT() {
        return COUNT;
    }

    /**
     * Method to edit COUNT
     * @param COUNT
     */
    public static void setCOUNT(int COUNT) {
        Car.COUNT = COUNT;
    }

    /**
     * Method to know if two cars are the same
     * @param o
     * @return true/false
     */
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
