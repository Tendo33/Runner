
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.animation.Animation;

public class Hero  extends AnimatedThing{

    // Constructeur
    public Hero(double x, double y, int attitude, int index, int maxIndex, double l, double h, String filename) {
        super(x, y, attitude, index, maxIndex, l, h, filename);
    }

    // Saut
    public void jumpUp(){
        this.setAttitude(2);
        this.setIndex(0);
        this.spriteSheet.setViewport(new Rectangle2D(this.getIndex(),161,75,100));
        this.spriteSheet.setX(this.getX());
        this.spriteSheet.setY(this.getY()-20);
    }

    public void jumpDown(){
        this.setAttitude(3);
        this.setIndex(85);
        this.spriteSheet.setViewport(new Rectangle2D(this.getIndex(),161,75,100));
        this.spriteSheet.setX(this.getX());
        this.spriteSheet.setY(this.getY());
    }


}

