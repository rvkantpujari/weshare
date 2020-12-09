function upvote(postId, event)
{
	var downvoteBtn = document.getElementById("downvote"+postId);
	var downvoteBtnClasses = downvoteBtn.classList;
	var upvoteBtnClasses = event.classList;
	var scoreBtn = document.getElementById("score"+postId);
	var currentScore = parseInt(scoreBtn.textContent);
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
				if(upvoteBtnClasses.contains("text-green"))
				{
					event.classList.remove("text-green");
					event.classList.add("text-muted");
					scoreBtn.textContent = currentScore - 1;
				}
				else if(upvoteBtnClasses.contains("text-muted"))
				{
					console.log("changin up btn to green");
					event.classList.add("text-green");
					event.classList.remove("text-muted");
					scoreBtn.textContent = currentScore + 1;
				}
				if(downvoteBtnClasses.contains("text-red"))
				{
					downvoteBtn.classList.remove("text-red");
					downvoteBtn.classList.add("text-muted");
					scoreBtn.textContent = currentScore + 2;
				}
				console.log("upvoted successfully!!!");
			} else {
				console.log("upvote  unsuccessfully!!!");
			}
		//alert(result);
		},
		error : function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});
}
/*
$('#do-login').click(function(e) {
    var me = $(this);
    e.preventDefault();

    if ( me.data('requestRunning') ) {
        return;
    }

    me.data('requestRunning', true);

    $.ajax({
        type: "POST",
        url: "/php/auth/login.php",
        data: $("#login-form").serialize(),
        success: function(msg) {
            //stuffs
        },
        complete: function() {
            me.data('requestRunning', false);
        }
    });      
}); 
*/