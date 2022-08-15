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
				<div class="title"></div>
			</div>
		</div>
		<div class="panel-body">
			<form id="regForm" class="form-horizontal" >
				<input type="hidden" name="userNo" value="${empty userVO? 0:userVO.userNo }">
			
				<table class="table table-bordered">
					<colgroup>
						<col width="20%" />
						<col width="80%" />
					</colgroup>
					<tr>
						<th>총 관리자 유무</th>
						<td><input type="radio" class="auth" name="auth" id="auth-Y" value="Y"${userVO.auth eq 'Y'? 'checked':empty userVO? 'checked':'' } ><label for="auth-Y">Y</label>
						<input type="radio" class="auth" name="auth" id="auth-N"  value="N"${userVO.auth eq 'N'? 'checked':'' } ><label for="auth-N">N</label></td>
					</tr>

					<tr>
						<th>이름</th>
						<td><input type="text" name="userName" id="userName" title="이름" value="${userVO.userName }" ></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="text" name="phone" id="phone" title="연락처" value="${userVO.phone }" ></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email" id="email" title="이메일" value="${userVO.email }" ></td>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId" id="userId" title="아이디" value="${userVO.userId }" readonly></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password"  class="pwd" name="pwd" id="pwd" title="비밀번호" required>※비밀번호 미입력시 기존 비밀번호가 유지됩니다.</td>
					</tr>
				</table>
				
				
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<button type="button" class="btn btn-default" onclick="cancel();">취소</button>
						<button type="button" class="btn btn-primary" onclick="save();">저장</button>
					</div>
				</div>
				
			</form>
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

function cancel(){
	var url = "${empty userVO? 'list':userVO.userNo}";
	var params = fnGetPrevParmas("userNo");
	fnRedirect(url+'?'+params);
}

$(function(){
	var userNo = "${userVO.userNo}";
	if(userNo == 0||userNo == null){
	$('#userId').attr('readonly',false);
	
	}
});

$(function(){
	var pwd = "${userVO.pwd}";
	$('input').find("#pwd").prop("required", true);
});

function save(){
	
	
	var param = $('#regForm').serialize();
	var pwd = $('.pwd').val();
	var auth = $('.auth').val();
	var userId =$('#userId').val();
	
	
	
	$('.auth:checked').val()
	if(auth == ""){
		alert("관리자 유무를 설정해 주세요");
		return;
	}	
	
	if(pwd== ""){
		$('input').find("#pwd").prop("required", false);
	} 
	 
	$.ajax({
	    url : "/admin/user/save",
		type: 'POST',
		data: param,
		dataType: 'json',
		success: function(response) {
			console.log(response);
			alert(response.msg);
			if(response.result){
				goList();
			}
		}
	});
	
}
</script>
