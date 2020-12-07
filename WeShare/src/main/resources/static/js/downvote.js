function downvote(postId, event)
{
	var upvoteBtn = document.getElementById("upvote"+postId);
	var upvoteBtnClasses = upvoteBtn.classList;
	var downvoteBtnClasses = event.classList;
	var scoreBtn = document.getElementById("score"+postId);
	var currentScore = parseInt(scoreBtn.textContent);
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
				
				if(downvoteBtnClasses.contains("text-red"))
				{
					event.classList.remove("text-red");
					event.classList.add("text-muted");
					scoreBtn.textContent = currentScore + 1;
				}
				else if(downvoteBtnClasses.contains("text-muted"))
				{
					event.classList.add("text-red");
					event.classList.remove("text-muted");
					scoreBtn.textContent = currentScore - 1;
				}
				if(upvoteBtnClasses.contains("text-green"))
				{
					upvoteBtn.classList.remove("text-green");
					upvoteBtn.classList.add("text-muted");
					scoreBtn.textContent = currentScore - 2;
				}
				console.log("downvoted successfully!!!");
			} else {
				console.log("downvote  unsuccessfully!!!");
			}
		//alert(result);
		},
		error : function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});
}	