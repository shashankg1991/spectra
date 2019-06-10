<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<t:page>
	<div class="container-register form-container">
		<h4>Sign-up for Spectra</h4>
		<c:if test="${not empty errorMessge}">
			<div class="global-form-error">${errorMessge}</div>
		</c:if>
		<form:form method="POST" modelAttribute="userRegistrationForm" class="form-horizontal">
			<div class="row">
				<div class="form-group col-md-12">
					<form:input type="text" placeholder="First Name" path="firstName"
						id="firstName" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="firstName" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<form:input type="text" placeholder="Last Name" path="lastName"
						id="lastName" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="lastName" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<form:input type="text" placeholder="Email" path="email" id="email"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="email" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<form:input type="text" placeholder="Username" path="username"
						id="username" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="username" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<form:input type="password" placeholder="Password" path="password"
						id="password" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="password" class="help-inline" />
					</div>
				</div>
			</div>
			<!-- Only admin can register a user with role -->
			<security:authorize access="hasRole('ADMIN')">
				<div class="row">
					<div class="form-group col-md-12 roles">
						<label class="col-md-3" for="roles">Roles</label>
						<div class="col-md-7">
							<form:select path="roles" items="${roles}" multiple="false"
								itemValue="id" itemLabel="name" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="roles" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</security:authorize>

			<div class="row">
				<div class="form-actions  col-md-12">
					<input type="submit" value="Register"
						class="btn btn-primary btn-sm registerBtn">
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 signin">
					<a href="/login">Already a user? SignIn</a>
				</div>
			</div>
		</form:form>
	</div>
</t:page>
