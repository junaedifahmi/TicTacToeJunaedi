<jsp:include page="header.html" />
<%
int cols = (int) session.getAttribute("cols");
int rows = (int) session.getAttribute("rows");
int[][] boards = (int[][]) session.getAttribute("board");
String value = "";
%>
<h1> Now <%= ((int)session.getAttribute("player") ==1)? "O" :"X" %> turn! </h1>
<table class="table">
<%
for(int i = 0; i < cols; i++){ %>
	<tr>
	<% for(int j =0; j < rows; j++){
		String disabled="disabled";
		if (boards[i][j] == 1){
			value="O";
		}
		else if (boards[i][j] == 2){
			value="X";
		}
		else{
			value="&nbsp";
			disabled="";
		} %>
		<td> <button class="btn" id="<%=i%> <%=j%>"  <%=disabled%> onclick="change_txt(this.id)" > <%=value %> </button> </td>
	<% } %>
	<tr>
<%}%>
</table>

<form method="post" action="game" id="form">
	<input type hidden="true" name="position" value="" id="position">
</form>

<script type="text/javascript">
<% if((int) session.getAttribute("winner") != 0){ %>
function myFunc(){
	window.alert("Congratulation for the wining,  <%= ((int)session.getAttribute("player") ==1)? "O" :"X" %> ")
}
	
<%}%>
function change_txt(id){
	var btn = document.getElementById(id);
	console.log(id);
	btn.innerHTML="X";
	btn.disabled=true;
	console.log(btn.value);
	document.getElementById("position").value = id;
	document.getElementById("form").submit();
}
</script>
<jsp:include page="footer.html" />