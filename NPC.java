import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * Write a description of class NPC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NPC
{
    private String dialogueTreePath;
    private String name;
    private int id;
    private File fXmlFile;
    private int startNodeID;
    private DialogueTree dialogueTree;
    
    public NPC(String name)
    {
        this.name = name;
        this.dialogueTreePath = "Data/DialogueTrees/" + name;
        fXmlFile = new File(dialogueTreePath);
        
        startNodeID = 0;
        
        if(fXmlFile.exists())
        {
            addDialogueTree(dialogueTreePath);
        }
        else
        {
            System.out.println("NPC " + name + " has no dialogue, ignoring...");
        }
    }
    
    public void addDialogueTree(String path)
    {
       //make the XML file reader and parse to data
       int id = 0;
       String nodeMessage = "";
       String choiceMessage = "";
       int returnValue = 0;
       int nextNodeID = 0;
       
       dialogueTree = new DialogueTree();
       
       
       try
       {
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           Document doc = dBuilder.parse(fXmlFile);
           
           doc.getDocumentElement().normalize();
           //System.out.println("Root : " + doc.getDocumentElement().getNodeName());
           
           NodeList dNodeList = doc.getElementsByTagName("DialogueNode");
           
           for(int i = 0; i < dNodeList.getLength(); i++)
           {
                Node dNode = dNodeList.item(i);
                Element nElement = (Element) dNode;
                
                id = Integer.parseInt(nElement.getAttribute("id"));
                nodeMessage = nElement.getAttribute("message");
                
                DialogueNode tempNode = new DialogueNode(id, nodeMessage);
                
                //For debugging
                //System.out.print(tempNode.getMessage() + " ");
                
                NodeList cNodeList = nElement.getElementsByTagName("DialogueChoice");
                
                for(int j = 0; j < cNodeList.getLength(); j++)
                {
                     Node cNode = cNodeList.item(j);
                     Element oElement = (Element) cNode;
                     
                     choiceMessage = oElement.getAttribute("message");
                     returnValue = Integer.parseInt(oElement.getAttribute("returnValue"));
                     nextNodeID = Integer.parseInt(oElement.getAttribute("nextNodeID"));
                     tempNode.addChoice(choiceMessage, returnValue, nextNodeID);
                     
                }
                
                dialogueTree.addDialogueNode(tempNode);
                
           }
           
           System.out.println("Tree for " + name + " added successfully");
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
   
    public void startDialogue()
    {
        DialogueChoice choiceResult;
        int tempReturnValue = 0;
        int currentNode = startNodeID;
        
        while(tempReturnValue == 0)
        {
            choiceResult = dialogueTree.playNode(currentNode);
            tempReturnValue = choiceResult.getReturnValue();
            currentNode = choiceResult.getNextNodeID();
            
            if(tempReturnValue != 0)
            {
                startNodeID = choiceResult.getNextNodeID();
                System.out.println("Convo has ended");
                System.out.println("Return value is now: " + choiceResult.getReturnValue());
                System.out.println("Start ID is now: " + startNodeID);
            }
        }
        
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
