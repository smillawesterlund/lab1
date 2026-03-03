import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController implements CarCommands {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.


    // The frame that represents this instance View of the MVC pattern
    private CarView frame;

    private Simulation simulation;

    public CarController(Simulation sim){
        this.simulation = sim;
    }

    public void start(){
        Timer timer = new Timer(delay, new TimerListener());
        timer.start();
    }



    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            simulation.update();
            //frame.drawPanel.repaint();
        }
    }



// Calls the gas method for each car once
public void gas(int amount) {
    double gas = ((double) amount) / 100;
    for (Car car : simulation.getCars()) {
        car.gas(gas);
    }
}
public void brake(int amount) {
    double brake = ((double) amount) / 100;
    for (Car car : simulation.getCars()) {
        car.brake(brake);
    }
}
public void turnLeft(){
    for (Car car : simulation.getCars()) {
        car.turnLeft();
    }
}
public void turnRight(){
    for (Car car : simulation.getCars()) {
        car.turnRight();
    }
}

public void liftBed(){
    for(Car car: simulation.getCars()){
        if (car instanceof LiftableFlatBed){
            LiftableFlatBed c = (LiftableFlatBed) car;
            c.liftBed();
        }
    }
}
public void lowerBed(){
    for(Car car: simulation.getCars()){
        if (car instanceof LiftableFlatBed){
            LiftableFlatBed c = (LiftableFlatBed) car;
            c.lowerBed();
        }
    }
}
public void turboOn(){
    for(Car car:simulation.getCars()){
        if(car instanceof Turboable){
            Turboable c = (Turboable) car;
            c.turboOn();
        }
    }

}
public void turboOff(){
    for(Car car:simulation.getCars()){
        if(car instanceof Turboable){
            Turboable c = (Turboable) car;
            c.turboOff();
        }
    }
}
public void startEngine() {
    for (Car car : simulation.getCars()) {
        car.startEngine();
    }
}
public void stopEngine() {
    for (Car car : simulation.getCars()) {
        car.stopEngine();
    }
}
}
