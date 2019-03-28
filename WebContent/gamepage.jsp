<jsp:include page="header.html" />
<%
int cols =  Integer.parseInt(request.getParameter("cols"));
int rows =  Integer.parseInt(request.getParameter("rows"));

%>
	<% for(int i=0; i <cols;i+=1){ %>
		<% for(int j=0; j < rows;j+=1){ %>
			<button value="<%=i%> <%=j%>" class="btn" onclick="change_txt(this.id)" id="<%=i%> <%=j%>" > </button>
	<% } %>
	<br>
	<% } %>

<form method="post" action="game" id="form">
	
	<input type hidden="true" name="position" value="" id="position">
</form>

<script type="text/javascript">
function change_txt(id){
	var btn = document.getElementById(id);
	btn.innerHTML="X";
	btn.disabled=true;
	console.log(btn.value);
	
	document.getElementById("position").value = id;
	document.getElementById("form").submit();
}
</script>
<jsp:include page="footer.html" />