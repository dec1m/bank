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
        <td><a href="client/${client.id}">${client.id}</a></td>
        <td>${client.firstName}</td>
        <td>${client.lastName}</td>
        <td>${client.phone_number}</td>
        <td>${client.birthDay}</td>
    </tr>



    <table>

        <tr>
            <th><@spring.message "label_number_account"/></th>
            <th><@spring.message "label_money"/></th>
        </tr>

        <tr>
            <td>${client.account.id}</td>
            <td>${client.account.money}</td>
            <td><a href="/transfer"> <@spring.message "label_send"/></a></td>
        </tr>

    </table>




</body>

</@c.page>