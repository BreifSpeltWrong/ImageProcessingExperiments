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

    public void createDistributionFromStDev(double meu, double sigma) {
        mean = meu;
        variance = Math.pow(sigma,2);
    }
    public void createDistributionFromVariance(double meu, double sigmaSquared) {
        mean = meu;
        variance = sigmaSquared;
    }

    private double getGaussianFromDistribution(double meu, double sigmaSquared, double n){ 
        return (1/(Math.sqrt(sigmaSquared)*Math.sqrt(2*Math.PI)))*(Math.pow(Math.E,(-Math.pow((n-meu),2))/(2*sigmaSquared))); // G(x): Probability Density Function, taking the mean as the origin
    }

    @Override
    public double getValue(double x) {
        return getGaussianFromDistribution(mean, variance, x);
    }

    @Override
    public double get2DValue(double x, double y) {
        return getValue(x)*getValue(y); // G(x,y) = G(x)*G(y), big formula unnecessary
    }
}
