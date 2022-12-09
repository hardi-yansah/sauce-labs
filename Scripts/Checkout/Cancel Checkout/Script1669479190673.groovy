import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.click(findTestObject('order_page/button_Checkout'))

WebUI.setText(findTestObject('order_page/input_firstName'), 'Test First Name')

WebUI.setText(findTestObject('order_page/input_lastName'), 'Test Last Name')

WebUI.setText(findTestObject('order_page/input_postalCode'), '15415')

WebUI.click(findTestObject('order_page/input_continue'))

WebUI.click(findTestObject('order_page/button_Cancel_order'))

