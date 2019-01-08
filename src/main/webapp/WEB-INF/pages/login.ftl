<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html xmlns:sf="http://www.w3.org/1999/html">




<head>
    <meta charset="UTF-8"/>
    <title><@spring.message "label_register"/></title>

</head>
<body>
<form action="/check" method="post">
    <label for="client_login">Username</label>
    <input type="text"  name="client_login"><br/>
    <label for="client_password">Password</label>
    <input type="text"   name="client_password"><br/>
    <input type="submit"  value="LOGIN!">
</form>
</body>
</html>
