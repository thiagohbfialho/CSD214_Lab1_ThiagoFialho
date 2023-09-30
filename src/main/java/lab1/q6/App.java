package lab1.q6;

import lab1.q4.Car;

import java.util.Scanner;

public class App {

    private final int numCars = 100;
    private Car[] unsoldCars;
    private Car[] soldCars;
    private int unsoldCurrentIndex;
    private int soldCurrentIndex;
    private Scanner input;
    private String menu;

    public App() {
        this.unsoldCars = new Car[numCars];
        this.soldCars = new Car[numCars];
        this.unsoldCurrentIndex = unsoldCurrentIndex;
        this.soldCurrentIndex = soldCurrentIndex;
        this.input = new Scanner(System.in);
        this.menu  = ""
                + "----------------\n"
                + "Thiago's Used Car Lot\n"
                + "----------------\n"
                + " 1. Add a Car\n"
                + " 2. Edit a car\n"
                + " 3. Delete an unsold Car\n"
                + " 4. Delete a sold Car\n"
                + " 5. List unsold Cars\n"
                + " 6. List sold Cars\n"
                + " 7. Sell a Car\n"
                + "99. Exit\n";
    }

    public int getNumCars() {
        return numCars;
    }

    public Car[] getUnsoldCars() {
        return unsoldCars;
    }

    public Car[] getSoldCars() {
        return soldCars;
    }

    public void setSoldCars(Car[] soldCars) {
        this.soldCars = soldCars;
    }

    public int getUnsoldCurrentIndex() {
        return unsoldCurrentIndex;
    }

    public void setUnsoldCurrentIndex(int unsoldCurrentIndex) {
        this.unsoldCurrentIndex = unsoldCurrentIndex;
    }

    public int getSoldCurrentIndex() {
        return soldCurrentIndex;
    }

    public void setSoldCurrentIndex(int soldCurrentIndex) {
        this.soldCurrentIndex = soldCurrentIndex;
    }

    public Scanner getInput() {
        return input;
    }

    public String getMenu() {
        return menu;
    }

    /*
    Method to insert a car in a unsoldCars array
     */
    public void addCar(Car car){
        if(car!=null){
            int unsoldCurrentIndex = this.getUnsoldCurrentIndex();
            if(unsoldCurrentIndex<99){
                this.unsoldCars[unsoldCurrentIndex] = car;
                this.setUnsoldCurrentIndex(unsoldCurrentIndex+1);
            }else {
                System.out.println("Unsold Cars lits is full, delete one car!");
            }
        }
    }

    public String listUnsoldCars(){
        String list = "";
        int totalunsoldCars = this.getUnsoldCurrentIndex();
                for(int i = 0; totalunsoldCars > i; i++ ){
                    list += (i+1)+". ";
                    list += this.getUnsoldCars()[i].getMake() +", ";
                    list += this.getUnsoldCars()[i].getModel() +", ";
                    list += this.getUnsoldCars()[i].getYear() +" ";
                }
        return list;
    }

    public static void main(String[] args) {

        int selection = 0;

        App app = new App();
        while(selection!=99){
            System.out.println(app.getMenu());
            selection = app.input.nextInt();

            if(selection==1){

                Scanner input = new Scanner(System.in); // reset the scanner

                System.out.println("Enter Make:");
                String make = input.nextLine();
                //System.out.println("f");
                System.out.println("Enter Model:");
                String model = input.nextLine();
                //System.out.println("b");
                System.out.println("Enter Year:");
                int year = input.nextInt();
                //System.out.println("2");

                Car car = new Car(make,model,year);
                app.addCar(car);

                //System.out.println(app.listUnsoldCars());
            }

        }
    }

}
