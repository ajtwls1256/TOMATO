<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/admin/adminMember.css"/>    
</head>
<body>
	<%@include file="/admin/adminHeader.jsp" %>
	<section>
		<div class="admin-member-section">
			<div class="admin-member-title" style="display:inline;">회원관리</div>
			<div class="admin-member-search" style="display:inline; float:right;">
				<select class="admin-member-search-select">
					<option>회원번호</option>
					<option>아이디</option>
					<option>상점명</option>
				</select>
				<input type="text" class="admin-member-search-input"> 
				<input type="button" value="검색" class="admin-member-search-button">
			</div>
			
			
			
			 
			<div class="table-wrapper admin-member-table-div" style="margin:0 auto;">
				<table class="table table-stariped admin-member-table" style="text-align: center; ">
					<tr style="text-align:center; font-size: 16px; font-weight: bold;">
						<td>회원번호</td>
						<td>이메일</td>
						<td>상점명</td>
						<td>이름</td>
						<td>연락처</td>
						<td>주소</td>
						<td>가입일</td>
						<td>탈퇴</td>
					</tr>
					<tr class="admin-member-table-tr">
						<td style="line-height: 28px;">00001</td>
						<td style="line-height: 28px;">aaa@gmail.com</td>
						<td style="line-height: 28px;">aaa상점</td>
						<td style="line-height: 28px;">aaa</td>
						<td style="line-height: 28px;">010-1111-1111</td>
						<td style="line-height: 28px;">서울특별시 동작구 사당동</td>
						<td style="line-height: 28px;">2019년 10월 20일</td>
						<td style="line-height: 28px;"><input type="button" class="admin-member-button" value="탈퇴"></td>
					</tr>
					<tr>
						<td>00002</td>
						<td>bbb@gmail.com</td>
						<td>bbb상점</td>
						<td>bbb</td>
						<td>010-2222-2222</td>
						<td>서울특별시 영등포구 당산동</td>
						<td>2019년 10월 20일</td>
						<td><input type="button" class="admin-member-button" value="탈퇴"></td>
					</tr>
				</table>
			</div>
		</div>
	</section>
</body>
</html>