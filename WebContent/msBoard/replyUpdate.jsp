<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src ="${path}/js/jquery-3.6.0.min.js" ></script>
<script type="text/javascript">



	function checkValid() {
		var f = window.document.updateReplyForm;		
				
		if (f.boardReplyContent.value == "") {
			alert("내용을 입력하세요.");
			f.boardReplyContent.focus();
			return false;
		}
		
		return true;
	}
	
</script>

</head>
<body>
	
	<form name="updateReplyForm" method="post"
		action="${path}/front"
		onSubmit='return checkValid()'>
		<input type='hidden' name="key" value="board">
		<input type='hidden' name="methodName"value="updateReply">
		
		<input type='text' name="boardReplyCode" value="${param.boardReplyCode}">
		<input type='text' name="boardCode"value="${param.boardCode}">
		<table align="center" width="1000px">
			<tr>
				<td colspan="3" align="center">BoardReply Update</td>
			</tr>					
			<tr>
				<td >내용</td>
				<td colspan="2"><input type=text name="boardReplyContent" value=""></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type=submit value=수정하기>
					<input type=reset value=다시쓰기></td>
			</tr>
		</table>

	</form>
</body>
</html>