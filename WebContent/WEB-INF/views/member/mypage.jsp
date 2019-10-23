<%@page import="kr.co.tomato.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member m = (Member) session.getAttribute("member");
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
						<td colspan="2"><input class="input-info" type="password"
							></td>
					</tr>
					<tr></tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/phone-call.png"></td>
						<td style="width: 130px;">핸드폰 번호</td>
						<td colspan="2"><input class="input-info" type="text"
							name="phone"></td>
					</tr>
					<tr></tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/envelope.png"></td>
						<td>우편번호</td>
						<td><input class="input-info" id="postCode"
						 name="zipCode" style="width:90px" readOnly></td>
						<td><img src="/img/sj/btn_zipcode.gif" style="width:92px; height:28px; margin-left:10px; cursor:pointer; position:absolute; top:240px; right:605px;" onclick="addrSearch();" ></td>
					</tr>
					<tr></tr>
					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/house.png"></td>
						<td>주소</td>
						<td colspan="2"><input style="width:300px;"class="input-info" id="addr"  readOnly
							></td>
					</tr>

					<tr>
						<td class="f-icon-td"><img class="icon-img" src="/img/add.png"></td>
						<td style="width: 130px;">상세주소</td>
						<td colspan="2"><input class="input-info"></td>
					</tr>
				</table>
				<p>추가정보</p>
				<table style="position:relative">
					<tr >
						<td class="f-icon-td"><img class="icon-img" src="/img/placeholder.png"></td>
						<td  style="width: 130px;">관심 지역 </td>
						<td style="width: 900px;"><input class="input-info"></td>
						<td><button type="button" style="width:100px; position:absolute; top:13px; right:500px;">수정</button></td>
					</tr>
				
				</table>
				
				<div class="btn-wrap">
					<button class="btn-2">뒤로가기</button> 
					<button class="btn-2">수정</button> 
					<button class="btn-2">탈퇴</button> 
				</div>

			</div>

			<div class=""></div>

		</div>
	</div>
	
	
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
		
	})
	
	</script>
	
	
	
	
	
</body>
</html>