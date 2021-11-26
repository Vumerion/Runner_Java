import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    public double x;
    public double y;
    public ImageView imageAnimated;
    private int maxXindex;
    private int index;
    private double durationbtw;
    private int maxIndex;
    private int largeurWindow;
    private int hauteurWindow;
    private int offsetFrame;
    private Rectangle2D hitbox;

    public AnimatedThing(String filename, double x, double y, int maxXindex, int index, double duration, int maxIndex,int minx, int miny, int largeurWindow, int hauteurWindow, int offsetFrame) {
        this.maxXindex = maxXindex;
        this.x = x;
        this.y = y;
        this.index = index;
        this.durationbtw = duration;
        this.maxIndex = maxIndex;
        this.largeurWindow = largeurWindow;
        this.hauteurWindow = hauteurWindow;
        this.offsetFrame = offsetFrame;
        this.hitbox = new Rectangle2D(this.x, this.y,largeurWindow,hauteurWindow );
        Image imageanim = new Image(filename);
        imageAnimated = new ImageView(imageanim);
        imageAnimated.setViewport( new Rectangle2D(minx, miny, largeurWindow, hauteurWindow));
        imageAnimated.setX(x);
        imageAnimated.setY(y);


    }

    public ImageView getImageAnimated(){
        return imageAnimated;
    }

    public double getDuration() {
        return durationbtw;
    }

    public Rectangle2D getHitbox(){
        return this.hitbox;
    }

    public void updateframe(long time){

        index = (index + 1) % maxIndex;
        int indiceX = 0;
        if (indiceX<maxXindex){
            indiceX = indiceX + index*offsetFrame;
        }
        else{
            indiceX=0;
        }
        imageAnimated.setViewport(new Rectangle2D(indiceX, 0, largeurWindow, hauteurWindow));

    }

    public  double getX(){
        return x;
    }
    public   double getY(){
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
