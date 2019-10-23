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
<title>Insert title here</title>
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

				<table style="margin-bottom:30px;">
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/email2.png"></td>
						<td style="width: 150px;">이메일</td>
						<td style="width: 900px;"><input class="input-info" type="text"
							name="email" value="<%=m.getEmail()%>"readOnly></td>
						<td></td>
					</tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/padlock.png"></td>
						<td style="width: 130px;">비밀번호</td>
						<td colspan="2"><input class="input-info" type="password"
							name="pw" value="<%=m.getMemberPw()%>">&nbsp*  8~16자의 영문, 숫자 사용  </td>
					</tr>
					<tr></tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/padlock.png"></td>
						<td style="width: 130px;">비밀번호 확인</td>
						<td colspan="2"><input class="input-info" type="password" placeholder="비밓번호 확인"
							></td>
					</tr>
					<tr></tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/phone-call.png"></td>
						<td style="width: 130px;">핸드폰 번호</td>
						<%if(m.getPhone()==null){%>
							<td colspan="2"><input class="input-info" type="text"
							name="phone" placeholder="핸드폰 번호"></td>
						<%} else{%>
							<td colspan="2"><input class="input-info" type="text"
							name="phone" value="<%=m.getPhone()%>"></td>
						<%} %>
					</tr>
					<tr></tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/envelope.png"></td>
						<td>우편번호</td>
						<%if(m.getZipCode()==null){%>
							<td colspan="2"><input class="input-info" type="text" id="zipCode" style="width:90px" 
							name="zipCode" placeholder="우편번호" readOnly></td>
						<%} else{%>
							<td colspan="2"><input class="input-info" type="text" id="zipCode" style="width:90px" 
							name="zipCode" value="<%=m.getZipCode()%>" readOnly></td>
						<%} %>
						<td><img src="/img/sj/btn_zipcode.gif" style="width:92px; height:28px; margin-left:10px; cursor:pointer; position:absolute; top:240px; right:605px;" onclick="addrSearch();" ></td>
					</tr>
					<tr></tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/house.png"></td>
						<td>주소</td>
						<%if(addr==null){%>
							<td colspan="2"><input class="input-info" type="text" id="addr" style="width:300px" 
							name="addr" placeholder="주소" readOnly></td>
						<%} else{%>
							<td colspan="2"><input class="input-info" type="text" id="addr" style="width:300px" 
							name="addr" value="<%=addr%>" readOnly></td>
						<%} %>
					</tr>

					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/add.png"></td>
						<td style="width: 130px;">상세주소</td>
						<%if(detailAddr==null){%>
							<td colspan="2"><input class="input-info" type="text" 
							placeholder="상세주소" id="detailAddr"></td>
						<%} else{%>
							<td colspan="2"><input class="input-info" type="text"
							name="detailAddr" value="<%=detailAddr%>"></td>
						<%} %>
					</tr>
				</table>
				<p>추가정보</p>
				<table >
				
				<%for(MemberAddress mAddr : list) {%>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/placeholder.png"></td>
						<td  style="width: 130px;">관심 지역 </td>
						<td style="width: 205px;"><input class="input-info" value="<%=mAddr.getAddrChoice()%>"></td>
						<td  style="width: 695px;"><button type="button" style="width:100px;">수정</button></td>
					</tr>
				<%} %>
				</table>
				
				<div class="btn-wrap">
					<button class="btn-2">뒤로가기</button> 
					<button class="btn-2">수정</button> 
					<button class="btn-2" id="btn-deleteMember">탈퇴</button> 
				</div>

			</div>

			<div class=""></div>

		</div>
	</div>
	
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	
	<script>
	
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
		$("btn-deleteMember").click(function(){
			alert("삭제");		
		})		
		
		
		
	})
	
	
	</script>
	
	
		
	
	
	
</body>
</html>