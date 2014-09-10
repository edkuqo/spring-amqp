<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css" />
    <script src="<c:url value="/resources/resources/js/bootstrap.min.js" />" type="text/javascript"></script>

    <script type="text/javascript">
        $.getJSON('${pageContext.request.contextPath}/sample/get', function (data) {
            $.each(data, function (i, item) {
                var $tr = $('<tr>').append(
                        $('<td>').text(item.id),
                        $('<td>').text(item.firstName),
                        $('<td>').text(item.lastName),
                        $('<td>').text(item.age),
                        $('<td>').text(item.interests),
                        $('<td><form method="POST" action="delete"> ' +
                                '<input type="hidden" name="id" value="' + item.id + '"/>' +
                                '<input type="submit" value="Delete"/>' +
                                '</form>')).appendTo('#results');
            });
        });
    </script>
</head>

<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <h2>List of Messages Published</h2>
            <table id="results" class="table">
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Interests</th>
                    <th>Actions</th>
                </tr>
            </table>
            <table class="table">
                <tr></tr>
                <tr>
                    <td colspan="2">
                        <a href="${pageContext.request.contextPath}/sample/reset">Reset the List</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <a href="${pageContext.request.contextPath}/sample/welcome">Publish new Message</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>


