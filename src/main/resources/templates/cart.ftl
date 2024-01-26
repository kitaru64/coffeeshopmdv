<#import "templ/templ.ftl" as p>

<@p.page>
    <h2>Cart</h2>

    <#if cart??>

        <table class="table table-striped">
        <thead>
        <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total price</th>
            <th>Update</th>
            <th>Remove</th>
        </tr>
        </thead>
        <tbody>
        <#list cart as item>
            <tr>
                <th><img src="${item.product.image}" height="25px" alt="${item.product.name}"></th>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <form action="/updateProductFromCart" method="post">
                    <input type="hidden" name="id" value="${item.product.id}">
                    <td><input type="number" name="quantity" value="${item.quantity}"></td>
                    <td>${item.quantity * item.product.price}</td>
                    <td>
                        <button type="submit" class="btn btn-primary">Update</button>
                    </td>
                </form>

                <td>
                    <form action="/deleteProductFromCart" method="post">
                        <input type="hidden" name="id" value="${item.product.id}">
                        <button type="submit" class="btn btn-success">Delete</button>
                    </form>
                </td>
            </tr>
        </#list>
    </#if>
    </tbody>
    </table>
        <h5><b><i> Total price: [ ${total} $ ] </i></b></h5>
        <h5><b><i> Total count: [ ${sum} ] </i></b></h5>
    <h6> <form action="/deleteAllProductFromCart" method="post">
            <button class="btn btn-primary bi bi-1-square" type="submit">  Clear cart</button>
        </form>
    </h6>
        <h6> <a href="/category"> Return to category </a></h6>
        <h6> <a href="/login"> Confirm </a></h6>
</@p.page>