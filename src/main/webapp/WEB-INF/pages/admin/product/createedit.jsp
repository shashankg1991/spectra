<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/admin/common"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/admin/product"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<common:page>
	<script type="text/javascript"
		src="/resources/js/admin/productcreate.js"></script>
	<div class="container">
		<form id="admin-create-edit-form" data-parsley-validate="">
			<h5>Create New Product</h5>
			<product:basic product="${product}" />
			<ul class="nav nav-tabs">
				<li class="nav-item"><a class="nav-link active"
					data-toggle="tab" href="#details">Details</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#metal-entries">Metal & Sizes</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#stone-entries">Stone</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#diamond-grade-details">Diamond</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#images">Images</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#stocks">Stocks</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#default-option-details">Default Options</a></li>
			</ul>
			<div class="tab-content">
				<div id="details" class="container mt-2 tab-pane fade active show">
					<product:details product="${product}" />
				</div>
				<div id="metal-entries"
					class="container metal-entries border mt-2 p-2 tab-pane fade">
					<div class="row m-2">
						<h5 class="col-md-8">Metal Entries</h5>
						<div class="form-actions col-md-4">
							<input type="button" value="Add metal entry"
								class="btn btn-primary btn-sm float-right" id="add-metal-entry">
						</div>
					</div>
					<c:if
						test="${(product ne null) and (product.metalEntries ne null) }">
						<c:forEach items="${product.metalEntries}" var="metalEntry">
							<product:metalentry entry="${metalEntry}" />
						</c:forEach>
					</c:if>
				</div>
				<div id="stone-entries"
					class="container stone-entries border mt-2 p-2 tab-pane fade">
					<div class="row m-2">
						<h5 class="col-md-8">Stone Entries</h5>
						<div class="form-actions col-md-4">
							<input type="button" value="Add stone entry"
								class="btn btn-primary btn-sm float-right" id="add-stone-entry">
						</div>
					</div>
					<c:if
						test="${(product ne null) and (product.stoneEntries ne null) }">
						<c:forEach items="${product.stoneEntries}" var="stoneEntry">
							<product:stoneentry entry="${stoneEntry}" />
						</c:forEach>
					</c:if>
				</div>
				<div id="diamond-grade-details"
					class="container diamond-grade-details border mt-2 p-2 tab-pane fade">
					<div class="row m-2">
						<h5 class="col-md-8">Diamond Grade Details</h5>
						<div class="form-actions col-md-4">
							<input type="button" value="Add diamond grade details"
								class="btn btn-primary btn-sm float-right"
								id="add-diamond-grade-details">
						</div>
					</div>
					<c:if
						test="${(product ne null) and (product.diamondGradeDetails ne null) }">
						<c:forEach items="${product.diamondGradeDetails}"
							var="diamondGradeDetail">
							<product:diamondgradedetail
								diamondgradedetail="${diamondGradeDetail}" />
						</c:forEach>
					</c:if>
				</div>
				<div id="stocks"
					class="container stocks border mt-2 p-2 tab-pane fade">
					<div class="row m-2">
						<h5 class="col-md-8">Stocks</h5>
						<div class="form-actions col-md-4">
							<input type="button" value="Add stock"
								class="btn btn-primary btn-sm float-right" id="add-stock">
						</div>
					</div>
					<c:if test="${(product ne null) and (product.stocks ne null) }">
						<c:forEach items="${product.stocks}" var="stock">
							<product:stock stock="${stock}" />
						</c:forEach>
					</c:if>
				</div>
				<div id="images"
					class="container images border mt-2 p-2 tab-pane fade">
					<div class="row m-2">
						<h5 class="col-md-8">Images</h5>
						<div class="form-actions col-md-4">
							<input type="button" value="Add image"
								class="btn btn-primary btn-sm float-right" id="add-image">
						</div>
					</div>
					<c:if test="${(product ne null) and (product.images ne null) }">
						<c:forEach items="${product.images}" var="image">
							<product:image image="${image}" />
						</c:forEach>
					</c:if>
				</div>
				<div id="default-option-details"
					class="container border mt-2 p-2 tab-pane fade">
					<product:defaultoptions product="${product}"
						metalColorOptions="${metalColorOptions}"
						metalPurityOptions="${metalPurityOptions}"
						sizeOptions="${sizeOptions}"
						diamondGradeOptions="${diamondGradeOptions}" />
				</div>
			</div>
			<div class="container m-2">
				<div class="row">
					<div class="form-actions offset-md-6 col-md-4">
						<input type="submit" value="Save Product"
							class="btn btn-primary btn-sm save-product">
					</div>
				</div>
			</div>
		</form>
	</div>
</common:page>