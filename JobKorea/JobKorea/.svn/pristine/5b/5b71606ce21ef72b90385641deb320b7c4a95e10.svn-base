<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cutil" uri="tld/CommonUtil.tld"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>JobKorea</title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

    var pageSize = 5;
    var pageBlockSize = 10;

	/** OnLoad event */ 
	$(function() {
	
		// 그룹코드 조회
		fSelectRoomList();
		
		// 버튼 이벤트 등록
		fRegisterButtonClickEvent();
	});
	
	/** 버튼 이벤트 등록 */
	function fRegisterButtonClickEvent() {
		$('a[name=btn]').click(function(e) {
			e.preventDefault();

			var btnId = $(this).attr('id');

			switch (btnId) {
				case 'btnSaveRoom' :
					finsertRoom();
					break;
				case 'btnDeleteRoom' :
					fdeleteRoom();
					break;
				case 'btnCloseRoom' :
					gfCloseModal();
					break;
			}
		});
	}
	
	/** 자료실 조회 */
	function fSelectRoomList(currentPage) {
		
		currentPage = currentPage || 1;
		
		var param = {
					currentPage : currentPage
				,	pageSize : pageSize
		}
		
		var resultCallback = function(data) {
			flistRoomResult(data, currentPage);
		}; 
		
		callAjax("/room/SelectRoomList.do", "post", "text", true, param, resultCallback);
	}
	
	/** 자료실 조회 콜백 함수 */
	function flistRoomResult(data, currentPage) {
		
		// 기존 목록 삭제
		$('#SelectRoomList').empty();
		//$('#listComnGrpCod').find("tr").remove() 
		
		var $data = $( $(data).html() );
		
		console.log($data);

		// 신규 목록 생성
		var $SelectRoomList = $data.find("#SelectRoomList");		
		$("#SelectRoomList").append($SelectRoomList.children());
		
		// 총 개수 추출
		var $totalCountRoom = $data.find("#totalCountRoom");
		var totalCountRoom = $totalCountRoom.text(); 
		
		// 페이지 네비게이션 생성
		var paginationHtml = getPaginationHtml(currentPage, totalCountRoom, pageSize, pageBlockSize, 'fSelectRoomList');
		$("#RoomPagination").empty().append( paginationHtml );
		
		// 현재 페이지 설정
		$("#currentPage").val(currentPage);
	}
	
	
	/** 그룹코드 모달 실행 */
	function finsertRoomlist(wno) {
		
		// 신규 저장
		if (wno == null || wno=="") {
			alert("신규등록 버튼 누름");
			$("#action").val("I");
			fWriteRoomForm();
			
			// 모달 팝업
			gfModalPop("#layer1");

		// 수정 저장
		} else {
			
			$("#action").val("U");
			alert("수정버튼 누르고 wno : " +wno );
			
			fupdateRoomForm(wno);
			
		}
	}
	
	/* this is modal~modal~ */
	function fWriteRoomForm(data) {
		var sloginId = $("#sloginId").val();
	
		$("#wno").focus();
		if($("#action").val() == "I") {
			alert("신규작성 으로 진입함");
			$("#wno").val();
			$("#title").val("");
			$("#note").val("");
			$("#reg_date").val("");
			$("#regId").val(sloginId);
			$("#file_name").val("");
			
			$("#wno").attr("readonly", true);
			$("#reg_date").attr("readonly", true);
			$("#regId").attr("readonly", true);
			$("#wno").css("background", "#FFFFFF");
			$("#reg_date").css("background", "#FFFFFF");
			$("#regId").css("background", "#FFFFFF");
			$("#wno").focus();
			$("#btnDeleteGrpCod").hide();
			
		} else{
			alert("1111111111111111 : " + data.file_name);
			
			alert("수정및 게시물보기  진입함");
			$("#wno").val(data.wno);
			$("#title").val(data.title);
			$("#note").val(data.note);
			$("#reg_date").val(data.reg_date);
			$("#regId").val(sloginId);
			//$("#file_name").val(data.file_name);
			
			var downloadhtml = "";
			
			if(data.file_name == "" || data.file_name == null) {				
			} else {
				downloadhtml = "<br><a href='javascript:fdownload();' >" + data.file_name + "</a>";
			}
			
			$("#filedownload").empty().append( downloadhtml );			
			
		
			$("#wno").attr("readonly", true);
			$("#reg_date").attr("readonly", true);
			$("#regId").attr("readonly", true);
			$("#wno").css("background", "#F5F5F5");
			$("#reg_date").css("background", "#F5F5F5");
			$("#regId").css("background", "#F5F5F5");
			$("#title").focus();
			$("#btnDeleteGrpCod").show();
		}
	}
	
	
	/* 빈값 체크  */
	function fCheckRoom() {

		var chk = checkNotEmpty(
				[
						[ "title", "제목을 입력해 주세요." ]
					,	[ "content", "내용을 입력해 주세요" ]
					,	[ "regID", "작성자를 입력해 주세요." ]
				]
		);

		if (!chk) {
			return;
		}

		return true;
	}
	
	
	/** 신규등록 저장 */
	function finsertRoom() {

		// vaildation 체크
		if ( ! fCheckRoom() ) {
			return;
		}
		
		// file form 값 생성
		var frm = document.getElementById("myForm");
		frm.enctype = 'multipart/form-data';
		var fileData = new FormData(frm);
		
				
		fileData.append("empty", "empty");
		
		var resultCallback = function(data) {
			fSaveRoomResult(data);
		};

		callAjaxFileUploadSetFormData("/room/RoomlistForm.do", "post", "json", true, fileData, resultCallback);	
	
	}
	
	
	/** 저장 콜백 함수 */
	function fSaveRoomResult(data) {
		
		// 목록 조회 페이지 번호
		var currentPage = "1";
		if ($("#action").val() != "I") {
			currentPage = $("#currentPage").val();
		}
		
		if (data.result == "SUCCESS") {
			
			$("#file_name").val("");	// 첨부파일
			
			// 응답 메시지 출력
			alert(data.resultMsg);
		
			// 목록 조회
			fSelectRoomList(currentPage);
						
			// 모달 닫기
			gfCloseModal();
			

		} else {
			// 오류 응답 메시지 출력
			alert(data.resultMsg);
		}
		
		// 입력폼 초기화
		fWriteRoomForm();
	}
	
	
	/** 수정수정 */
	function fupdateRoomForm(wno) {
		
		var param = { wno : wno };
		
		var resultCallback = function(data) {
			fUpdateRoomResult(data);
		};
		
		callAjax("/room/ViewRoom.do", "post", "json", true, param, resultCallback);
	}
	
	
	/** 수정 콜백함수*/
	function fUpdateRoomResult(data) {

		if (data.result == "SUCCESS") {

			// 모달 팝업
			gfModalPop("#layer1");
			
			// 그룹코드 폼 데이터 설정
			fWriteRoomForm(data.roomListModel);
			
		} else {
			alert(data.resultMsg);
		}	
	}

	
	/** 상세코드 삭제 */
	function fdeleteRoom() {
		
		var resultCallback = function(data) {
			fdeleteRoomResult(data);
		};
		
		callAjax("/room/deleteRoom.do", "post", "json", true, $("#myForm").serialize(), resultCallback);
	}
	
	
	/** 상세코드 삭제 콜백 함수 */
	function fdeleteRoomResult(data) {
		
		var currentPage = $("#currentPage").val();
		
		if (data.result == "SUCCESS") {
			
			// 응답 메시지 출력
			alert(data.resultMsg);
			
			// 모달 닫기
			gfCloseModal();
			
			// 그룹코드 목록 조회
			fSelectRoomList(currentPage);
			
		} else {
			alert(data.resultMsg);
		}	
	}
	
	
	function fdownload(wno) {
		
		var params = "";
		params += "<input type='hidden' name='wno' value='"+ wno +"' />";
		//params += "<input type='hidden' name='snm' value='"+ snm +"' />";
		
		jQuery("<form action='/room/downloadtFile.do' method='post'>"+params+"</form>").appendTo('body').submit().remove();
	}

	
