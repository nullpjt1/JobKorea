<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="divEmpty">
	<div class="hiddenData">
		<span id="totalCntProCod">${totalCntProCod}</span>
	</div>
	<table class="col2 mb10" style="width: 1020px;">
		<thead>
			<tr>
				<th>순번</th>
				<th>프로젝트 명</th>
				<th>지역</th>
				<th>직무</th>
				<th>산업</th>
				<th>작성일</th>
				<th>모집마감일</th>
				<th>작성회사</th>
				<th></th>
			</tr>
		</thead>
		<tbody id="projectList">
			<c:if test="${totalCntProCod eq 0 }">
				<tr>
					<td colspan="7">데이터가 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:set var="nRow" value="${pageSize*(currentPageProCod-1)}" />
			<c:forEach items="${project}" var="pro">
				<tr>
					<td>${nRow+1}</td>
					<td>${pro.project_name}</td>
					<td>${pro.workarea}</td>
					<td>${pro.work_type}</td>
					<td>${pro.industry_type}</td>
					<td>${pro.reg_date}</td>
					<td>${pro.receive_to_date}</td>
					<td>${pro.regId}</td>
					<td><a class="btnType3 color1"
						href="javascript:fPopModalProDtl('${pro.projectId}');"><span>상세보기</span></a>
					</td>
				</tr>
				<c:set var="nRow" value="${nRow + 1}" />
			</c:forEach>
		</tbody>
	</table>
	</table>
</div>
