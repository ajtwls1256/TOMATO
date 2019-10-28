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
    <section class="c-sellpage">
    <br>
    	<div class="con">
	        <div class = "c-sell_page_main">
	            <div class="c-sell_sell">
	                		<div class="c-sell_photo">
	                			<div class="c-sell_photo_view">
		                			 <c:choose>
	                                    <c:when test="${empty item.getItemThumFilepath() }">
	                                       <img src="/img/imageempty.png" style="width:100%; height:100%;">
	                                    </c:when>
	                                    <c:otherwise>
	                                       <img src="/upload/product/${item.getItemThumFilepath() }" style="width:100%; height:100%;">
	                                    </c:otherwise>
	                                 </c:choose> 
                                 </div>
                             </div>
	                	
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
														<%-- <c:if test="${sessionScope.member.getMemberNo()==item.getMemberNo() }"> --%>
														<input type="hidden" name="itemInquiryNo" value="${inquiry.getItemInquiryNo() }"></input>
			                            				<input type="hidden" name="itemRef" value="${inquiry.getItemRef() }"></input>
			                            				<td><button class="c-textareaDelete" type="submit" >삭제하기</button></td>
			                            				<%-- </c:if> --%>
			                            				
			                            				</tr>
			                            			
			                            			</form>
		                            			</c:if>
		                            			<c:forEach items="${itemInquiry}" var="inquiryReply" >
			                            			<c:if test="${inquiryReply.getItemInquiryLevel()==2 && inquiryReply.getItemInquiryRef() == inquiry.getItemInquiryNo()}">
			                            				<form action="/deleteItemInquiryReply" get="post">
					                            			<tr>				
					                            				<td></td>							  				
												  				<td>└─</td>
												  				<td>${inquiryReply.getItemInquiryWriter()}</td>
												  				<td>${inquiryReply.getItemInquiryComment() }</td>
												  				<td>${inquiryReply.getItemInquiryDate() }</td>
												  				<td><button class='c-replyDelete'>문의 답글 삭제하기</button></td>	
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
	                
	                
	                <div class="c-sell_store_info">
	                    <div class="c-sell_store_info_title"><h3>상점 정보</h3></div>
	                    <div class="c-sell_store_info_indiv">
	                    	<div class="c-sell-indiv-img"><a href="/mypage"><img src="/img/mypage/mypage_view.png" style="width:100%;height:100%;"></a></div>
	                    	<div class="c-sell-indiv-info">
	                    		<a href="#" class="c-sell-indiv-a1">${sessionScope.member.getMemberName()}</a>
	
	                    	</div>
	                    
	                    </div>
	                    <div class="c-sell_store_info_picture">
	                    	<div class="c-sell_store_info_picture_photo">
	                    		<c:forEach items="${photoList}" var="photoList">
		                                       <img src="/upload/product/${photoList.getItemThumFilepath() }" style="width:100px; height:100px;" onclick="gofunction(${photoList.getItemNo()})">
                                 	</c:forEach>
                                 </div>
                                 
	                    	<div class="c-sell_store_info_picture_a" >
	                    		
	                    	</div>
	                    </div>
	                    <div class="c-sell_info_input"><h3>상점 후기</h3></div>
	                    <div class="c-sell_store_info_review">
	                   	 <table>
	                   	 	<tr>
	                   	 		<td>작성자</td>
	                   	 		<td>작성내용</td>
	                   	 		<td>작성날짜 </td>
	                   	 		<td>별점</td>
	                   	 	</tr>
	                    	<c:forEach items="${Review}" var="review">
	                    	<c:if test="${review.getShopNo()==item.getMemberNo() }">
		                    	<div class="c-sell_info_view_review" >
		                    	<tr>
		                    		<form action="/deleteReview" method="post">
		                    		<td><span>${review.getReviewWriter()}</span></td>
		                    		<td><span>${review.getReviewContent()}</span></td>
		                    		<td><span>${review.getReviewDate()}</span></td>
		                    		<td><span>${review.getReviewScore()}</span></td> 
		                    		<td><button tyep="submit" class="deleteReviewBt" class="deleteReviewBtn">삭제</button></td>
		                    		<input type="hidden" name="reviewNo" value="${review.getReviewNo() }"></input>
		                    		<input type="hidden" name="shopNo" value="${review.getShopNo() }"></input>
		                    		<input type="hidden" name="itemNo" value="${item.getItemNo() }"></input>
		                    		</form>                   		
		                    	</tr>
		                    	</div>
	                    	</c:if>
	                   			
	                    	</c:forEach>
	                     </table>
							<div class="c-sell_info_review_btn"><button type="button" ><span>후기 작성</span></button></div>
							
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
    	 
    	 var itemNo = ${item.getItemNo()};
    	 var shopNo = ${sessionScope.member.getMemberNo()};
    	 var favoriteCount = ${item.getFavoriteCount()};
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
	    		console.log('여기'+content );
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
    	 var Cif=$(" <c:if test='${sessionScope.member.getMemberNo()!=item.getMemberNo()}'></c:if>"); 
    	
    	var form=$("<form action='/insertReview' method='post'></form>");
    	form.append($("<input type='hidden' name='shopNo' value='${sessionScope.member.getMemberNo()}'></input>")); 
   	 	form.append($("<input type='hidden' name='reviewWriter' value='${sessionScope.member.getMemberName()}'></input>"));
   	 	form.append("<input type='hidden' name='itemNo' value='${item.getItemNo()}'</input>")
   	   	form.append("<input type='text' name='reviewContent'  style='width:65%;height:30px;'></input>");
    	form.append("<input type='text' placeholder='1~5까지 점수를 입력해주세요' style='width:30px;height:30px;text-align center;' name='reviewScore'></input>")
    	form.append("<button type='submit' name='insertReviewContent'>후기 등록</button>");
    	 Cif.append(form); 
    	
    	 div.append(Cif); 
    	
    	
    	$(this).after(div);
    
     });
     
     	/* 사진 클릭시 상점이동 */
     	function gofunction(itemNo){
     		location.href="/SellPage?itemNo="+itemNo;
     	}
     
     </script>
     
     
    
</body>
</html>