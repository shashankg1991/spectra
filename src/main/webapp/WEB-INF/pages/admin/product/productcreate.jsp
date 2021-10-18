<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="at" tagdir="/WEB-INF/tags/admin"%>
<at:page>
	<script type="text/javascript"
		src="/resources/js/admin/productcreate.js"></script>
	<div class="container">
		<h4>Create New Product</h4>
		<div class="row">
			<label for="code" class="col-sm-2 col-form-label">Code</label>
			<div class="form-group col-md-4">
				<input type="text" placeholder="Code" name="code"
					class="form-control input-sm" />
			</div>
			<label for="name" class="col-sm-2 col-form-label">Name</label>
			<div class="form-group col-md-4">
				<input type="text" name="name" placeholder="Name"
					class="form-control input-sm" />
			</div>
		</div>
		<div class="row">
			<label for="description" class="col-sm-2 col-form-label">Description</label>
			<div class="form-group col-md-10">
				<textarea rows="2" name="description" placeholder="Description"
					class="form-control input-sm"></textarea>
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
			<label for="wastage" class="col-sm-2 col-form-label">Wastage</label>
			<div class="form-group col-md-4">
				<input type="number" min="0" name="wastage" placeholder="Wastage"
					class="form-control input-sm" />
			</div>
		</div>
		<div class="row">
			<label for="fixedLabor" class="col-md-2 col-form-label">Fixed
				Labor</label>
			<div class="form-group col-md-3">
				<input type="number" min="0" name="fixedLabor"
					placeholder="Fixed Labor" class="form-control input-sm" />
			</div>
			<select name="priceUnitFixedLaborOptions"
				id="priceUnitFixedLaborOptions" class="col-md-1 form-group">
				<c:forEach items="${priceUnitOptions}" var="priceUnitOption">
					<option value="${priceUnitOption.code}">${priceUnitOption.name}</option>
				</c:forEach>
			</select> <label for="variableLabor" class="col-md-2 col-form-label">Variable
				Labor</label>
			<div class="form-group col-md-3">
				<input type="number" min="0" name="variableLabor"
					placeholder="Variable Labor" class="form-control input-sm" />
			</div>
			<select name="priceUnitVariableLaborOptions"
				id="priceUnitVariableLaborOptions" class="col-md-1 form-group">
				<c:forEach items="${priceUnitOptions}" var="priceUnitOption">
					<option value="${priceUnitOption.code}">${priceUnitOption.name}</option>
				</c:forEach>
			</select>
		</div>

		<div class="row">
			<label for="notes" class="col-sm-2 col-form-label">Notes</label>
			<div class="form-group col-md-10">
				<textarea rows="3" name="notes" placeholder="Notes"
					class="form-control input-sm"></textarea>
			</div>
		</div>
	</div>
	<div class="container metal-entries border mt-2 p-2">
		<div class="row m-2">
			<h5 class="col-md-8">Metal Entries</h5>
			<div class="form-actions col-md-4">
				<input type="submit" value="Add metal entry"
					class="btn btn-primary btn-sm float-right" id="add-metal-entry">
			</div>
		</div>
	</div>
	<div class="container stone-entries border mt-2 p-2">
		<div class="row m-2">
			<h5 class="col-md-8">Stone Entries</h5>
			<div class="form-actions col-md-4">
				<input type="submit" value="Add stone entry"
					class="btn btn-primary btn-sm float-right" id="add-stone-entry">
			</div>
		</div>
	</div>
	<div class="container diamond-grade-details border mt-2 p-2">
		<div class="row m-2">
			<h5 class="col-md-8">Diamond Grade Details</h5>
			<div class="form-actions col-md-4">
				<input type="submit" value="Add diamond grade details"
					class="btn btn-primary btn-sm float-right" id="add-diamond-grade-details">
			</div>
		</div>
	</div>
	<div class="container m-2">
		<div class="row">
			<div class="form-actions offset-md-6 col-md-4">
				<input type="submit" value="Create Product"
					class="btn btn-primary btn-sm create-product">
			</div>
		</div>
	</div>
</at:page>