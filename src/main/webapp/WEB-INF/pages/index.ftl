<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><@spring.message "label_home_page"/></title>
</head>
<body>
<center>
<h2><@spring.message "label_home_page"/></h2>
    <h3><a href="/clients"><@spring.message "label_Allclients"/></a></h3>
    <h3><a href="/register"><@spring.message "label_register"/></a></h3>
    <h3><a href="/login"><@spring.message "label_auth"/></a></h3>
    <h4><a href="/perform_logout"><@spring.message "label_out"/></a> </h4>

</center>

</body>
</html>