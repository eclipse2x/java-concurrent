package concurrent.scene.singleinstance;

/**
 * 安全的双重检查例子
 * @author Administrator
 *
 */
public class SafeDoubleCheckInstance {
	private volatile static UnsafeDoubleCheckInstance instance;
	
	public static UnsafeDoubleCheckInstance getIsntance() {
		if (instance == null) {
			synchronized (UnsafeDoubleCheckInstance.class) {
				if (instance == null) {
					instance = new UnsafeDoubleCheckInstance();
				}
			}
		}
		
		return instance;
	}
}
