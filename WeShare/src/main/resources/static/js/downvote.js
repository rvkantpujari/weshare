function downvote(postId, event)
{
	console.log("post id: ",postId);
	var buttonClasses = event.classList;
	console.log(buttonClasses.contains("text-red"));
	$.ajax({
		type : "POST",
		url : "/downvote",
		data : {
			postId: postId
		},
		success : function(result)
		{
			if (result == "success")
			{
				
				if(buttonClasses.contains("text-red"))
				{
					event.classList.remove("text-red");
					event.classList.add("text-muted");
				}
				else if(buttonClasses.contains("text-muted"))
				{
					event.classList.add("text-red");
					event.classList.remove("text-muted");
				}
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