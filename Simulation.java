import java.awt.*;
import java.util.ArrayList;

public class Simulation implements Subject{

    private ArrayList<Car> cars;
    private AutoServiceCenter<Volvo240> volvoCenter;
    private final int MAX_CAR = 10;
    private ArrayList<Observer> observers = new ArrayList<>();


    public Simulation(){

        cars = new ArrayList<>();
        volvoCenter = new AutoServiceCenter<>(650,380,4);

        cars.add(CarFactory.createVolvo());
        cars.add(CarFactory.createSaab());
        cars.add(CarFactory.createScania());

    }

    public void addCar(Car car){
        if (cars.size() >= MAX_CAR) return;
        cars.add(car);
    }

    public void removeCar(Car car){
        cars.remove(car);
    }

    public void removeLastCar() {
        if (!cars.isEmpty()) {
            cars.removeLast();
        }
    }

    public void update(){
        handelWallCollision();
        handelServiceCenterCollision();
        moveCars();
        notifyObservers();
    }

    private void moveCars(){
        for(Car car :cars){
            car.move();
        }
    }
    private void handelWallCollision(){
        for (Car car:cars){
            if (car.getX() <= 0 || car.getX() >= 700 || car.getY() <= 0 || car.getY() >= 500) {
                car.turnLeft();
                car.turnLeft();
            }
        }
    }
    private void handelServiceCenterCollision(){
        for(Car car :cars){
            if (car.getX() >= volvoCenter.getX() && car.getY() >= volvoCenter.getY() && car.getY() <= volvoCenter.getY()+100)
                if(car.getModelName().equals("Volvo240")){
                    volvoCenter.addCar((Volvo240)car);
                    car.stopEngine();
                    car.setX(volvoCenter.getX());
                    car.setY(volvoCenter.getY());

            }
        }
    }
    public ArrayList<Car> getCars(){return new ArrayList<>(cars) ;}


    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers){
            o.update(cars);
        }
    }
}
