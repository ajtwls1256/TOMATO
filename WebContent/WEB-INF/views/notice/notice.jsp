<%@page import="kr.co.tomato.notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
%>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.notice {
	width: 33.3%;
	float: left;
	height: 44px;
	line-height: 44px;
	background: white;
}

.noticeContent {
	display: none;
	background: white;
}
</style>

<script>
	$(document)
			.ready(
					function() {

						$(".noticeContent1").hide();
						$(".notice").css("border-bottom", "none").css("color",
								"black");

						$(".notice").click(
								function() {

									$(".notice").css("border-bottom", "none")
											.css("color", "black");
									$(this).css("border-bottom",
											"2px solid #C42026").css("color",
											"#C42026");

									$(".noticeContent1").hide();
									var index = $(".notice").index(this);
									$(this).parent().siblings().children().eq(
											index).show();

								});

						$(".subject").click(
								function() {
									var index = $(".subject").index(this);

									$(this).siblings(".noticeContent")
											.eq(index).toggle();
								});

						// servlet에서 type 값 가져와서 요청한 페이지 나타나게 
						$(".notice").eq(0).click();
					});
</script>


<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div>
		<div class=notice_wrap style="width: 1000px; margin: 0 auto; margin-top: 10px;">
			<div class="noitce_header"
				style="width: 100%; text-align: center; height: 44px;">
				<div class="notice">공지사항</div>
				<div class="notice">운영정책</div>
				<div class="notice">자주묻는 질문</div>
			</div>
			<div class="notice_content">
				<!-- 공지사항  -->
				<div class="noticeContent1" id="content1"
					style="width: 100%; margin: 0 auto; margin-top: 10px; height: 47px;">
					<%
						for (Notice n : list) {
					%>
					<div class="subject"
						style="padding: 18px 62px 18px 16px; background-color: white;">
						<p><%=n.getNoticeTitle()%></p>
						<span style="font-family: inherit; line-height: inherit;"><%=n.getNoticeDate()%></span>


					</div>

					<div class="noticeContent"
						style="border-top: 1px solid #ededed; border-bottom: 1px solid #ededed; background-color: #fafafa;">
						<br>
						<pre style="margin: 0; padding-left: 10px;"><%=n.getNoticeContent()%></pre>
						<br>
					</div>

					<%
						}
					%>
				</div>
				<!-- 운영정책  -->
				<div class="noticeContent1">

					<style>
.header {
	background: #ffffff;
	width: 100%;
	padding: 36px 0px 30px;
}

.titleImg img {
	width: 230px;
	display: block;
	margin: auto;
	margin-bottom: 20px;
}

.titleContent {
	display: block;
	font-size: 14px;
	color: #757575;
	text-align: center;
	line-height: 18px;
}

.content1 {
	border-top: 1px solid #f5f5f5;
	padding: 30px 0px;
}

.articleImg img {
	width: 73px;
	float: left;
	clear: both;
}

.articleContent .ac1 {
	font-size: 15px;
	font-weight: bold;
	color: #212121;
}

.articleContent .ac2 {
	font-size: 13px;
	color: #808080;
	margin-top: 12px;
}

.footerImg img {
	display: block;
	margin: auto;
	width: 250px;
	margin: 20px auto;
}

.footerImg .step {
	background: #fcfcfc;
	border-top: 1px solid #ebebeb;
	border-bottom: 1px solid #ebebeb;
}
</style>

					<div class="total">

						<header>
							<div class="titleImg" style="margin-top: 20px;">
								<img src="/img/icon/img_manage_top.png">
							</div>
							<div class="titleContent">
								<p>공정한 거래 문화를 위해 토마토마켓은 다음과 같은 약속들을 준수합니다.</p>
							</div>
						</header>

						<article>
							<div class="content1">
								<div class="articleImg">
									<img src="/img/icon/img_manage_attention1.png">
								</div>
								<div class="articleContent">
									<p class="ac1">거래 금지 품목 거래시 제재 받을 수 있습니다.</p>
									<p class="ac2">전자 통신판매법 등에 의해 저촉되어 인터넷 거래기준에 적용되는 상품으로 1회
										적발시 즉시 이용제한이 될 수 있습니다.</p>
								</div>
							</div>

							<div class="content1">
								<div class="articleImg">
									<img src="/img/icon/img_manage_attention2.png">
								</div>
								<div class="articleContent">
									<p class="ac1">랜덤박스(비공개/반공개)는 분쟁의 원인이 되고 있습니다.</p>
									<p class="ac2">랜덤박스는 상품의 상태 및 내용물을 확인할 수 없거나 모호하여 분쟁과 신고
										접속의 원인이 되고 있어 운영자에 의해 제재 받을 수 있습니다.</p>
								</div>
							</div>
							<div class="content1">
								<div class="articleImg">
									<img src="/img/icon/img_manage_attention3.png">
								</div>
								<div class="articleContent">
									<p class="ac1">상품, 댓글의 10회 이상 도배, 등록을 피해주세요.</p>
								</div>
							</div>
							<div class="content1">
								<div class="articleImg">
									<img src="/img/icon/img_manage_attention4.png">
								</div>
								<div class="articleContent">
									<p class="ac1">욕설, 성희롱 등 비매너 행위는 타인을 불쾌하게 합니다.</p>
									<p class="ac2">비매너 행위에 관한 게시물과 댓글은 운영진에 의해 제재 받을 수 있습니다.</p>
								</div>
							</div>
							<div class="content1">
								<div class="articleImg">
									<img src="/img/icon/img_manage_attention5.png">
								</div>
								<div class="articleContent">
									<p class="ac1">선정적이거나 판매 상품에 적절치 않은 이미지는 사용자 혼란을 일으킵니다.</p>
									<p class="ac2">판매하려는 상품을 명확히 표현하는 사진을 사용해주세요.</p>
								</div>
							</div>
							<div class="content1">
								<div class="articleImg">
									<img src="/img/icon/img_manage_attention6.png">
								</div>
								<div class="articleContent">
									<p class="ac1">상품명, 키워드에 판매 상품과 관계없는 단어 삽입은 제재 받을 수 있습니다.</p>
									<p class="ac2">상품 노출을 높여보고자 인기 검색어를 마구 집어 넣는 행위는 여러 유저들에게
										불편을 일으키는 원인이 됩니다.</p>
								</div>
							</div>
							<div class="content1"
								style="border-bottom: 1px solid #f5f5f5; margin-bottom: 10px;">

								<div class="articleImg">
									<img src="/img/icon/img_manage_attention7.png">
								</div>
								<div class="articleContent">
									<p class="ac1">정확한 상품 가격 정보를 입력해 주세요.</p>
									<p class="ac2">실제 판매하려는 가격과 다른 상품 가격정보를 써 놓아 구매자에게 혼돈을 주지
										마세요.</p>
								</div>
							</div>
						</article>

						<footer>
							<div class="footerImg">
								<img src="/img/icon/img_manage_4out.png">
								<div class="step">
									<img src="/img/icon/img_manage_4out_step.png">

								</div>

							</div>

						</footer>
					</div>

				</div>
				<!-- 자주묻는 질문  -->
				<div class="noticeContent1">자주묻는 질문 ???????</div>

			</div>
		</div>
	</div>



</body>
</html>