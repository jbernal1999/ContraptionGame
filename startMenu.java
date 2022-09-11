//Start menu
//import necessary packages with javaFX
import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.geometry.Orientation; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.*;
import javafx.scene.layout.*; 
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.awt.Component;
import javafx.geometry.*;
import javafx.scene.text.*;

public class startMenu extends Application
{
    public static void main(String[] args)
   {
      launch(args);
   }
   
   //set here so pane doesn't change
   int paneWidth = 650;
   int paneHeight = 650;
   
   //change stage name so there's no confusion
   Stage mainWindow;
   //create additional scene for level
   Scene level1, level2, level3, level4;
   
   public void start(Stage stage)
   {
      //change stage name
      mainWindow = stage; 
       
      //create application window(pane)
      VBox window = new VBox(10);
      //set size of window
      window.setPrefSize(paneWidth, paneHeight);
      //set color
      window.setStyle("-fx-background-color:deepskyblue");
      
      
      //padding insets to center
      //insets = (top, left, bottom, right)
      window.setPadding(new Insets(30, 250, 30, 250));
      
      //add title - create label
      Label title = new Label("STUDENT DROPOUT:)");
      //add title to window
      window.getChildren().addAll(title);
      title.setTextAlignment(TextAlignment.CENTER);
      title.setPadding(new Insets(20,0,10,0));
      //set title font
      title.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.REGULAR, 12));
      
      //create buttons
      String startString = "START BUTTON";
      Button startButton = new Button(startString);
      //this button will have to hold some sort of memory, right?
      Button loadButton = new Button("LOAD GAME");
      
      //set size of buttons
      startButton.setMinWidth(125);
      startButton.setMinHeight(50);
      loadButton.setMinWidth(125);
      loadButton.setMinHeight(50);
      
      startButton.setStyle("-fx-text-fill: black");
      loadButton.setStyle("-fx-text-fill: black");
      
      //startButton.setTextAlignment(TextAlignment.CENTER);
      //loadButton.setTextAlignment(TextAlignment.CENTER);
      startButton.setAlignment(Pos.CENTER);
      loadButton.setAlignment(Pos.CENTER);
      window.getChildren().add(startButton);
      window.getChildren().add(loadButton);
      
      //window.setHgap(10);
      
      Scene startPage = new Scene(window, paneWidth, paneHeight);
      
      //set action on start button
      startButton.setOnAction(e -> mainWindow.setScene(level1));
      
      //show everything
      mainWindow.setScene(startPage);
      mainWindow.setTitle("START MENU");
      mainWindow.show();
      
   }
}
