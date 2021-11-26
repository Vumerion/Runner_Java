import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.Collections;

public class Hero extends AnimatedThing {
    private ArrayList<Double> pastStates;
    double gravity;

    public Hero(String filename, double x,double y, int maxXindex, int index, double durationbtw, int maxIndex, int minx, int miny, int largeurWindow, int hauteurWndow, int offsetFrame) {
        super(filename, x,y, maxXindex, index, durationbtw, maxIndex, minx, miny, largeurWindow, hauteurWndow, offsetFrame);
        pastStates = new ArrayList(Collections.nCopies(6, 0.0));
        this.pastStates.set(0,super.getX());    //position initiale en X du héro
        this.pastStates.set(1, 400.0);          //vitesse initiale en X du héro
        this.pastStates.set(2, 0.0);            //accéleration initiale en X du héro
        this.pastStates.set(3, super.getY());         //altitude initiale du héro
        this.gravity = 2500.0;
    }

    public void update(){
        double accelX = pastStates.get(2);
        double speedX = pastStates.get(1)+super.getDuration()*accelX;
        double positionX = pastStates.get(0)+super.getDuration()*speedX;

        double accelY = pastStates.get(5);
        double speedY = pastStates.get(4) + super.getDuration()*accelY;
        double positionY = pastStates.get(3) + super.getDuration()*speedY;
        if (positionY>250){
            positionY=250;
            speedY=0;
        }


        pastStates.set(0, positionX);
        pastStates.set(1, speedX);
        pastStates.set(2, 2.8);

        pastStates.set(3, positionY);
        pastStates.set(4, speedY);
        pastStates.set(5, this.gravity);

        super.setX(positionX);
        super.setY(positionY);

        if (speedY==0 && positionY==250) super.updateframe(100_000_000);
        else if(speedY>0) imageAnimated.setViewport(new Rectangle2D(0, 160 , 86, 105)); //jump down
        else imageAnimated.setViewport(new Rectangle2D(0,160, 85, 105));                //jump up
    }

    public void jump(){
        if (pastStates.get(3)==250.0){
            pastStates.set(5,-3.0*this.gravity);
        }
    }
}

