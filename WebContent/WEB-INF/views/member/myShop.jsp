<%@page import="kr.co.tomato.myshop.model.vo.Review"%>
<%@page import="kr.co.tomato.myshop.model.vo.DealItem"%>
<%@page import="kr.co.tomato.sellPage.model.vo.Item"%>
<%@page import="kr.co.tomato.myshop.model.vo.MyshopData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <% 
    MyshopData data = (MyshopData)request.getAttribute("myshopData");
    
    //상점 별점 구하기 
    double score = 0;
    for(Review r : data.getrList()) {
			   score+=r.getReviewScore();
    }
    Math.round(score/= data.getrList().size());//내상점별점 소숫점 반올림
    
    //내상품 판매 횟수
   	int sellCount=0;
    for(Item i : data.getiList()){
    	if(i.getItemDealState().equals("판매완료")){
    		sellCount++;	    		
    	}
    }
    
    Member m = (Member)session.getAttribute("member");
    %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

		.c-my_page-wrap {
		margin-top:10px;
		width: 100%;
		display: flex;
		justify-content: center;
		}
		.c-my_page{
			width:1000px;
		}
		
		.c-my_page button{
			cursor: pointer;
        	border:none;
             border-shadow:none;
             outline:none;
		}
		
		.c-my_page_top{
			width:100%;
			height:310px;
		}
		
		.c-my_page_view{
		background-color:rgb(181, 181, 181);;
		display:flex;
		justify-content: center;
		align-items:center;
		flex-direction: column;
		width:29.6%;
		height:100%;
		background-image:url('/img/sj/myShopPageImg3.png');
		}

		.c-my_page_view_nickname{
		margin:2px 0 2px 0 ;
		color:white;
		}
		.c-my_page_view_star{
		margin:0 0 2px 0 ;
		color:white;
		}
		
		.c-my_page_view_img{
		width:130px;
		height:130px;
		background-color:white;
		display:flex;
		justify-content: center;
		align-items:center;
		border-radius: 50%;
		}

		.c-my_page_view_img img{
			width:100px;
		 	height:100px;
		}
		.c-my_page_view_btn>button{
			width: 106px;
			height: 40px;
			color:aliceblue;
			background:0;
			border : 1px solid white;
		}
		/* 상단부 왼쪽 css */
		.c-my_page_view{
		width:31%;
			float:left;
		}
		.c-my_page_info{
		float:left;
			padding: 0 30px 0 30px;
			width:69%;
			height:310px;
			border: 1px solid rgb(238, 238, 238);
		
		}
		.c-my_page_info_top{
			position : relative;
			display:flex;
			flex-direction: roe;
		}
		.c-my_page_info_name{
			font-size: 18px;
			font-weight: 600;
			height: 75px;
			margin-top:30px;
		}
		.c-my_page_name_btn{
			margin:30px 0 0 10px;
			width:85px;
			border: 1px solid rgb(238, 238, 238);
		}
		.c-my_page_name_btn button, .c-my_page_info_btn button{
			background-color:white;
		}
	
		.c-my_page_viewers{
				height:20px;
			display:inline-block;
			line-height: 20px;	
		}
		.c-my_page_viewers img, .c-my_page_selling img{
			padding:0px 5px 1px 0;
			width:18px;
			height:18px;
		}
		.c-my_page_variable{
			position : absolute;
			top:60px;
			margin-top : 30px;
			display:flex;
			flex-direction: roe;
		}
		.c-my_page_selling{
			margin-left:30px;
		}
		
		.c-my_page_info_bottom{
			height:200px;
			width:100%;
			padding-top:25px;
		}
		.c-my_page_info_btn{
			position : absolute;
			top:465px;
			width:85px;
			border: 1px solid rgb(238, 238, 238);
		}
		.c-my_page_bottom{
			margin:25px 0 ;
		}
			/* 탭 메뉴 동작 */ 
			ul.c-tabs{
			  margin: 0px;
			  padding: 0px;
			  list-style: none;
			 
			  
			}
			ul.c-tabs li{
			 width:17%;
			  background: none;
			  color: #222;
			  display: inline-block;
			  padding: 10px 15px;
			  cursor: pointer;
			}
			 
			ul.c-tabs li.current{
			  background: #ededed;
			  color: #222;
			}
			 
			.tab-content{
			width:100%;
			height:100%;
			  display: none;
			  
			  padding: 15px;
			}
			 
			.tab-content.current{
			  display: inherit;
			}
			
			/* 첫번쨰 탭 */ 
			
			#c-tab-1{
				width:100%;
			}
		
			#c-tab-1>div{
			
			width:100%;
			height:100%;
			
			}
			
			.c-product_top, .c-favorite_top, .c-selling_top{
			padding: 40px 0px 20px;
			width:100%;
			height:50px;
			}
			.c-product_top>div{
				float:left;
				border-bottom: 1px solid rgb(238, 238, 238);
			}
			
			.c-product_name{
			
			width:49.5%;
			height:50px;
			
			}
			.c-product_name>span{
			font-size:25px;
			}
			
			.c-product_select{
			width:49.5%;
			height:50px;
			
			}
			.c-product_select>select{
				float:right;
				margin-right:100px;
			}
			
		
			.c-product_content{
				margin:30px 0;
				color: rgb(136, 136, 136);
				
				padding: 30px 0px 100px;
			}
		
		/* 두번쨰 탭 */ 
		
        .c-selling button{
            cursor: pointer;
        	outline:none;
           border-bottom: 1px solid rgb(238, 238, 238);
            background:none; 
        	border-shadow:none;
        }
            
        .c-selling{
            width:1000px;
            
        }
        .c-selling_name{
            width:100%;
            height:30px;
            padding-top: 2px;
            
        }
        .c-selling_name>span{
            font-size: 25px;
        }
        .c-selling_table{
            width:100%;
           
            float: left;
        }
        .c-selling_table div{
            float: left;
        }
        .c-selling_table_top{
            width:100%;
            height:30px;
        }
        .c-selling_num{
            width:5%;
            height:100%;
        }
        .c-selling_product{
             width:71%;
            height:100%;
            text-align: center;
        }
        .c-selling_store{
             width:15%;
            height:100%;
            text-align: center;
        }
        .c-selling_order{
            width:8%;
            height:100%;
            text-align: center;
            
        }
        
        .c-selling_table_bottom{
            width:100%;
            height: 280px;
			border : 1px solid rgb(238, 238, 238);;
        }
        .c-selling_number{
            width:5%;
            height:100%;
            text-align: center;
             border-right: 1px solid rgb(238, 238, 238);
        }
        .c-selling_number>span{
            display: inline-block;
            padding-top:120px;
        }
        .c-selling_product_info{
           width:95%;
             height:100%;
            
        }
        .c-selling_product_img{
            width:20%;
            height:200px;
            margin-top: 40px;
            margin-left: 10px;
            margin-right: 10px;
            margin-bottom: 40px;
            
        }
        .c-selling_product_img img{
        	background-clip:content-box;
			background-repeat: no-repeat;
			width: 100%;
			height: 100%;
			margin: 0 auto;
        
        }
        
        .c-selling_product_introduce{
            width:53%;
            height:100%;
        	padding:15px 0 5px 20px;
        	border-right : 1px solid rgb(238, 238, 238);
        }
        .c-selling_product_introduce>div{
            float:none;
            margin-top: 30px;
            width: 97%;
            height: 10%;
            padding-left: 15px;
        }
        .c-selling_product_variable>div{
            width:100px;
            height: 100%;
        }
        .c-selling_product_date>span{
            color: #878787;
        }
        .c-selling_product_etc>span{
            color: #878787;
        }
        
        .c-selling_product_store_info{
            width:15.5%;
            height:100%;
            text-align: center;
           border-right : 1px solid rgb(238, 238, 238);
             
        }
        .c-selling_product_store_info>button{
            color:#878787;
        }
        .c-selling_product_order_list{
            width:8.5%;
             height:100%;
            text-align: center;
            
        }
        
        .c-selling_product_order_list>button{
            width:80px;
            height: 50px;
            margin-top:60px;
            margin-left: 3px;
        }
        
        /* 세번쨰 탭 */ 

       
        .c-favorite_name>span{
            font-size: 25px;
        }
        
        

     
        
		/* 네번쨰 탭 */ 

			.c-inquiry_name>span{
			font-size: 25px;
			}
			
			
			
			/******/
			.tab-content, .current{
			padding : 0;
			}
		/*+tab1*/
			.c-product_content{
				margin:30px 0;
				color: rgb(136, 136, 136);
				
				padding: 30px 0px 100px;
			}
		/*+tab2*/
		.c-selling_bottom{
		
		
		}
		
		/*+tab3*/
		.c-favorite_box{
			height: 140px;
		width: 100%;
		border : 1px solid rgb(238, 238, 238);;
		}
		.c-favorite_img{
			width: 139px;
   			 height: 100%;
   			 display:flex;
   			 align-items:center;
   			 justify-content:ceter;
   			 flex-shrink: 0;
   			 float:left;
		}
		.c-favorite_img img{
			width:130px;
			 height:130px;
			 overflow:auto;
		}
		.c-favorite_info{
			width:80%;
			padding: 0px 64px 0px 20px;
		
		}
		
		.c-favorite_box{
			position: relative;
		}
		.c-favorite_addr{
			float:left;
			height: 40px;
   			display: flex;
  			width: 100%;
  			align-items: center;
  		 	padding-left: 20px;
    		font-size: 12px;
    		color: rgb(102, 102, 102);
   			box-sizing: border-box;
   			border-top: 1px solid rgb(238, 238, 238);
			}
		/*+tab4*/
		.c-inquiry_content, .c-favorite_bottom, .c-selling_bottom{
				margin:30px 0;
				color: rgb(136, 136, 136);
				padding: 30px 0px 100px;
			}
		.c-inquiry_content1{
		margin:0;
		padding: 30px 0px 50px;
		}
			.c-inquiry_name, .c-favorite_name, .c-selling_name{
			width:100%;
			height:50px;
			border-bottom:1px solid rgb(238, 238, 238);;
			}
		.c-inquiry_content_body{
			width:100%;
			height:100%;
			border-bottom:1px solid rgb(238, 238, 238);
			padding-left:30px;
		}
		.c-inquiry_content_writer{
			width:88%;
			height:20px;
			position: relative;
		}

		.c-inquiry_content_score{

			width:100%;
		}
		.c-inquiry_content_content{
			width:100%;
			height:50px;
			margin-top: 10px;
		}
		.c-inquiry_content2{
			margin:30px 0;
				color: rgb(136, 136, 136);
		}
		.c-inquiry_content_date{
			text-align:right;
		
		}
		/*********************************/
		.cate1-md{
	background-repeat: no-repeat;
	background-size: 192px 192px;	
	width:192px;
	height:250px;

	border:none;
	box-shadow: 0px 0px 1px 0px #D5D5D5;
	
}
.cate1{
	width:192px;
	height:300px;
		float:left;
		margin-right:8px;
}

