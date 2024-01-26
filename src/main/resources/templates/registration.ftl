<#import "/spring.ftl" as spring>
<#import "templ/templ.ftl" as p>
<@p.page>
    <h2> Registration </h2>
    <@spring.bind "users"/>

    <form method="post" action="/registration">

        <label>Login</label><br>
        <@spring.formInput "users.username"/>
        <@spring.showErrors "<br>"/><br>

        <label>Password</label><br>
        <@spring.formInput "users.password"/>
        <@spring.showErrors "<br>"/><br>

        <@spring.bind "clients"/>

        <label>Name</label><br>
        <@spring.formInput "clients.firstName"/>
        <@spring.showErrors "<br>"/><br>

        <label>Last Name</label><br>
        <@spring.formInput "clients.lastName"/>
        <@spring.showErrors "<br>"/><br>

        <label>Phone number</label><br>
        <@spring.formInput "clients.phone"/>
        <@spring.showErrors "<br>"/><br>

        <label>Age</label><br>
        <@spring.formInput "clients.age"/>
        <@spring.showErrors "<br>"/><br>

        <label>Email</label><br>
        <@spring.formInput "clients.email"/>
        <@spring.showErrors "<br>"/><br>

        <button type="submit">Create</button>
    </form>


</@p.page>