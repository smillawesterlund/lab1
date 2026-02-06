import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    public Saab95(double x, double y, int direction, int nrDoors, double enginePower, double currentSpeed, boolean isBigCar, Color color){

        super(x, y,direction,nrDoors,enginePower,currentSpeed,isBigCar,color);
        setNrDoors(nrDoors);
        setColor(color);
        setEnginePower(enginePower);
        setIsBigCar(false);
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

    public boolean getTurboOn() {return turboOn; }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}


