public class GaussianDistribution extends Distribution{

    /*
    Gaussian Distribution:
    v = variance
    s = sqrt(variance)
    m = mean
    x = input
    PDF
    (1/(s*sqrt(2*pi)))*(e^((-(x-m)^(2))/(2v)))


    lhsNonInverted:     a = s*sqrt(2*pi)
    eExponentNumerator  b = -(x-m)^2
    eExponentDenom      c = 2v
    lhs                 d = 1/a
    eExpo               g = b/c
    eRes                h = e^g
     */

    private double mean;
    private double variance;

    public static double getGaussianFromDistribution(double mean, double variance, double n){
        return (1/(Math.sqrt(variance)*Math.sqrt(2*Math.PI)))*(Math.pow(Math.E,(-Math.pow((n-mean),2))/(2*variance)));
    }

    @Override
    public double getValue(double n) {
        return 0;
    }

    @Override
    public double get2DValue(double x, double y) {
        return 0;
    }
}
