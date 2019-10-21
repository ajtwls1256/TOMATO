<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/admin/adminPayment.css"/> 
</head>
<body>
	<%@include file="/admin/adminHeader.jsp" %>
	<section>
		<div class="admin-payment-section">
			<div class="admin-payment-title" style="display:inline;">결제관리</div>
			<div class="admin-payment-search" style="display:inline; float:right;">
				<select class="admin-payment-search-select">
					<option>상품번호</option>
					<option>회원번호</option>
					<option>거래번호</option>
					<option>결제상태</option>
				</select>
				<input type="text" class="admin-payment-search-input"> 
				<input type="button" value="검색" class="admin-payment-search-button">
			</div>
			
			
			
			 
			<div class="table-wrapper admin-payment-table-div" style="margin:0 auto;">
				<table class="table table-stariped admin-payment-table" style="text-align: center; ">
					<tr style="text-align:center; font-size: 16px; font-weight: bold;">
						<td>상품번호</td>   
						<td>회원번호</td>
						<td>거래번호</td>
						<td>금액</td>
						<td>결제일</td>
						<td>환불여부</td>
						<td>거래상태</td>
						<td>결제상태</td>
					</tr>
					<tr>
		 				<td>00001</td>
						<td>00001</td>
						<td>00001</td>
						<td>50,000원</td>
						<td>2019년 10월 20일</td>
						<td>X</td>
						<td>
							<select class="admin-select">
								<option>판매 중</option>
								<option>거래 중</option>
								<option>거래 완료</option>
							</select>
						</td>
						<td>
							<select class="admin-select">
								<option>결제 완료</option>
								<option>결제 취소</option>
							</selet>
						</td>
					</tr>
					<tr>
		 				<td>00002</td>
						<td>00002</td>
						<td>00002</td>
						<td>2,000원</td>
						<td>2019년 1월 20일</td>
						<td>O</td>
						<td>
							<select class="admin-select">
								<option>판매 중</option>
								<option>거래 중</option>
								<option>거래 완료</option>
							</select>
						</td>
						<td>
							<select class="admin-select">
								<option>결제 완료</option>
								<option>결제 취소</option>
							</selet>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</section>
</body>
</html>