<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../style/js/jquery-1.7.2.min.js" type="text/javascript"></script>

<script type="text/javascript">
	function valid() {
		var tradeAmount = $("#tradeAmount").val();
		if (isNaN(tradeAmount)) {
			alert("请输入正确的金额");
		}
	}
</script>

</head>
<body>
 <form action="/yintai_demo/rest/service/add" method="post">
     交易状态:
     <input type="radio" name="tradeStatus" value="true" checked="checked" />交易成功
	 <input type="radio" name="tradeStatus" value="false" />交易失败 
	 <br/>  <br/> 
     交易类型: <select name="tradeType">
			<option value="1" selected="selected">支付</option>
			<option value="2" >退款</option>
		</select> <br/>  <br/> 
	交易金额:<input type="text" name="tradeAmount" id="tradeAmount" onchange="valid()"/><br/> <br/> 
	  交易币种:
     <input type="radio" name="tradeCurrency" value="1" checked="checked" />人民币
	 <input type="radio" name="tradeCurrency" value="2" />美元
	 <br/>  <br/> 
	 
	 用户编号：<input type="text"  name="userId"/><br/>
	 用户姓名：<input type="text"  name="userName"/><br/>
	 
      <input type= "submit"/>
    </form>
</body>
</html>