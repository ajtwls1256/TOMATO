<%@page import="kr.co.tomato.vo.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
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
    <section>
    	<div class="c-con">
	        <div class="c-sell_page_main">
	        	<div class="c-sell-main-img-div">
	        		<c:choose>
                       <c:when test="${empty item.getItemThumFilepath() }">
                          <img src="/img/imageempty.png" id="sell-main-img" style="width:400px; height:400px; margin-top: 20px;">
                       </c:when>
                       <c:otherwise>
                          <img src="/upload/product/${item.getItemThumFilepath() }" style="width:400px; height:400px; margin-top: 20px;">
                       </c:otherwise>
                    </c:choose> 
	        	</div>
	        	<div class="c-sell-main-info">
	        		<div class="c-sell_title">
		        		<h2 style="padding-left: 20px; font-weight: bold;">${item.getItemName()}</h2>
		        		<h1 style="padding-left: 20px;"> <fmt:formatNumber type="number" maxFractionDigits="3" value="${item.itemPrice }" />원</h1>
	        		</div>
	                    <div class="c-sell_info_variable">
	                    	<div class="c-sell_info_favorite"><img src="/img/sellPage/favorite.png" class="sell-main-icon"><span>${item.getFavoriteCount()}</span></div>
	                    	<div class="c-sell_info_view" ><img src="/img/sellPage/view.png" class="sell-main-icon"><span>${item.getReadcount()}</span></div>
	                    	<div><img src="/img/sellPage/date.png" class="sell-main-icon"><span>${item.getItemEnrollDate()}</span></div>
	                    </div>
	                    <div class="sell-main-con2">
		                    <div class="c-sell_info_fix">
		                        <ul style="padding-left: 420px; font-size: 16px;">
		                            <li><h5>상품상태 :${item.getItemState()} </h5></li>
		                            <li><h5>상품 수량: ${item.getItemAmount()} </h5></li>
		                            <li><h5>배송비여부 : ${item.getItemDeliveryNY()}  </h5></li>
		                            <li><h5>거래지역 : ${item.getItemDealRegion()} </h5></li>
		                            
		                        </ul>
		                    </div>
		                    <div class="c-sell_info_btn">
		                        <div class="c-sell_interest_btn"><button class="c-sell_interest_button" type="button">찜</button></div>
		                        <div class="c-sell_contact_btn"><button class="c-sell_contact_button" type="button">연락처</button></div>
		                        <div class="c-sell_sell_btn"><button class="c-sell_sell_button" type="button">바로구매</button></div>
		                    </div>
	                    </div>
	                </div>
	        	</div> 

<%-- 	        
	            		<div class="c-sell_sell">
	                		<div class="c-sell_photo">
	                			<div class="c-sell_photo_view">
		                			 <c:choose>
	                                    <c:when test="${empty item.getItemThumFilepath() }">
	                                       <img src="/img/imageempty.png" style="width:400px; height:400px; margin-top: 20px;">
	                                    </c:when>
	                                    <c:otherwise>
	                                       <img src="/upload/product/${item.getItemThumFilepath() }" style="width:400px; height:400px;">
	                                    </c:otherwise>
	                                 </c:choose> 
                                 </div>
                             </div>
	                	</div>
 --%>	                
