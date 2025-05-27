package Filters;

import java.awt.image.BufferedImage;

public class ShiftFilter extends Filter{

    private int xOffset = 25;
    private int yOffset = 25;

    public ShiftFilter(int xOff, int yOff){
        xOffset = xOff;
        yOffset = yOff;
    }

    /**
     * Filters the input image to return a shifted image.
     *
     * @param inputImage The image to be filtered. This image should be preserved and not edited.
     * @return The edited image
     */
    @Override
    public BufferedImage filterImage(BufferedImage inputImage) {
        BufferedImage returnImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), inputImage.getType());
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        for(int x = 0; x < returnImage.getWidth(); x++) {
            for (int y = 0; y < returnImage.getHeight(); y++) {
                returnImage.setRGB((x+xOffset)%width, (y+yOffset)%height, inputImage.getRGB(x, y));
            }
        }
        return returnImage;
    }

    /**
     * Returns the name of the filter in a human-readable format for display
     *
     * @return The name
     */
    @Override
    public String getName() {
        return "Horizontal Offset / Shift Filter";
    }

    /**
     * A short description of the filter, for a summary explanation of the filters effects.
     *
     * @return The description
     */
    @Override
    public String getDesc() {
        return "A filter that offsets everything n pixels to one side (and wraps around the edge of the screen)";
    }

    /**
     * The names of any bonus arguments required - This is required to be in the same order as is needed for input to the filter.
     *
     * @return An array of argument names
     */
    @Override
    public String[] getBonusArgs() {
        return new String[] {"Horizontal Offset", "Vertical Offset"};
    }

    /**
     * Sets any bonus arguments required
     *
     * @param bonusArgs The string arguments required
     */
    @Override
    public void setBonusArgs(String[] bonusArgs) {

    }

}
