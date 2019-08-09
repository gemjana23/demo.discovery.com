package com.test.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyData {
   Properties properties;
private Object String;


  public ReadPropertyData() {
	  File f=new File(System.getProperty("user.dir")+"/PropertyFiles/config.properties");
	  try {
		FileInputStream fis=new FileInputStream(f);
		properties=new Properties();
		properties.load(fis);
	       } 
	  catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Exception is "+e.getMessage());
	}
	  
  }
  
  public  String getApplicationURL(){
		  
		  String url=properties.getProperty("url");
		  return url;
	  }
  
/*  public  String getUsername(){
	  
	  String username=properties.getProperty("username");
	  return username;
  }
  
  
 public  String getPassword(){
	  
	  String password=properties.getProperty("password");
	  return password;
  }*/
  
 
 public  String getChromePath(){
	  
	  String chromepath=properties.getProperty("chromepath");
	  return chromepath;
 }
 
 public  String getFirefoxPath(){
	  
	  String firefoxpath=properties.getProperty("firefoxpath");
	  return firefoxpath;
}

 public  String getIEPath(){
	  
	  String iepath=properties.getProperty("iepath");
	  return iepath;
}
 
 
 }

