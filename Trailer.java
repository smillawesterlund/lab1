public class Trailer implements Movable{
    private final Scania scania;
    private boolean ramp;

    public Trailer(double x, double y, int direction) {
        scania = new Scania(x,y,direction);
        ramp = false;
    }

    public void openRamp(){
        if(scania.getCurrentSpeed()==0){ramp = true;}
    }
    public void closeRamp(){ramp = false;}
    public boolean getRamp(){return ramp;}


    @Override
    public void move() {
        scania.move();
    }

    @Override
    public void turnLeft() {
        scania.turnLeft();
    }

    @Override
    public void turnRight() {
        scania.turnRight();
    }


}
