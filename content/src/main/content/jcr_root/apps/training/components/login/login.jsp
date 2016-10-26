<%--

 login component.

 login component

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%>

<cq:includeClientLib categories="jquerysamples" />
<div class="login-page">
  <div class="form">
    <form class="login-form" method="post" action="/content/signinauth/j_security_check">
      <input type="text" name="j_username" placeholder="username"/>
      <input type="password" name="j_password" placeholder="password"/>
      <input type="submit" name="submit">
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
  </div>
</div>