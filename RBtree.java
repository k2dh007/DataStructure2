package RBtree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RBtree {
	 public static void main(String args[]) {

		    if (args.length == 0) {                   
		      System.err.println("Input Filename...");
		      System.exit(1);                         
		    }
		    int insertNum=0;
		    int deleteNum=0;
		    int missNum=0;
		    try {
		    	RBtree1 st = new RBtree1();
		    	File f = new File(args[0]);
		      BufferedReader in = new BufferedReader(new FileReader(f));
		      String s;
		      while ((s = in.readLine()) != null) {
		    	  int s_int = Integer.parseInt(s.trim());
		    	  if(s_int>0){
		    		  st.insert(s_int);
		    		  insertNum++;
		    	  }
		    	  else if(s_int<0){
		    		  String s_str = Integer.toString(-s_int);
		    		  if(st.remove(-s_int)==null) missNum++;
		    		  else deleteNum++;
		    	  }
		    	  else break;
		      }
		      in.close();
		      System.out.println("filename = " + f.getName());
		      System.out.println("total = " + st.size());
		      System.out.println("insert = " + insertNum);
		      System.out.println("deleted = " + deleteNum);
		      System.out.println("miss = " + missNum);
		      System.out.println("nb = " + st.nb());
		      System.out.println("bh = " + st.bh());
		      st.inorder();

		    } catch (IOException e) {
		        System.err.println(e); 
		        System.exit(1);
		    }
		    
		  }
}
