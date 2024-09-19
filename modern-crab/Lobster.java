// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Lobster extends Actor
{

    /**
     * 
     */
    public Lobster()
    {
        turn(Greenfoot.getRandomNumber(360));
    }

    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        startingDirection();
        moveAround();
        crabDisappear();
        removeWormAddLobster();
        if (isGameLost()) {
            transitionToGameOverWorld();
        }
    }

    /**
     * 
     */
    public void moveAround()
    {
        move(4);
        if (Greenfoot.getRandomNumber(10) == 1) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if (isAtEdge()) {
            turn(180);
        }
    }

    /**
     * 
     */
    public void startingDirection()
    {
        if (Greenfoot.getRandomNumber(10) == 1) {
            turn(Greenfoot.getRandomNumber(360));
        }
    }

    /**
     * 
     */
    public void crabDisappear()
    {
        if (isTouching(Crab.class)) {
            World world = getWorld();
            removeTouching(Crab.class);
            Greenfoot.playSound("scary.wav");
        }
    }

    /**
     * 
     */
    public boolean isGameLost()
    {
        World world = getWorld();
        if (world.getObjects(Crab.class).isEmpty()) {
            return true;
            
        }
        else {
            return false;
        }
    }

    /**
     * 
     */
    public void transitionToGameOverWorld()
    {
        World gameOverWorld =  new  GameOverWorld();
        Greenfoot.setWorld(gameOverWorld);
    }

    /**
     * 
     */
    public void removeWormAddLobster()
    {
        Actor worm = getOneIntersectingObject(Worm.class);
        if (worm != null) {
            World world = getWorld();
            int locationX = worm.getX();
            int locationY = worm.getY();
            Actor lobster =  new  Lobster();
            world.removeObject(worm);
            world.addObject(lobster, locationX, locationY);
        }
    }
}