</script>	

</head>
<body>
<form id="myForm" action=""  method="">
	<input type="hid-den" id="currentPageRoomlist" value="1">
	<input type="hid-den" id="currentPageRoomCd" value="1">
	<input type="hid-den" id="tmpGrpCod" value="">
	<input type="hid-den" id="tmpGrpCodNm" value="">
	<input type="hid-den" name="action" id="action" value="">
	<input type="hid-den" name="sloginId" id="sloginId" value="${loginId}">
	
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
								class="btn_nav">시스템 관리</a> <span class="btn_nav bold">자료실
								</span> <a href="#" class="btn_set refresh">새로고침</a>
						</p>

						<p class="conTitle">
							<span>자료실</span> 
							<span class="fr"> 
								<a class="btnType blue" href="javascript:finsertRoomlist();" name="modal"><span>신규등록</span></a>
							</span>
						</p>
						
						<div class="divRoomList">
							<table class="col">
								<caption>caption</caption>
								<colgroup>
									<col width="6%">
									<col width="20%">
									<col width="10%">
									<col width="10%">
									<col width="5%">
									<col width="5%">
								</colgroup>
	
								<thead>
									<tr>
										<th scope="col">순번</th>
										<th scope="col">제목</th>
										<th scope="col">작성일</th>
										<th scope="col">작성자</th>
										<th scope="col">파일</th>
										<th scope="col"></th>
										
									</tr>
								</thead>
								<tbody id="SelectRoomList"></tbody>
							</table>
						</div>
	
						<div class="paging_area"  id="RoomPagination"> </div>
	

					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>


