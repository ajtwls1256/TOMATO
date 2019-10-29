<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin 결제관리</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/admin/adminPayment.css"/> 
</head>
<body>
	<%@include file="/admin/adminHeader.jsp" %>
	<section>
		<div class="admin-payment-section">
			<div class="admin-payment-title" style="display:inline;">결제관리</div>
			<div class="admin-payment-search" style="display:inline; float:right;">
				<form action="/adminPaymentKeyword">
					<!-- 상품번호, 회원번호, 거래번호, 결제상태 -->
						<select class="admin-payment-search-select" name="type">
							<c:if test="${empty type }"> 
								<option value="itemNo">상품번호</option>
								<option value="memberNo">회원번호</option>
								<option value="merchantUid">상점거래ID</option>
								<option value="paymentState">결제상태</option>
							</c:if>
							<c:if test="${not empty type && type=='itemNo' }"><!-- null이 아닐 때 -->
								<option value="itemNo" selected="selected">상품번호</option>
								<option value="memberNo">회원번호</option>
								<option value="merchantUid">상점거래ID</option>
								<option value="paymentState">결제상태</option>
							</c:if> 
							<c:if test="${not empty type && type=='memberNo' }"><!-- null이 아닐 때 -->
								<option value="itemNo">상품번호</option>
								<option value="memberNo" selected="selected">회원번호</option>
								<option value="merchantUid">상점거래ID</option>
								<option value="paymentState">결제상태</option>
							</c:if>
							<c:if test="${not empty type && type=='merchantUid' }"><!-- null이 아닐 때 -->
								<option value="itemNo">상품번호</option>
								<option value="memberNo">회원번호</option>
								<option value="merchantUid" selected="selected">상점거래ID</option>
								<option value="paymentState">결제상태</option>
							</c:if>
							<c:if test="${not empty type && type=='paymentState' }"><!-- null이 아닐 때 -->
								<option value="itemNo">상품번호</option>
								<option value="memberNo">회원번호</option>
								<option value="merchantUid">상점거래ID</option>
								<option value="paymentState" selected="selected">결제상태</option>
							</c:if>
						</select>
					<input type="text" class="admin-payment-search-input" name="keyword" id="keyword" value="${keyword }"> 
					<button type="submit" class="admin-payment-search-button">검색</button>
				</form>
			</div>
			
			<div class="table-wrapper admin-payment-table-div" style="margin:0 auto;">
				<table class="table table-stariped admin-payment-table" style="text-align: center; ">
					<tr style="text-align:center; font-size: 16px; font-weight: bold;">
						<td style="padding: 11px;">번호</td>
						<td style="padding: 11px;">상점거래ID</td>
						<td style="padding: 11px;">상품번호</td>   
						<td style="padding: 11px;">회원번호</td>
						<td style="padding: 11px;">관리자 고유ID</td>
						<td style="padding: 11px;">결제금액 </td>
						<td style="padding: 11px;">결제일</td>
						<td style="padding: 11px;">카드승인번호</td>
						<td style="padding: 11px;">결제수수료</td>
						<td style="padding: 11px;">결제상태</td>
						<td style="padding: 11px;">환불여부</td>
						<td style="padding: 11px;">변경</td>
						<td style="padding: 11px;">삭제</td>
					</tr>
					<c:forEach items="${aplpd.list}" var="p">					
						<tr>
			 				<td style="padding: 13px;">${p.rnum }</td>
							<td style="padding: 13px;" class="merchantUid">${p.merchantUid }</td>
							<td style="padding: 13px;" class="itemNo">${p.itemNo }</td>
							<td style="padding: 13px;">${p.memberNo }</td>
							<td style="padding: 13px;">${p.impUid }</td>
							<td style="padding: 13px;">${p.paymentPay }</td>
							<td style="padding: 13px;">${p.paymentDate }</td>
							<td style="padding: 13px;">${p.paymentApplyNum }</td>
							<td style="padding: 13px;">${p.paymentCommission }</td>
							<td style="padding: 13px;">
								<select class="admin-select select1" name="select1">	
									<c:if test="${empty p.paymentState }"> 
									<option value="결제완료">결제완료</option>
									<option value="결제취소">결제취소</option>
									</c:if>
									<c:if test="${not empty p.paymentState && p.paymentState=='결제완료' }"><!-- null이 아닐 때 -->
									<option value="결제완료" selected="selected">결제완료</option>
									<option value="결제취소">결제취소</option>
									</c:if> 
									<c:if test="${not empty p.paymentState && p.paymentState=='결제취소' }"><!-- null이 아닐 때 -->
									<option value="결제완료">결제완료</option>
									<option value="결제취소" selected="selected">결제취소</option>
									</c:if>								
								</select>
							</td>
							<td style="padding: 13px;">
								<select class="admin-select select2" name="select2">
									<c:if test="${empty p.paymentNy }"> 
										<option value="N">N</option>
										<option value="Y">Y</option>
									</c:if>
									<c:if test="${not empty p.paymentNy && p.paymentNy=='N' }"><!-- null이 아닐 때 -->
										<option value="N" selected="selected">N</option>
										<option value="Y">Y</option>
									</c:if> 
									<c:if test="${not empty p.paymentNy && p.paymentNy=='Y' }"><!-- null이 아닐 때 -->
										<option value="N">N</option>
										<option value="Y" selected="selected">Y</option>
									</c:if>								
								</select>
							</td>
							<td style="line-height: 28px; padding: 13px;">
								<button type="button" class="admin-payment-button paymentUpdate">변경</button>
							</td>
							<td style="line-height: 28px; padding: 13px;">
								<input type="button" class="admin-payment-button" value="삭제" onclick="location.href='/adminPaymentDelete?merchantUid=${p.merchantUid }'">
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="pageNavi" style="width: 100%; margin: 0 auto; height: 32px; text-align:center; margin-top: 60px;">
					${aplpd.pageNavi }
			</div>
		</div>
	</section>
	<script>
		$(".paymentUpdate").click(function(){
			var index =$(".paymentUpdate").index(this); 
			var merchantUid = $(".merchantUid").eq(index).html();
			var itemNo = $(".itemNo").eq(index).html();
			var select1 = $(".select1").eq(index).val();
			var select2 = $(".select2 option:selected").eq(index).val();
			$.ajax({
				url : "/adminPaymentUpdate",
				type : "post",
				data : {merchantUid:merchantUid, select1:select1, select2:select2, itemNo:itemNo},
				success : function(data){
					$(".select1 option:selected").eq(index).html(select1);
					$(".select2 option:selected").eq(index).html(select2);
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