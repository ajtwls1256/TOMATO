<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/admin/adminReview.css"/>    
</head>
<body>
	<%@include file="/admin/adminHeader.jsp" %>
	<section>
		<div class="admin-review-section">
			<div class="admin-review-title" style="display:inline-block;">상점후기</div>
			<div class="admin-review-search" style="display:inline-block;; float:right;">
				<select class="admin-review-search-select">
					<option>후기번호</option>
					<option>상점번호</option>
					<option>상점이름</option>
					<option>작성자</option>
				</select>
				<input type="text" class="admin-review-search-input"> 
				<input type="button" value="검색" class="admin-review-search-button">
			</div>
			
			
			 
			<div class="admin-review-div">
				<div class="table-wrapper admin-review-table-div" style="margin:0 auto;">
					<table class="table table-stariped admin-review-table" style="text-align: center; ">
						<tr>
							<td colspan="8" style="text-align:center; font-size: 18px; font-weight: bold;">후기 목록</td>
						</tr>
						<tr style="text-align:center; font-size: 16px; font-weight: bold;">
							<td>후기번호</td>
							<td>상점번호</td>
							<td>상점이름</td>
							<td>작성자</td>
							<td>내용</td>
							<td>별점</td>
							<td>작성일</td>
							<td>삭제</td>
						</tr>
						<tr class="admin-review-table-tr">
							<td><a href="#" class="admin-review-a">00001</a></td>
							<td>00001</td>
							<td>aaaa</td>
							<td>작성자a</td>
							<td>aaaaaaaaaaaaaaaa</td>
							<td>00000</td>
							<td>2019년 10월 20일</td>
							<td><input type="button" class="admin-review-button" value="삭제"></td>
						</tr>
						<tr>
							<td><a href="#" class="admin-review-a">00002</a></td>
							<td>00002</td>
							<td>bbbb</td>
							<td>작성자b</td>
							<td>bbbbbbbbbbbbbbbbbbbbbbbb</td>
							<td>00000</td>
							<td>2019년 10월 10일</td>
							<td><input type="button" class="admin-review-button" value="삭제"></td>
						</tr>
					</table>
				</div>
				
				<div class="table-wrapper admin-review-table-div2" style="margin:0 auto;">
					<table class="table table-stariped admin-review-table2" style="text-align: center; font-size: 15px;">
						<tr>
							<td colspan="4" style="text-align:center; font-size: 18px; font-weight: bold;">후기 내용</td>
						</tr>
						<tr style="text-align:left; font-size: 16px;">
							<td style="font-weight:bold">상품번호</td>
							<td><span>0001</span></td>
							<td style="font-weight:bold">작성자</td>
							<td><span>aaa</span></td>
						</tr>
						<tr class="admin-review-table-tr">
							<td colspan="4"><textarea name="adminReview" cols="50" rows="10"></textarea></td>
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
</body>
</html>