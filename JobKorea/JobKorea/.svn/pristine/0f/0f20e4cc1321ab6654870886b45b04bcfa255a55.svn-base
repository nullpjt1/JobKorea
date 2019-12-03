<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>잡코리아 dashboard</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>
<!-- D3 -->

<script type="text/javascript">
	// 프로젝트 페이징 설정
	var pageSizeProCod = 5;
	var pageBlockSizeProCod = 10;


	/* onLoad event */
	$(function() {

		//프로젝트 조회
		pList();

		//검색버튼 이벤트 등록
		pSearchButtonClickEvent();

	});

	//검색버튼 이벤트 등록
	function pSearchButtonClickEvent() {

		$('#memberBtn').click(function() { //프로젝트 검색버튼
			var workarea = $('#workarea');
			var work_type = $('#work_type');
			var industry_type = $('#industry_type');
			var regId = $('#regId');

			$.ajax({
				url : '/dashboard/proList.do',
				type : 'POST',
				dataType : 'text',
				data : {
					workarea : workarea.val(),
					work_type : work_type.val(),
					industry_type : industry_type.val(),
					regId : regId.val()
				},
				async : false,
				success : function(data) {

				},
				error : function(xhr, status, e) {
					console.log("error", e);
					console.log("status", status);
				}
			});

		});
	}

	//프로젝트 목록 조회
	function pList(currentPage) {

		currentPage = currentPage || 1;

		var param = {
			currentPage : currentPage,
			pageSize : pageSizeProCod

		}

		var resultCallback = function(data) {
			pListResult(data, currentPage);
		};

		callAjax("/dashboard/proList.do", "post", "text", true, param,
				resultCallback);

	}

	/* 프로젝트 조회 콜백 함수 */
	function pListResult(data, currentPage) {

		//기존 목록 삭제
		$('#projectList').empty();

		var $data = $($(data).html());

		//신규 목록 생성
		var $projectList = $data.find("#projectList");
		$("#projectList").append($projectList.children());

		//총 개수 추출
		var $totalCntProCod = $data.find("#totalCntProCod");
		var totalCntProCod = $totalCntProCod.text();

		//페이지 네비게이션 생성
		var paginationHtml = getPaginationHtml(currentPage, totalCntProCod,
				pageSizeProCod, pageBlockSizeProCod, 'pList');
		$("#proCodePagination").empty().append(paginationHtml);

		//현재페이지 설정
		$("#currentPageProCod").val(currentPage);

	}


	
</script>

</head>
<body>
	<!-- 모달 배경 -->
	<div id="mask"></div>

	<div id="wrap_area">


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
							<a href="#" class="btn_set home">메인으로</a> <span
								class="btn_nav bold">메인</span> <a href="#"
								class="btn_set refresh">새로고침</a>
						</p>


						<div class="dashboard2 mt30 mb20">
							<ul>
								<li>
									<div class="col">
										<p class="tit">
											<em>Project</em>
										</p>
										<form id="myForm2" action="" method="">
											<input type="hidden" id="currentPageProCod" value="1">
											<!-- 현재 프로젝트 목록페이지 -->
											<input type="hidden" id="tmpGrpCod" value="" /> <input
												type="hidden" id="tmpGrpCodNm" value="" /> <input
												type="hidden" name="action" id="action" value="" />

											<table width="1000px;" cellpadding="5" cellspacing="0"
												border="1"
												style="border-collapse: collapse; border: 1px #50bcdf;">
												<tr style="border: 0px; border-color: blue">
													<th width="100px" height="25" style="font-size: 120%">&nbsp;&nbsp;프로젝트
														조회</th>

													<td align="right" height="25"
														style="font-size: 100%; margin-right: 5px;">주소</td>
													<td height="25" style="font-size: 100%"><select
														id="workarea" name="workarea" style="width: 98px">
															<option value="02" id="area1">서울</option>
															<option value="031" id="area2">경기</option>
															<option value="041" id="area3">충남</option>
															<option value="042" id="area4">충븍</option>
															<option value="061" id="area5">전남</option>
															<option value="063" id="area6">전북</option>
															<option value="055" id="area7">경남</option>
															<option value="054" id="area8">경북</option>
															<option value="033" id="area9">강원</option>
															<option value="051" id="area10">부산</option>
															<option value="064" id="area11">제주</option>
													</select></td>
													<td align="right" height="25" style="font-size: 100%">직무</td>
													<td height="25" style="font-size: 100%"><select
														id="work_type" name="work_type" style="width: 98px">
															<option value="1" id="work1">경영사무</option>
															<option value="2" id="work2">마케팅 광고</option>
															<option value="3" id="work3">IT 인터넷</option>
															<option value="4" id="work4">디자인</option>
															<option value="5" id="work5">무역 유통</option>
															<option value="6" id="work6">영업</option>
															<option value="7" id="work7">서비스</option>
															<option value="8" id="work8">연구개발 설계</option>
															<option value="9" id="work9">생산제조</option>
															<option value="10" id="work10">교육</option>
															<option value="11" id="work11">건설</option>
															<option value="12" id="work12">의료</option>
															<option value="13" id="work13">미디어</option>
															<option value="11" id="work14">특수직</option>
													</select></td>
													<td align="right" height="25" style="font-size: 100%">산업</td>
													<td height="25" style="font-size: 100%"><select
														id="industry_type" name="industry_type"
														style="width: 98px"><option value="K64" id="K64">금융
																은행업</option>
															<option value="J62" id="J62">IT 정보통신업</option>
															<option value="G45" id="G45">판매유통업</option>
															<option value="C10" id="C10">제조 생산화학업</option>
															<option value="P85" id="P85">교육업</option>
															<option value="F41" id="F41">건설업</option>
															<option value="Q86" id="Q86">의료 제약업</option>
															<option value="J58" id="J58">미디어 광고업</option>
															<option value="M70" id="M70">문화 예술 디자인업</option>
															<option value="S94" id="S94">기관협회</option>
													</select></td>
													<td width="110" height="60" style="font-size: 120%"><input
														type="submit" value="검  색  " id="memberBtn"
														class="test_btn1" border="0"
														style="border-collapse: collapse; border: 0px gray solid; background-color: #50bcdf; width: 70px; color: white" /></td>
												</tr>

											</table>

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
												<tbody id="projectList"></tbody>
												<!-- 프로젝트 목록 불러옴 -->
											</table>
											
										</form>
									</div>
									
								</li>
							</ul>
							<div class="paging_area" id="proCodePagination"></div>
						</div>
					</div>
				</li>
			</ul>

		</div>
	</div>
</body>
</html>