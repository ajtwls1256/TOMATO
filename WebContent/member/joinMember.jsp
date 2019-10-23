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
<title>Insert title here</title>
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
							<td><input class="input-info" id="postCode"
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
						<form id="form1">


							<div id="sel1">
								<select id="area1-1" name="h_area1-1" style="width: 90px">

									<option>-선택-</option>

									<option value='서울'>서울</option>
									<option value='부산'>부산</option>
									<option value='대구'>대구</option>
									<option value='인천'>인천</option>
									<option value='광주'>광주</option>
									<option value='대전'>대전</option>
									<option value='울산'>울산</option>
									<option value='강원'>강원</option>
									<option value='경기'>경기</option>
									<option value='경남'>경남</option>
									<option value='경북'>경북</option>
									<option value='전남'>전남</option>
									<option value='전북'>전북</option>
									<option value='제주'>제주</option>
									<option value='충남'>충남</option>
									<option value='충북'>충북</option>

								</select> <select id="area2-1" name="h_area2-1" style="width: 120px">

									<option value='0'>-선택-</option>

								</select>
								<button class="addressAdd-btn" id="btn1" type="button">추가</button>
							</div>


							<div id="sel2">
								<select id="area1-2" name="h_area1-2" style="width: 90px">

									<option>-선택-</option>

									<option value='서울'>서울</option>
									<option value='부산'>부산</option>
									<option value='대구'>대구</option>
									<option value='인천'>인천</option>
									<option value='광주'>광주</option>
									<option value='대전'>대전</option>
									<option value='울산'>울산</option>
									<option value='강원'>강원</option>
									<option value='경기'>경기</option>
									<option value='경남'>경남</option>
									<option value='경북'>경북</option>
									<option value='전남'>전남</option>
									<option value='전북'>전북</option>
									<option value='제주'>제주</option>
									<option value='충남'>충남</option>
									<option value='충북'>충북</option>

								</select> <select id="area2-2" name="h_area2-2" style="width: 120px">

									<option value='0'>-선택-</option>

								</select>
								<button class=".addressAdd-btn" id="btn2" type="button">추가</button>
							</div>


							<div id="sel3">
								<select id="area1-3" name="h_area1-3" style="width: 90px">

									<option>-선택-</option>

									<option value='서울'>서울</option>
									<option value='부산'>부산</option>
									<option value='대구'>대구</option>
									<option value='인천'>인천</option>
									<option value='광주'>광주</option>
									<option value='대전'>대전</option>
									<option value='울산'>울산</option>
									<option value='강원'>강원</option>
									<option value='경기'>경기</option>
									<option value='경남'>경남</option>
									<option value='경북'>경북</option>
									<option value='전남'>전남</option>
									<option value='전북'>전북</option>
									<option value='제주'>제주</option>
									<option value='충남'>충남</option>
									<option value='충북'>충북</option>

								</select> <select id="area2-3" name="h_area2-3" style="width: 120px">

									<option value='0'>-선택-</option>

								</select>
								<button class=".addressAdd-btn" id="btn3" type="button">추가</button>
							</div>


							<button class="addressAdd-btn" id="complete" type="button"
								style="margin-top: 20px;">완료</button>
						</form>
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
					$("#postCode").val(data.zonecode);
					$("#addr").val(data.roadAddress);
					$("#addr").val(data.jibunAddress);
				}
			}).open();
		}

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
		var cat1_name = new Array('서울', '부산', '대구', '인천', '광주', '대전', '울산',
				'강원', '경기', '경남', '경북', '전남', '전북', '제주', '충남', '충북');

		var cat2_name = new Array();

		cat2_name[1] = new Array('강남구', '강동구', '강북구', '강서구', '관악구', '광진구',
				'구로구', '금천구', '노원구', '도봉구', '동대문구', '동작구', '마포구', '서대문구',
				'서초구', '성동구', '성북구', '송파구', '양천구', '영등포구', '용산구', '은평구', '종로구',
				'중구', '중랑구');

		cat2_name[2] = new Array('강서구', '금정구', '남구', '동구', '동래구', '부산진구', '북구',
				'사상구', '사하구', '서구', '수영구', '연제구', '영도구', '중구', '해운대구', '기장군');

		cat2_name[3] = new Array('남구', '달서구', '동구', '북구', '서구', '수성구', '중구',
				'달성군');

		cat2_name[4] = new Array('계양구', '남구', '남동구', '동구', '부평구', '서구', '연수구',
				'중구', '강화군', '옹진군');

		cat2_name[5] = new Array('광산구', '남구', '동구', '북구', '서구');

		cat2_name[6] = new Array('대덕구', '동구', '서구', '유성구', '중구');

		cat2_name[7] = new Array('남구', '동구', '북구', '중구', '울주군');

		cat2_name[8] = new Array('강릉시', '동해시', '삼척시', '속초시', '원주시', '춘천시',
				'태백시', '고성군', '양구군', '양양군', '영월군', '인제군', '정선군', '철원군', '평창군',
				'홍천군', '화천군', '횡성군');

		cat2_name[9] = new Array('고양시 덕양구', '고양시 일산구', '과천시', '광명시', '광주시',
				'구리시', '군포시', '김포시', '남양주시', '동두천시', '부천시 소사구', '부천시 오정구',
				'부천시 원미구', '성남시 분당구', '성남시 수정구', '성남시 중원구', '수원시 권선구',
				'수원시 장안구', '수원시 팔달구', '시흥시', '안산시 단원구', '안산시 상록구', '안성시',
				'안양시 동안구', '안양시 만안구', '오산시', '용인시', '의왕시', '의정부시', '이천시',
				'파주시', '평택시', '하남시', '화성시', '가평군', '양주군', '양평군', '여주군', '연천군',
				'포천군');

		cat2_name[10] = new Array('거제시', '김해시', '마산시', '밀양시', '사천시', '양산시',
				'진주시', '진해시', '창원시', '통영시', '거창군', '고성군', '남해군', '산청군', '의령군',
				'창녕군', '하동군', '함안군', '함양군', '합천군');

		cat2_name[11] = new Array('경산시', '경주시', '구미시', '김천시', '문경시', '상주시',
				'안동시', '영주시', '영천시', '포항시 남구', '포항시 북구', '고령군', '군위군', '봉화군',
				'성주군', '영덕군', '영양군', '예천군', '울릉군', '울진군', '의성군', '청도군', '청송군',
				'칠곡군');

		cat2_name[12] = new Array('광양시', '나주시', '목포시', '순천시', '여수시', '강진군',
				'고흥군', '곡성군', '구례군', '담양군', '무안군', '보성군', '신안군', '영광군', '영암군',
				'완도군', '장성군', '장흥군', '진도군', '함평군', '해남군', '화순군');

		cat2_name[13] = new Array('군산시', '김제시', '남원시', '익산시', '전주시 덕진구',
				'전주시 완산구', '정읍시', '고창군', '무주군', '부안군', '순창군', '완주군', '임실군',
				'장수군', '진안군');

		cat2_name[14] = new Array('서귀포시', '제주시', '남제주군', '북제주군');

		cat2_name[15] = new Array('공주시', '논산시', '보령시', '서산시', '아산시', '천안시',
				'금산군', '당진군', '부여군', '서천군', '연기군', '예산군', '청양군', '태안군', '홍성군');

		cat2_name[16] = new Array('제천시', '청주시 상당구', '청주시 흥덕구', '충주시', '괴산군',
				'단양군', '보은군', '영동군', '옥천군', '음성군', '진천군', '청원군');

		function chkAll() {

		}
		//modal에서 addservlet으로 보내느 cat2지역 전역변수로 지정
		var cat2Area1 = 0;
		var cat2Area2 = 0;
		var cat2Area3 = 0;
		var cat2Area = new Array();
		$(document).ready(function() {
						
							$("#sel2").hide();
							$("#sel3").hide();

							$("#area1-1")
									.change(
											function() {
												//console.log($(this).val());	
												//console.log($("#area1 option").length-1);

												if ($(this).val() == '0') // 시가 선택되지 않으면 리턴
													return;

												var opt = $("#area2-1 option");
												opt.not("[value='0']").remove(); //#area2의 기본값만 남기고 삭제

												//console.log(cat2_name[$(this).val()].length);
												var area1_1 = $(this).val();

												for (var a = 0; a < cat1_name.length; a++) {
													if (area1_1 == cat1_name[a]) {
														area1_1 = (a + 1);
													}
												}

												for (var i = 0; i < cat2_name[area1_1].length; i++) { //#area의 option 생성
													var option = $("<option>"
															+ cat2_name[area1_1][i]
															+ "</option>");
													$("<option></option>")
															.attr(
																	"value",
																	cat2_name[area1_1][i]);
													$("#area2-1")
															.append(option);
												}
												
												$("#area2-1").change(
														function() {
															cat2Area[0] = ($(this).val());
														})
											})
							$("#area1-2")
									.change(
											function() {
												//console.log($(this).val());	
												//console.log($("#area1 option").length-1);

												if ($(this).val() == '0') // 시가 선택되지 않으면 리턴
													return;

												var opt = $("#area2-2 option");
												opt.not("[value='0']").remove(); //#area2의 기본값만 남기고 삭제

												//console.log(cat2_name[$(this).val()].length);
												var area1_2 = $(this).val();

												for (var a = 0; a < cat1_name.length; a++) {
													if (area1_2 == cat1_name[a]) {
														area1_2 = (a + 1);
													}
												}

												for (var i = 0; i < cat2_name[area1_2].length; i++) { //#area의 option 생성
													var option = $("<option>"
															+ cat2_name[area1_2][i]
															+ "</option>");
															
															$("<option></option>").attr(
																	"value",
																	cat2_name[area1_2][i]);
															$("#area2-2")
															.append(option);
												}

												$("#area2-2").change(
														function() {
															cat2Area[1] = ($(this)
																	.val());
														})
											})

							$("#area1-3")
									.change(
											function() {
												//console.log($(this).val());	
												//console.log($("#area1 option").length-1);

												if ($(this).val() == '0') // 시가 선택되지 않으면 리턴
													return;

												var opt = $("#area2-3 option");
												opt.not("[value='0']").remove(); //#area2의 기본값만 남기고 삭제

												//console.log(cat2_name[$(this).val()].length);
												var area1_3 = $(this).val();

												for (var a = 0; a < cat1_name.length; a++) {
													if (area1_3 == cat1_name[a]) {
														area1_3 = (a + 1);
													}
												}

												for (var i = 0; i < cat2_name[area1_3].length; i++) { //#area의 option 생성
													var option = $("<option>"
															+ cat2_name[area1_3][i]
															+ "</option>");
													$("<option></option>")
															.attr(
																	"value",
																	cat2_name[area1_3][i]);
													$("#area2-3")
															.append(option);
												}

												$("#area2-3").change(
														function() {
															cat2Area[2]=($(this)
																	.val());
														})
											})

							$("#btn1").click(function() {
								$("#sel2").show();
								$("#btn1").hide();
							})

							$("#btn2").click(function() {
								$("#sel3").show();
								$("#btn2").hide();
								var name = $("#area2-3").attr("name");
								console.log(name);
							})
							
							$("#btn3").click(function() {
								$("#btn3").hide();
							})
							
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
										console.log("아이디 중복 체크 실패");
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
							}/*else if(!(($("#chk1").attr("checked"))&&($("#chk2").attr("checked")))){
								alert("필수 이용약관에 동의해주세요");
							}
							*/
							else{
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
						
						//$('#myModal').modal('show');
							// modal을 이용한 주변주소 정보 추가
										
								$('#btn1').click(function(){
									var email = $("#email").val();
									var cat1Area1 = $("#area1-1").val();
									var choiceArea = cat1Area1+"/"+(cat2Area[0]); // 시 / 군,구
									console.log(choiceArea);
									$.ajax({
											url:"/ajaxAddAddrChoice",
											type:"get",
											data:{email:email, addrChoice:choiceArea},
											success :function(data){
												if(data!=0){
													alert("괸심지역1 추가 성공");
												}else{
													alert("괸심지역1 추가 실패!");												
												}
											}, error:function(){
												alert("괸심지역1 추가 망함ㅜ");
											}
									})
								})
								
								$('#btn2').click(function(){
									var email = $("#email").val();
									var cat1Area1 = $("#area1-2").val();
									var choiceArea = cat1Area1+"/"+(cat2Area[1]); // 시 / 군,구
									console.log(choiceArea);
									$.ajax({
											url:"/ajaxAddAddrChoice",
											type:"get",
											data:{email:email, addrChoice:choiceArea},
											success :function(data){
												if(data!=0){
													alert("괸심지역2 추가 성공");
												}else{
													alert("괸심지역2 추가 실패!");												
												}
											}, error:function(){
												alert("괸심지역1 추가 망함ㅜ");
											}
									})
								})
								$('#btn3').click(function(){
									var email = $("#email").val();
									var cat1Area1 = $("#area1-3").val();
									var choiceArea = cat1Area1+"/"+(cat2Area[2]); // 시 / 군,구
									console.log(choiceArea);
									$.ajax({
											url:"/ajaxAddAddrChoice",
											type:"get",
											data:{email:email, addrChoice:choiceArea},
											success :function(data){
												if(data!=0){
													alert("괸심지역3 추가 성공");
												}else{
													alert("괸심지역3 추가 실패!");												
												}
											}, error:function(){
												alert("괸심지역3 추가 망함ㅜ");
											}
									})
								})
								
		})
	</script>

</body>
</html>