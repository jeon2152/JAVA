import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vehicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vehicle extends Actor
{
    /**
     * Act - do whatever the Vehicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moveDown();
        if(getY()>=getWorld().getHeight()-1)
        {
            getWorld().removeObject(this);
                        
        }
        if(getWorld()==null) return;
        {
            getWorld().removeObjects(getIntersectingObjects(Vehicle.class));
        }
    }
    
    public void moveDown()
     {
        setLocation(getX(),getY()+4);
    
     }   
}
