<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript">


function deleteFile(pNo) {
    var checkArr = [];    
    
    $("input[name=deleteFileName]:checked").each(function() {
    	checkArr.push($(this).val());     
    });
 
    $.ajax({
        url: '${pageContext.request.contextPath}/product/deletefile'
        , type: 'post'
        , dataType: 'text'
        , data: {
            deleteFileName : checkArr,
            productNo : pNo
        },success : function(data){
        	alert('삭제 완료');
        	window.location.href= '${pageContext.request.contextPath}/product/view?productNo=' + pNo;
        }
    });
    
}
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		
		<div id="content">
			<div id="board">
				<h1>상품 정보 수정</h1>
				<form id="search-form" method="post"  enctype="multipart/form-data"
					action="">
					<table class="tbl-ex">
						<tr>
							<td style="width:100px;" class="label">상품명</td>
							<td><input type="text" name="productName" value="${vo.productName}" style=" float: left; width: 310px;"></td>
							<td><input type="hidden" name ="productNo" value="${vo.productNo }"> </td>
						</tr>
						<tr>
							<td style="width:100px;" class="label">수량</td>
							<td><input type="text" name="productCount" value="${vo.productCount }" style=" float: left; width: 310px;"></td>
							<td></td>
						</tr>
						<tr>
							<td style="width:100px;" class="label">가격</td>
							<td><input type="text" name="productPrice" value="${vo.productPrice }" style=" float: left; width: 310px;"></td>
						</tr>
						<tr>
							<td style="width:100px;"  class="label">상세 설명</td>
							<td>
								<textarea id="content" name="productComment" 
								style=" float: left; width:300px; height:50px; 
								padding: 10px; resize: none; outline: none; ">${vo.productComment}</textarea>
								
							</td>
							<td></td>
						</tr>
						<tr>
							<td style="width:100px;"  class="label">사진</td>
							<td height = "0"  >
								<c:forEach items="${imageList }" var="vo" varStatus="status">
									<div style = "float:left; height:50%; padding-right: 10px;">
										<input type="checkbox" id="deleteFileName" name="deleteFileName" value="${vo.saveFileName}" >
										
										<img src="${pageContext.request.contextPath}/upload/${vo.saveFileName}" 
											style="width:100px; height: 100px; ">
									</div>
								</c:forEach>
							</td> 
							<td>
								<input type="submit" value="삭제" 
									onclick="deleteFile('${vo.productNo}')">
							</td>
						</tr>
						<tr>
							<td style="width:100px;" class="label">첨부파일</td>
							<td><input type="file" name="file" size="40" style="float: left;" value=""/></td>
							<td></td>
						</tr>
					
					</table>
					
					<input type="submit" value="수정" formaction="${pageContext.request.contextPath}/product/view"  style="padding: 10px; width: 100px;">	
					<input type="submit" value="삭제" formaction="${pageContext.request.contextPath}/product/delete"  style="padding: 10px; width: 100px;">	
				</form>
				
				
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
			<c:param name="menu" value="product" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>