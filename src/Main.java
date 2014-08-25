/**
 *  Copyright (C) 2014 BISMOY MURASING <bmurasing@gmail.com>
 * 
 *  The codes cannot be shared without the express permission of the author : Bismoy Murasing.
 */

public class Main 

{
	
   public static void main(String[] args) {
	  
	  Maintainer m = new Maintainer();
      Producer p = new Producer(m, 1);
      Consumer c = new Consumer(m, 1);
      System.out.println("[Server] Server Started.");
	  System.out.println("[Server] Waiting for clients to connect.");
      p.start(); 
      c.start();
   }
}
