class CircleCalculations{

	public static double calculateArea(int radius){
		return Math.pow(radius, 2) * Math.PI;
	}

	public static double calculateCircumference(int radius){
		return 2 * Math.PI * radius;
	}
}

import CircleCalculations;

public class ShowCircleData{
	public static void main(String[] args){
		CircleCalculations foo = new CircleCalculations();

		System.out.printf("The area of a circle with a radius of 9 is: %d.", foo.calculateArea(9));
		System.out.printf("The circumference of a circle with a radius of 13 is: %d.", foo.calculateCircumference(13));
	}
}

