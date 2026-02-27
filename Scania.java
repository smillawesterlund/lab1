import java.awt.*;

public class Scania extends Car implements LiftableFlatBed{
    private FlatBed flatBed;

    public Scania(double x, double y, int direction, int nrDoors, double enginePower, double currentSpeed, boolean isBigCar, Color color){

        super(x, y, direction, nrDoors, enginePower, currentSpeed, isBigCar, color);
        flatBed = new FlatBed(0,70);
        modelName = "Scania";
        stopEngine();
    }

    @Override
    public double speedFactor() {
        return 1;
    }

    public void liftBed(){flatBed.raiseAngle(10);}

    public void lowerBed(){
        flatBed.decreaseAngle(10);
    }

    public int getDumpBedAngle(){return flatBed.getAngle();}

    @Override
    public void startEngine() {
        if (flatBed.isFlatbedReady()){super.startEngine();}
    }

    @Override
    public void gas(double amount) {
        if (flatBed.isFlatbedReady()) {
            super.gas(amount);
        }

    }


}
