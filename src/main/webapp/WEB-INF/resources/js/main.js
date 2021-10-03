$(document).ready(function() {
	$('select').niceSelect();

	$('#searchbox').on("keydown", function search(e) {
		if (e.keyCode == 13) {
			window.location.href = "/search?searchTerm=" + $(this).val();
		}
	});
});