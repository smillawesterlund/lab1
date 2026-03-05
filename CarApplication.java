public class CarApplication {
    public static void main(String[] args) {

        Simulation sim = new Simulation();
        CarController cc = new CarController(sim);
        CarView view = new CarView("CarSim 1.0", cc);

        sim.addObserver(view.getDrawPanel());
        cc.start();



    }
}
