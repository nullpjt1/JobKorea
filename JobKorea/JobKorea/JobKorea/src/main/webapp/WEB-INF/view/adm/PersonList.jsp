<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<title>프로젝트관리</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">
// 그룹코드 페이징 설정
var pageSizePerson = 5;
var pageBlockSizePerson = 10;	
	
$(document).ready(function() {
	
	$('#memberBtn').click(function() {		
		
		var area = $('#area');		
		var industry_type = $('#industry_type');

		$.ajax({
			url : '/adm/PersonList.do',
			type : 'POST',
			dataType : 'text',
			data : {
				currentPage : currentPage,	
				pageSize : pageSizePerson,
				area : area.val(),				
				industry_type : industry_type.val()				
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

			},
			error : function(xhr, status, e) {
				console.log("error", e);
				console.log("status", status);
			}
		});

	});

	
	/** OnLoad event */ 
	$(function() {	
		
		//alert("onload !!!!!!!!!!!!!!!!!!!");
		// 코드 조회
		fListPerson();
		
		// 버튼 이벤트 등록
		//fRegisterButtonClickEvent();
	});	
	
	 
	
	
	/** 그룹코드 폼 초기화 */
	function fInitFormGrpCod(object) {
		$("#grp_cod").focus();
		if( object == "" || object == null || object == undefined) {
			
			$("#grp_cod").val("");
			$("#grp_cod_nm").val("");
			$("#grp_cod_eplti").val("");
			$("#grp_tmp_fld_01").val("");
			$("#grp_tmp_fld_02").val("");
			$("#grp_tmp_fld_03").val("");
			$("input:radio[name=grp_use_poa]:input[value='Y']").attr("checked", true);
			$("#grp_cod").attr("readonly", false);
			$("#grp_cod").css("background", "#FFFFFF");
			$("#grp_cod").focus();
			$("#btnDeleteGrpCod").hide();
			
		} else {
			
			$("#grp_cod").val(object.grp_cod);
			$("#grp_cod_nm").val(object.grp_cod_nm);
			$("#grp_cod_eplti").val(object.grp_cod_eplti);
			$("#grp_tmp_fld_01").val(object.tmp_fld_01);
			$("#grp_tmp_fld_02").val(object.tmp_fld_02);
			$("#grp_tmp_fld_03").val(object.tmp_fld_03);
			$("input:radio[name=grp_use_poa]:input[value="+object.use_poa+"]").attr("checked", true);
			$("#grp_cod").attr("readonly", true);
			$("#grp_cod").css("background", "#F5F5F5");
			$("#grp_cod_nm").focus();
			$("#btnDeleteGrpCod").show();
		}
	}	
		
	
	/** 그룹코드 모달 실행 */
	function fPopModalComnGrpCod(grp_cod) {
		
		// 신규 저장
		if (grp_cod == null || grp_cod=="") {
		
			// Tranjection type 설정
			$("#action").val("I");
			
			// 그룹코드 폼 초기화
			fInitFormGrpCod();
			
			// 모달 팝업
			gfModalPop("#popup1");

		// 수정 저장
		} else {
			
			// Tranjection type 설정
			$("#action").val("U");
			
			// 그룹코드 단건 조회
			fSelectPerson(grp_cod);
		}
	}
	
	
	
	//조회
	function fListPerson(currentPage) {
		//alert("fListPerson ");
		currentPage = currentPage || 1;
		
		var area = $('#area');			
		var industry_type = $('#industry_type');
		
		//alert("area : " + area);
		
		var param = {
					currentPage : currentPage
				,	pageSize : pageSizePerson
				,	area : area.val()				
				,	industry_type : industry_type.val()
		};
		
		var resultCallback = function(data) {
			flistPersonResult(data, currentPage);
		};
		
				
		callAjax("/adm/listPerson.do", "post", "text", true, param, resultCallback);
	}

  
	
	
	/** 그룹코드 조회 콜백 함수 */
	function flistPersonResult(data, currentPage) {
		
		// 기존 목록 삭제
		$('#listPerson').empty();
		//$('#listComnGrpCod').find("tr").remove() 
		
		var $data = $( $(data).html() );

		// 신규 목록 생성
		var $listPerson = $data.find("#listPerson");	
		
		//alert("listPerson : " + $listPerson);
		
		$("#listPerson").append($listPerson.children());
		
		// 총 개수 추출
		var $totalCntPerson = $data.find("#totalCntPerson");
		var totalCntPerson = $totalCntPerson.text(); 
		
		// 페이지 네비게이션 생성
		var paginationHtml = getPaginationHtml(currentPage, totalCntPerson, pageSizePerson, pageBlockSizePerson, 'fListPerson');
		$("#comnPersonPagination").empty().append( paginationHtml );
		
		// 현재 페이지 설정
		$("#currentPagePerson").val(currentPage);
	}
	

	// 그룹단건
	function fSelectPerson(grp_cod) {
		
		var param = { grp_cod : grp_cod };
		
		var resultCallback = function(data) {
			fSelectPersonResult(data);
		};
		
		callAjax("/admin/selectPerson.do", "post", "json", true, param, resultCallback);
	}
	
	
	//그룹조회
	function fSelectPersonResult(data) {

		if (data.result == "SUCCESS") {

			// 모달 팝업
			gfModalPop("#popup1");
			
			// 그룹코드 폼 데이터 설정
			fInitFormPerson(data.comnPersonModel);
			
		} else {
			alert(data.resultMsg);
		}	
	}
	
	$('SendNote').click(function() {		
		
		var area = $('#area');		
		var industry_type = $('#industry_type');

		$.ajax({
			url : '/adm/PersonList.do',
			type : 'POST',
			dataType : 'text',
			data : {
				currentPage : currentPage,	
				pageSize : pageSizePerson,
				area : area.val(),				
				industry_type : industry_type.val()				
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

			},
			error : function(xhr, status, e) {
				console.log("error", e);
				console.log("status", status);
			}
		});

	});
	 
	
});	

	
</script>

