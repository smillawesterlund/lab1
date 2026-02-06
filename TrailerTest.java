import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TrailerTest {
    Trailer trailer;

    @BeforeEach
    void setUp(){
        trailer = new Trailer(100,100,0,2,100,0,true,Color.GREEN,2);
    }

    @Test
    void addNewCar() {

        Car newCarClose = new Volvo240(105, 103,0,4,125,0,false,Color.BLUE);
        Car newCarFar = new Saab95(111,89,0,4,125,0,false,Color.BLUE);
        Car newScania = new Scania(100,100,0,4,125,0,true,Color.BLUE);

        trailer.riseFlatBedAngle(1);
        trailer.addNewCar(newCarClose);
        assertEquals(1, trailer.getCarListSize());
        //en bil ska finnas på trailern

        trailer.addNewCar(newCarFar);
        assertEquals(1, trailer.getCarListSize());
        //bilen läggs inte till om den är långt bort ifrån trailer

        trailer.addNewCar(newCarClose);
        trailer.addNewCar(newCarClose);
        assertEquals(2, trailer.getCarListSize());
        //kan inte läggas till fler än 2 bilar

        trailer.removeLastCar();
        trailer.removeLastCar();
        trailer.addNewCar(newScania);
        assertEquals(0, trailer.getCarListSize());
        //kan inte lägga till stora bilar aka lastbilar

        trailer.decreaseFlatBedAngle(1);
        trailer.addNewCar(newCarClose);
        assertEquals(0, trailer.getCarListSize());
        //kan inte lägga till om rampen stängd
    }

    @Test
    void removeLastCar() {
        Car smallCar = new Saab95(100,100,0,2,125,0,false,Color.BLUE);

        trailer.riseFlatBedAngle(1);
        trailer.addNewCar(smallCar);

        trailer.removeLastCar();
        assertEquals(0, trailer.getCarListSize());
        //position på bilen borde vara slumpad men ändå rimlig

        assertTrue(smallCar.getX() >= trailer.getX() + 5 && smallCar.getX() <= trailer.getX() + 15);
    }


    @Test
    void startEngine() {
        trailer.stopEngine();
        assertEquals(0, trailer.getCurrentSpeed(), 0.0001);

        trailer.startEngine();
        assertEquals(0.1, trailer.getCurrentSpeed(), 0.0001, "Hej Mose du suger!!!()");
    }

    @Test
    void move() {
        Car testCar = new Saab95(100,100,0,2,125,0,false,Color.BLUE);
        trailer.riseFlatBedAngle(1);
        trailer.addNewCar(testCar);
        trailer.decreaseFlatBedAngle(1);
        trailer.startEngine();
        trailer.gas(1);
        trailer.move();
        assertEquals(trailer.getX(), testCar.getX());
        assertEquals(trailer.getY(), testCar.getY());
    }
}