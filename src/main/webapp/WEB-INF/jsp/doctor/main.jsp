<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("newline", "\n"); %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" content="text/html">
	<meta http-equiv="Content-Script-Type" content="text/javascript">
	<meta http-equiv="Content-Style-Type" content="text/css">
	<link rel="shortcut icon" href="/resources/img/logo.png">
	<title>충북대학교 병원</title>
	<link rel="stylesheet" type="text/css" href="/css/normalize.css">
	<link rel="stylesheet" type="text/css" href="/css/layout.css">
	<link rel="stylesheet" type="text/css" href="/css/font.css">
</head>

<script type="text/javascript">
	function removeRow(obj){
		$(obj).parent().parent().remove();
	}

	function searchPatient(){
		window.open("<c:url value="/doctor/searchPatient"/>?page=0&max=20"+"width=1000px, height=800");
	}
</script>
<body >
<!-- wrap :s -->
	<div id="wrapper">
		<!-- header :s -->
		<div id="headerWrap">
			<c:import url="../common/prescription/header.jsp"/>
		</div>
		<!-- header :e -->
		<!-- contentsWrap :s -->
		<div id="contentsWrap">
			<!-- container :s -->
				<div id="lnbWrap">
				<div id="lnb_title">
					<h2>환자 목록</h2>
				</div>
				<c:import url="../common/prescription/submenu.jsp"/>
			</div>
			<div id="container">
				<!-- 컨텐츠영역 txt :s -->
				<div id="txt">

		            <span class="rightButton">
		            	<input type="button" value="환자 추가" class="subbtn2" onclick="searchPatient()">
		            </span>
					<br>
					<div class="tableDiv">
					<h4 class="subtitle">환자 리스트</h4>
					<!-- table :s -->
					<table class="tbl_basic center" id="prohibitionTable" style="table-layout:fixed;">
			            <caption>
			                <strong>환자 리스트</strong>
			                <details>
			                    <summary>환자 목록</summary>
			                </details>
			            </caption>
		                <thead>
		                    <tr>
								<th class="trw">번호</th>
								<th class="trw">환자 이름</th>
								<th class="trw">환자 아이디</th>
								<th class="trw">가입일</th>
		                    </tr>
		                </thead>
		                <tbody id ="prohibitionTableBody">
		                	<c:forEach var="prohibition" items="${ATCHashMapList.prohibitionList}">
							<tr>
								<td name="prohibitionCode"><c:out value="${prohibition.ATCCode }"/></td>
								<td><c:out value="${prohibition.ATCName }"/></td>
								<td>
									<input name="deleteChangeProhibition" type="button" value="삭제" class="btn_save" onclick="deleteChangeProhibitionTolerableUpper('<c:out value="${prohibition.ATCID}"/>',this,'<c:out value="${prohibition.ATCCode}"/>')">
								</td>
		                   	</tr>
		                   	</c:forEach>
		                </tbody>
		            </table>
		            <!-- table :e -->
					<!-- 컨텐츠영역 txt :e -->
				</div>
				<!-- container :e -->
			</div>
			<!-- contentsWrap :e -->

		<!-- footerWrap :s -->
		<div id="footerWrap">
			<c:import url="../common/footer.jsp"/>
		</div>
		<!-- footerWrap :e -->
		</div>
</body>
</html>