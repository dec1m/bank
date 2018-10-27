<#import "/spring.ftl" as spring/>
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><@spring.message "label_transfer"/></title>
</head>
<body>

<@sf.form action="/transfer" method="post" name="transfer" modelAttribute="transfer" >
    <label for="money"><@spring.message "label_money"/></label>
   <@sf.input path="countMoney" />
<label for="whom"><@spring.message "label_you_account"/></label>
   <@sf.input path="idAccountSender" />
<label for="whom"><@spring.message "label_whom"/></label>
   <@sf.input path="idAccountTarget" />

    <input type="submit"  value="<@spring.message "label_transfer"/>">
</@sf.form>
</body>
</html>
