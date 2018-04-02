<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap start -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.js" /> "></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" /> "></script>
<!-- bootstrap end -->
<script type="text/javascript">

$(document).ready(function(){
	
	
	$('#specific_set').on('change', function(){
		let x = document.getElementById("specific_set").selectedIndex;
		let y = document.getElementById("specific_set").options;
		if(y[x].index != 0){
			let id = $('#specific_set').val();
			let content = y[x].textContent;
			alert(content + '목록을 가져옵니다.');
			
			$.getJSON('../projTest/detail/'+id, function(data){
				let ids = data['id'];
				alert(data['id']);
				alert(ids[1]);
				let labels = data['label'];
				
				var lists = '<option>원하는 ' + content + '를 선택해 주십시오.</option>';
				$.each(data, function(key, val){
					for(let i=0; i < val.length; i++){
						lists += '<option value=' + ids[i] +'>' + labels[i] + '</option>';
					}
					
				})
				$('#detail_list').html(lists);		
			})
		}
	})
	
})
</script>
</head>
<body>
<h1>TESTTEST</h1>

<div id="specific">
	<h2>원하는 상세 분류 내용을 선택해 주십시오.</h2>
	<select id="specific_set">
		<option>test용</option>
		<option value="LOCATION">Country</option>
	</select>
</div>
<div id="grouping">
	<h2>원하는 상세 목록들을 선택해 주십시오.</h2>
	<select id="detail_list">
	</select>
</div>
</body>
</html>