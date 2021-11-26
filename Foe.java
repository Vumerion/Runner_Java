import javafx.scene.image.ImageView;

public class Foe extends StaticThing{
    double speed;

    Foe( double y, double speed) {
        super("Cactus.png", 50, y);
        this.speed = speed;
    }

    public void Advance(){
        double X = this.view.getX();
        this.view.setX(X-this.speed);
    }
}