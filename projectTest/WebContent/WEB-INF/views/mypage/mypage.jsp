<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="/css/sellpage/mypage.css">

<body>
	
	 <%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <br>
	
	<section>
		<div class="c-my_page">
			<div class="c-my_page_top" >
				<div class="c-my_page_view">
					
						<div class="c-my_page_view_img"></div>
						<div class="c-my_page_view_nickname"></div>
						<div class="c-my_page_view_star"></div>
						<div class="c-my_page_view_btn">
							<button>내 상점 관리</button>
						</div>
					
				</div>
				<div class="c-my_page_info">
					<div class="c-my_page_info_top">
						<div class="c-my_page_info_name">상점명</div>
						<div class="c-my_page_info_view">
							<div class="c-my_page_name_btn">
								<button><span>상점명 수정</span></button>
							</div>
							<div class="c-my_page_variable"> 
								<div class="c-my_page_viewers"></div> 
								<div class="c-my_page_selling"></div> 
							</div>
						</div>
					</div>
					<div class="c-my_page_info_bottom">
						<div class = "c-my_page_info_introduce"></div>
						<div class = "c-my_page_info_btn" >
							<button><span>소개글 수정</span></button>
						</div>
					</div>
				</div>
			</div>
			<div class="c-my_page_bottom">
				
					<div class="c-container">
 
					  <ul class="c-tabs">
					    <li class="tab-link current" data-tab="c-tab-1">상품</li>
					    <li class="tab-link" data-tab="c-tab-2">구매중</li>
					    <li class="tab-link" data-tab="c-tab-3">찜</li>
					    <li class="tab-link" data-tab="c-tab-4">상점후기</li>
					    <li class="tab-link" data-tab="c-tab-5">알림</li>
					    
					  </ul>
					 
					  <div id="c-tab-1" class="tab-content current">
						  <div class="c-mypage_product">
							<div class="c-product_top">
								<div class="c-product_name"><span>상품</span>숫자</div>
								<div class="c-product_select"><select></select></div>
							</div>
							<div class="c-product_bottom">
								<div class="c-product_content">등록된 상품이 없습니다</div>
							</div>
						</div>	
					  </div>
					  <div id="c-tab-2" class="tab-content">
                            <div class="c-selling">
                             <div class="c-selling_name"><span>구매중</span>숫자</div>
                             <div class="c-selling_table">
                                <div class="c-selling_top">
                                    <div class="c-selling_num"><span>번호</span></div>
                                    <div class="c-selling_product"><span>상품명</span></div>
                                    <div class="c-selling_store"><span>판매 상점</span></div>
                                    <div class="c-selling_order"><span>주문관리</span></div>
                                </div>

                                <div class="c-selling_bottom">
                                    <div class="c-selling_number"><span> 번호 </span></div>
                                    <div class="c-selling_product_info">
                                        <div class="c-selling_product_img"><img>이미지 들어갈 자리</div>
                                        <div class="c-selling_product_introduce">
                                            <div class="c-selling_product_name"><span>상품명</span></div>
                                            <div class="c-selling_product_variable">
                                                <div class="c-selling_product_price"><span>가격</span></div>
                                                <div class="c-selling_product_date"><span>날짜</span></div>
                                            </div>
                                            <div class="c-selling_product_delivery"><a href="#">배송</a></div>
                                            <div class="c-selling_product_etc"><span>상품은 잘 받아보셨나요? 확인하시고 구매 확정해주세요!</span></div>
                                        </div>
                                        <div class="c-selling_product_store_info">
                                            <br><br><br><br>
                                            <span>상점 이름</span><br>
                                            <span>상점 전화번호</span><br>
                                            <button>문의 하기</button>
                                        </div>
                                        <div class="c-selling_product_order_list">
                                            <button>구매 확정</button>
                                            <button>반품 요청</button>
                                        </div>
                                    </div>
                                </div>

                             </div>     
                        </div>
					  </div>
					  <div id="c-tab-3" class="tab-content">
						  
                            <div class="c-favorite">
                                <div class="c-favorite_top">
                                    <div class="c-favorite_name"><span>찜</span>숫자</div>
                                </div>
                                <div class="c-favorite_bottom">
                                    <div class="c-favorite_check_top">
                                        <div class="c-favorite_bottom_check1">
                                            <input type="checkbox"><button>선택 삭제</button>
                                        </div>
                                        <div class="c-favorite_sequence">
                                            <div class="c-favorite_price_high"><a href="#">고가순</a></div>
                                            <div class="c-favorite_price_low"><a href="#">저가순</a></div>
                                            <div class="c-favorite_favorite"><a href="#">인기순</a></div>
                                            <div class="c-favorite_new"><a href="#">최신순</a></div>

                                        </div>
                                    </div>
                                    <div class="c-favorite_check_bottom">
                                        <div class="c-favorite_box">
                                            <div class="c-favorite_img">
                                                <div class="c-favorite_sell">
                                                    <br><br><br><br>
                                                    <span>판매</span><img src="/img/mypage/soldout.png"><span>완료</span>
                                                </div>
                                            </div>
                                            <div class="c-favorite_info">
                                                <div class="c-favorite_info_view">
                                                    <div class="c-favorite_variabe">
                                                        <div class="c-favorite_info_name"><span>내용</span></div>
                                                        <div class="c-favorite_info_price"><span>가격</span></div>
                                                        <div class="c-favorite_info_date"><span>날짜</span></div>
                                                    </div>
                                                    <div class="c-favorite_bottom_check2"><input type="checkbox"></div>
                                                </div>
                                                <div class="c-favorite_addr"><img src="/img/mypage/where2.png"><span>주소</span></div>
                                            </div>
                                        </div>    
                                    </div>
                                </div>


                            </div>

					  </div>
					  <div id="c-tab-4" class="tab-content">
					  	<div class="c-store">
					  		<div class="c-inquiry_name"><span>상점 후기</span></div>
					  		<div class="c-inquiry_content">
					  			<div> 상점 후기가 없습니다</div>
					  		</div>
					  	</div>
					  </div>
					  <div id="c-tab-5" class="tab-content">
						<div class="c-alarm">
					  		<div class="c-alarm_name"><span> 알림 </span></div>	
					  		<div class="c-alarm_content">
					  			<div> 알림 없습니다</div>
					  		</div>
					  	</div>
						
						
					  </div>
					 
					</div>
							
			</div>
		</div>
	</section>


	
	
	
	
	
	
	
	<script>
	
	/* 탭 메뉴 돌아가는 로직 시작*/
	
	$(document).ready(function(){
		
		$('ul.c-tabs li').click(function(){
			var tab_id = $(this).attr('data-tab');

			$('ul.c-tabs li').removeClass('current');
			$('.tab-content').removeClass('current');

			$(this).addClass('current');
			$("#"+tab_id).addClass('current');
		})

	})
	
	/* 탭 메뉴 돌아가는 로직 끝*/
	
	/* 이미지 누르면 대표 이미지 변경 */
	
	
	/* 이미지 누르면 대표 이미지 변경 */
	
	
	
	
	
	</script>





</body>
</html>