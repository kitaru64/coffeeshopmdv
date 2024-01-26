<#import "templ/templ.ftl" as p>

<@p.page>
    <h2>Category list</h2>

    <div class="row row-cols-2 row-cols-md-3 g-4">

        <#if categories??>
        <#list categories as category>

        <div class="col">
            <div class="card">
                <a href="/category/${category.id}">
                    <img src="${category.image}" class="card-img-top" alt="user">
                </a>
                <div class="card-body text-center">
                    <h5 class="card-title">${category.name}</h5>
                </div>
            </div>
        </div>
        </#list>
        </#if>

    </div>

</@p.page>