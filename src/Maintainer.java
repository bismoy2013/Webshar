/**
 *  Copyright (C) 2014 BISMOY MURASING <bmurasing@gmail.com>
 * 
 *  The codes cannot be shared without the express permission of the author : Bismoy Murasing.
 */
class Maintainer {
   private int contents;
   private boolean available = false;
   public synchronized int get() 
   {
      while (available == false) {
         try {
            wait();
         }
         catch (InterruptedException e) {
         }
      }
      available = false;
      notifyAll();
      return contents;
   }
   
   public synchronized void put(int value) {
      while (available == true) {
         try {
            wait();
         }
         catch (InterruptedException e) { 
         } 
      }
      contents = value;
      available = true;
      notifyAll();
   }
}
