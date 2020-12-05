function upvote(postId, event)
{
	console.log("post id: ",postId);
	var buttonClasses = event.classList;
	console.log(buttonClasses.contains("text-red"));
	$.ajax({
		type : "POST",
		url : "/upvote",
		data : {
			postId: postId
		},
		success : function(result)
		{
			if (result == "success")
			{
				if(buttonClasses.contains("text-green"))
				{
					event.classList.remove("text-green");
					event.classList.add("text-muted");
				}
				else if(buttonClasses.contains("text-muted"))
				{
					event.classList.add("text-green");
					event.classList.remove("text-muted");
				}
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