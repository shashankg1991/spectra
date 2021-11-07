<%@ attribute name="product" required="false"
	type="com.spectra.jewel.data.ws.ProductWsData"%>
<%@ attribute name="metalColorOptions" required="true"
	type="java.util.List"%>
<%@ attribute name="metalPurityOptions" required="true"
	type="java.util.List"%>
<%@ attribute name="sizeOptions" required="true" type="java.util.List"%>
<%@ attribute name="diamondGradeOptions" required="true"
	type="java.util.List"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:htmlEscape defaultHtmlEscape="true" />



<div class="row col-md-12 mt-2">
	<label for="metalColor" class="col-md-3 col-form-label">Default
		Metal Color</label> <select name="metalColorOptions" id="metalColorOptions"
		class="col-md-3 form-group">
		<c:forEach items="${metalColorOptions}" var="metalColorOption">
			<option value="${metalColorOption}"
				${(product ne null) and (product.defaultMetalColor eq metalColorOption) ?'selected':''}>${metalColorOption}</option>
		</c:forEach>
	</select> <label for="metalPurity" class="col-md-3 col-form-label">Default
		Metal Purity</label> <select name="metalPurityOptions" id="metalPurityOptions"
		class="col-md-1 form-group">
		<c:forEach items="${metalPurityOptions}" var="metalPurityOption">
			<option value="${metalPurityOption.code}"
				${(product ne null) and (product.defaultMetalPurity eq metalPurityOption) ?'selected':''}>${metalPurityOption.name}</option>
		</c:forEach>
	</select>
</div>
<div class="row col-md-12">
	<label for="metalColor" class="col-md-3 col-form-label">Default
		Size</label> <select name="sizeOptions" id="sizeOptions"
		class="col-md-3 form-group">
		<c:forEach items="${sizeOptions}" var="sizeOption">
			<option value="${sizeOption.code}"
				${(product ne null) and (product.defaultSize eq sizeOption) ?'selected':''}>${sizeOption.name}</option>
		</c:forEach>
	</select> <label for="diamondGrade" class="col-md-3 col-form-label">Default
		Diamond Grade</label> <select name="diamondGradeOptions"
		id="diamondGradeOptions" class="col-md-1 form-group">
		<c:forEach items="${diamondGradeOptions}" var="diamondGradeOption">
			<option value="${diamondGradeOption.code}"
				${(product ne null) and (product.defaultDiamondGrade eq diamondGradeOption) ?'selected':''}>${diamondGradeOption.name}</option>
		</c:forEach>
	</select>
</div>
