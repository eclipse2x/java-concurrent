package thread.status.interrupt;

public class SleepInterrupt {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		thread.interrupt();
		System.out.println("end of main");
	}
	
	static class MyThread extends Thread {

		@Override
		public void run() {
			for (int i=0; i<10; i++) {
				System.out.println(i);
			}
			
			try {
				System.out.println("begin sleep on my thread");
				Thread.sleep(20000);
				System.out.println("end sleep on my thread");
			} catch (InterruptedException e) {
				System.out.println("sleep of mythread is interrupted");
				e.printStackTrace();
			}
		}
		
	}
}
