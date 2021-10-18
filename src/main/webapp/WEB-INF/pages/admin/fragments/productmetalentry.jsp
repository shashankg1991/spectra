<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row metal-entry m-2 p-2 bg-light">
	<div class="row col-md-12">
		<div class="form-group col-md-4">
			<div class="col-md-12 row">
				<span class="col-md-4">Weight:</span> <span class="col-md-6"><input
					type="number" name="weight" placeholder="Weight"
					class="form-control input-sm" /></span> <select name="weightUnitOptions"
					id="weightUnitOptions" class="col-md-1 form-group">
					<c:forEach items="${weightUnitOptions}" var="weightUnitOption">
						<option value="${weightUnitOption.code}">${weightUnitOption.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group col-md-4 row">
			<div class="col-md-12 row">
				<span class="col-md-5">Size:</span> <select name="size"
					id="productSizeSelect" class="col-md-7 form-group">
					<c:forEach items="${sizeOptions}" var="sizeOption">
						<option value="${sizeOption.code}">${sizeOption.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group col-md-3 row">
			<div class="col-md-12 row">
				<span class="col-md-5">Purity:</span> <select name="metalPurity"
					id="productSizeSelect" class="col-md-7 form-group">
					<c:forEach items="${metalPurityOptions}" var="metalPurityOption">
						<option value="${metalPurityOption.code}">${metalPurityOption.name}</option>
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