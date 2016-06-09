package thread.problem.produceconsume;

/**
 * 生产者消费者模式的主类
 * @author eclipse
 */
public class ProduceConsume {
	public static void main(String []args) {
		Stack stack = new Stack();
		
		Producer producer = new Producer(stack);
		Consumer consumer = new Consumer(stack);

		Thread p1 = new Thread(producer, "producer 1");
		Thread p2 = new Thread(producer, "producer 2");
		Thread p3 = new Thread(producer, "producer 3");

		Thread c1 = new Thread(consumer, "consumer 1");
		Thread c2 = new Thread(consumer, "consumer 2");
		Thread c3 = new Thread(consumer, "consumer 3");
		
		p1.start();
		p2.start();
		
		c1.start();
		c2.start();
		
		p3.start();
		c3.start();
	}
}