.cate-md-img{
	background-clip:content-box;
	background-repeat: no-repeat;
	background-size: 190px 190px;
	margin-left:0px;
	width: 100%;
	height: 190px;
	margin: 0 auto;
}
.cate-md-img img{
width: 100%;
height: 100%;
}
.cate-md-name{  
	width:192px;
	text-aligh:left;
	margin:5px 0px 6px 6px;
	padding: 0px;
	font-size:14px;
}
.cate-md-price{
	width:192px;
	text-aligh:left;
	margin:0px 0px 0px 6px;
	padding: 0px;
	font-size:15px;
	font-weight:bold;
}
.cate-md-time{
	clear:both;
	float:right;
	margin:0px 6px 0px 0px;
	font-size:12px;
	line-height:20px;
}
		.c-favorite_bottom{
		height:350px;
		}
		#updateShopName{
		width:150px;
		}
		#btn-update-shopName-complete{
		}
		#updateShopName{
			height:25px;
			padding-left:5px;
			font-size:0.8em;
		}
		#updateShopContent{
			width:630px;
			height:120px;	
			padding-left:10px;	
		}
</style>
</head>
<body>
	
	 <%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <br>
	 
	<div class="c-my_page-wrap">
		<div class="c-my_page">
			<div class="c-my_page_top" >
				<div class="c-my_page_view">
					
						<div class="c-my_page_view_img"><img src="/upload/member/default_img.png"></div>
						<div class="c-my_page_view_nickname"><%=data.getMem().getShopName() %></div>
						<div class="c-my_page_view_star">
						<%for(int i=(int)score;i<5;i++){ %>
						☆
						<%} %>
						<%for(int i=0;i<(int)score;i++){ %>
						★
						<%} %>
						<%if (Double.isNaN(score)){ %>
						 0
						<%} else{%>
						<%=score %> 점
						<%} %>
						</div>
						<div class="c-my_page_view_btn">
							<button type="button" onclick="location.href='/itemList?memberNo=<%=data.getMem().getMemberNo() %>'">내 상점 관리</button>
						</div>
					
				</div>
				<div class="c-my_page_info">
					<div class="c-my_page_info_top">
						<div class="c-my_page_info_name"><div>상점명 : <%=data.getMem().getShopName() %></div>
						<input id="updateShopName">
						</div>
						<div class="c-my_page_info_view">
							<div class="c-my_page_name_btn">
								<button id="btn-update-shopName"><span>상점명 수정</span></button>
								<button id="btn-update-shopName-complete"><span>&nbsp&nbsp수정완료</span></button>
							</div>
						</div>
						<div class="c-my_page_variable"> 
							 	<div class="c-my_page_viewers"><img src="/img/sj/myShopPageImg1.png">상점방문수 <%=data.getMem().getShopReadcount() %></div> 
								<div class="c-my_page_selling"><img src="/img/sj/myShopPageImg2.png">상품판매수 <%=sellCount %></div> 
							 
						</div>
					</div>
					<div class="c-my_page_info_bottom">
						<div class = "c-my_page_info_introduce"><div style="padding:10px 0 0 10px;">
						<%if(data.getMem().getShopContent()!=null){ %>
						<%=data.getMem().getShopContent() %>
						<%}else{%>
						내 상점 소개란이 비어있습니다.
						<%} %>
						</div>
						<input id="updateShopContent">
						</div>
						<div class = "c-my_page_info_btn" >
							<button id="btn-update-shopContent"><span>소개글 수정</span></button>
							<button id="btn-update-shopContent-complete"><span>&nbsp&nbsp수정완료</span></button>
						</div>
					</div>
				</div>
			</div>
			
			
			
			<!-- tab -->
			<div class="c-my_page_bottom">
				
					<div class="c-container">
 						
					  <ul class="c-tabs">
					    <li class="tab-link current" data-tab="c-tab-1">상품</li>
					    <li class="tab-link" data-tab="c-tab-2">구매중</li>
					    <li class="tab-link" data-tab="c-tab-3">찜</li>
					    <li class="tab-link" data-tab="c-tab-4">상점후기</li>					    
					  </ul>
					 
					  <div id="c-tab-1" class="tab-content current">
						  <div class="c-mypage_product">
							<div class="c-product_top">
								<div class="c-product_name"><span>상품</span></div>
								<div class="c-product_select"></div>
							</div>
							<%if(data.getiList()==null){ %>
							<div class="c-product_bottom">
								<div class="c-product_content">등록된 상품이 없습니다</div>
							</div>
							<%} else{%>
							<%int a=0;%>
							 <div class="c-favorite_bottom"> 
							<!--<div class="c-product_bottom">--> 
							<%for(Item i : data.getiList()){ %>
							<%if((i.getItemDealState().equals("판매중"))){ %>
							
                               		<div class="cate1">
                              	 		 <div class="cate1-md cate1-md5" style="margin-left:0px;">
											<div class="cate-md-div">
											<%if(i.getItemThumFilename()==null){ %>
											<a href="/sellPage?itemNo=<%=i.getItemNo() %>"><img class="cate-md-img" src="/img/imgempty.png" alt="사진없음"></a>
											<%}else {%>
											<a href="/sellPage?itemNo=<%=i.getItemNo() %> "><img class="cate-md-img" src="/upload/product/<%=i.getItemThumFilename() %>" alt="사진5"></a>
											<%} %>
											</div>							  				
											<p class="cate-md-name cate1-md5-name"><%=i.getItemName() %></p>
											<span class="cate-md-price cate1-md5-price"><%=i.getItemPrice() %></span>
											<span class="cate-md-time cate1-md5-time"><%=i.getItemEnrollDate() %></span>
								  		</div>
									</div>  
                                
                                <%a++;%>
							<%}}%>
							<%  if(a==0){%>
								<div class="c-product_content">등록된 상품이 없습니다</div>
							<%}%>
							</div>
							<%}%>
							
						</div>	
					  </div>
					  
					  <div id="c-tab-2" class="tab-content">
                            <div class="c-selling">
                            <div class="c-selling_top">
                             <div class="c-selling_name"><span>구매중</span></div>
                             </div>
                              <%if(data.getdList()==null){%>
                                <div class="c-product_bottom">
								<div class="c-product_content">등록된 상품이 없습니다</div>
							</div>
                                <%} else{%>
                             <div class="c-selling_bottom">
                             <div class="c-selling_table" style="padding-bottom:50px">
                                <div class="c-selling_table_top">
                                    <div class="c-selling_num"><span>&nbsp&nbsp&nbsp번호</span></div>
                                    <div class="c-selling_product"><span>상품정보</span></div>
                                    <div class="c-selling_store"><span>판매 상점</span></div>
                                    <div class="c-selling_order"><span>주문관리</span></div>
                                </div>
                                <%int i=1; %>
								<% for(DealItem dItem : data.getdList()){ %>
								<form>
								<input type="hidden" name="dealItemNo" value="<%=dItem.getItemNo() %>">
								<input type="hidden" name="memberNo" value="<%=data.getMem().getMemberNo() %>">
								<input type="hidden" name="memberEmail" value="<%=data.getMem().getEmail() %>">
								<input type="hidden" name="visitMemberNo" value="<%=dItem.getMemberNo() %>">
								<input type="hidden" name="visitShopReadcount" value="<%=dItem.getShopReadcount() %>">
								<input type="hidden" name="visitEmail" value="<%=dItem.getEmail() %>">
                                	<div class="c-selling_table_bottom">
                                  	  <div class="c-selling_number"><span> <%=i %> </span></div>
                                   	  <div class="c-selling_product_info">
                                        	<div class="c-selling_product_img" style="padding-left:10px;">
                                        	<%if(dItem.getItemThumFilename()==null){ %>
											<img class="cate-md-img" src="/img/imgempty.png" alt="사진없음">
											<%}else {%>
                                      		 <img src="/upload/product/<%=dItem.getItemThumFilename() %>">
                                      		 <%} %>
                                      		 </div>
                                        	<div class="c-selling_product_introduce">
                                           	 <div class="c-selling_product_name"><span><%=dItem.getItemName() %></span></div>
                                          	  <div class="c-selling_product_variable">
                                                <div class="c-selling_product_price"><span><%=dItem.getPaymentPay() %>원&nbsp&nbsp&nbsp&nbsp&nbsp |</span></div>
                                                <div class="c-selling_product_date"><span><%=dItem.getPaymentDate() %></span></div>
                                         	   </div>
                                          	  <div class="c-selling_product_delivery"><a href="#">결제완료</a></div>
                                         	   <div class="c-selling_product_etc"><span>상품은 잘 받아보셨나요? 확인하시고 구매 확정해주세요!</span></div>
                                      		 </div>
                                       		 <div class="c-selling_product_store_info" style="display:flex; justify-content: center; align-items:center;flex-direction: column;">
                                        	    <p><%=dItem.getShopName() %></p>
                                         	   <button type="submit" onclick="visitShop(this)">상점 방문</button>
                                      		  </div>
                                        <div class="c-selling_product_order_list">
                                            <button type="submit" onclick="buyComplete(this)">구매 확정</button>
                                            <button type="submit" onclick="buyRuturn(this)">반품 요청</button>
                                        </div>
                                    	</div>
                               		 </div>
                                </form>
                                <%i++; }} %>
                             </div>  
                           </div> 
                        </div>
					  </div>
					  
					  <div id="c-tab-3" class="tab-content">
                            <div class="c-favorite">
                                <div class="c-favorite_top">
                                    <div class="c-favorite_name"><span>찜</span></div>
                                </div>
                                <%if(data.getfList().size()==0){%>
                                <div class="c-product_bottom">
								<div class="c-product_content">등록된 상품이 없습니다</div>
							</div>
                                <%} else{%>
                               <div class="c-favorite_bottom">
                                <%for(Item fItem : data.getfList()){ %>
                                
                               		<div class="cate1">
                                		 <div class="cate1-md-delete"><button type="button" onclick="deleteFav(this);">삭제</button>
                                		 <input id="input-delItem_itemNo" type="hidden" value="<%=fItem.getItemNo() %>">
                                		 <input id="input-delItem_memberNo" type="hidden" value="<%=data.getMem().getMemberNo()%>">
                                		 </div>
                              	 		 <div class="cate1-md cate1-md5" style="margin-left:0px;">
											<div class="cate-md-div">
											 <%if(fItem.getItemThumFilename()==null){ %>
											<a href="/sellPage?itemNo=<%=fItem.getItemNo() %>"><img class="cate-md-img" src="/img/imgempty.png" alt="사진없음"></a>
											<%}else {%>
                                        <a href="/sellPage?itemNo=<%=fItem.getItemNo() %>"><img class="cate-md-img" src="/upload/product/<%=fItem.getItemThumFilename() %>" alt="사진5"></a>
                                        <%} %>
											</div>							  				
											<p class="cate-md-name cate1-md5-name"><%=fItem.getItemName() %></p>
											<span class="cate-md-price cate1-md5-price"><%=fItem.getItemPrice() %>원</span>
											<span class="cate-md-time cate1-md5-time"><%=fItem.getItemEnrollDate() %></span>
								  		</div>
									</div>  
                                
                                <%} %>
                                
                                </div>
                                <% }%>
                            </div>
					  </div>
					  
					  <div id="c-tab-4" class="tab-content">
					  	<div class="c-store">
					  	<div class="c-product_top" >
					  		<div class="c-inquiry_name"><span>상점 후기</span></div>
					  	</div>	
					  	<div class="c-product_bottom" >
					  		<%if(data.getrList().size()==0){ %>
					  		<div class="c-inquiry_content">
					  			<div> 상점 후기가 없습니다</div>
					  		</div> 
					  		<%}else{ %>
					  		<div class="c-inquiry_content1">
					  		<%for(Review r : data.getrList()) {%>
							<div class="c-inquiry_content2">
					  			<div class="c-inquiry_content_body">
					  			<div class="c-inquiry_content_writer"><%=r.getReviewWriter() %><div class="c-inquiry_content_date">작성일 &nbsp<%=r.getReviewDate() %></div></div>
					  			<div class="c-inquiry_content_score">
					  			<%for(int i=r.getReviewScore();i<5;i++){%>
					  			☆
					  			<%} %>
					  			<%for(int i=0;i<r.getReviewScore();i++){%>
					  			★
					  			<%} %>
					  			</div>
					  			<div class="c-inquiry_content_content"><%=r.getReviewContent() %></div>
					  			</div>
					  		</div>
					  		<%} %>
					  		</div>
					  	<%} %>
					  		</div>
					  	</div>	
					  	</div>
					 </div>
					 
				</div>			
			</div>
			<!-- tab 끝 -->
		</div>
	</div>
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
	
	<script>
	
	
	$(document).ready(function(){
		$("#updateShopName").hide();
		$("#btn-update-shopName-complete").hide();
		$("#updateShopContent").hide();
		$("#btn-update-shopContent-complete").hide();
		
		/* 탭 메뉴 돌아가는 로직 시작*/
		$('ul.c-tabs li').click(function(){
			var tab_id = $(this).attr('data-tab');

			$('ul.c-tabs li').removeClass('current');
			$('.tab-content').removeClass('current');

			$(this).addClass('current');
			$("#"+tab_id).addClass('current');
			
		})
			
			
		<%if(m.getMemberNo()!=data.getMem().getMemberNo()){%>
			$('.c-tabs').children().eq(1).hide();
			$('.c-tabs').children().eq(2).hide();
			$(".c-my_page_name_btn").hide();
			$(".c-my_page_info_btn").hide();
			$(".c-my_page_view_btn").hide();
		<%}%>	
			
		/*상점 이름 수정*/
		$("#btn-update-shopName").click(function(){
			$(".c-my_page_info_name div").toggle(); // show -> hide
			$("#updateShopName").toggle(); // hide -> show
			$("#btn-update-shopName").toggle(); // show -> hide
			$("#btn-update-shopName-complete").toggle(); // hide -> show
		})
		
		$("#btn-update-shopName-complete").click(function(){
			var shopName = "<%=data.getMem().getShopName() %>";
			var updateShopName = $("#updateShopName").val();
			$.ajax({
				url:"/ajaxUpdateShopName",
				type:"get",
				data:{shopName:shopName,updateShopName:updateShopName},
				success :function(data){
					if(data!=0){
						console.log("상점이름 수정 성공");
						$(".c-my_page_info_name div").toggle();
						$("#updateShopName").toggle(); 
						$("#btn-update-shopName").toggle(); 
						$("#btn-update-shopName-complete").toggle();
						$(".c-my_page_info_name div").html("상점명 : "+updateShopName);
						$(".c-my_page_view_nickname").html(updateShopName);
					}else{
						console.log("상점이름 수정 실패!");												
					}
				}, error:function(){
					console.log("상점이름 수정  error");
				}
			})	
		});
		
		/*상점 내용 수정*/
		$("#btn-update-shopContent").click(function(){
			$(".c-my_page_info_introduce div").toggle(); // show -> hide
			$("#updateShopContent").toggle(); // hide -> show
			$("#btn-update-shopContent").toggle(); // show -> hide
			$("#btn-update-shopContent-complete").toggle(); // hide -> show
		})
		
		$("#btn-update-shopContent-complete").click(function(){
			var shopName = "<%=data.getMem().getShopName() %>";
			var shopContent = $("#updateShopContent").val();
			$.ajax({
				url:"/ajaxUpdateShopContent",
				type:"get",
				data:{shopName:shopName,shopContent:shopContent},
				success :function(data){
					if(data!=0){
						console.log("상점내용 수정 성공");
						$(".c-my_page_info_introduce div").toggle();
						$("#updateShopContent").toggle(); 
						$("#btn-update-shopContent").toggle(); 
						$("#btn-update-shopContent-complete").toggle();
						$(".c-my_page_info_introduce div").html(shopContent);
					}else{
						console.log("상점내용 수정 실패!");												
					}
				}, error:function(){
					console.log("상점내용 수정  error");
				}
			
			})
		})
		
	})	
	/*찜 목록 삭제*/
		function deleteFav(delBtn){
			var itemNo = $(delBtn).next().val();
			var shopNo = $(delBtn).next().next().val();
			console.log(itemNo+"/"+shopNo);
			$.ajax({
				url:"/ajaxDeleteFavorite",
				type:"get",
				data:{itemNo:itemNo, shopNo:shopNo},
				success :function(data){
					if(data!=0){
						alert("찜 목록 삭제 성공! 새로고침 해주세요");
					}else{
						console.log("찜 목록 삭제 실패!");												
					}
				}, error:function(){
					console.log("찜 목록 삭제 error");
				}
			})
		}
	
	/*상품 구매 확정*/
	function buyComplete(buyBtn){
		console.log("구매완료");
		$(buyBtn).parent().parent().parent().parent().attr("action","/itemBuyComplete");
	}
	function buyRuturn(returnBtn){
		console.log("반품요청");
		$(returnBtn).parent().parent().parent().parent().attr("action","/itemBuyReturn");
	}
	
	function visitShop(shopData) {
		console.log("상점방문");
		$(shopData).parent().parent().parent().parent().attr("action","/visiteShop");
	}
	
	
	</script>


</body>
</html>