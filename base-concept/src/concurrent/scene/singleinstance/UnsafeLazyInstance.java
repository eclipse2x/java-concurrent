package concurrent.scene.singleinstance;

/**
 * 典型非安全单例模式
 * @author Administrator
 */
public class UnsafeLazyInstance {
	private static UnsafeLazyInstance instance = null;
	
	public static UnsafeLazyInstance getInstance() {
		if (instance == null) {
			instance = new UnsafeLazyInstance();
		}
		
		return instance;
	}
}
