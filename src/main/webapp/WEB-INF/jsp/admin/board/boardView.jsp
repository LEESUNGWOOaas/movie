<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>



<div class="header"> 
	<h1 class="page-header">
		<small>Board</small>
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
				<!-- ck에디터 들어와야함  -->
				</tr>
				<tr>
					<th>제목</th>
					<td>${boardVO.title }</td>
				</tr>

				<tr>
					<th>개재년월</th>
					<td>${boardVO.insertDate }</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td style=" line-height: 1.5em">${boardVO.content }</td>
				</tr>
			</table>
			
			<div class="form-group">
				<div class="col-sm-12 text-center">
                       <input type="button" class="btn btn-success" value="수정" onclick="goForm(${boardVO.boardNo})"> 
                       <input type="button" class="btn btn-danger" value="삭제" onclick="del(${boardVO.boardNo})"> 
                       <input type="button" class="btn btn-default" value="목록으로" onclick="goList();"> 
				</div>
			</div>
				
		</div>
	</div>
</div>


<script>
$(function(){
	activeMenu('/admin/board/list');
});

function goList() {
	var params = fnGetPrevParmas("");
	fnRedirect("./list");
}


function goForm(boardNo){
	location.href='./form?boardNo='+boardNo+'&'+window.location.search.substring(1);
}

function del(boardNo) {
	
	if(!confirm("삭제하시겠습니까?")) return;
	
	var params = {
		"boardNo": boardNo
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


