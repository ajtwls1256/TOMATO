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
	padding: 5px;
	border-top: 1px solid #ededed;
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

.subject_content {
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

				$(".subject").click(function() {
					var index = $(".subject").index(this);

					$(this).siblings().toggle();

				});

			});
</script>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="noticeMTM_wrap">

		<div class="noticeMTM_header">
			<div class="noticeMTM_title">1:1 상담하기</div>
			<div class="noticeMTM_title">상담내역</div>
		</div>

		<script>
			$(document).ready(
					function() {
						$(".noticeMTM_sub_category").children().children(
								"select").hide();
						$(".1t").show();
						
						$(".total").change(
								function() {
									var array = new Array("계정문의", "차단(제재)", "거래신고",
											"서비스기능", "광고/전문상점", "서비스장애", "제안", "기타신고");

									var index = $(this).val();
									
									for (var i = 0; i < array.length; i++) {
										if (index === array[i]) {
											index = i + 1;
										}
									}
									$(".noticeMTM_sub_category").children().children(
									"select").hide();
									$("." + index + "t").show();
								});
					});

			
		</script>

		<div class="noticeMTM_article">
			<div class="noticeMTM">
				<div class="noticeMTM_main_category">
					<div>
						<select class="total">
							<option selected class="1" value="1">계정문의</option>
							<option class="2" value="2">차단(제재)</option>
							<option class="3" value="3">거래신고</option>
							<option class="4" value="4">서비스기능</option>
							<option class="5" value="5">광고/전문상점</option>
							<option class="6" value="6">서비스장애</option>
							<option class="7" value="7">제안</option>
							<option class="8" value="8">기타신고</option>
						</select>
					</div>
				</div>
				<div class="noticeMTM_sub_category">
					<div>
						<select class="1t">
							<option selected class="1-1">회원가입</option>
							<option class="1-2">재가입</option>
							<option class="1-3">탈퇴</option>
							<option class="1-4">기타</option>
						</select> <select class="2t">
							<option class="2-1" selected>해제요청</option>
							<option class="2-2">이용제한문의</option>
							<option class="2-3">기타</option>
						</select> <select class="3t">
							<option class="3-1" selected>미발송</option>
							<option class="3-2">환불</option>
							<option class="3-3">상태불량</option>
							<option class="3-4">착불</option>
							<option class="3-5">미입금</option>
							<option class="3-6">기타</option>
						</select> <select class="4t">
							<option class="4-1" selected>안전결제</option>
							<option class="4-2">상품.상점</option>
							<option class="4-3">배송서비스(택배)</option>
							<option class="4-4">기타</option>
						</select> <select class="5t">
							<option class="5-1" selected>광고</option>
							<option class="5-2">전문상점</option>
							<option class="5-3">기타</option>
						</select> <select class="6t">
							<option class="6-1" selected>웹</option>
							<option class="6-2">알림</option>
							<option class="6-3">기능동작오류</option>
							<option class="6-4">택배관련</option>
							<option class="6-5">본인인증 오류</option>
							<option class="6-6">기타</option>
						</select> <select class="7t">
							<option class="7-1" selected>기능제안</option>
							<option class="7-2">기타</option>
						</select> <select class="8t">
							<option class="8-1" selected>제제사항</option>
							<option class="8-2">리뷰삭제요청</option>
							<option class="8-3">나눔사기</option>
							<option class="8-4">제보</option>
							<option class="8-5">기타</option>
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