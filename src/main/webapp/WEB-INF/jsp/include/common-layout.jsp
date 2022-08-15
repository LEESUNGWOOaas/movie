<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<form id="downloadForm" name="downloadForm" method="POST">
   	<input type="hidden" name="fileId">
   	<input type="hidden" name="uploadFormName">
</form>
<iframe id="downloadFrame" name="downloadFrame" frameborder="0" style="display:none;" title="빈 프레임"></iframe>

