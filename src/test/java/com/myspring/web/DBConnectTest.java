package com.myspring.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class DBConnectTest {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/springdb";
	private static final String DBID = "root";
	private static final String DBPW = "1234";
	
	
	// 디비연결 테스트()
	// @Test 어노테이션이 있어야지만 테스트가 가능하다
	@Test
	public void testCon() throws Exception {
		System.out.println(" Test : Junit을 사용한 테스트 메서드! 1");
	}
	
	@Test
	public void 디비연결테스트() {
		System.out.println(" Test : Junit을 사용한 테스트 메서드! 2");
		
		// try-with구문 (최소 자바 1.7 이상)
		// AutoCloseable 인터페이스를 구현하는 객체들을 try ()안에 작성하면
		// 객체를 사용후 자동으로 리소스 해제 
		
		try(Connection con = DriverManager.getConnection(DBURL, DBID, DBPW)) {
			// 1. 드라이버 로드
			Class.forName(DRIVER);
			System.out.println(" Test : 드라이버로드 성공! ");
			
			// 2. 디비연결
			System.out.println(" Test : 디비연결 성공 ");
			System.out.println(" Test : "+con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
	}

}
