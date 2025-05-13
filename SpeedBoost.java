import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * food for the elephant.
 * 
 * @author (mark ku) 
 * @version (April 29 2025)
 */
public class SpeedBoost extends Actor
{
    
    private int speed = 1;
    public SpeedBoost()
    {
        GreenfootImage img = new GreenfootImage("images/boost.png");
        img.scale(img.getWidth()/6, img.getHeight()/6);
        setImage(img);
    }
    /**
     * Act - do whatever the SpeedBoost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // SpeedBoost falls down
        int x = getX();
        int y = getY() + 2;
        setLocation (x,y);
        
        //Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
