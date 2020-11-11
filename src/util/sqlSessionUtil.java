package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class sqlSessionUtil {
	private sqlSessionUtil() {}
	
	private static SqlSessionFactory sessionFactory;
	static {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//获取session对象
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	
	public static SqlSession getSession() {
		SqlSession session = threadLocal.get();
		if (session == null) {
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}
	
	//关闭session对象
	public static void closeSession(SqlSession session) {
		if (session != null) {
			session.close();
			threadLocal.remove();
		}
	}
}
