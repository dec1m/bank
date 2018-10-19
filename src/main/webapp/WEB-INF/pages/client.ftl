<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Info</title>

</head>
<body>
<h1>Client Info</h1>
<br/>
<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone Number</th>
        <th>Birth Day</th>
    </tr>

  <tr>
      <td><a href="client/${client.id}">${client.id}</a></td>
      <td>${client.firstName}</td>
      <td>${client.lastName}</td>
      <td>${client.phone_number}</td>
      <td>${client.birthDay}</td>
  </tr>

</table>
</body>
</html>
