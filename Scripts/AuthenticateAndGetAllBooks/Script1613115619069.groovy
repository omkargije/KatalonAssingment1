import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.assertj.core.api.Assertions

ResponseObject PostResponse = WS.sendRequest(findTestObject('Authenticate'))
Assertions.assertThat(PostResponse.getStatusCode()).isEqualTo(200)

JsonSlurper parser = new JsonSlurper()
String response1 = parser.parseText(PostResponse.getResponseBodyContent())

String str=response1.substring(10,201);
token=str;
println(token)



//token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTYxMzIwOTM3Nn0.m8YBzJznWue7J7OQ_1Ch6eYZaJt5d8Xzv94XKcgqDAHi9C6uR_Hx4vttVysjYFWtTWwXrVfAq0Hr1a0bb7hbmA";

ResponseObject GetResponse1 = WS.sendRequest(findTestObject('GetAll Books', [('token') : token ]))

getAllBooksResponse = parser.parseText(GetResponse1.getResponseBodyContent())

Assertions.assertThat(GetResponse1.getStatusCode()).isEqualTo(200)
//println(getAllBooksResponse)

def ItemCount = new groovy.json.JsonSlurper().parseText(GetResponse1.getResponseBodyContent())
println(ItemCount.size())


String test='''{"menu": {
"id": "file",
"tools": {
"actions": [
{"id": "new", "title": "New File"},
{"id": "open", "title": "Open File"},
{"id": "close", "title": "Close File"}
],
"errors": []
}}}'''

String test2='''
	{
		"id": 1,
		"name": "Test2",
		"ibn": "Test"
	},
	{
		"id": 3,
		"name": "Configuration mobile intuitive",
		"ibn": "Center"
	},
	{
		"id": 4,
		"name": "Georgia generate",
		"ibn": "Designer calculating"
	},
	{
		"id": 5,
		"name": "Overpass toolset",
		"ibn": "architectures synthe"
	},
	{
		"id": 6,
		"name": "Cotton Representative software",
		"ibn": "Bedfordshire calcula"
	}'''
Map parsedJson = parser.parseText(test2)
String idValue = parsedJson.
println(idValue)


