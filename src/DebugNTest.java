import Filters.Meanfilter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DebugNTest {

    //For some reason the import wasn't working, so I pasted FTM
    public static BufferedImage readFileAsImage(String fileDirectory){
        BufferedImage returnImage = new BufferedImage(1,1, BufferedImage.TYPE_INT_ARGB);
        try{
            File input_file = new File(fileDirectory);

            // image file path create an object of
            // BufferedImage type and pass as parameter the
            // width,  height and image int
            // type. TYPE_INT_ARGB means that we are
            // representing the Alpha , Red, Green and Blue
            // component of the image pixel using 8-bit
            // integer value.

            // Reading input file
            returnImage = ImageIO.read(input_file);

            System.out.println(fileDirectory + " read successfully as image.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return returnImage;
    }

    public static void main(String[] args){
        Meanfilter Meanfilter = new Meanfilter(3);
        DebugNTest dnt = new DebugNTest();

        BufferedImage bf = readFileAsImage("Test Images/Test Img 1.png");
        dnt.displayImage(bf);
        BufferedImage bf2 = Meanfilter.filterImage(bf);
        dnt.displayImage(bf2);
    }

    public void displayImage(BufferedImage img){
        //displays the image
        //stolen from a tutorial
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        frame.setSize(img.getWidth(), img.getHeight());
        label.setIcon(new ImageIcon(img));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
