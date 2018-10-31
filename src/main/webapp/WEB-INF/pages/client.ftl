<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title><@spring.message "label_client_info"/></title>

</head>
<body>


<h3><@spring.message "label_client_info"/> </h3>
<br/>

<table>

    <tr>
        <th><@spring.message "label_id"/></th>
        <th><@spring.message "label_first_name"/></th>
        <th><@spring.message "label_last_name"/></th>
        <th><@spring.message "label_phone_number"/></th>
        <th><@spring.message "label_birth_day"/></th>
    </tr>

    <tr>
        <td><a href="client/${client.id}">${client.id}</a></td>
        <td>${client.firstName}</td>
        <td>${client.lastName}</td>
        <td>${client.phone_number}</td>
        <td>${client.birthDay}</td>
    </tr>

    <#if accounts??>
        <#list accounts as account>
    <table>

        <tr>
            <th><@spring.message "label_number_account"/></th>
            <th><@spring.message "label_money"/></th>
        </tr>

        <tr>
            <td>${account.id}</td>
            <td>${account.money}</td>
            <td><a href="/accounts/del/${client.login}/${account.id}"> <@spring.message "label_delete"/></a></td>
            <td><a href="/accounts/new/${client.id}"> <@spring.message "label_newAccount"/></a></td>
            <td><a href="/accounts/transfer/${client.login}"> <@spring.message "label_send"/></a></td>
        </tr>

    </table>
        </#list>
    </#if>



</body>
</html>
