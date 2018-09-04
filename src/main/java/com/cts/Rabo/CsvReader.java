package com.cts.Rabo;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader extends XmlReader{

	TransactionRecords trCsv = new TransactionRecords();	
	
	public void readData() throws Exception{
		
	   String csvFile = "C:/Users/RAVI/AssignmentBE2/records.csv";
       BufferedReader br = null;
       String line = "";
       String cvsSplitBy = ",";
       
       
       try {

           br = new BufferedReader(new FileReader(csvFile));
       
           List<String> al = new ArrayList<String>();
           
           while ((line = br.readLine()) != null) {

               String[] transaction = line.split(cvsSplitBy);
               
               trCsv.setRef(transaction[0]);
               
               trCsv.setAccNum(transaction[1]);
               
               trCsv.setStartBal(transaction[2]);
               
               trCsv.setMut(transaction[3]);
               
               trCsv.setDesc(transaction[4]);
               
               trCsv.setEndBal(transaction[5]);
               
               al.add(trCsv.getRef()+","+trCsv.getAccNum()+","+trCsv.getStartBal()+","+trCsv.getMut()+","+trCsv.getDesc()+","+trCsv.getEndBal());    
              
               }
           
           String csv[] = al.toArray(new String[al.size()]);
           
           System.out.println("Root Elements : records");
           
           System.out.println("-------------------------");
           
           ValidateData.validateData(csv);

           } catch (FileNotFoundException e) {
           e.printStackTrace();
           } catch (IOException e) {
           e.printStackTrace();
           } finally {
           if (br != null) {
               try {
                   br.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
     }
}
}