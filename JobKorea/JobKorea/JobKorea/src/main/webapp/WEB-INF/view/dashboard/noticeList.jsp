<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="divEmpty">
	<div class="hiddenData">
		<span id="totalCntNoCod">${totalCntNoCod}</span>
	</div>
	<table class="col2 mb10" style="width: 1020px;">
		<thead>
			<tr>
				<th width="10%">순번</th>
				<th width="60%">제목</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody id="noticeList">
			<c:if test="${totalCntNoCod eq 0 }">
				<tr>
					<td colspan="3">데이터가 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:set var="nRow" value="${pageSize*(currentPageNoCod-1)}" />
			<c:forEach items="${notice}" var="no">
				<tr>
					<td>${nRow+1}</td>
					<%-- <td>${no.wno}</td> --%>
					<td><a href="javascript:nListDtl('${no.wno}')">${no.title}</td>
					<td>${no.reg_date}</td>
				</tr>
				<c:set var="nRow" value="${nRow + 1}" />
			</c:forEach>
		</tbody>
	</table>
</div>
