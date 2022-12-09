import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Login/Login Standard'), [('username') : 'standard_user', ('password') : 'secret_sauce'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('inventory_item_page/button_AddToCart'))

WebUI.click(findTestObject('inventory_item_page/shopping_cart_container'))

WebUI.callTestCase(findTestCase('Checkout/Cancel Checkout'), [:], FailureHandling.STOP_ON_FAILURE)

assert WebUI.getUrl() == (GlobalVariable.url + 'inventory.html')

