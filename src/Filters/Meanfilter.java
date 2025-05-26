package Filters;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class Meanfilter extends Filter {

    private int kernalsize;

    public Meanfilter(int kernalsize){
        this.kernalsize = kernalsize;
    }

    @Override
    public BufferedImage filterImage(BufferedImage inputImage) {
        Raster rawImage = inputImage.getData();
        for(int hi = 0; hi <= rawImage.getHeight(); hi++){
            for(int wi = 0; wi <= rawImage.getWidth(); wi++){
                int[] kernal = rawImage.getPixels(wi,hi,kernalsize,kernalsize,new int[] {});
            }
        }


        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getDesc() {
        return "";
    }

    @Override
    public String[] getBonusArgs() {
        return new String[0];
    }
}
