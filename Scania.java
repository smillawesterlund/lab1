import java.awt.*;

public class Scania extends Car{
    private FlatBed flatBed;

    public Scania(double x, double y, int direction, int nrDoors, double enginePower, double currentSpeed, boolean isBigCar, Color color){

        super(x, y, direction, nrDoors, enginePower, currentSpeed, isBigCar, color);
        flatBed = new FlatBed(0,70);
        modelName = "Scania";
        stopEngine();
    }
    /*default method
    public Scania(double x, double y, int direction){
        super(x, y,direction);
        setNrDoors(2);
        setColor(Color.GREEN);
        setEnginePower(90);
        setIsBigCar(true);
        dumpBedAngle = 0;
        modelName = "Scania";
        stopEngine();
    }

     */


    @Override
    public double speedFactor() {
        return 1;
    }
    public void raiseDumpBedAngle(int amount){
        flatBed.raiseAngle(amount);
    }

    public void decreaseDumpBedAngle(int amount){
        flatBed.decreaseAngle(amount);
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
