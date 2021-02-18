<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    	
		<div id="page_nav">
			<c:if test="${requestScope.page.pageNo > 1}">
				<a href="${requestScope.page.url }&pageNo=1">首頁</a>
				<a href="${requestScope.page.url }&pageNo=${requestScope.page.pageNo - 1 }">上一頁</a>
			</c:if>
			
			<c:choose>
				<c:when test="${requestScope.page.pageTotal <= 5 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${requestScope.page.pageTotal }"></c:set>
				</c:when>
				
				<c:when test="${requestScope.page.pageTotal > 5 }">
					<c:choose>
						<c:when test="${requestScope.page.pageNo == 1}">
							<c:set var="begin" value="${requestScope.page.pageNo }"></c:set>
							<c:set var="end" value="${requestScope.page.pageNo + 1 }"></c:set>
						</c:when>
											
						<c:when test="${requestScope.page.pageNo <= 3}">
							<c:set var="begin" value="${requestScope.page.pageNo - 1 }"></c:set>
							<c:set var="end" value="${requestScope.page.pageNo + 1 }"></c:set>
						</c:when>
						
						<c:when test="${requestScope.page.pageNo == requestScope.page.pageTotal }">
							<c:set var="begin" value="${requestScope.page.pageNo - 1 }"></c:set>
							<c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
						</c:when>
						
						<c:otherwise>
							<c:set var="begin" value="${requestScope.page.pageNo - 1 }"></c:set>
							<c:set var="end" value="${requestScope.page.pageNo + 1 }"></c:set>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
			
			<c:forEach begin="${begin }" end="${end }" var="i">
				<c:if test="${i == requestScope.page.pageNo }">
					【${i}】
				</c:if>
				
				<c:if test="${i != requestScope.page.pageNo }">
					<a href="${requestScope.page.url }&pageNo=${i }">${i}</a>
				</c:if>
			</c:forEach>

			<c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
				<a href="${requestScope.page.url }&pageNo=${requestScope.page.pageNo + 1 }">下一頁</a>
				<a href="${requestScope.page.url }&pageNo=${requestScope.page.pageTotal }">末頁</a>
			</c:if>			

			共${requestScope.page.pageTotal }頁，${requestScope.page.pageTotalCount }條紀錄 到第<input value="${requestScope.page.pageNo }" name="pn" id="pn_input"/>頁
			<input id="jump" type="button" value="跳頁">
		</div>		
	