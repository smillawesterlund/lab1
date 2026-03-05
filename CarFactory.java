import java.awt.*;
import java.util.Random;

public class CarFactory {

    private static Random rand = new Random();

    public static Car createVolvo() {
        return new Volvo240(10, 10, 1, 4, 100, 0, false, Color.GREEN, "Volvo240");
    }
    public static Car createSaab() {
        return new Saab95(10, 100, 1, 2, 125, 0, false, Color.PINK, "Saab95");
    }

    public static Car createScania() {
        return new Scania(10, 200, 1, 2, 90, 0, true, Color.RED, "Scania");
    }
    // skapar en slumpmässig bil

    public static Car createRandomCar() {
        int i = rand.nextInt(3);

        switch (i) {
            case 0:
                return createVolvo();
            case 1:
                return createSaab();
            default:
                return createScania();
        }
    }
}

