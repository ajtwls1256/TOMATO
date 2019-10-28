<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="table-wrapper admin-review-table-div2"
		style="margin: 0 auto;">
		<form method="get" action="/adminNoticeInsert">
			<table class="table table-stariped admin-review-table2 table2"
				style="text-align: center; font-size: 15px;">
				<tr>
					<td colspan="4"
						style="text-align: center; font-size: 18px; font-weight: bold;">공지사항
						내용</td>
				</tr>
				<tr style="text-align: left; font-size: 16px;">
					<td style="font-weight: bold">제목 <input name=title type="text"></td>
				</tr>
				<tr class="admin-review-table-tr">
					<td colspan="4"><textarea name="content" cols="200" rows="20"
							class="content"></textarea></td>
				</tr>
				<tr>
					<td><button class=insert value='등록' type="submit">등록
						</button></td>
					<td><button type="reset">취소</button>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>