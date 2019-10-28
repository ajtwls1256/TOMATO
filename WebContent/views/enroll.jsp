<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>물품 관리</title>
<link rel="stylesheet" href="/css/product/enroll.css" type="text/css">
<!-- <script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>

	function loadImg(f) {
		console.log(f.files); // input태그에 선택된 파일을 배열로 가져옴
		if (f.files.length != 0 && f.files[0] != 0) {
			var reader = new FileReader();
			reader.readAsDataURL(f.files[0]); // 매개변수로 지정한 파일의 경로
			reader.onload = function(e) {
				$("#e-img_view").attr('src', e.target.result);
			}
		} else {
			$("#e-img_view").attr('src', '');
		}
	}

	$(function() {
		var sBtn = $(".e-nav > li");
		sBtn.find("#e-menu_select").click(function() {
			sBtn.removeClass("e-active");
			$(this).parent().addClass("e-active");
		});

		// 이미지 미리보기 지우기
		$('#e-img_del').click(function() {
			alert('지웠당~');
			// 보류
			// 삭제하려면 filename으로 넘어가는 name속성의 변수에 들어가는 값을 비워야되는데
			// 그게 뭔지 몰라
			$('#e-image').remove();
			// 미리보기 제거
			$("#e-img_view").attr('src', '');
		});

		// 상품설명 글자 제한
		$('.e-form_comment').keyup(function(e) {
			var content = $(this).val();
			$('#e-comment_count').html(content.length);

			if (content.length > 2000) {
				alert("최대 2000자까지 입력 가능합니다.");
				$(this).val(content.substring(0, 2000));
				$('#e-comment_count').html("2000");
			}
		});
	});
	// 메인카테고리 선택시 서브카테고리 선택
	function selectCategory() {
		var female = [ "상의", "하의", "원피스", "스포츠", "아우터", "신발" ];
		var male = [ "상의", "하의", "스포츠", "아우터", "신발" ];
		var beauty = [ "색조화장품", "기초화장품", "남성화장품", "식품" ];
		var digital = [ "PC/노트북", "카메라", "가전제품", "게임" ];
		var book = [ "상품권", "도서", "티켓", "기프티콘" ];
		var star = [ "보이그룹", "걸그룹", "기타" ];
		var life = [ "생활용품", "주방용품", "가구", "식품" ];
		var etc = [ "기타" ];
		var selectItem = $("#e-selectMain").val();
		var changeItem;
		if (selectItem == "여성의류") {
			changeItem = female;
		} else if (selectItem == "남성의류") {
			changeItem = male;
		} else if (selectItem == "뷰티/미용") {
			changeItem = beauty;
		} else if (selectItem == "디지털/가전") {
			changeItem = digital;
		} else if (selectItem == "도서/티켓") {
			changeItem = book;
		} else if (selectItem == "스타굿즈") {
			changeItem = star;
		} else if (selectItem == "생활/가구") {
			changeItem = life;
		} else if (selectItem == "기타") {
			changeItem = etc;
		}
		$('#e-selectSub').empty();
		for (var count = 0; count < changeItem.length; count++) {
			var option = $("<option>" + changeItem[count] + "</option>");
			$('#e-selectSub').append(option);
		}
	}
</script>
</head>

