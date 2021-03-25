import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class DialogueTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DialogueTree
{
    private ArrayList<DialogueNode> dialogueNodes = new ArrayList<>();
    private int startID;
    
    public DialogueTree()
    {
        // initialise instance variables
        startID = 0;
        
        //Zero will always be the starting node, so make sure you have one with id = 0
    }
    
    public void addDialogueNode(DialogueNode dialogueNode)
    {  
        dialogueNodes.add(dialogueNode);
    }
    
    public void sortNodes()
    {
       Collections.sort(dialogueNodes);
    }
    
    public DialogueChoice playNode(int nodeID)
    {
         DialogueChoice choice;
         choice = dialogueNodes.get(nodeID).playNode();
         return choice;   
    }
    
    public int getArrayLength()
    {
         return dialogueNodes.size();   
    }
    
    public DialogueNode getNode(int index)
    {
         return dialogueNodes.get(index);    
    }
    
}
