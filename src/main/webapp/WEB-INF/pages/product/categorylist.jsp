<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:page>
	<div class="container">
		<div class="row">
			<h2 class="offset-md-3">${searchPageResult.totalResults} Designs</h2>
		</div>
		<div class="row">
			<div class="offset-md-1 col-md-2">
				<c:forEach items="${searchPageResult.facets}" var="facet">
					<div class="facet">
						<div class="facet-name">${facet.facetName}:</div>
						<ul class="facet-values">
							<c:forEach items="${facet.facetEntries}" var="entry">
								<li><a href="/c/${categoryCode}?q=${entry.query}"><input
										type="checkbox" ${entry.selected? 'checked':''}
										onclick='window.location.assign("/c/${categoryCode}?q=${entry.query}")' />
										${entry.name }(${entry.count })</a></li>
							</c:forEach>
						</ul>
					</div>
				</c:forEach>
			</div>
			<div class="col-md-8">
				<div class="row">
					<c:forEach items="${searchPageResult.results}" var="product">
						<div class="col-md-4">
							<div class="product-list-item">
								<div class="image">
									<a><img src="${product.image}"></a>
								</div>
								<div class="name">
									<a>${product.name }</a>
								</div>
								<div class="price">${product.formattedPrice }</div>
								<div class="add-to-cart">
									<a href="/p/${product.code}"><button
											class="btn btn-primary">Details</button></a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<c:if test="${searchPageResult.totalPages gt 1}">
			<div
				class="pagination row offset-md-3 col-md-9 d-flex justify-content-center">
				<c:if test="${previousPageUrl ne null}">
					<a href="${previousPageUrl}" class="prev col-1 mr-1 ml-1"> << </a>
				</c:if>
				<span class="col-1 pt-1 text-center">${searchPageResult.pageNumber + 1}</span>
				<c:if test="${nextPageUrl ne null }">
					<a href="${nextPageUrl}" class="next btn col-1 mr-1 ml-1"> >> </a>
				</c:if>
			</div>
		</c:if>
	</div>
</t:page>