</head>
<body>
<form id="myForm" action="" method="">
	<input type="hidden" id="currentPagePerson" value="1">  
		<input type="hidden" id="tmpGrpCod" value=""> 
		<input type="hidden" id="tmpGrpCodNm" value=""> 
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
						class="btn_nav">개발자</a> <span class="btn_nav bold">일반회원
						관리</span> <a href="#" class="btn_set refresh">새로고침</a>
				</p>

				<p class="conTitle">
				<table width="100%" cellpadding="5" cellspacing="0" border="1"
					align="left"
					style="border-collapse: collapse; border: 1px #50bcdf;">
					<tr style="border: 0px; border-color: blue">
						<td width="100" height="25" style="font-size: 120%">&nbsp;&nbsp;회원
							조회</td>

						<td width="100" height="25" style="font-size: 100%">주소</td>
						<td width="70" height="25" style="font-size: 80%"></td>
						<!-- <td width="100" height="25" style="font-size: 100%">직무</td>
						<td width="70" height="25" style="font-size: 80%"></td> -->
						<td width="100" height="25" style="font-size: 100%">산업</td>
						<td width="70" height="25" style="font-size: 80%"></td>
					</tr>
					<tr class="col1" style="border: 0px; border-color: #50bcdf">
						<td width="100" height="25" style="font-size: 80%"></td>

						<td width="100" height="25" style="font-size: 100%">	
                            <form:select path="listLstNum" name="areaCD" id="areaCD">
                                <form:options items="${listLstNum}" itemLabel="dtl_cod_nm" itemValue="dtl_cod" />
                           </form:select>					

						</td>
						
						<td width="70" height="25" style="font-size: 80%"></td>
						<td width="100" height="25" style="font-size: 100%">
						 <form:select path="listInsNum" name="industryCD" id="industryCD">
                                <form:options items="${listInsNum}" itemLabel="dtl_cod_nm" itemValue="dtl_cod"  />
                           </form:select>
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
							<col width="6%">
							<col width="24%">
							<col width="24%">
							<col width="15%">
							<col width="10%">													
							<col width="10%">
							<col width="7%">
						</colgroup>

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
						<tbody id="listPerson"></tbody>
					</table>
				</div>
				
				<div class="paging_area"  id="comnPersonPagination"> </div>
			</div>
			<div id="popup1" class="layerPop layerType2" style="width: 600px;">
		<dl>
			<dt>
				<strong>그룹코드 관리</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<table class="row">
					<caption>caption</caption>
					<colgroup>
						<col width="120px">
						<col width="*">
						
					</colgroup>
	
					<tbody>
						<tr>							
							<th scope="row">받는이 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="rcv_loginId" id="rcv_loginId" /></td>
						</tr>
						<tr>
							<th scope="row">내용 <span class="font_red">*</span></th>
							<td colspan="3"><textarea rows="12" cols="70" name="note"></textarea></td>
						</tr>						
					</tbody>
				</table>
	
				<!-- e : 여기에 내용입력 -->
	
				<div class="btn_areaC mt30">
					<input type="submit" value="전  송" id="SendNote" class="test_btn1"	border="0" 
							style="border-collapse: collapse; border: 0px gray solid; background-color: #50bcdf; width: 70px; color: white" />
					<a href="" class="btnType blue" id="btnDeleteNote" name="btn"><span>취소</span></a> 
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>
		<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>		
	
</form>
	
		
</body>
</html>