import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {

    /**
     * Creates a BufferedImage from a specified filepath
     * @param fileDirectory The file directory relative to Main.java
     * @return BufferedImage
     */
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
}
