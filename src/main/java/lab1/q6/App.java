package lab1.q6;

import lab1.q3.Person;
import lab1.q4.Car;

import java.util.Scanner;

/**
 * @author thiagofialho
 * Date: 09-30-23
 * Description: This is a class for the App, this class allows a user
 * to add, edit and delete a car in an unsold list
 * The user can sell a car that was in an unsold list.
 * After sell a car, a user can delete this car.
 * The user can also see all cars in the unsold list and sold list.
 **/


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

    //Return all car's number in the app
    public int getNumCars() {
        return numCars;
    }

    //Return an array with unsold cars
    public Car[] getUnsoldCars() {
        return unsoldCars;
    }

    //Return an array with sold cars
    public Car[] getSoldCars() {
        return soldCars;
    }

    //Update the sold car's list
    public void setSoldCars(Car[] soldCars) {
        this.soldCars = soldCars;
    }

    public void setUnsoldCars(Car[] unsoldCars) {
        this.unsoldCars = unsoldCars;
    }
    //Return the unsold car's total
    public int getUnsoldCurrentIndex() {
        return unsoldCurrentIndex;
    }

    //Update the unsold car's total
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

    public String getListCars(int total, Car[] list){
        String listCars = "";
                for(int i = 0; total > i; i++ ){
                    listCars += (i+1)+". ";
                    listCars += list[i].getMake() +", ";
                    listCars += list[i].getModel() +", ";
                    listCars += list[i].getYear() +" \n";
                }
        return listCars;
    }

    /**
    * In this method the user can input information about a new car
     */
    private void addNewCar() {
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
        this.addCar(car);
    }

    /**
     * In this method the user can input information and edit a car
     */
    private void editCar() {
        int choice = getChoice(this.getUnsoldCars(), this.getUnsoldCurrentIndex(),"Which car would like to edit?");

        Scanner input = new Scanner(System.in); // reset the scanner
        if( choice > 0 && choice < this.getUnsoldCurrentIndex() + 1){
            Car car = this.getUnsoldCars()[choice-1];
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

    /**
     * In this method the user can choose which car he wants to edit
     */
    private int getChoice(Car[] list, int currentIndex,  String question) {
        System.out.println(this.getListCars(currentIndex, list));
        System.out.println(question);
        int choice = this.getInput().nextInt();
        return choice;
    }

    /**
     * This method delete a car from a list and return a new list with that car
     */
    private Car[] deleteCar(Car[] list, int indexDelete, int currentIndex){
        Car[] newListCars = new Car[this.getNumCars()];
        int newIndex = 0;
        for(int i = 0; i < currentIndex; i++){
            if(i!=indexDelete){
                newListCars[newIndex] = list[i];
                newIndex++;
            }
        }
        return newListCars;
    }

    /**
     * In this method the user can sell a car
     */
    private void sellCar(Car[] unsoldCars, int unsoldCurrentIndex) {
        int choice = getChoice(this.getUnsoldCars(), this.getUnsoldCurrentIndex(),"Which car would like to sell?");

        Scanner input = new Scanner(System.in); // reset the scanner
        if( choice > 0 && choice < this.getUnsoldCurrentIndex() + 1){
            Car car = this.getUnsoldCars()[choice-1];
            System.out.println("Owner First Name: ");
            String firstName = input.nextLine();
            System.out.println("Owner Last Name: ");
            String lastName = input.nextLine();
            Person person = new Person(firstName, lastName);
            car.setOwner(person);
            int soldCurrentIndex = this.getSoldCurrentIndex();
            if(soldCurrentIndex<99){
                this.soldCars[soldCurrentIndex] = car;
                this.setSoldCurrentIndex(soldCurrentIndex+1);
                this.setUnsoldCars(this.deleteCar(this.getUnsoldCars(),choice-1,this.getUnsoldCurrentIndex()));
                this.setUnsoldCurrentIndex(this.getUnsoldCurrentIndex()-1);
            }else {
                System.out.println("Sold Cars lits is full, delete one car!");
            }
        }else{
            System.out.println("Choice out of bounds!");
        }
    }

    /**
     * In this method the user can delete an unsold car
     */
    private void deleteUnsoldCar() {
        int unsoldCurrentIndex = this.getUnsoldCurrentIndex();
        Car[] unsoldCars = this.getUnsoldCars();
        int choice = getChoice(this.getUnsoldCars(), unsoldCurrentIndex,"Which car would like to delete?");

        Scanner input = new Scanner(System.in); // reset the scanner
        if( choice > 0 && choice < unsoldCurrentIndex + 1){
            if(unsoldCurrentIndex<99){
                this.setUnsoldCars(this.deleteCar(unsoldCars,choice-1,unsoldCurrentIndex));
                this.setUnsoldCurrentIndex(unsoldCurrentIndex-1);
            }else {
                System.out.println("Unsold Cars lits is full, delete one car!");
            }
        }else{
            System.out.println("Choice out of bounds!");
        }
    }

    /**
     * In this method the user can delete a sold car
     */
    private void deleteSoldCar() {
        int soldCurrentIndex = this.getSoldCurrentIndex();
        Car[] soldCars = this.getSoldCars();
        int choice = getChoice(this.getSoldCars(), soldCurrentIndex,"Which car would like to delete?");

        Scanner input = new Scanner(System.in); // reset the scanner
        if( choice > 0 && choice < soldCurrentIndex + 1){
            if(soldCurrentIndex<99){
                this.setSoldCars(this.deleteCar(soldCars,choice-1,soldCurrentIndex));
                this.setSoldCurrentIndex(soldCurrentIndex-1);
            }else {
                System.out.println("Sold Cars lits is full, delete one car!");
            }
        }else{
            System.out.println("Choice out of bounds!");
        }
    }

    /**
     * In this method the user can run the app.
     */
    public void run() {

        int selection = 0;
        boolean running = true;

        App app = new App();
        while(running){
            System.out.println(app.getMenu());
            selection = app.input.nextInt();

            if((selection > 0 && selection < 8) || selection == 99){
                switch (selection){
                    case 1: //Add a car
                        app.addNewCar();
                        break;
                    case 2: //Edit a car
                        app.editCar();
                        break;
                    case 3: //Delete an unsold Car
                        app.deleteUnsoldCar();
                        break;
                    case 4: //Delete a sold Car
                        app.deleteSoldCar();
                        break;
                    case 5: //List unsold Cars
                        System.out.println(app.getListCars(app.getUnsoldCurrentIndex(),app.getUnsoldCars()));
                        break;
                    case 6: //List sold Cars
                        System.out.println(app.getListCars(app.getSoldCurrentIndex(),app.getSoldCars()));
                        break;
                    case 7: //Sell a car
                        app.sellCar(app.getUnsoldCars(),app.getUnsoldCurrentIndex());
                        break;
                    case 99://Exit
                        System.out.println("Good bye!");
                        running = false;
                        break;
                }
            }
        }
    }



}
