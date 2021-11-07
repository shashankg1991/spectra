$(document).ready(function() {
	bindSelects();
	bindSearchbox();
});

function bindSelects() {
	var allSelects = $('select');
	var multiSelects = allSelects.filter('.multiselect');
	var bindedMultiselects = $('.multiselect-native-select>select');
	allSelects.not(multiSelects).niceSelect();
	multiSelects.not(bindedMultiselects).multiselect();
}

function bindSearchbox() {
	$('#searchbox').on("keydown", function search(e) {
		if (e.keyCode == 13) {
			window.location.href = "/search?searchTerm=" + $(this).val();
		}
	});
}