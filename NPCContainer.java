import java.util.ArrayList;

public class NPCContainer
{
    private static NPCContainer instance;
    private ArrayList<NPC> npcs;
    
    private NPCContainer()
    {
        npcs = new ArrayList<NPC>();
    }
    
    public static NPCContainer getInstance()
    {
        if(instance == null)
        {
            instance = new NPCContainer();
        }
        return instance;
    }

    public void addNPC(NPC npc)
    {
        npcs.add(npc);
    }
    
    public int getArrayLength()
    {
        return npcs.size();
    }
}
