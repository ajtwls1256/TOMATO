<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form method="post" action="/adminNoticeInsert">
			<table class="table table-stariped admin-review-table2 table2"
				style="text-align: center; font-size: 15px;">
				<tr>
					<td colspan="4"
						style="text-align: center; font-size: 18px; font-weight: bold;">공지사항
						내용</td>
				</tr>
				<tr style="text-align: left; font-size: 16px;">
					<td style="font-weight: bold">제목 <input name=title type="text" style="width: 100%;"></td>
				</tr>
				<tr class="admin-review-table-tr">
					<td colspan="4"><textarea id="summernote"
							name="content" class="content"></textarea></td>
				</tr>
				<tr>
					<td><button class=insert value='등록' type="submit">등록
						</button>
						<button type="reset">취소</button></td>
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