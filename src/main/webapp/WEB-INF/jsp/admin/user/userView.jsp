<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>




<div class="header"> 
	<h1 class="page-header">
		<small>User</small>
	</h1>
</div>

<div id="page-inner"> 

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="card-title">
				<div class="title"><!-- form --></div>
			</div>
		</div>
		<div class="panel-body">
				
			<table class="table table-bordered">
				<colgroup>
					<col width="20%" />
					<col width="80%" />
				</colgroup>
				<tr>
					<th>총 관리자 유무</th>
					<td>${userVO.auth}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${userVO.userName}</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${userVO.phone}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${userVO.email}</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>${userVO.userId}</td>
				</tr>
			</table>
			
			<div class="form-group">
				<div class="col-sm-12 text-center">
                       <input type="button" class="btn btn-success" value="수정" onclick="goForm(${userVO.userNo})"> 
                       <input type="button" class="btn btn-danger" value="삭제" onclick="del(${userVO.userNo})"> 
                       <input type="button" class="btn btn-default" value="목록으로" onclick="goList();"> 
				</div>
			</div>
				
		</div>
	</div>
</div>


<script>


$(function(){
	activeMenu('/admin/user/list');
});

function goList() {
	var params = fnGetPrevParmas("");
	fnRedirect("./list");
}

function goForm(userNo) {
	location.href='./form?userNo='+userNo+'&'+window.location.search.substring(1);
}


function del(userNo) {
	if(!confirm("삭제하시겠습니까?")) return;
	
	var params = {
		"userNo": userNo
	}

	$.ajax({
		url : "./delete",
		type: 'post',
		data: params,
		dataType: 'json',
		success: function(response) {
			alert(response.msg);
			if(response.result){
				goList();
			}
		}
	}); 	
	
}
</script>