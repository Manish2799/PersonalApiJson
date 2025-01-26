Feature: Test All personalInformation Api Endpoints using diff http requests

Background: 
* user set Baseuri

Scenario: Personal Info Create Entity
Given get Request Sepcification
And create and attach Req body 
When select http post request from RequestSpeccification Object
Then capture PersonalInfo id
And then get ValidatableResponse Object
And validate status code as 201 and Status Line as "201 Created"
And Validate Response Time should be below 7000 ms
And validate "Content-Type" and "application/json" Response Header
And validate "Date" and Current date and time response Header
And validate Json Schema 
And print repsonse logs
 