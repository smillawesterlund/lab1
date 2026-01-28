import java.awt.*;

public class Car implements Movable{

    private double x,y;
    private  int direction;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    public String modelName; // The car model name

    public Car(double x, double y, int direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public int getNrDoors(){

        return nrDoors;
    }
    public double getEnginePower(){

        return enginePower;
    }

    public double getCurrentSpeed(){

        return currentSpeed;
    }

    public Color getColor(){

        return color;
    }

    public void setColor(Color clr){

        color = clr;
    }

    public void startEngine(){

        currentSpeed = 0.1;
    }

    public void stopEngine(){

        currentSpeed = 0;
    }
// direcation kan vara 0,1,2,3 där 0 och 2 är uppåt respektive neråt, 3 och 1 är vänster respektive höger

    @Override
    public void move() {
        if (direction == 0){
            y = y - getCurrentSpeed();
        } else if (direction == 1) {
            x = x+ currentSpeed;
        } else if (direction==2) {
            y = y + currentSpeed;
        }else if (direction == 3){
            x = x-currentSpeed;
    }}

    @Override
    public void turnLeft() {
        direction = (direction -1 + 4) % 4;
    }

    @Override
    public void turnRight() {
        direction = (direction + 1 + 4) % 4;
    }
}
