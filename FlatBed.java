public class FlatBed {
    private int angle;
    private int maxAngle;

    public FlatBed(int angle, int maxAngle){
        this.angle = angle;
        this.maxAngle = maxAngle;
    }

    public int getAngle(){return angle;}

    public boolean isFlatbedReady() {
        if (angle == 0) {
            return true;
        }
        return false;
    }

    public void raiseAngle(int amount){
            if (angle + amount < maxAngle) {
                angle = angle + amount;
            }
        }

    public void decreaseAngle(int amount){
            if (angle - amount > 0) {
                angle = angle - amount;
            }
        }
    }
