import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutoServiceCenterTest {

    AutoServiceCenter<Movable> carServiceCenter;
    AutoServiceCenter<Volvo240> volvoServiceCenter;
    AutoServiceCenter<Scania> scaniaServiceCenter;
    AutoServiceCenter<Trailer> trailerServiceCenter;

    @Test
    void addCarAndPickUpCar() {
        carServiceCenter = new AutoServiceCenter<>(2);
        volvoServiceCenter = new AutoServiceCenter<>(3);

        Trailer trailer = new Trailer(4,3,0,6);
        Volvo240 volvo1 = new Volvo240(10,10,0);
        Volvo240 volvo2 = new Volvo240(1,1,0);
        Saab95 saab = new Saab95(20,20,0);
        carServiceCenter.addCar(trailer);
        carServiceCenter.addCar(saab);
        //volvoServiceCenter.addCar(saab);
        //saab kan inte läggas till i volvoServiceCenter, ger statiskt fel


    }


}