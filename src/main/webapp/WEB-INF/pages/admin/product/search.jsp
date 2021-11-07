<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/admin/common"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/admin/product"%>
<common:page>
	<script type="text/javascript"
		src="/resources/js/admin/productcreate.js"></script>
	<div class="container">
		<form action="find">
			<input type="hidden" name="page" value="${page}" />
			<div class="row">
				<div class="col-sm-3">Id</div>
				<div class=" col-md-3">
					<input type="text" placeholder="Id" name="id"
						class="form-control input-sm" value="${id}" />
				</div>
				<div class="col-sm-3">Code</div>
				<div class=" col-md-3">
					<input type="text" placeholder="Code" name="code"
						class="form-control input-sm" value="${code}" />
				</div>
			</div>
			<div class="row mt-2">
				<div class="col-sm-3">Search Text</div>
				<div class=" col-md-9">
					<input type="text" placeholder="Search term" name="text"
						class="form-control input-sm" value="${text}" />
				</div>
			</div>
			<div class="row mt-2">
				<button type="submit" class="btn btn-primary offset-5 col-md-3">Search</button>
			</div>
			<div class="row mt-2">
				<a class="btn btn-secondary offset-5 col-md-3"
					href="/adminproduct/create">Create New</a>
			</div>

		</form>
	</div>
	<div class="container">
		<c:if test="${searchPageData ne null }">
			<h4 class="col-md-12">${searchPageData.totalResults} products
				found.</h4>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Image</th>
						<th scope="col">Code</th>
						<th scope="col">Name</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<c:forEach items="${searchPageData.results}" var="product">
					<product:productrow product="${product}" />
				</c:forEach>
			</table>
			<c:if test="${searchPageData.totalPages gt 1}">
				<div
					class="pagination row offset-md-3 col-md-9 d-flex justify-content-center">
					<c:if test="${previousPageUrl ne null}">
						<a href="${previousPageUrl}" class="prev col-1 mr-1 ml-1"> <<
						</a>
					</c:if>
					<span class="col-1 pt-1 text-center">${searchPageData.pageNumber + 1}</span>
					<c:if test="${nextPageUrl ne null }">
						<a href="${nextPageUrl}" class="next btn col-1 mr-1 ml-1"> >>
						</a>
					</c:if>
				</div>
			</c:if>
		</c:if>
	</div>
</common:page>