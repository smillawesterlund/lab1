import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    @Test
    void setDumpBedAngle() {
        Scania scania = new Scania(0,0,0, 2,90,0,true, Color.GREEN);

        scania.raiseDumpBedAngle(30);
        assertEquals(30,scania.getDumpBedAngle());
        //flaket ska endast kunna ha vinkeln 0-70
        scania.decreaseDumpBedAngle(30);


        scania.startEngine();
        scania.gas(1);

        scania.raiseDumpBedAngle((20));
        assertEquals(0, scania.getDumpBedAngle());
        //Dumpbed ska inte gå att ändra om den lastbilen körs

    }


    @Test
    void startEngine() {
        Scania scania = new Scania(0,0,0, 2,90,0,true, Color.GREEN);

        scania.raiseDumpBedAngle(30);
        scania.startEngine();

        assertEquals(0, scania.getCurrentSpeed());
        //Motorn ska inte kunna köras om flaket är uppfält
    }

}