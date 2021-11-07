<%@ attribute name="product" required="false"
	type="com.spectra.jewel.data.ws.ProductWsData"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row mb-2">
	<label for="categories" class="col-md-2 col-form-label">Categories</label>
	<select multiple="multiple" name="metalColorOptions" id="categories"
		data-parsley-required="true" class="col-md-4 form-group multiselect">
		<c:forEach items="${categories}" var="category">
			<c:set var="isSelected" value="false" />
			<c:if test="${(product ne null) and (product.categories ne null) }">
				<c:forEach items="${product.categories}" var="productCategory">
					<c:if test="${category.code eq productCategory.code}">
						<c:set var="isSelected" value="true" />
					</c:if>
				</c:forEach>
			</c:if>
			<option value="${category.code}" ${isSelected? 'selected':'' }>${category.name}</option>
		</c:forEach>
	</select>
</div>
<div class="row">
	<label for="wastage" class="col-sm-2 col-form-label">Wastage</label>
	<div class="form-group col-md-4">
		<input type="number" min="0" name="wastage" placeholder="Wastage"
			value="${product ne null?product.wastage:'' }" step="0.01"
			data-parsley-required="true" data-parsley-type="number"
			data-parsley-min="0" class="form-control input-sm" />
	</div>
</div>
<div class="row">
	<label for="fixedLabor" class="col-md-2 col-form-label">Fixed
		Labor</label> <input name="fixedLaborId" type="hidden"
		value="${(product ne null) and (product.fixedLabor ne null)?product.fixedLabor.id:'-1' }" />
	<div class="form-group col-md-2">
		<input type="number" min="0" name="fixedLabor"
			value="${(product ne null) and (product.fixedLabor ne null)?product.fixedLabor.val:'' }"
			placeholder="Fixed Labor" step="0.001" data-parsley-required="true"
			data-parsley-type="number" data-parsley-min="0"
			class="form-control input-sm" />
	</div>
	<select name="priceUnitFixedLaborOptions"
		id="priceUnitFixedLaborOptions" class="col-md-1 form-group">
		<c:forEach items="${priceUnitOptions}" var="priceUnitOption">
			<option value="${priceUnitOption.code}"
				${(product ne null) and (product.fixedLabor ne null) and (product.fixedLabor.unit eq priceUnitOption.code) ?'selected':'' }>
				${priceUnitOption.name}</option>
		</c:forEach>
	</select> <select name="currencyFixedLaborOptions"
		id="currencyFixedLaborOptions" class="col-md-1 form-group">
		<c:forEach items="${currencyOptions}" var="currencyOption">
			<option value="${currencyOption.code}"
				${(product ne null) and (product.fixedLabor ne null) and (product.fixedLabor.currency eq currencyOption.code) ?'selected':'' }>
				${currencyOption.name}</option>
		</c:forEach>
	</select> <label for="variableLabor" class="col-md-2 col-form-label">Variable
		Labor</label> <input name="variableLaborId" type="hidden"
		value="${(product ne null) and (product.variableLabor ne null)?product.variableLabor.id:'-1' }" />
	<div class="form-group col-md-2">
		<input type="number" min="0" name="variableLabor"
			value="${product ne null?product.variableLabor.val:'' }" step="0.001"
			data-parsley-required="true" data-parsley-type="number"
			data-parsley-min="0" placeholder="Variable Labor"
			class="form-control input-sm" />
	</div>
	<select name="priceUnitVariableLaborOptions"
		id="priceUnitVariableLaborOptions" class="col-md-1 form-group">
		<c:forEach items="${priceUnitOptions}" var="priceUnitOption">
			<option value="${priceUnitOption.code}"
				${(product ne null) and (product.variableLabor ne null) and (product.variableLabor.unit eq priceUnitOption.code) ?'selected':'' }>
				${priceUnitOption.name}</option>
		</c:forEach>
	</select> <select name="currencyVariableLaborOptions"
		id="currencyVariableLaborOptions" class="col-md-1 form-group">
		<c:forEach items="${currencyOptions}" var="currencyOption">
			<option value="${currencyOption.code}"
				${(product ne null) and (product.variableLabor ne null) and (product.variableLabor.currency eq currencyOption.code) ?'selected':'' }>
				${currencyOption.name}</option>
		</c:forEach>
	</select>
</div>
<div class="row">
	<label for="metalType" class="col-md-2 col-form-label">Metal
		Type</label> <select name="metalTypeOption" id="metalTypeOptions"
		data-parsley-required="true" class="col-md-4 ml-3 form-group">
		<c:forEach items="${metalTypeOptions}" var="metalTypeOption">
			<option value="${metalTypeOption}"
				${(product ne null) and (product.metalType eq metalTypeOption) ?'selected':'' }>
				${metalTypeOption}</option>
		</c:forEach>
	</select> <label for="metalColor" class="col-md-2 col-form-label">Metal
		Colors</label> <select multiple="multiple" name="metalColorOptions"
		id="metalColorOptions" data-parsley-required="true"
		class="col-md-4 form-group multiselect">
		<c:forEach items="${metalColorOptions}" var="metalColorOption">
			<c:if test="${(product ne null) and (product.metalColors ne null) }">
				<c:forEach items="${product.metalColors}" var="productMetalColor">
					<c:if test="${productMetalColor eq metalColorOption}">
						<c:set var="isSelected" value="true" />
					</c:if>
				</c:forEach>
			</c:if>
			<option value="${metalColorOption}" ${isSelected? 'selected':'' }>${metalColorOption}</option>
		</c:forEach>
	</select>
</div>