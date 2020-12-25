$(document).on('click','.delete-post',function(e){

	e.preventDefault();
	const postId = e.target.value;
	console.log("in delete-post js: "+postId);

	$.ajax({
		type : "POST",
		url : "/user/community/post/delete/"+postId,
		
		success : function(result)
		{
			if (result == "success")
			{
				console.log("post  deleted successfully!!!");
				$("#card-"+postId).remove();
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