import java.util.ArrayList;
import java.util.Comparator;
/**
 * Write a description of class DialogueNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DialogueNode implements Comparable<DialogueNode>
{  
    private int id;
    private String message;
    private ArrayList<DialogueChoice> dialogueChoices = new ArrayList<>();
    
    public DialogueNode(int id, String message)
    {
        this.id = id;
        this.message = message;
    }
    
    public int getID()
    {
         return id;   
    }

    public String getMessage()
    {
         return message;   
    }
    
    public int getArrayLength()
    {
         return dialogueChoices.size();   
    }
    
    public void addChoice(String message, int returnValue, int nextNodeID)
    {
         DialogueChoice dialogueChoice = new DialogueChoice(message, returnValue, nextNodeID);   
         dialogueChoices.add(dialogueChoice);
    }
    
    public DialogueChoice getChoice(int index)
    {
         return dialogueChoices.get(index);    
    }
    
    @Override
    public int compareTo(DialogueNode dialogueNode)
    {
        return Integer.compare(getID(), dialogueNode.getID());
    }
    
}
