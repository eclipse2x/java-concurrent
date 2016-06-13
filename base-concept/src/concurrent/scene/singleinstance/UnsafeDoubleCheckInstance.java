package concurrent.scene.singleinstance;

/**
 * 双重加锁的例子，注意此例子不能保证线程安全
 * @author Administrator
 *
 */
public class UnsafeDoubleCheckInstance {
	private static UnsafeDoubleCheckInstance instance;
	
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
