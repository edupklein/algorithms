package com.example.filereader;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader {
    
    public static void main(String[] args) {
        
        XmlReader xmlreader = new XmlReader();

        String fileName = "src/main/resources/students.xml";
        
        try
        {  
            File file = new File(fileName);  
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
            
            Document document = documentBuilder.parse(file);  
            
            System.out.println("Root element: "+ document.getDocumentElement().getNodeName());  
            
            if (document.hasChildNodes()) {  
                xmlreader.printNodeList(document.getChildNodes());  
            }

        }catch (Exception e) {  
            System.out.println(e.getMessage());  
        }   
    }

    public void printNodeList(NodeList childNodes) {



        for (int count = 0; count < childNodes.getLength(); count++){  
            
            Node elemNode = childNodes.item(count);  
            
            if (elemNode.getNodeType() == Node.ELEMENT_NODE) {  
            
                System.out.println("\nNode Name =" + elemNode.getNodeName()+ " [OPEN]");  
                System.out.println("Node Content =" + elemNode.getTextContent());  
            
                if (elemNode.hasAttributes()) {  
                    NamedNodeMap nodeMap = elemNode.getAttributes();  
                    
                    for (int i = 0; i < nodeMap.getLength(); i++) {  
                        
                        Node node = nodeMap.item(i);  
                        
                        System.out.println("attr name : " + node.getNodeName());  
                        
                        System.out.println("attr value : " + node.getNodeValue());  
                    }  
                }  
                
                /*
                if (elemNode.hasChildNodes()) {  
                //recursive call if the node has child nodes  
                    printNodeList(elemNode.getChildNodes());  
                }*/ 
                
                System.out.println("Node Name =" + elemNode.getNodeName()+ " [CLOSE]");  
            }  
        }
    }

}  
