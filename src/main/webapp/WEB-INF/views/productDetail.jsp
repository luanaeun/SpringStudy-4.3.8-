<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>productDetail 페이지</h3>
  Hello! <br>
  msg : ${msg } <br>
  
  <hr>
  
  <h4>객체 하나하나 출력하기</h4>
  상품명: ${vo.name } <br>
  가격: ${vo.price } <br>
  
  <hr>
  <h4>이름없이 객체 전달: 전달되는 타입의 클래스명의 첫글자를 소문자로 바꿔서 이름으로 사용한다.</h4>
  ${productVO }<br>
  상품명: ${productVO.name } <br>
  
</body>
</html>