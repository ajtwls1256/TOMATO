
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/chat/css/custom.css"/>  
	<link rel ="stylesheet" href="/chat/css/bootstrap.css">
	<title>토마톡</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="/chat/js/bootstrap.js"></script>
	
	
	<style>
		.row:hover{
			background : lightgray;
		}
	</style>
	
<title>Insert title here</title>
</head>
<body class="d-chat">
	<div class="container" style="padding:0px">
		<div class="container bootstrap snippet" style="padding:0px">
			<div class="col-xs-12"  style="padding:0px">
				<div class="portlet portlet-default">
					<div class="portlet-heading" style="background : #c42026">
						<div class="portlet-title">
							<h4>
								<i class="fa fa-circle text-green"></i>토마톡
							</h4>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="chat" class="panel-collapse collapse in">
						<div class="portlet-body chat-widget chat-body"	style="overflow-y: auto; width: auto; height: 560px;">


							<!-- 채팅 작성 부분 -->
							
							<c:if test="${not empty chatList}">
							<c:forEach items="${chatList }" var="chat" varStatus="i">
							
							<div class="row" ondblclick="divdblClick(${chat.senderNo})">
								<div class="col-lg-12">
									<div class="media">
										<a class="pull-left" href="#"> 
											<img style="width:30px; height:30px;" class="media-object img-circle" src='/upload/member/${chat.senderFilePath}'>
										</a>

										<div class="media-body">
											<h4 class="media-heading" style="color:#009300">
												${chat.senderShopName } <span class="small pull-right">${chat.chatTime }</span>
											</h4>
										</div>
										<p>${chat.chatContent }</p>
									</div>
								</div>
							</div>
							

							<hr>
							</c:forEach>
							</c:if>

							
							
							
						</div>
						
					
					</div>
				</div>
			</div>
		</div>
	</div>


	<script>

		function divdblClick(senderNo){
			console.log(senderNo);
			location.href="/chatting?senderNo="+senderNo+"&receiverNo="+"${chatList[0].receiverNo}";
		};
		
	</script>





</body>
</html>