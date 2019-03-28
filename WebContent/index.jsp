<jsp:include page="header.html" />
<h1> Hello there, Get your Hot Chocolate!<br> Cause we are going to play TicTacToe </h1>
<form class="form-horizontal" action="start" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="rows">How many Rows ?</label>
    <div class="col-sm-10">
      <input type="number" max="12" min="3" class="form-control" id="rows" name="rows" placeholder="Rows Counts">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="cols">How many Columns?</label>
    <div class="col-sm-10"> 
      <input type="number" max="12" min="3" class="form-control" name="cols" id="cols" placeholder="Columns Counts">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Let's Get started</button>
    </div>
  </div>
</form>

<jsp:include page="footer.html" />