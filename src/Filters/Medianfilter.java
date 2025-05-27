package Filters;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Medianfilter extends Filter {

    private int kernalsize;

    public Medianfilter(int kernalsize){
        this.kernalsize = kernalsize;
    }

    @Override
    public BufferedImage filterImage(BufferedImage inputImage) {
        BufferedImage newImage = new BufferedImage(inputImage.getWidth(),inputImage.getHeight(),BufferedImage.TYPE_INT_RGB);

        int kerSqr = kernalsize*kernalsize;

        //Goes through Pixel by pixel
        for(int x = 0; x < newImage.getWidth(); x++){
            for(int y = 0; y < newImage.getHeight(); y++){

                int[][] kernal= new int[kernalsize][kernalsize];
                int[] r = new int[kerSqr], g  = new int[kerSqr], b = new int[kerSqr];

                //Searches a <kernalsize> Grid arround the pixel
                int searchSize = kernalsize/2;
                for(int q = -searchSize; q <= searchSize; q++){
                    for(int v = -searchSize; v <= searchSize; v++){

                        int sq = searchSize + q;
                        int sv = searchSize + v;

                        //Stores the RGB data of the pixel or 0 if it's not there
                        try{
                            kernal[sq][sv] = inputImage.getRGB(x+q,y+v);
                        }catch (ArrayIndexOutOfBoundsException aE){
                            kernal[sq][sv] = 0;
                        }

                        int i = (sq) * kernalsize + searchSize + v;

                        //stores the r g and b in sperate arrays
                        r[i] = (kernal[sq][sv] >> 16) & 0xFF;
                        g[i] += (kernal[sq][sv] >> 8) & 0xFF;
                        b[i] +=  kernal[sq][sv] & 0xFF;
                    }
                }
                Arrays.sort(r);
                Arrays.sort(g);
                Arrays.sort(b);

                // divided the R G and B values by the gridsize and reformats it
                int newRGB = ((r[r.length/2]) << 16) + ((g[g.length/2]) << 8) + ((b[b.length/2]));

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

}
