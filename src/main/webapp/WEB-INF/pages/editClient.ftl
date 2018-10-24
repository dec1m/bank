<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title><@spring.message "label_register"/></title>

</head>
<body>

<h2><@spring.message "label_update"/></h2>

<form name="client" action="/update" method="post">
    <p><@spring.message "label_id"/></p>
    <input title="<@spring.message "label_id"/>"  type="text" name="id" value="${client.id}"  >
    <p><@spring.message "label_first_name"/></p>
    <input title="<@spring.message "label_first_name"/>" type="text" name="firstName" value="${client.firstName}">
    <p><@spring.message "label_last_name"/></p>
    <input title="<@spring.message "label_last_name"/>" type="text" name="lastName" value="${client.lastName}">
    <p><@spring.message "label_password"/></p>
    <input title="<@spring.message "label_password"/>" type="text" name="password" value="${client.password}">
    <p><@spring.message "label_login"/></p>
    <input title="<@spring.message "label_login"/>" type="text" name="login" value="${client.login}">

    <#--<p><@spring.message "label_authority"/></p>-->
    <#--<input title="<@spring.message "label_authority"/>" type="text" name="role" value="${client.role}">-->


    <p><@spring.message "label_authority"/></p>

    <select   name="role"   size="1" >
        <option  value="<@spring.message "admin"/>"><@spring.message "label_admin"/></option>
        <option  selected value="<@spring.message "user"/>"><@spring.message "label_user"/></option>
        <option value="<@spring.message "anonymous"/>"><@spring.message "label_anonymous"/></option>
    </select>




    <p><@spring.message "label_phone_number"/></p>
    <input title="<@spring.message "label_phone_number"/>" type="text" name="phone_number" value="${client.phone_number}">
    <p><@spring.message "label_birth_day"/></p>
    <input title="<@spring.message "label_birth_day"/>"  type="text"   name="birthDay"  value="${client.birthDay}">
    <input type="submit" value="<@spring.message "label_update"/>">
</form>
</body>
</html>
