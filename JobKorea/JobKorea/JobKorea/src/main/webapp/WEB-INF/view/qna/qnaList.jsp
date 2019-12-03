<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title> QnA-게시판  </title>

<jsp:include page="/WEB-INF/view/common/common_include.jsp"></jsp:include>

<script type="text/javascript">

	// 페이징 설정 
	var qnaPageSize = 10;    	// 화면에 뿌릴 데이터 수 
	var qnaPageBlock = 10;		// 블럭으로 잡히는 페이징처리 수
	
	/* onload 이벤트  */
	$(function(){
		// QnA 리스트 뿌리기 함수 
		selectQnaList();
		
		// 버튼 이벤트 등록 (저장, 수정, 삭제, 모달창 닫기)
		fButtonClickEvent();
	});
	
	/* 버튼 이벤트 등록 - 저장, 수정, 삭제  */
	function fButtonClickEvent(){
		$('a[name=btn]').click(function(e){
			e.preventDefault(); // ?? 
					
			var btnId = $(this).attr('id');
			
			alert("btnId : " + btnId);
			
			switch(btnId){
			case 'btnSaveQnA' : fSaveQna(); // save 안에 저장,수정
				alert("저장버튼 클릭!!!이벤트!!");
				break;
			case 'btnDeleteQnA' : fDeleteQna();	// 만들자 
				alert("삭제버튼 클릭!!!이벤트!!");		
				break;
			case 'btnClose' : gfCloseModal();  // 모달닫기 
				selectQnaList(1); // 첫페이지 다시 로딩 
				break;
			case 'btnUpdateQnA' : fUpdateQna();  // 수정하기
				break;
			case 'commentWrite' : fCommentInsert();   // 댓글--> 답변글로 변경 // 저장 
				break;
			}
		});
	}
	
	/* QnA 리스트 불러오기  */
	function selectQnaList(currentPage){
		
		currentPage = currentPage || 1;   // or		
		alert("지금 현재 페이지를 찍어봅시다. " + currentPage);
		
		var param = {
				currentPage : currentPage ,
				pageSize : qnaPageSize 
		}
		
		var resultCallback = function(data){  // 데이터를 이 함수로 넘깁시다. 
			qnaListResult(data, currentPage); 
		}
		
		callAjax("/qna/qnaReallist.do","post","text", true, param, resultCallback);
		
	}
	
	/* callAjax 공통 common.js 에서 퍼옴  -> 이렇게 생긴 함수입니다.  
	
	function fOnloadImg(param){
		var resultCallback = function(data) {
			fOnloadImgResult(data);
		};
		callAjax("/image/selectImgSize.do", "post", "json", false, param, resultCallback);
	 } */
	

	 /* qna 리스트 data를 콜백함수를 통해 뿌려봅시당   */
	 function qnaListResult(data, currentPage){
		 
		 // 일단 기존 목록을 삭제합니다. (변경시 재부팅 용)
		 $("#qnaList").empty();
		 //alert("데이터!!! " + data);
		 console.log("data !!!! " +  data);
		 
		 //var $data = $( $(data).html() ); // data의 .html()통해서 html구문을 끌어온다.
		 //alert("데이터 찍어보자!!!! " +  $data); // object
		 
		 $("#qnaList").append(data);
		 // 받아온 리스트 data의 text를 추출해서 newList에 담겠습니다.
		 // 신규 목록 생성 
		 //var $qnaNewList = $data.find("#qnaRealList");
		 //$("#qnaList").append($qnaNewList.children()); // 여기 리스트 아래에 뿌릴게요 -> 이거 안되서 그냥 text로 했음.
		 //alert("newList!!" + $qnaNewList.children());
		 
		 // 리스트의 총 개수를 추출합니다. 
		 //var totalCnt = $data.find("#totalCnt").text();
		 var totalCnt = $("#totalCnt").val();  // qnaRealList() 에서보낸값 
		 alert("totalCnt 찍어봄!! " + totalCnt);
		 
		 // * 페이지 네비게이션 생성 (만들어져있는 함수를 사용한다 -common.js)
		 // function getPaginationHtml(currentPage, totalCount, pageRow, blockPage, pageFunc, exParams)
		 // 파라미터를 참조합시다. 
		 var list = $("#tmpList").val();
		 //var listnum = $("#tmpListNum").val();
		 var pagingnavi = getPaginationHtml(currentPage, totalCnt, qnaPageSize,qnaPageBlock, 'selectQnaList',[list]);
		 
		 console.log("pagingnavi : " + pagingnavi);
		 // 비운다음에 다시 append 
		 $("#pagingnavi").empty().append(pagingnavi); // 위에꺼를 첨부합니다. 
		 
		 // 현재 페이지 설정 
		 $("#currentPage").val(currentPage);
		 
	 }
	 
	 /* QnA 모달창(팝업) 실행  */
	 function fQnaModal(num) {
		 
		 // 신규저장 하기 버튼 클릭시 (값이 null)
		 if(num == null || num==""){
			// Tranjection type 설정
			alert("넘을 찍어보자!!!!!!" + num);
			
			$("#action").val("I"); // insert 
			frealPopModal(num); // QnA 게시판 초기화 
			
			//모달 팝업 모양 오픈! (빈거) _ 있는 함수 쓰는거임. 
			gfModalPop("#layer1");
			
		 }else{
			// Tranjection type 설정
			$("#action").val("U");  // update
			fdetailModal(num); //번호로 -> QnA 상세 조회 팝업 띄우기
		 }

	 }
	 
	 
	 /*  QnA 상세 조회  */
	 function fdetailModal(num){
		 alert("QnA 상세 조회  ");
		 
		 var param = {num : num};
		 var resultCallback2 = function(data){
			 fdetailResult(data);
		 };
		 
		 callAjax("/qna/detailQnAlist.do", "post", "json", true, param, resultCallback2);
	 }
	 
	 /*  QnA 상세 조회 -> 콜백함수   */
	 function fdetailResult(data){

		 if(data.resultMsg == "SUCCESS"){
			 //모달 띄우기 
			 gfModalPop("#layer1");
			 
			// 모달에 정보 넣기 
			frealPopModal(data.result);
		 
		 }else{
			 alert(data.resultMsg);
		 }
	 }
	 
	 /* 팝업 _ 초기화 페이지(신규) 혹은 내용뿌리기  */
	 function frealPopModal(object){
		 
		 if(object == "" || object == null || object == undefined){
			 var writer = $("#swriter").val();
			 $("#writer").val(writer);
			 $("#reg_date").val("저장시점에 날짜로 저장^^");
			 $("#subject").val("");
			 $("#content").val("");
			 $("#pwd").val("");
			 $("#readCnt").val("");
			 $("#btnDeleteQnA").hide(); // 삭제버튼 숨기기
			 $("#btnUpdateQnA").hide();
			 $("#btnSaveQnA").show();
			 $("#showComment").hide();
			 
		 }else{
			 
			 alert("숫자찍어보세 : " + object.wno);// 페이징 처리가 제대로 안되서 
			 $("#writer").val(object.regId);
			 $("#writer").attr("readonly", true); // 작성자 수정불가 
			 
			 $("#reg_date").val(object.reg_date);
			 $("#reg_date").attr("readonly", true); // 처음 작성된 날짜 수정불가 
			 
			 $("#subject").val(object.title);
			 $("#content").val(object.note);
			 //$("#readCnt").val(object.readCnt);
			 //$("#pwd").val(object.pwd);
			 
			 $("#wno").val(object.wno); // 중요한 num 값도 숨겨서 받아온다. 
			 
			 $("#btnDeleteQnA").show(); // 삭제버튼 보이기 
			 $("#btnSaveQnA").hide();
			 $("#btnUpdateQnA").css("display","");
			 //if문써서 로그인 아이디 == 작성자 아이디 일치시  --- 추가하기 
			 //$("#grp_cod").attr("readonly", false);  // false, true(읽기만)로 수정
			 //$("#showComment").val(object2.c_content);
			 $("#showComment").show(); // 코멘트 보이기 
		 }
	 }
	 
	 
	 /* 팝업내 수정, 저장 validation */
	 function fValidatePopup(){
		 var chk = checkNotEmpty(
				 [
					 ["subject", "제목을 입력해주세요!"],
					 ["content", "내용을 입력해주세요!"]
				 ]
		 );
	 
	 	if(!chk){return;}
	 	return true;
	 }
	 
	 /* qna 게시판 등록(저장) */
	 function fSaveQna(){
		 
		 alert("저장 함수 타는지!!!!!?? ");
		 // validation 체크 
		 if(!(fValidatePopup())){ return; }
		 
		 var resultCallback3 = function(data){
			 fSaveQnaResult(data);
		 };
		 
		 $("#action").val("I");  // insert
		 
		 callAjax("/qna/qnaSave.do", "post", "json", true, $("#myQna").serialize(), resultCallback3);
	 	// $("#myQna").serialize() => 직렬화해서 name 값들을 그냥 넘김.
	 }
	 
	 
	 /* 저장 ,수정 콜백 함수 처리  */   
	 function fSaveQnaResult(data){
		 var currentPage = "1"; 
		 
		 if($("#action").val() != "I"){
			 currentPage = $("#currentPage").val();
		 }
		 
		 if(data.resultMsg == "SUCCESS"){
			 alert(data.resultMsg);	// 받은 메세지 출력 
		 }else if(data.resultMsg == "UPDATE") {
			 alert("수정 완료되었습니다.");
		 }else{
			 alert(data.resultMsg); //실패시 이거 탄다. 
		 }
		 
		 gfCloseModal();	// 모달 닫기
		 selectQnaList(currentPage); // 목록조회 함수 다시 출력 
		 frealPopModal();// 입력폼 초기화
	 }
	 
	 /* qna 게시판 등록(수정) */
	 function fUpdateQna(){
		 
		 alert("수정  함수 타는지!!!!!?? ");
		 // validation 체크 
		 if(!(fValidatePopup())){ return; }
		 
		 var resultCallback3 = function(data){
			 fSaveQnaResult(data);
		 };
		 
		 $("#action").val("U");  // update
		 
		 callAjax("/qna/qnaSave.do", "post", "json", true, $("#myQna").serialize(), resultCallback3);
	 	// $("#myQna").serialize() => 직렬화해서 name 값들을 그냥 넘김.
	 }
	 
	 /* Qna 게시판 1건 삭제 */
	 function fDeleteQna(){
		 var con = confirm("정말 삭제하겠습니까? \n 삭제시 복구불가합니다."); 
		 if(con){
			 var resultCallback3 = function(data){
				 fSaveQnaResult(data);
			 }
			 $("#action").val("D");  // delete
			 callAjax("/qna/qnaSave.do", "post", "json", true, $("#myQna").serialize(), resultCallback3);
			 // num만 넘겨도되지만 그냥 귀찮으니깐...^^... 
		 }else{
			 gfCloseModal();	// 모달 닫기
			 selectQnaList(currentPage); // 목록조회 함수 다시 출력 
			 frealPopModal();// 입력폼 초기화
		 }
	 }
	 
	 
	 /* 댓글 저장하기 */
	function fCommentInsert(){
		
		alert("댓글 함수 타죠?? "); 
		alert("찍어보자 넘값" + $("#wno").val());   
		 
		// validation 체크  만들기 
		 var resultCallback3 = function(data){
			 fCommentSave(data);
		 };
		 
		$("#action").val("C");  // comments Insert
		 
		 callAjax("/qna/qnaSave.do", "post", "json", true, $("#myQna").serialize(), resultCallback3);
	 }
	 
	 /* 댓글 저장 콜백함수  */
	 function fCommentSave(data){
		 alert("저장이 완료되었습니다!"  + data);
	 }
	 
