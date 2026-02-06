import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {


    Volvo240 volvo;

    @BeforeEach
    void setUp(){

        volvo = new Volvo240(100,100,0,5,101,0,false, Color.GRAY);
    }

    @Test
    void speedFactor() {
        assertEquals(1.2625,volvo.speedFactor());
    }


    @Test
    void getX() {
        assertEquals(100,volvo.getX());
    }

    @Test
    void getY() {
        assertEquals(100,volvo.getY());
    }

    @Test
    void getDirection() {
        assertEquals(0,volvo.getDirection());
    }

    @Test
    void getNrDoors() {
        assertEquals(5,volvo.getNrDoors());
    }

    @Test
    void getEnginePower() {
        assertEquals(101,volvo.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {
        assertEquals(0,volvo.getCurrentSpeed());
    }

    @Test
    void getAndSetColor() {
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
        volvo.startEngine();
        volvo.gas(2);
        assertEquals(0.1, volvo.getCurrentSpeed());

        double speed = volvo.getCurrentSpeed();
        volvo.gas(0.34);
        assertTrue(speed<volvo.getCurrentSpeed());

    }


    @Test
    void brake() {
        volvo.startEngine();
        volvo.brake(-2);
        assertEquals(0.1, volvo.getCurrentSpeed());

        double speed = volvo.getCurrentSpeed();

        volvo.brake(0.6);
        assertTrue(speed>volvo.getCurrentSpeed());
    }

}