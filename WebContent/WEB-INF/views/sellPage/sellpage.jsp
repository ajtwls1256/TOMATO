<%@page import="kr.co.tomato.vo.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type ="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js">	
</script>
<link rel="stylesheet" href="/css/sellPage/sellPage.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    
   
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <br>
    <section class="c-sellpage">
    	
        <div class = "c-sell_page_main">
            <div class="c-sell_sell">
               
                <div class="c-sell_photo">
                	<div class="c-sell_photo_view"></div>
                	<div class="c-sell_photo_navi"></div>
                </div>
                <div class="c-sell_info">
                    <div class="c-sell_title"><h2>${item.getItemName()} </h2><h2>${item.getItemPrice()}원</h2></div>
                    <div class="c-sell_info_variable">
                    	<div class="c-sell_info_favorite"><img src="/img/sellPage/favorite.png"><span>${item.getFavoriteCount()}</span></div>
                    	<div class="c-sell_info_view" ><img src="/img/sellPage/view.png"><span>${item.getReadcount()}</span></div>
                    	<div class="c-sell_info_date" ><img src="/img/sellPage/date.png"><span>${item.getItemEnrollDate()}</span></div>
                    	
                    </div>
                    <div class="c-sell_info_fix">
                        <ul>
                            <li><h4>상품상태 :${item.getItemState()} </h4></li>
                            <li><h4> 상품 수량: ${item.getItemAmount()} </h4></li>
                            <li><h4>배송비여부 : ${item.getItemDeliveryNy()}  </h4></li>
                            <li><h4>거래지역 : ${item.getItemDealRegion()} </h4></li>
                            
                        </ul>
                    </div>
                    <div class="c-sell_info_btn">
                        <div class="c-sell_interest_btn"><button class="c-sell_interest_button"><h2>찜</h2></button></div>
                        <div class="c-sell_contact_btn"><button class="c-sell_contact_button"><h2>연락처</h2></button></div>
                        <div class="c-sell_sell_btn"><button class="c-sell_sell_button"><h2>바로구매</h2></button></div>
                    </div>
                </div>
            </div>
            
           
            
            
            
            
             <!--  상품정보 div--> 
             
              
            <div class="c-sell_etc">
                <div class="c-sell_etc_title">
                    <div class="c-sell_etc_info">
                        <div class="c-sell_etc_input"><h3>상품 정보</h3></div>
                        <div class="c-sell_etc_view">${item.getItemContent() }</div>
                        <div class="c-sell_etc_choice">
                            <div class="c-sell_etc_addr">
                            	<img src="/img/sellPage/where2.png"><span>거래지역</span><br><br>
                            	<span class="c-sell_etc_content">${item.getItemDealRegion()}</span>
                            </div>
	                        <div class="c-sell_etc_category">
	                       	 <img src="/img/sellPage/category.png"><span>카테고리</span><br><br>
	                       	 <span class="c-sell_etc_content"><a href="#">${item.getItemMainCategory()}</a></span>
	                        </div>
                            <div class="c-sell_etc_tag">
                            <img src="/img/sellPage/tag.png"><span>상품 태그</span><br><br>
                            <span class="c-sell_etc_content"><a href="/mypage?memberNo=${item.getMemberNo()}">${item.getItemNo()}</a></span>
                            </div>
                        </div>
                    </div>
                    
                    
             <!-- 상품 문의 div -->
             
             
                    <div class="c-sell_etc_inquiry">
                        <div class="c-etc_inquiry_input">
                             <div class="c-etc_inquiry_title"><h3>상품 문의</h3></div>
                             <div class="c-etc_inquiry_textarea">
                             	<form>
                                 <textarea placeholder="문의내용을 입력해주세요" class="c-etc_textarea_content"></textarea>
                            	</form>
                            </div>
                            <div class="c-etc_inquiry_textinput">
                                <div class="c-etc_inquiry_textvar">
                                    <span></span>
                                </div>
                                <div class="c-etc_inquiry_textin">
                                    <button class="c-etc_inquiry_textin_btn"><img src="/img/sellPage/input.png"><span>등록</span></button>
                                </div>
                            </div>    
                        </div>
                        <div class="c-etc_inquiry_view">
                            <div class="c-etc_inquiry_view2">
                            	
                            </div>
                            <div class="c-etc_inquiry_btn">  
                               
                                <button >상품문의 더보기</button>
                                
                            </div>
                               
                        </div>
                        
                    </div>
                </div>
               
          <!-- 상점 정보  div -->  
                
                
                <div class="c-sell_store_info">
                    <div class="c-sell_store_info_title"><h3>상점 정보</h3></div>
                    <div class="c-sell_store_info_indiv">
                    	<div class="c-sell-indiv-img">이미지 자리</div>
                    	<div class="c-sell-indiv-info">
                    		<a href="#" class="c-sell-indiv-a1">상점 이름</a>
                    		
                    		<a href="#" class="c-sell-indiv-a2">상품</a> 
                    	</div>
                    
                    </div>
                    <div class="c-sell_store_info_picture">
                    	<div class="c-sell_store_info_picture_photo">사진 들어갈 자리</div>
                    	<div class="c-sell_store_info_picture_a" >
                    		
                    	</div>
                    </div>
                    <div class="c-sell_info_input"><h3>상점 후기</h3></div>
                    <div class="c-sell_store_info_review">
                    	<div class="c-sell_info_null">
                    		<div class="c-sell_info_null_content">등록된 후기가 없습니다.<br> 
                    		첫 후기를 등록해보세요!</div>
                            <div class="c-sell_info_null_btn"><button><span>후기 작성</span></button></div>
                    	</div>
                    	
                    </div>
                </div>
            </div>
        </div>
    </section>
    <br>
     
      
     
     <script>
     
     	/* 찜 카운트 스크립트 */
     
     $(".c-sell_interest_button").click(function(){
    	 
    	 var itemNo = ${item.getItemNo()}
    	 var shopNo = ${item.getItemNo()}
    	 var favoriteCount = ${item.getFavoriteCount()}
    	 $.ajax({
    		 url:"/sellPageFavorite",
    		 type:"get",
    		 data:{itemNo:itemNo,shopNo:shopNo,favoriteCount:favoriteCount},
    		 success : function(){
    			 location.href="/sellPage?itemNo=${item.getItemNo()}";
				
			},
			error : function(){
				console.log("실패");
			}
    		 
    	 });
    	 
     });
    
    
     /* 결제 api */
     
     $(document).ready(function(){
    	$(".c-sell_sell_button").click(function(){	
    		var url="/sellPagePopUp?itemNo=${item.getItemNo()}";
    		var popupDiv="c-popup_div";
    		var status="left=500px, top=200px, width=900px, height=700px, menubar=no,status=no,scrollbar=yes";
    		var popup = window.open(url,popupDiv,status);//빈창 오픈
    		
    	});
    	
     });
     
    
     
      /* 상품 문의 */
     $(".c-etc_inquiry_textin_btn").click(function(){
    	var textarea =  $(".c-etc_textarea_content").val();
    	var itemNo = ${item.getItemNo()};
    	/* var memberName = ${sessionScope.member.getMemberName()}; */
    	var inquiryLevel = 1;
    	 $.ajax({
    		 url:"/insertItemInquiry", 
				data:{textarea:textarea,itemNo:itemNo,inquiryLevel:inquiryLevel},
				type:"get",
				success:function(){
					location.href="/viewItemInquiry?itemNo=${item.getItemNo()}"
				},
				error: function(){
					console.log("서버전송실패");
				}   		 
    	 });

     });
     
     
     
     
     
     
     
     
     
     
     
     </script>
     
     
    
</body>
</html>