import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    private int HSPEED=10;
    //CarWorld sound = new CarWorld();
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("right"))
        {
            moveRight();
        }
        if(Greenfoot.isKeyDown("left"))
        {
            moveLeft();
        }
        if(Greenfoot.isKeyDown("up"))
        {
            moveUp();
        }
        if(Greenfoot.isKeyDown("down"))
        {
            moveDown();
        }
        checkCollision();

    }
    
    public void moveRight()
    {
        setLocation(getX()+2,getY());
    }
    
    public void moveLeft()
    {
        setLocation(getX()-2,getY());
    }
    
    public void moveUp()
    {
        setLocation(getX(),getY()-2);
    }
    
    public void moveDown()
    {
        setLocation(getX(),getY()+4);
    }
    
    public void checkCollision()
    {
        if(crash(Vehicle.class))
        {
           Greenfoot.stop();
           Greenfoot.playSound("crash.mp3");
           CarWorld carworld = (CarWorld)getWorld();
           carworld.showMessage2();
        }
        if(crash(Tree.class))
        {
           Greenfoot.stop();
           Greenfoot.playSound("crash.mp3");
           CarWorld carworld = (CarWorld)getWorld();
           carworld.showMessage2();
        }
        if(crash(Snake.class)) 
        {
           Greenfoot.stop();
           Greenfoot.playSound("crash.mp3");
           CarWorld carworld = (CarWorld)getWorld();
           carworld.showMessage2();
        }
        
        if(isTouching(Gift.class))
        {
            removeTouching(Gift.class);
            CarWorld carworld = (CarWorld)getWorld();
            carworld.addScore(1);
        }
    }
    
    public boolean crash(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0,-30,clss);
        return actor != null;
    }
}
