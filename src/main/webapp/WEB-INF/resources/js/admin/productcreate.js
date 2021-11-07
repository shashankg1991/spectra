function bindCreateProductForm() {
	$('#admin-create-edit-form').on('submit', function(event) {
		event.preventDefault();
	});
}

function bindSaveProductSubmit() {
	$(".save-product")
			.on(
					'click',
					function(e) {
						e.preventDefault();
						$('#admin-create-edit-form').parsley().validate();
						if ($('.parsley-error').length > 0) {
							alert('Data has errors!');
							return;
						}
						var data = {};

						// Basic
						data.id = $('input[name="id"]').val();
						data.code = $('input[name="code"]').val();
						data.name = $('input[name="name"]').val();
						data.description = $('textarea[name="description"]')
								.val();
						data.manufacturer = $('input[name="manufacturer"]')
								.val();
						data.notes = $('textarea[name="notes"]').val();

						// Details
						data.categories = [];
						var categories = $('#categories').val();
						if (categories) {
							for (let counter = 0; counter < categories.length; counter++) {
								var category = {};
								category.code = categories[counter];
								data.categories.push(category);
							}
						}
						data.wastage = $('input[name="wastage"]').val();
						data.fixedLabor = {};
						data.fixedLabor.id = $('input[name="fixedLaborId"]')
								.val();
						data.fixedLabor.val = $('input[name="fixedLabor"]')
								.val();
						data.fixedLabor.unit = $(
								'select[name="priceUnitFixedLaborOptions"]')
								.val();
						data.fixedLabor.currency = $(
								'select[name="currencyFixedLaborOptions"]')
								.val();
						data.variableLabor = {};
						data.variableLabor.id = $(
								'input[name="variableLaborId"]').val();
						data.variableLabor.val = $(
								'input[name="variableLabor"]').val();
						data.variableLabor.unit = $(
								'select[name="priceUnitVariableLaborOptions"]')
								.val();
						data.variableLabor.currency = $(
								'select[name="currencyVariableLaborOptions"]')
								.val();
						data.metalType = $('select[name="metalTypeOption"]')
								.val();
						data.metalColors = $('#metalColorOptions').val();

						// Metal & Size
						data.metalEntries = [];
						var metalEntryHtmls = $('.metal-entry');
						if (metalEntryHtmls) {
							for (let counter = 0; counter < metalEntryHtmls.length; counter++) {
								var metalEntry = {};
								metalEntry.weight = {};
								metalEntry.id = $(metalEntryHtmls[counter])
										.find('input[name="id"]').val();
								metalEntry.weight.id = $(
										metalEntryHtmls[counter]).find(
										'input[name="weightId"]').val();
								metalEntry.weight.val = $(
										metalEntryHtmls[counter]).find(
										'input[name="weight"]').val();
								metalEntry.weight.unit = $(
										metalEntryHtmls[counter]).find(
										'select[name="weightUnitOptions"]')
										.val();
								metalEntry.size = $(metalEntryHtmls[counter])
										.find('select[name="size"]').val();
								metalEntry.metalPurity = $(
										metalEntryHtmls[counter]).find(
										'select[name="metalPurity"]').val();
								data.metalEntries.push(metalEntry);
							}
						}

						// Stone entries
						data.stoneEntries = [];
						var stoneEntryHtmls = $('.stone-entry');
						if (stoneEntryHtmls) {
							for (let counter = 0; counter < stoneEntryHtmls.length; counter++) {
								var stoneEntry = {};
								stoneEntry.weight = {};
								stoneEntry.rate = {};
								stoneEntry.id = $(stoneEntryHtmls[counter])
										.find('input[name="id"]').val();
								stoneEntry.description = $(
										stoneEntryHtmls[counter]).find(
										'textarea[name="description"]').val();
								stoneEntry.weight.id = $(
										stoneEntryHtmls[counter]).find(
										'input[name="weightId"]').val();
								stoneEntry.weight.val = $(
										stoneEntryHtmls[counter]).find(
										'input[name="weight"]').val();
								stoneEntry.weight.unit = $(
										stoneEntryHtmls[counter]).find(
										'select[name="weightUnitOptions"]')
										.val();
								stoneEntry.rate.id = $(stoneEntryHtmls[counter])
										.find('input[name="rateId"]').val();
								stoneEntry.rate.val = $(
										stoneEntryHtmls[counter]).find(
										'input[name="rate"]').val();
								stoneEntry.rate.unit = $(
										stoneEntryHtmls[counter]).find(
										'select[name="priceUnitOptions"]')
										.val();
								stoneEntry.rate.currency = $(
										stoneEntryHtmls[counter]).find(
										'select[name="currencyOptions"]').val();
								data.stoneEntries.push(stoneEntry);
							}
						}

						// Diamond entries
						data.diamondGradeDetails = [];
						var diamondGradeDetailHtmls = $('.diamond-grade-detail');
						if (diamondGradeDetailHtmls) {
							for (let parentCounter = 0; parentCounter < diamondGradeDetailHtmls.length; parentCounter++) {
								var diamondGradeDetail = {};
								diamondGradeDetail.id = $(
										diamondGradeDetailHtmls[parentCounter])
										.find('input[name="id"]').val();
								diamondGradeDetail.grade = $(
										diamondGradeDetailHtmls[parentCounter])
										.find(
												'select[name="diamondGradeOptions"]')
										.val();
								var diamondEntryHtmls = $(
										diamondGradeDetailHtmls[parentCounter])
										.find('.diamond-entry');
								if (diamondEntryHtmls) {
									diamondGradeDetail.entries = [];
									for (let childCounter = 0; childCounter < diamondEntryHtmls.length; childCounter++) {
										var diamondEntry = {};
										diamondEntry.weight = {};
										diamondEntry.rate = {};
										diamondEntry.id = $(
												diamondEntryHtmls[childCounter])
												.find('input[name="id"]').val();
										diamondEntry.size = $(
												diamondEntryHtmls[childCounter])
												.find(
														'select[name="diamondSizeOptions"]')
												.val();
										diamondEntry.number = $(
												diamondEntryHtmls[childCounter])
												.find('input[name="number"]')
												.val();
										diamondEntry.weight.id = $(
												diamondEntryHtmls[childCounter])
												.find('input[name="weightId"]')
												.val();
										diamondEntry.weight.val = $(
												diamondEntryHtmls[childCounter])
												.find('input[name="weight"]')
												.val();
										diamondEntry.weight.unit = $(
												diamondEntryHtmls[childCounter])
												.find(
														'select[name="weightUnitOptions"]')
												.val();
										diamondEntry.rate.id = $(
												diamondEntryHtmls[childCounter])
												.find('input[name="rateId"]')
												.val();
										diamondEntry.rate.val = $(
												diamondEntryHtmls[childCounter])
												.find('input[name="rate"]')
												.val();
										diamondEntry.rate.unit = $(
												diamondEntryHtmls[childCounter])
												.find(
														'select[name="priceUnitOptions"]')
												.val();
										diamondEntry.rate.currency = $(
												diamondEntryHtmls[childCounter])
												.find(
														'select[name="currencyOptions"]')
												.val();
										diamondGradeDetail.entries
												.push(diamondEntry);

									}
								}
								data.diamondGradeDetails
										.push(diamondGradeDetail);
							}
						}

						// Images
						data.images = [];
						var imageHtmls = $('.image');
						if (imageHtmls) {
							for (let counter = 0; counter < imageHtmls.length; counter++) {
								var image = {};
								image.id = $(imageHtmls[counter]).find(
										'input[name="id"]').val();
								image.metalColor = $(imageHtmls[counter]).find(
										'select[name="metalColorOptions"]')
										.val();
								image.sequence = $(imageHtmls[counter]).find(
										'input[name="sequence"]').val();
								image.url = $(imageHtmls[counter]).find(
										'textarea[name="url"]').val();
								data.images.push(image);
							}
						}

						// Stocks
						data.stocks = [];
						var stockHtmls = $('.stock');
						if (stockHtmls) {
							for (let counter = 0; counter < stockHtmls.length; counter++) {
								var stock = {};
								stock.id = $(stockHtmls[counter]).find(
										'input[name="id"]').val();
								stock.quantity = $(stockHtmls[counter]).find(
										'input[name="quantity"]').val();
								stock.stockLevel = $(stockHtmls[counter])
										.find(
												'select[name="stockLevelStatusOptions"]')
										.val();
								stock.metalColor = $(stockHtmls[counter]).find(
										'select[name="metalColorOptions"]')
										.val();
								stock.metalPurity = $(stockHtmls[counter])
										.find(
												'select[name="metalPurityOptions"]')
										.val();
								stock.size = $(stockHtmls[counter]).find(
										'select[name="sizeOptions"]').val();
								stock.diamondGrade = $(stockHtmls[counter])
										.find(
												'select[name="diamondGradeOptions"]')
										.val();
								data.stocks.push(stock);
							}
						}

						// Default options
						data.defaultMetalColor = $('#default-option-details')
								.find('select[name="metalColorOptions"]').val();
						data.defaultMetalPurity = $('#default-option-details')
								.find('select[name="metalPurityOptions"]')
								.val();
						data.defaultSize = $('#default-option-details').find(
								'select[name="sizeOptions"]').val();
						data.defaultDiamondGrade = $('#default-option-details')
								.find('select[name="diamondGradeOptions"]')
								.val();
						console.debug(JSON.stringify(data));
						$.ajax({
							type : "POST",
							url : '/adminproduct/save',
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
				$(".metal-entries")[0].insertAdjacentHTML('beforeend', data);
				bindRemoveMetalEntry();
				bindSelects();
			},
		});
	});
}

