function bindCreateProductSubmit() {
	$(".create-product").on('click', function(e) {
		e.preventDefault();

		var data = {};
		data.code = $('input[name="code"]').val();

		$.ajax({
			type : "POST",
			url : '/adminproduct/create',
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				window.location.href = data;
			},
		});
	});
}

$('document').ready(function() {
	bindCreateProductSubmit();
});
