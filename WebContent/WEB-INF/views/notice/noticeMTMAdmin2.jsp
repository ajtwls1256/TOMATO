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
<title>1:1 문의 사항</title>
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<link rel="stylesheet" href="/css/admin/adminReview.css" />
</head>
<body>
<!-- 문의 내용  -->
	<div>
		<table
			style="text-align: center; font-size: 15px; margin: 0 auto; margin-top: 50px;">
			<tr>
				<td colspan="4"
					style="text-align: center; font-size: 18px; font-weight: bold;">1:1
					문의 내용</td>
			</tr>
			<tr style="text-align: left; font-size: 16px;">
				<td style="font-weight: bold">작성자 : <span class="memberId"><%=mtm.getMemberMTMNo() %></span></td>
			</tr>
			<tr>
				<td colspan="4"><textarea class="memberContent" id="summernote"><%=mtm.getNoticeMTMContent() %></textarea></td>
			</tr>
			<tr style="text-align: left; font-size: 16px;">
				<td style="font-weight: bold;">작성일 : <%=mtm.getNoticeMTMDate() %></td>
			</tr>
		</table>
		</div>
		
		<div>
		<!--  문의 답변 -->
		<!-- <form action="noticeMTMAdminInsert" method="get"> -->

			<table
				style="text-align: center; font-size: 15px; margin: 0 auto; margin-top: 50px;">
				<tr>
					<td colspan="4"
						style="text-align: center; font-size: 18px; font-weight: bold;">1:1
						문의 답변</td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="content"
							class="memberContent2" id="summernote1"><%=mtm.getNoticeMTMAnswerContent() %></textarea></td>
				</tr>

				<tr>
					<td><input type="hidden" name="no"
						value="<%=mtm.getNoticeMTMNo()%>"></td>
				</tr>
				<%if(mtm.getFileName()!=null){ %>
				<tr>
					<img src="/upload/noticeMTM/<%=mtm.getFileName()%>">
				</tr>
				<%} %>
			</table>
		</form>
		</div>
		<script>
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 400, // set editor height
			minHeight : null, // set minimum height of editor
			maxHeight : null, // set maximum height of editor
			focus : true,
			width : 1000
		// set focus to editable area after initializing summernote
		});
		
		$('#summernote1').summernote({
			height : 400, // set editor height
			minHeight : null, // set minimum height of editor
			maxHeight : null, // set maximum height of editor
			focus : true,
			width : 1000
		// set focus to editable area after initializing summernote
		});
	});
	</script>
</body>
</html>