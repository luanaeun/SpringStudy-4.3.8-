package com.myspring.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	// DataSource Bean(객체)를 사용해서 DB연결 테스트하기. 
	
	// 1. 디비 연결 객체 생성
	@Inject
	private DataSource ds; 
	
	
	// 2. 주입된 객체가 있는지 체크 테스트.
	@Test
	public void DataSource객체확인테스트() {
		System.out.println("ds확인 : " + ds);
	}
	
	
	// 3. 디비 연결 테스트
	@Test
	public void Bean으로디비연결테스트() {
		try {
			Connection con = ds.getConnection();
			System.out.println("Bean으로 디비연결 확인 : " + con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