<%-- 	                
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
	                            <li><h4>배송비여부 : ${item.getItemDeliveryNY()}  </h4></li>
	                            <li><h4>거래지역 : ${item.getItemDealRegion()} </h4></li>
	                            
	                        </ul>
	                    </div>
	                    <div class="c-sell_info_btn">
	                        <div class="c-sell_interest_btn"><button class="c-sell_interest_button" type="button"><h2>찜</h2></button></div>
	                        <div class="c-sell_contact_btn"><button class="c-sell_contact_button" type="button"><h2>연락처</h2></button></div>
	                        <div class="c-sell_sell_btn"><button class="c-sell_sell_button" type="button"><h2>바로구매</h2></button></div>
	                    </div>
	                </div>
	            </div>   
	             --%>
	           
	            
	            
	            
	            
	             <!--  상품정보 div--> 
	             
	              
	            <div class="c-sell_etc" style="display: inline-block;">
	                <div class="c-sell_etc_title">
	                    <div class="c-sell_etc_info">
	                        <div class="c-sell_etc_input">상품 정보</div>
	                        <div class="c-sell_etc_view">
		                        <p style="font-weight: bold;">상품 설명</p>
		                        ${item.getItemContent() }
	                        </div>
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
	                            <span class="c-sell_etc_content"><a href="/mypage?memberNo=${item.getMemberNo()}">#${item.getItemNo()}</a></span>
	                            </div>
	                        </div>
	                    </div>
	                    
	                    
	             <!-- 상품 문의 div -->
	             
	             
	                    <div class="c-sell_etc_inquiry">
	                        <div class="c-etc_inquiry_input">
	                             <div class="c-etc_inquiry_title">상품 문의</div>
	                             <div class="c-etc_inquiry_textarea">
	                                 <textarea placeholder="문의내용을 입력해주세요" class="c-etc_textarea_content"></textarea>
	                            </div>
	                            <div class="c-etc_inquiry_textinput">
	                                <div class="c-etc_inquiry_textvar">
	                                    
	                                </div>
	                                <div class="c-etc_inquiry_textin">
	                                    <button class="c-etc_inquiry_textin_btn" type="button"><img src="/img/sellPage/input.png"><span>등록</span></button>
	                                </div>
	                            </div>    
	                        </div>
	                       </form>
	                        <div class="c-etc_inquiry_view">
	                            <div class="c-etc_inquiry_view2">
	                            	<table>
	                            		
	                            		<c:forEach items="${itemInquiry}" var="inquiry" >
	                            				<c:if test="${inquiry.getItemInquiryLevel()==1 }" >
		                            				
			                            			<form action="/deleteItemInquiry" type="post">
			                            			<tr>
			                            				
			                            				<td></td>
			                            				<td>${inquiry.getItemInquiryWriter()}</td>
			                            				<td>${inquiry.getItemInquiryComment() }</td>
			                            				<td>${inquiry.getItemInquiryDate() }</td>
			                            				<c:if test="${not empty sessionScope.member}">
														<td><button class="c-textareaReply" type="button" onclick="infunction(this,${inquiry.getItemInquiryNo()})">답글 등록</button></td>
														</c:if>
														<c:if test="${sessionScope.member.getMemberNo()==item.getMemberNo() }"> 
														<input type="hidden" name="itemInquiryNo" value="${inquiry.getItemInquiryNo() }"></input>
			                            				<input type="hidden" name="itemRef" value="${inquiry.getItemRef() }"></input>
			                            				<td><button class="c-textareaDelete" type="submit" >삭제하기</button></td>
			                            				< </c:if> 
			                            				
			                            				</tr>
			                            			
			                            			</form>
		                            			</c:if>
		                            			<c:forEach items="${itemInquiry}" var="inquiryReply" >
			                            			<c:if test="${inquiryReply.getItemInquiryLevel() eq 2 && inquiryReply.getItemInquiryRef() eq inquiry.getItemInquiryNo()}">
			                            				<form action="/deleteItemInquiryReply" get="post">
					                            			<tr>				
					                            				<td></td>							  				
												  				<td>└─</td>
												  				<td>${inquiryReply.getItemInquiryWriter()}</td>
												  				<td>${inquiryReply.getItemInquiryComment() }</td>
												  				<td>${inquiryReply.getItemInquiryDate() }</td>
												  				<c:if test="${sessionScope.member.getMemberNo()==item.getMemberNo() }">
												  				<td><button class='c-replyDelete'>문의 답글 삭제하기</button></td>	
												  				</c:if>
												  				<td><input type="hidden" name="itemReplyNo" value="${inquiryReply.getItemInquiryNo()}"></input></td>
												  				<td><input type="hidden" name="itemReplyRef" value="${inquiryReply.getItemRef()}"></input></td>
												  				<td><input type="hidden" name="itemReplyLevel" value=2></input></td>
												  				<td><input type="hidden" name="itemReplyInquiryRef" value="${inquiryReply.getItemInquiryRef()}"></input></td>			                            				
					                            			</tr>
				                            			</form>
			                            			</c:if>
	                            				</c:forEach>
	                            		</c:forEach>
	                            		
	                            		</table>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	               
	          <!-- 상점 정보  div -->  
	                
	                
	                
	            </div>  
	            <div class="c-sell_store_info" style="display: inline-block;">
	                    <div class="c-sell_store_info_title">상점 정보</div>
	                    <div class="c-sell_store_info_indiv">
	                    	<div class="c-sell-indiv-img"><a href="/mypage"><img src="/img/mypage/mypage_view.png" style="width:100%;height:100%;"></a></div>
	                    	<div class="c-sell-indiv-info">
	                    		<a href="#" class="c-sell-indiv-a1">${sessionScope.member.getMemberName()}</a>
	
	                    	</div>
	                    
	                    </div>
	                    <div class="c-sell_store_info_picture">
	                    	<div class="c-sell_store_info_picture_photo">
	                    		<c:forEach items="${photoList}" var="photo">
		                    			<c:if test="${photo.memberNo == item.memberNo}">
			                                       <img src="/upload/product/${photo.itemThumFilepath}" style="width:100px; height:100px;" onclick="gofunction(${photo.itemNo})">
	                                 	
	                                 	</c:if>
                                 	</c:forEach>
                                 </div>
                                 
	                    	<div class="c-sell_store_info_picture_a" >
	                    		
	                    	</div>
	                    </div>

	                    <div class="c-sell_info_input">상점 후기</div>

	                    <div class="c-sell_store_info_review">
	                   	 <table>
	                   	 	
	                    	<c:forEach items="${Review}" var="review">
	                    	
		                    	<form action="/deleteReview" method="post">
		                    	<tr>
		                    		
		                    		<td>${review.reviewWriter}</td>
		                    		<td>${review.reviewDate}</td>
		                    	</tr>
		                    	<tr>	
		                    		<td>${review.reviewContent}</td>
		                    		<td>${review.reviewScore}</td> 
		                    		<c:if test="${sessionScope.member.memberNo == item.memberNo}">
		                    		<td><button tyep="submit" class="deleteReviewBt" class="deleteReviewBtn">삭제</button></td>
		                    		<input type="hidden" name="reviewNo" value="${review.getReviewNo() }"></input>
		                    		<input type="hidden" name="shopNo" value="${review.getShopNo() }"></input>
		                    		<input type="hidden" name="itemNo" value="${item.getItemNo() }"></input>
		                    		</c:if>
		                    		                  		
		                    	</tr>
		                    	</form> 
	                    	
	                   			
	                    	</c:forEach>
	                     </table>
	                     	<c:if test="${sessionScope.member.getMemberNo() ne item.getMemberNo()}">
							<div class="c-sell_info_review_btn"><button type="button" ><span>후기 작성</span></button></div>
							</c:if>
							
	                    </div>
	                </div>
	        </div>
	     
    </section>

     <script>
     
     	/* 찜 카운트 스크립트 */
     
     $(".c-sell_interest_button").click(function(){
    	
    	 var itemNo = ${item.itemNo};
    	 var shopNo = ${sessionScope.member.memberNo};
    	 var favoriteCount = ${item.favoriteCount};
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
    	var inquiryLevel = 1;
    	var shopName = "${sessionScope.member.getShopName()}";
    	 $.ajax({
    		 url:"/insertItemInquiry", 
				data:{textarea:textarea,itemNo:itemNo,inquiryLevel:inquiryLevel,shopName:shopName},
				type:"get",
				success:function(){
					location.href="/sellPage?itemNo=${item.getItemNo()}"
				},
				error: function(){
					console.log("서버전송실패");
				}   		 
    	 });

     });
     
      /* 상품 문의의 답글 */
      
      
      
     function infunction(obj,inquiryNo){
    	
    	 var tr = $("<tr style='width:5%;height:40px;'></tr>");
    	
    	 	tr.append($("<td></td>"));
    	 	tr.append($("<td></td>"));
    	 	tr.append($("<td></td>"));
    	 	tr.append($("<td></td>"));
    	 	tr.append($("<td></td>"));
    	 	 tr.append($("<td><input type='text'  class='itemTextareaReplyContent'></input></td>")); 
    	 	tr.append($("<td><button type='button' class='c-ReplyInsert' onclick='ReplyInsert(this,"+inquiryNo+")'>등록</button></td>"));
    	 	tr.append($("<td><button type='button' class='c-ReplyDefault' onclick='ReplyDefault(this)'>취소</button></td>"));
    	 	
    	 $(obj).parent().parent().after(tr);
    	 
     };
    	/* 답글 저장 */
	     function ReplyInsert(obj,inquiryNo){
	    	 
	    		var content = $('.itemTextareaReplyContent').val();
	    		
	    	 	var form = $("<form action='/insertItemInquiryReply' method='post' ></form>");
	      	   	 form.append($("<input type='text' name='itemInquiryNo' value='"+inquiryNo+"'></input>")); 
	      	   	form.append($("<input type='hidden' name='itemInquiryWriter' value='${sessionScope.member.getShopName()}'></input>"));
	      	   	form.append($("<input type='hidden' name='itemFormTextareaReplyContent' value='"+content+"'></input>"));
	      	  	form.append($("<input type='hidden' name='itemRef' value='${item.getItemNo()}'></input>"));
	  			form.append($("<input type='hidden' name='itemInquiryLevel' value='2'></input>"));
	  			
	  			$(obj).append(form);
	  			
	  			
	  			form.submit();
	  			
	  			
	      	  $(obj).parent().parent().hide();
	      	  
	      	 
	     }
     	
     
      
     	function ReplyDefault(obj){
     		$(obj).parent().parent().hide();
     	}
 
     /* 후기 입력 */
     $(".c-sell_info_review_btn").click(function(){
    	$(this).hide();
    	
    	var div=$("<div></div>");
    	
    	
    	var form=$("<form action='/insertReview' method='post'></form>");
    	form.append($("<input type='hidden' name='shopNo' value='${item.getMemberNo()}'></input>")); 
   	 	form.append($("<input type='hidden' name='reviewWriter' value='${sessionScope.member.getShopName()}'></input>"));
   	 	form.append("<input type='hidden' name='itemNo' value='${item.getItemNo()}'></input>")
   	   	form.append("<input type='text' name='reviewContent'  style='width:65%;height:30px;'></input>");
    	form.append("<input type='text' placeholder='1~5까지 점수를 입력해주세요' style='width:30px;height:30px;text-align center;' name='reviewScore'></input>")
    	form.append("<button type='submit' name='insertReviewContent'>후기 등록</button>");
    	
    	
    	 div.append(form); 
    	
    	
    	$(this).after(div);
    
     });
     
     	/* 사진 클릭시 상점이동 */
     	function gofunction(itemNo){
     		location.href="#"
     	}
     
     </script>
     
     <%@include file="/WEB-INF/views/common/footer.jsp" %>
     
    
</body>
</html>