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
	if(!m.getAddress().equals("/")){
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
.addressAdd-btn{
	width: 100%;
	background: #C42026;
	color: white;
	border-radius: 4px;
	border: 0;
	height: 30px;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<div class="mypage_area">
		<div class="mypage_box">

			<div class="f-header">My page</div>
			
			<div class="f-content"  style="position:relative">
			
				<p>기본정보</p>

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
						<td><input class="input-info" type="password" placeholder="비밀번호 확인" id="rePw"></td>
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
							<td colspan="2"><input class="input-info" type="text"  name="detailAddr" id="detailAddr" value="<%=detailAddr%>"></td>
						<%} %>
					</tr>
				</table>
				<p>추가정보</p>
				<table>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/add.png"></td>
						<td style="width: 130px;">회원 이름</td>
						<%if(m.getMemberName()==null){%>
							<td colspan="3" style="width:900px;" ><input class="input-info" type="text" 
							placeholder="이름" id="memberName" name="memberName"></td>
						<%} else{%>
							<td colspan="3"  style="width:900px;" ><input class="input-info" type="text"
							name="memberName" id="memberName" value="<%=m.getMemberName()%>"></td>
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
							name="memberBank" id="memberBank" value="<%=m.getMemberBank()%>"></td>
						<%} %>
					</tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/add.png"></td>
						<td style="width: 130px;">계좌번호</td>
						<%if(m.getMemberAccount()==null){%>
							<td colspan="3"><input class="input-info" type="text" 
							placeholder="계좌번호" id="memberAccount" name="memberAccount"></td>
						<%} else{%>
							<td colspan="3"><input class="input-info" type="text"
							name="memberAccount" id="memberAccount" value="<%=m.getMemberAccount()%>"></td>
						<%} %>
					</tr>
					</table>

				<%for(MemberAddress mAddr : list) {%>
				<form action="/updateAddr" method="get">
				<table>
					<tr>
						<td class="f-icon-td" style="border-top:0"><img class="icon-img" src="/img/placeholder.png"></td>
						<td  style="width: 150px; border-top:0">관심 지역 </td>
						<td class="city" style="width: 205px; border-top:0"><input class="input-info" value="<%=mAddr.getAddrChoiceCity()%>"></td>
						<td class="gungu" style="width: 205px; border-top:0"><input class="input-info" value="<%=mAddr.getAddrChoiceGungu()%>"></td>
						<td class="newCity" style="width: 205px; border-top:0">		
							<select id="area1-1" name="h_area1-1" style="width:192px">
								<option value='서울'>서울</option>
							</select> 
						</td>
						<td class="newGungu" style="width: 205px; border-top:0">		
							<select id="area2-1" name="h_area2-1" style="width: 192px">
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
								<input type="hidden" name="myEmail" value="<%=m.getEmail() %>">
								<input type="hidden" name="oldGunguAddr" value="<%=mAddr.getAddrChoiceGungu()%>">
							</td>	
						<td  style="width: 115px; border-top:0"><button type="button" style="width:100px;" onclick="updateAddress(this);">수정</button></td>
						<td  class="btn-submit" style="width: 115px; border-top:0"><button type="submit" style="width:100px;">완료</button></td>
						<td  style="width: 300px; border-top:0"><button type="button" style="width:100px;" onclick="deleteAddress(this);">삭제</button></td>
					</tr>

					</table>
					</form>
				<%} %>
				<div><button type="button" id="btn-insertAddr">관심지역 추가</button></div>
				<div class="btn-wrap">
					<button class="btn-2" id="btn-mainPage">뒤로가기</button> 
					<button class="btn-2" id="btn-updateMember" type="button">수정</button> 
					<button class="btn-2" id="btn-deleteMember">탈퇴</button> 
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- Modal -->
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog" >
			<div class="modal-dialog modal-div">
				<!-- Modal content-->
				<div class="modal-content">
				
				<form action="/addAddrInMypage" method="get">
				
					<div class="modal-header"
						style="padding: 50px 50px; text-align: center; border: 0px; padding-bottom: 0px">
						<img src="/img/tomatoMarketLogo.png" width="30" height="34">
						<p style="font-size: 1.5em; margin-top: 15px;">토마토마켓을 이용해주셔서
							감사합니다.</p>
						<p>회원님의 관심지역을 선택해주세요!</p>
					</div>
					<div class="modal-body" style="padding: 40px 192px;">

							<div id="div-choiceAddr">
								<input type="hidden" name="addrEmail"value="<%=m.getEmail()%>">
								<select name="addCity" style="width: 90px">
									<option value='서울'>서울</option>
								</select> 
								
								<select name="addGungu" style="width: 120px">
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
								
							</div>
					</div>
					<div class="modal-footer">
					<button class="addressAdd-btn" id="complete" type="submit">완료</button>
				
					</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Modal end -->
	
	
	
	
	
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	
	<script>
	
	//다음 api를 이용한 주소 찾기
	function addrSearch() {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#zipCode").val(data.zonecode);
				$("#addr").val(data.roadAddress);
				$("#addr").val(data.jibunAddress);
			}
		}).open();
	}
	
	// 관심 주소 수정
	function updateAddress(updateBtn){
		$(updateBtn).parent().prev().show();
		$(updateBtn).parent().prev().prev().show();
		$(updateBtn).parent().siblings().eq(2).hide();
		$(updateBtn).parent().siblings().eq(3).hide();
		$(updateBtn).parent().hide();
		$(updateBtn).parent().next().show();
	}
	
	function deleteAddress(deleteBtn){
		var email = $("#email").val();
		var gungu = $(deleteBtn).parent().siblings().eq(3).children().eq(0).val();
		console.log(gungu);
		location.href="/deleteAddress?email="+email+"&gungu="+gungu+"";
	}
	
	$(document).ready(function(){
		
		// 관심지역추가Btn 누르면 관심지역추가Modal 나타남 
		$("#btn-insertAddr").click(function(){
			$('#myModal').modal('show');
		})
		
		$(".newCity").hide();
		$(".newGungu").hide();
		$(".btn-submit").hide();
		
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
		
		// 수정 button 실행 조건
		$("#btn-updateMember").click(function(){
				var email = $("#email").val();
				var pw = $("#pw").val();
				var rePw = $("#rePw").val();
				var phone = $("#phone").val();
				var addr = $("#addr").val();
				var zipCode = $("#zipCode").val();
				var detailAddr = $("#detailAddr").val();
				var name = $("#memberName").val();
				var memberBank = $("#memberBank").val();
				var memberAccount = $("#memberAccount").val();
					
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
					console.log("정보 수정중..");
					$.ajax({
						url:"/ajaxUpdateMember",
						type:"get",
						data:{email:email, pw:pw, phone:phone, zipCode:zipCode, address:address, name:name, memberBank:memberBank, memberAccount:memberAccount},
						success : function(data){
							if(data!=0){
								alert("사용자 정보 수정 성공");
							}else{
								alert("사용자 정보 수정 실패!");												
							}
						}, error : function(){
							alert("사용자 정보 수정 error");
						}
					})
				}
		})
	})
	
	
	</script>
	
</body>
</html>