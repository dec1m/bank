<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html xmlns:sf="http://www.w3.org/1999/html">




<head>
    <meta charset="UTF-8"/>
    <title><@spring.message "label_register"/></title>

</head>
<body>
<h2><@spring.message "label_register"/></h2>

<@sf.form action="/register" method="post" name="client" modelAttribute="client" >
    <div>
        <@sf.label path"firstName"><@spring.message "label_first_name"/></@sf.label>
        <@sf.input path="firstName" />
        <@sf.errors path="firstName" />
    </div>

  <div>
        <@sf.label path"lastName"><@spring.message "label_last_name"/></@sf.label>
        <@sf.input path="lastName" />
        <@sf.errors path="lastName" />
  </div>
  <div>
        <@sf.label path"login"><@spring.message "label_login"/></@sf.label>
        <@sf.input path="login"  />
        <@sf.errors path="login" />
  </div>
  <div>
        <@sf.label path"password"><@spring.message "label_password"/></@sf.label>
        <@sf.input path="password"  />
        <@sf.errors path="password" />
  </div>

  <div>
        <@sf.label path"phone_number"><@spring.message "label_phone_number"/></@sf.label>
        <@sf.input path="phone_number" />
        <@sf.errors path="phone_number" />
  </div>

  <div>
        <@sf.label path"birthDay"><@spring.message "label_birth_day"/></@sf.label>
        <@sf.input path="birthDay" />
        <@sf.errors path="birthDay" />
  </div>
<input type="submit" value="<@spring.message "label_register"/>"/>
</@sf.form>



</body>
</html>
