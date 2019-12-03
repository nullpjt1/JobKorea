<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				
				
		<!-- 갯수가 0인 경우  -->
		<c:if test="${totalCnt eq 0 }">
			<tr>
				<td colspan="6">데이터가 존재하지 않습니다.</td>
			</tr>
		</c:if>
		

		<!-- 갯수가 있는 경우  -->
		<c:if test="${totalCnt > 0 }">
			<c:set var="nRow" value="${pageSize*(totalCnt-1)}" /> 
			<c:forEach items="${qnaList}" var="list">
				<tr>
					<td>${list.num}</td>  <!-- 보여지는 가짜 리스트 번호  -->
					<td>${list.upper_wno}</td> <!-- 상위글 upper_wno -->
					<td>${list.regId}</td>
					<td>${list.title}</td>
					<td>${list.note}</td>
					<td>${list.reg_date}</td>
					<%-- <td>${list.readCnt}</td> --%>
					<td><a class="btnType3 color1" href="javascript:fQnaModal(${list.wno});"><span>보기</span></a></td>
					<!-- qnaList에 있는 js 함수 호출가능 이거 그대로 가지고 가기 때문에 !!  -->
				</tr>
				 <c:set var="nRow" value="${nRow + 1}" /> 
			</c:forEach>
		</c:if>
		
		<input type="hidden" id="totalCnt" value="${totalCnt}">
		<!-- 이거 중간에 있으면 table 안먹힘  -->
	