<#import "templ/templ.ftl" as p>
<@p.page>
    <h2> Order </h2>

    <#if client.firstName??>
    <p> Name: <b> ${client.firstName}</b></p>
    <p> Last name:<b>  ${client.lastName}</b></p>
    <p> Phone number :<b>  ${client.phone} </b></p>
    <p> Email :<b>  ${client.email} </b></p>
    </#if>

    <#if cart??>

        <table class="table table-striped">
        <thead>
        <tr>
            <th>image</th>
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th>quantity</th>
            <th>value</th>
        </tr>

        </thead>
        <tbody>

        <#list cart as item>
            <tr>
                <th><img src="${item.product.image}" height="25px" alt="${item.product.name}"></th>
                <td>${item.product.id}</td>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.quantity * item.product.price}</td>
            </tr>
        </#list>
    </#if>

    </tbody>
    </table>
    <h5><b><i> Total price: ${total} $ </i></b></h5>

    <form action="/buy" method="post">
        <h2> Payment </h2>
        <select name="payment">
            <option value="1"> Points</option>
            <option value="2"> Money</option>
        </select>

        <h2> Delivery </h2>
        <select name="delivery">
            <option value="1"> Department #1</option>
            <option value="2"> Department #2</option>
            <option value="3"> Department #3</option>
        </select>

        <button type="submit">Done!</button>
    </form>

</@p.page>