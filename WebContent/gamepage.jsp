<jsp:include page="header.html" />

<%
if(request.getAttribute("board") == null){
	int cols =  Integer.parseInt(request.getParameter("cols"));
	int rows =  Integer.parseInt(request.getParameter("rows"));
	request.setAttribute("cols", cols);
	request.setAttribute("rows", rows);
	for(int i=0; i < cols;i+=1){
		for(int j=0; j < rows;j+=1){ %>
			<button value="<%=i%> <%=j%>" class="btn" onclick="change_txt(this.id)" id="<%=i%> <%=j%>" > </button>
		<% } %>
	<br>
	<% } 
} else{
	int[][] board = (int[][]) request.getAttribute("board");
	for(int x =0; x < length(board[0]);x+=1){
		
	}
}
%>














































<%

for(int i=0; i < cols;i+=1){ %>
		<% for(int j=0; j < rows;j+=1){ %>
			<button value="<%=i%> <%=j%>" class="btn" onclick="change_txt(this.id)" id="<%=i%> <%=j%>" > </button>
	<% } %>
	<br>
	<% } %>

<form method="post" action="game" id="form">
	<input type hidden="true" name="position" value="" id="position">
</form>

<script type="text/javascript">
function effect(btn){
	btn.innerHTML="X";
	btn.disabled=true;
}
function change_txt(id){
	var btn = document.getElementById(id);
	effect(btn);
	document.getElementById("position").value = id;
	document.getElementById("form").submit();
}
</script>

<jsp:include page="footer.html" />