package proxy.statics;

/**
 * @author sunzl
 * @date 2018年12月14日
 *
 */
public class Test {

	public static void main(String[] args) {
		CountImpl countImpl = new CountImpl();
		CountProxy countProxy = new CountProxy(countImpl);
		countProxy.updateCount();
		countProxy.queryCount();
	}
}
