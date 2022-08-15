<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<div class="text-center">
	<ul class="pagination">
		<c:if test="${pageVO.nowBlock>1}">
			<li onclick="fnGoPage(${pageVO.startPage-1})"><a href="#none">&lt; </a></li>
		</c:if>
		
		<c:forEach var="i" begin="${pageVO.startPage}" end="${pageVO.endPage}">
			<c:choose>
			<c:when test="${i==pageVO.page }">
				<li class="active"><a href="#">${i}</a></li>
			</c:when>
			<c:otherwise>
				<li onclick="fnGoPage(${i})"><a href="#none">${i}</a></li>
			</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${pageVO.nowBlock<pageVO.totBlock }">
			<li onclick="fnGoPage(${pageVO.endPage+1})"><a href="#none">&gt; </a></li>
		</c:if>
		
	</ul>
</div>