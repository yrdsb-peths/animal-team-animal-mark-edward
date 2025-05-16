import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * food for the elephant.
 * 
 * @author (mark ku, edward wang) 
 * @version (April 29 2025)
 */
public class Apple extends Actor
{
    
    private int speed = 1;
    public Apple()
    {
        setImage("apple.png");
    }
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Apple falls down
        int x = getX();
        int y = getY() + speed;
        setLocation (x,y);
        
        //Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
