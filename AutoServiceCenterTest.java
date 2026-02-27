import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class AutoServiceCenterTest {

    AutoServiceCenter<Car> carServiceCenter;
    AutoServiceCenter<Volvo240> volvoServiceCenter;
    AutoServiceCenter<Scania> scaniaServiceCenter;
    AutoServiceCenter<Trailer> trailerServiceCenter;

    @Test
    void addCarAndPickUpCar() {
        carServiceCenter = new AutoServiceCenter<>(0,0,2);
        volvoServiceCenter = new AutoServiceCenter<>(0,0,3);

        Trailer trailer = new Trailer(0,0,0, 2,125,0,true, Color.GREEN,8);
        Volvo240 volvo1 = new Volvo240(10,10,0,4,125,0,false, Color.BLUE);
        Volvo240 volvo2 = new Volvo240(1,1,0, 4,125,0,false, Color.BLUE);
        Saab95 saab = new Saab95(1,1,0, 2,100,0,false, Color.BLUE);
        carServiceCenter.addCar(trailer);
        carServiceCenter.addCar(saab);
        //volvoServiceCenter.addCar(saab);
        //saab kan inte läggas till i volvoServiceCenter, ger statiskt fel


    }


}