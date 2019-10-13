<%-- 
    Document   : editAccountPage
    Created on : Oct 10, 2019, 8:52:22 PM
    Author     : Amer Delic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div id="header"></div>
<form action="AccountControllerFront" method="POST">
    <div class="col">
        <div class="row">
            <div class="col mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="e-profile">
                            <div class="row">
                                <div class="col d-flex flex-column flex-sm-row justify-content-between mb-3">
                                    <div class="text-center text-sm-left mb-2 mb-sm-0">
                                        <h4 class="pt-sm-2 pb-1 mb-0 text-nowrap">${user.getUserName()}</h4>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-content pt-3">
                                <div class="tab-pane active">
                                    <form class="form">
                                        <div class="row">
                                            <div class="col">
                                                <div class="row">
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label>UserName</label>
                                                            <input class="form-control" type="text" name="userName" value="${user.getUserName()}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label>Email</label>
                                                            <input class="form-control" type="text" name="email" value="${user.getEmail()}" readonly>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col mb-3">
                                                        <div class="form-group">
                                                            <label>About Me</label>
                                                            <textarea class="form-control" name="aboutMe" rows="5">${user.getAboutMe()}</textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col">
                                                        <div class="col d-flex justify-content-end">
                                                            <button class="btn btn-primary" type="submit" name="updateAboutMeButton">Update About Me</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-12 col-sm-6 mb-3">
                                                <div class="mb-2"><b>Change Password</b></div>
                                                <div class="row">
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label>Current Password</label>
                                                            <div style="color:red"><c:out value="${errors.getErrors().wrongPassword}" /></div>
                                                            <input class="form-control" type="password" name="oldPassword" placeholder="Current Password">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label>New Password</label>
                                                            <div style="color:red"><c:out value="${errors.getErrors().password}" /></div>
                                                            <div style="color:red"><c:out value="${errors.getErrors().passwordsNotEqual}" /></div>
                                                            <input class="form-control" type="password" name="password" placeholder="New Password">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label>Confirm Password</label>
                                                            <div style="color:red"><c:out value="${errors.getErrors().password}" /></div>
                                                            <div style="color:red"><c:out value="${errors.getErrors().passwordsNotEqual}" /></div>
                                                            <input class="form-control" type="password" name="confirmNewPassword" placeholder="Confirm New Password">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col">
                                                        <div class="col d-flex justify-content-end">
                                                            <button class="btn btn-primary" type="submit" name="changePasswordButton">Update Password</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<div id="footer"></div>
<script src="//code.jquery.com/jquery-3.3.1.js"></script>
<script>
    $(function () {
        $("#header").load("header.jsp");
        $("#footer").load("footer.jsp");
    });
</script>