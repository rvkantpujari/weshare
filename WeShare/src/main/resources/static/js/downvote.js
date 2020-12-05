function downvote(postId)
{
	console.log("post id: ",postId);

	$.ajax({
		type : "POST",
		url : "/user/community/downvote",
		data : {
			postId: postId
		},
		success : function(result)
		{
			if (result == "success")
			{
				console.log("downvoted successfully!!!");
			} else {
				console.log("downvote  unsuccessfully!!!");
			}
		alert(result);
		},
		error : function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});
}	