<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row stone-entry  m-2 p-2 bg-light">
	<div class="row col-md-12">
		<div class="form-group col-md-11">
			<textarea rows="2" name="description" placeholder="Description"
				class="form-control input-sm"></textarea>
		</div>
		<div class="col-md-1">
			<button class="btn btn-danger float-right stone-entry-remove">
				<i class="icon icon-cross"></i>
			</button>
		</div>
	</div>
	<div class="row col-md-12">
		<div class="form-group col-md-6">
			<div class="col-md-12 row">
				<span class="col-md-3">Weight:</span> <span class="col-md-6"><input
					type="number" name="weight" placeholder="Weight"
					class="form-control input-sm" /></span> <select name="weightUnitOptions"
					id="weightUnitOptions" class="col-md-2 form-group">
					<c:forEach items="${weightUnitOptions}" var="weightUnitOption">
						<option value="${weightUnitOption.code}">${weightUnitOption.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group col-md-6">
			<div class="col-md-12 row">
				<span class="col-md-3">Rate:</span> <span class="col-md-6"><input
					type="number" name="rate" placeholder="Rate"
					class="form-control input-sm" /></span> <select name="priceUnitOptions"
					id="priceUnitOptions" class="col-md-2 form-group">
					<c:forEach items="${priceUnitOptions}" var="priceUnitOption">
						<option value="${priceUnitOption.code}">${priceUnitOption.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
</div>