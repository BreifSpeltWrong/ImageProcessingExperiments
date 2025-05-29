package Filters;

import java.awt.image.BufferedImage;

public class Meanfilter extends Filter {

    private int kernalsize;

    public Meanfilter(int kernalsize){
        this.kernalsize = kernalsize;
    }

    @Override
    public BufferedImage filterImage(BufferedImage inputImage) {
        BufferedImage newImage = new BufferedImage(inputImage.getWidth(),inputImage.getHeight(),BufferedImage.TYPE_INT_RGB);

        //Goes through Pixel by pixel
        for(int x = 0; x < newImage.getWidth(); x++){
            for(int y = 0; y < newImage.getHeight(); y++){

                int[][] kernal= new int[kernalsize][kernalsize];
                int r = 0, g =0, b = 0;

                //Searches a <kernalsize> Grid arround the pixel
                int searchSize = kernalsize/2;
                for(int q = -searchSize; q <= searchSize; q++){
                    for(int v = -searchSize; v <= searchSize; v++){

                        //Stores the RGB data of the pixel or 0 if it's not there
                        int sq = searchSize + q;
                        int sv = searchSize + v;

                        try{
                            kernal[sq][sv] = inputImage.getRGB(x+q,y+v);
                        }catch (ArrayIndexOutOfBoundsException aE){
                            kernal[sq][sv] = 0;
                        }

                        //Sums the R G and B values
                        r += (kernal[sq][sv] >> 16) & 0xFF;
                        g += (kernal[sq][sv] >> 8) & 0xFF;
                        b +=  kernal[sq][sv] & 0xFF;
                    }
                }

                // divided the R G and B values by the gridsize and reformats it
                int kerSqr = kernalsize*kernalsize;
                int newRGB = ((r/kerSqr) << 16) + ((g/kerSqr) << 8) + ((b/kerSqr));

                newImage.setRGB(x,y, newRGB);
            }
        }

        return newImage;
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

    /**
     * Sets any bonus arguments required
     *
     * @param bonusArgs
     */
    @Override
    public void setBonusArgs(String[] bonusArgs) {

    }

}
