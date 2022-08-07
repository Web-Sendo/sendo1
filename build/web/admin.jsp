<%-- 
    Document   : admin
    Created on : Aug 7, 2022, 3:27:15 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Bootstrap User Management Data Table</title>
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
        <link rel="stylesheet" href="./admin.css">
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </head>
    <body>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-5">
                                <img src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAxMzAgMzUiIHdpZHRoPSIxMzAiIGhlaWdodD0iMzUiPjxzd2l0Y2g+PGc+PHBhdGggZmlsbD0iI0ZGRiIgZmlsbC1ydWxlPSJub256ZXJvIiBkPSJNMTAzLjIuOEw5OC42IDI1YTY0IDY0IDAgMCAwLTEuMSA5LjdIOTFsLjQtNC4zaC0uMWE5IDkgMCAwIDEtNy44IDQuNGMtNC4xIDAtNy40LTMuMi03LjQtOSAwLTguMyA2LTE1LjkgMTUtMTUuOSAxLjEgMCAyLjIuMiAzLjMuNkw5Ni4yLjlsNy0uMXpNOTMuMyAxNmE0IDQgMCAwIDAtMi44LS44Yy00LjIgMC03LjIgNC45LTcuMiA5LjUgMCAyLjkgMS4zIDQuNSAzLjMgNC41IDIuMSAwIDQuNS0yLjEgNS40LTYuN2wxLjMtNi41em0tODYgMTAuNmMyLjQgMS40IDUgMi4xIDcuOCAyLjEgMi43IDAgNS4yLTEuMyA1LjItMy45IDAtMS45LTEuNC0zLjEtNC40LTQuNi0zLjYtMS45LTYuOS00LjQtNi45LTguN0M5IDQuOSAxNC44LjggMjIgLjhjNCAwIDYuNC45IDcuOCAxLjdsLTIuMiA1LjljLTEuOS0xLTQtMS41LTYuMS0xLjUtMy4zIDAtNSAxLjctNSAzLjUgMCAxLjkgMiAzLjEgNC44IDQuNiA0IDIuMSA2LjYgNC44IDYuNiA4LjcgMCA3LjMtNi4xIDExLjEtMTMuNCAxMS4xLTQuNiAwLTcuOS0xLjItOS40LTIuM2wyLjItNS45em00MSA2LjNhMjAuNyAyMC43IDAgMCAxLTguOSAxLjljLTYuOCAwLTEwLjMtMy45LTEwLjMtMTBDMjkuMSAxNy41IDM0LjQgMTAgNDMgMTBjNC44IDAgOC4zIDIuNyA4LjMgNy4xIDAgNi4xLTUuOSA4LjMtMTUuNSA4LjEgMCAuOS4zIDEuNy43IDIuNC45IDEuMiAyLjUgMS45IDQuNiAxLjkgMi4zIDAgNC42LS41IDYuNy0xLjVsLjUgNC45ek00Mi4xIDE1Yy0zLjMgMC01LjEgMi43LTUuNiA0LjkgNS41LjEgOC4yLS43IDguMi0yLjkgMC0xLjItLjktMi0yLjYtMnptOC4yIDE5LjdsMy4xLTE2LjZjLjYtMyAxLjEtNi4yIDEuMy04LjNINjFsLS42IDQuNWguMWExMCAxMCAwIDAgMSA4LjQtNC41YzMuOSAwIDYuMSAyLjQgNi4xIDYuNSAwIDEuNC0uMiAyLjctLjQgNC4xbC0yLjcgMTQuM2gtN0w2Ny41IDIxYy4yLS45LjItMS44LjItMi43IDAtMS43LS42LTIuOC0yLjMtMi44LTIuMyAwLTUgMi45LTUuOSA4LjFsLTIuMSAxMS4xaC03LjF6bTc1LjEtMTVjMCA4LjctNS45IDE1LjEtMTQuMiAxNS4xLTYuMSAwLTEwLjEtNC0xMC4xLTkuOSAwLTguMyA1LjgtMTUuMSAxNC4yLTE1LjEgNi40LjEgMTAuMSA0LjUgMTAuMSA5LjltLTE3IDUuMWMwIDIuOCAxLjQgNC42IDMuOCA0LjYgMy45IDAgNi01LjYgNi05LjcgMC0yLjItLjktNC41LTMuOC00LjUtNCAwLTYuMSA1LjktNiA5LjYiLz48cGF0aCBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGQ9Ik0tMS43LTZoMTQyLjZ2NDcuNkgtMS43Vi02eiIvPjwvZz48L3N3aXRjaD48L3N2Zz4=" height="41">
                                <h3>Products <b>Management</b></h3>
                            </div>
                            <div class="col-sm-7">
                                <a href="LogoutController" class="btn btn-secondary"><span>Logout</span></a>	
                                <a href="MainController?action=loadFormAdd" class="btn btn-success" ><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>

                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Product Name </th>						
                                <th>Image</th>
                                <th>Description</th>
                                <th>Status</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Category</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.LIST_PRODUCTS}" var="p">
                                <tr>
                                    <td>${p.productID}</td>
                                    <td>${p.productName}</td> 
                                    <td><img src="${p.image}" width="150" height="100">
                                    </td>  
                                    <td>${p.description}</td>  
                                    <td>${p.status}</td>  
                                    <td>${p.quantity}</td>  
                                    <td>${p.price}VNĐ</td>
                                    <td>${p.categoryID}</td>
                                    <td>
                                        <a href="MainController?action=loadFormUpdate&productID=${p.productID}"  onclick="return confirm('Are you sure update Product?')" ><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                        <a href="MainController?action=delete&productID=${p.productID}" onclick="return confirm('Are you sure delete Product?')" ><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                    </td>
                                </c:forEach>
                            </tr>
                        </tbody>
                    </table>
                    <div class="clearfix">

                        <ul class="pagination">
                            <c:forEach begin="1" end="${requestScope.END_PAGE}" var="i">
                                <li class="page-item"><a href="AdminController?index=${i}" class="page-link">${i}</a></li>
                                </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>   
        <!-- Edit Modal HTML -->

        <c:if test="${requestScope.SUCCESS != null}">
            <script>
                alert('${requestScope.SUCCESS}');
            </script>
        </c:if>

    </body>
</html>
