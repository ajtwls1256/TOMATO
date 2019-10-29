<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/css/sellPage/sellPage.css">
<body>
	
	<!-- 구매 팝업창 -->
            <div class="c-popup_div" >
            	<div><span></span> 상품번호: ${item.getItemNo() }  </div>
            	<div><span></span> 상품명: ${item.getItemName() }  </div>
            	<div><span></span> 회원명: ${item.getMemberNo()}  </div>
            	<div><span></span> 결제금액: <fmt:formatNumber type="number" maxFractionDigits="3" value="${item.itemPrice }" />원  </div>
            	<div><span></span> 거래지역: ${item.getItemDealRegion() }  </div> 
            	
            	<div><span></span> 결제 수수료: <c:if test="${item.getItemDeliveryNY()==1}">O</c:if>
            	<c:if test="${item.getItemDeliveryNY()!=1}">X</c:if>

            	  </div>
            	
            
            
            	<button class="c-pay_start"><h3>결제하기</h3></button>
            
            </div>
            
            <script>
            
            $(".c-pay_start").click(function(){
            	  //상품명 _현재시간
            	var d = new Date();
				var date = d.getFullYear()+''+(d.getMonth()+1)+''+d.getDate()+''+d.getHours()+''+d.getMinutes()+''+d.getSeconds();	
            	 
				
				var cApiMerchant ='${item.getItemName()}';
            	 var cApiName='${item.getItemName()}결제';
            	 var cApiAmount='${item.getItemPrice()}';
            	 var cApiEmail='${sessionScope.member.getEmail()}';
            	 var cApiBuyName='${sessionScope.member.getMemberName()}';
            	 var cApiTel='${sessionScope.member.getPhone()}';
            	 var cApiAddr='${sessionScope.member.getAddress()}';
            	 
            	 
    			
    			IMP.init('imp17979985');
    			IMP.request_pay({
    			    pg : 'html5_inicis',
    			    merchant_uid :cApiMerchant+'_'+date,
    			    name :cApiName,
    			    amount : cApiAmount,
    			    buyer_email : cApiEmail,
    			    buyer_name : cApiBuyName,
    			    buyer_tel : cApiTel,
    			    buyer_addr : cApiAddr,
    			    
    			}, function(rsp) {
    			    if ( rsp.success ) {
    			        var msg = '결제가 완료되었습니다.';
  						
    			      	 var itemNo = ${item.getItemNo()};
  						var memberNo =${item.getMemberNo()};
  						/*  var buyerNo = ${sessionScope.member.getMemberNo()};  */
  							
    			       	var impUid			=rsp.imp_uid;
    			       	var merchantUid		=rsp.merchant_uid;
    			       	var payApplyNum		=rsp.pg_tid;
    			       	var paidAmount		=rsp.paid_amount;
    			       	var status			='판매중';
    			       	var	name			=rsp.name;		       	
    			       	var paidAtnumber	=rsp.paid_at
    			       			
    			       	$.ajax({
    			       		url:"/sellPageTo",
    			       		type:"get",
    			       		data:{itemNo:itemNo,memberNo:memberNo,impUid:impUid,merchantUid:merchantUid,payApplyNum:payApplyNum,status:status,
    			       			name:name,/* buyerNo:buyerNo */ paidAtnumber: paidAtnumber,paidAmount:paidAmount},
	    			       	success : function(itemNo){
	    					
	    					},
	    					error : function(){
	    						console.log("실패");
	    					}
    			       	
    			       	});
    			       		
    			       	
    			       					
    			    } else {
    			        var msg = '결제에 실패하였습니다.';
    			        msg += '에러내용 : ' + rsp.error_msg;
    			    }

    			    alert(msg);
    			}); 
            	
            }); 
          
    /*         
     	상품번호 item
            회원번호  member
            관리자 고유ID  impUid
            결제금액 paid_amount	number
            결제 상태 status	string
            결제일  sysdate
            카드 승인번호 apply_num
            결제 수수료   3000
            상점 거래ID merchant_uid
            환불 여부 default */
            
            
            
            </script> 
</body>
</html>