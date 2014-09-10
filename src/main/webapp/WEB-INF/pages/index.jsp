<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css" />
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h2>Publish a Message</h2>

            <form method="POST" action="publish" name="testForm">
                <table class="table">
                    <tr>
                        <td>
                            <label id="firstName">First Name </label>
                        </td>
                        <td>
                            <input type="text" name="firstName" required="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label id="lastName">Last Name </label>
                        </td>
                        <td>
                            <input type="text" name="lastName" required="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label id="age">Your Age </label>
                        </td>
                        <td>
                            <input type="number" name="age" required="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label id="interests">Your Interests </label>
                        </td>
                        <td>
                            <input type="text" name="interests"
                                   required="true"
                                   class="form-control"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Submit"/>
                        </td>
                    </tr>
                </table>
            </form>

        </div>
    </div>
</div>
</body>
</html>

