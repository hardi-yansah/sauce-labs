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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Login/Login Standard'), [('username') : 'standard_user', ('password') : 'secret_sauce'], 
    FailureHandling.STOP_ON_FAILURE)

/*
	 * for (i = 0; i < 6; i++) {
	 * WebUI.click(findTestObject('inventory_item_page/button_AddToCart'))
	 * WebUI.click(findTestObject('inventory_item_page/shopping_cart_container'))
	 * WebUI.click(findTestObject('order_page/button_Continue_Shopping')) }
	 * 
	 * getCount = WebUI.getText(findTestObject('inventory_item_page/cart_badge'))
	 * 
	 * WebUI.verifyElementText(findTestObject('inventory_item_page/cart_badge'),
	 * getCount)
	 */
WebUI.click(findTestObject('inventory_item_page/shopping_cart_container'))

WebUI.click(findTestObject('order_page/button_Checkout'))

WebUI.setText(findTestObject('order_page/input_firstName'), 'Test First Name')

WebUI.setText(findTestObject('order_page/input_lastName'), 'Test Last Name')

WebUI.setText(findTestObject('order_page/input_postalCode'), '15415')

WebUI.click(findTestObject('order_page/input_continue'))

WebUI.verifyElementText(findTestObject('order_page/div_checkout_summary'), 'Total: $0.00')

WebUI.click(findTestObject('order_page/button_Finish'))

WebUI.click(findTestObject('order_page/button_Back Home'))

assert WebUI.getUrl() == (GlobalVariable.url + 'inventory.html')
