<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/css/sellpage/sellPage.css">
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
                    <div class="c-sell_title"><h2>상품명</h2><h2>상품가격</h2></div>
                    <div class="c-sell_info_variable">
                    	<div class="c-sell_info_favorite"><img src="/img/sellPage/favorite.png"><span>찜 수</span></div>
                    	<div class="c-sell_info_view" ><img src="/img/sellPage/view.png"><span>본 사람 수</span></div>
                    	<div class="c-sell_info_date" ><img src="/img/sellPage/date.png"><span>날짜</span></div>
                    	
                    </div>
                    <div class="c-sell_info_fix">
                        <ul>
                            <li><h4>상품상태 : </h4></li>
                            <li><h4>교환여부 : </h4></li>
                            <li><h4>배송비 : </h4></li>
                            <li><h4>거래지역 : </h4></li>
                            
                        </ul>
                    </div>
                    <div class="c-sell_info_btn">
                        <div class="c-sell_interest_btn"><button id="c-sell_button1"><h2>찜</h2></button></div>
                        <div class="c-sell_contact_btn"><button id="c-sell_button2"><h2>연락처</h2></button></div>
                        <div class="c-sell_sell_btn"><button id="c-sell_button3"><h2>바로구매</h2></button></div>
                    </div>
                </div>
            </div>
            
            
             <!--  상품정보 div--> 
             
              
            <div class="c-sell_etc">
                <div class="c-sell_etc_title">
                    <div class="c-sell_etc_info">
                        <div class="c-sell_etc_input"><h3>상품 정보</h3></div>
                        <div class="c-sell_etc_view"></div>
                        <div class="c-sell_etc_choice">
                            <div class="c-sell_etc_addr"><img src="/img/sellPage/where2.png"><span>거래지역</span></div>
                        <div class="c-sell_etc_category"><img src="/img/sellPage/category.png"><span>카테고리</span></div>
                            <div class="c-sell_etc_tag"><img src="/img/sellPage/tag.png"><span>상품 태그</span></div>
                        </div>
                    </div>
                    
                    
             <!-- 상품 문의 div -->
             
             
                    <div class="c-sell_etc_inquiry">
                        <div class="c-etc_inquiry_input">
                             <div class="c-etc_inquiry_title"><h3>상품 문의</h3></div>
                             <div class="c-etc_inquiry_textarea">
                                 <textarea placeholder="문의내용을 입력해주세요";></textarea>
                            </div>
                            <div class="c-etc_inquiry_textinput">
                                <div class="c-etc_inquiry_textvar">
                                    <span>글자수</span>
                                </div>
                                <div class="c-etc_inquiry_textin">
                                    <button id="c-sell_button4"><img src="/img/sellPage/input.png"><span>등록</span></button>
                                </div>
                            </div>    
                        </div>
                        <div class="c-etc_inquiry_view">
                            <div class="c-etc_inquiry_view2">
                            	<div>생성될 문의들</div>
                            </div>
                            <div class="c-etc_inquiry_btn">  
                               
                                <button id="c-sell_button5">상품문의 더보기</button>
                                
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
                    		<a href="#">상점 이름</a>
                    		
                    		<a href="#">상품</a> 
                    	</div>
                    
                    </div>
                    <div class="c-sell_store_info_picture">
                    	<div class="c-sell_store_info_picture_photo">사진 들어갈 자리</div>
                    	<div class="c-sell_store_info_picture_a" >
                    		<a href="#">이동</a>
                    	</div>
                    </div>
                    <div class="c-sell_info_input"><h3>상점 후기</h3></div>
                    <div class="c-sell_store_info_review">
                    	<div class="c-sell_info_null">
                    		<div class="c-sell_info_null_content">등록된 후기가 없습니다.<br> 
                    		첫 후기를 등록해보세요!</div>
                            <div class="c-sell_info_null_btn"><button id="c-sell_button6"><span>후기 작성</span></button></div>
                    	</div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <br>
     
     
     
     <script>
     
     	$("#id-sell_button1").click(function(){
     		var
     		
     		
     	});
     
     
     </script>
       
     $("#jQ1").click(function(){
			var message=$("#msg1").val();
			$.ajax({
				url:"/ajaxTest1", 
				data:{msg:message},
				type:"get",
				success:function(){
					console.log("서버전송성공");
				},
				error: function(){
					console.log("서버전송실패");
				},
				complete:function(){
					console.log("무조건 호출");
				}
			})
		});
     
     
     
    
</body>
</html>