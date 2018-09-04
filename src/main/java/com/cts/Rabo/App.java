package com.cts.Rabo;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	ClassPathResource res = new ClassPathResource("spring.xml");
    	XmlBeanFactory factory = new XmlBeanFactory(res);	
       FileReader read =(FileReader)factory.getBean("filereader");
       read.readData();
    }
}
