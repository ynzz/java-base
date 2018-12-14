package proxy.statics;

/**
 * @author sunzl
 * @date 2018年12月14日
 *
 */
public class CountProxy implements Count{
	
	// 组合一个业务实现类对象来进行真正的业务方法的调用
	private CountImpl countImpl;
	
	public CountProxy(CountImpl countImpl) {
		this.countImpl = countImpl;
	}
	
	@Override
	public void queryCount() {
		System.out.println("查询账户之前的预处理");
		// 调用真正的查询账户方法
		countImpl.queryCount();
		System.out.println("查询账户之后的操作");
	}

	@Override
	public void updateCount() {
		System.out.println("修改账户之前的预处理");
		// 调用真正的修改账户操作
		countImpl.updateCount();
		System.out.println("修改账户之后的操作");
	}
	
	
}
