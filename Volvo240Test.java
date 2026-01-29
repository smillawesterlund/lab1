import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    Volvo240 defaultVolvo;
    Volvo240 volvo;

    @BeforeEach
    void setUp(){
        defaultVolvo = new Volvo240(100,100,0);
        volvo = new Volvo240(100,100,0,5,101, Color.GRAY);
    }

    @Test
    void speedFactor() {
        assertEquals(1.25,defaultVolvo.speedFactor());
        assertEquals(1.2625,volvo.speedFactor());
    }

    @Test
    void incrementSpeed() {
        defaultVolvo.startEngine();
        defaultVolvo.incrementSpeed(2);
        assertEquals(2.6,defaultVolvo.getCurrentSpeed());
        defaultVolvo.incrementSpeed(200);
        assertEquals(defaultVolvo.enginePower,defaultVolvo.getCurrentSpeed());
    }

    @Test
    void decrementSpeed() {
        defaultVolvo.startEngine();
        defaultVolvo.decrementSpeed(2);
        assertEquals(0,defaultVolvo.getCurrentSpeed());
        defaultVolvo.incrementSpeed(200);
        defaultVolvo.decrementSpeed(2);
        assertEquals(97.5,defaultVolvo.getCurrentSpeed());

    }

    @Test
    void getX() {
        assertEquals(100,defaultVolvo.getX());
    }

    @Test
    void getY() {
        assertEquals(100,defaultVolvo.getY());
    }

    @Test
    void getDirection() {
        assertEquals(0,defaultVolvo.getDirection());
    }

    @Test
    void getNrDoors() {
        assertEquals(4,defaultVolvo.getNrDoors());
        assertEquals(5,volvo.getNrDoors());

    }

    @Test
    void getEnginePower() {
        assertEquals(100,defaultVolvo.getEnginePower());
        assertEquals(101,volvo.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {
        assertEquals(0,defaultVolvo.getCurrentSpeed());
        assertEquals(0,volvo.getCurrentSpeed());
    }

    @Test
    void getAndSetColor() {
        assertEquals(Color.BLACK,defaultVolvo.getColor());
        assertEquals(Color.GRAY, volvo.getColor());
        volvo.setColor(Color.GREEN);
        assertEquals(Color.GREEN,volvo.getColor());
    }



    @Test
    void startEngine() {
        volvo.startEngine();
        assertEquals(0.1,volvo.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        volvo.startEngine();
        assertEquals(0.1,volvo.getCurrentSpeed());
        volvo.stopEngine();
        assertEquals(0,volvo.getCurrentSpeed());
    }

    @Test
    void move() {
        double x = volvo.getX();
        double y = volvo.getY();

        volvo.startEngine();
        volvo.move();
        assertEquals(x , volvo.getX());
        assertTrue(y>volvo.getY());

        x = volvo.getX();
        y = volvo.getY();
        volvo.turnLeft();
        volvo.move();
        assertEquals(y , volvo.getY());
        assertTrue(x>volvo.getX());

        x = volvo.getX();
        y = volvo.getY();
        volvo.turnLeft();
        volvo.move();
        assertEquals(x , volvo.getX());
        assertTrue(y<volvo.getY());

        x = volvo.getX();
        y = volvo.getY();
        volvo.turnLeft();
        volvo.move();
        assertEquals(y , volvo.getY());
        assertTrue(x<volvo.getX());

        x = volvo.getX();
        volvo.stopEngine();
        volvo.move();
        assertEquals(x,volvo.getX());
    }

    @Test
    void turnLeft() {
        volvo.turnLeft();
        assertEquals(3,volvo.getDirection());
    }

    @Test
    void turnRight() {
        volvo.turnRight();
        assertEquals(1,volvo.getDirection());
    }

    @Test
    void gas() {
        defaultVolvo.startEngine();
        defaultVolvo.gas(2);
        assertEquals(0.1,defaultVolvo.getCurrentSpeed());

        double speed = defaultVolvo.getCurrentSpeed();
        defaultVolvo.gas(0.34);
        assertTrue(speed<defaultVolvo.getCurrentSpeed());

    }


    @Test
    void brake() {
        defaultVolvo.startEngine();
        defaultVolvo.brake(-2);
        assertEquals(0.1, defaultVolvo.getCurrentSpeed());

        double speed = defaultVolvo.getCurrentSpeed();

        defaultVolvo.brake(0.6);
        assertTrue(speed>defaultVolvo.getCurrentSpeed());
    }

}