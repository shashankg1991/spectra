<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:page>
	<div class="container-login  form-container">
		<h4>Sign-in</h4>
		<c:if test="${not empty errorMessge}">
			<div class="global-form-error">${errorMessge}</div>
		</c:if>

		<form name="login" action="/login" method="POST">
			<div class="row">
				<div class="form-group col-md-12">
					<input type="text" placeholder="Username" name="username" class="form-control input-sm" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<input type="password" name="password" placeholder="Password" class="form-control input-sm"/>
				</div>
			</div>
			<div class="row">
				<div class="form-actions  col-md-12">
					<input type="submit" value="Login"
						class="btn btn-primary btn-sm loginBtn">
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 signup">
					<a href="/register">New user? SignUp</a>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
</t:page>

