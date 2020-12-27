$(document).on('click','.delete-comment',function(e){

	e.preventDefault();
	const commentId = e.target.value;
	console.log("in delete-comment js: "+commentId);

	$.ajax({
		type : "POST",
		url : "/admin/comment/delete/"+commentId,
		
		success : function(result)
		{
			if (result == "success")
			{
				console.log("comment deleted successfully!!!");
				$("#card-"+commentId).remove();
			} else
			{
				console.log("something went wrong!!!");
			}
		//alert(result);
		},
		error : function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});

	return false;

});