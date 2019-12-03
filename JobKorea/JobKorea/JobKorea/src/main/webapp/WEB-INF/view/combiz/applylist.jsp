<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>JobKorea</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">
	
$(document).ready(function() {
	

	$('#memberBtn').click(function() {		
		
		var project_name = $('#project_name').val();		
		alert(project_name + " : 111111111111111111");
		$.ajax({
			url : '/combiz/applyprojectlist.do',
			type : 'POST',
			dataType : 'text',
			data : {				
				project_name : project_name							
			},
			async : false,
			success : function(data) {

				/* 	   console.log(data);
				   if(data==null){
					   alert("검색조건에 일치하는 회원이 업습니다.");    
					  return false
				   }else {            		   
					  
				          alert("회원 목록입니다.");
				          
				          return false
				   }   */
				   alert(project_name + " : " + data.project_name);
				   $("#project_name").val(project_name);  
				   //$("#update_date").val(data.update_date);  

			},
			error : function(xhr, status, e) {
				console.log("error", e);
				console.log("status", status);
			}
		});
		
	});
});

	var pageSizePerson = 5;
	var pageBlockSizeComnPerson = 10;
	
	/** 프로젝트 지원한 사원 조회 */
	function fprojectPerson(currentPage, projectId) {
		
		currentPage = currentPage || 1;
		
		alert("currentPage : " + currentPage + " projectId : " + projectId);
		
		// 사원 정보 설정
		$("#projectId").val(projectId);
		
		var param = {
				projectId : projectId
				,	currentPage : currentPage
				,	pageSize : pageSizePerson
		}
		
		var resultCallback = function(data) {
			flistProjectResult(data, currentPage);
		};
		
		callAjax("/combiz/listProject.do", "post", "text", true, param, resultCallback);
	}
	
	/** 상세코드 조회 콜백 함수 */
	function flistProjectResult(data, currentPage) {
		
		// 기존 목록 삭제
		$('#listProject').empty(); 
		
		var $data = $( $(data).html() );

		// 신규 목록 생성
		var $listProject = $data.find("#listProject");		
		$("#listProject").append($listProject.children());
		
		// 총 개수 추출
		var $totalCntProject = $data.find("#totalCntProject");
		var totalCntProject = $totalCntProject.text(); 
		
		// 페이지 네비게이션 생성
		var projectId = $("#projectId").val();
		var loginId = $("#loginId").val();
		var paginationHtml = getPaginationHtml(currentPage, totalCntProject, pageSizePerson, pageBlockSizeComnPerson, 'fprojectPerson', [projectId]);
		$("#comnPersonPagination").empty().append( paginationHtml );
		
		// 현재 페이지 설정
		$("#currentPagePerson").val(currentPage);
	}

	
</script>

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hidden" id="currentPagePerson" value="1">	
	<input type="hidden" id="projectId" value="">
	<input type="hidden" id="loginId" value="">
	<input type="hidden" name="action" id="action" value="">
	
	<!-- 모달 배경 -->
	<div id="mask"></div>

	<div id="wrap_area">

		<h2 class="hidden">header 영역</h2>
		<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

		<h2 class="hidden">컨텐츠 영역</h2>
		<div id="container">
			<ul>
				<li class="lnb">
					<!-- lnb 영역 --> <jsp:include
						page="/WEB-INF/view/common/lnbMenu.jsp"></jsp:include> <!--// lnb 영역 -->
				</li>
				<li class="contents">
					<!-- contents -->
					<h3 class="hidden">contents 영역</h3> <!-- content -->
					<div class="content">

						<p class="Location">
							<a href="#" class="btn_set home">메인으로</a> <a href="#"
								class="btn_nav">마이페이지</a> <span class="btn_nav bold">지원현황
								</span> <a href="#" class="btn_set refresh">새로고침</a>
						</p>
						
						<p class="conTitle">
							<span>지원 현황 </span>
						</p>
							<table width="100%" cellpadding="5" cellspacing="0" border="1"
								align="left"
								style="border-collapse: collapse; border: 1px #50bcdf;">
								<tr style="border: 0px; border-color: blue">
									<td width="100" height="25" style="font-size: 120%">&nbsp;&nbsp;</td>

									<td width="100" height="25" style="font-size: 100%">프로젝트명</td>
									<td width="70" height="25" style="font-size: 80%"></td>									
									<td width="100" height="25" style="font-size: 100%">마감일자</td>
									<td width="70" height="25" style="font-size: 80%"></td>
								</tr>
								<tr class="col1" style="border: 0px; border-color: #50bcdf">
									<td width="100" height="25" style="font-size: 80%"></td>

									<td width="100" height="50" style="font-size: 100%"><input type="text"
										 style="width: 120px" id="project_name" name="project_name">											
									</td>
									<td width="70" height="25" style="font-size: 80%"></td>
									<td width="100" height="50" style="font-size: 100%"><input type="date"
										 style="width: 120px" id="update_date" name="update_date">
									</td>
								
									<td width="70" height="25" style="font-size: 80%"></td>					
																	

								</tr>
								<tr class="col1" style="border: 0px; border-color: lightgray">
									<td width="100" height="15" style="font-size: 80%"></td>

									<td width="100" height="15" style="font-size: 70%"></td>
									<td width="70" height="15" style="font-size: 80%"></td>
									<td width="100" height="15" style="font-size: 70%"></td>
									<td width="70" height="15" style="font-size: 80%"></td>
									<td width="100" height="15" style="font-size: 70%"></td>
									<td width="110" height="60" style="font-size: 120%"><input
										type="submit" value="검  색  " id="memberBtn" class="test_btn1"
										border="0"
										style="border-collapse: collapse; border: 0px gray solid; background-color: #50bcdf; width: 70px; color: white" /></td>

								</tr>
							</table>
							
							<div class="divComGrpCodList">
								<table class="col">
									<caption>caption</caption>
									<colgroup>
										<col width="45%">
										<col width="35%">
										<col width="20%">																				
										
									</colgroup>
			
									<thead>
										<tr>
											<th scope="col">프로젝트명</th>
											<th scope="col">마감일자</th>
											<th scope="col">지원자수</th>														
											
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${cop}" var="c">	
										<tr>
											<td><a href="javascript:fprojectPerson(1, '${c.projectId}');"><span>${c.project_name}</span></a></td>
											<td>${c.update_date}</td>
											<td></td>											
										</tr>
									</c:forEach>
									</tbody>
								</table>								
								
							</div>
							
													
							<table>
								<tr>
									<td height="20"></td>
								</tr>
							</table>												
						
						<p class="conTitle mt50">
							<span>회원 목록</span> <span class="fr"></span>
						</p>	
							
						<div class="divComDtlCodList">
							<table class="col">
								<colgroup>
									<col width="5%">
									<col width="10%">
									<col width="25%">
									<col width="30%">
									<col width="20%">
									<col width="10%">
								</colgroup>
								
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
									<tr>
										<td colspan="6">프로젝트명을 선택해주세요.</td>
									</tr>
								</tbody>
							</table>
						</div>
                           
                        <div class="paging_area"  id="comnPersonPagination"> </div>

					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>

	
</form>
</body>
</html>