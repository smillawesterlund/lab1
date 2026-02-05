import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Trailer implements Movable{
    private final Scania scania;
    private boolean ramp;
    private ArrayList<Car> carList;
    private final int capacity;
    private Random rand = new Random();

    public Trailer(double x, double y, int direction, int capacity) {
        scania = new Scania(x,y,direction);
        ramp = false;
        carList = new ArrayList<>(6);
        this.capacity = capacity;
    }

    public void addNewCar(Car newCar) {
        double diffX = Math.abs(newCar.getX() - scania.getX());
        double diffY = Math.abs(newCar.getY() - scania.getY());

        if(ramp && (diffX <=10 && diffY <= 10) && carList.size() < capacity) {
            if(newCar.getIsBigCar()) {
                return;
            }
            carList.add(newCar);
        }
    }

    public void removeLastCar(){
        if (ramp){
            carList.getLast().setX(rand.nextDouble(scania.getX()+5, scania.getX()+15) );
            carList.getLast().setY(rand.nextDouble(scania.getY()+5, scania.getY()+15) );

            carList.removeLast();
        }
    }

    public void openRamp(){
        if(scania.getCurrentSpeed()==0){ramp = true;}
    }
    public void closeRamp(){ramp = false;}
    public boolean getRamp(){return ramp;}

    public double speedFactor(){
        return scania.speedFactor();
    }

    public void incrementSpeed(double amount){
        scania.incrementSpeed(amount);
    }

    public void decrementSpeed(double amount){
        scania.decrementSpeed(amount);

    }

    public int getCarListSize(){return carList.size();}

    public int getCapacity(){return capacity;}

    public double getX(){return scania.getX();}

    public double getY() {return scania.getY();}

    public int getDirection() {return scania.getDirection();}

    public int getNrDoors(){return scania.getNrDoors();}
    public double getEnginePower(){return scania.getEnginePower();}

    public double getCurrentSpeed(){return scania.getCurrentSpeed();}

    public void setCurrentSpeed(double speed){
        scania.setCurrentSpeed(speed);
    }

    public Color getColor(){return scania.getColor();}

    public void setColor(Color clr){scania.setColor(clr);}

    public void startEngine(){scania.setCurrentSpeed(0.1); }

    public void stopEngine(){scania.setCurrentSpeed(0);}

    @Override
    public void move() {
        scania.move();
        for(Car car: carList){
            car.setX(scania.getX());
            car.setY(scania.getY());
            car.setDirection(scania.getDirection());
        }

    }

    @Override
    public void turnLeft() {
        scania.turnLeft();
    }

    @Override
    public void turnRight() {
        scania.turnRight();
    }


    public void gas(double amount){
        if (amount < 0 || amount > 1) {
            return;
        }
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1) {
            return;
        }
        decrementSpeed(amount);

    }


}
