import java.util.ArrayList;

public class AutoServiceCenter<T extends Car> {
    private ArrayList<T> serviceCenter;
    private int capacity;
    private int x,y;

    public AutoServiceCenter(int x, int y,int capacity){
        this.x = x;
        this.y = y;
        this.capacity = capacity;
        serviceCenter = new ArrayList<>(capacity);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
