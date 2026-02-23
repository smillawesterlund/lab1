import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;
    
    public Volvo240(double x, double y, int direction, int nrDoors, double enginePower, double currentSpeed, boolean isBigCar, Color color){

        super(x, y,direction,nrDoors,enginePower,currentSpeed,isBigCar,color);
        modelName = "Volvo240";
        stopEngine();
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


}

