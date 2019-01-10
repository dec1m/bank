<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#import "/spring.ftl" as spring/>
<#import  "templates/common.ftl" as c>


<@c.page>

<form action="/check" method="post">
    <label for="client_login">Username</label>
    <input type="text"  name="client_login"><br/>
    <label for="client_password">Password</label>
    <input type="text"   name="client_password"><br/>
    <input type="submit"  value="LOGIN!">
</form>

</@c.page>