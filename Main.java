import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Runner");
        Group root = new Group();
        Pane pane = new Pane(root);
        GameScene thegame = new GameScene(pane, 800, 450, 0, 0);
        //Attention à l'ordre d'ajout.
        pane.getChildren().addAll(thegame.getBackgroundLeft().getView(),thegame.getBackgroundRight().getView(),thegame.getPannel().getView(),thegame.getRunner().getImageAnimated(),thegame.getBlood().getView());
        pane.getChildren().addAll();
        primaryStage.setScene(thegame);

        thegame.setOnMouseClicked( (event)->{
            thegame.Runner.jump();
        });
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
