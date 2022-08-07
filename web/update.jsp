
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Varela Round', sans-serif;
                font-size: 13px;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                min-width: 1000px;
                background: #fff;
                padding: 20px 25px;
                border-radius: 3px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 15px;
                background-color: red;
                color: #fff;
                padding: 16px 30px;
                margin: -20px -25px 10px;
                border-radius: 3px 3px 0 0;
            }
            .table-title h2 {
                margin: 5px 0 0;
                font-size: 24px;
            }
            .table-title .btn {
                color: #566787;
                float: right;
                font-size: 13px;
                background: #fff;
                border: none;
                min-width: 50px;
                border-radius: 2px;
                border: none;
                outline: none !important;
                margin-left: 10px;
            }
            .table-title .btn:hover, .table-title .btn:focus {
                color: #566787;
                background: #f2f2f2;
            }
            .table-title .btn i {
                float: left;
                font-size: 21px;
                margin-right: 5px;
            }
            .table-title .btn span {
                float: left;
                margin-top: 2px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
                padding: 12px 15px;
                vertical-align: middle;
            }
            table.table tr th:first-child {
                width: 60px;
            }
            table.table tr th:last-child {
                width: 100px;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }	
            table.table td:last-child i {
                opacity: 0.9;
                font-size: 22px;
                margin: 0 5px;
            }
            table.table td a {
                font-weight: bold;
                color: #566787;
                display: inline-block;
                text-decoration: none;
            }
            table.table td a:hover {
                color: #2196F3;
            }
            table.table td a.settings {
                color: #2196F3;
            }
            table.table td a.delete {
                color: #F44336;
            }
            table.table td i {
                font-size: 19px;
            }
            table.table .avatar {
                border-radius: 50%;
                vertical-align: middle;
                margin-right: 10px;
            }
            .status {
                font-size: 30px;
                margin: 2px 2px 0 0;
                display: inline-block;
                vertical-align: middle;
                line-height: 10px;
            }
            .text-success {
                color: #10c469;
            }
            .text-info {
                color: #62c9e8;
            }
            .text-warning {
                color: #FFC107;
            }
            .text-danger {
                color: #ff5b5b;
            }
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 13px;
                min-width: 30px;
                min-height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 2px !important;
                text-align: center;
                padding: 0 6px;
            }
            .pagination li a:hover {
                color: #666;
            }	
            .pagination li.active a, .pagination li.active a.page-link {
                background: #03A9F4;
            }
            .pagination li.active a:hover {        
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 10px;
                font-size: 13px;
                .modal .modal-dialog {
                    max-width: 400px;
                }
                .modal .modal-header, .modal .modal-body, .modal .modal-footer {
                    padding: 20px 30px;
                }
                .modal .modal-content {
                    border-radius: 3px;
                    font-size: 14px;
                }
                .modal .modal-footer {
                    background: #ecf0f1;
                    border-radius: 0 0 3px 3px;
                }
                .modal .modal-title {
                    display: inline-block;
                }
                .modal .form-control {
                    border-radius: 2px;
                    box-shadow: none;
                    border-color: #dddddd;
                }
                .modal textarea.form-control {
                    resize: vertical;
                }
                .modal .btn {
                    border-radius: 2px;
                    min-width: 100px;
                }	
                .modal form label {
                    font-weight: normal;
                }	
            }
        </style>
    </head>
    <body>
        <div class="container-xl" >
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-5">
                                <h2>Update <b>Product</b></h2>
                                <a href="MainController?action=admin" class="btn btn-success" > <span>Back Admin Page</span></a>
                            </div>

                        </div>
                    </div>

                </div>
                <div id="editEmployeeModal" >
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="UpdateProductController" method="POST" enctype="multipart/form-data">
                                <div class="modal-header">						
                                    <h4 class="modal-title">Update Product</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <c:set var="error" value="${requestScope.ERROR_CREATE}"/>
                                <c:set value="${requestScope.PRODUCT}" var="p"/>
                                <div class="modal-body">					
                                    <div class="modal-body">					
                                        <div class="form-group">
                                            <label>Product ID</label>
                                            <input type="text" name="productID" value="${p.productID}" class="form-control" required readonly>
                                        </div>
                                        <div class="form-group">
                                            <label>Product Name</label>
                                            <input type="text" name="productName" value="${p.productName}"  class="form-control" required>
                                            <font color="red">${error.productNameError}</font> 
                                        </div>                                      
                                        <div class="form-group">
                                            <label>Image</label>
                                            <img src="${p.image}" width="150" height="100">
                                            <input type="text" name="image" value="${p.image}"  class="form-control" required>
                                               <font color="red">${error.imageError}</font> 
                                        </div>
                                             <div class="form-group">
                                            <label>Description</label>
                                            <input type="text" name="description" value="${p.description}"  class="form-control" required>
                                            <font color="red">${error.descriptionError}</font> 
                                        </div> 
                                        <div class="form-group">
                                            <label>Quantity</label>
                                            <input type="text" name="quantity"  value="${requestScope.QUANTITY}" class="form-control" required>
                                            <font color="red">${error.quantityError}</font> 
                                        </div>
                                        <div class="form-group">
                                            <label>Price</label>
                                            <input type="text" name="price"  value="${requestScope.PRICE}" class="form-control" required>
                                            <font color="red">${error.priceError}</font> 
                                        </div>
                                        <div class="form-group">
                                            <label>Status</label>
                                            <input type="text" name="status" value="${p.status}" class="form-control" required>
                                            <font color="red">${error.statusError}</font> 
                                        </div>
                                        <div class="form-group">
                                            <label>Category</label>
                                            <select name="category">
                                                 <option value="${p.categoryID}">${requestScope.cateName}</option>
                                                 <c:forEach items="${requestScope.LIST_CATEGORY}" var="cate">
                                                    <option value="${cate.categoryID}">${cate.categoryName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>					
                                    </div>			
                                </div>
                                <div class="modal-footer">

                                    <input type="submit" class="btn btn-info" value="Save">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
