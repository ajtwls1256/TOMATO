<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin 상품관리>상품목록</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/admin/adminMdList.css"/> 
</head>
<body>
	<%@include file="/admin/adminHeader.jsp" %>
	<section>
		<div class="admin-MdList-section">
			<div class="admin-MdList-title" style="display:inline;">상품목록</div>
			<div class="admin-MdList-search" style="display:inline; float:right;">
				<form action="/adminMdsearchKeyword">
					<!-- 상품번호, 회원번호, 상품명, 거래상태 -->
					<select class="admin-MdList-search-select" name="type">
						<c:if test="${empty type }"> 
							<option value="itemNo">상품번호</option>
							<option value="memberNo">회원번호</option>
							<option value="itemName">상품명</option>
							<option value="itemDealState">거래상태</option>
						</c:if>
						<c:if test="${not empty type && type=='itemNo' }"><!-- null이 아닐 때 -->
							<option value="itemNo" selected="selected">상품번호</option>
							<option value="memberNo">회원번호</option>
							<option value="itemName">상품명</option>
							<option value="itemDealState">거래상태</option>
						</c:if> 
						<c:if test="${not empty type && type=='memberNo' }"><!-- null이 아닐 때 -->
							<option value="itemNo">상품번호</option>
							<option value="memberNo" selected="selected">회원번호</option>
							<option value="itemName">상품명</option>
							<option value="itemDealState">거래상태</option>
						</c:if>
						<c:if test="${not empty type && type=='itemName' }"><!-- null이 아닐 때 -->
							<option value="itemNo">상품번호</option>
							<option value="memberNo">회원번호</option>
							<option value="itemName" selected="selected">상품명</option>
							<option value="itemDealState">거래상태</option>
						</c:if>
						<c:if test="${not empty type && type=='itemDealState' }"><!-- null이 아닐 때 -->
							<option value="itemNo">상품번호</option>
							<option value="memberNo">회원번호</option>
							<option value="itemName">상품명</option>
							<option value="itemDealState" selected="selected">거래상태</option>
						</c:if>
					</select>
					<input type="text" class="admin-MdList-search-input" name="keyword" id="keyword" value="${keyword }"> 
					<button type="submit"class="admin-MdList-search-button">검색</button>
				</form>
			</div>
			
			 
			<div class="table-wrapper admin-MdList-table-div" style="margin:0 auto;">
				<table class="table table-stariped admin-MdList-table" style="text-align: center; ">
					<tr style="text-align:center; font-size: 16px; font-weight: bold;">
						<td style="padding: 11px;">번호</td>
						<td style="padding: 11px;">상품번호</td>   
						<td style="padding: 11px;">회원번호</td>
						<td style="padding: 11px;">카테고리1</td>
						<td style="padding: 11px;">카테고리2</td>
						<td style="padding: 11px;">상품명</td>
						<td style="padding: 11px;">가격</td>
						<td style="padding: 11px;">상품상태</td>
						<td style="padding: 11px;">등록일</td>
						<td style="padding: 11px;">거래상태</td>
						<td style="padding: 11px;">변경</td>
						<td style="padding: 11px;">삭제</td>
					</tr>
					<c:forEach items="${amlpd.list}" var="i">
					<!-- ajax 객체로 받아서 객체로 처리 -->
						<tr id="adminMdTr">
							<td style="padding: 11px;">${i.rnum }</td>
			 				<td style="padding: 11px;" class="itemNo">${i.itemNo }</td>
							<td style="padding: 11px;">${i.memberNo }</td>
							<td style="padding: 11px;">${i.itemMainCategory }</td>
							<td style="padding: 11px;">${i.itemSubCategory }</td>
							<td style="padding: 11px;">${i.itemName }</td>
							<td style="padding: 11px;">${i.itemPrice }</td>
							<td style="padding: 11px;">
							<!-- itemStats -->
								<select class="admin-select select1" name="select1">
									<c:if test="${empty i.itemState }"> 
										<option value="중고">중고</option>
										<option value="중고+하자">중고+하자</option>
										<option value="새물품">새물품</option>
										<option value="새것+하자">새것+하자</option>
										<option value="거의새것">거의새것</option>
									</c:if>
									<c:if test="${not empty i.itemState && i.itemState=='중고' }"><!-- null이 아닐 때 -->
										<option value="중고" selected="selected">중고</option>
										<option value="중고+하자">중고+하자</option>
										<option value="새물품">새물품</option>
										<option value="새것+하자">새것+하자</option>
										<option value="거의새것">거의새것</option>
									</c:if> 
									<c:if test="${not empty i.itemState && i.itemState=='중고+하자' }"><!-- null이 아닐 때 -->
										<option value="중고">중고</option>
										<option value="중고+하자" selected="selected">중고+하자</option>
										<option value="새물품">새물품</option>
										<option value="새것+하자">새것+하자</option>
										<option value="거의새것">거의새것</option>
									</c:if>
									<c:if test="${not empty i.itemState && i.itemState=='새물품' }"><!-- null이 아닐 때 -->
										<option value="중고">중고</option>
										<option value="중고+하자">중고+하자</option>
										<option value="새물품" selected="selected">새물품</option>
										<option value="새것+하자">새것+하자</option>
										<option value="거의새것">거의새것</option>
									</c:if>
									<c:if test="${not empty i.itemState && i.itemState=='새것+하자' }"><!-- null이 아닐 때 -->
										<option value="중고">중고</option>
										<option value="중고+하자">중고+하자</option>
										<option value="새물품">새물품</option>
										<option value="새것+하자" selected="selected">새것+하자</option>
										<option value="거의새것">거의새것</option>
									</c:if>								
									<c:if test="${not empty i.itemState && i.itemState=='거의새것' }"><!-- null이 아닐 때 -->
										<option value="중고">중고</option>
										<option value="중고+하자">중고+하자</option>
										<option value="새물품">새물품</option>
										<option value="새것+하자">새것+하자</option>
										<option value="거의새것" selected="selected">거의새것</option>
									</c:if>									
								</select>
							</td>
							<td style="padding: 11px;">${i.itemEnrollDate }</td>
							<td style="padding: 11px;">
							<!-- itemDealState -->
								<select class="admin-select select2" name="select2">	
									<c:if test="${empty i.itemDealState }"> 
									<option value="판매중">판매중</option>
									<option value="거래중">거래중</option>
									<option value="거래완료">거래완료</option>
									<option value="거래취소">거래취소</option>		
									</c:if>
									<c:if test="${not empty i.itemDealState && i.itemDealState=='판매중' }"><!-- null이 아닐 때 -->
									<option value="판매중" selected="selected">판매중</option>
									<option value="거래중">거래중</option>
									<option value="거래완료">거래완료</option>
									<option value="거래취소">거래취소</option>		
									</c:if> 
									<c:if test="${not empty i.itemDealState && i.itemDealState=='거래중' }"><!-- null이 아닐 때 -->
									<option value="판매중">판매중</option>
									<option value="거래중" selected="selected">거래중</option>
									<option value="거래완료">거래완료</option>
									<option value="거래취소">거래취소</option>		
									</c:if>
									<c:if test="${not empty i.itemDealState && i.itemDealState=='거래완료' }"><!-- null이 아닐 때 -->
									<option value="판매중">판매중</option>
									<option value="거래중">거래중</option>
									<option value="거래완료" selected="selected">거래완료</option>
									<option value="거래취소">거래취소</option>		
									</c:if>
									<c:if test="${not empty i.itemDealState && i.itemDealState=='거래취소' }"><!-- null이 아닐 때 -->
									<option value="판매중">판매중</option>
									<option value="거래중">거래중</option>
									<option value="거래완료">거래완료</option>
									<option value="거래취소" selected="selected">거래취소</option>		
									</c:if>										
								</select>
							</td>
							<td style="line-height: 28px; padding: 11px;">
								<button type="button" class="admin-MdList-button mdUpdate">변경</button>
							</td>
							<td style="line-height: 28px; padding: 11px;">
								<input type="button" class="admin-MdList-button" value="삭제" onclick="location.href='/adminMdListDelete?itemNo=${i.itemNo}'">
							</td>
						</tr>	
					</c:forEach>
				</table>
			</div>
			<div id="pageNavi" style="width: 100%; margin: 0 auto; height: 32px; text-align:center; margin-top: 60px;">
					${amlpd.pageNavi }
			</div>
		</div>
	</section>
	<script>
		$(".mdUpdate").click(function(){
			var index =$(".mdUpdate").index(this); 
			var itemNo = $(".itemNo").eq(index).html();
			var select1 = $(".select1 option:selected").eq(index).val();
			var select2 = $(".select2 option:selected").eq(index).val();
			$.ajax({
				url : "/adminMdUpdate",
				type : "post",
				data : {itemNo:itemNo,select1:select1,select2:select2},
				success : function(data){
					$(".select1 option:selected").eq(index).html(select1);
					$(".select2 option:selected").eq(index).html(select2);elect1.equals('거래완료''))
					alert("변경완료");
				},
				error : function(){
					console.log("ajax 실패");
				}
			});
		});
	</script>
</body>
</html>