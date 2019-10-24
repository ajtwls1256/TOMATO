<%@page import="kr.co.tomato.vo.PageData"%>
<%@ page import="kr.co.tomato.vo.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>물품 관리</title>
        <link rel="stylesheet" href="/css/product/list.css" type="text/css">
        <script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
        <script>
            $(function(){
                var sBtn = $(".e-nav > li");
                sBtn.find("a").click(function(){
                    sBtn.removeClass("e-active");
                    $(this).parent().addClass("e-active");
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
                                <a href="#">
                                    <img src="/WebContent/img/tomatoLogo.png" width="100%" height="100%">
                                </a>
                                <br>
                                <a href="#">
                                    <img src="/WebContent/img/instagram.png" width="100%" height="100%">
                                </a>
                                <span>상점이름 - E05</span>
                            </div>
                        </li>
                        <li>
                            <a href="#">
                                <span>홈</span>
                            </a>
                        </li>
                        <li>
                            <a href="enroll.jsp">
                                <span>물품 등록</span>
                            </a>
                        </li>
                        <li>
                            <a href="list.jsp" class="e-active">
                                <span>물품 관리</span>
                            </a>
                        </li>
                        <li>
                            <a href="order.jsp">
                                <span>구매/판매 내역</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span>탈퇴하러가기</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="e-main">
            <div class="e-div_bg">
                <div class="e-main_head">
                    <div class="e-main_head_top">
                        <h2>물품 목록</h2>
                        <ol class="e-main_head_title">
                            <li>
                                <a href="메인화면">Home</a>
                            </li>
                            /
                            <li>
                                <strong>물품 목록</strong>
                            </li>
                        </ol>
                        <select class="e-select_count">
                            <option value="10">10개씩</option>
                            <option value="20">20개씩</option>
                            <option value="30">30개씩</option>
                        </select>
                        <select class="e-select_status">
                            <option value="10">전체</option>
                            <option value="20">판매중</option>
                            <option value="30">판매완료</option>
                        </select>
                        <input type="text" class="e-search_name">
                        <button onclick="" class="e-search_name_btn">검색</button>
                    </div>
                </div>
                <div class="e-main_body">
                    <br>
                    <div class="e-main_body_btn">
                        <button class="e-enroll_btn">물품등록</button>
                    </div>
                    <br>
                    <div class="e-main_body_menu">
                        <table class="e-main_body_table">
                            <thead>
                                <tr class="e-main_body_list">
                                    <th>
                                       	 사진
                                    </th>
                                    <th>
                                       	 상태
                                    </th>
                                    <th>
                                      	 물품명
                                    </th>
                                    <th>
                                       	 가격
                                    </th>
                                    <th>
                                       	 등록일
                                    </th>
                                    <th>
                                       	 기능
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
	                            <c:forEach items="${pd.list }" var="i" varStatus="a">
	                                <tr class="e-main_body_list">
	                                	<td>사진</td>
	                                    <td>${i.itemState }</td>
	                                    <td>${i.itemName }</td>
	                                    <td>${i.itemPrice }</td>
	                                    <td>${i.itemEnrollDate }</td>
	                                    <td><button class="" onclick="">수정</button></td>
	                                    <td><button class="" onclick="">삭제</button></td>
	                                </tr>
	                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>