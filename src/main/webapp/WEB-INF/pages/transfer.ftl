<#import "/spring.ftl" as spring/>
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><@spring.message "label_transfer"/></title>
</head>
<body>

<@sf.form action="/transferTo" method="post" name="transfer" modelAttribute="transferDto" >
<label for="money"><@spring.message "label_money"/></label><br/>
   <@sf.input path="countMoney" /><br/>
<label  for="whom"><@spring.message "label_whom_id"/></label><br/>
   <@sf.input  path="idTarget"/><br/>
<input type="submit" value="<@spring.message "label_transfer"/>"><br/>
</@sf.form>
</body>
</html>
