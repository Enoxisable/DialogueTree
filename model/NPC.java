package model;


/**
 * Write a description of class NPC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NPC
{
    private String name;
    private int id;
    private boolean isHostile;
    
    public NPC(String name, boolean isHostile)
    {
        this.isHostile = isHostile;
    }
    
    public void setID(int id)
    {
        this.id = id;   
    }
    
    public int getID()
    {
        return id;   
    }
    
}
