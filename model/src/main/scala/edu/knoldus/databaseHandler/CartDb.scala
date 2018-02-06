package edu.knoldus.databaseHandler

import main.scala.edu.knoldus.database.Item

import scala.collection.mutable.ListBuffer

class CartDb {

  val itemsInCart = new ListBuffer[Item]

  def addItemInCart(item: Item): List[Item] = {
    itemsInCart += item
    itemsInCart.toList
  }

  def deleteItemFromCart(item: Item): List[Item] ={
    itemsInCart -= item
    itemsInCart.toList
  }

  def emptyCart(): Boolean ={
    itemsInCart.clear()
    true
  }
}
