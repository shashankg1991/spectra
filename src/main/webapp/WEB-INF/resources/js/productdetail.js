$('document').ready(function() {
	$(".thumbnails a").on('click', function(e) {
		e.preventDefault();
		$('.primary-img').attr('src', $(this).attr('href'));
	});
});
