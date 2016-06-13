package concurrent.scene.singleinstance;

/**
 * 通过内部类来持有实例
 * @author Administrator
 *
 */
public class HoldInstance {
	private static class InnerHolder {
		private static HoldInstance instance = new HoldInstance();
	}
	
	public static HoldInstance getInstance() {
		return InnerHolder.instance;
	}
}
