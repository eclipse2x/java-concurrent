package thread.problem.produceconsume;

/**
 * 生产者
 * @author eclipse
 */
public class Producer implements Runnable {
	
	private Stack stack;
	
	public Producer(Stack stack) {
		this.stack = stack;
	}

	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			Bread bread = new Bread(Thread.currentThread().getName() + "生产的面包", i);
			stack.put(bread);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
