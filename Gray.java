/*--------------------------
 *Hayden Ivatts
 *hpivat21@g.holycross.edu
 *2-19-18
 *
 *Accepts a JPEG image from the user and then converts the image into a grayscale copy of the original image. Uses luminance formula
 *to determine the shade of each pixel.
 *
 *java Gray holycross.jpg
 *
 *---------------*/

import java.awt.Color;
    
public class Gray {
    public static void main(String[] args) {
        //Tests to make sure user enters the correct amount of args, if not, display error message.
        if (args.length < 1) {
            System.out.println("Error: You have not entered the correct number of arguments. The correct format is: java Gray (name of image).jpg. Thank you, Goodbye.");
            
            System.exit(0);
        } 
        
        Picture original = new Picture (args[0]);//Takes a JPEG image input from the user
        
        //Cycles through each pixel using a nested for loop, converting each pixel to grayscale.
        for (int i = 0; i < original.width(); i++) {
            for (int j = 0; j < original.height(); j++) {
                Color pixel = original.get(i, j);//Represents individual pixel being converted
                
                double luminance = (0.299 * pixel.getRed()) + (0.587 * pixel.getGreen()) + (0.114 * pixel.getBlue());//Converts red, green, and blue intensities into one number that represents the shade of the pixel
                
                int g = (int)luminance;//Casts the double luminance, into a integer so it can be used to create a new color
                
                Color gray = new Color (g, g, g);//Creates a grayscale version of the pixel
                
                original.set(i, j, gray);//Replaces the old color pixel with the new gray pixel.
            }
        }
        
        original.save("grayscale.jpg");//Saves the new image 
        
              
                
    }//end main
}//end class Gray
            
        
