package com.cts.Rabo;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XmlReader implements FileReader{
	
	TransactionRecords trXml = new TransactionRecords();

        public void readData()throws Exception{

          try {

             File fXmlFile = new File("C:/Users/RAVI/AssignmentBE2/records.XML");

             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

             Document doc = dBuilder.parse(fXmlFile);

                        
             doc.getDocumentElement().normalize();

             System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

             NodeList nList = doc.getElementsByTagName("record");

             System.out.println("------------------------");

             String rabo[] = new String[nList.getLength()];

             for (int temp = 0; temp < rabo.length; temp++) {

                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    	
                    	Element eElement = (Element) nNode;

                    	trXml.setRef(eElement.getAttribute("reference"));

                    	trXml.setAccNum(eElement.getElementsByTagName("accountNumber").item(0).getTextContent());
                           
                    	trXml.setStartBal(eElement.getElementsByTagName("startBalance").item(0).getTextContent()); 

                    	trXml.setMut(eElement.getElementsByTagName("mutation").item(0).getTextContent());

                    	trXml.setDesc(eElement.getElementsByTagName("description").item(0).getTextContent());

                    	trXml.setEndBal(eElement.getElementsByTagName("endBalance").item(0).getTextContent());;

                          

                        rabo[temp] = (trXml.getRef()+","+trXml.getAccNum()+","+trXml.getStartBal()+","+trXml.getMut()+","+trXml.getDesc()+","+trXml.getEndBal());

                    }

                }

             ValidateData.validateData(rabo);
             
          } catch (Exception e){

             e.printStackTrace();

          }

        }
}