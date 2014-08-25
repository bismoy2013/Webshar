/**
 *  Copyright (C) 2014 BISMOY MURASING <bmurasing@gmail.com>
 * 
 *  The codes cannot be shared without the express permission of the author : Bismoy Murasing.
 */
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author bismoy
 *
 */

class Producer extends Thread {

private Maintainer maintainer;
Scanner in=new Scanner(System.in);
Set<Integer> hs=new LinkedHashSet<Integer>();
ArrayList<Integer> al=new ArrayList<Integer>();
@SuppressWarnings("unused")
private int id;

public Producer(Maintainer m, int id) {
maintainer = m;
this.id=id;
}

public void run() {
	
while (true) {
	
	System.out.println("[UserInput] Choose from options below: ");
	System.out.println("[UserInput] 1. Create a new client");
	System.out.println("[UserInput] 2. Send a message on behalf of some client");
	System.out.println("[UserInput] Enter Choice: ");
	int choice=in.nextInt();
	
	switch(choice)
	{
	case 1:
		System.out.println("[UserInput] Creating a new client. Enter ClientID: ");
		int id=in.nextInt();
		hs.add(id);
	    maintainer.put(id);
	    break;
	case 2:
		System.out.println("[UserInput] Through which client to send the message. Enter ID: ");
		int newid=in.nextInt();
		hs.add(newid);
		System.out.println("[UserInput] Enter Integer message: ");
		int message=in.nextInt();
		System.out.println("[Server] Got a message from ClientID="+newid+" message="+message);
		for(int g:hs)
		{
			if(message%g==0)
			{
				al.add(g);
			}
		}
		System.out.println("[Server] Forwarding message=48 to ClientIDs="+al);
		for(int aa:al)
		{
			System.out.println("[Client"+aa+"]"+"Got a message from server: Message="+message);
		}
		System.out.println("Thread Exiting !");
		System.exit(1);
	default:
		 System.out.println("Please Choose Other Options");
		 System.out.println(hs);
		 break;
	}
	
try {
Thread.sleep(1000);
} catch (InterruptedException e) { }
}
}
}
