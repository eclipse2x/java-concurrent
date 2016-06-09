package thread.status.interrupt;

/**
 *  调用 interrupt() 将会中断处于 sleep(), 或者 wait() 或者 join() 的线程，被打断的线程会收到
 *  一个 InterruptedException, 但是如果对处于 Running 状态的线程调用此方法需要配合 isInterrupted() 来处理
 * @author eclipse
 */
public class ThreadInterrupt {
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
