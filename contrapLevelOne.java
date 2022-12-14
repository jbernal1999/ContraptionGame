//level one
//import necessary packages with javaFX
import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.geometry.Orientation; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.*; 
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.awt.Component;
import javafx.geometry.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;

public class contrapLevelOne extends Application
{
    public static void main(String[] args)
   {
      launch(args);
   }
   
   private static final double W = 650, H = 650;
   boolean goUp, goDown, goRight, goLeft, inBounds;
   public Rectangle human;
   public AnimationTimer timer;
   
   
   @Override
   public void start(Stage stage)
   {
      human = new Rectangle(10,10);
      human.setArcHeight(10);
      human.setArcWidth(10);
      moveHeroTo(W / 2, H / 2);
      //set inBounds to true since we are in the middle of pane
      inBounds = true;
 
      //level 1 layout - create new pane
      TilePane levelOne = new TilePane();
      levelOne.setPrefSize(W, H);
      
     
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
            levelOne.getChildren().add(tiles[i][j]);
         }
      }
      levelOne.setAlignment(Pos.CENTER);
      //System.out.println(levelOne.getBoundsInLocal().getWidth());
     
      Group levelUno = new Group();
      levelUno.getChildren().add(0,levelOne);
      levelUno.getChildren().add(human);
      System.out.println(levelUno.getChildren());
      
      Scene level1 = new Scene(levelUno, W, H, Color.FORESTGREEN);
      
      level1.setOnKeyPressed(new EventHandler<KeyEvent>() 
      {
            public void handle(KeyEvent event) 
            {
                switch (event.getCode()) 
                {
                    case UP:    goUp = true;
                    //System.out.println("UP pressed");
                    //System.out.println("X: " + human.getLocalToParentTransform().getTx() + "\tY: " + human.getLocalToParentTransform().getTy());
                    break;
                    
                    case DOWN:  goDown = true;
                    //System.out.println("DONW pressed");
                    //System.out.println("X: " + human.getLocalToSceneTransform().getTx() + "\tY: " + human.getLocalToSceneTransform().getTy());
                    break;
                    
                    case LEFT:  goLeft  = true; 
                    //System.out.println("LEFT pressed");
                    //System.out.println("X: " + human.getLocalToSceneTransform().getTx() + "\tY: " + human.getLocalToSceneTransform().getTy());
                    break;
                    
                    case RIGHT: goRight  = true;
                    //System.out.println("RIGHT pressed");
                    //System.out.println("X: " + human.getLocalToSceneTransform().getTx() + "\tY: " + human.getLocalToSceneTransform().getTy());
                    break;
                    
                }
            }
        });

      level1.setOnKeyReleased(new EventHandler<KeyEvent>() 
      {
            public void handle(KeyEvent event) 
            {
                switch (event.getCode()) 
                {
                    case UP:    goUp = false;
                    //System.out.println("UP released");
                    break;
                    case DOWN:  goDown = false;
                    //System.out.println("DOWN released");
                    break;
                    case LEFT:  goLeft  = false;
                    //System.out.println("LEFT released");
                    break;
                    case RIGHT: goRight  = false;
                    //System.out.println("RIGHT released");
                    break;
                }
            }
        });

      
      stage.setScene(level1);
      stage.setTitle("LEVEL ONE");
      stage.show();
      
      timer = new AnimationTimer() 
      {
            
            public void handle(long now) 
            {
                int dx = 0, dy = 0;

                if (goUp) dy -= 1;
                if (goDown) dy += 1;
                if (goLeft)  dx -= 1;
                if (goRight)  dx += 1;

                moveHeroBy(dx, dy);
                //testing boundaries
                /*if((human.getLocalToParentTransform().getTx() < 26) || (human.getLocalToParentTransform().getTy() < 74) ||
                  (human.getLocalToParentTransform().getTx() > 617) || (human.getLocalToParentTransform().getTy() > 566))
                {
                  
                }*/
                
                //if too far left
                if(human.getLocalToParentTransform().getTx() < 26)
                {
                  human.relocate(26.0, (human.getLocalToParentTransform().getTy()));
                }
                //if too far up
                if(human.getLocalToParentTransform().getTy() < 74)
                {
                  human.relocate((human.getLocalToParentTransform().getTx()), 74.0);
                }
                //too far right
                if(human.getLocalToParentTransform().getTx() > 617)
                {
                  human.relocate(617.0, (human.getLocalToParentTransform().getTy()));
                }
                //too far down
                if(human.getLocalToParentTransform().getTy() > 566)
                {
                  human.relocate((human.getLocalToParentTransform().getTx()), 566.0);
                }
               
            }
        };
        timer.start();
       
   }
   
   private void moveHeroBy(int dx, int dy) 
   {
        if (dx == 0 && dy == 0) return;

        final double cx = human.getBoundsInLocal().getWidth()  / 2;
        final double cy = human.getBoundsInLocal().getHeight() / 2;
        

        double x = cx + human.getLayoutX() + dx;
        double y = cy + human.getLayoutY() + dy;

        moveHeroTo(x, y);
    }
    private void moveHeroTo(double x, double y) 
    {
        final double cx = human.getBoundsInLocal().getWidth()  / 2;
        final double cy = human.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
            x + cx <= W &&
            y - cy >= 0 &&
            y + cy <= H) {
            human.relocate(x - cx, y - cy);
        }
    }
}
