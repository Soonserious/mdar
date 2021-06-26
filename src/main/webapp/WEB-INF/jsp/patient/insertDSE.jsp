<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<!-- initial-scale=1.0 : 기본확대 1배율 , user-scalable=no : 사용자확대,축소불가  -->
<meta name="viewport" content="width=device-width"> <!-- 디바이스 크기에 일치시킴 -->
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href=""/css/default.css"">
<link rel="stylesheet" type="text/css" href="/css/font.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="<c:url value="/js/jquery.validate.min.js"/>"></script>
<script src="<c:url value="/js/submenu.js"/>"></script>
<script src="https://unpkg.com/hangul-js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#searchButton").click(function(){
			if($("#searchValue").val() ==""){
				alert("검색어를 바르게 입력하세요(공백X).");
				return false;
			}
			$("#searchMedicine").submit();
		});


	});
	$(document).on("keypress","#relivedKeyword",function(){
        dse = Hangul.disassemble(#("#relivedKeyword").val())
        $.ajax({
            url: "/patient/insertAutoDSE", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
            data: { "des": dse }, // HTTP 요청과 함께 서버로 보낼 데이터
            method: "GET", // HTTP 요청 메소드(GET, POST 등)
            dataType: "json"
        }).done(function(json){

        })
	})

	function checkMedicine(code, id){
		$.ajax({
			type:"GET",
			url : "/patient/checkDrug",
			data : {"id" : id},
			dataType : "JSON",
			success: function(json){
				console.log(json);
				console.log("json");
				alert(json.message);
			},
			error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		       }
		});
	}
</script>
</head>
<body>
<!-- wrap :s -->
    <div id="wrap">
        <!-- content :s -->
		<div id="content">
			<div id="searchDiv">
				<form id="searchMedicine" name="searchMedicine" class="search_info" action="/patient/relivedDSE" method="get">
					<input type="hidden" id="relivedKeyword" name="relivedKeyword" value=""/>
					<input type="submit" id="searchButton" name="searchButton" value="검색" class="submitbtn"/>
				</form>
			</div>
		</div>
        <!-- content :e -->
        	<table class="tbl_basic" style="table-layout:fixed;">
                        <thead>
                            <tr>
                                <th class="trw" width="50%" style="word-break:break-all;" wrap="hard">약품 이름</th>
                                <th class="trw" width="50%" style="word-break:break-all;" wrap="hard">약품 성분</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:choose>
                     		<c:when test="${fn:length(medicineList) > 0 }">
        	             		<c:forEach var="medicine" items="${medicineList}">
        						<tr class="medicineList" onclick="checkMedicine('<c:out value="${medicine.itemSeq } "/>','<c:out value="${id} "/>')">
        							<td style="word-break:break-all;" wrap="hard"><c:out value="${medicine.itemName }"/></td>
        							<td style="word-break:break-all;" wrap="hard"></td>
        						</tr>
        						</c:forEach>
                     		</c:when>
                     		<c:otherwise>
                     		<tr>
                     			<td colspan="2">해당 조건의 약제가 검색되지 않습니다. 검색하신 약제의 복용가능 여부를 의사 선생님과 상의해주세요.</td>
                     		</tr>
                     		</c:otherwise>
                     	</c:choose>
                        </tbody>
                    </table>
        <!-- footer :s -->
        <div id="footer">

            <address>
               <!--  <P class="f_logo"><span class="blind">충북대학교병원</span></P> -->
                <p> Copyright  ⓒ  CHUNGBUK NATIONAL UNIVERSITY HOSPITAL. ALL RIGHT</p>
            </address>
        </div>
        <!-- footer :e   -->



    </div>
<!-- wrap :e -->

</body>
</html>