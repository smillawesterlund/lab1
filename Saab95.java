import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(double x, double y, int direction, int nrDoors, double enginePower, Color color){

        super(x, y,direction);
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }
    // default method
    public Saab95(double x, double y, int direction){
        super(x, y,direction);
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }


    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}


