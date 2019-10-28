
<%@page import="kr.co.tomato.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.tomato.vo.Chat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    	// 그 회원과의 이전 대화내용들
		ArrayList<Chat> cList = (ArrayList<Chat>)request.getAttribute("chattingList");	



		//채팅 보낼 상대방의 No를 저장
		int memberNo = cList.get(0).getSenderNo();
		System.out.println(memberNo);
		
		
		HttpSession sessions = request.getSession();
		Member m = (Member)sessions.getAttribute("member");
		
		if(cList.get(0).getSenderNo() == m.getMemberNo()){
			memberNo = cList.get(0).getReceiverNo();
		}
		
		System.out.println(memberNo);
%>




<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel ="stylesheet" href="/chat/css/bootstrap.css">
	<link rel ="stylesheet" href="/chat/css/custom.css">
	<title>토마톡</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="/chat/js/bootstrap.js"></script>
	
	
	<style>
		.receiveMsg:hover{
			background : lightgray;
		}
		
		.myMsg:hover{
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
					<div class="portlet-heading" style="background : #285226">
						<div class="portlet-title">
							<h4>
								<i class="fa fa-circle text-green"></i>토마톡
							</h4>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="chat" class="panel-collapse collapse in">
						<div class="portlet-body chat-widget chat-body" style="overflow-y: auto; width: auto; height: 450px;">


							<c:forEach items="${chattingList }" var="chat" varStatus="i">
							
							
							<!-- 상대방이 나한테 보낸거 -->
							<c:if test="${chat.senderNo!=sessionScope.member.memberNo}">
							

							<!-- 상대방이 나한테보낸 채팅메세지 div -->
							<div class="receiveMsg">
								<div class="col-lg-12" style="padding:0px">
									<div class="media">
										<a class="pull-left" href="#"> 
											<img style="width:30px;" class="media-object img-circle" src="/upload/member/${chat.senderFilePath}">
										</a>
							
										<div class="media-body">
											<h4 class="media-heading">
												${chat.senderShopName } <span class="small pull-right">${chat.chatTime }</span>
											</h4>
										</div>
										<p>${chat.chatContent }</p>
									</div>
								</div>
							</div>
							

							<hr>
							
							</c:if>
							
							<!-- 내가 상대방한테 보낸거 -->
							<c:if test="${chat.senderNo==sessionScope.member.memberNo}">
							
							
							<!-- 내 채팅메세지 div -->
							<div class="myMsg">
								<div class="col-lg-12" style="padding:0px">
									<div class="media">
										<a class="pull-left" href="#"> 
											<img style="width:30px;" class="media-object img-circle" src='/upload/member/${sessionScope.member.filePath}'>
										</a>
						
										<div class="media-body">
											<h4 class="media-heading">
												${sessionScope.member.shopName} <span class="small pull-right">${chat.chatTime }</</span>
											</h4>
										</div>
										<p>${chat.chatContent }</p>
									</div>
								</div>
							</div>
							
							<hr>
							
							
							</c:if>
							
							</c:forEach>
							
							
						</div>
						
						

						<div class="portlet-footer" style="background : #c42026">
						

							<!-- 메시지 입력 -->
							<div class="row" style="height: 90px">
								<div class="form-group col-xs-10">
									<textarea style="height: 80px" id="chatContent"
										class="form-control" placeholder="메시지를 입력하세요." maxlength="100"></textarea>
								</div>
								<div class="form-group col-xs-2">
									<button type="button" class="btn btn-default pull-right"
										onclick="submitFunction();" style="background : #c42026; color: white">전송</button>
									<div class="clearfix"></div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- 내 채팅메세지 div -->
	<div class="myMessage" style="display:none">
		<div class="col-lg-12">
			<div class="media">
				<a class="pull-left" href="#"> 
					<img style="width:30px;" class="media-object img-circle" src='/upload/member/${sessionScope.member.filePath}'>
				</a>

				<div class="media-body">
					<h4 class="media-heading">
						${sessionScope.member.shopName} <span class="small pull-right">보낸시간</span>
					</h4>
				</div>
				<p>내가보낸메시지</p>
			</div>
		</div>
	</div>
	

	
	
	
	<!-- 상대방 채팅메세지 div -->
	<div class="reciveMessage" style="display:none">
		<div class="col-lg-12">
			<div class="media">
				<a class="pull-left" href="#"> 
					<img style="width:30px;" class="media-object img-circle" src="/chat/img/icon.png">
				</a>
	
				<div class="media-body">
					<h4 class="media-heading">
						보낸사람상점명 <span class="small pull-right">보낸시간</span>
					</h4>
				</div>
				<p>내가받는메시지</p>
			</div>
		</div>
	</div>




	<script>
	
	
		$(function(){
			// 스크롤바 내리기
			$('.chat-body').scrollTop($('.chat-body')[0].scrollHeight);
		});
	
		// 웹소켓 생성 후 각 이벤트 정의
		//var webSocket = new WebSocket('ws://192.168.40.12/server');
		// 노트북 ip로 잠시 변경
		var webSocket = new WebSocket('ws://192.168.0.25/server');
		
		
		// 채팅내용 추가용
		var chatBody = $(".chat-body");
		
		
		webSocket.onopen = function(event) {
			onOpen(event);
		};

		webSocket.onerror = function(event) {
			onError(event);
		};

		webSocket.onmessage = function(event) {
			onMessage(event);
		};

		function onOpen(event) {
			//textarea.value += "연결 성공\n";
			
		}

		function onError(event) {
			alert("에러발생 = " + event.data);
		}

		// 메시지 입력받을때
		function onMessage(event) {
			
			// 입력받은 메시지를 보낸사람상점명,상점사진,메시지로분리
			var receiveMsg = event.data+"";
		    var inputMsg = receiveMsg.split("#!@");
		     
		    var senderShopName = inputMsg[0];
		    var senderFilePath = inputMsg[1];
		    var sendMsg = inputMsg[2];
		    var sendTime = inputMsg[3];
			
			
			/* 입력받은 채팅의 html 추가 */
			// 만들어놓은 내채팅입력형태를 복사
 			var chatRow = $(".reciveMessage").clone();
			// 같은 클래스명이면 위의 코드에서 계속 받아와서 중첩되기때문에 클래스명 변경
			chatRow.attr("class", "receiveMsg");
			// inline-block를 해야 아래 붙이는 <hr>이 잘먹음.. 이유는몰라..
			chatRow.css("display","inline-block");
			// padding이 이상하게 적용되서 밀리는데 이를 위해 변경..
			chatRow.children().first().css("padding","0px");
			
			
			
			// 사진 변경
			chatRow.find("img").attr("src","/upload/member/"+senderFilePath);
			

			
			// 보낸사람 상점명 과 시간
			chatRow.find("h4").html(senderShopName + "<span class='small pull-right'>"+ sendTime + "</span>");
			

			
			// 입력받은 값으로 채팅내용html 변경
			chatRow.find("p").html(sendMsg+"");
			
			
			
			// 채팅 마지막부분에 입력내용 추가
			chatBody.append(chatRow);
			chatBody.append($("<hr>").clone());

			
			// 스크롤바 내리기
			$('.chat-body').scrollTop($('.chat-body')[0].scrollHeight);
		}
	
		

		
		function submitFunction() {

			
			/* 내가 입력한 채팅의 html 추가 */
			// 만들어놓은 내채팅입력형태를 복사
 			var chatRow = $(".myMessage").clone();
			// 같은 클래스명이면 위의 코드에서 계속 받아와서 중첩되기때문에 클래스명 변경
			chatRow.attr("class", "myMsg");
			// inline-block를 해야 아래 붙이는 <hr>이 잘먹음.. 이유는몰라..
			chatRow.css("display","inline-block");
			// padding이 이상하게 적용되서 밀리는데 이를 위해 변경..
			chatRow.children().first().css("padding","0px");
			
			
			// 현재시간으로 시간표시 html 변경
			var d = new Date();
		
			var year = d.getFullYear();
			var month = d.getMonth()+1;
			var day = d.getDate();
			var hours = d.getHours();
			var minutes = d.getMinutes()+"";
			
			var ampm = "오전";
			if (hours >= 12) {
				ampm = "오후";
				if (hours >= 13) {
					hours = hours - 12;
				}
			}
			// 04분 09분 이렇게 표시하기위함
			if(minutes.length < 2){
				minutes = "0"+minutes;
			}
			var chatTime = year + "-" + month + "-" + day + " " +ampm + " " + hours + ":" + minutes;
			
			chatRow.find("span").html(chatTime);
			
			
			
			
			
			// 입력받은 값으로 채팅내용html 변경
			var chatContent = $("#chatContent").val();
			// >, <, & 와 띄워쓰기, 엔터가 적용되도록 변경
			
			chatContent = replaceAll(chatContent, " ", "&nbsp;");
			chatContent = replaceAll(chatContent, "<", "&lt;");
			chatContent = replaceAll(chatContent, ">", "&gt;");
			// 요거 p태그 줄바꿈해도 들여쓰기간격맞출라고 공백추가
			chatContent = replaceAll(chatContent, "\n", "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			
			
			chatRow.find("p").html(chatContent);
			
			
			
			// 채팅 마지막부분에 입력내용 추가
			chatBody.append(chatRow);
			chatBody.append($("<hr>").clone());
			
			
			

			// 상대방회원No#!@내상점명#!@내사진파일경로#!@전송할메세지 로 전송해 server에서 누구한테 전송하는건지 알수있게
			webSocket.send(<%=memberNo%> + "#!@" + '${sessionScope.member.shopName}' + "#!@" + '${sessionScope.member.filePath}' + "#!@" + chatContent + "#!@" + chatTime);

			
			// 채팅입력창 초기화
			$("#chatContent").val('');
			
			// 스크롤바 내리기
			$('.chat-body').scrollTop($('.chat-body')[0].scrollHeight);
		}
		
		
		// replaceAll이 없어서 replace를 이용해 만듬
		function replaceAll(str, searchStr, replaceStr) {
			  return str.split(searchStr).join(replaceStr);
		}
	</script>



</body>
</html>