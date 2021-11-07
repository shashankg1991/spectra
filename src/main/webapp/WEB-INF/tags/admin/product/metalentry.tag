<%@ attribute name="entry" required="false"
	type="com.spectra.jewel.data.ws.ProductMetalSizeEntryWsData"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row metal-entry m-2 p-2 bg-light">
	<div class="row col-md-12">
		<input name="id" type="hidden" value="${entry ne null?entry.id:'-1' }" />
		<div class="form-group col-md-4">
			<div class="col-md-12 row">
				<span class="col-md-3">Weight:</span> <input name="weightId"
					type="hidden"
					value="${(entry ne null) and (entry.weight ne null)?entry.weight.id:'-1' }" /><span
					class="col-md-6"><input type="number" name="weight"
					placeholder="Weight" step="0.001" data-parsley-required="true"
					data-parsley-type="number" data-parsley-min="0"
					value="${(entry ne null) and (entry.weight ne null)?entry.weight.val:'' }"
					class="form-control input-sm" /></span> <select name="weightUnitOptions"
					id="weightUnitOptions" class="col-md-1 form-group">
					<c:forEach items="${weightUnitOptions}" var="weightUnitOption">
						<option value="${weightUnitOption.code}"
							${(entry ne null) and (entry.weight ne null) and (entry.weight.unit eq weightUnitOption.code) ?'selected':''}>
							${weightUnitOption.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group col-md-4 row">
			<div class="col-md-12 row">
				<span class="col-md-5">Size:</span> <select name="size"
					id="productSizeSelect" class="col-md-7 form-group">
					<c:forEach items="${sizeOptions}" var="sizeOption">
						<option value="${sizeOption.code}"
							${(entry ne null) and (entry.size eq sizeOption.code) ?'selected':''}>
							${sizeOption.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group col-md-3 row">
			<div class="col-md-12 row">
				<span class="col-md-5">Purity:</span> <select name="metalPurity"
					id="metalPurity" class="col-md-7 form-group">
					<c:forEach items="${metalPurityOptions}" var="metalPurityOption">
						<option value="${metalPurityOption.code}"
							${(entry ne null) and (entry.metalPurity eq metalPurityOption.code) ?'selected':''}>
							${metalPurityOption.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="col-md-1">
			<button class="btn btn-danger float-right metal-entry-remove">
				<i class="icon icon-cross"></i>
			</button>
		</div>
	</div>
</div>