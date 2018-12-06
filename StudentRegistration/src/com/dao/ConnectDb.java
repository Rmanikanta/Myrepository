package com.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeMap;

// this class is created for doing all the CURD operations into the files 
public class ConnectDb {
   
	public static void main(String[] args) {
		 TreeMap<Integer,AdminModel> treeMap = new TreeMap<Integer,AdminModel>();
		ObjectOutputStream outStreem = getOutPutStreem("AdminInfoFile");
		if(outStreem != null) {
			try {
				treeMap.put(1, new AdminModel(1, "mani", "1234"));
				treeMap.put(2, new AdminModel(2, "chitra", "1111"));
				treeMap.put(3,new AdminModel(1, "vinay", "2222"));
				treeMap.put(1,new AdminModel(1, "jadhav", "2222"));
			   outStreem.writeObject(treeMap);
				
//			outStreem.writeObject(new AdminModel(1, "mani", "1234"));
//			outStreem.writeObject(new AdminModel(2, "chitra", "1111"));
//			outStreem.writeObject(new AdminModel(1, "vinay", "2222"));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		try {
			outStreem.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectInputStream inStreem = getInputStreem("AdminInfoFile");
		if(inStreem != null) {
			try {
				@SuppressWarnings("unchecked")
				TreeMap<Integer,AdminModel> tree = (TreeMap<Integer,AdminModel>)inStreem.readObject();
			    Set<Integer> s = tree.keySet();
			    for(Integer i:s) {
			    	
			    	System.out.println(tree.get(i).getName());
			    	
			    }
			
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
//			for(int i = 0; i < 5; i++) {
//				AdminModel admin;
//				try {
//					admin = (AdminModel)inStreem.readObject();
//					System.out.println(admin.getName());
//				} catch (ClassNotFoundException | IOException e) {
//				
//					e.printStackTrace();
//				}
//				
//			}
		}
		
		try {
			inStreem.close();
			outStreem.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//this method is used for creating the   the connection to the file  
 


  // this method returns the outputStreem to the given file 
 public static ObjectOutputStream getOutPutStreem(String filePath) {
	 FileOutputStream fis = null;
	 ObjectOutputStream  outputStreem = null;
	 try {
			     fis = new FileOutputStream(new File(filePath));
				 outputStreem = new ObjectOutputStream(fis);
				 return outputStreem;
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return null;
			
		}catch (IOException e) {
			
				e.printStackTrace();
				return null;
		}
	    finally {
	    	if(fis != null && outputStreem != null) {
//	    		try {
//					fis.close();
//					 outputStreem.close();
//				} catch (IOException e) {
//					
//					e.printStackTrace();
//				}
	    	   
	    	} 	
	    }
		 
	 }
 
 
 // this method returns the ObjectInputStreem for the given file path
 public static ObjectInputStream getInputStreem(String filePath) {
	 FileInputStream fis = null;
	 ObjectInputStream  inputStreem = null;
	 try {
			     fis = new FileInputStream(new File(filePath));
				 inputStreem = new ObjectInputStream(fis);
				 return inputStreem;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
		}
	    finally {
//	    	if(fis != null && inputStreem != null) {
//	    		try {
//					fis.close();
//					 inputStreem.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
	    	   
	    	//} 	
	   }
		 
	}
 
 }



class AdminModel implements Serializable{
	int unqkey;
	public int getUnqkey() {
		return unqkey;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	String name;
	String password;
	public AdminModel(int unqKey,String name,String password ) {
		this.unqkey = unqKey;
		this.name = name;
		this.password = password;
		
	}
}



