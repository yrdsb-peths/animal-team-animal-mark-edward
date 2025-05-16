import greenfoot.*;

/**
 * The world is where the elephant lives in
 * 
 * @author Mark Ku & Edward Wang
 * @ version May 2025
 */

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int level = 1;

    
    public MyWorld() {
        super(600, 400, 1, false);
        
        //Create elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 350);
        
        //Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createApple();
        
        createBoost();
        
        //Sets background image
        setBackground("images/background.jpg");
        
        
    }
    
    /**
     * End game and draw 'GameOver'
     */
    
    public void gameOver()
    {
        isGameOver = true;
        Label gameOverLabel = new Label ("Game Over", 100);
        addObject (gameOverLabel, 300, 200);
        Label gameOverLabelInstructions = new Label ("Press [space] to play again", 50);
        addObject (gameOverLabelInstructions, 300, 300);
    }
    
    public boolean isGameOver()
    {
        return isGameOver;
    }
    
    /**
     * increases score
     */
    public void increaseScore()
    {
        score ++;
        scoreLabel.setValue(score);
        
        if (score % 5 == 0)
        {
            level += 1;
        }
    }
    
    /**
     * Create a new apple at random locations
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject (apple, x, y);
    }
    
    /**
     * Create a new boost at random locations
     */
    public void createBoost()
    {
        SpeedBoost boost = new SpeedBoost();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject (boost, x, y);
    }
    
    public void act()
    {
        if (isGameOver && !gameEnded)
        {
            if (Greenfoot.isKeyDown("space"))
            {
                gameEnded = true; // prevent multiple restarts
                Greenfoot.setWorld(new MyWorld()); //restarts game   
            }
        }
    }
}
