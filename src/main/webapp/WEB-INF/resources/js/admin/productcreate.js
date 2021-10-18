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

function bindAddMetalEntry() {
	$("#add-metal-entry").on('click', function(e) {
		$.ajax({
			type : "GET",
			url : '/adminproduct/fragment/metalentry',
			success : function(data) {
				$(".metal-entries")[0].innerHTML += data;
				bindAddMetalEntry();
				$('select').niceSelect();
			},
		});
	});

	$(".metal-entry-remove").on('click', function(e) {
		e.preventDefault();
		$(this).closest('.metal-entry').remove()
	});
}

function bindAddStoneEntry() {
	$("#add-stone-entry").on('click', function(e) {
		$.ajax({
			type : "GET",
			url : '/adminproduct/fragment/stoneentry',
			success : function(data) {
				$(".stone-entries")[0].innerHTML += data;
				bindAddStoneEntry();
				$('select').niceSelect();
			},
		});
	});

	$(".stone-entry-remove").on('click', function(e) {
		e.preventDefault();
		$(this).closest('.stone-entry').remove()
	});
}

function bindAddDiamomndGradeDetails() {
	$("#add-diamond-grade-details").on('click', function(e) {
		$.ajax({
			type : "GET",
			url : '/adminproduct/fragment/diamondgradedetail',
			success : function(data) {
				$(".diamond-grade-details")[0].innerHTML += data;
				bindAddDiamomndGradeDetails();
				bindAddDiamondEntry();
				$('select').niceSelect();
			},
		});
	});

	$(".diamond-grade-detail-remove").on('click', function(e) {
		e.preventDefault();
		$(this).closest('.diamond-grade-detail').remove()
	});
}

function bindAddDiamondEntry() {
	$(".add-diamond-entry").on('click', function(e) {
		let $this = $(this);
		$.ajax({
			type : "GET",
			url : '/adminproduct/fragment/diamondentry',
			success : function(data) {
				$this.closest(".diamond-entries")[0].innerHTML += data;
				bindAddDiamondEntry();
				$('select').niceSelect();
			},
		});
	});

	$(".diamond-entry-remove").on('click', function(e) {
		e.preventDefault();
		$(this).closest('.diamond-entry').remove()
	});
}

$('document').ready(function() {
	bindCreateProductSubmit();
	bindAddMetalEntry();
	bindAddStoneEntry();
	bindAddDiamomndGradeDetails();
	bindAddDiamondEntry;
});
