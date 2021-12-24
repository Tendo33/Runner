import javafx.scene.image.ImageView;

public class staticThing {
    private double x;
    private double y;
    public ImageView imageview;

    // Setter
    public void setImageview(String fileName) {
        imageview = new ImageView(fileName);
    }

    // Constructeur
    public staticThing(double x, double y, String fileName) {
        this.x = x;
        this.y = y;
        setImageview(fileName);
    }

    // Getter
    public double getSTx() {
        return x;
    }

    public double getSTy() {
        return y;
    }

    // Update pour faire l'animation du background initialement statique
    public void update(long time) {
        if (this.x < -801) {
            this.x = 700;
        } else {
            this.x = this.x - 40;
        }
        GameScene.background();

    }
}
