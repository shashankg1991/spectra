<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/admin/common"%>
<common:page>
	<div class="container">

		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Product</h5>
				<p class="card-text">Create, edit or delete products.</p>
				<a href="/adminproduct/find" class="card-link">Current products</a>
			</div>
		</div>

		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Test Data</h5>
				<p class="card-text">Generate test data.</p>
				<a href="/test/product/create" class="card-link">Generate</a>
			</div>
		</div>

	</div>
</common:page>