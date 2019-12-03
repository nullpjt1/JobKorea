<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
					<div class="divEmpty">
						<div class="hiddenData">
							<span id="totalCntProject">${totalCntProject}</span>
						</div>
						<table class="col">
							<thead>
								<tr>
									<th scope="col">순번</th>									
									<th scope="col">성명</th>
									<th scope="col">제목</th>
									<th scope="col">지역</th>									
									<th scope="col">보유기술</th>
									<th scope="col">비고</th>									
								</tr>
							</thead>
							<tbody id="listProject">							
							<c:if test="${totalCntProject eq 0 }">
								<tr>
									<td colspan="6">데이터가 존재하지 않습니다.</td>
								</tr>
							</c:if>
							<c:set var="nRow" value="${pageSize*(currentPagePerson-1)}" />
							<c:forEach items="${listPerson}" var="list">
								<tr>
									<td>${totalCntProject - nRow}</td>									
									<td>${list.name}</td>
									<td>${list.title}</td>
									<td>${list.area}</td>									
									<td>${list.skill_code}</td>
									<td></td>									
								</tr>
								<c:set var="nRow" value="${nRow + 1}" />
							</c:forEach>
							</tbody>
						</table>
					</div>