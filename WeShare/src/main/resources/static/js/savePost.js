$(document).on('click', '.save-post', function(event) {
	event.preventDefault();
	const postId = event.target.value;
	console.log("in save post: " + postId);
	var saveButtonClasses = event.target.classList;
	console.log("saveButtonClasses: " + saveButtonClasses);
	$.ajax({
		type: "POST",
		url: "/user/post/" + postId + "/save",

		success: function(result)
		{
			if (result == "success")
			{
				console.log("post saved successfully!!!");
				event.target.classList.remove("save-post");
				event.target.classList.add("unsave-post");
				event.target.classList.remove("fa-bookmark-o");
				event.target.classList.add("fa-bookmark");
				event.target.innerHTML = "Unsave";
			} else
			{
				console.log("something went wrong!!!");
			}
			//alert(result);
		},
		error: function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});
});