/**
 * 
 */
$(function() {
	$('#btn-save').on('click',function() {
		var article = {
				bSubject: $('#txt-title').val(),
				bContent: $('#txt-contents').val()
		};
		$.ajax({
			url: '/board/pro',
			method: 'POST',
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(article),
			success: function() {
				location.href = '/';
			}
		});
	});
});