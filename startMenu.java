//Start menu
//import necessary packages with javaFX
import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.geometry.Orientation; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.TilePane; 
import javafx.stage.Stage;
import java.awt.Component;
import javafx.geometry.*;

public class startMenu extends Application
{
   //set here so pane doesn't change?
   int paneWidth = 650;
   int paneHeight = 650;
   public void start(Stage stage)
   {
      //create application window(pane)
      TilePane window = new TilePane(Orientation.VERTICAL);
      //set size of window
      window.setPrefSize(paneWidth, paneHeight);
      //set color
      window.setStyle("-fx-background-color:deepskyblue");
      
      
      //padding insets to center
      //insets = (top, right, bottom, left)
      window.setPadding(new Insets(30, 200, 20, 200));
      //set vgap = pace between rows
      window.setVgap(10);
      
      
      //add title - create label
      Label title = new Label("GAME TITLE FOR SOMEONE TO COME UP WITH");
      //add title to window
      window.getChildren().addAll(title);
      title.setTextAlignment(TextAlignment.CENTER);
      
      //create buttons
      String startString = "START BUTTON";
      Button startButton = new Button(startString);
      //this button will have to hold some sort of memory, right?
      Button loadButton = new Button("LOAD GAME");
      
      //set size of buttons
      startButton.setMinWidth(125);
      startButton.setMinHeight(75);
      
      loadButton.setMinWidth(125);
      loadButton.setMinHeight(75);
      
      startButton.setStyle("-fx-text-fill: black");
      loadButton.setStyle("-fx-text-fill: black");
      
      startButton.setTextAlignment(TextAlignment.CENTER);
      loadButton.setTextAlignment(TextAlignment.CENTER);
      window.getChildren().add(startButton);
      window.getChildren().add(loadButton);
      
      window.setHgap(10);
      
      Scene scene = new Scene(window, paneWidth, paneHeight);
      
      //show everything
      stage.setScene(scene);
      stage.setTitle("START MENU");
      stage.show();
      
   }
   public static void main(String[] args)
   {
      launch(args);
   }

}