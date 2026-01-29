import java.awt.*;

public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;
    
    public Volvo240(double x, double y, int direction, int nrDoors, double enginePower, Color color){

        super(x, y,direction);
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        modelName = "Volvo240";
        stopEngine();
    }
    // default method
    public Volvo240(double x, double y, int direction){

        super(x, y,direction);
        nrDoors = 4;
        color = Color.BLACK;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


}

