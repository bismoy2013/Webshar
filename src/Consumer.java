class Consumer extends Thread {
   
	
	private Maintainer maintainer;
	
	
	@SuppressWarnings("unused")
	private int id;
	public Consumer(Maintainer m, int id) {
      maintainer = m;
      this.id = id;
   }
   
   public void run() {
	   
      int value = 0;
      while(true){
          value = maintainer.get();
          if(value==-1)
            {
            	System.out.println("Thread Exiting !");
				System.exit(1);
            }
      System.out.println("[Server] Accepted a new Client with ID="+value);
   
}
}
}