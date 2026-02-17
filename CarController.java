import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    AutoServiceCenter<Volvo240> volvoCenter = new AutoServiceCenter<>(4);

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0,0,0,4,100,0,false,Color.GREEN));
        cc.cars.add(new Saab95(0,0,0,2,125,0,false,Color.pink));
        cc.cars.add(new Scania(0,0,0,2,90,0,true,Color.red));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();

            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
            }
    }
    void turnLeft(){
        for (Car car : cars) {
            car.turnLeft();
        }
    }
    void turnRight(){
        for (Car car : cars) {
            car.turnRight();
        }
    }

    void liftBed(){
        for(Car car: cars){
            if (car instanceof Scania){
                Scania scania = (Scania) car;
                scania.raiseDumpBedAngle(10);
            }
        }
    }
    void lowerBed(){
        for(Car car: cars){
            if (car instanceof Scania){
                Scania scania = (Scania) car;
                scania.decreaseDumpBedAngle(10);
            }
        }
    }
    void turboOn(){
        for(Car car:cars){
            if(car instanceof Saab95){
                Saab95 saab95 = (Saab95) car;
                saab95.setTurboOn();
            }
        }

    }
    void turboOff(){
        for(Car car:cars){
            if(car instanceof Saab95){
                Saab95 saab95 = (Saab95) car;
                saab95.setTurboOff();
            }
        }
    }

}
