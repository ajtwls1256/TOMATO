<%@page import="kr.co.tomato.member.model.vo.Member"%>
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
<style>
.singUp_area {
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.sinUp_box {
	width: 500px;
	height: 100%;
	background-color: white;
	margin: auto 0;
	padding: 30px;
	height: 100%;
	border-radius: 4px;
	height: 100%;
	box-shadow: rgba(0, 0, 0, 0.1) 0px 3px 6px 0px;
}

.header {
	margin: 40px 0 40px 0px;
	text-align: center;
	font-size: 30px;
}

.table-wrapper {
	width: 80%;
	margin: 0 auto;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 0;
	padding: 0;
}

td {
	border-bottom: 1px solid #878787;
}

body {
	background-color: #f9f9f9;
}

.input-info {
	border: 0;
	width: 250px;
	height: 30px;
	padding-left: 5px;
}

.certification, #addrSearchBtn {
	border-radius: 4px;
	background-color: #878787;
	font-size: 13px;
	color: #fff;
	border: 0;
	height: 30px;
}

.icon-img {
	width: 25px;
	height: 25px;
}

.agree-td {
	border-bottom: 0;
	padding-left: 10px;
	height:40px;
}

.agree-content {
	margin-top: 5px;
	line-height: 1.4;
	max-height: 150px;
	overflow: hidden auto;
	border: 1px solid #eeeeee;
	color: #cccccc;
	font-size: 13px;
	white-space: pre-wrap;
	padding: 10px;
	background: #f9f9f9;
}

.sub-button, #complete {
	width: 100%;
	background: #C42026;
	color: white;
	border-radius: 4px;
	border: 0;
	height: 30px;
}

.ion-td {
	padding: 5px 5px 0 0;
	height: 50px;
}

.info-td {
	width: 250px;
}

