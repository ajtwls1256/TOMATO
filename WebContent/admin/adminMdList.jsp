<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/admin/adminMdList.css"/> 
</head>
<body>
	<%@include file="/admin/adminHeader.jsp" %>
	<section>
		<div class="admin-MdList-section">
			<div class="admin-MdList-title" style="display:inline;">상품목록</div>
			<div class="admin-MdList-search" style="display:inline; float:right;">
				<select class="admin-MdList-search-select">
					<option>상품번호</option>
					<option>회원번호</option>
					<option>상품명</option>
					<option>거래상태</option>
				</select>
				<input type="text" class="admin-MdList-search-input"> 
				<input type="button" value="검색" class="admin-MdList-search-button">
			</div>
			
			
			
			 
			<div class="table-wrapper admin-MdList-table-div" style="margin:0 auto;">
				<table class="table table-stariped admin-MdList-table" style="text-align: center; ">
					<tr style="text-align:center; font-size: 16px; font-weight: bold;">
						<td>상품번호</td>   
						<td>회원번호</td>
						<td>카테고리1</td>
						<td>카테고리2</td>
						<td>상품명</td>
						<td>가격</td>
						<td>상태</td>
						<td>거래상태</td>
						<td>등록일</td>
					</tr>
					<tr>
		 				<td>00001</td>
						<td>00001</td>
						<td>여성의류</td>
						<td>상의</td>
						<td>aaaaa</td>
						<td>50,000원</td>
						<td>새상품</td>
						<td>
							<select class="admin-select">
								<option>판매 중</option>
								<option>거래 중</option>
								<option>거래 완료</option>
							</select>
						</td>
						<td>2019년 10월 20일</td>
					</tr>
					<tr>
		 				<td>00002</td>
						<td>00002</td>
						<td>디지털/가전</td>
						<td>카메라</td>
						<td>bbbbb</td>
						<td>100,000원</td>
						<td>중고</td>
						<td>
							<select class="admin-select">
								<option>판매 중</option>
								<option>거래 중</option>
								<option>거래 완료</option>
							</select>
						</td>
						<td>2019년 8월 20일</td>
					</tr>
				</table>
			</div>
		</div>
	</section>
</body>
</html>