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

</head>
<body>
<div>
		<form method="post" action="/adminNoticeUpdate">
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
					<td colspan="4"><textarea name="content" id="summernote"
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
	<script>
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 400, // set editor height
			minHeight : null, // set minimum height of editor
			maxHeight : null, // set maximum height of editor
			focus : true
		// set focus to editable area after initializing summernote
		});
	});
	</script>
</body>
</html>