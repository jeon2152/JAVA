import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private int score;
    
    public Counter()
    {
        score = 0;
        setImage(new GreenfootImage(200,30));
        update();
    }
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void addScore() 
    {    
        score++;
        update();
    }
    
    private void update()
    {
       // Greenfoot img = getImage();
       // img.clear();
       // img.setColor(Color.WHITE);
       // img.setFont(img.getFont().deriveFont(Font.BOLD));
       // img.setFont(img.getFont().deriveFont(20.0F));
       // img.drawString("Score: "+ score,4,20);
    }
}
