import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Edge_detect {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String filename = "D:\\Coding\\java\\IntelliJ\\OpenCV\\Pre_Canny.jpg"; // INSERT ORIGINAL FILE PATH HERE
        Mat orig = Imgcodecs.imread(filename);


        Mat grayscale = new Mat();
        Mat final_img = new Mat();

        Imgproc.cvtColor(orig, grayscale, Imgproc.COLOR_RGB2GRAY);
        Imgproc.Canny(grayscale,final_img,50,150,3,false);
        final_img.convertTo(final_img, CvType.CV_8U);

        // Download the Image
        String final_filename = "D:\\Coding\\java\\IntelliJ\\OpenCV\\Post_Canny.jpg"; // INSERT FINAL FILE PATH HERE
        Imgcodecs.imwrite(final_filename,final_img);
        System.out.println("Saved!!!!!!!!!!!");
    }
}
