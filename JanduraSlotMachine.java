import java.util.Random; // import random 

/** Charles Jandura
 *  Computer Science 2
 *  Slot Machine Final Project
 */
 
 /** class used to control Slot Machine logic
  *  inherited by JanduraPlayer
  *  implements JanduraSpinMachine
 */
public class JanduraSlotMachine implements JanduraSpinMachine {
      
      private int firstImage;
      private int secondImage;
      private int thirdImage;
   
    
    /** protected class that generates the 'images'
     *  @param nothing
     *  @return nothing
     */
    protected void spinMachine() {

        // create new random object
        Random rand = new Random();       
        
        // generate three random numbers from 1 to 10 and stores them
        firstImage = rand.nextInt(1, 10);
        secondImage = rand.nextInt(1, 10);
        thirdImage = rand.nextInt(1, 10);

    }

    /** protected method used to compare the generates images and return winnings
     *  @param double bet
     *  @return double bet * appropriate value
     */
    protected double compareImages(double bet) {

        // generate images
        spinMachine();

        // if statement block that compares the image variables and returns the appropriate amount of winnings
        if (firstImage == secondImage && firstImage == thirdImage) {
            return bet * 4.0;
        } else if (firstImage == secondImage || firstImage == thirdImage || secondImage == thirdImage) {
            return bet * 3.0;
        } else{
            return 0.0;
        }
    }
    
    /** getter method used to return firstImage
        no @param
        @return firstImage
    */
    public int getImage1() {
      
      return firstImage;
    
    }
    
    /** getter method used to return firstImage
        no @param
        @return secondImage 
    */
    public int getImage2() {
      
      return secondImage;
    
    }
    
    /** getter method used to return firstImage
        no @param
        @return thirdImage
    */
    public int getImage3() {
      
      return thirdImage;
    
    }

}


    