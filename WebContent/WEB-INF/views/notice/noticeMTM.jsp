<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<style>
.noticeMTM_wrap {
	width: 1000px;
	margin: 0 auto;
	margin-top: 10px;
}

.noticeMTM_header {
	width: 100%;
	height: 44px;
	text-align: center;
}

.noticeMTM_article {
	width: 100%;
}

.noticeMTM_main_category select {
	width: 100%;
	margin-top: 10px;
	padding: 3px;
}

.noticeMTM_sub_category select {
	width: 100%;
	margin-top: 10px;
	padding: 3px;
}

.noticeMTM_content {
	margin-top: 10px;
}

.noticeMTM_content textarea {
	padding: 10px;
}

.content {
	width: 100%;
	height: 300px;
}

.file {
	display: inline;
}

.file button {
	width: 150px;
	height: 35px;
	cursor: pointer;
}

.submit {
	float: right;
}

.submit button {
	width: 150px;
	height: 35px;
	cursor: pointer;
}

.noticeMTM_title {
	width: 50%;
	float: left;
	height: 44px;
	line-height: 44px;
}

.subject {
	padding: 5px; border-top : 1px solid #ededed;
	border-bottom: 1px solid #ededed;
	border-top: 1px solid #ededed;
}

.subject p span:last-child {
	float: right;
}

.noticeMTM {
	width: 100%;
	margin: 0 auto;
	margin-top: 10px;
	height: 47px;
}
.subject_content{
display: none;
}
</style>

<script>
	$(document).ready(
			function() {
				$(".noitceMTM").hide();
				$(".noticeMTM_title").css("border-bottom", "none").css("color",
						"black");

				$(".noticeMTM_title").click(
						function() {
							$(".noticeMTM_title").css("border-bottom", "none")
									.css("color", "black");
							$(this).css("border-bottom", "2px solid #C42026")
									.css("color", "#C42026");
							$(".noticeMTM").hide();
							var index = $(".noticeMTM_title").index(this);
							$(this).parent().siblings().children().eq(index)
									.show();

						});

				$(".noticeMTM_title").eq(0).click();
				
				$(".subject").click(function () {
					var index = $(".subject").index(this);
					
					$(this).siblings().toggle();
					
			});

	
	});
</script>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="noticeMTM_wrap">

		<div class="noticeMTM_header">
			<div class="noticeMTM_title">1:1 상담하기 </div>
			<div class="noticeMTM_title">상담내역</div>
		</div>

		<div class="noticeMTM_article">
			<div class="noticeMTM">
				<div class="noticeMTM_main_category">
					<div>
						<select>
							<option>계정문의</option>
						</select>
					</div>
				</div>

				<div class="noticeMTM_sub_category">
					<div>
						<select>
							<option>회원가입</option>
						</select>
					</div>

				</div>

				<div class="noticeMTM_content">
					<textarea class="content">컨텐츠 내용입니다.</textarea>
				</div>

				<div class="footer">
					<div class="file">
						<button type="button">사진 첨부</button>
					</div>

					<div class="submit">
						<button type="submit">상담신청</button>
					</div>
				</div>
			</div>
			<div class="noticeMTM">
				<div class="subject">
					<p>
						<span>대분류 > 소분류</span> <span id=complete> 확인중 </span>
					</p>
					<p>날짜</p>
				</div>
				
				<div class="subject_content">
					<div class="subject_anwser_wrap">
						<div class="subject_anwser">
							<p>번장운영센터 답변</p>
							<p>날짜</p>
						</div>
						<div class="subject_anwser_final">
							<p>답변한 내용</p>
						</div>
					</div>

					<div class="subject_content_wrap">
						<div class="subject_content">
							<p>문의내용</p>
							<p>날짜</p>
						</div>
						<div class="subject_content_final">
							<p>질문한 내용</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>