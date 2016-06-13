package concurrent.happenbofore;

public class VolatileExample {
	private int a = 0;
	private boolean flag = false;
	
	public void write() throws Exception {
		a = 1;
		flag = true;
	}
	
	public void read() throws Exception {
		if (flag) {
			System.out.println("a=" + a + ";flag=" + flag);
		}
	}
	
	public static void main(String []args) throws Exception {
		for (int i=0; i<10000; i++) {
			VolatileExample example = new VolatileExample();
			Thread w1 = new Thread(new WriteRunner(example), "writer1");
			w1.start();
			
			Thread r1 = new Thread(new ReadRunner(example, w1), "reader1");
			Thread r2 = new Thread(new ReadRunner(example, w1), "reader2");
			Thread r3 = new Thread(new ReadRunner(example, w1), "reader3");
			r1.start();
			r2.start();
			r3.start();
		}
	}

	static class WriteRunner implements Runnable {
		VolatileExample example ;
		
		public WriteRunner(VolatileExample example) {
			this.example = example;
		}

		@Override
		public void run() {
			try {
				example.write();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	static class ReadRunner implements Runnable {
		VolatileExample example ;
		Thread before;
		
		public ReadRunner(VolatileExample example, Thread before) {
			this.example = example;
			this.before = before;
		}

		@Override
		public void run() {
			try {
				before.join();
				example.read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
