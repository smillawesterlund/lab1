import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {


    Saab95 saab;

    @BeforeEach
    void setUp(){

        saab = new Saab95(100,100,0,2,130,0,false, Color.DARK_GRAY);
    }

    @Test
    void setTurboOn() {
        saab.setTurboOn();


        assertTrue(saab.getTurboOn());


    }

    @Test
    void setTurboOff() {
        saab.setTurboOff();


        assertFalse(saab.getTurboOn());


    }

    @Test
    void speedFactor() {
        assertEquals(1.3,saab.speedFactor(),0.0001);

    }
}