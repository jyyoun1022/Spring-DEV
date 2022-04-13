<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<%@include file="../includes/header.jsp" %>
	<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify</div>
		<div class="panel-body">
				
				<form role="form" action="/board/modify" method="post">
				
				<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
		        <input type='hidden' name='amount' value='<c:out value="${cri.size }"/>'>
			 
				
				
						<div class="form-group">
					<label>Bno</label>
					<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' >
					
				</div>
			
				<div class="form-group">
					<label>Title</label>
					 <input class="form-control" name='title' value='<c:out value="${board.title}"/>'> 
				</div>
				
				<div class="form-group">
					<label>Content</label>
					<textarea class="form-control" rows="3" name="content" ><c:out value="${board.content}"/></textarea>
				</div>
				
				<div class="form-group">
					<label>Writer</label>
					<input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly >
				</div>
				<div class="form-group">
            		<label><b>regDate</b></label>
            		<input  class="form-control"  value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regDate}" />' readonly/>
            		<div class="form-group">
            		<label><b>modDate</b></label>
            		<input  class="form-control"   value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.modDate}" />' readonly>
        		</div>
        		</div>
						
						<button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
						<button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
						<button type="submit" data-oper="list" class="btn btn-info">Go To List</button>
						
				</form>
		
				
		</div>
		</div>		
		</div>
		</div>
						
		
		
				<%@include file="../includes/footer.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		
		var formObj = $("form");
		
		$("button").on("click",function(e){
			
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			console.log(operation);
			
			if(operation === 'remove'){
				formObj.attr("action","/board/remove");
			}else if(operation === 'list'){
				formObj.attr("action","/board/list").attr("method","get");
				var pageNumTag = $("input[name="pageNum"]").clone();
				var sizeTag = $("input[name="size"]").clone();
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(sizeTag);
			}
			formObj.submit();
		});
	});
</script>				