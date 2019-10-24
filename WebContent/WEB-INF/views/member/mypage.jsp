<%@page import="kr.co.tomato.member.model.vo.MemberAddress"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="kr.co.tomato.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member m = (Member) session.getAttribute("member");
		
	ArrayList<MemberAddress> list = (ArrayList<MemberAddress>)request.getAttribute("addrList");

	// 우리집 주소 (db) : '주소 /상세주소' 형태로 저장  => 토큰으로 분리해서 사용
	String addr = null;
	String detailAddr = null;
	if(m.getAddress()!=null){
		StringTokenizer token = new StringTokenizer(m.getAddress(),"/");
		addr = token.nextToken();
		detailAddr = token.nextToken();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>토마토마켓</title>
<script type="text/javascript"
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
<style>
* {
	
}

.mypage_area {
	width: 100%;
	display: flex;
	justify-content: center;
}

.mypage_box {
	width: 1000px;
	padding: 50px 10px 20px 20px;
}

.f-header {
	padding-bottom: 25px;
	font-size: 25px;
}

.icon-img{
	width: 25px;
	height: 25px;
}


.f-icon-td {
	width: 30px;
	padding: 0 10px 0 10px;
}

td {
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
	height: 50px;
}
.btn-wrap{
	width:100%;
	display:inline-block;
	text-align:center;
	margin:30px 0 10px 0;
}
.btn1{
	border:1 soild black;
	border-radius:1px;
	background-color:white;
	color:#878787;
	font-size:13px;
	height: 30px;
	width:100px;
}
.btn-2{
	margin-left:10px;
	width:200px;
	height:50px;
	background-color:white;
	border:1px solid #c42026;
	border-radius: 4px;
	color:#c42026;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<div class="mypage_area">
		<div class="mypage_box">

			<div class="f-header">My page</div>

			<div class="f-content"  style="position:relative">
				<p>기본정보</p>
				<form action="/updateMember" method="get">
				<table style="margin-bottom:30px;">
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/email2.png"></td>
						<td style="width: 150px;">이메일</td>
						<td colspan="2" style="width: 200px;"><input class="input-info" type="text" id="email" name="email" value="<%=m.getEmail()%>"readOnly></td>
					</tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/padlock.png"></td>
						<td>비밀번호</td>
						<td><input type="password" id="pw" name="pw" value="<%=m.getMemberPw()%>"></td>
						<td style="width:700px; padding-left:10px;"><span id="chkMsg3"></span></td>
					</tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/padlock.png"></td>
						<td>비밀번호 확인</td>
						<td><input class="input-info" type="password" placeholder="비밓번호 확인" id="rePw"></td>
						<td style="padding-left:10px;"><span id="chkMsg4"></span></td>
					</tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/phone-call.png"></td>
						<td>핸드폰 번호</td>
						<%if(m.getPhone()==null){%>
							<td><input class="input-info" type="text" id="phone" name="phone" placeholder="핸드폰 번호"></td>
						<%} else{%>
							<td><input class="input-info" type="text" id="phone" name="phone" value="<%=m.getPhone()%>"></td>
						<%} %>
						<td style="padding-left:10px;"><span id="chkMsg5"></span></td>
					</tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/envelope.png"></td>
						<td>우편번호</td>
						<%if(m.getZipCode()==null){%>
							<td><input class="input-info" type="text" id="zipCode" name="zipCode" style="width:90px" placeholder="우편번호" readOnly></td>
						<%} else{%>
							<td><input class="input-info" type="text" id="zipCode" name="zipCode" style="width:90px" value="<%=m.getZipCode()%>" readOnly></td>
						<%} %>
						<td><img src="/img/sj/btn_zipcode.gif" style="width:92px; height:28px; margin-left:10px; cursor:pointer; position:absolute; top:240px; right:605px;" onclick="addrSearch();" ></td>
					</tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/house.png"></td>
						<td>주소</td>
						<%if(addr==null){%>
							<td colspan="2"><input class="input-info" type="text" id="addr" name="addr" style="width:300px" placeholder="주소" readOnly></td>
						<%} else{%>
							<td colspan="2"><input class="input-info" type="text" id="addr" name="addr" style="width:300px" value="<%=addr%>" readOnly></td>
						<%} %>
					</tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/add.png"></td>
						<td style="width: 130px;">상세주소</td>
						<%if(detailAddr==null){%>
							<td colspan="2"><input class="input-info" type="text" placeholder="상세주소" id="detailAddr" name="detailAddr"></td>
						<%} else{%>
							<td colspan="2"><input class="input-info" type="text"  name="detailAddr" value="<%=detailAddr%>"></td>
						<%} %>
					</tr>
				</table>
				<p>추가정보</p>
				<table>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/add.png"></td>
						<td style="width: 150px;">회원 이름</td>
						<%if(m.getMemberName()==null){%>
							<td colspan="3"><input class="input-info" type="text" 
							placeholder="이름" id="memberName" name="memberName"></td>
						<%} else{%>
							<td colspan="3"><input class="input-info" type="text"
							name="memberName" value="<%=m.getMemberName()%>"></td>
						<%} %>
					</tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/add.png"></td>
						<td style="width: 130px;">은행</td>
						<%if(m.getMemberBank()==null){%>
							<td colspan="3"><input class="input-info" type="text" 
							placeholder="은행" id="memberBank" name="memberBank"></td>
						<%} else{%>
							<td colspan="3"><input class="input-info" type="text"
							name="memberBank" value="<%=m.getMemberBank()%>"></td>
						<%} %>
					</tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/add.png"></td>
						<td style="width: 130px;">계좌번호</td>
						<%if(m.getMemberAccount().equals("0")){%>
							<td colspan="3"><input class="input-info" type="text" 
							placeholder="계좌번호" id="memberAccount" name="memberAccount"></td>
						<%} else{%>
							<td colspan="3"><input class="input-info" type="text"
							name="memberAccount" value="<%=m.getMemberAccount()%>"></td>
						<%} %>
					</tr>
				<%for(MemberAddress mAddr : list) {%>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/placeholder.png"></td>
						<td  style="width: 130px;">관심 지역 </td>
						<td style="width: 205px;"><input class="input-info" value="<%=mAddr.getAddrChoiceCity()%>"></td>
						<td style="width: 205px;"><input class="input-info" value="<%=mAddr.getAddrChoiceGungu()%>"></td>
						<td  style="width: 440px;"><button type="button" style="width:100px;">수정</button></td>
					</tr>
				<%} %>
				</table>
				
				<div class="btn-wrap">
					<button class="btn-2" id="btn-mainPage">뒤로가기</button> 
					<button class="btn-2" id="btn-updateMember" type="button">수정</button> 
					<button class="btn-2" id="btn-deleteMember">탈퇴</button> 
				</div>
				
				</form>
			</div>


		</div>
	</div>
	
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	
	<script>
	
	//다음 api를 이용한 주소 찾기
	function addrSearch() {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#postCode").val(data.zonecode);
				$("#addr").val(data.roadAddress);
				$("#addr").val(data.jibunAddress);
			}
		}).open();
	}
	
	$(document).ready(function(){
		$("#btn-mainPage").click(function(){
			location.href="/";
		})
		
		// 회원 탈퇴
		$("#btn-deleteMember").click(function(){
			var email = $("#email").val();
			console.log(email);
			location.href="/deleteMember?email="+email+"";
		})		

		// 비밀번호, 핸드폰 번호 정규표현식
		var regExpPassword = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{6,}$/;
		var regExpPhone = /^01(?:0|1|[6-9])-(?:[0-9]{3}|[0-9]{4})-[0-9]{4}$/;
		
		
		// password 정규표현식 확인
		$("#pw").change(function(){
			var pw = $("#pw").val();
			var msg = $("#chkMsg3");
			if(!regExpPassword.test(pw)){
				msg.html('* 6자 이상의 영문, 숫자 사용');
				msg.css('color', 'red');
				msg.attr('status','0');
			}else{
				msg.html('');
				msg.attr('status','1');
			}
		})
	
		// password 재확인
		$("#rePw").change(function(){
			var pw = $("#rePw").val();
			var msg = $("#chkMsg4");
			if(!(pw===$("#pw").val())){
				msg.html('* 비밀번호 확인항목의 값이 일치하지 않습니다.');
				msg.css('color', 'red');
				msg.attr('status','0');
			}else{
				msg.html('');
				msg.attr('status','1');
			}
		})
		
		// phone 정규표현식 확인
		$("#phone").change(function(){
			var pw = $("#phone").val();
			var msg = $("#chkMsg5");
			if($("#phone").val()==""){
				msg.html('');
				msg.attr('status','1');
			}else if(!regExpPhone.test(pw)){
				msg.html('‘-’ 를 포함하여 10~11자리 번호를 입력해주세요.');
				msg.css('color', 'red');
				msg.attr('status','0');
			}else{
				msg.html('');
				msg.attr('status','1');
			}
		})
		
		// 관심지역 수정 btn을 누르면
		
		
		
		
		
		
		// 수정 button 실행 조건
		$("#btn-updateMember").click(function(){
				var pw = $("#pw").val();
				var rePw = $("#rePw").val();
				var phone = $("#phone").val();
				var addr = $("#addr").val();
				var zipCode = $("#zipCode").val();
				var detailAddr = $("#detailAddr").val();
					
				var address = addr+"/"+detailAddr;	//주소 = 주소/상세주소
				console.log(address);
							
				if(pw==""){
					alert("비밀번호를 입력해주세요");
					$("#pw").focus();
					$("#chkMsg3").html('* 비밀번호항목은 필수 정보입니다.');
					$("#chkMsg3").css('color', 'red');
				}else if(rePw==""){
					alert("비밀번호확인 항목을 입력해주세요");
					$("#codeCheck").focus();
					$("#chkMsg4").html('* 비밀번호확인 항목은 필수 정보입니다.');
					$("#chkMsg4").css('color', 'red');
				}else if($("#chkMsg3").attr('status')=='0'){
					$("#pw").focus();
				}else if($("#chkMsg4").attr('status')=='0'){
					$("#rePw").focus();
				}else if($("#chkMsg5").attr('status')=='0'){
					$("#phone").focus();
				}
				else{
					$("#btn-updateMember").attr('type','submit');
				}
							
		})
	})
	
	
	</script>
	
</body>
</html>