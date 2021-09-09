function bindImages() {
	$(".thumbnails a").on('click', function(e) {
		e.preventDefault();
		$('.primary-img').attr('src', $(this).attr('href'));
	});
}

function getVariantDeatils() {
	var productCode = $('.product-code').text();
	var productSize = $('#productSizeSelect').val();
	var diamondGrade = $('#diamondGradeSelect').val();
	var metalPurity = $('input[type=radio][name=metalPurity]').val();
	var color = $('input[type=radio][name=color]').val();

	$.getJSON(
			'/p/' + productCode + '/variant/?metalPurity=' + metalPurity
					+ '&metalColor=' + color + '&productSize=' + productSize
					+ '&diamondGrade=' + diamondGrade,
			null,
			function(data, textStatus, jqXHR) {
				$('.diamond-weight').text(data.diamondWeight);
				$('.diamond-number').text(data.diamondNumber);
				$('.stone-weight').text(data.stoneWeight);
				$('.metal-weight').text(data.grossWeight);
				$('.metal-price').text(
						data.productPrice.currency
								+ data.productPrice.metalPrice);
				$('.diamond-price').text(
						data.productPrice.currency
								+ data.productPrice.diamondPrice);
				$('.stone-price').text(
						data.productPrice.currency
								+ data.productPrice.stonesPrice);
				$('.making-price').text(
						data.productPrice.currency + data.productPrice.labour);
				$('.total-price').text(
						data.productPrice.currency
								+ data.productPrice.totalPrice);
			}).fail(function(jqxhr, settings, ex) {
		console.error('Failied to get the variant details');
	});

}

function bindSizeSelect() {
	$('#productSizeSelect').on('change', function() {
		getVariantDeatils();
	});

}

function bindDiamondGradeSelect() {
	$('#diamondGradeSelect').on('change', function() {
		getVariantDeatils();
	});

}

function bindMetalPurityRadio() {
	$('input[type=radio][name=metalPurity]').change(function() {
		getVariantDeatils();
	});
}

function bindColorRadio() {
	$('input[type=radio][name=color]').change(function() {
		getVariantDeatils();
	});
}

$('document').ready(function() {
	bindImages();
	bindSizeSelect();
	bindDiamondGradeSelect();
	bindMetalPurityRadio();
	bindColorRadio();
});
