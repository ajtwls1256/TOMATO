<%@page import="kr.co.tomato.notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	Notice n = (Notice)request.getAttribute("n");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<div class="table-wrapper admin-review-table-div2"
		style="margin: 0 auto;">
		<form method="get" action="/adminNoticeUpdate">
			<table class="table table-stariped admin-review-table2 table1"
				style="text-align: center; font-size: 15px;">
				<tr>
					<td colspan="4"
						style="text-align: center; font-size: 18px; font-weight: bold;">공지사항
						내용</td>
				</tr>
				<tr style="text-align: left; font-size: 16px;">
					<td style="font-weight: bold">제목 <input type="text"
						style="width: 100%;" name="title" value="<%=n.getNoticeTitle()%>"></td>
				</tr>
				<tr class="admin-review-table-tr">
					<td colspan="4"><textarea name="content" cols="200" rows="20"
							class="content" style="margin-top: 20px;"><%=n.getNoticeContent()%></textarea></td>
				</tr>
				<tr style="text-align: left; font-size: 16px;">
					<td style="font-weight: bold;">작성일 <%=n.getNoticeDate()%></td>
				</tr>
				<input type="hidden" name="no" value="<%=n.getNoticeNo()%>">
				<tr>
					<td><button type="submit" class=update value='수정'>수정</button>
					
					<button type="button" class=exit value='취소'>취소</button>
					
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>