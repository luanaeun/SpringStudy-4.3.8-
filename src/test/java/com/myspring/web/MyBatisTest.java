package com.myspring.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MyBatisTest {
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void SqlSessionFactory객체확인() {
		System.out.println("Factory객체 확인" + sqlFactory);
	}
	
	@Test
	public void MyBatis로DB연결확인() {
		SqlSession session = sqlFactory.openSession();
		System.out.println("DB연결 세션: " + session);
	}
}
