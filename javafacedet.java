package com.jfacedetection;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

public class javafacedet {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.out.println("hello hi");
		
		String image="images/31.jpg";
		Mat src= Imgcodecs.imread(image);
		String xmlfile="xml/lbpcascade_frontalface.xml";
		CascadeClassifier cc = new CascadeClassifier(xmlfile);
		MatOfRect facedetection = new MatOfRect();
		cc.detectMultiScale(src, facedetection);
		System.out.println(String.format("detected faces:%d", facedetection.toArray().length));
		
		for(Rect rect: facedetection.toArray()) {
			Imgproc.rectangle(src, new Point(rect.x , rect.y),new Point( rect.x + rect.width, rect.y + rect.height) , new Scalar(0,0,255),3);
			
		}
		
		Imgcodecs.imwrite("images/saved.jpg",src);
		System.out.println("work done");
		
		//sketching app backend code
		
		String images="images/objects.jpg";
		Mat source= Imgcodecs.imread(images);
		Mat destination1 = new Mat();
		Imgproc.cvtColor(source, destination1, Imgproc.COLOR_RGB2GRAY);
		Imgcodecs.imwrite("images/gray.jpg", destination1);
		Mat destination2 = new Mat();
		Imgproc.GaussianBlur(destination1, destination2, new Size(15, 15), 0);
		Imgcodecs.imwrite("images/guassian.jpg", destination2);
		Mat destination3 = new Mat();
		int threshold=10;
		Imgproc.Canny(destination2, destination3, threshold, threshold * 7, 3, false);
		Imgcodecs.imwrite("images/canny.jpg", destination3);
		Mat destination4 = new Mat();
		Core.bitwise_not(destination3, destination4 );
		Imgcodecs.imwrite("images/final.jpg", destination4);
	}

}
