<%@page import="kr.co.tomato.noitceMTM.model.vo.NoticeMTM"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<NoticeMTM> list = (ArrayList<NoticeMTM>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/admin/adminReview.css"/>    
	<style>
	.table2{
	display: none;
	}
	.talbe3{
	}
	</style>
</head>
<body>
	<%@include file="/admin/adminHeader.jsp" %>
	<section>
		<div class="admin-review-section">
			<div class="admin-review-title" style="display:inline-block;">1:1 문의 게시판</div>
			<div class="admin-review-search" style="display:inline-block;; float:right;">
				<select class="admin-review-search-select">
					<option>제목</option>
				</select>
				<input type="text" class="admin-review-search-input"> 
				<input type="button" value="검색" class="admin-review-search-button">
			</div>
			
			<script>
			$(document).ready(function () {
				
				$(".bt1").click(function () {
					$(".table2").hide();
					
					var index = $(".bt1").index(this);
					
					$(".table2").eq(index).show();
				});
				
				/* 사진 보기 구현 */
				
				$(".bt3").click(function () {
					$(".table2").hide();
					$(".table1").hide();
					
					var index = $(".table2").index(this);
					
					$(".table2").eq(index).show();
				});
				
			});
			
			</script>
			 <!-- 문의목록  -->
			<div class="admin-review-div">
				<div class="table-wrapper admin-review-table-div" style="margin:0 auto;">
			
					<table class="table table-stariped admin-review-table" style="text-align: center; ">
						<tr>
							<td colspan="8" style="text-align:center; font-size: 18px; font-weight: bold;">1:1 문의 미답변 목록</td>
						</tr>
						<tr style="text-align:center; font-size: 16px; font-weight: bold;">
							<td>작성일</td>
							<td>분류</td>
							<td>작성자</td>
							<td>사진</td>
						</tr>
							<%for (NoticeMTM mtm : list){ %>
						<%if(mtm.getNoticeMTMAnswerState() ==0){ %>
						<tr class="admin-review-table-tr">
							<td> <%=mtm.getNoticeMTMDate() %> </td>
							<td><%=mtm.getNoticeMTMMainCategory() %> > <%=mtm.getNoticeMTMSubCategory() %> <button class="bt1"> 보기</button></td> 
							<td><%=mtm.getMemberMTMNo() %></td>
							<td><button type="button" class="bt2">보기</button></td>
						</tr>
						<%} %>
						<%} %>
					</table>
					
					<!-- 답변 완료 목록  -->
					<table class="table table-stariped admin-review-table" style="text-align: center; ">
						<tr>
							<td colspan="8" style="text-align:center; font-size: 18px; font-weight: bold;">1:1 문의 답변완료 목록</td>
						</tr>
						<tr style="text-align:center; font-size: 16px; font-weight: bold;">
							<td>작성일</td>
							<td>분류</td>
							<td>작성자</td>
							<td>사진</td>
						</tr>
						<%for (NoticeMTM mtm : list){ %>
						<%if(mtm.getNoticeMTMAnswerState() ==1) {%>
						<tr class="admin-review-table-tr">
							<td> <%=mtm.getNoticeMTMAnswerDate() %> </td>
							<td><%=mtm.getNoticeMTMMainCategory() %> > <%=mtm.getNoticeMTMSubCategory() %> <button class="bt1"> 보기</button></td> 
							<td><%=mtm.getMemberMTMNo() %></td>
							<td><button type="button" class="bt2">보기</button></td>
						</tr>
						<%} %>
						<%} %>
					</table>
				</div>
				
				<!-- 문의 내용  -->
				<%for(NoticeMTM mtm : list){ %>
				<div class="table-wrapper admin-review-table-div2 table2" style="margin:0 auto;">
					<table class="table table-stariped admin-review-table2" style="text-align: center; font-size: 15px;">
						<tr>
							<td colspan="4" style="text-align:center; font-size: 18px; font-weight: bold;">1:1 문의 내용</td>
						</tr>
						<tr style="text-align:left; font-size: 16px;">
							<td style="font-weight:bold">작성자</td>
							<td><span class="memberId"><%=mtm.getMemberMTMNo() %></span></td>
						</tr>
						<tr class="admin-review-table-tr">
							<td colspan="4"><textarea class="memberContent" cols="50" rows="10"><%=mtm.getNoticeMTMContent() %></textarea></td>
						</tr>
						<tr style="text-align:left; font-size: 16px;">	
							<td style="font-weight:bold;">작성일</td>
							<td colspan="3" class="memberDate"><%=mtm.getNoticeMTMDate() %></td>
						</tr>
					</table>
					
					<!--  문의 답변 -->
					<form action="noticeMTMAdminInsert" method="get">
					<table class="table table-stariped admin-review-table2" style="text-align: center; font-size: 15px;">
						<tr>
							<td colspan="4" style="text-align:center; font-size: 18px; font-weight: bold;">1:1 문의 답변</td>
						</tr>
						<tr class="admin-review-table-tr">
							<td colspan="4"><textarea class="memberContent" cols="50" rows="10" name="content"><%=mtm.getNoticeMTMAnswerContent() %></textarea></td>
							
							
						</tr>
						<tr>
						<%if(mtm.getNoticeMTMAnswerState()==0) {%>
							<input type="hidden" name="no">
							<td> <button type="submit">작성</button> </td>
							<td> <button type="reset">취소</button> </td>
							<%} %>
						</tr>
					</table>
					</form>
				</div>
				<%} %>
				
			</div>
		</div>
	</section>
</body>
</html>