<div id="layer1" class="layerPop layerType2" style="width: 600px;">
	
		<dl>
			<dt>
				<strong>자료게시물 등록</strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<table class="row">
					<caption>caption</caption>
					<colgroup>
						<col width="120px">
						<col width="*">
						<col width="120px">
						<col width="*">
					</colgroup>

					<tbody>
						<tr>
							<th scope="row">번호 <span class="font_red"></span></th>
							<td><input type="text" class="inputTxt p100" name="wno" id="wno" /></td>
							<th scope="row">작성일</th>
							<td colspan="3"><input type="text" class="inputTxt p100"
								name="reg_date" id="reg_date" /></td>
						</tr>
						<tr>
							<th scope="row">제목<span class="font_red"></span></th>
							<td><input type="text" class="inputTxt p100" name="title" id="title" /></td>
							<th scope="row">작성자</th>
							<td colspan="3"><input type="text" class="inputTxt p100"
								name="regId" id="regId" /></td>
							
						</tr>
						<tr>
							<th scope="row">내용 <span class="font_red"></span></th>
							<td colspan="3">
								<input type="text" class="inputTxt p100" name="note" id="note" />
								
							</td>
						</tr>
						<tr>
						
						</tr>
						<tr>
							<th scope="row">파일명</th>
							<td colspan="4">
								
							    <input type="text" class="inputTxt p100" name="file_name" id="file_name" />
							    
							    <div id="filedownload"></div>

							  
							</td>
							<td><button>찾아보기</button></td>	
						</tr>
			
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnSaveRoom" name="btn"><span>저장</span></a> 
					<a href="" class="btnType blue" id="btnDeleteRoom" name="btn"><span>삭제</span></a>
					<a href=""	class="btnType gray"  id="btnCloseRoom" name="btn"><span>취소</span></a>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>
	
	
	
</form>
</body>
</html>