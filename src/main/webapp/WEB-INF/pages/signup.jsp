<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FirebaseUI Auth Demo</title>
    <script src="https://cdn.firebase.com/libs/firebaseui/1.0.0/firebaseui.js"></script>
    <link type="text/css" rel="stylesheet" href="https://cdn.firebase.com/libs/firebaseui/1.0.0/firebaseui.css" />
    <script src="https://www.gstatic.com/firebasejs/live/3.6/firebase.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/scripts/config.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div id="container">
    <div id="loading">Loading...</div>
    <div id="loaded" class="hidden">
        <div id="main">
            <div id="user-signed-in" class="hidden">
                <div id="user-info">
                    <div id="photo-container">
                        <img id="photo" />
                    </div>
                    <div id="name"></div>
                    <div id="email"></div>
                    <div class="clearfix"></div>
                </div>
                <div id="account-details"></div>
                <p>
                    <button id="sign-out">Sign Out</button>
                    <button id="delete-account">Delete account</button>
                </p>
            </div>
            <div id="user-signed-out" class="hidden">
                <h4>You are signed out.</h4>
                <div id="firebaseui-spa">
                    <h5>Single Page Application mode:</h5>
                    <div id="firebaseui-container"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/scripts/app.js"></script>
</body>
</html>
