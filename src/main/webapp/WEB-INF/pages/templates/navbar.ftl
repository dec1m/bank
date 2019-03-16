<#include  "security.ftl">
<#import "/spring.ftl" as spring/>
<#assign  security=JspTaglibs["http://www.springframework.org/security/tags"] />
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">EugenBank</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="/"><@spring.message "label_home_page"/></span></a>
            </li>
            <@security.authorize  access="hasRole('ROLE_ADMIN')">
            <li class="nav-item ">
                <a class="nav-link" href="/clients"><@spring.message "label_Allclients"/></span></a>
            </li>

            </@security.authorize>
            <@security.authorize access="!isAuthenticated()">
                <li class="nav-item ">
                    <a class="nav-link" href="/register"><@spring.message "label_register"/></span></a>
                </li>
            </@security.authorize>
            <@security.authorize access="!isAuthenticated()">
            <li class="nav-item ">
                <a class="nav-link" href="/login"><@spring.message "label_auth"/></span></a>
            </li>
            </@security.authorize>

            <@security.authorize access="isAuthenticated()">
                <li class="nav-item ">
                    <a class="nav-link" href="/client/${id}"><@spring.message "label_my_account"/></span></a>

                </li>

            <li class="nav-item ">
                <a class="nav-link" href="/perform_logout"><@spring.message "label_out"/></span></a>
            </li>
            </@security.authorize>
        </ul>
        <span id="blockLocale">
            <a href="?lang=ru"><img width="20" height="20" src="../../../img/locale/ru.png" />ru </a>
            <a href="?lang=en"><img width="20" height="20"  src="../../../img/locale/en.png"/>en </a>
        </span>

        <div class="navbar-text mr-3"><@spring.message "label_welcome"/>, ${name}</div>
    </div>
</nav>
