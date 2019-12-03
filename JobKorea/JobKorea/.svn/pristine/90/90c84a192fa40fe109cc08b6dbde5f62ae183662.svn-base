<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<div class="divEmpty">
					<div class="hiddenData">
						<span id="totalCntPerson">${totalCntPerson}</span>
					</div>
					<table class="col">
						<thead>
							<tr>
								<th scope="col">순번</th>
								<th scope="col">성명</th>
								<th scope="col">제목</th>
								<th scope="col">지역</th>
								<th scope="col">임시 필드 01</th>
								<th scope="col">추가기술</th>
								<th scope="col">비고</th>									
							</tr>
						</thead>
						<tbody id="listPerson">
						<c:if test="${totalCntPerson eq 0 }">
							<tr>
								<td colspan="6">데이터가 존재하지 않습니다.</td>
							</tr>
						</c:if>
						<c:set var="nRow" value="${pageSize*(currentPagePerson-1)}" />
						<c:forEach items="${test}" var="t">
							<tr>
								<td>${totalCntPerson - nRow}</td>
								<td>${t.name}</td>
								<td>${t.title}</td>
								<td>${t.area}</td>
								<td></td>
								<td>${t.addtec}</td>
								<td><a class="btnType3 color1" href="javascript:fPopModalComnGrpCod('${list.grp_cod}');"><span>쪽지</span></a></td>									
							</tr>
							<c:set var="nRow" value="${nRow + 1}" />
						</c:forEach>
						</tbody>
					</table>
				</div>