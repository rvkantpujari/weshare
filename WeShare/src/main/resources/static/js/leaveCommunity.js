$(document).on('click', '.leaveCommunityBtn', function(event) {
	event.preventDefault();
	const communityName = event.target.value;
	var communityMembersCount = document.getElementById("communityMembersCount");
	var currentCommunityMembersCount = parseInt(communityMembersCount.textContent);
	console.log("in leave  community: " + communityName);
	$.ajax({
		type: "POST",
		url: "/user/community/" + communityName + "/leave",

		success: function(result)
		{
			if (result == "success")
			{
				console.log("community leaved successfully!!!");
				event.target.classList.remove("btn-danger");
				event.target.classList.add("btn-success");
				event.target.classList.remove("leaveCommunityBtn");
				event.target.classList.add("joinCommunityBtn");
				event.target.innerHTML = "Join";
				communityMembersCount.textContent = currentCommunityMembersCount - 1;
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