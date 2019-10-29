<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%! 
	// 이메일 인증번호 난수 생성
	public int getRandom(){
	int random = 0;
	random = (int)Math.floor((Math.random()*(99999-10000+1)))+10000;
	return random;
} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>토마토마켓</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
body {
	background-color: #f9f9f9;
}

.container {
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.searchPW-box {
	border: 1px solid white;
	width: 500px;
	height: 100%;
	background-color: white;
	border-radius: 4px;
	padding: 30px;
	margin: auto 0;
	box-shadow: rgba(0, 0, 0, 0.1) 0px 3px 6px 0px;
	
}
.btn1{
	border-radius: 4px;
	background-color: #878787;
	font-size: 13px;
	color: #fff;
	border: 0;
	height: 30px;
}
.btn2{
	border-radius: 4px;
	width:100%;
	background-color: #c42026;
	font-size: 13px;
	color: #fff;
	height: 30px;
	font-size: 13px;
	text-align: center;
	border: 0;
}
td{
}
input {
	border: 0;
	width: 260px;
	height: 30px;
	padding-left: 5px;
}
#complete {
	width: 100%;
	background: #C42026;
	color: white;
	border-radius: 4px;
	border: 0;
	height: 30px;
}

</style>
</head>
<body>

	<div class="container">
		<div class="searchPW-box">

			<header
				style="margin: 40px 0 40px 0; text-align: center; font-size: 30px;">비밀번호
				찾기</header>

				<div style="width: 80%; margin: 0 auto;">
					<form>
						<table class="tbl" style="width: 100%;">
							<tr>
								<td style="height: 70px;"><img src="/img/email2.png"
									style="width: 25px; height: 25px;"></td>
								<td><input class="input-info" type="text" id="email"
								placeholder="이메일(비밀번호 분실시 사용)">
								<input type="hidden" readonly="readonly" name="code_check"
					id="code_check" value="<%=getRandom()%>" /></td>
								<td><button type="button" class="btn1" id="checkCodeBtn">인증번호</button></td>
							</tr>
							<tr id="msg-tr1">
							<td style="border:0; height:25px; "></td>
							<td colspan="2" style="border:0; padding-top:4px;"><span id="chkMsg1"></span></td>
							</tr>
							<tr>
								<td style="height: 70px;"><img src="/img/shield.png"
									style="width: 25px; height: 25px;"></td>
								<td colspan="2"><input class="input-info" type="text" id="codeCheck"
								placeholder="인증번호 입력"></td>
							</tr>
								<tr id="msg-tr2">
							<td style="border:0; height:25px; "></td>
							<td colspan="2" style="border:0; padding-top:4px;"><span id="chkMsg2"></span></td>
							</tr>
							<tr>
								<td colspan="3"><button type="button" class="btn2" style="margin:20px 0 20px 0 ">확인</button>
								<input type="hidden" readonly="readonly" id="pw" />
								</td>
							</tr>
						</table>
					</form>
				</div>

	<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog" >
			<div class="modal-dialog modal-div">
			<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header"
						style="padding: 50px 50px; text-align: center; border: 0px; padding-bottom: 0px">
						<img src="/img/tomatoMarketLogo.png" width="30" height="34">
						<p style="font-size: 1.5em; margin-top: 15px;">토마토마켓을 이용해주셔서 감사합니다.</p>
						<p>즐거운 쇼핑하세요 :)</p>
					</div>
					<div class="modal-body" style="padding: 40px 168px; position: relative;">
					회원님의 비밀번호 : <input type="text" id="searchPW" readOnly style="width:100; position: absolute; top:33px;">
					<button class="addressAdd-btn" id="complete" type="button"
								style="margin-top: 20px;" onclick="login()">로그인하러가기</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal end -->

		</div>
	</div>
	
	<script>
	
	$(document).ready(function(){
		
		//이메일 인증번호 전송
		$("#checkCodeBtn").click(function(){
			var receiver = $("#email").val();
			var code_check = $("#code_check").val();
			$.ajax({
				url:"/send",
				type:"get",
				data:{receiver:receiver,code_check:code_check},
				success:function(data){
					if(data=='1'){
						console.log("전송성공");
					}else{
						console.log("전송실패");
					}
				},error:function(){
					console.log("망해따..");
				}		
				})	
		})
		
		
		$("#msg-tr1").hide();
		$("#msg-tr2").hide();
		$("#email").change(function() {
								var email = $("#email").val();
								var msg = $("#chkMsg1");
								$.ajax({
									url : "/ajaxCheckEmail",
									type : "get",
									data : {
										email : email
									},
									success : function(data) {
										if (data == '0') {
											msg.html('인증번호를 입력해주세요');
											msg.css('color', 'blue');
											$("#msg-tr1").show();
											$("#checkCodeBtn").css("cursor","pointer");
										} else {
											msg.html('없는 아이디입니다.');
											msg.css('color', 'red');
											$("#checkCodeBtn").css("cursor","no-drop");
											$("#msg-tr1").show();
										}
									},
									error : function() {
										console.log("아이디 확인 실패");
									}
								})
		})
		$(".btn2").click(function(){
								var msg = $("#chkMsg2");
								var email = $("#email").val();
								
								var codeCheck = $("#codeCheck").val();
								if(codeCheck==$('#code_check').val()){
									$.ajax({
										url:"/ajaxSearchPW",
										type:"get",
										data:{email:email},
										success:function(data){
											if(data!=0){	//비번 찾기 성공
												$("#searchPW").val(data);
												$("#myModal").modal('show');
											}else{// 실패
												alert("비밀번호찾기 실패");
											}
										}, error:function(){
											console.log("비밀번호 확인 실패");
										}
										
										
									})			
									
								}else if(codeCheck==""){
									msg.html('인증코드를 입력해주세요');
									msg.css('color', 'red');
									$("#msg-tr2").show();
								}
								else{
									msg.html('인증코드를 잘못 입력하셨습니다.');
									msg.css('color', 'red');
									$("#msg-tr2").show();
								}
		})
		
		
			
	})
	
	function login(){
		location.href="/";
	}
	
	
	</script>


</body>
</html>