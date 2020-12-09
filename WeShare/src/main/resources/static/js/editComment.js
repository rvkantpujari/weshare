$(document).on('click','.editCommentBtn',function(e){

	e.preventDefault();
	const commentId = e.target.value;
	const newContent = document.getElementById("editCommentTextArea-"+commentId).value;
	// console.log(commentId);
	// console.log(newContent);

	$.ajax({
		type : "POST",
		url : "/user/comment/update",
		data : {
			commentId: commentId,
			commentDescription: newContent
		},
		success : function(result)
		{
			if (result == "success")
			{
				console.log("comment saved successfully!!!");
				$("#showCommentContent-"+commentId).text(newContent);
				$('#editCommentForm-'+commentId).hide();
		        $('#viewCommentId-'+commentId).show();
		        $('#3-dots-btn-'+commentId).show(100);
			} else
			{
				console.log("something went wrong!!!");
			}
		//alert(result);
		},
		error : function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});

	return false;

});


// function submitEditCommentForm(commentId, e)
// {
// 	e.preventDefault();
//   alert(e);
//   //"/user/comment/update"
//   $("#saveCommentBtn"+commentId).click(function(e) {
//         e.stopImmediatePropagation();
//         alert("asdasdad");
//         return false;
//     });

//   return false;
// }
      
