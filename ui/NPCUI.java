package ui;

import controller.NPCController;


public class NPCUI
{

    private NPCController npcController;
    
    public NPCUI()
    {
        npcController = new NPCController();
    }
    
    
    public void createNPC()
    {
        String name = "newConvo";
        npcController.createNPC(name);
    }
    
    public void createInteractableNPC()
    {
        String name = "newConvo";
        npcController.createInteractableNPC(name);
    }
}
