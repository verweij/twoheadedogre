import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;

/**
 * Write a description of class GrassWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrassWorld extends World
{

    /**
     * Constructor for objects of class GrassWorld.
     * 
     */
    public Ogre ogre;
    public Face face;
    public GrassWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 600, 1);
        face = new Face(true);
        ogre = new Ogre(new ImagePackage(), face);
        populate();
    }
    
    public void populate() {
        addObject(face,50,50);
        addObject(ogre, 350, 300);
        addObject(new Knight(new ImagePackage(), ogre), 500,600);
    }
}
