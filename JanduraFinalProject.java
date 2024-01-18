import javafx.application.Application; // import javaFX controls
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/** Charles Jandura
 *  Computer Science 2
 *  Slot Machine Final Project
 */

public class JanduraFinalProject extends Application {
   
   // private variables used to manipulate the gui on button click
   private TextField inputBet;
   private Label betLabel;
   private Label winningsLabel;
   private Label outputLabel;
   private ImageView imageView1;
   private ImageView imageView2;
   private ImageView imageView3;
   
   // image files used in start and setImages
   Image appleImage = new Image("file:Apple.png");
   Image bananaImage = new Image("file:Banana.png");
   Image cherryImage = new Image("file:Cherries.png");
   Image grapesImage = new Image("file:Grapes.png");
   Image lemonImage = new Image("file:Lemon.png");
   Image limeImage = new Image("file:Lime.png");
   Image orangeImage = new Image("file:Orange.png");
   Image pearImage = new Image("file:Pear.png");
   Image strawberryImage = new Image("file:Strawberry.png");
   Image watermelonImage = new Image("file:Watermelon.png");
   Image blankImage = new Image("file:BlankFruit.png");
   
   // create a new player object
   JanduraPlayer player = new JanduraPlayer();
      
    /** main function used to launch application
        no @param
        no @return
    */
    public static void main(String[]args) {
       
        launch(args); // launch application

    }
    
    /** override the start method from Application
        @param primaryStage
        no @return
    */
    @Override
    public void start(Stage primaryStage) {
      
      // create the ImageView components.
      imageView1 = new ImageView(cherryImage);
      imageView2 = new ImageView(cherryImage);
      imageView3 = new ImageView(cherryImage);
      
      // resize the images, preserving their aspect ratio.
      imageView1.setFitWidth(200);
      imageView1.setPreserveRatio(true);
      imageView2.setFitWidth(200);
      imageView2.setPreserveRatio(true);
      imageView3.setFitWidth(200);
      imageView3.setPreserveRatio(true);
      
      // create winnings and bet labels
      winningsLabel = new Label();
      betLabel = new Label();
      outputLabel = new Label();
      
      // create playButton
      Button playButton = new Button("Spin The Machine");
      playButton.setOnAction(new PlayButtonHandler());
      
      // create inputBet TextField
      inputBet = new TextField("Input Bet");
      
      // put the imageviews in an hbox with 10 pixels spacing, set padding and center
      HBox imageHbox = new HBox(10,imageView1, imageView2, imageView3);
      imageHbox.setPadding(new Insets(30));
      imageHbox.setAlignment(Pos.CENTER);
      
      // put the labels in an hbox with 10 pixels spacing, set padding and center
      HBox labelHbox = new HBox(10, winningsLabel, betLabel);
      labelHbox.setPadding(new Insets(30));
      labelHbox.setAlignment(Pos.CENTER);
      
      // put the inputBet textfield and playButton in an hbox with 5 pixels spacing and center
      HBox inputHbox = new HBox(5, inputBet, playButton);
      inputHbox.setAlignment(Pos.CENTER);
      
      // create a new vbox, place hbox's into and center
      VBox vbox = new VBox(outputLabel, imageHbox, labelHbox, inputHbox);
      vbox.setPadding(new Insets(10));
      vbox.setAlignment(Pos.CENTER);
      
      // create a scene with the vbox in it
      Scene scene = new Scene(vbox);
      
      // set the scene in the stage, give it a title, width, and height, and show
      primaryStage.setScene(scene);
      primaryStage.setTitle("Slot Machine");
      primaryStage.setWidth(650);
      primaryStage.setHeight(500);
      primaryStage.show();   
    
    }
    
    /** EventHandler class used to run actions on button click
        no @param
        no @return
    */
    class PlayButtonHandler implements EventHandler<ActionEvent> {
      
