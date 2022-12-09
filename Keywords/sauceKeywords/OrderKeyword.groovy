package sauceKeywords
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class OrderKeyword {
	@Keyword
	def GetCountBadges() {
		String getCount = WebUiCommonHelper.findWebElement(findTestObject('inventory_item_page/cart_badge'), 30).getText()

		WebUI.verifyElementText(findTestObject('inventory_item_page/cart_badge'), getCount)
	}

	@Keyword
	def RemoveItem() {
		switch (WebUI.verifyElementText(findTestObject('order_page/button_Remove'), 'REMOVE')) {
			case true:
				for (int i = 0; i < 6; i++) {
					WebUI.click(findTestObject('order_page/button_Remove'))
				}
			default:
				WebUI.click(findTestObject('order_page/button_Continue_Shopping'))

				break
		}
	}

	@Keyword
	def RemoveItemHome() {
		switch (WebUI.verifyElementText(findTestObject('inventory_item_page/button_RemoveItem'), 'REMOVE')) {
			case true:
				for (int i = 0; i < 6; i++) {
					WebUI.click(findTestObject('inventory_item_page/button_RemoveItem'))
				}
			default:
				break
		}
	}

	@Keyword
	def AddtoCharts() {
		for (int i = 0; i < 6; i++) {
			WebUI.click(findTestObject('inventory_item_page/button_AddToCart'))
		}
	}
}