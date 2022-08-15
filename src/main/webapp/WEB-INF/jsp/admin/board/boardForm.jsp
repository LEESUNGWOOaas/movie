<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
				<div class="title"></div>
			</div>
		</div>
		<div class="panel-body">
			<form id="regForm" class="form-horizontal" >
				<input type="hidden" name="boardNo" value="${empty boardVO? 0:boardVO.boardNo }">
				
				<table class="table table-bordered">
					<colgroup>
						<col width="20%" />
						<col width="80%" />
					</colgroup>

					
				
					<tr>
						<th>*공지사항</th>
						<td><input type="radio" class="sci" name="sci" id="sci-Y" value="Y"${boardVO.sci eq '공지'? 'checked':empty boardVO? 'checked':'' } ><label for="sci-Y">공지</label>
						<input type="radio" class="sci" name="sci" id="sci-N"  value="N"${boardVO.sci eq '비공지'? 'checked':'' } ><label for="sci-N">비공지</label></td>
					</tr>
					<tr>

					<tr>
						<th>*제목</th>
						<td><input type="text" name="title" id="title" title="논문명" class="form-control" value="${boardVO.title }"required></td>
					</tr>
					<tr>
						<th>*내용</th>
						<td ><textarea name="content" id="content" title="내용" class="form-control"  required>${boardVO.content }</textarea></td>
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

<script src="/ckeditor/ckeditor.js"></script>
<script>

$(function(){
	activeMenu('/admin/notice/bbs009/list');
	CKEDITOR.replace("content");
});

function goList() {
	var params = fnGetPrevParmas("");
	fnRedirect("./list");
}

function cancel(){
	var url = "${empty communicationVO? 'list':bbsVO.bbsNo}";
	var params = fnGetPrevParmas("bbsNo");
	fnRedirect(url+'?'+params);
}



function save(){
	
	$('#content').val(CKEDITOR.instances.content.getData());
	
	var form = $('#regForm')[0];
	var formData = new FormData(form);
	
	var sci = $('#sci').val();
	var title = $('#title').val();
	var content = $('#content').val();
	
	
	$('.sci:checked').val()
	if(sci == ""){
		alert("공지사항 유무를  기입해주세요.");
		return;
	}		
	
	if(title == ""){
		alert("제목을 입력해주세요.");
		return;
	}

	if(content == ""){
		alert("내용을 입력해주세요.");
		return;
	}	
	
	$.ajax({
	    url : "/admin/board/save",
		type: "post",
		data: formData,
		enctype: 'multipart/form-data',
        processData: false,
        contentType: false,		
		success: function(response) {
			if(response.result){
				alert(response.msg);
				goList();
			}
		}
	});
	
}
</script>