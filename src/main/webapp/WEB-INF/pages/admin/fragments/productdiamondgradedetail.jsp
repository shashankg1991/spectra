<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row diamond-grade-detail  m-2 p-2 bg-light">
	<div class="row col-md-12">
		<div class="form-group col-md-11 row">
			<span class="col-md-3">Grade:</span> <select name="weightUnitOptions"
				id="weightUnitOptions" class="col-md-6 form-group">
				<c:forEach items="${diamondGradeOptions}" var="diamondGradeOption">
					<option value="${diamondGradeOption.code}">${diamondGradeOption.name}</option>
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
	</div>
</div>