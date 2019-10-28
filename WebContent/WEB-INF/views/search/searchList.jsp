<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
                <div class="d-category">
                    <!-- 카테고리검색, 검색창 검색에 따라 다른 카테고리 -->
                    <div class="d-searchingCategory">
                        <p>카테고리</p>
                        <p>
                            <!-- 포함된 카테고리가 많은 순으로 최대 4개 -->
                            <span>
                                디지털/가전 > 데스크탑/본체 <span>3백+</span>
                            </span>
                            <span>
                                남성의류 > 맨투맨 티셔츠 <span>2백+</span>
                            </span>
                            <span>
                                도서/티켓/취미/애완 > 학습/사전/참고서 <span>1백+</span>
                            </span>
                            <span>
                                디지털/가전 > 노트북/넷북 <span>50+</span>
                            </span>
                        </p>
                    </div>    
                        
                    <div class="d-selectingCategory">
                        
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
                        
                    </div>
                    <div  class="d-categoryTableDiv">
                    <!-- 검색어가 포함된 메인카테고리,  많은순으로 -->
                        <table>
                            <tr>
                                <td>
                                    디지털가전 <span>1만+</span>
                                </td>
                                <td>
                                    남성의류 <span>1만+</span>
                                </td>
                                <td>
                                    패션잡화 <span>1만+</span>
                                </td>
                                <td>
                                    여성의류 <span>1만+</span>
                                </td>
                                <td>
                                    도서/티켓/취미/애완 <span>1만+</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    디지털가전 <span>1만+</span>
                                </td>
                                <td>
                                    남성의류 <span>1만+</span>
                                </td>
                                <td>
                                    패션잡화 <span>1만+</span>
                                </td>
                                <td>
                                    여성의류 <span>1만+</span>
                                </td>
                                <td>
                                    도서/티켓/취미/애완 <span>1만+</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    디지털가전 <span>1만+</span>
                                </td>
                                <td>
                                    남성의류 <span>1만+</span>
                                </td>
                                <td>
                                    패션잡화 <span>1만+</span>
                                </td>
                                <td>
                                    여성의류 <span>1만+</span>
                                </td>
                                <td>
                                    도서/티켓/취미/애완 <span>1만+</span>
                                </td>
                            </tr>
                        </table>
                    </div>

                </div>
                <div class="d-result">
                    <div calss="d-result-head">
                        <span class="d-result-head-text">
                            
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
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진5">
							  				</div>							  				
							  				<p class="cate-md-name cate1-md5-name">${l.itemName }</p>
							  				<span class="cate-md-price cate1-md5-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate1-md5-time">${l.itemDealRegion }</span>
							  			</div>
			  						</c:when>
			  						<c:otherwise>
			  							<div class="cate1-md cate1-md1">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진">
							  				</div>		
							  				<p class="cate-md-name cate1-md1-name">${l.itemName }</p>
							  				<span class="cate-md-price cate1-md1-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate1-md1-time">${l.itemDealRegion }</span>
							  			</div>
			  						</c:otherwise>
			  					</c:choose>
			  				</c:forEach>
                    </div>
                    <div class="d-result-footer">
                        <!-- 페이지 네비 -->
                    </div>
                </div>
                
            </div>
        </div>
    </div>
	</section>
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %> 
	
	
	 <script>
        $(function(){
            
           
            
            
             $(".d-region>div").click(function(){
                 var index = $(".d-region>div").index(this);
                 
                 $(".d-searchingCategory").addClass("d-off");
                 $(".d-selectingCategory").addClass("d-off");
                 
                 if(index == 0){
                     $(".d-searchingCategory").removeClass("d-off");
                     $(".d-searchingCategory").addClass("d-on");
                     $(".d-categoryTableDiv tr").first().children().css("border-top","1px solid lightgray");
                 }else{
                     $(".d-selectingCategory").removeClass("d-off");
                     $(".d-selectingCategory").addClass("d-on");
                     $(".d-categoryTableDiv tr").first().children().css("border-top","none");
                 }
             });
            
            $(".d-region>div").first().click();
        });
        
       
    </script>
</body>
</html>