import java.awt.*;
import java.util.ArrayList;

public class Simulation implements Subject{

    private ArrayList<Car> cars;
    private AutoServiceCenter<Volvo240> volvoCenter;

    private ArrayList<Observer> observers = new ArrayList<>();


    public Simulation(){

        cars = new ArrayList<>();
        volvoCenter = new AutoServiceCenter<>(650,380,4);

        cars.add(new Volvo240(10,10,1,4,100,0,false, Color.GREEN, "Volvo240"));
        cars.add(new Saab95(10,100,1,2,125,0,false,Color.pink,"Saab95"));
        cars.add(new Scania(10,200,1,2,90,0,true,Color.red, "Scania"));

    }

    public void addCar(Car car){
        cars.add(car);
    }
    public void removeCar(Car car){
        cars.remove(car);
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
    public ArrayList<Car> getCars(){return cars;}


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
