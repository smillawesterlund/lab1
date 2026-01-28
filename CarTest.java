import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car(100,100,0);
    }
    @Test
    void getX(){
        assertEquals(100,car.getX());
    }
    @Test
    void getY(){
        assertEquals(100,car.getY());
    }
    @Test
    void getDirection(){
        assertEquals(0,car.getDirection());
    }
    @Test
    void getCurrentspeed(){
        car.startEngine();
        assertEquals(0.1,car.getCurrentSpeed());
        car.stopEngine();
        assertEquals(0,car.getCurrentSpeed());
    }
    @Test
    void setColor(){
        car.setColor(Color.blue);
        assertEquals(Color.blue , car.getColor());
    }

    @Test
    void startEngine() {
        car.startEngine();
        assertEquals(0.1,car.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        car.stopEngine();
        assertEquals(0,car.getCurrentSpeed());
    }

    @Test
    void move() {
        double x = car.getX();
        double y = car.getY();

        car.startEngine();
        car.move();
        assertEquals(x , car.getX());
        assertTrue(y>car.getY());

        x = car.getX();
        y = car.getY();
        car.turnLeft();
        car.move();
        assertEquals(y , car.getY());
        assertTrue(x>car.getX());

        x = car.getX();
        y = car.getY();
        car.turnLeft();
        car.move();
        assertEquals(x , car.getX());
        assertTrue(y<car.getY());

        x = car.getX();
        y = car.getY();
        car.turnLeft();
        car.move();
        assertEquals(y , car.getY());
        assertTrue(x<car.getX());

        x = car.getX();
        car.stopEngine();
        car.move();
        assertEquals(x,car.getX());

    }

    @Test
    void turnLeft() {
        car.turnLeft();
        assertEquals(3,car.getDirection());
    }

    @Test
    void turnRight() {
        car.turnRight();
        assertEquals(1,car.getDirection());
    }
}