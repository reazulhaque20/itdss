<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
$(window).load(function() {
	$('#unauthorizedModal').modal('show');
}); 
</script>
</head>
<body>
	  <!-- Modal -->
  <div class="modal fade" id="unauthorizedModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Un-Authorized..</h4>
        </div>
        <div class="modal-body">
         <img src="resources/images/noaccess.jpg" class="img-responsive" alt="Cinque Terre" width="100%" height="100%">
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
	

</body>
</html>