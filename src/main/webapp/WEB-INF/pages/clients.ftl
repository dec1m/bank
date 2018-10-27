<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8"/>
    <title><@spring.message "label_client_list"/></title>
</head>
<body>

<h3><@spring.message "label_client_list"/></h3>
<br/>
<center>
<table>
    <tr>
        <th><@spring.message "label_id"/></th>
        <th><@spring.message "label_first_name"/></th>
        <th><@spring.message "label_last_name"/></th>
        <th><@spring.message "label_login"/></th>
        <th><@spring.message "label_authority"/></th>
        <th><@spring.message "label_phone_number"/></th>
        <th><@spring.message "label_birth_day"/></th>

    </tr>

<#list clients as client>
  <tr>
      <td><a href="client/${client.id}">${client.id}</a></td>
      <td>${client.firstName}</td>
      <td>${client.lastName}</td>
      <td>${client.login}</td>
      <td>${client.role}</td>
      <td>${client.phone_number}</td>
      <td>${client.birthDay}</td>
      <td><a href="/update/${client.id}"><@spring.message "label_update"/></a></td>
     <td><a href="/delete/${client.id}"> <@spring.message "label_delete"/></a></td>

  </tr>


</#list>
</table>
<a href="/register"><@spring.message "label_register"/></a>
</center>

</body>
</html>
