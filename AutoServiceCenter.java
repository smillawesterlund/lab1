import java.util.ArrayList;

public class AutoServiceCenter<T extends Car> {
    private ArrayList<T> serviceCenter;
    private int capacity;

    public AutoServiceCenter(int capacity){
        this.capacity = capacity;
        serviceCenter = new ArrayList<>(capacity);
    }

    public void addCar(T car){
        if(serviceCenter.size()<capacity)
            serviceCenter.add(car);
    }

    public T pickUpCar(T car){
        if(serviceCenter.contains(car)){
            serviceCenter.remove(car);
            return car;
        }
        return null;
    }

}
