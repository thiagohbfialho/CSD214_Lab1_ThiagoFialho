package lab1.q6;

import lab1.q4.Car;

import java.util.Scanner;

public class App {

    private final int numCars = 100;
    private Car[] unsoldCars = new Car[numCars];
    private Car[] soldCars = new Car[numCars];
    private int unsoldCurrentIndex = 0;
    private int soldCurrentIndex = 0;
    private Scanner input = new Scanner(System.in);
    private String menu = ""
            + "----------------\n"
            + " 1. Add a Car\n"
            + " 2. Edit a car\n"
            + " 3. Delete an unsold Car\n"
            + " 4. Delete a sold Car\n"
            + " 5. List unsold Cars\n"
            + " 6. List sold Cars\n"
            + " 7. Sell a Car\n"
            + "99. Exit\n";

    public String getMenu(){
        return this.menu;
    }

    public static void main(String[] args) {

        int selection = 0;

        App app = new App();
        while(selection!=99){
            System.out.println(app.getMenu());
            selection = app.input.nextInt();
        }
    }

}
