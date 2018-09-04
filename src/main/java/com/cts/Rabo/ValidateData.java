package com.cts.Rabo;

import java.util.ArrayList;
import java.util.List;

public class ValidateData {
    
	static int arrLength;
    
	public static void validateData(String s[]) throws Exception{
 		
		 List<String> validFail = new ArrayList<String>();
     
 		 arrLength = s.length;

          List<String> arrList = new ArrayList<String>();

          List<String> duplicateList = new ArrayList<String>();

          int cnt= 0;

               for(int i=0;i<arrLength;i++){

             for(int j=i+1;j<arrLength;j++){

                if((s[i].substring(0,6)).equals((s[j].substring(0,6)))){

                  cnt+=1;

                }      

             }

             if(cnt<1){

               arrList.add(s[i]);

             }else if(cnt == 1){

                   duplicateList.add(s[i]);

             }

               cnt=0;

             }

            String array2[] = arrList.toArray(new String[arrList.size()]);

           for(String strng : array2){

                 String input[] = strng.split(",");

                 if(((Double.parseDouble(input[2])+(Double.parseDouble(input[3]))) == Double.parseDouble(input[5])) || ((Float.parseFloat(input[2])+Float.parseFloat(input[3])) == (Float.parseFloat(input[5])))){

                 
                 System.out.println("\nRecord \nTransaction Reference : "+input[0]);

                 System.out.println("Account Number : "+input[1]);

                 System.out.println("Start Balance : "+input[2]);

                 System.out.println("Mutation : "+input[3]);

                 System.out.println("Description : "+input[4]);

                 System.out.println("End Balance : "+input[5]);
                 

                 }
                 else if(((Double.parseDouble(input[2])+Double.parseDouble(input[3]))!= (Double.parseDouble(input[5]))) || ((Float.parseFloat(input[2])+Float.parseFloat(input[3])) != (Float.parseFloat(input[5])))){
                 	
                 validFail.add("\nRecord\nTransaction Reference : "+input[0]+"\nAccount Number : "+input[1]+"\nStart Balance : "+input[2]+"\nMutation : "+input[3]+"\nDescription : "+input[4]+"\nEnd Balance : "+input[5]);	
                 
                 }
        }

           System.out.println("\n\n\nDuplicated : ");
           System.out.println("--------------");

           String array3[] = duplicateList.toArray(new String[duplicateList.size()]);

           for(String strng : array3){

                 String input1[] = strng.split(",");

                 System.out.println("\nRecord \nTransaction Reference : "+input1[0]);

                 System.out.println("Description : "+input1[4]);

           }
           
           System.out.println("\n\n\nValidation Failed Records : ");
           System.out.println("-------------------------------");
           
           for(String strValid : validFail){
         	  System.out.println(strValid);
           }
           
     }

}
