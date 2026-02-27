import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image
    BufferedImage volvoWorkshopImage;
    BufferedImage bilmattaImage;

    private ArrayList<Car> cars = new ArrayList<>();

    Point volvoWorkshopPoint = new Point(650,380);

    public void updateCars(ArrayList<Car> cars){
        this.cars = cars;
        repaint();
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            bilmattaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/bilmatta.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bilmattaImage,0,0,null);

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        for(Car car: cars){
            int x = (int) Math.round(car.getX());
            int y = (int) Math.round(car.getY());

            g.drawImage(car.getImg(), x, y, null);
        }



    }
}
