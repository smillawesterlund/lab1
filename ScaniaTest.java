import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    @Test
    void setDumpBedAngle() {
        Scania scania = new Scania(0,0,0);

        scania.setDumpBedAngle(30);
        assertEquals(30,scania.getDumpBedAngle());
        //flaket ska endast kunna ha vinkeln 0-70
        scania.setDumpBedAngle(0);


        scania.startEngine();
        scania.gas(1);

        scania.setDumpBedAngle((50));
        assertEquals(0, scania.getDumpBedAngle());
        //Dumpbed ska inte gå att ändra om den lastbilen körs

    }


    @Test
    void startEngine() {
        Scania scania = new Scania(0,0,0);

        scania.setDumpBedAngle(30);
        scania.startEngine();

        assertEquals(0, scania.getCurrentSpeed());
        //Motorn ska inte kunna köras om flaket är uppfält
    }

}