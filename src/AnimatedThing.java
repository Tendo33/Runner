import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double x;
    private double y;
    public ImageView spriteSheet;
    private int attitude;
    private int index;      // index
    private static double duration;// durée entre 2 frames
    private int maxIndex;   // indice max
    private double l;    // longueur de la fenêtre
    private double h;    // hauteur de la fenêtre
    private static double offset;  // offset entre chaque frame


    // Setter
    public void setImageview(String fileName) {
        this.spriteSheet = new ImageView(fileName);
    }
    public void setDuration(double Duree) {
        this.duration = Duree;
    }
    public void setOffset(double offset) { this.offset = offset;}
    public void setIndex(int ind) {this.index = ind;}
    public void setMaxIndex(int maxind) {this.maxIndex = maxind;}
    public void setAttitude(int att) {
        this.attitude = att;
    }

    // Constructeur
    public AnimatedThing(double x, double y, int attitude, int index, int maxIndex, double l, double h, String fileName) {
        this.x = x;
        this.y = y;
        this.attitude = attitude;
        this.index = index;
        this.maxIndex = maxIndex;
        this.l = l;
        this.h = h;
        setImageview(fileName);

    }

    // Getter
    public ImageView getSpriteSheet() {
        return spriteSheet;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getIndex() {
        return index;
    }
    public int getAttitude() { return attitude;}

    // Animation du fantôme
    public void animationFoe(long time) {
        GameScene.insertFantome();
        if (this.x < -801) {
            this.x = 700;
        } else {
            this.x = this.x - 40;
        }
    }

    // Update - Pour les animations du héros
    public void update(long time) {

        // Attitude 1 => le héros court
        if (this.attitude == 1) {
            GameScene.heroRun();
            if (this.index < this.maxIndex) {
                this.index = this.index + 85;
            } else {
                this.index = 0;
            }
        }

        // Attitude 2 => jump up
        if (this.attitude == 2) {
            GameScene.heroRun.jumpUp();
            this.y = this.y-25;
            if (this.y <=110){ this.setAttitude(3);}
        }

        // Attitude 3 => jump down
        if (this.attitude == 3) {
            GameScene.heroRun.jumpDown();

            if (this.y <= 255) {
                this.y = this.y + 25;
            }
            if (this.y >= 255) {
                this.setAttitude(1);
            }
        }




    }
}


