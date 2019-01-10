<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign

    client = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = client.getLogin()

    >
<#else>
    <#assign
    name = "Гость"
    >
</#if>