//Start menu
//import necessary packages with javaFX
import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.geometry.Orientation; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
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
      //insets = (top, right, bottom, left)
      //this may have to change? WILL IT EFFECT OTHER SCENE PADDINGS?
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
      
      
      //level 1 layout - create new pane
      TilePane levelOne = new TilePane(Orientation.VERTICAL);
      levelOne.setPrefSize(paneWidth, paneHeight);
      levelOne.setPadding(new Insets(20,20,20,20));
      
      //borderpane
      //BorderPane tileFloor = new Borderpane();
   
      
      //declare tileboard
      Rectangle[][] tiles;
      int rows = 6;
      int columns = 5;
      tiles = new Rectangle[rows][columns];
      //initalize tileboard
      for(int i = 0; i < rows; i++)
      {
         for(int j = 0; j < columns; j++)
         {
            tiles[i][j] = new Rectangle();
            tiles[i][j].setWidth(100);
            tiles[i][j].setHeight(100);
            tiles[i][j].setFill(Color.RED);
            tiles[i][j].setStroke(Color.BLACK);
            
            levelOne.getChildren().add(0,tiles[i][j]);
         }
      }
      
      levelOne.setAlignment(Pos.CENTER);
      
      //create new rectangle for raised area
      Rectangle shelf = new Rectangle(125,600);
      shelf.setFill(Color.GREY);
      //levelOne.getChildren().add(1,shelf);
     
      
      level1 = new Scene(levelOne, paneWidth, paneHeight);
      
       //set action on start button -> (from scene to scene)
      startButton.setOnAction(e -> mainWindow.setScene(level1));
      //show everything
      mainWindow.setScene(startPage);
      mainWindow.setTitle("START MENU");
      mainWindow.show();
      
   }
}
