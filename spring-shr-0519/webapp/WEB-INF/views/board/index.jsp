<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<script src="https://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function boardPublic(){
		alert('권한 없음. 비공개 글입니다.');
	}
	
</script>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		
		<div id="content">
			<div id="board">
				<h1>질문 게시판 </h1>
				<form id="search-form" method="get" action="${pageContext.request.contextPath}/board">
					<input type="text" id="kwd" name="kwd" value="${map.keyword }">
					<input type="submit" value="검색">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${map.list}" var ="vo" varStatus="status">
						<tr>
							<td>${map.totalCount - (map.currentPage -1) * map.listSize - status.index }</td>
							<c:choose>
								<c:when test="${vo.boardPublic == 0 }">
									<c:choose>
										<c:when test="${vo.depth > 0}">
										<td class="left" style="padding-left: ${15*vo.depth}px">
											<img src="${pageContext.request.contextPath }/assets/images/reply.png">
											<c:choose>
												<c:when test="${authUser.usersNo == vo.usersNo || authUser.usersType == 'admin' }">
													<a href=
													"${pageContext.request.contextPath }/board/view?no=${vo.no}&p=${map.currentPage}&kwd=${map.keyword}">  
													 ${vo.title} </a>
												</c:when>
												<c:otherwise>
													<a href="" onclick="boardPublic()">
													 비공개 글입니다. </a>
												</c:otherwise>
											</c:choose>
											</td>
										</c:when>
										
										<c:otherwise>
											<td class="left">
												<c:choose>
													<c:when test="${authUser.usersNo == vo.usersNo || authUser.usersType == 'admin' }">
														<a href="${pageContext.request.contextPath }/board/view?no=${vo.no}&p=${map.currentPage}&kwd=${map.keyword}"> ${vo.title} </a>
													</c:when>
													<c:otherwise>
														<a href="" onclick="boardPublic()">비공개 글입니다. </a>
													</c:otherwise>
											</c:choose>
											</td>
										</c:otherwise>
									</c:choose>
								</c:when>	
									
									<c:otherwise>
										<c:choose>
										<c:when test="${vo.depth > 0}">
										<td class="left" style="padding-left: ${15*vo.depth}px">
											<img src="${pageContext.request.contextPath }/assets/images/reply.png">
											<c:choose>
												<c:when test="${authUser.usersNo == vo.usersNo || authUser.usersType == 'admin' }">
													<a href="${pageContext.request.contextPath }/board/view?no=${vo.no}&p=${map.currentPage}&kwd=${map.keyword}"> ${vo.title} </a>
												</c:when>
												<c:otherwise>
													<a href="${pageContext.request.contextPath }/board/view?no=${vo.no}&p=${map.currentPage}&kwd=${map.keyword}" > ${vo.title} </a>
												</c:otherwise>
											</c:choose>
											</td>
										</c:when>
										
										<c:otherwise>
											<td class="left">
												<c:choose>
													<c:when test="${authUser.usersNo == vo.usersNo || authUser.usersType == 'admin' }">
														<a href="${pageContext.request.contextPath }/board/view?no=${vo.no}&p=${map.currentPage}&kwd=${map.keyword}"> ${vo.title} </a>
													</c:when>
													<c:otherwise>
														<a href="${pageContext.request.contextPath }/board/view?no=${vo.no}&p=${map.currentPage}&kwd=${map.keyword}" > ${vo.title} </a>
													</c:otherwise>
											</c:choose>
											</td>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							
							</c:choose>
										
									<td>${vo.userName}</td>
									<td>${vo.hit }</td>
									<td>${vo.regDate }</td>
								</tr>			
					</c:forEach>
				</table>
				
				<div class="pager">
					<ul>
						<c:if test="${map.prevPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/board?
								p=${map.prevPage }&kwd=${map.keyword}"> ◀ </a></li>
						</c:if>
						
						<c:forEach begin="${map.beginPage }" end="${map.beginPage + map.listSize -1 }" var="page">
							<c:choose>
								<c:when test="${map.endPage < page }">
									<li>${page}</li>
								</c:when>
								<c:when test="${map.currentPage == page }">
									<li class="selected" > ${page }</li>
								</c:when>
								<c:otherwise>
									<li><a href="${pageContext.request.contextPath}/board?p=${page}&kwd=${map.keyword}">${page}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${map.nextPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/board?
								p=${map.nextPage }&kwd=${map.keyword}"> ▶  </a></li>
						</c:if>
					</ul>
				</div>
				
				<div class="bottom" style="padding-bottom: 25px;">
					<c:if test="${ not empty authUser }">
						<a href="${pageContext.request.contextPath }/board/write" id="new-book">글쓰기</a>
					</c:if>
				</div>
				
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
			<c:param name="menu" value="board" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>