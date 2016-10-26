<%--

 login component.

 login component

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%>

<cq:includeClientLib categories="jquerysamples" />
<div class="login-page">
  <div class="form">
    <form action=/bin/otpverify method="post">
        Enter OTP:<input type="text" name="otpnumber"/>
        <input type="submit" name="submit" />
    </form>
  </div>
</div>