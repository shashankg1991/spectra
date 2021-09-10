<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:page>
	<link href="/resources/css/productdetail.css" rel="stylesheet">
	<script type="text/javascript" src="/resources/js/productdetail.js"></script>
	<div class="container">
		<div class="row breadcrumbs mb-5">
			<c:forEach items="${product.breadcrumbs}" var="breadcrumb">
				<a href="${breadcrumb.url}">${breadcrumb.name }</a><span
					class="separator ml-1 mr-1">/</span>
			</c:forEach>
		</div>
		<div class="row">
			<!-- Product Image -->
			<div class="col-md-6 row">
				<img src="${ product.defaultProductVariant.images.get(0)}"
					alt="Primary" class="border col-md-12 primary-img">

				<div class=" col-md-12 row thumbnails">
					<c:forEach items="${product.defaultProductVariant.images}"
						var="image">
						<a href="${image}" class="border mt-2 mr-2 col-md-3"> <img
							src="${image}" alt="Thumbnail">
						</a>
					</c:forEach>
				</div>
			</div>

			<!-- Main details -->
			<div class="col-md-6">

				<div class="col-md-12">
					<h1>${product.name}</h1>
				</div>
				<div class="col-md-12">
					<h2>
						<span class="total-price">${product.defaultProductVariant.productPrice.currency}
							${product.defaultProductVariant.productPrice.totalPrice}</span>
					</h2>
				</div>
				<div class="col-md-12">${product.description}</div>


				<div id="product-options" class="col-md-12 row">

					<div class="panel-group  pt-3 pb-3 col-md-12">
						<div class="panel panel-default">
							<a data-toggle="collapse" href="#customize-options">
								<div class="panel-heading  border-top border-bottom">
									<span class="panel-title">Customize this design</span><i
										class="icon icon-plus float-right"></i>
								</div>
							</a>
							<div id="customize-options" class="collapse  mt-3">
								<div class="col-md-12 row">
									<span class="col-md-6">Diamond Grade:</span> <select
										name="diamondGrade" id="diamondGradeSelect" class="col-md-6">
										<c:forEach items="${product.diamondGradeOptions}"
											var="diamondGradeOption">
											<option value="${diamondGradeOption.code}"
												${product.defaultDiamondGrade eq diamondGradeOption.code ? 'selected' : ''}>${diamondGradeOption.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-12 row">
									<span class="col-md-6">Purity:</span> <span class="col-md-6">
										<c:forEach items="${product.metalPurityOptions}"
											var="metalPurityOption">
											<label class="radio-inline mr-2"> <input type="radio"
												name="metalPurity" value="${metalPurityOption.code}"
												${product.defaultMetalPurity eq metalPurityOption.code ? 'checked':''}><span
												class="ml-1">${metalPurityOption.name}</span></input>
											</label>
										</c:forEach>
									</span>

								</div>
								<div class="col-md-12 row">
									<span class="col-md-6">Color:</span> <span class="col-md-6">
										<c:forEach items="${product.colorOptions}" var="colorOption">
											<label class="radio-inline mr-2"> <input type="radio"
												name="color" value="${colorOption}"
												${product.defaultMetalColor eq colorOption ? 'checked':''}><span
												class="ml-1">${colorOption}</span></input>
											</label>
										</c:forEach>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-12 row">
						<span class="col-md-2">Size:</span> <select name="productSize"
							id="productSizeSelect" class="col-md-5 form-group">
							<c:forEach items="${product.sizeOptions}" var="sizeOption">
								<option value="${sizeOption.code}"
									${product.defaultProductSize eq sizeOption.code ? 'selected' : ''}>${sizeOption.name}</option>
							</c:forEach>
						</select> <span class="offset-md-2 col-md-3"><a href="#">Size
								Guide</a></span>
					</div>
					<div class="add-to-cart mt-5 col-md-12 row">
						<button
							class="btn btn-primary add-to-cart-btn btn-primary offset-md-1 col-md-10">
							<i class="icon icon-shopping-cart float-left pl-3"></i>Add To
							Cart
						</button>
					</div>
				</div>
			</div>
		</div>

		<div class="mt-5 row">
			<!-- Product details -->
			<div class="col-md-7">
				<section>
					<h2>Product Details</h2>
					<table class="table col-md-12">
						<tbody>
							<tr>
								<td>Product Code</td>
								<td class="product-code text-right">${product.code}</td>
							</tr>
						</tbody>
					</table>
				</section>
				<section>
					<h2>Diamond Details</h2>
					<table class="table col-md-12">
						<tbody>
							<tr>
								<td>Total Weight</td>
								<td class="diamond-weight text-right">${product.defaultProductVariant.diamondWeight }${product.defaultProductVariant.diamondWeightUnit}</td>
							</tr>
							<tr>
								<td>Total No. of Diamonds</td>
								<td class="diamond-number text-right">${product.defaultProductVariant.diamondNumber }</td>
							</tr>
						</tbody>
					</table>
				</section>
				<section>
					<h2>Stone Details</h2>
					<table class="table col-md-12">
						<tbody>
							<tr>
								<td>Total Weight</td>
								<td class="stone-weight text-right">${product.defaultProductVariant.stoneWeight }${product.defaultProductVariant.stoneWeightUnit}</td>
							</tr>
						</tbody>
					</table>
				</section>
				<section>
					<h2>Metal Details</h2>
					<table class="table col-md-12">
						<tbody>
							<tr>
								<td>Type</td>
								<td class="text-right"></td>
							</tr>
							<tr>
								<td>Total Weight</td>
								<td class="metal-weight text-right">${product.defaultProductVariant.grossWeight }${product.defaultProductVariant.metalWeightUnit}</td>

							</tr>
						</tbody>
					</table>
				</section>
				<section>
					<h2>Price Breakdown</h2>
					<table class="table col-md-12">
						<tbody>
							<tr>
								<td>Gold</td>
								<td class="metal-price text-right">${product.defaultProductVariant.productPrice.currency}${product.defaultProductVariant.productPrice.metalPrice }</td>
							</tr>
							<tr>
								<td>Diamonds</td>
								<td class="diamond-price text-right">${product.defaultProductVariant.productPrice.currency}${product.defaultProductVariant.productPrice.diamondPrice }</td>
							</tr>
							<tr>
								<td>Stones</td>
								<td class="stone-price text-right">${product.defaultProductVariant.productPrice.currency}${product.defaultProductVariant.productPrice.stonesPrice }</td>
							</tr>
							<tr>
								<td>Making Charges</td>
								<td class="making-price text-right">${product.defaultProductVariant.productPrice.currency}${product.defaultProductVariant.productPrice.labour }</td>
							</tr>
							<tr>
								<td>Taxes</td>
								<td class="taxes text-right"></td>
							</tr>
							<tr>
								<td>Total</td>
								<td class="total-price text-right">${product.defaultProductVariant.productPrice.currency}${product.defaultProductVariant.productPrice.totalPrice }</td>
							</tr>
						</tbody>
					</table>
				</section>
			</div>
			<div class="col-md-5">
				<div class="policies p-4 card row offset-md-1 col-md-11">
					<div class="row col-md-12">
						<h2>SPECTRA PROMISE</h2>
					</div>
					<div class="row col-md-12">
						<i class="icon icon-loop float-left pl-3 pr-3"></i>30-Day Money
						Back
					</div>
					<div class="row col-md-12">
						<i class="icon icon-expand float-left pl-3 pr-3"></i>Lifetime
						Exchange <br> & Buy-Back
					</div>
					<div class="row col-md-12">
						<i class="icon icon-file float-left pl-3 pr-3"></i>Certified
						Jewelry
					</div>
				</div>
				<div class="contact p-4 mt-4 card row offset-md-1 col-md-11">
					Any Questions? <br> Please feel free to reach us at:
					1800-000-0000
				</div>
			</div>

		</div>
</t:page>
