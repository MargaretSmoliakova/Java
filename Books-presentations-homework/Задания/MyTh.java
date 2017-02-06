
public class MyTh {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Main start");
		// Создание потока
		Thread t = new Thread(new Runnable() {
		    public void run() {
		    	for (int i=0;i<10;i++){
		    		System.out.println("Hello "+i);
		            try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    	
		    }
		});
		// Запуск потока
		
		Thread t2 = new Thread(new Runnable() {
		    public void run() {
		    	for (int i=0;i<10;i++){
		    		System.out.println("Hi "+i);
		    		 try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    	}
		    }
		});
		// Запуск потока
		t.start();
		t2.start();
		t.join();
		t2.join();
		System.out.println("Main stop");


	}

}
