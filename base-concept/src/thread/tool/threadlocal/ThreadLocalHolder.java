package thread.tool.threadlocal;

/**
 * 每个线程设置的 ThreadLocal 值都只对当前线程可见
 * @author eclipse
 *
 */
public class ThreadLocalHolder implements Runnable {
	private ThreadLocal<String> local = new ThreadLocal<String>();
	
	@Override
	public void run() {
		local.set(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName() + " get from " + local.get());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " get from " + local.get());
	}
	
	public static void main(String []args) {
		ThreadLocalHolder holder = new ThreadLocalHolder();
		
		Thread t1 = new Thread(holder, "第一个线程");
		Thread t2 = new Thread(holder, "第二个线程");

		Thread t3 = new Thread(holder, "第三个线程");
		Thread t4 = new Thread(holder, "第四个线程");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
