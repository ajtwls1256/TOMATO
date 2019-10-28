<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/aside/aside.css">
</head>
<body>
<script>
	$(function(){
		$(window).scroll(function() {
		        if ($(this).scrollTop() > 400) {
		            $('.cate-go').fadeIn();
		        } else {
		            $('.cate-go').fadeOut();
		        }
		    });	   
	    $(window).scroll(function() {
	        if ($(this).scrollTop() > 300) {
	            $('.page-top').fadeIn();
	        } else {
	            $('.page-top').fadeOut(); 
	        }
	    });
	});
</script>
	<aside>
		<div class="aside" style="float:left;">aa
			<div class="cate-go">	
				<div class="cate-go-div"><a href="#cate1"><img class="cate-go-img" src="/img/cate1.png"></a></div>
				<div class="cate-go-div"><a href="#cate2"><img class="cate-go-img" src="/img/cate2.png"></a></div>
				<div class="cate-go-div"><a href="#cate3"><img class="cate-go-img" src="/img/cate3.png"></a></div>
				<div class="cate-go-div"><a href="#cate4"><img class="cate-go-img" src="/img/cate4.png"></a></div>
				<div class="cate-go-div"><a href="#cate5"><img class="cate-go-img" src="/img/cate5.png"></a></div>
				<div class="cate-go-div"><a href="#cate6"><img class="cate-go-img" src="/img/cate6.png"></a></div>
				<div class="cate-go-div"><a href="#cate7"><img class="cate-go-img" src="/img/cate7.png"></a></div>		
			</div>		
		</div>
	</aside>	
</body>
</html>