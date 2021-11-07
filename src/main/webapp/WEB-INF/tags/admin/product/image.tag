<%@ attribute name="image" required="false"
	type="com.spectra.jewel.data.ws.ImageWsData"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="row image m-2 p-2 bg-light">
	<input name="id" type="hidden" value="${image ne null?image.id:'-1' }" />
	<div class="row col-md-12">
		<span class="col-md-2">Metal Color:</span> <select
			name="metalColorOptions" id="metalColorOptions"
			class="col-md-2 form-group">
			<c:forEach items="${metalColorOptions}" var="metalColorOption">
				<option value="${metalColorOption}"
					${(image ne null) and (image.metalColor eq metalColorOption) ?'selected':''}>
					${metalColorOption}</option>
			</c:forEach>
		</select> <span class="col-md-2">Sequence:</span> <span class="col-md-2"><input
			type="number" name="sequence" placeholder="Sequence"
			value="${(image ne null)? image.sequence:''}" step="1"
			data-parsley-required="true" data-parsley-type="number"
			data-parsley-min="0" class="form-control input-sm" /></span>
		<div class="offset-md-3 col-md-1">
			<button class="btn btn-danger float-right image-remove">
				<i class="icon icon-cross"></i>
			</button>
		</div>
	</div>
	<div class="row form-group col-md-12 image-url-details">
		<textarea rows="2" name="url" placeholder="URL"
			data-parsley-required="true"
			class="form-control col-md-8 input-sm image-url">${(image ne null)? image.url:''}</textarea>
		<span class="col-md-4"><img height="100px"
			src="https://static.umotive.com/img/product_image_thumbnail_placeholder.png"
			class="image-preview"></span>
	</div>
</div>