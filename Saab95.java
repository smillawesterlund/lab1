import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Saab95 extends Car implements Turboable{

    private boolean turboOn;

    public Saab95(double x, double y, int direction, int nrDoors, double enginePower, double currentSpeed, boolean isBigCar, Color color, String modelName){

        super(x, y,direction,nrDoors,enginePower,currentSpeed,isBigCar,color, modelName);
	    turboOn = false;
        stopEngine();
        try {
            setImg(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void turboOn(){
	    turboOn = true;
    }

    public void turboOff(){
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


