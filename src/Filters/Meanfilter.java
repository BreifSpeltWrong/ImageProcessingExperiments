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
        for(int x = 0; x < newImage.getWidth(); x++){
            for(int y = 0; y < newImage.getHeight(); y++){
                int[][] kernal= new int[kernalsize][kernalsize];
                int r = 0, g =0, b = 0;

                for(int q = -1; q <= 1; q++){
                    for(int v = -1; v <= 1; v++){
                        try{
                            kernal[1+q][1+v] = inputImage.getRGB(x+q,y+v);
                        }catch (ArrayIndexOutOfBoundsException aE){
                            kernal[1+q][1+v] = 0;
                        }

                        System.out.print(kernal[1+q][1+v] + "\t");

                        r = (kernal[1+q][1+v] >> 16) & 0xFF;
                        g = (kernal[1+q][1+v] >> 8) & 0xFF;
                        b =  kernal[1+q][1+v] & 0xFF;

                        System.out.println(r + "\t" + g + "\t" + b);
                    }
                }

                int kerSqr = kernalsize*kernalsize;
                int newRGB = ((r/kerSqr) << 16) + ((g/kerSqr) << 16) + ((b/kerSqr));

                System.out.println(newRGB);

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
