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
.notice{
	width: 33.3%; float: left; height: 44px; line-height: 44px; background: white;
}
.noticeContent{
display: none; background: white;
}


</style>

<script>
$(document).ready(function(){
	
	$(".noticeContent1").hide();
	$(".notice").css("border-bottom","none").css("color","black");
	
	$(".notice").click(function(){
		
		$(".notice").css("border-bottom","none").css("color","black");
		$(this).css("border-bottom","2px solid #C42026").css("color","#C42026");
		
		$(".noticeContent1").hide();
		var index = $(".notice").index(this);
		$(this).parent().siblings().children().eq(index).show();
		
	});
	
	$(".subject").click(function () {
		var index = $(".subject").index(this);
		
		$(this).siblings(".noticeContent").eq(index).toggle();
	});
	
	// servlet에서 type 값 가져와서 요청한 페이지 나타나게 
	$(".notice").eq(0).click();
});

</script>


<body>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div>
		<div class=notice_wrap" style="width: 1000px; margin: 0 auto; margin-top: 10px;" >
			<div class="noitce_header" style="width: 100%; text-align: center; height: 44px;">
				<div class="notice">
				공지사항
				</div>
				<div class="notice" >
				운영정책  
				</div>
				<div class="notice">
				자주묻는 질문  
				</div>
			</div>
			<div class="notice_content">
				<!-- 공지사항  -->
				<div class="noticeContent1" id="content1" style="width: 100%; margin: 0 auto; margin-top: 10px; height: 47px;">
						<%
							for (Notice n : list) {
						%>
						<div class="subject" style="padding: 18px 62px 18px 16px; background-color: white;">
							<p><%=n.getNoticeTitle() %></p>
							<span style="font-family: inherit; line-height: inherit;"><%=n.getNoticeDate() %></span>
							
							
						</div>
						
						<div class="noticeContent" style="border-top: 1px solid #ededed; border-bottom:1px solid #ededed; background-color: #fafafa; ">
							<br>
								<pre style="margin: 0; padding-left: 10px;"><%=n.getNoticeContent() %></pre>
								<br>
						</div>
						
					<%
					}
					%>
				</div>
				<!-- 운영정책  -->
				<div class="noticeContent1" id="content2">
					
				</div>
				<!-- 자주묻는 질문  -->
				<div class="noticeContent1" id="content3">
				자주묻는 질문  ???????
				</div>
				
				</div>
			</div>
		</div>
	
	
	
</body>
</html>