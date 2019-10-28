<%@ page import="kr.co.tomato.vo.Item"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>구매/판매내역</title>
    <link rel="stylesheet" href="/css/product/order.css" type="text/css">
    <script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function() {
            var sBtn = $(".e-nav > li");
            sBtn.find("a").click(function() {
                sBtn.removeClass("e-active");
                $(this).parent().addClass("e-active");
            });
        });
        $(document).ready(function() {
            $('ul.e-tabs li').click(function() {
                var tab_id = $(this).attr('data-tab');
                $('ul.e-tabs li').removeClass('current');
                $('.e-tab-content').removeClass('current');
                $(this).addClass('current');
                $("#" + tab_id).addClass('current');
            });
        });
    </script>
        
</head>

<body>
    <div class="e-sidebar">
        <nav class="e-navbar">
            <div>
                <ul class="e-nav">
					<li class="e-nav-header">
						<div>
							<a href="/"> <img src="/img/tomatoLogo.png" width="100%"
								height="100%">
							</a> <br> <a href="#"> <img src="/img/instagram.png"
								width="100%" height="100%">
							</a> <span>상점이름 - E05</span>
						</div>
					</li>
					<li>
						<a href="/" id="e-menu_select"> <span>홈</span>
						</a>
					</li>
					<li>
					<a href="/views/enroll.jsp" id="e-menu_select">
							<span>물품 등록</span>
					</a></li>
					<li>
					<a href="/itemList" id="e-menu_select" class="e-active"> <span>물품
								관리</span>
					</a></li>
					<li><a href="/views/order.jsp" id="e-menu_select"> <span>구매/판매
								내역</span>
					</a></li>
					<li><a href="#" id="e-menu_select"> <span>탈퇴하러가기</span>
					</a></li>
				</ul>
            </div>
        </nav>
    </div>
    <div class="e-main">
        <div class="e-div_bg">
            <div class="e-main_head">
                <div class="e-main_head_top">
                    <h2>구매/판매내역</h2>
                    <ol class="e-main_head_title">
                        <li>
                            <a href="/">Home</a>
                        </li>
                        /
                        <li>
                            <strong>구매판매내역</strong>
                        </li>
                    </ol>
                    <select class="e-select_count">
                        <option value="10">10개씩</option>
                        <option value="20">20개씩</option>
                        <option value="30">30개씩</option>
                    </select>
                </div>
            </div>
            <div class="e-main_body">
                <br>
                <form>
	                <div class="e-container">
	                    <ul class="e-tabs">
	                        <li class="e-tab-link current" data-tab="e-tab-1">구매 내역</li>
	                        <li class="e-tab-link" data-tab="e-tab-2">판매 내역</li>
	                    </ul>
						
	                    <div id="e-tab-1" class="e-tab-content current">
	                        <div class="e-main_body_menu">
	                        <table class="e-main_body_table">
	                            <thead>
	                                <tr class="e-main_body_list">
	                                    <th>사진</th>
	                                    <th>물품명</th>
	                                    <th>가격</th>
	                                    <th>등록일</th>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            	<c:forEach items="${buyItem }" var="i" varStatus="status">
		                                <tr>
		                                	<td>
		                                		<c:choose>
													<c:when test="${empty i.itemThumFilepath }">
														<img src="/img/imageempty.png" style="width:100px; height:100px;">
													</c:when>
													<c:otherwise>
														<img src="/upload/product/${i.itemThumFilepath }" style="width:100px; height:100px;">
													</c:otherwise>
												</c:choose>
		                                	</td>
			                                <td>${i.itemName }</td>
			                                <td>${i.itemPrice }</td>
			                                <td>${i.itemEnrollDate }</td>
			                            </tr>
		                            </c:forEach>
	                            </tbody>
	                        </table>
	                    </div>
	                    </div>
	                    <div id="e-tab-2" class="e-tab-content">
	                        <div class="e-main_body_menu">
		                        <table class="e-main_body_table">
		                            <thead>
		                                <tr class="e-main_body_list">
		                                    <th>사진</th>
		                                    <th>물품명</th>
		                                    <th>가격</th>
		                                    <th>등록일</th>
		                                </tr>
		                            </thead>
		                            <tbody>
		                                <c:forEach items="${sellItem }" var="i" varStatus="status">
			                                <tr>
			                                	<td>
			                                		<c:choose>
														<c:when test="${empty i.itemThumFilepath }">
															<img src="/img/imageempty.png" style="width:100px; height:100px;">
														</c:when>
														<c:otherwise>
															<img src="/upload/product/${i.itemThumFilepath }" style="width:100px; height:100px;">
														</c:otherwise>
													</c:choose>
			                                	</td>
				                                <td>${i.itemName }</td>
				                                <td>${i.itemPrice }</td>
				                                <td>${i.itemEnrollDate }</td>
				                            </tr>
			                            </c:forEach>
		                            </tbody>
		                        </table>
		                    </div>
	                    </div>
	                </div>
                </form>
            </div>
        </div>
    </div>

</body></html>