</script>


</head>
<body>
	<!-- ///////////////////// html 페이지  ///////////////////////////// -->

<form id="myQna" action="" method="">
	
	<input type="hidden" id="currentPage" value="1">  <!-- 현재페이지는 처음에 항상 1로 설정하여 넘김  -->
	<input type="hidden" id="tmpList" value=""> <!-- ★ 이거뭐임??? -->
	<input type="hidden" id="tmpListNum" value=""> <!-- 스크립트에서 값을 설정해서 넘길거임 / 임시 리스트 넘버 -->
	<input type="hidden" name="action" id="action" value=""> <!-- 이것은 무엇에 쓰는 물건인고? -->
	<input type="hidden" id="swriter" value="${writer}"> <!-- 작성자 session에서 java에서 넘어온값 -->

	<div id="wrap_area">

		<h2 class="hidden">header 영역</h2>
		<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

		<h2 class="hidden">컨텐츠 영역</h2>
		<div id="container">
			<ul>
				<li class="lnb">
					<!-- lnb 영역 --> 
					<jsp:include page="/WEB-INF/view/common/lnbMenu.jsp"></jsp:include> <!--// lnb 영역 -->
				</li>
				<li class="contents">
					<!-- contents -->
					<h3 class="hidden">contents 영역</h3> <!-- content -->
					<div class="content">

						<p class="Location">
							<a href="#" class="btn_set home">메인으로</a> 
							<a href="#" class="btn_nav">자료실</a> 
								<span class="btn_nav bold">QnA</span> 
								<a href="#" class="btn_set refresh">새로고침</a>
						</p>

						<p class="conTitle">
							<span>QnA 게시판 </span> <span class="fr"> 
								<c:set var="nullNum" value=""></c:set>
								<a class="btnType blue" href="javascript:fQnaModal(${nullNum});" name="modal">
								<span>신규등록</span></a>
							</span>
						</p>
						
						<div class="divComGrpCodList">
							<table class="col">
								<caption>caption</caption>
	
								<thead>
									<tr>
							              <th scope="col">순번</th>
							              <th scope="col">상위글</th>
							              <th scope="col">작성자</th>
							              <th scope="col">제목</th>
							              <th scope="col">본문</th>
							              <th scope="col">등록일</th>
						              	  <!-- <th scope="col">조회 수</th> -->
							              <th scope="col">조회</th>
									</tr>
								</thead>
								<!-- <tbody id="listComnGrpCod"></tbody> -->
								<!-- ** 이자리에 뿌릴 겁니다. ** -->	
								<tbody id="qnaList"></tbody>
							</table>
							
							<!-- 페이징 처리  -->
							<div class="paging_area" id="pagingnavi">
								<div class="paging">
									<a class="first" href="javascript:selectQnaList(1)">
									<span class="hidden">맨앞</span></a>
									<a class="pre" href="javascript:selectQnaList(1)">
									<span class="hidden">이전</span></a>
									<strong>1</strong> 
									<a href="javascript:selectQnaList(2)">2</a> 
									<a href="javascript:selectQnaList(3)">3</a> 
									<a href="javascript:selectQnaList(4)">4</a>
									<a class="next" href="javascript:selectQnaList(4)">
									<span class="hidden">다음</span></a>
									<a class="last" href="javascript:selectQnaList(4)">
									<span class="hidden">맨뒤</span></a>
								</div>
							</div>
											
						</div>

		
					</div> <!--// content -->

					<h3 class="hidden">풋터 영역</h3>
						<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
				</li>
			</ul>
		</div>
	</div>


	<!-- 모달팝업 -->
	<div id="layer1" class="layerPop layerType2" style="width: 600px;">
		<input type="hidden" id="wno" name="wno"> <!-- 수정시 필요한 num 값을 넘김  -->
		
		<dl>
			<dt>
				<strong>큐엔에이 상세보기 </strong>
			</dt>
			<dd class="content">
				<!-- s : 여기에 내용입력 -->
				<table class="row">
					<caption>caption</caption>

					<tbody>
						<tr>
							<th scope="row">작성자 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="writer" id="writer" /></td>
							<th scope="row">작성일<span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100" name="reg_date" id="reg_date" /></td>
						</tr>
						<tr>
							<th scope="row">제목 <span class="font_red">*</span></th>
							<td colspan="3"><input type="text" class="inputTxt p100"
								name="subject" id="subject" /></td>
						</tr>
						<tr>
							<th scope="row">내용</th>
							<td colspan="3">
								<textarea class="inputTxt p100" name="content" id="content">
								</textarea>
							</td>
						</tr>
						<!-- 패스워드  -->
						<tr>
							<th scope="row">패스워드 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100"
								name="pwd" id="pwd" /></td>
							<th scope="row">조회수 <span class="font_red">*</span></th>
							<td><input type="text" class="inputTxt p100"
								name="readCnt" id="readCnt" /></td>
						</tr>
					</tbody>
				</table>

				<!-- e : 여기에 내용입력 -->

				<div class="btn_areaC mt30">
					<a href="" class="btnType blue" id="btnSaveQnA" name="btn"><span>저장</span></a> 
					<a href="" class="btnType blue" id="btnUpdateQnA" name="btn" style="display:none"><span>수정</span></a> 
					<a href="" class="btnType blue" id="btnDeleteQnA" name="btn"><span>삭제</span></a> 
					<a href=""	class="btnType gray"  id="btnClose" name="btn"><span>취소</span></a>
				</div>
			</dd>
			
			<dd> <!-- comments 댓글 -->
				<div id="comments">
					<div class="input-group" role="group" aria-label="..." style="margin-top: 10px; width: 100%;">
					    <textarea class="form-control" rows="3" id="commentContent" name="commentContent" placeholder="댓글을 입력하세요." style="width: 100%;" ></textarea>
					    <div class="btn-group btn-group-sm">
				            <!-- <a href=""> 
				            <input type="button" class="btn btn-default" value="댓글 쓰기" id="commentWrite" name="btn"></a>
					        <a href="">  -->
					        <%-- <input type="button" class="btn btn-default" value="댓글 읽기(${article.commentCount})"  name="btn"
					                onclick="getComment(1, event)" id="commentRead"></a> --%>
					   		
					   		<a href=""	class="btn btn-default"  id="commentWrite" name="btn"><span>댓글 쓰기</span></a>
					   		<a href=""	class="btn btn-default"  id="commentRead" name="btn"><span>댓글 읽기</span></a>
					    </div>
					</div>
					 
					<!-- Comment 태그 추가 -->
					<div class="input-group" role="group" aria-label="..." style="margin-top: 10px; width: 100%;">
					    <div id="showComment" style="text-align: center;"></div>
					</div>
				</div>
			</dd>
		</dl>
		<a href="" class="closePop"><span class="hidden">닫기</span></a>
	</div>





</form>

</body>
</html>




