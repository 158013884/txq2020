package util;

public class ServiceFactory {
	public static Object getService(Object service) {
		return new TransactionInvocationHandle(service).getProxy();
	}
}
