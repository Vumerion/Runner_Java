import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/* création d'une image statique (background) */

public class StaticThing {
    double x;
    double y;
    ImageView view;

    StaticThing(String fileName, double x, double y){
        this.x = x;
        this.y = y;
        Image image = new Image( fileName);
        view = new ImageView(image);
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public ImageView getView() {
        return view;
    }
}