#form2 {
	margin-bottom: 30px;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>

	<div class="singUp_area">
		<div class="sinUp_box">

			<div class="header">회원가입</div>

			<div class="table-wrapper">

				<form name="checkEmailFrm">
					<!-- 이메일 중복 체크 -->
					<input type="hidden" name="checkEamil">
				</form>

				<form action="#" method="post">
					<!-- 이메일 인증번호 확인 form -->
					<table>
						<tr>
							<td class="ion-td"><img class="icon-img"
								src="/img/email2.png"></td>
							<td class="info-td"><input class="input-info" type="text"
								placeholder="google이메일 입력" name="email" id="email">
								<input type="hidden" readonly="readonly" name="code_check"
					id="code_check" value="<%=getRandom()%>" />
								</td>
							<td><button class="certification" type="button" id="checkCodeBtn">인증번호</button></td>
						</tr>
						<tr id="msg-tr1">
							<td style="border:0; height:25px; "></td>
							<td colspan="2" style="border:0; padding-top:4px;"><span id="chkMsg1"></span></td>
						</tr>
						<tr>
							<td class="ion-td"><img class="icon-img"
								src="/img/shield.png"></td>
							<td colspan="2"><input class="input-info" type="text"
								placeholder="인증번호 입력" name="codeCheck" id="codeCheck"></td>
						</tr>
						<tr id="msg-tr2">
							<td style="border:0; height:25px; "></td>
							<td colspan="2" style="border:0; padding-top:4px;"><span id="chkMsg2"></span></td>
						</tr>
					</table>
				</form>

				<form action="/signUp" method="post">
					<!-- 회원가입 form -->
					<input class="input-info" type="hidden" name="email">
					<table>
						<tr>
							<td class="ion-td"><img class="icon-img"
								src="/img/padlock.png"></td>
							<td colspan="2"><input class="input-info" type="password"
								placeholder="비밀번호            * 6자 이상의 영문, 숫자 사용  " name="pw" id="pw"></td>
						</tr>
						<tr id="msg-tr3">
							<td style="border:0; height:25px; "></td>
							<td colspan="2" style="border:0; padding-top:4px;"><span id="chkMsg3"></span></td>
						</tr>
						<tr>
							<td class="ion-td"><img class="icon-img"
								src="/img/padlock.png"></td>
							<td colspan="2"><input class="input-info" type="password"
								placeholder="비밀번호 확인" id="rePw"></td>
						</tr>
						<tr id="msg-tr4">
							<td style="border:0; height:25px; "></td>
							<td colspan="2" style="border:0; padding-top:4px;"><span id="chkMsg4"></span></td>
						</tr>
						<tr></tr>
						<tr>
							<td class="ion-td"><img class="icon-img"
								src="/img/phone-call.png"></td>
							<td colspan="2"><input class="input-info" type="text"
								placeholder="(선택) 핸드폰 번호 " name="phone" id="phone"></td>
						</tr>
						<tr id="msg-tr5">
							<td style="border:0; height:25px; "></td>
							<td colspan="2" style="border:0; padding-top:4px;"><span id="chkMsg5"></span></td>
						</tr>
						<tr></tr>
						<tr>
							<td class="ion-td"><img class="icon-img"
								src="/img/envelope.png"></td>
							<td><input class="input-info" id="zipCode"
								placeholder="(선택) 우편번호" name="zipCode" readOnly></td>
							<td><button type="button" id="addrSearchBtn"
									onclick="addrSearch();">주소 검색</button></td>
						</tr>
						<tr></tr>
						<tr style="width: 500px;">
							<td class="ion-td"><img class="icon-img"
								src="/img/house.png"></td>
							<td colspan="2"><input class="input-info" id="addr"
								placeholder="(선택) 주소"></td>
						</tr>

						<tr style="width: 500px;">
							<td class="ion-td"><img class="icon-img" src="/img/add.png"></td>
							<td colspan="2"><input class="input-info" placeholder="(선택) 상세주소" id="detailAddr"></td>
						</tr>
						<tr>
							<td style="height: 20px; border: 0;"></td>
						</tr>
						<tr></tr>
						<tr>
							<td style="border: 0; height:40px;"><input type="checkbox" id="checkall"></td>
							<td style="font-size: 1em; border: 0;">전체 동의하기</td>
						</tr>
						<tr>
							<td class="agree-td "><input type="checkbox" class="chk" id="chk1"></td>
							<td class="agree-td " style="font-size: 0.9em;"><span
								style="color: red">(필수)</span><span> 토마토마켓 이용약관 동의</span></td>
							<td class="agree-td" style="padding-left: 50px"><img
								src="/img/icon-signup-dropdown.png" id="agree-content-img"></td>
						</tr>
						<tr>
							<td colspan="3" class="agree-td" id="content"><div
									class="agree-content">제 1 장 총칙 제 1 조 (목적) 본 약관은 서비스 이용자가
									번개장터 주식회사 (이하 “회사”라 합니다)이 제공하는 온라인상의 인터넷 서비스(이하 “서비스”라고 하며, 접속
									가능한 유•무선 단말기의 종류와는 상관없이 이용 가능한 “회사”가 제공하는 모든 “서비스”를 의미합니다. 이하
									같습니다)에 회원으로 가입하고 이를 이용함에 있어 회사와 회원(본 약관에 동의하고 회원등록을 완료한 서비스
									이용자를 말합니다. 이하 “회원”이라고 합니다)의 권리•의무 및 책임사항을 ㄴ규정함을 목적으로 합니다. 제 2 조
									(약관의 명시, 효력 및 개정).....</div></td>
						</tr>
						<tr>
							<td class="agree-td"><input type="checkbox" class="chk" id="chk2"></td>
							<td class="agree-td " style="font-size: 0.9em;"><span
								style="color: red">(필수)</span><span> 개인정보 처리 방침 동의</span></td>
						</tr>
						<tr>
							<td class="agree-td"><input type="checkbox" class="chk"></td>
							<td class="agree-td " style="font-size: 0.9em;"><span
								style="color: #878787">(선택)</span><span> 위치기반서비스 동의</span></td>
						</tr>
						<tr>
							<td class="agree-td"><input type="checkbox" class="chk"></td>
							<td class="agree-td " style="font-size: 0.9em;"><span
								style="color: #878787">(선택)</span><span> 이메일,SMS 광고 수신 동의</span></td>
						</tr>
						<tr>
							<td colspan="3" style="border: 0px; padding-top:15px;"><button
									class="sub-button" type="button" id="join-button">제출하기</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog" >
			<div class="modal-dialog modal-div">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header"
						style="padding: 50px 50px; text-align: center; border: 0px; padding-bottom: 0px">
						<img src="/img/tomatoMarketLogo.png" width="30" height="34">
						<p style="font-size: 1.5em; margin-top: 15px;">토마토마켓에 가입해주셔서
							감사합니다.</p>
						<p>회원님의 관심지역을 선택해주세요!</p>
					</div>
					<div class="modal-body" style="padding: 40px 168px;">

							<div id="div-choiceAddr">
								
								<select id="area1-1" name="h_area1-1" style="width: 90px">
									<option value='서울'>서울</option>
								</select> 
								
								<select id="area2-1" name="h_area2-1" style="width: 120px">
									<option selected disabled hidden>-선택-</option>
									<option>강남구</option>
									<option>강동구</option>
									<option>강북구</option>
									<option>강서구</option>
									<option>관악구</option>
									<option>광진구</option>
									<option>구로구</option>
									<option>금천구</option>
									<option>노원구</option>
									<option>도봉구</option>
									<option>동대문구</option>
									<option>동작구</option>
									<option>마포구</option>
									<option>서대문구</option>
									<option>서초구</option>
									<option>성동구</option>
									<option>성북구</option>
									<option>송파구</option>
									<option>양청구</option>
									<option>영등포구</option>
									<option>용산구</option>
									<option>은평구</option>
									<option>종로구</option>
									<option>중구</option>
									<option>중랑구</option>
								</select>
								
								<button class="addressAdd-btn btn11" id="btn1" type="button" onclick="copy(this);">추가</button>
							
							</div>
							
					</div>
					<div class="modal-footer">
					<button class="addressAdd-btn" id="complete" type="button"style="margin-top: 20px;">완료</button>
					
					</div>
				</div>
			</div>
		</div>
		<!-- Modal end -->
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
	})

		// daum api 이용하여 주소값 설정
		function addrSearch() {
			new daum.Postcode({
				oncomplete : function(data) {
					$("#zipCode").val(data.zonecode);
					$("#addr").val(data.roadAddress);
					$("#addr").val(data.jibunAddress);
				}
			}).open();
		}
	
	
		// 테크박스 전체 선택
		$(document).ready(function() {

			$("#content").hide();
			$("#checkall").click(function() {
				if ($("#checkall").prop("checked")) {
					$(".chk").prop("checked", true);
				} else {
					$(".chk").prop("checked", false);
				}
			})

			$("#agree-content-img").click(function() {
				$("#content").toggle();
				$("#agree-content-img").show();
			})

		});

		/*********************************Modal***********************************/
		i=0;
		function copy(addrBtn){
			var email = $("#email").val();
			var city = $(addrBtn).prev().prev().val();
			var gungu = $(addrBtn).prev().val();
			console.log(city);
			$.ajax({
				url:"/ajaxAddAddrChoice",
				type:"get",
				data:{email:email, city:city, gungu:gungu},
				success :function(data){
					if(data!=0){
						alert("괸심지역 추가 성공");
					}else{
						alert("괸심지역 추가 실패!");												
					}
				}, error:function(){
					alert("괸심지역 추가 error");
				}
			});
			i++;
			if(i==3){
				alert("관심 지역은 최대 3개까지 추가 가능합니다.");
				$(addrBtn).hide();
				return;
			}
			$(addrBtn).parent().clone().appendTo(".modal-body");
			$(addrBtn).hide();
			
			}
		
		$(document).ready(function() {
				$("#complete").click(function() {
				alert("관심지역이 추가되었습니다. 회원가입을 축하드립니다.");
				location.href = "/";
		})
							
							
		////////////////////////회원가입 유효성 검사////////////////////////
							// email, password, phone 정규표현식
							var regExpEmail = /^[a-zA-Z0-9]([-_.]?[0-9a-zA-Z])*@gmail.com$/;
							var regExpPassword = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{6,}$/;
							var regExpPhone = /^01(?:0|1|[6-9])-(?:[0-9]{3}|[0-9]{4})-[0-9]{4}$/;
							
							// 처음 load시, msg의 모든 tr태그 숨김 & email인증 버튼 비활성화
							for(var i=1;i<6;i++){
							$("#msg-tr"+i+"").hide();
							}
							$(".certification").css("cursor","no-drop");
							
							// email 중복 체크 및 정규표현식 확인
							$("#email").change(function() {
								var email = $("#email").val();
								var msg = $("#chkMsg1");
								if(!regExpEmail.test(email)){
									msg.html('형식에 맞춰 작성해주세요 ( ○○○@gmail.com )');
									msg.css('color', 'red');
									msg.attr('status','0');
									$(".certification").css("cursor","no-drop");
									$("#msg-tr1").show();
									return;
								}
								$.ajax({
									url : "/ajaxCheckEmail",
									type : "get",
									data : {
										email : email
									},
									success : function(data) {
										if (data == '1') {
											msg.html('사용가능한 이메일입니다.인증번호를 입력하세요.');
											msg.css('color', 'blue');
											msg.attr('status','1');
											$("#msg-tr1").show();
											$(".certification").css("cursor","pointer");
										} else {
											msg.html('이미 사용중인 이메일입니다.');
											msg.css('color', 'red');
											msg.attr('status','0');
											$(".certification").css("cursor","no-drop");
											$("#msg-tr1").show();
										}
									},
									error : function() {
										console.log("아이디 중복 체크 error");
									}
								})
							})
							
							// email 인증 버튼 구현 
							$(".certification").click(function(){
								var email = $("#email").val();
								var msg = $("#chkMsg1");
								console.log(email);
								if(email==""){	
									msg.html('이메일을 입력해주세요');
									msg.css('color', 'red');
									$(".certification").css("cursor","no-drop");
									$("#msg-tr1").show();
								}
							})
							
							// 인증코드 맞는지 확인
							$("#codeCheck").change(function(){
								var msg = $("#chkMsg2");
								var codeCheck = $("#codeCheck").val();
								if(codeCheck==$('#code_check').val()){
									msg.html('이메일이 인증되었습니다.');
									msg.css('color', 'blue');
									msg.attr('status','1');
									$("#msg-tr2").show();
								}else{
									msg.html('인증코드를 잘못 입력하셨습니다.');
									msg.css('color', 'red');
									msg.attr('status','0');
									$("#msg-tr2").show();
								}
							})
							
							// password 정규표현식 확인
							$("#pw").change(function(){
								var pw = $("#pw").val();
								var msg = $("#chkMsg3");
								if(!regExpPassword.test(pw)){
									msg.html('* 6자 이상의 영문, 숫자 사용');
									msg.css('color', 'red');
									msg.attr('status','0');
									$("#msg-tr3").show();
								}else{
									$("#msg-tr3").hide();
									msg.attr('status','1');
								}
							})
							
							// password 재확인
							$("#rePw").change(function(){
								var pw = $("#rePw").val();
								var msg = $("#chkMsg4");
								if(!(pw===$("#pw").val())){
									msg.html('비밀번호 확인항목의 값이 일치하지 않습니다.');
									msg.css('color', 'red');
									msg.attr('status','0');
									$("#msg-tr4").show();
								}else{
									$("#msg-tr4").hide();
									msg.attr('status','1');
								}
							})
							
							// phone 정규표현식 확인
							$("#phone").change(function(){
								var pw = $("#phone").val();
								var msg = $("#chkMsg5");
								if($("#phone").val()==""){
									msg.attr('status','1');
									$("#msg-tr5").hide();
								}else if(!regExpPhone.test(pw)){
									msg.html('‘-’ 를 포함하여 10~11자리 번호를 입력해주세요.');
									msg.css('color', 'red');
									msg.attr('status','0');
									$("#msg-tr5").show();
								}else{
									msg.attr('status','1');
									$("#msg-tr5").hide();
								}
							})
							
							// 회원가입 button 조건
							$("#join-button").click(function(){
							var email = $("#email").val();
							var codeCheck = $("#codeCheck").val();
							var pw = $("#pw").val();
							var rePw = $("#rePw").val();
							var phone = $("#phone").val();
							var addr = $("#addr").val();
							var zipCode = $("#zipCode").val();
							var detailAddr = $("#detailAddr").val();
							
							var address = addr+"/"+detailAddr;	//주소 = 주소/상세주소
							
							console.log(address);
							
							if(email==""){
								alert("이메일을 입력해주세요");
								  $("#email").focus();
								  $("#chkMsg1").html('이메일항목은 필수 정보입니다.');
								  $("#chkMsg1").css('color', 'red');
							}else if($("#chkMsg1").attr('status')=='0'){
								  $("#email").focus();
							}else if(codeCheck==""){
								alert("이메일을 인증해주세요");
								$("#codeCheck").focus();
								$("#chkMsg2").html('인증번호항목은 필수 정보입니다.');
								$("#chkMsg2").css('color', 'red');
							}else if($("#chkMsg2").attr('status')=='0'){
								  $("#codeCheck").focus();
							}else if(pw==""){
								alert("비밀번호를 입력해주세요");
								$("#pw").focus();
								$("#chkMsg3").html('비밀번호항목은 필수 정보입니다.');
								$("#chkMsg3").css('color', 'red');
							}else if(rePw==""){
								alert("비밀번호확인 항목을 입력해주세요");
								$("#codeCheck").focus();
								$("#chkMsg4").html('비밀번호확인 항목은 필수 정보입니다.');
								$("#chkMsg4").css('color', 'red');
							}else if($("#chkMsg3").attr('status')=='0'){
								  $("#pw").focus();
							}else if($("#chkMsg4").attr('status')=='0'){
								  $("#rePw").focus();
							}else if($("#chkMsg5").attr('status')=='0'){
								  $("#phone").focus();
							}else if(!($("#chk1").is(':checked'))){
								alert("필수 이용약관에 동의해주세요");
							}else if(!($("#chk2").is(':checked'))){
								alert("필수 이용약관에 동의해주세요");
							}
							
							else{
								$('#myModal').modal('show');
								$.ajax({
									url:"/ajaxJoin",
									type:"get",
									data: {email:email, pw:pw,phone:phone,address:address,zipCode:zipCode},
									success:function(data){
										if(data=='0'){ 	// 회원가입 실패
											console.log("회원가입실패");
										}else{
											console.log("회원가입성공");
											$('#myModal').modal('show');
										}																										
									}, error:function(){
										console.log("에러");
									}
								})
							}
								
							
						})
						
					
				
		})
	</script>

</body>
</html>