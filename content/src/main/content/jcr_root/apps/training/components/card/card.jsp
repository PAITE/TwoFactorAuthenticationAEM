<%--

 login component.

 login component

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%>

<cq:includeClientLib categories="jquerysamples" />
<div class="login-page">
  <div class="form">
    <form action=/bin/makepayment method="post">
        Enter Card number:<input type="text" name="cardnumber"/>
        <input type="submit" name="submit" />
    </form>
  </div>
</div>