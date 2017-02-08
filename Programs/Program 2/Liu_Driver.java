/***************************************************************
 * file: Liu_Decoder.java
 * author: B. Liu
 * class: CS 141 - Programming and Problem Solving
 *
 * assignment: program 2
 * date last modified: 12 - January - 2017
 *
 * purpose: to create a septerate class which will do the math part
 * of calculating the area of either a circle, triangle, or rectangle
 * of which we will call upon in a different class. we will recieve input
 * from the scanner object, manipulated by the user on the console. they
 * will input the dimensions of said shape and which the class of the
 * respective shape will be called upon to calculate the area and returned
 * to the user.
 *
 ****************************************************************/
import java.util.*;

class Liu_Geometry{
	
	// method: AreaCircle
    // purpose: this method takes in int radius and returns double area of the circle
	// @param radius radius of the circle -- input from user
    public static double AreaCircle(int radius){
        return Math.PI * Math.pow(radius, 2);
    }

	// method: AreaRectangle
    // purpose: this method takes in the params length and width and returns the area
	// @param length length of the rectangle -- input from user
	// @param width width of the rectangle -- input from user
    public static double AreaRectangle(int length, int width){
        return length * width;
    }

	// method: AreaTriangle
    // purpose: this method takes in the param of the base and height and outputs the area
	// @param base base of the triangle -- input from user
	// @param height height of the triangle -- input from user
    public static double AreaTriangle(int base, int height){
        return base * height * 0.5;
    }
}

public class Liu_Driver {

    // method: main
    // purpose: runs the ask method
    public static void main(String[] args){
        ask();
    }

    // method: ask
    // purpose: this method asks the user if they want to calculate the area of a 
    // rectangle, triangle, or circle. then user inputs the appropriate dimensions of
	// said shape and outputs the area. this will cycle until the user force quits or 
	// inputs "4"
    public static void ask(){
        System.out.println("");
        System.out.println("Geometry Calculator");
        System.out.println("1. Calculate the Area of a Circle");
        System.out.println("2. Calculate the Area of a Rectangle");
        System.out.println("3. Calculate the Area of a Triangle");
        System.out.println("4. Quit");
        System.out.println("");
        System.out.print("Enter your choice (1-4): ");

        try{
            Scanner console = new Scanner(System.in);
            int choice = console.nextInt();

            while (true){
                if (choice == 1){
                    int radiusCircle = 0;

                    System.out.println("");
                    System.out.print("Enter the radius of the circle: ");
                    radiusCircle = console.nextInt();
					
					while (radiusCircle < 0){
						System.out.println("The radius you have inputted is not a positive integer. Please try again.");
						System.out.print("Enter the radius of the circle: ");
						radiusCircle = console.nextInt();
					}
					
                    System.out.println("");
                    System.out.printf("The area of the circle is: %.2f%n", areaCircle(radiusCircle));

                    choice = 1234;
                }
                else if (choice == 2){
                    int lengthRectangle, widthRectangle = 0;

                    System.out.println("");
                    System.out.print("Enter the length of the rectangle: ");
                    lengthRectangle = console.nextInt();
					
					while (lengthRectangle < 0){
						System.out.println("The length you have inputted is not a positive integer. Please try again.");
						System.out.print("Enter the length of the rectangle: ");
						lengthRectangle = console.nextInt();
					}
					
                    System.out.print("Enter the width of the rectangle: ");
                    widthRectangle = console.nextInt();
					
					while (widthRectangle < 0){
						System.out.println("The width you have inputted is not a positive integer. Please try again.");
						System.out.print("Enter the width of the rectangle: ");
						widthRectangle = console.nextInt();
					}
					
                    System.out.println("");
                    System.out.printf("The area of the rectangle is: %.2f%n", areaRectangle(lengthRectangle, widthRectangle));

                    choice = 1234;
                }
                else if (choice == 3){
                    int baseTriangle, heightTriangle = 0;

                    System.out.println("");
                    System.out.print("Enter the base of the triangle: ");
                    baseTriangle = console.nextInt();
					
					while (baseTriangle < 0){
						System.out.println("The base you have inputted is not a positive integer. Please try again.");
						System.out.print("Enter the base of the triangle: ");
						baseTriangle = console.nextInt();
					}
					
                    System.out.print("Enter the height of the triangle: ");
                    heightTriangle = console.nextInt();
					
					while (heightTriangle < 0){
						System.out.println("The height you have inputted is not a positive integer. Please try again.");
						System.out.print("Enter the height of the triangle: ");
						heightTriangle = console.nextInt();
					}
					
                    System.out.println("");
                    System.out.printf("The area of the triangle is: %.2f%n", areaTriangle(baseTriangle, heightTriangle));

                    choice = 1234;
                }
                else if (choice == 4){
                    System.exit(1);
                }
                else if(choice == 1234){
                    System.out.println("");
                    System.out.println("Geometry Calculator");
                    System.out.println("1. Calculate the Area of a Circle");
                    System.out.println("2. Calculate the Area of a Rectangle");
                    System.out.println("3. Calculate the Area of a Triangle");
                    System.out.println("4. Quit");
                    System.out.println("");
                    System.out.print("Enter your choice (1-4): ");

                    choice = console.nextInt();
                }
                else{
                    System.out.println("Incorrect Choice, please try again.");
					
					choice = 1234;
                }
            }
        } catch (Exception e) {
            System.out.println("Did not enter integer, please try again.");
        }
    }

    // method: areaCircle
    // purpose: this method calculates the area of the circle by calling the Geometry class
    // @param radius radius of the circle -- input from user
    public static double areaCircle(int radius){
        return Liu_Geometry.AreaCircle(radius);
    }

    // method: areaRectangle
    // purpose: this method calculates the area of the rectangle by calling the Geometry class
    // @param length length of the rectangle -- input from user
    // @param width width of the rectangle -- input from user
    public static double areaRectangle(int length, int width){
        return Liu_Geometry.AreaRectangle(length, width);
    }

    // method: areaTriangle
    // purpose: this method calculates the area of the triangle by calling the Geometry class
    // @param base base of the triangle -- input from user
    // @param height height of the triangle -- input from user
    public static double areaTriangle(int base, int height){
        return Liu_Geometry.AreaTriangle(base, height);
    }
}
