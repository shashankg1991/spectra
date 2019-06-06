<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:page>
	<div class="form-container">

		<h1>New User Registration Form</h1>

		<form:form method="POST" modelAttribute="user" class="form-horizontal">

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">First
						Name</label>
					<div class="col-md-7">
						<form:input type="text" path="firstName" id="firstName"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="firstName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName">Last
						Name</label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="lastName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="username">SSO ID</label>
					<div class="col-md-7">
						<form:input type="text" path="username" id="username"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="username" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Password</label>
					<div class="col-md-7">
						<form:input type="password" path="password" id="password"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="password" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="email"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="email" class="help-inline" />
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="roles">Roles</label>
					<div class="col-md-7">
						<form:select path="roles" items="${roles}" multiple="true"
							itemValue="id" itemLabel="name" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="roles" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-actions floatRight">
					<input type="submit" value="Register"
						class="btn btn-primary btn-sm"> or <a
						href="<c:url value='/admin' />">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>
</t:page>

