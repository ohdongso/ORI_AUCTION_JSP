<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String title = (String)request.getParameter("artName");
	String artist = (String)request.getParameter("artistName");
	String id = (String)request.getParameter("sucBidId");
	String sucBidCode = (String)request.getParameter("sucBidCode");
	String sucBidCost = (String)request.getParameter("sucBidCost");
	int totalPrice = Integer.parseInt(sucBidCost);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
    <script>
    $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp75728843'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : 'ORI-AUCTION 낙찰 작품 결제',
            amount : <%=totalPrice%>,
            buyer_name : '<%=id%>'
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        
                        alert(msg);
                    } else {
                    	msg = '결제가 정상적으로 완료되지 않아 자동취소되었습니다.';
                    	alert(msg);
                    }
                });
                //성공시 이동할 페이지
                <%-- location.href='<%=request.getContextPath()%>/payment/paySuccess?msg='+msg; --%>
                <%-- location.href="<%=request.getContextPath()%>/front?key=sucBid&methodName=changeState&sucBidCode="+sucBidCode; --%>

                var code = <%=sucBidCode%>;
                location.href="${path}/front?key=sucBid&methodName=changeState&sucBidCode="+code;
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                <%-- location.href="<%=request.getContextPath()%>/payment/payFail"; --%>
                location.href="${path}/payment/payFail.jsp";
                //alert(msg);
            }
        });
        
    });
    </script>
 
</body>
</html>
