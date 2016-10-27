Two Factor Authentication
========

Introduction
--------
This is a very basic article on implementing two factor authentication.

Usecase Bank transaction Scenario
--------

1) Once user signs in , goes to transaction gateway, Enters OTP .After successful verification of OTP , he makes payment.  <br />  
2) If suppose user gets to access transaction gateway without signing in then our AuthFilter will check this and redirect it to sign in page  <br />
3) Similarly if he accesses OTP page , without signing ion then our AuthFilter will check this and redirect again to the sign in page.  
<br/>

So any call to servlet /bin/makepayment  has to be verified by two factor authentication before the Servlet is called.
This work is done by our AuthFilter.



