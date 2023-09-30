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

    private void addNewCar(App app) {
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
    }

    private void editCar(App app) {
        System.out.println(app.listUnsoldCars());
        System.out.println("Which car would like to edit?");
        int choice = app.getInput().nextInt();

        Scanner input = new Scanner(System.in); // reset the scanner
        if( choice > 0 && choice < app.getUnsoldCurrentIndex() + 1){
            Car car = app.getUnsoldCars()[choice-1];
            System.out.println("Make: "+car.getMake());
            car.setMake(input.nextLine());
            System.out.println("Model: "+car.getModel());
            car.setModel(input.nextLine());
            System.out.println("Year: "+car.getYear());
            car.setYear(input.nextInt());
        }else{
            System.out.println("Choice out of bounds!");
        }
    }

    private void deleteCar(App app) {
    }

    public static void main(String[] args) {

        int selection = 0;
        boolean running = true;

        App app = new App();
        while(running){
            System.out.println(app.getMenu());
            selection = app.input.nextInt();

            if((selection > 0 && selection < 8) || selection == 99){
                switch (selection){
                    case 1:
                        app.addNewCar(app);
                        break;
                    case 2:
                        app.editCar(app);
                        break;
                    case 3:
                        app.deleteCar(app);
                        break;
                    case 5:
                        System.out.println(app.listUnsoldCars());
                        break;
                    case 99:
                        System.out.println("Good bye!");
                        running = false;
                        break;
                }
            }
        }
    }

}
