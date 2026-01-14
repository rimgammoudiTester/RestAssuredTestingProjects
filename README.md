/**@Author Rim Gammoudi********/

This is a project representing a dummy restfulApi tested by RestAssured Framework Withn TestNG 
#The project is dedicated to test and maintain dummy apis it's devided in multiple controllers 
#Posts Api
#Albums Api
#Comments Api
#Photos Api
#Todos Api
#Users Api

#The architecture of my project is based on hybrid framework 
It contains a generic class containning all the usefull api's methods (Get/Post/Patch/Delete) that allowed us to recuperate /create .......  objects.
A generic class for  The necessary asserts that we gonna use in our testCases 
A class Treating the apiClient
A  TestCases Ccass deal with the necessary  for certain api controller ( Albums Api's TestCases)
In the testCases Class itself we make sure that the api's schema is correct , and it returns the desired parameters 
With the appropriate expected values
**/The test are excuted with a suites Files Xml
The reporting is executed with the tool Allure-reports 





