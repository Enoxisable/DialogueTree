

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
        System.out.println(npc.getID());
    }
}
