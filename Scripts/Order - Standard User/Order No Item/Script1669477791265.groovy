import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Login/Login Standard'), [('username') : 'standard_user', ('password') : 'secret_sauce'], 
    FailureHandling.STOP_ON_FAILURE)

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