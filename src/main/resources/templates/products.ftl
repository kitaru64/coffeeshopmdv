<#import "templ/templ.ftl" as p>

<@p.page>
    <h2>Products list</h2>

    <div class="row row-cols-2 row-cols-md-3 g-4">

        <#if productByCategory??>
            <#list productByCategory as product>


                <form action="/addItemToCart" method="post">
                    <div class="col">
                        <div class="card">
                            <input type="hidden" name="id" value="${product.id}">
                            <a href="/category/${product.id}">
                                <img src="${product.image}" class="card-img-top" alt="user">
                            </a>
                            <div class="card-body">
                                <h5 class="card-title text-center">${product.name}</h5>
                                <p class="card-text">${product.description}</p>
                                <p class="card-title text-center">${product.price} $</p>
                                <p class="card-title text-center">
                                    <input type="number" name="quantity" value="1" min="0" size="1">
                                </p>
                            </div>
                            <button type="submit">Add to Cart</button>
                        </div>
                    </div>
                </form>
            </#list>
        </#if>

    </div>

</@p.page>