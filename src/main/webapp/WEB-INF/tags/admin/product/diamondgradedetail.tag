<%@ attribute name="diamondgradedetail" required="false"
	type="com.spectra.jewel.data.ws.ProductDiamondGradeDetailWsData"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/admin/product"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row diamond-grade-detail  m-2 p-2 bg-light">
	<input name="id" type="hidden"
		value="${diamondgradedetail ne null?diamondgradedetail.id:'-1' }" />
	<div class="row col-md-12">
		<div class="form-group col-md-11 row">
			<span class="col-md-3">Grade:</span> <select
				name="diamondGradeOptions" id="diamondGradeOptions"
				class="col-md-6 form-group">
				<c:forEach items="${diamondGradeOptions}" var="diamondGradeOption">
					<option value="${diamondGradeOption.code}"
						${(diamondgradedetail ne null) and (diamondgradedetail.grade eq diamondGradeOption.code) ?'selected':''}>
						${diamondGradeOption.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-md-1">
			<button
				class="btn btn-danger float-right diamond-grade-detail-remove">
				<i class="icon icon-cross"></i>
			</button>
		</div>
	</div>
	<div class="row col-10 offset-md-1 diamond-entries p-2">
		<h5 class="col-md-8">Diamond Entries</h5>
		<div class="form-actions col-md-4">
			<input type="submit" value="Add diamond entry"
				class="btn btn-primary btn-sm float-right add-diamond-entry">
		</div>
		<c:if
			test="${(diamondgradedetail ne null) and (diamondgradedetail.entries ne null) }">
			<c:forEach items="${diamondgradedetail.entries}" var="diamondEntry">
				<product:diamondentry entry="${diamondEntry}" />
			</c:forEach>
		</c:if>
	</div>
</div>