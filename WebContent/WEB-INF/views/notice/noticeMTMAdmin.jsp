<%@page import="kr.co.tomato.noitceMTM.model.vo.NoticeMTM"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    NoticeMTM mtm = (NoticeMTM)request.getAttribute("mtm");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=mtm.getNoticeMTMMainCategory() %> > <%=mtm.getNoticeMTMSubCategory() %> 문의사항</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/css/admin/adminReview.css" />
</head>
<body>
	<!-- 문의 내용  -->
	<div class="table-wrapper admin-review-table-div2 table2"
		style="margin: 0 auto; text-align: center;">
		<table class="table table-stariped admin-review-table2"
			style="text-align: center; font-size: 15px;">
			<tr>
				<td colspan="4"
					style="text-align: center; font-size: 18px; font-weight: bold;">1:1
					문의 내용</td>
			</tr>
			<tr style="text-align: left; font-size: 16px;">
				<td style="font-weight: bold">작성자</td>
				<td><span class="memberId"><%=mtm.getMemberMTMNo() %></span></td>
			</tr>
			<tr class="admin-review-table-tr">
				<td colspan="4"><textarea class="memberContent" cols="200"
						rows="20"><%=mtm.getNoticeMTMContent() %></textarea></td>
			</tr>
			<tr style="text-align: left; font-size: 16px;">
				<td style="font-weight: bold;">작성일</td>
				<td colspan="3" class="memberDate"><%=mtm.getNoticeMTMDate() %></td>
			</tr>
		</table>
		<!--  문의 답변 -->
		<form action="noticeMTMAdminInsert" method="get">

			<table class="table table-stariped admin-review-table2 table3"
				style="text-align: center; font-size: 15px;">
				<tr>
					<td colspan="4"
						style="text-align: center; font-size: 18px; font-weight: bold;">1:1
						문의 답변</td>
				</tr>
				<tr class="admin-review-table-tr">
					<td colspan="4"><textarea cols="200" rows="20" name="content"
							class="memberContent2"></textarea></td>
				</tr>

				<tr>
					<td><input type="hidden" name="no"
						value="<%=mtm.getNoticeMTMNo()%>"></td>
					<td>
						<button type="submit" class="sub">작성</button>
					</td>
					<td>
						<button type="reset" class="sub">취소</button>
					</td>
				</tr>
				
				<tr>
					<img src="/upload/noticeMTM/<%=mtm.getFileName() %>">
				</tr>
			</table>
		</form>
		</div>
</body>
</html>