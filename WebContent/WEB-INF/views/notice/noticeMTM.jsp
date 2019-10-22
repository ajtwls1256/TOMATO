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
						//sub 초기값 
						$(".1t").show();

						//초기값 
						$.ajax({
							url : "/ajaxCategory",
							type : "get",
							data : {
								sub : $(".1-1").val()
							},
							success : function(data) {
								$(".content").html(data);
							},
							error : function() {

							}
						});

						$(".total").change(
								function() {

									var array = new Array("계정문의", "차단(제재)",
											"거래신고", "서비스기능", "광고/전문상점",
											"서비스장애", "제안", "기타신고");

									var index = $(this).val();

									for (var i = 0; i < array.length; i++) {
										if (index === array[i]) {
											index = i + 1;
										}
									}
									$(".noticeMTM_sub_category").children()
											.children("select").hide();
									$("." + index + "t").show();

									if (index == 2) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".2-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 3) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".3-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 4) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".4-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 5) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".5-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 6) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".6-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 7) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".7-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 8) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".8-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									}
								});

						//서브 카테고리 변경 시 들어갈 content 값

						$(".1t").change(function() {
							var array = new Array("회원가입", "재가입", "탈퇴", "기타");

							var index = $(this).val();

							for (var i = 0; i < array.length; i++) {
								if (index === array[i]) {
									index = i + 1;
								}
							}

							if (index == 1) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".1-1").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							} else if (index == 2) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".1-2").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							} else if (index == 3) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".1-3").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							} else if (index == 4) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".1-4").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							}
						});

						// sub 2

						$(".2t").change(function() {
							var array = new Array("해제요청", "이용제한문의", "기타");

							var index = $(this).val();

							for (var i = 0; i < array.length; i++) {
								if (index === array[i]) {
									index = i + 1;
								}
							}

							if (index == 1) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".2-1").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							} else if (index == 2) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".2-2").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							} else if (index == 3) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".1-4").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							}
						});

						// sub 3

						$(".3t").change(
								function() {
									var array = new Array("미발송", "환불", "상태불량",
											"착불", "미입금", "기타");

									var index = $(this).val();

									for (var i = 0; i < array.length; i++) {
										if (index === array[i]) {
											index = i + 1;
										}
									}

									if (index == 1) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".3-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 2) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".3-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 3) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".3-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 4) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".3-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 5) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".3-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 6) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".1-4").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									}
								});

						// sub 4

						$(".4t").change(
								function() {
									var array = new Array("안전결제", "상품.상점",
											"배송서비스(택배)", "기타");

									var index = $(this).val();

									for (var i = 0; i < array.length; i++) {
										if (index === array[i]) {
											index = i + 1;
										}
									}

									if (index == 1) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".4-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 2) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".4-2").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 3) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".4-2").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 4) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".1-4").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									}
								});

						// sub 5

						$(".5t").change(function() {
							var array = new Array("광고", "전문상점", "기타");

							var index = $(this).val();

							for (var i = 0; i < array.length; i++) {
								if (index === array[i]) {
									index = i + 1;
								}
							}

							if (index == 1) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".5-1").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							} else if (index == 2) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".5-1").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							} else if (index == 3) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".1-4").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							}
						});

						// sub 6

						$(".6t").change(
								function() {
									var array = new Array("웹", "알림", "기능동작오류",
											"택배관련", "기타");

									var index = $(this).val();

									for (var i = 0; i < array.length; i++) {
										if (index === array[i]) {
											index = i + 1;
										}
									}

									if (index == 1) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".6-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 2) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".6-2").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 3) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".6-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 4) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".6-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 5) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".1-4").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									}
								});

						// sub 7

						$(".7t").change(function() {
							var array = new Array("기능제안", "기타");

							var index = $(this).val();

							for (var i = 0; i < array.length; i++) {
								if (index === array[i]) {
									index = i + 1;
								}
							}

							if (index == 1) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".7-1").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							} else if (index == 2) {
								$.ajax({
									url : "/ajaxCategory",
									type : "get",
									data : {
										sub : $(".1-4").val()
									},
									success : function(data) {
										$(".content").html(data);
									},
									error : function() {

									}
								});
							}
						});

						// sub 8

						$(".8t").change(
								function() {
									var array = new Array("제재사항", "리뷰삭제요청",
											"나눔사기", "제보", "기타");

									var index = $(this).val();

									for (var i = 0; i < array.length; i++) {
										if (index === array[i]) {
											index = i + 1;
										}
									}

									if (index == 1) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".8-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 2) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".8-2").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 3) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".8-1").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 4) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".8-4").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									} else if (index == 5) {
										$.ajax({
											url : "/ajaxCategory",
											type : "get",
											data : {
												sub : $(".1-4").val()
											},
											success : function(data) {
												$(".content").html(data);
											},
											error : function() {

											}
										});
									}
								});
					});
		</script>

		<div class="noticeMTM_article">
			<div class="noticeMTM">
				<div class="noticeMTM_main_category">
					<div>
						<form method="post" action="/noticeMTMInsert"
							enctype="multipart/form-data">
							<select class="total" name="main">
								<option selected class="1" value="계정문의">계정문의</option>
								<option class="2" value="차단(제재)">차단(제재)</option>
								<option class="3" value="거래신고">거래신고</option>
								<option class="4" value="서비스기능">서비스기능</option>
								<option class="5" value="광고/전문상점">광고/전문상점</option>
								<option class="6" value="서비스장애">서비스장애</option>
								<option class="7" value="제안">제안</option>
								<option class="8" value="기타신고">기타신고</option>
							</select>
					</div>
				</div>
				<div class="noticeMTM_sub_category">
					<div>
						<select class="1t" name="sub">
							<option selected class="1-1" value="회원가입">회원가입</option>
							<option class="1-2" value="재가입">재가입</option>
							<option class="1-3" value="탈퇴">탈퇴</option>
							<option class="1-4" value="기타">기타</option>
						</select> <select class="2t">
							<option class="2-1" selected value="해제요청">해제요청</option>
							<option class="2-2" value="이용제한문의">이용제한문의</option>
							<option class="2-3" value="기타">기타</option>
						</select> <select class="3t">
							<option class="3-1" selected value="미발송">미발송</option>
							<option class="3-2" value="환불">환불</option>
							<option class="3-3" value="상태불량">상태불량</option>
							<option class="3-4" value="착불">착불</option>
							<option class="3-5" value="미입금">미입금</option>
							<option class="3-6" value="기타">기타</option>
						</select> <select class="4t">
							<option class="4-1" selected value="안전결제">안전결제</option>
							<option class="4-2" value="상품.상점">상품.상점</option>
							<option class="4-3" value="배송서비스(택배)">배송서비스(택배)</option>
							<option class="4-4" value="기타">기타</option>
						</select> <select class="5t">
							<option class="5-1" selected value="광고">광고</option>
							<option class="5-2" value="전문상점">전문상점</option>
							<option class="5-3" value="기타">기타</option>
						</select> <select class="6t">
							<option class="6-1" selected value="웹">웹</option>
							<option class="6-2" value="알림">알림</option>
							<option class="6-3" value="기능동작오류">기능동작오류</option>
							<option class="6-4" value="택배관련">택배관련</option>
							<option class="6-5" value="기타">기타</option>
						</select> <select class="7t">
							<option class="7-1" selected value="기능제안">기능제안</option>
							<option class="7-2" value="기타">기타</option>
						</select> <select class="8t">
							<option class="8-1" selected value="기타">제재사항</option>
							<option class="8-2" value="리뷰삭제요청">리뷰삭제요청</option>
							<option class="8-3" value="나눔사기">나눔사기</option>
							<option class="8-4" value="제보">제보</option>
							<option class="8-5" value="기타">기타</option>
						</select>
					</div>

				</div>

				<div class="noticeMTM_content">
					<textarea class="content" name="content"></textarea>
				</div>

				<div class="footer">
					<div class="file">
						<input type="file" name="filename">
					</div>

					<div class="submit">
						<button type="submit">상담신청</button>
					</div>
				</div>
				</form>
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