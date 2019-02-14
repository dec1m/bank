<#import "/spring.ftl" as spring/>
<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#import  "templates/common.ftl" as c>
<@c.page>

<@sf.form action="/transferTo/#{idAccountSender}" method="post" name="transfer" modelAttribute="transferDto" >
<label for="money"><@spring.message "label_money"/></label><br/>
   <@sf.input path="countMoney" /><br/>
<label  for="whom"><@spring.message "label_whom_id"/></label><br/>
   <@sf.input  path="idTarget"/><br/>
<input type="submit" value="<@spring.message "label_transfer"/>"><br/>
</@sf.form>





</@c.page>