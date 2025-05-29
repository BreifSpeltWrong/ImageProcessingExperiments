import Filters.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DebugNTest {


    public static void main(String[] args){
        //The Filter being tested, Change to approach filter
        Filter testfilter = new GaussianMeanFilter(3);

        //Opens the Test image dir
        File testDir = new File("Test Images/");
        File[] files = testDir.listFiles();
        assert files != null;

        //Goes through all the files in the test images folder and create a before and after frame for the filter
        for(File f : files){
            try {
                JFrame frame = new JFrame(testfilter.getName() + " " + f.getName());
                frame.setLayout(new GridLayout(1,2));
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                BufferedImage img = ImageIO.read(f);
                BufferedImage filterImg = testfilter.filterImage(img);

                JLabel preImg = new JLabel(new ImageIcon(img));
                JLabel postImg = new JLabel(new ImageIcon(filterImg));

                frame.add(preImg);
                frame.add(postImg);

                frame.setSize(2*img.getWidth(), img.getHeight());

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((int)(Math.random() * screenSize.width/2), (int)(Math.random() * screenSize.height/2));
                frame.pack();
                frame.setVisible(true);
            } catch (IOException e) {
                System.err.println("Error on Img");
            }
        }

    }

}
