package Filters;

import java.awt.image.BufferedImage;

public class Meanfilter extends Filter {

    public Meanfilter(){

    }

    @Override
    public BufferedImage filterImage(BufferedImage inputImage) {
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
