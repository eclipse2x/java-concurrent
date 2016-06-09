package thread.problem.produceconsume;

import java.util.ArrayList;
import java.util.List;

/**
 * 货品堆栈
 * @author eclipse
 *
 */
public class Stack {
	/**
	 * 最大容量
	 */
	private static final int CAPACITY = 10;
	
	private List<Bread> list = new ArrayList<Bread>();
	
	/**
	 * 放入面包，如果容量已满则等待并唤醒其他线程
	 * @param bread
	 */
	public synchronized void put(Bread bread) {
		while (list.size() >= CAPACITY) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		list.add(bread);
		this.notifyAll();
		System.out.println(bread);
	}
	
	/**
	 * 拿出面包，如果容量为空则等待并唤醒其他线程
	 * @return
	 */
	public synchronized Bread pop() {
		while (list.size() == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 如果只是 notify() ，在极端情况下可能出现一直循环唤醒同类线程导致活锁
		this.notifyAll();
		Bread bread = list.remove(0);
		System.out.println(Thread.currentThread().getName() + "消费了" + bread.toString());
		return bread;
	}
}
