package thread.problem.produceconsume;

/**
 * 消费者
 * @author eclipse
 *
 */
public class Consumer implements Runnable {
	private Stack stack;
	
	public Consumer(Stack stack) {
		this.stack = stack;
	}
	
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			stack.pop();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
