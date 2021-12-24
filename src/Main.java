import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.Animation;

    public class Main extends Application {
        public void start(Stage primaryStage) {

            GameScene.timer.start();

            primaryStage.setTitle("Runner");
            Group root = new Group();
            Pane pane = new Pane(root);
            Scene scene = new Scene(pane, 700, 400);
            GameScene.lifebar();

            primaryStage.setScene(scene);
            primaryStage.show();

            // Saut quand un clic est fait
            pane.setOnMouseClicked( (event)->{
                System.out.println("Jump");
                if (GameScene.heroRun.getAttitude() == 1){
                    GameScene.heroRun.setAttitude(2);}
            });



            // Pour que nos éléments s'affichent
            root.getChildren().add(GameScene.left.imageview);
            root.getChildren().add(GameScene.right.imageview);
            root.getChildren().add(GameScene.fullLife.imageview);
            root.getChildren().add(GameScene.heroRun.spriteSheet);
            root.getChildren().add(GameScene.fantome.spriteSheet);


        }

        public static void main(String[] args) {
            launch(args);
        }
    }

