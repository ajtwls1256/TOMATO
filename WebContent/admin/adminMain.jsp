<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/admin/adminMain.css"/> 
</head>
<body>
	<%@include file="/admin/adminHeader.jsp" %>
	<section>
		<div class="admin-main-section">
			<div class="admin-main-title" style="display:inline-block;">메인 슬라이더</div>
			
			<div class="admin-main-div">
				<div class="table-wrapper admin-main-table-div" style="margin:0 auto;">
					<table class="table table-stariped admin-main-table" style="text-align: center; ">
						<tr>
							<td colspan="3" style="text-align:center; font-size: 18px; font-weight: bold;">사진 목록</td>
						</tr>
						<tr style="text-align:center; font-size: 16px; font-weight: bold;">
							<td>사진</td>
							<td>등록일</td>
							<td>삭제</td>
						</tr>
						<tr class="admin-main-table-tr">
							<td><img src=""></td>
							<td>2019년 10월 20일</td>
							<td><input type="button" class="admin-main-button" value="삭제"></td>
						</tr>
						<tr>
							<td><img src=""></td>
							<td>2019년 10월 20일</td>
							<td><input type="button" class="admin-main-button" value="삭제"></td>
						</tr>
					</table>
				</div>
				
				<div class="table-wrapper admin-main-table-div2" style="margin:0 auto;">
					<table class="table table-stariped admin-main-table2" style="text-align: center; font-size: 15px;">
						<tr>
							<td colspan="4" style="text-align:center; font-size: 18px; font-weight: bold;">사진 추가</td>
						</tr>
						<tr style="text-align:left; font-size: 16px;">
							<td style="font-weight:bold">사진 첨부</td>
							<td colspan="3"><input type="file" name="filename"></td> 
						</tr>
						<tr class="admin-main-table-tr">
							<td colspan="4" style="height:440px;">
								<img src="#" style="width:600px; height: 300px; margin-top: 50px;">  
							</td>
						</tr>
						<tr style="text-align:left; font-size: 16px;">	
							<td style="font-weight:bold;">작성일</td>
							<td colspan="3">2019년 10월 20일</td>
						</tr>
						<tr>
							<td colspan="4"><input type="button" value="등록하기" id=""></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</section>
</body>
</html>