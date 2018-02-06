package main.scala.edu.knoldus.databaseHandler

import main.scala.edu.knoldus.database.{Category, Item, Vendor}

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

class ItemDb {

  val itemList = new ListBuffer[Item]

  def addItem(itemId: String, itemName: String, description: String, price: Int, quantity: Int, category: Category, vendorInfo: Vendor): ListBuffer[Item] = {

    val newItem = Item(itemId,itemName,description,price,quantity,category,vendorInfo)
    itemList += newItem
    itemList
  }

  def showAllItems(): List[Item] = {
    itemList.toList
  }

  def searchByName(name: String): List[Item] = {
    @tailrec
    def search(name: String, resultList: List[Item], inventory: List[Item]): List[Item] = {

      inventory match {
        case head :: tail if head.itemName.equalsIgnoreCase(name) => search(name, head :: resultList, tail)
        case _ => List()
      }

    }
    search(name, List(), itemList.toList)
  }

  def searchById(id: String): Item = {
    @tailrec
    def search(id: String, inventory: List[Item]): Item = {

      inventory match {
        case head :: _ if head.itemId.equalsIgnoreCase(id) => head
        case _ :: tail => search(id, tail)
      }

    }
    search(id , itemList.toList)
  }

  def deleteItem(item: Item) : List[Item] ={
    itemList -= item
    itemList.toList
  }

}
