function upvote(postId)
{
	console.log("post id: ",postId);

	$.ajax({
		type : "POST",
		url : "/user/community/upvote",
		data : {
			postId: postId
		},
		success : function(result)
		{
			if (result == "success")
			{
				console.log("upvoted successfully!!!");
			} else {
				console.log("upvote  unsuccessfully!!!");
			}
		alert(result);
		},
		error : function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});
}	