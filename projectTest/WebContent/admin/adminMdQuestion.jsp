<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/admin/adminMdQuestion.css"/>    
</head>
<body>
	<%@include file="/admin/adminHeader.jsp" %>
	<section>
		<div class="admin-question-section">
			<div class="admin-question-title" style="display:inline-block;">상품문의</div>
			<div class="admin-question-search" style="display:inline-block;; float:right;">
				<select class="admin-question-search-select">
					<option>상품번호</option>
					<option>작성자</option>
				</select>
				<input type="text" class="admin-question-search-input"> 
				<input type="button" value="검색" class="admin-question-search-button">
			</div>
			
			
			 
			<div class="admin-question-div">
				<div class="table-wrapper admin-question-table-div" style="margin:0 auto;">
					<table class="table table-stariped admin-question-table" style="text-align: center; ">
						<tr>
							<td colspan="5" style="text-align:center; font-size: 18px; font-weight: bold;">문의 목록</td>
						</tr>
						<tr style="text-align:center; font-size: 16px; font-weight: bold;">
							<td>상품번호</td>
							<td>작성자</td>
							<td>문의 내용</td>
							<td>작성일</td>
							<td>삭제</td>
						</tr>
						<tr class="admin-question-table-tr">
							<td><a href="#" class="admin-question-a">00001</a></td>
							<td>aaaa</td>
							<td>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</td>
							<td>2019년 10월 20일</td>
							<td><input type="button" class="admin-question-button" value="삭제"></td>
						</tr>
						<tr>
							<td><a href="#" class="admin-question-a">00002</a></td>
							<td>bbbb</td>
							<td>bbbbbbbbbbbbbbbbbbbbbbbbbbbb</td>
							<td>2019년 9월 3일</td>
							<td><input type="button" class="admin-question-button" value="삭제"></td>
						</tr>
					</table>
				</div>
				
				<div class="table-wrapper admin-question-table-div2" style="margin:0 auto;">
					<table class="table table-stariped admin-question-table2" style="text-align: center; font-size: 15px;">
						<tr>
							<td colspan="4" style="text-align:center; font-size: 18px; font-weight: bold;">문의 내용</td>
						</tr>
						<tr style="text-align:left; font-size: 16px;">
							<td style="font-weight:bold">상품번호</td>
							<td><span>0001</span></td>
							<td style="font-weight:bold">작성자</td>
							<td><span>aaa</span></td>
						</tr>
						<tr class="admin-question-table-tr">
							<td colspan="4"><textarea name="adminQuestion" cols="50" rows="10"></textarea></td>
						</tr>
						<tr style="text-align:left; font-size: 16px;">	
							<td style="font-weight:bold;">작성일</td>
							<td colspan="3">2019년 10월 20일</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</section>
</html>