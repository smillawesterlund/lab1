import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 defaultSaab;
    Saab95 saab;

    @BeforeEach
    void setUp(){
        defaultSaab = new Saab95(100,100,0);
        saab = new Saab95(100,100,0,2,130, Color.DARK_GRAY);
    }

    @Test
    void setTurboOn() {
        saab.setTurboOn();
        defaultSaab.setTurboOn();

        assertTrue(saab.getTurboOn());
        assertTrue(defaultSaab.getTurboOn());

    }

    @Test
    void setTurboOff() {
        saab.setTurboOff();
        defaultSaab.setTurboOff();

        assertFalse(saab.getTurboOn());
        assertFalse(defaultSaab.getTurboOn());

    }

    @Test
    void speedFactor() {
        assertEquals(1.3,saab.speedFactor(),0.0001);
        assertEquals(1.25,defaultSaab.speedFactor(),0.0001);
    }
}