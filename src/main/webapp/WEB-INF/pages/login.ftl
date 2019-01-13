<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#import "/spring.ftl" as spring/>
<#import  "templates/common.ftl" as c>


<@c.page>
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
        <div class="alert alert-danger" role="alert">
            ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </#if>

<form action="/check" method="post">
    <label for="client_login">Username</label>
    <input type="text"  name="client_login"><br/>
    <label for="client_password">Password</label>
    <input type="text"   name="client_password"><br/>
    <input type="submit"  value="LOGIN!">
</form>

</@c.page>

