import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import java.util.ArrayList;
import java.util.Random;

public class GameScene extends Scene {
    private double x;
    private double y;
    private double l;
    private double h;
    //Camera cam = new Camera(x,y);

    static Random rand = new Random();

    public static staticThing left = new staticThing(0,0,"desert.png");   // instanciation de 2 staticThing pour afficher le background
    public static staticThing right = new staticThing(800,0,"desert.png");   // instanciation de 2 staticThing pour afficher le background);
    public static staticThing fullLife = new staticThing(20,12,"lifebar.png");
    public static Hero heroRun = new Hero(200,255,1,0,420,10,103,"heros.png");
    public static Foe fantome = new Foe(801,280,1,0,0,74,57,"foe.png");

    // Animation du héro, timer
    static AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            try {
                Thread.sleep(60);             // Permet de contrôler la vitesse du héro
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            heroRun.update(time);
            //camera.update(time);
            left.update(time);
            right.update(time);
            fantome.animationFoe(time);
        }
    };

    // Constructeur
    public GameScene(double x, double y, double l, double h, Group g){
        super(g);
        this.x = x;
        this.y = y;
        this.l = l;
        this.h = h;
    }

    public static void background() {
        left.imageview.setX(left.getSTx()); // getSTx et getSTy sont les getters de staticThing
        left.imageview.setY(left.getSTy()); // cela nous permettra d'obtenir le x et le y de left et right

        right.imageview.setX(right.getSTx());
        right.imageview.setY(right.getSTy());
    }

    public static void lifebar(){
        fullLife.imageview.setX(fullLife.getSTx());
        fullLife.imageview.setY(fullLife.getSTy());
    }

    public static void heroRun(){
        heroRun.setAttitude(1);
        heroRun.spriteSheet.setViewport(new Rectangle2D(heroRun.getIndex(),0,80,100));
        heroRun.spriteSheet.setX(heroRun.getX());
        heroRun.spriteSheet.setY(heroRun.getY());
    }

    public static void insertFantome(){
        int n = rand.nextInt(300);
        fantome.spriteSheet.setViewport(new Rectangle2D(fantome.getIndex(),0,74,57));
        fantome.spriteSheet.setX(fantome.getX());
        fantome.spriteSheet.setY(fantome.getY());
    }

    // L'update pour faire l'animation du background se situe dans staticThing


}


