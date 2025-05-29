package utilities;

/**
 * @author Will
**/
public class Matrix {
    // Attributes
    double[][] matrixArray;
    int[] dimensions = new int[2];
    // Constructor
    Matrix(int x, int y) {
        matrixArray = new double[y][x];
        dimensions[0] = x;
        dimensions[1] = y;
    }

    // Methods
    public int[] getDimensions() {
        return dimensions;
    }
    public double get(int x, int y) {
        return matrixArray[y][x];
    }
    public void set(int x, int y, double value) {
        matrixArray[y][x] = value;
    }
    public double[] getColumn(int x) {
        double[] output = new double[dimensions[0]];
        int a = 0;
        for (double[] array:matrixArray) {
            output[a] = array[x];
            a++;
        }
        return output;
    }
    public double[] getRow(int y) {
        return matrixArray[y];
    }
    public void setValues(double[][] array2D) throws Exception {
        int x = 0;
        int y = 0;
        try{
            for (double[] array:array2D) {
                for (double value : array) {
                    matrixArray[x][y] = value;
                    y++;
                }
                x++;
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            throw new Exception(String.format("Ultilities.Matrix of size %1$ X %2$ does not allow for added values of size %3$ X %4$", dimensions[1], dimensions[0], array2D[0].length, array2D.length));
        }
    }

    
    private double dot(double[] a, double[] b) {
        double output = 0;
        for (int i=0; i<a.length; i++) {
            output += a[i]*b[i];
        }
        return output;
    }
  
    // Dev note: I know this is O(n^3), if you can do better please do it LMAO
    public Matrix dot(Matrix matrix) throws Exception {
        int[] secondMatrixDimensions = matrix.getDimensions();
        if (secondMatrixDimensions[1] != dimensions[0]) {
            throw new Exception("Cannot perform a . b where a's horizontal length is different from b's vertical length");
        }
        Matrix output = new Matrix(secondMatrixDimensions[0],dimensions[1]);
        for (int i = 0; i < dimensions[1]; i++) {
            for (int j = 0; j < secondMatrixDimensions[0]; j++) {
                output.set(i,j,dot(getRow(i),matrix.getColumn(j)));
            }
        }
        return output;
    }

}
