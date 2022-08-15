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

	<div class="row mb-10 ">
		<div class="col-sm-12 text-right">

			 <a href="form" class="btn btn-sm btn-primary">등록</a><br/>
		</div>
	</div>
	
	<div class="panel panel-default">
		
		<div class="panel-body">
			
			<form id="searchForm" action="list">
			<div class="row mb-10 ">
				<div class="col-sm-6 pt-10">
					전체 <span class="text-red" style="color:red">${pageVO.totSize }</span>건
				</div>
				<div class="col-sm-3"></div>
				<div class="col-sm-3">
					<div class="input-group">
						<div class="input-group-addon">
							<select name="searchType">						
								<option value="user_name" <c:if test="${userVO.searchType eq 'userName'}">selected</c:if>>이름</option>
								<option value="email" <c:if test="${userVO.searchType eq 'email'}">selected</c:if>>이메일</option>
							</select>
						</div>
						<input type="text" name="searchKeyword" class="form-control" value="${userVO.searchKeyword}">
						<span class="input-group-btn">
							<button type="submit" class="btn btn-primary">검색
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						</span>
					</div>
				
				</div>
			</div>
			</form>

			<div class="row">
				<div class="col-sm-12">

					<div class="table-responsive">
						<table class="table table-bordered table-hover text-center">
							<thead>
								<tr>
									<th width="30">번호</th>
									<th width="150">관리자 이름</th>
									<th width="100">총 관리자</th>
									<th width="100">등록일</th>
									<c:if test="${currentUser.auth == 'Y'}">
									<th width="100">관리 </th>
									</c:if>
								</tr>
							</thead>
							<tbody>
								<c:set var="rownum" value="${pageVO.rownum }"/>
								<c:forEach var="item" items="${list }">
								<tr>
									<td>${rownum }</td>
									<td><a onclick="view(${item.userNo})">${item.userName }</a></td>
									<td>${item.auth }</td>
									<td><fmt:formatDate value="${item.insertDate }" pattern="yyyy-MM-dd"/> </td>
									<c:if test="${currentUser.auth == 'Y'}">
									<td><input type="button" class="btn btn-xs btn-danger" value="삭제"
											onclick="del('${item.userNo}')"></td></c:if>
								</tr>
								<c:set var="rownum" value="${rownum-1 }"/>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
					<jsp:include page="/WEB-INF/jsp/include/paging-admin.jsp"/>
					
				</div>
			</div>
			
       
		</div>
	</div>
</div>

<script>

$(function(){
	activeMenu('/admin/user/list');
});

function view(userNo){
	location.href= userNo+'?'+window.location.search.substring(1);
} 

function del(userNo){
	if(!confirm("삭제하시겠습니까?")) return;
	
	var params={
			userNo: userNo
	}
	
	$.ajax({
		url : "./delete",
		type: 'post',
		data: params,
		dataType: 'json',
		success:function(response){
			alert(response.msg);
			if(response.result){
				fnReload();
				
			}
		}
	});
}
</script>