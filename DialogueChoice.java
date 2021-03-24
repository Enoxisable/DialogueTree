
/**
 * Write a description of class DialogueChoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DialogueChoice
{

    private String message;
    private int returnValue;
    private int nextNodeID;

    
    public DialogueChoice(String message, int returnValue, int nextNodeID)
    {
       this.message = message;
       this.returnValue = returnValue;
       this.nextNodeID = nextNodeID;
    }
    
    public String getMessage()
    {
        return message;
    }
}
