<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Clients List</title>
</head>
<body>
<h3>Client List</h3>
<br/>
<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone Number</th>
        <th>Birth Day</th>
    </tr>

<#list clients as client>
  <tr>
      <td>${client.id}</td>
      <td>${client.firstName}</td>
      <td>${client.lastName}</td>
      <td>${client.phone_number}</td>
      <td>${client.birthDay}</td>
  </tr>

</#list>
</table>
</body>
</html>
