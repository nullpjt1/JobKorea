<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="divEmpty">
	<div class="hiddenData">
		<span id="totalCountRoom">${totalCountRoom}</span>
	</div>
	<table class="col">
		<thead>
			<tr>
				<th scope="col">순번</th>
				<th scope="col">제목</th>
				<th scope="col">작성일</th>
				<th scope="col">작성자</th>
				<th scope="col">파일</th>
			</tr>
		</thead>
		<tbody id="SelectRoomList">
		<c:if test="${totalCountRoom eq 0 }">
			<tr>
				<td colspan="9">데이터가 존재하지 않습니다.</td>
			</tr>
		</c:if>
		<c:set var="nRow" value="${pageSize*(currentPage-1)}" />
		<c:forEach items="${listRoomModel}" var="list">
			<tr>
				<td>${list.row_num}</td>
				<td><a href="javascript:finsertRoomlist('${list.wno}')">${list.title}</a></td>
				<td>${list.reg_date}</td>
				<td>${list.regId}</td>
				<td><a href="javascript:fFileDownload('${list.wno}')">${list.file_name}</a></td>
				
				<td>
					<a class="btnType3 color1" href="javascript:finsertRoomlist('${list.wno}');"><span>수정</span></a>
				</td>
			</tr>
			<c:set var="nRow" value="${nRow + 1}" />
		</c:forEach>
		</tbody>
	</table>
</div>

					