function bindRemoveMetalEntry() {
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
				$(".stone-entries")[0].insertAdjacentHTML('beforeend', data);
				bindRemoveStoneEntry();
				bindSelects();
			},
		});
	});

}

function bindRemoveStoneEntry() {
	$(".stone-entry-remove").on('click', function(e) {
		e.preventDefault();
		$(this).closest('.stone-entry').remove()
	});
}
function bindAddDiamomndGradeDetails() {
	$("#add-diamond-grade-details").on(
			'click',
			function(e) {
				$.ajax({
					type : "GET",
					url : '/adminproduct/fragment/diamondgradedetail',
					success : function(data) {
						$(".diamond-grade-details")[0].insertAdjacentHTML(
								'beforeend', data);
						bindAddDiamondEntry();
						bindRemoveDiamomndGradeDetails();
						bindSelects();
					},
				});
			});
}

function bindRemoveDiamomndGradeDetails() {
	$(".diamond-grade-detail-remove").on('click', function(e) {
		e.preventDefault();
		$(this).closest('.diamond-grade-detail').remove()
	});
}

function bindAddDiamondEntry() {
	$(".add-diamond-entry").on(
			'click',
			function(e) {
				let $this = $(this);
				$.ajax({
					type : "GET",
					url : '/adminproduct/fragment/diamondentry',
					success : function(data) {
						$this.closest(".diamond-entries")[0]
								.insertAdjacentHTML('beforeend', data);
						bindRemoveDiamondEntry();
						bindSelects();
					},
				});
			});

}

