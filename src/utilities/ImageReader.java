package utilities;

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

    public static int writeImageAsFile(BufferedImage image, String outputFileLocation){
        try {
            String extension = "png";

            int dotIndex = outputFileLocation.lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < outputFileLocation.length() - 1) {
                extension = outputFileLocation.substring(dotIndex + 1);
            } else if (outputFileLocation.charAt(outputFileLocation.length() - 1) != '.'){
                outputFileLocation += ".png";
            } else {
                outputFileLocation += "png";
            }
            
            // Output file path
            File outputFile = new File(outputFileLocation);


            // Writing to file taking type and path as
            ImageIO.write(image, extension, outputFile);

            System.out.println("Writing complete.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return 0;
    }
}
