package main.edu.knoldus

import edu.knoldus.databaseHandler.CartDb
import main.scala.edu.knoldus.database.Item
import main.scala.edu.knoldus.databaseHandler.ItemDb

class CheckoutService {

/*  def getPrice(itemId: String): Int = {
    val price = (new InventoryServices).searchById(itemId).price
    price
  }*/

  def addItemInCart(item: Item) = {
    (new ItemDb).deleteItem(item)
    (new CartDb).addItemInCart(item)
  }

  def deleteItemFromCart(item: Item) = {
    (new ItemDb).addItem(item.itemId,item.itemName,item.description,item.price,item.quantity,item.category,item.vendorInfo)
    (new CartDb).deleteItemFromCart(item)
  }

  def placeOrder(): Boolean = {
    if(!((new CartDb).itemsInCart.isEmpty)) placeOrder() else false
  }



}
