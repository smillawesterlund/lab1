import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Trailer extends Car{

    private FlatBed flatBed;
    private ArrayList<Car> carList;
    private final int capacity;
    private Random rand = new Random();

    public Trailer(double x, double y, int direction, int nrDoors, double enginePower, double currentSpeed, boolean isBigCar, Color color, String modelName, int capacity){
        super(x, y,direction,nrDoors,enginePower,currentSpeed,isBigCar,color,modelName);
        flatBed = new FlatBed(0,1);
        carList = new ArrayList<>(6);
        this.capacity = capacity;
    }

    public void addNewCar(Car newCar) {
        double diffX = Math.abs(newCar.getX() - super.getX());
        double diffY = Math.abs(newCar.getY() - super.getY());

        if(flatBed.isFlatbedReady() && (diffX <=10 && diffY <= 10) && carList.size() < capacity) {
            if(newCar.getIsBigCar()) {
                return;
            }
            carList.add(newCar);
        }
    }

    public void removeLastCar(){
        if (flatBed.isFlatbedReady()){
            carList.getLast().setX(rand.nextDouble(super.getX()+5, super.getX()+15) );
            carList.getLast().setY(rand.nextDouble(super.getY()+5, super.getY()+15) );

            carList.removeLast();
        }
    }

    public void riseFlatBedAngle(int amount){ flatBed.raiseAngle(amount);}
    public void decreaseFlatBedAngle(int amount){flatBed.decreaseAngle(amount);}


    public double speedFactor(){
        return 1;
    }


    public int getCarListSize(){return carList.size();}

    public int getCapacity(){return capacity;}



    @Override
    public void move() {
        super.move();
        for(Car car: carList){
            car.setX(super.getX());
            car.setY(super.getY());
            car.setDirection(super.getDirection());
        }
    }


    public void gas(double amount){
        if (flatBed.isFlatbedReady()) {
            super.gas(amount);
        }
    }

    public void brake(double amount){
        if (flatBed.isFlatbedReady()) {
            super.brake(amount);
        }
    }


}
