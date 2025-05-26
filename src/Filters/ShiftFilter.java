package Filters;

import java.awt.image.BufferedImage;

public class ShiftFilter extends Filter{
    /**
     * Filters the input image to return a shifted image.
     *
     * @param inputImage The image to be filtered. This image should be preserved and not edited.
     * @return The edited image
     */
    @Override
    public BufferedImage filterImage(BufferedImage inputImage) {
        return null;
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
        return new String[0];
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
