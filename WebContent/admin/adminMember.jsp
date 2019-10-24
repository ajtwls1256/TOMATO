
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin 회원관리</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/admin/adminMember.css"/>    
</head>
<body>
	<%@include file="/admin/adminHeader.jsp" %>
	<section>
		<div class="admin-member-section">
			<div class="admin-member-title" style="display:inline;">회원관리</div>
			<div class="admin-member-search" style="display:inline; float:right;">
				<form action="/searchMemberKeyword">				
					<select name="type" class="admin-member-search-select">
						<c:if test="${empty type }"> 
							<option value="memberNo">회원번호</option>
							<option value="email">이메일</option>
							<option value="shopName">상점명</option>
							<option value="memberName">이름</option>
						</c:if>
						<c:if test="${not empty type && type=='memberNo' }"><!-- null이 아닐 때 -->
							<option value="memberNo" selected="selected">회원번호</option>
							<option value="email">이메일</option>
							<option value="shopName">상점명</option>
							<option value="memberName">이름</option>
						</c:if> 
						<c:if test="${not empty type && type=='email' }"><!-- null이 아닐 때 -->
							<option value="memberNo">회원번호</option>
							<option value="email" selected="selected">이메일</option>
							<option value="shopName">상점명</option>
							<option value="memberName">이름</option>
						</c:if>
						<c:if test="${not empty type && type=='shopName' }"><!-- null이 아닐 때 -->
							<option value="memberNo">회원번호</option>
							<option value="email">아이디</option>
							<option value="shopName" selected="selected">상점명</option>
							<option value="memberName">이름</option>
						</c:if>
						<c:if test="${not empty type && type=='memberName' }"><!-- null이 아닐 때 -->
							<option value="memberNo">회원번호</option>
							<option value="email">이메일</option>
							<option value="shopName">상점명</option>
							<option value="memberName" selected="selected">이름</option>
						</c:if>
					</select>
					<input type="text" class="admin-member-search-input" name="keyword" id="keyword" value="${keyword }"> 
					<button type="submit" class="admin-member-search-button">검색</button>
				</form>
			</div>
			
			<div class="table-wrapper admin-member-table-div" style="margin:0 auto; height: 560px;">
				<table class="table table-stariped admin-member-table" style="text-align: center; ">
					<tr style="text-align:center; font-size: 16px; font-weight: bold;">
						<td style="padding: 11px;">번호</td>
						<td style="padding: 11px;">회원번호</td>
						<td style="padding: 11px;">이메일</td>
						<td style="padding: 11px;">상점명</td>
						<td style="padding: 11px;">이름</td>
						<td style="padding: 11px;">연락처</td>
						<td style="padding: 11px;">주소</td>
						<td style="padding: 11px;">가입일</td>
						<td style="padding: 11px;">탈퇴</td>
					</tr>
					<c:forEach items="${amlpd.list}" var="m">
					<tr class="admin-member-table-tr">
						<td style="line-height: 28px; padding: 11px;">${m.rnum }</td>
						<td style="line-height: 28px; padding: 11px;">${m.memberNo }</td>
						<td style="line-height: 28px; padding: 11px;">${m.email }</td>
						<td style="line-height: 28px; padding: 11px;">${m.shopName }</td>
						<td style="line-height: 28px; padding: 11px;">${m.memberName }</td>
						<td style="line-height: 28px; padding: 11px;">${m.phone }</td>
						<td style="line-height: 28px; padding: 11px;">${m.address }</td>
						<td style="line-height: 28px; padding: 11px;">${m.enrollDate }</td>
						<td style="line-height: 28px; padding: 11px;">
							<input type="button" class="admin-member-button" value="탈퇴" onclick="location.href='/adminMemberDelete?memberNo=${m.memberNo}'">
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
</body>
</html>