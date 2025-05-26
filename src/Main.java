/**
 * @author Al
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0 || args.length == 1) {
            tooFewArguments();
        } else {
            processImage(args[0], args[1]);
        }
    }

    public static void tooFewArguments()  {
        System.err.println("Missing file location and filters");
    }

    public static void processImage(String fileLoc, String filter){
    }

}