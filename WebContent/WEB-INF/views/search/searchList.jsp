<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>토마토마켓</title>
<link rel="stylesheet" href="/css/search/searchList.css"/>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	
	<section>
	<div class="d-section">
        <div class="d-container">
            <div class="d-region">
                <div>
                    전체 지역 보기
                </div>
                <div>
                    내 관심지역 보기
                </div>
            </div>
            <div class="d-content">
            	<c:if test="${not empty searchPd.categoryMainResult }">
                <div class="d-category">
                    <!-- 카테고리검색, 검색창 검색에 따라 다른 카테고리 -->
                    <div class="d-searchingCategory">
                        <p>카테고리</p>
                        <p>
                            <!-- 포함된 카테고리가 많은 순으로 최대 4개 -->
                            <c:forEach items="${searchPd.categorySubResult }" var="subCategory" begin="0" end="3">
                            	<span onclick="location.href='/search?keyword=${keyword }&mainCategory=${subCategory.itemMainCategory }&subCategory=${subCategory.itemSubCategory }'">
                               		 ${subCategory.itemMainCategory } > ${subCategory.itemSubCategory } <span>${subCategory.total }</span>
                            	</span>
                            </c:forEach>
                            
                        </p>
                    </div>    
                        
                    <!-- <div class="d-selectingCategory">
                        
                        <img src="/WebContent/img/d-categoryHome.png" height="16px">
                        <span>
                            홈
                        </span>
                        <span>
                            >
                        </span>
                        <span>
                            <select>
                                메인카테고리
                            </select>
                        </span>
                        <span>
                            >
                        </span>
                        <span>
                            <select>
                                서브카테고리
                            </select>
                        </span>
                        
                    </div> -->
                    <div  class="d-categoryTableDiv">
                    <!-- 검색어가 포함된 메인카테고리,  많은순으로 -->
                        <table>
                        	<tr>
                        	<c:forEach items="${searchPd.categoryMainResult }" var="mainCategory" varStatus="mainIndex">
                            	<c:if test="${mainIndex.count ne 1 and  mainIndex.count%6 eq 0}">
                            		</tr><tr>
                            	</c:if>
                            	
                            	<td onclick="location.href='/search?keyword=${keyword }&mainCategory=${mainCategory.itemMainCategory }'">
                            		${mainCategory.itemMainCategory } <span>${mainCategory.total }</span>
                            	</td>
                            	
                            </c:forEach>
                            </tr>
                        
  
                        </table>
                    </div>

                </div>
                </c:if>
                
                <div class="d-result">
                    <div calss="d-result-head">
                        <span class="d-result-head-text" style="font-size: 17px; padding-left:5px;" >
                        	<c:if test="${not empty keyword}">
                            	<span style="color:#c42026; font-weight:bold;">'${keyword }' </span> 
                        	</c:if>
                       		<c:if test="${not empty mainCategory}">
                        		<span style="color:#c42026; font-weight:bold;">(${mainCategory }) </span>
                        	</c:if>
                        	<c:if test="${not empty subCategory}">
                        		<span style="color:#c42026; font-weight:bold;">>(${subCategory }) </span>
                        	</c:if> 
                        	<c:if test="${not empty memAddress}">
                        		<span style="color:#c42026; font-weight:bold;">
                        		[
                        			<c:forEach items="${memAddress }" var="memaddr" varStatus="addrIndex">       
                        				<c:if test="${addrIndex.last }">
                        					${memaddr } ] 지역 
                        				</c:if>  
                        				<c:if test="${not addrIndex.last }">
                        					${memaddr },
                        				</c:if>      				                        		
                        			</c:forEach>
                        		
                        		</span>
                        	</c:if> 
                        	의 검색결과 <span style="color:#c42026; font-weight:bold;">${searchPd.totalCount } </span> 개
                        </span>
                        <span class="d-result-head-order">
                            
                        </span>
                    </div>
                    <div class="d-result-body">
                        	<c:forEach items="${searchPd.list }" var="l" varStatus="searchIndex">
			  					<c:choose>
			  						<c:when test="${searchIndex.count%5 eq 0 }">
			  							<div class="cate1-md cate1-md5" style="margin-left:0px;">
											<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진">
							  				</div>							  				
							  				<p class="cate-md-name cate1-md5-name">${l.itemName }</p>
							  				<span class="cate-md-price cate1-md5-price"><fmt:formatNumber type="number" maxFractionDigits="3" value="${l.itemPrice }" />원</span>
							  				<span class="cate-md-time cate1-md5-time">${l.itemDealRegion }</span>
							  			</div>
			  						</c:when>
			  						<c:otherwise>
			  							<div class="cate1-md cate1-md1">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진">
							  				</div>		
							  				<p class="cate-md-name cate1-md1-name">${l.itemName }</p>
							  				<span class="cate-md-price cate1-md1-price"><fmt:formatNumber type="number" maxFractionDigits="3" value="${l.itemPrice }" />원</span>
							  				<span class="cate-md-time cate1-md1-time">${l.itemDealRegion }</span>
							  			</div>
			  						</c:otherwise>
			  					</c:choose>
			  				</c:forEach>
                    </div>
                    <div class="d-result-footer"  style="width: 100%; margin: 0 auto; height: 50px; text-align:center;  margin-top: 40px;">
                        <!-- 페이지 네비 -->
                        ${searchPd.pageNavi }
                    </div>
                </div>
                
            </div>
        </div>
    </div>
	</section>
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %> 
	
	
	 <script>
	 
		 $(".d-region>div").click(function(){
	         var index = $(".d-region>div").index(this);

	         if(index == 0){
 				 if('${subCategory }' != ""){
  					alert('서브카테고리있네');
  					location.href='/search?keyword=${keyword }&mainCategory=${mainCategory }&subCategory=${subCategory }';
 	        	 }else if('${mainCategory }' != ""){
 	        		 alert('검색어,메인카테고리만있네');
 	        		 location.href='/search?keyword=${keyword }&mainCategory=${mainCategory }';
 	        	 }else{
 	        		 alert('검색어만있네');
 	        		 location.href='/search?keyword=${keyword }';
 	        	 }
	        	 
	        	 
	         }else{
	        	 
 				 if('${subCategory }' != ""){
 					alert('서브카테고리있네');
 					location.href='/search?keyword=${keyword }&mainCategory=${mainCategory }&subCategory=${subCategory }&email=${sessionScope.member.email}';
	        	 }else if('${mainCategory }' != ""){
	        		 alert('검색어,메인카테고리만있네');
	        		 location.href='/search?keyword=${keyword }&mainCategory=${mainCategory }&email=${sessionScope.member.email}';
	        	 }else{
	        		 alert('검색어만있네');
	        		 location.href='/search?keyword=${keyword }&email=${sessionScope.member.email}';
	        	 }
	        	 
	         } 
	         
	     });
		 
		 
		 $(function(){
			$("#header-searchBox").html('${keyword}');
			 
		 });
		 
        
       
    </script>
</body>
</html>