<%@ attribute name="product" required="false"
	type="com.spectra.jewel.data.ws.ProductWsData"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="container">
	<input name="id" type="hidden"
		value="${product ne null?product.id:'-1' }" />
	<div class="row">
		<label for="code" class="col-sm-2 col-form-label">Code</label>
		<div class="form-group col-md-4">
			<input type="text" placeholder="Code" name="code"
				data-parsley-required="true" class="form-control input-sm"
				value="${product ne null?product.code:'' }" />
		</div>
		<label for="name" class="col-sm-2 col-form-label">Name</label>
		<div class="form-group col-md-4">
			<input type="text" name="name" placeholder="Name"
				value="${product ne null?product.name:'' }"
				data-parsley-required="true" class="form-control input-sm" />
		</div>
	</div>
	<div class="row">
		<label for="description" class="col-sm-2 col-form-label">Description</label>
		<div class="form-group col-md-10">
			<textarea rows="2" name="description" placeholder="Description"
				class="form-control input-sm">${product ne null?product.description:''}</textarea>
		</div>
	</div>
	<div class="row">
		<label for="manufacturer" class="col-sm-2 col-form-label">Manufacturer</label>
		<div class="form-group col-md-10">
			<input type="text" name="manufacturer" placeholder="Manufacturer"
				value="${product ne null?product.manufacturer:'' }"
				class="form-control input-sm" />
		</div>
	</div>
	<div class="row">
		<label for="notes" class="col-sm-2 col-form-label">Notes</label>
		<div class="form-group col-md-10">
			<textarea rows="3" name="notes" placeholder="Notes"
				class="form-control input-sm">${product ne null?product.notes:'' }</textarea>
		</div>
	</div>
</div>