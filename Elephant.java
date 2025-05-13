import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant is the hero.
 * 
 * @author (mark ku) 
 * @version (April 29 2025)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound ("elephantscream.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    
    //direction the elephant is facing at the star
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Constructor - the code that gets run one time when object is created
     */
    public Elephant()
    {
       
        for (int i=0; i<8; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        
        for(int i=0; i<idleLeft.length;i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        
        animationTimer.mark();
        
        //initial elephant image
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if (animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals ("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    public void act()
    {
        // Add your action code here.
    
        if (Greenfoot.isKeyDown("left"))
        {

            move(-2);

            

            facing = "right";
        }
        else if (Greenfoot.isKeyDown("right"))
        {

            move(2);

         

            facing = "left";
        }
        
        // Remove apple if elephant eats it
        eat();
        
        //animate the elephant
        animateElephant();
    
    }
    
    /**
     * Eat apple and spawn new apple if apple is ate
     */
    public void eat()
    {
        if (isTouching(Apple.class))
        {
            removeTouching (Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
