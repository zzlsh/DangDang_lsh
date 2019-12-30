package com.lsh.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取sqlSession对象
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = tl.get();
		if(sqlSession == null){
			sqlSession = sqlSessionFactory.openSession();
			tl.set(sqlSession);
		}
		return sqlSession;
	}
	
	//关闭资源
	public static void close(SqlSession sqlSession){
		if(sqlSession !=null) {
			sqlSession.close();
			tl.remove();
		}	
	}
	
	//提交
	public static void commit(SqlSession sqlSession){
		sqlSession.commit();
		close(sqlSession);
	}
	
	//回滚
	public static void rollback(SqlSession sqlSession){
		sqlSession.rollback();
		close(sqlSession);
	}
	
}
