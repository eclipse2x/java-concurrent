package thread.problem.produceconsume;

/**
 * 面包类
 * @author eclipse
 */
public class Bread {
	private int index;
	
	private String desc;
	
	public Bread(String desc, int index) {
		this.index = index;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return desc + ", bread: " + index;
	}
}
