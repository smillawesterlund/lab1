import java.awt.*;

public class Scania extends Car{
    private int dumpBedAngle;

    public Scania(double x, double y, int direction, int nrDoors, double enginePower, Color color, int dumpBedAngle){
        super(x, y,direction);
        setNrDoors(nrDoors);

        setColor(color);
        setEnginePower( enginePower);
        setIsBigCar(true);
        this.dumpBedAngle = dumpBedAngle;
        modelName = "Scania";
        stopEngine();
    }
    // default method
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

    @Override
    public double speedFactor() {
        return 1;
    }
    public void setDumpBedAngle(int newAngle){
        if (newAngle>=0 && newAngle<=70 && getCurrentSpeed() == 0){
            dumpBedAngle = newAngle;
        }
    }

    public int getDumpBedAngle(){return dumpBedAngle;}

    @Override
    public void startEngine() {
        if (dumpBedAngle==0){super.startEngine();}
    }

    @Override
    public void gas(double amount) {
        if ((amount < 0 || amount > 1) || dumpBedAngle!=0) {
            //returnar inget
            return;
        }
        incrementSpeed(amount);
    }


}
