<#import "/spring.ftl" as spring/>
<#import  "templates/common.ftl" as c>


<@c.page>

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
        <td>${client.id}</td>
        <td>${client.firstName}</td>
        <td>${client.lastName}</td>
        <td>${client.phone_number}</td>
        <td>${client.birthDay}</td>
    </tr>


    <#if accounts??>
    <table>

        <tr>
            <th><@spring.message "label_number_account"/></th>
            <th><@spring.message "label_money"/></th>
            <th><@spring.message "label_currency"/></th>
        </tr>





            <#list accounts as account>
        <tr>
            <td>${account.id}</td>
            <td>${account.money}</td>
            <td>${account.currency}</td>
            <td><a href="account/delete/#{client.id}/#{account.id}"><@spring.message "label_delete"/> </a></td>

            <td><a href="/transfer/${account.id}"> <@spring.message "label_send"/></a></td>
        </tr>
            </#list>






    </table>
    </#if>
    <a href="#{client.id}/account/new"><@spring.message"label_open_new_account"/></a>



</body>

</@c.page>