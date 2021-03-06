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
			<div class="panel-heading">Board Read</div>
		<div class="panel-body">
		
		
				
				<div class="form-group">
					<label>Bno</label>
					<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
					
				</div>
			
				<div class="form-group">
					<label>Title</label>
					 <input class="form-control" name='title' value='<c:out value="${board.title}"/>' readonly="readonly"> 
				</div>
				
				<div class="form-group">
					<label>Content</label>
					<textarea class="form-control" rows="3" name="content" readonly="readonly"><c:out value="${board.content}"/></textarea>
				</div>
				
				<div class="form-group">
					<label>Writer</label>
					<input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly="readonly">
				</div>
				<div>
				<div class="form-group">
            		<label><b>regDate</b></label>
            		<input  class="form-control"   value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.modDate}" />' readonly>
            		<div class="form-group">
            		<label><b>modDate</b></label>
            		<input  class="form-control"   value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.modDate}" />' readonly>
        		</div>
				</div>
				<button data-oper='modify' class="btn btn-default" >Modify</button>
				<button data-oper='list' class="btn btn-info" >Go To List</button>

				<form id="operForm" action="/board/modify"	method="get">
					<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno }"/>'>
					<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
					<input type="hidden" name="size" value='<c:out value="${cri.size}"/>'>
				</form>
				
				</div>
				
			
				
		</div>
		</div>
		</div>
		
		
		
				<%@include file="../includes/footer.jsp" %>
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click",function(e){
			
			operForm.attr("action","/board/modify").submit();
			
			
			
		});
	$("button[data-oper='list']").on("click",function(e){
		
		operForm.find("#bno").remove();
		operForm.attr("action","/board/list").submit();
	});
	
	
	
		console.log(replyService)	;
		
	console.log("===============");
	console.log("JS TEST");

	var bnoValue = '<c:out value="${board.bno}"/>';

	//for replyService add test
	 replyService.add(
	    
	    {reply:"JS Test", replyer:"tester", bno:bnoValue}
	    ,
	    function(result){ 
	      alert("RESULT: " + result);
	    }
	);
				
	});
</script>				
