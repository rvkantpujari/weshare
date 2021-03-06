$(document).on('click', '.joinCommunityBtn', function(event) {
	event.preventDefault();
	const communityName = event.target.value;
	var communityMembersCount = document.getElementById("communityMembersCount");
	var currentCommunityMembersCount = parseInt(communityMembersCount.textContent);
	console.log("in join  community: " + communityName);
	$.ajax({
		type: "POST",
		url: "/user/community/" + communityName + "/join",

		success: function(result)
		{
			if (result == "success")
			{
				console.log("community joined successfully!!!");
				event.target.classList.remove("btn-success");
				event.target.classList.add("btn-danger");
				event.target.classList.remove("joinCommunityBtn");
				event.target.classList.add("leaveCommunityBtn");
				event.target.innerHTML = "Leave";
				communityMembersCount.textContent = currentCommunityMembersCount + 1;
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