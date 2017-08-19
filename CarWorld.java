import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CarWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarWorld extends World
{
    private static int GAP = 20;
    private int counter;
    private int score;
    private int time;
    GreenfootSound sound1 = new GreenfootSound("RacingDriving.mp3");

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public CarWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        setPaintOrder(Counter.class,Car.class,Vehicle.class,Gift.class,Tree.class,Snake.class,Line.class);
        addObject(new Car(),300,550);
        addObject(new Line(),400,0);
        addObject(new Line(),400,120);
        addObject(new Line(),400,240);
        addObject(new Line(),400,360);
        addObject(new Line(),400,480);
        addObject(new Line(),400,600);
        addObject(new Line(),200,0);
        addObject(new Line(),200,120);
        addObject(new Line(),200,240);
        addObject(new Line(),200,360);
        addObject(new Line(),200,480);
        addObject(new Line(),200,600);
        
        score = 0;
        updateScore();
        
        time = 2000;
        updateTime();
    }
    
    public void act()
    {
        lineAdding();
        counter++;
        sound1.play();
        if(Greenfoot.getRandomNumber(100)<2)
        {
            addObject(new Vehicle(), Greenfoot.getRandomNumber(200)+200,0);
        }
        if(Greenfoot.getRandomNumber(100)<7)
        {
          addObject(new Tree(), Greenfoot.getRandomNumber(120)+30,0);  
        }
        if(Greenfoot.getRandomNumber(50)<7)
        {
          addObject(new Tree(), Greenfoot.getRandomNumber(350)+450,0);  
        }
        if(Greenfoot.getRandomNumber(300)<1)
        {
           addObject(new Snake(), Greenfoot.getRandomNumber(550)+49,0);  
        }
        if(Greenfoot.getRandomNumber(100)<3)
        {
            addObject(new Gift(), Greenfoot.getRandomNumber(300)+150, 0);
        }
        
        countTime();
    }

    private void lineAdding()
    {
        if(counter == 40){
            addObject(new Line(),400,0);
            addObject(new Line(),200,0);
            counter=0;
        }
    }
    
    public void addScore(int points)
    {
        score = score + points;
        updateScore();
    }
    
    private void updateScore()
    {
        showText("Score: " + score, 60, 20);
    }
    
    private void countTime()
    {
        time = time - 1;
        updateTime();
        
        if(time == 0)
        {
            Greenfoot.stop();
            if(score >= 25)
            {
                showMessage1();
            }
            else
            {
                showMessage3();
            }
        }
    }
    
    private void updateTime()
    {
        showText("Time: " + time, 72, 40);
    }
    
    public void showMessage1()
    {
        showText("YOU WIN", 300, 290);
        showText("Your Score: " + score + " points", 300, 310);
    }
    
    public void showMessage2()
    {
        showText("GAME OVER", 300, 290);
        showText("Your Score: " + score + " points", 300, 310);
    }
    
    public void showMessage3()
    {
        showText("TRY AGAIN", 300, 290);
        showText("Your Score: " + score + " points", 300, 310);
    }

}