<body>
	<div class="e-sidebar">
		<nav class="e-navbar">
			<div>
				<ul class="e-nav">
					<li class="e-nav-header">
						<div>
							<a href="/"> <img src="/img/tomatoLogo.png" width="100%"
								height="100%">
							</a> <br> <a href="#"> <img src="/img/instagram.png"
								width="100%" height="100%">
							</a> <span>상점이름 - E05</span>
						</div>
					</li>
					<li>
						<a href="/" id="e-menu_select">
							<span>홈</span>
						</a>
					</li>
					<li>
						<a href="/views/enroll.jsp" id="e-menu_select" class="e-active">
							<span>물품 등록</span>
						</a>
					</li>
					<li>
						<a href="/itemList" id="e-menu_select">
							<span>물품관리</span>
						</a>
						</li>
					<li>
						<a href="/buyItem" id="e-menu_select">
							<span>구매/판매내역</span>
						</a>
					</li>
					<li>
						<a href="#" id="e-menu_select">
							<span>탈퇴하러가기</span>
						</a>
					</li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="e-main">

		<form action="/insertItem" method="post" enctype="multipart/form-data">

			<div class="e-div_bg">
				<div class="e-main_head">
					<div class="e-main_head_top">
						<h2>물품 등록</h2>
						<ol class="e-main_head_title">
							<li><a href="/">Home</a></li> /
							<li><strong>물품 등록</strong></li>
						</ol>
					</div>
				</div>
				<div class="e-main_body">
					<div>
						<div class="e-main_body_img">
							<div class="e-main-body_imgcontent">
								<h2>이미지 등록</h2>
								<br>

								<!-- 이미지 업로드 버튼 -->
								<div class="e-enroll_img_btn">
									<span>이미지 업로드</span> <input type="file" name="filename"
										class="e-enroll_box" multiple id="photo_upload"
										onchange="loadImg(this)" id="e-image">
								</div>
								<br>
								<div class="e-main_img" id="e-img_viewer">
									<!--사진 여기 들어감!!!!-->
									<img id="e-img_view" height="420"
										style="max-width: 592px; max-height: 500px;">
									<button id="e-img_del" class="e-img_del_btn" type="button">
										지우기</button>
								</div>
								<ul class="e-img_list">
									<li style="float: left;" class="">
										<div id="e-img_previewer">
											<img id="e-img_preview" class="e-input_img">
										</div>
									</li>
								</ul>

								<h2>
									<br>
								</h2>
								<br> <span class="e-text_position"> * 상품 이미지는
									640x640에 최적화 되어 있습니다. <br> - 이미지는 상품등록 시 정사각형으로 짤려서 등록됩니다.
									<br> - 큰 이미지일경우 이미지가 깨지는 경우가 발생할 수 있습니다. <br> 최대 지원
									사이즈인 640 X 640 으로 리사이즈 해서 올려주세요. <br>
								</span> <br>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="e-item_status_back">
				<!-- 상품 기본정보 들어감!!! -->
				<div class="e-item_status_set">
					<div>
						<h2>물품정보</h2>
						<div>
							<div class="e-item_main_back">
								<fieldset class="e-item_main">
									<div class="e-item_menu">
										<label class="e-item_menu_label">카테고리 : </label>
										<div class="e-item_menu_maincate">
											<select class="e-mainCategory_select" name="itemMainCategory"
												id="e-selectMain" onchange="selectCategory()">
												<option value="" selected disabled>카테고리를 선택해주세요</option>
												<option value="여성의류">여성의류</option>
												<option value="남성의류">남성의류</option>
												<option value="뷰티/미용">뷰티/미용</option>
												<option value="디지털/가전">디지털/가전</option>
												<option value="도서/티켓">도서/티켓</option>
												<option value="스타굿즈">스타굿즈</option>
												<option value="생활/가구">생활/가구</option>
												<option value="기타">기타</option>
											</select>
										</div>
										<div class="e-item_menu_subcate">
											<select class="e-subCategory_select" name="itemSubCategory"
												id="e-selectSub">
											</select>
										</div>
									</div>
									<br>
									<div class="e-item_menu">
										<br> <label class="e-item_menu_label">거래지역 :</label>
										<div class="e-item_menu_addr">
											<select class="e-mainCategory_select" name="itemDealRegion">
												<option value="" selected disabled>-선택-</option>
												<option value="강남구">강남구</option>
												<option value="강동구">강동구</option>
												<option value="강북구">강북구</option>
												<option value="강서구">강서구</option>
												<option value="관악구">관악구</option>
												<option value="광진구">광진구</option>
												<option value="구로구">구로구</option>
												<option value="금천구">금천구</option>
												<option value="노원구">노원구</option>
												<option value="도봉구">도봉구</option>
												<option value="동대문구">동대문구</option>
												<option value="동작구">동작구</option>
												<option value="마포구">마포구</option>
												<option value="서대문구">서대문구</option>
												<option value="서초구">서초구</option>
												<option value="성동구">성동구</option>
												<option value="성북구">성북구</option>
												<option value="송파구">송파구</option>
												<option value="양청구">양청구</option>
												<option value="영등포구">영등포구</option>
												<option value="용산구">용산구</option>
												<option value="은평구">은평구</option>
												<option value="종로구">종로구</option>
												<option value="중구">중구</option>
												<option value="중랑구">중랑구</option>
											</select>
										</div>
									</div>
									<div class="e-item_menu">
										<br> <br> <label class="e-item_menu_label">상태
											:</label>
										<div class="e-item_menu_state">
											<select class="e-menu_state_form_control" name="itemState">
												<option value="중고">중고</option>
												<option value="중고+하자">중고+하자</option>
												<option value="새물품">새물품</option>
												<option value="새것+하자">새것+하자</option>
												<option value="거의새것">거의새것</option>
											</select>
										</div>
									</div>
									<div class="e-item_menu">
										<br> <br> <label class="e-item_menu_label">제목
											:</label>
										<div class="e-item_menu_title">
											<input type="text" class="e-form_control_title"
												placeholder="제목(최대 40자)" name="itemName">
										</div>
									</div>
									<div class="e-item_menu">
										<br> <br> <label class="e-item_menu_label">가격
											:</label>
										<div class="e-item_menu_price">
											<input type="number" class="e-form_control_price"
												placeholder="10000(가격은 숫자로만 입력)" name="itemPrice">
											<div class="e-service_check">
												<label class="e-checkbox_inline"> <input
													type="checkbox" id="input_service_check"
													name="itemDeliveryNY" value="1"> 택배비 포함
												</label>
											</div>
										</div>
									</div>
									<br> <br>
									<div class="e-item_menu">
										<br> <label class="e-item_menu_label">설명 :</label>
										<div class="e-item_menu_comment">
											<textarea class="e-form_comment" rows="7"
												placeholder="상품설명은 2000자 까지 가능합니다." name="itemContent"></textarea>
											<div>
												<span style="float: right;">/2000</span> <span
													id="e-comment_count"
													style="float: right; color: rgb(0, 0, 0);">0</span>
											</div>
										</div>
									</div>
									<div class="e-item_menu">
										<br> <label class="e-item_menu_label">수량 :</label>
										<div class="e-item_menu_count">
											<input type="text" class="e-item_count" placeholder="1"
												value="1" name="itemAmount">
										</div>
									</div>
									
								</fieldset>
							</div>
						</div>
						<div class="e-item_pay">
							<div class="e-item_upload">
								<div class="e-upload_text">
									<button type="submit" class="e-upload_btn">물품 등록</button>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

		</form>

	</div>
</body>
</html>
