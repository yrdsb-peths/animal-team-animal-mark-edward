import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Speed boost for the elephant.
 * 
 * @author (Mark Ku & Edward Wang) 
 * @version (May 2025)
 */
public class SpeedBoost extends Actor
{
    
    
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
        MyWorld world = (MyWorld) getWorld();
        // SpeedBoost falls down
        int x = getX();
        int y = getY() + 2;
        setLocation (x,y);
    
        
        if (world.isGameOver())
        {
            return;
        }
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
            world.createBoost();
        }
    }
    
}
