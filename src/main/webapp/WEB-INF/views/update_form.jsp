<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>

</head>
<body>

	<section class="h-100 h-custom" style="background-color: #8fc4b7;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-8 col-xl-6">
					<div class="card rounded-3">
						<img
							src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
							class="w-100"
							style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
							alt="Sample photo">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Change Product Details</h3>

							<form method="post" action="${pageContext.request.contextPath }/handle-product">
								
								 <input type="hidden" value="${product.id }" name="id" />
								
								<div class="form-outline mb-4">
									<input type="text" name="name" id="form3Example1q"
										class="form-control" placeholder="Enter Product Name" 
										value="${product.name }"
										/>
								</div>

								<div class="form-outline mb-4">
									<input type="text" name="description" id="form3Example1q"
										class="form-control" placeholder="Enter Description"
										value="${product.description }" />
								</div>

								<div class="form-outline mb-4">
									<input type="text" name="price" id="form3Example1q"
										class="form-control" placeholder="Enter Price" 
										value="${product.price }"/>
								</div>

								<div class="container text-center">

									<a href="${pageContext.request.contextPath }/"
										class="btn btn-outline-danger">Back</a>

									<button type="submit" class="btn btn-warning btn-lg mb-1">Update Product</button>

								</div>
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


</body>
</html>