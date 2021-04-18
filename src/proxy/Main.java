package proxy;

import java.lang.reflect.Proxy;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author kaiz
 * @date 下午2:06 2021/4/17.
 */
public class Main {
	public static void main(String[] args) {
//		UserService userService = new UserServiceImpl();
//
//		UserService proxyUserService = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(),
//				new Class[]{UserService.class},
//				new JDKProxyHandler(userService));
//
//		proxyUserService.add();

		UserServiceImpl userService1 = new UserServiceImpl();
		CglibProxy cglibProxy = new CglibProxy();
		UserServiceImpl userServiceCglibProxy = (UserServiceImpl) cglibProxy.getInstance(userService1);
		userServiceCglibProxy.add();

	}
}
