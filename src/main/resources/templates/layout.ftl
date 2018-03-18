<#-- *****************************************************************************
 HTML
*******************************************************************************-->

<#macro html title=""><#compress>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <title><#if title?has_content>${title}<#else><@spring.message "common.layout.title.default" /></#if></title>
    </head>
    <body>
        <#nested>
    </body>
</html>
</#compress></#macro>

<#-- *****************************************************************************
 ERROR
*******************************************************************************-->

<#macro errors code links=[] class="errors main-centering">
    <@html title="error.${code}" class=class>
        <@main>
        <h1 class="errors-title">${code}</h1>
        <p class="errors-info"><@spring.message "error.${code}"/></p>
            <#if links?has_content>
            <ul class="errors-list-link">
                <#list links as link>
                    <li><a href="${link.href}">${link.text}</a></li>
                </#list>
            </ul>
            </#if>
        </@main>
    </@html>
</#macro>
