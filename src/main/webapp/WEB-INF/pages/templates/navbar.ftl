<#include  "security.ftl">
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
                <a class="nav-link" href="/perform_logout"><@spring.message "label_out"/></span></a>
            </li>
            </@security.authorize>
        </ul>

        <div class="navbar-text mr-3">Здравствуйте, ${name}</div>
    </div>
</nav>
