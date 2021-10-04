<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="at" tagdir="/WEB-INF/tags/admin"%>
<at:page>
	<script type="text/javascript" src="/resources/js/admin/productcreate.js"></script>
	<div class="container">
		<div>Create New Product</div>
		<div class="row">
			<label for="code" class="col-sm-2 col-form-label">Code</label>
			<div class="form-group col-md-10">
				<input type="text" placeholder="Code" name="code"
					class="form-control input-sm" />
			</div>
		</div>
		<div class="row">
			<label for="name" class="col-sm-2 col-form-label">Name</label>
			<div class="form-group col-md-10">
				<input type="text" name="name" placeholder="Name"
					class="form-control input-sm" />
			</div>
		</div>
		<div class="row">
			<label for="description" class="col-sm-2 col-form-label">Description</label>
			<div class="form-group col-md-10">
				<input type="text" name="description" placeholder="Description"
					class="form-control input-sm" />
			</div>
		</div>
		<div class="row">
			<label for="manufacturer" class="col-sm-2 col-form-label">Manufacturer</label>
			<div class="form-group col-md-10">
				<input type="text" name="manufacturer" placeholder="Manufacturer"
					class="form-control input-sm" />
			</div>
		</div>
		<div class="row">
			<label for="notes" class="col-sm-2 col-form-label">Notes</label>
			<div class="form-group col-md-10">
				<input type="text" name="notes" placeholder="Notes"
					class="form-control input-sm" />
			</div>
		</div>
		<div class="row">
			<label for="wastage" class="col-sm-2 col-form-label">Wastage</label>
			<div class="form-group col-md-10">
				<input type="number" name="wastage" placeholder="Wastage"
					class="form-control input-sm" />
			</div>
		</div>
		<div class="row">
			<label for="code" class="col-sm-2 col-form-label">Fixed Labor</label>
			<div class="form-group col-md-10">
				<input type="number" name="fixedLabor" placeholder="Fixed Labor"
					class="form-control input-sm" />
			</div>
		</div>
		<div class="row">
			<div class="form-actions  col-md-10">
				<input type="submit" value="Create Product"
					class="btn btn-primary btn-sm create-product">
			</div>
		</div>
	</div>
</at:page>