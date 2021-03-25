import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
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
    
    public DialogueChoice playNode()
    {
        System.out.println(message);
        printChoices();
        int choiceID = 0;
        
        while(choiceID == 0 || choiceID > dialogueChoices.size())
        {
            choiceID = makeDecision();
        }
        
            choiceID--;
        return dialogueChoices.get(choiceID);
    }
    
    public void printChoices()
    {
        for(int i = 0; i < dialogueChoices.size(); i++)
        {
             System.out.println((i+1) + ".  " + dialogueChoices.get(i).getMessage());
        }
    }
    
    public int makeDecision()
    {
           int decisionNumber = 0; 
           Scanner scanner = new Scanner(System.in);
           
           System.out.println("Make decision:");
           decisionNumber = scanner.nextInt();
           
           if(decisionNumber > dialogueChoices.size() || decisionNumber == 0)
           {
               System.out.println("Not a valid option, try again");
               return decisionNumber;
           }
           
           return decisionNumber;
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
