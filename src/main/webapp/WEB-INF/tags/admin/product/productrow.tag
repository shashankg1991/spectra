<%@ attribute name="product" required="true"
	type="com.spectra.jewel.data.ws.ProductWsData"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<tr>
	<td>${product.id}</td>
	<td><c:if test="${product.images ne null}">
			<img src="${ product.images[0].url}" width="100px">
		</c:if></td>
	<td><a href="/p/${product.code}">${product.code}</a></td>
	<td>${product.name}</td>
	<td><a href="/adminproduct/edit/${product.code}"
		class="btn btn-primary ">Edit</a> <a
		href="/adminproduct/delete/${product.code}" class="btn btn-danger">Delete</a></td>
</tr>