package controller;
import model.*;

public class NPCController
{

    private NPCContainer npcContainer;
    
    public NPCController()
    {
        npcContainer = NPCContainer.getInstance();
    }

    public void createNPC(String name)
    {
        NPC npc = new NPC(name);
        npc.setID(npcContainer.getArrayLength());
        npcContainer.addNPC(npc);
    }
    
    public void createInteractableNPC(String name)
    {
        InteractableNPC npc = new InteractableNPC(name);
        npc.setID(npcContainer.getArrayLength());
        npcContainer.addInteractableNPC(npc);
    }
}
