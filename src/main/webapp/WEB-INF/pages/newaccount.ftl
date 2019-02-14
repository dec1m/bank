<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#import "/spring.ftl" as spring/>
<#import  "templates/common.ftl" as c>


<@c.page>
    <form name="account" action="/account/new/#{clientId}" method="post" >
        <p><@spring.message "label_currency"/></p>
        <input type="radio" name="currency" value="EUR" > EUR<br>
        <input type="radio" name="currency" value="USD" checked > USD<br>
        <input type="radio" name="currency" value="RUB" > RUB<br>
        <input type="radio" name="currency" value="MDL"> MDL<br>
        <input type="radio" name="currency" value="UAH"> UAH<br>

        <input type="submit"  value="<@spring.message "label_create"/>">

    </form>
</@c.page>