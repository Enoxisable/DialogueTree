package model;
import java.util.ArrayList;

public class NPCContainer
{
    private static NPCContainer instance;
    private ArrayList<NPC> npcs;
    private ArrayList<InteractableNPC> interactableNPCs;
    
    private NPCContainer()
    {
        npcs = new ArrayList<NPC>();
        interactableNPCs = new ArrayList<InteractableNPC>();
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
    
    public void addInteractableNPC(InteractableNPC npc)
    {
        interactableNPCs.add(npc);
        npc.startDialogue();
    }
    
    public int getArrayLength()
    {
        return npcs.size();
    }
}