function bindRemoveDiamondEntry() {
	$(".diamond-entry-remove").on('click', function(e) {
		e.preventDefault();
		$(this).closest('.diamond-entry').remove()
	});
}

function bindAddImage() {
	$("#add-image").on(
			'click',
			function(e) {
				let $this = $(this);
				$.ajax({
					type : "GET",
					url : '/adminproduct/fragment/image',
					success : function(data) {
						$this.closest(".images")[0].insertAdjacentHTML(
								'beforeend', data);
						bindRemoveImage();
						bindImagePreview();
						bindSelects();
					},
				});
			});

}

function bindRemoveImage() {
	$(".image-remove").on('click', function(e) {
		e.preventDefault();
		$(this).closest('.image').remove()
	});
}

function bindImagePreview() {
	$('.image-url').on('change', function() {
		$(this).parent().find('.image-preview').prop('src', this.value);
	});
}

function bindAddStock() {
	$("#add-stock").on(
			'click',
			function(e) {
				let $this = $(this);
				$.ajax({
					type : "GET",
					url : '/adminproduct/fragment/stock',
					success : function(data) {
						$this.closest(".stocks")[0].insertAdjacentHTML(
								'beforeend', data);
						bindRemoveStock();
						bindSelects();
					},
				});
			});

}

function bindRemoveStock() {
	$(".stock-remove").on('click', function(e) {
		e.preventDefault();
		$(this).closest('.stock').remove()
	});
}

$('document').ready(function() {
	bindCreateProductForm();
	
	bindSaveProductSubmit();
	
	bindAddMetalEntry();
	bindAddStoneEntry();
	bindAddDiamomndGradeDetails();
	bindAddDiamondEntry();
	bindAddImage();
	bindAddStock();
	
	bindRemoveMetalEntry();
	bindRemoveStoneEntry();
	bindRemoveDiamomndGradeDetails();
	bindRemoveDiamondEntry();
	bindRemoveImage();
	bindRemoveStock();
	
	bindImagePreview();
});
