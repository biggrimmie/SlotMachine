/** Charles Jandura
 *  Computer Science 2
 *  Slot Machine Final Project
 */

 /** 
  * Class used to control the player and slot machine classes
  * Extends JanduraSlotMachine
  */
public class JanduraPlayer extends JanduraSlotMachine {

    // variables
    private double totalWinnings;
    private double totalBet;
    private double roundWinnings;
    
    // No arg constructor used to set totalMoney, totalBet, and roundWinnings to 0
    public JanduraPlayer() {
        
        totalWinnings = 0;
        totalBet = 0;
        roundWinnings = 0;

    }

    /** setter method used to increase totalWinnings
     *  @param double x
     *  @return nothing
     */
    private void increaseWinnings(double winnings) {

        // increase totalMoney by x
        totalWinnings += winnings;

    }

    /** getter method used to recieve totalMoney value
     *  @param nothing
     *  @return double totalMoney
     */
    public double getWinnings() {

        // return totalWinnings
        return totalWinnings;

    }
    
    /** getter method used to return totalBet
        no @param
        @return totalBet
    */
    public double getBet() {
        
        // return totalBet
        return totalBet;
    
    }
    
    /** getter method used to return roundWinnings
        no @param
        @return totalWinnings
    */
    public double getRoundWinnings() {
        
        // return roundWinnings
        return roundWinnings;
         
    }
    
    /** method used to place bet
     *  @param double bet
     *  @return nothing
     */
    public void placeBet(double bet) {
        
        // keep track of total bet
        totalBet += bet;

        // run the compareImages method and store it in winnings
        double winnings = compareImages(bet);
        
        // set round winnings
        roundWinnings = winnings;

        // use increaseWinnings method to increased winnings
        increaseWinnings(winnings);

    }


}