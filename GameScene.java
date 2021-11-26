import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.ArrayList;

public class GameScene extends Scene {
    Camera camera;
    StaticThing backgroundLeft;
    StaticThing backgroundRight;
    StaticThing Blood;
    StaticThing Pannel;
    Hero Runner;
    Rectangle2D HitboxHero;
    private int bloodamount;
    ArrayList<Foe> Cactus_Liste;

    GameScene(Parent root, double v1, double v2, int x, int y) {
        super(root, v1, v2);
        timer.start();
        this.bloodamount = 3;
        this.Pannel = new StaticThing("Texture_planche.png", 0, 300);
        this.Runner = new Hero("heros.png", 50, 250, 471, 0, 0.1, 6, 20, 0, 85, 100, 84);
        this.camera = new Camera(0, 0, this.Runner);
        this.backgroundLeft = new StaticThing("desert.png", 0, 0);
        this.backgroundRight = new StaticThing("desert.png", 0, 0);
        this.Blood = new StaticThing("Vie_Sang_transp.png", 70, 350);
        this.Cactus_Liste = new ArrayList<Foe>() ;
        this.Cactus_Liste.add(new Foe(250,50));
        Blood.view.setViewport(new Rectangle2D(0, 0, 1500, 524));
        Blood.view.setFitHeight(50);
        Blood.view.setFitWidth(160);
        Blood.view.setY(Blood.getY());
        Blood.view.setX(Blood.getX());
        backgroundLeft.view.setViewport(new Rectangle2D(0, 0, 800, 400));
        backgroundRight.view.setViewport(new Rectangle2D(0, 0, 800, 400));
        Pannel.view.setViewport(new Rectangle2D(0,0,800, 400));
        Pannel.view.setFitWidth(900);
        Pannel.view.setFitHeight(170);
        Pannel.view.setY(Pannel.getY());
        this.HitboxHero = new Rectangle2D(0,0,85,100);
    }

    long tictac = 0;
    //durée d'une frame=100 000 000 ns.
    AnimationTimer timer = new AnimationTimer() {
        public void handle(long time) {
            if (time - tictac >= 100_000_000) {
                tictac = time;
                Runner.update();
                camera.update();
                update(time);
            }
        }
    };

    public StaticThing getBlood() {
        return Blood;
    }

    public StaticThing getBackgroundLeft() {
        return backgroundLeft;
    }
    public StaticThing getBackgroundRight() {
            return backgroundRight;
    }

    public StaticThing getPannel(){
        return Pannel;
    }

    public ArrayList<Foe> getCactus(){
        return Cactus_Liste;
    }

    public Hero getRunner() {
            return Runner;
    }

    public void update(long time) {
        double Xcamera = this.camera.getX();
        double backgroundWidth = 800;
        double backgroundHeight = 400;
        this.backgroundLeft.view.setViewport(new Rectangle2D(Xcamera % backgroundWidth, camera.getY() % backgroundHeight, backgroundWidth - Xcamera % backgroundWidth, backgroundHeight - camera.getY()));
        this.backgroundRight.view.setViewport(new Rectangle2D(0, camera.getY() % backgroundHeight, Xcamera % backgroundWidth, backgroundHeight - camera.getY()));
        this.backgroundRight.view.setX(backgroundWidth - Xcamera % backgroundWidth);
        this.Runner.imageAnimated.setX(this.Runner.getX() - this.camera.getX());
        this.Runner.imageAnimated.setY(this.Runner.getY() - this.camera.getY());
        Blood.view.setViewport(new Rectangle2D(500*(3-this.bloodamount), 0, 1500, 524));
    }
}