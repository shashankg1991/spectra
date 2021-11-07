<%@ attribute name="entry" required="false"
	type="com.spectra.jewel.data.ws.ProductDiamondEntryWsData"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row diamond-entry  mt-2 mb-2 pt-2 pb-2 bg-white">
	<input name="id" type="hidden" value="${entry ne null?entry.id:'-1' }" />
	<div class="row col-md-12">
		<div class="row col-md-11">
			<span class="col-md-3">Size:</span><select name="diamondSizeOptions"
				id="diamondSizeOptions" class="col-md-3 form-group">
				<c:forEach items="${diamondSizeOptions}" var="diamondSizeOption">
					<option value="${diamondSizeOption.code}"
						${(entry ne null) and (entry.size eq diamondSizeOption.code) ?'selected':''}>
						${diamondSizeOption.name}</option>
				</c:forEach>
			</select> <span class="col-md-3">Number:</span><input type="number"
				name="number" placeholder="Number"
				value="${entry ne null?entry.number:''}" step="1"
				data-parsley-required="true" data-parsley-type="number"
				data-parsley-min="0" class="form-control input-sm col-md-3" />
		</div>
		<div class="col-md-1">
			<button class="btn btn-danger float-right diamond-entry-remove">
				<i class="icon icon-cross"></i>
			</button>
		</div>
	</div>
	<div class="row col-md-12 mt-2">
		<div class="form-group col-md-6">
			<div class="col-md-12 row">
				<span class="col-md-3">Weight:</span> <input name="weightId"
					type="hidden"
					value="${(entry ne null) and (entry.weight ne null)?entry.weight.id:'-1' }" /><span
					class="col-md-6"><input type="number" name="weight"
					placeholder="Weight"
					value="${(entry ne null) and (entry.weight ne null)?entry.weight.val:''}"
					step="0.001" data-parsley-required="true"
					data-parsley-type="number" data-parsley-min="0"
					class="form-control input-sm" /></span> <select name="weightUnitOptions"
					id="weightUnitOptions" class="col-md-2 form-group">
					<c:forEach items="${weightUnitOptions}" var="weightUnitOption">
						<option value="${weightUnitOption.code}"
							${(entry ne null) and (entry.weight ne null) and (entry.weight.unit eq weightUnitOption.code) ?'selected':''}>
							${weightUnitOption.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group col-md-6">
			<div class="col-md-12 row">
				<span class="col-md-2">Rate:</span><input name="rateId"
					type="hidden"
					value="${(entry ne null) and (entry.rate ne null)?entry.rate.id:'-1' }" />
				<span class="col-md-4"><input type="number" name="rate"
					placeholder="Rate"
					value="${(entry ne null) and (entry.rate ne null)?entry.rate.val:''}"
					step="0.01" data-parsley-required="true" data-parsley-type="number"
					data-parsley-min="0" class="form-control input-sm" /></span> <select
					name="priceUnitOptions" id="priceUnitOptions"
					class="col-md-3 form-group">
					<c:forEach items="${priceUnitOptions}" var="priceUnitOption">
						<option value="${priceUnitOption.code}"
							${(entry ne null) and (entry.rate ne null) and (entry.rate.unit eq priceUnitOption.code) ?'selected':''}>
							${priceUnitOption.name}</option>
					</c:forEach>
				</select> <select name="currencyOptions" id="currencyOptions"
					class="col-md-3 form-group">
					<c:forEach items="${currencyOptions}" var="currencyOption">
						<option value="${currencyOption.code}"
							${(entry ne null) and (entry.rate ne null) and (entry.rate.currency eq currencyOption.code) ?'selected':''}>
							${currencyOption.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
</div>