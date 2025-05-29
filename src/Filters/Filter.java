package Filters;

import java.awt.image.BufferedImage;

public abstract class Filter {
    /**
     * Filters the input image to return an output.
     * @param inputImage The image to be filtered. This image should be preserved and not edited.
     * @return The edited image
     */
    public abstract BufferedImage filterImage(BufferedImage inputImage);

    /**
     * Returns the name of the filter in a human-readable format for display
     * @return The name
     */
    public abstract String getName();

    /**
     * A short description of the filter, for a summary explanation of the filters effects.
     * @return The description
     */
    public abstract String getDesc();

    /**
     * The names of any bonus arguments required - This is required to be in the same order as is needed for input to the filter.
     * @return An array of argument names
     */
    public abstract String[] getBonusArgs();

    /**
     * Sets any bonus arguments required
     */
    public abstract void setBonusArgs(String[] bonusArgs);

}
