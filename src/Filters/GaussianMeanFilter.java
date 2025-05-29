package Filters;

import utilities.GaussianDistribution;
import java.awt.image.BufferedImage;

public class GaussianMeanFilter extends Filter {
    private int kernalsize;
    GaussianDistribution gaussian = new GaussianDistribution();

    public GaussianMeanFilter(double sigma){
        gaussian.createDistributionFromStDev(0,sigma);
        this.kernalsize = (int) sigma*2;
    }

    @Override
    public BufferedImage filterImage(BufferedImage inputImage) {
        BufferedImage newImage = new BufferedImage(inputImage.getWidth(),inputImage.getHeight(),BufferedImage.TYPE_INT_RGB);

        //Goes through Pixel by pixel
        for(int x = 0; x < newImage.getWidth(); x++){
            for(int y = 0; y < newImage.getHeight(); y++){
                int[][] kernel= new int[kernalsize][kernalsize];
                int r = 0, g =0, b = 0;
                double sumWeights = 0;

                //Searches a <kernalsize> Grid arround the pixel
                int searchSize = kernalsize/2;
                for(int q = -searchSize; q <= searchSize; q++){
                    for(int v = -searchSize; v <= searchSize; v++){

                        //Stores the RGB data of the pixel or 0 if it's not there
                        int sq = searchSize + q;
                        int sv = searchSize + v;
                        try{
                            kernel[sq][sv] = inputImage.getRGB(x+q,y+v);
                        }catch (ArrayIndexOutOfBoundsException aE){
                            kernel[sq][sv] = 0;
                        }

                        double weight = gaussian.get2DValue(q,v)*10;

                        //Sums the R G and B values
                        r += (int) (((kernel[sq][sv] >> 16) & 0xFF)*weight);
                        g += (int) (((kernel[sq][sv] >> 8) & 0xFF)*weight);
                        b += (int) ((kernel[sq][sv] & 0xFF)*weight);
                        sumWeights += weight;
                    }
                }

                // divided the R G and B values by the gridsize and reformats it
                int newRGB = ((int)(r/sumWeights) << 16) + ((int)(g/sumWeights) << 8) + ((int)(b/sumWeights));

                newImage.setRGB(x,y, newRGB);
            }
        }

        return newImage;
    }

    @Override
    public String getName() {
        return "GaussianFilter";
    }

    @Override
    public String getDesc() {
        return "";
    }

    @Override
    public String[] getBonusArgs() {
        return new String[0];
    }

    @Override
    public void setBonusArgs(String[] bonusArgs) {}
}