      /** Override the handle method from EventHandler
          @param event
          no @return
      */
      @Override
      public void handle(ActionEvent event)
      {
         
         // try statement used for validation
         try {
            
            Double bet = Double.parseDouble(inputBet.getText()); // parse inputBet text field for a double and store it in bet
            
            // if good data then run player.placeBet, setImages, and update our labels
            if (validateInput(bet)) {
               player.placeBet(bet);
               setImages();
               betLabel.setText(String.format("Total Bet: $%.2f", player.getBet()));
               winningsLabel.setText(String.format("Total Won: $%.2f", player.getWinnings()));
               outputLabel.setText(String.format("You won $%.2f!", player.getRoundWinnings()));
            
            // give output for bad data
            } else {
            
            outputLabel.setText("Invalid input. Please enter a number greater than 0.");
            }
            
         }
         
         // catch NumberFormatException in the case of letters being entered and give output
         catch (NumberFormatException e) {
         
            outputLabel.setText("Invalid input. Please enter a number greater than 0.");
            
         }
         
         // finally reset the inputBet text field
         finally {
         
            inputBet.setText("");
         
         }
         
      }
      
   }
   
   /** method used to validata input data
       @param bet
       @return boolean
   */
   public boolean validateInput(double bet) {
      
      // if better is greater than 0 return true, else false
      if (bet > 0)
         return true;
      return false;
   
   }
   
   /** method used to setImages based on randomly generated numbers from JanduraSlotMachine
       no @param
       no @return
   */
   public void setImages() {
       
       // switch statement that sets imageView1 to the appropriate image based on player.firstImage
       switch(player.getImage1()) {
       
         case 1 : imageView1.setImage(appleImage);
                  break;
         case 2 : imageView1.setImage(bananaImage);
                  break;
         case 3 : imageView1.setImage(cherryImage);
                  break;
         case 4 : imageView1.setImage(grapesImage);
                  break;
         case 5 : imageView1.setImage(lemonImage);
                  break;
         case 6 : imageView1.setImage(limeImage);
                  break;
         case 7 : imageView1.setImage(orangeImage);
                  break;
         case 8 : imageView1.setImage(pearImage);
                  break;
         case 9 : imageView1.setImage(strawberryImage);
                  break;
         case 10 : imageView1.setImage(watermelonImage);
                   break;
         default : imageView1.setImage(blankImage);
          
       }
       
       // switch statement that sets imageView2 to the appropriate image based on player.secondImage
       switch(player.getImage2()) {
       
         case 1 : imageView2.setImage(appleImage);
                  break;
         case 2 : imageView2.setImage(bananaImage);
                  break;
         case 3 : imageView2.setImage(cherryImage);
                  break;
         case 4 : imageView2.setImage(grapesImage);
                  break;
         case 5 : imageView2.setImage(lemonImage);
                  break;
         case 6 : imageView2.setImage(limeImage);
                  break;
         case 7 : imageView2.setImage(orangeImage);
                  break;
         case 8 : imageView2.setImage(pearImage);
                  break;
         case 9 : imageView2.setImage(strawberryImage);
                  break;
         case 10 : imageView2.setImage(watermelonImage);
                   break;
         default : imageView2.setImage(blankImage);
          
       } 
       
       // switch statement that sets imageView3 to the appropriate image based on player.thirdImage
       switch(player.getImage3()) {
       
         case 1 : imageView3.setImage(appleImage);
                  break;
         case 2 : imageView3.setImage(bananaImage);
                  break;
         case 3 : imageView3.setImage(cherryImage);
                  break;
         case 4 : imageView3.setImage(grapesImage);
                  break;
         case 5 : imageView3.setImage(lemonImage);
                  break;
         case 6 : imageView3.setImage(limeImage);
                  break;
         case 7 : imageView3.setImage(orangeImage);
                  break;
         case 8 : imageView3.setImage(pearImage);
                  break;
         case 9 : imageView3.setImage(strawberryImage);
                  break;
         case 10 : imageView3.setImage(watermelonImage);
                   break;
         default : imageView3.setImage(blankImage);
          
       } 
   
   }

}

/** Test Cases - Results
    -1 - invalid
    a - invalid
    asdfghjkl - invalid
    blank - invalid
    1 - wins $3 and 4$
    100 - wins $300 and $400
    500 - wins $1500 and $2000
    1234 - wins $3702 and $4936
    loss - gives $0
    2 matching - bet * 3.0
    3 matching - bet * 4.0
    100, 100, 100, 100, 100, 100, 100 - Total Won: $600.00, Total Bet: $700.00

*/