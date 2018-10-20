<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title><@spring.message "label_client_info"/></title>

</head>
<body>


<h3><@spring.message "label_client_info"/> </h3>
<br/>
<table>

    <tr>
        <th><@spring.message "label_id"/></th>
        <th><@spring.message "label_first_name"/></th>
        <th><@spring.message "label_last_name"/></th>
        <th><@spring.message "label_phone_number"/></th>
        <th><@spring.message "label_birth_day"/></th>
    </tr>

    <tr>
        <td><a href="client/${client.id}">${client.id}</a></td>
        <td>${client.firstName}</td>
        <td>${client.lastName}</td>
        <td>${client.phone_number}</td>
        <td>${client.birthDay}</td>
    </tr>

</table>
<a href="/clients"><@spring.message "label_all_clients"/></a>
</body>
</html>
