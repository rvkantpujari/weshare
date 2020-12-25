$(document).on('click', '.unsave-post', function(event) {
	event.preventDefault();
	const postId = event.target.value;
	var unsaveButtonClasses = event.target.classList;
	console.log("unsaveButtonClasses: " + unsaveButtonClasses);
	console.log("in unsave post: " + postId);
	
	$.ajax({
		type: "POST",
		url: "/user/post/" + postId + "/unsave",

		success: function(result)
		{
			if (result == "success")
			{
				console.log("post unsaved successfully!!!");
				event.target.classList.remove("unsave-post");
				event.target.classList.add("save-post");
				event.target.classList.remove("fa-bookmark");
				event.target.classList.add("fa-bookmark-o");
				event.target.innerHTML = "Save";
			} else
			{
				console.log("something went wrong!!!");
			}
			//alert(result);
		},
		error: function(e)
		{
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});
});