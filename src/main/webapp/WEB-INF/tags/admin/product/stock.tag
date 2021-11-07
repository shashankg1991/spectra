<%@ attribute name="stock" required="false"
	type="com.spectra.jewel.data.ws.StockLevelWsData"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row stock  m-2 p-2 bg-light">
	<input name="id" type="hidden" value="${stock ne null?stock.id:'-1' }" />
	<div class="row col-md-12">
		<div class="form-group col-md-11 row">
			<div class="col-md-6 row">
				<span class="col-md-6">Quantity:</span> <input type="number"
					name="quantity" placeholder="Quantity"
					value="${(stock ne null)?stock.quantity:''}" step="1"
					data-parsley-required="true" data-parsley-type="number"
					data-parsley-min="0" class="form-control col-md-6 input-sm" />
			</div>
			<div class="col-md-6 row">
				<span class="col-md-6">Status:</span> <select
					name="stockLevelStatusOptions" id="stockLevelStatusOptions"
					class="col-md-6 form-group">
					<c:forEach items="${stockLevelStatusOptions}"
						var="stockLevelStatusOption">
						<option value="${stockLevelStatusOption}"
							${(stock ne null) and (stock.stockLevel eq stockLevelStatusOption) ?'selected':''}>
							${stockLevelStatusOption}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-6 row mt-2">
				<span class="col-md-6">Color:</span> <select
					name="metalColorOptions" id="metalColorOptions"
					class="col-md-6 form-group">
					<c:forEach items="${metalColorOptions}" var="metalColorOption">
						<option value="${metalColorOption}"
							${(stock ne null) and (stock.metalColor eq metalColorOption) ?'selected':''}>
							${metalColorOption}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-6 row">
				<span class="col-md-6">Purity:</span> <select
					name="metalPurityOptions" id="metalPurityOptions"
					class="col-md-6 form-group">
					<c:forEach items="${metalPurityOptions}" var="metalPurityOption">
						<option value="${metalPurityOption.code}"
							${(stock ne null) and (stock.metalPurity eq metalPurityOption.code) ?'selected':''}>
							${metalPurityOption.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-6 row mt-2">
				<span class="col-md-6">Size:</span> <select name="sizeOptions"
					id="sizeOptions" class="col-md-6 form-group">
					<c:forEach items="${sizeOptions}" var="sizeOption">
						<option value="${sizeOption.code}"
							${(stock ne null) and (stock.size eq sizeOption.code) ?'selected':''}>
							${sizeOption.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-6 row">
				<span class="col-md-6">Diamond Grade:</span> <select
					name="diamondGradeOptions" id="diamondGradeOptions"
					class="col-md-6 form-group">
					<c:forEach items="${diamondGradeOptions}" var="diamondGradeOption">
						<option value="${diamondGradeOption.code}"
							${(stock ne null) and (stock.diamondGrade eq diamondGradeOption.code) ?'selected':''}>
							${diamondGradeOption.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="col-md-1">
			<button class="btn btn-danger float-right stock-remove">
				<i class="icon icon-cross"></i>
			</button>
		</div>
	</div>
</div>