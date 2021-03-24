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
    private DialogueTree dialogueTree;
    private String dialogueTreePath;
    private String name;
    
    public NPC(String name, String xmlPath)
    {
        this.name = name;
        
        if(xmlPath != null)
        {
            dialogueTreePath = xmlPath;
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
           File fXmlFile = new File(path);
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           Document doc = dBuilder.parse(fXmlFile);
           
           doc.getDocumentElement().normalize();
           System.out.println("Root : " + doc.getDocumentElement().getNodeName());
           
           NodeList dNodeList = doc.getElementsByTagName("DialogueNode");
           
           for(int i = 0; i < dNodeList.getLength(); i++)
           {
                Node dNode = dNodeList.item(i);
                Element nElement = (Element) dNode;
                
                id = Integer.parseInt(nElement.getElementsByTagName("id").item(0).getTextContent());
                nodeMessage = nElement.getElementsByTagName("Message").item(0).getTextContent();
                
                DialogueNode tempNode = new DialogueNode(id, nodeMessage);
                System.out.println(tempNode.getMessage());
                NodeList cNodeList = nElement.getElementsByTagName("DialogueChoice");
                
                for(int j = 0; j < cNodeList.getLength(); j++)
                {
                     Node cNode = cNodeList.item(j);
                     Element oElement = (Element) cNode;
                     
                     choiceMessage = oElement.getElementsByTagName("Message").item(0).getTextContent();
                     returnValue = Integer.parseInt(oElement.getElementsByTagName("ReturnValue").item(0).getTextContent());
                     nextNodeID = Integer.parseInt(oElement.getElementsByTagName("NextNodeID").item(0).getTextContent());
                     tempNode.addChoice(choiceMessage, returnValue, nextNodeID);
                     
                }
                
                dialogueTree.addDialogueNode(tempNode);
           }
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    
    public void testPrint()
    {
        for(int i = 0; i < dialogueTree.getArrayLength(); i++)
        {
            DialogueNode node = dialogueTree.getNode(i);
            System.out.println(node.getMessage());
            
            for(int j = 0; j < node.getArrayLength(); j++)
            {
                DialogueChoice choice = node.getChoice(j);
                System.out.println("        " + choice.getMessage());
            }
        }
    }
    
}
