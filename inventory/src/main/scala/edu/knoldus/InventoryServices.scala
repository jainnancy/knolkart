package edu.knoldus

import main.scala.edu.knoldus.database.Item
import main.scala.edu.knoldus.databaseHandler.{CategoryDb, ItemDb, vendorDb}

class InventoryServices {

  def sortList(itemList:List[Item],sortIn: Int): List[Item] = {
    sortIn match{
      case 1 => itemList.sortBy(itemList => itemList.price)
      case 2 => itemList.sortBy(itemList => itemList.price).reverse
      case 3 => itemList
    }
  }

  def showAll(sortBy: Int): List[Item] = {
    sortList((new ItemDb).showAllItems(),sortBy)
  }
  def searchByName(name: String, sortBy: Int): List[Item] = {
    sortList((new ItemDb).searchByName(name),sortBy)
  }

  def searchById(id: String): Item = {
    (new ItemDb).searchById(id)
  }

  def searchByCategory(name: String, sortBy: Int): List[Item] = {
    sortList( (new CategoryDb).searchByCategory(name).toList,sortBy )
  }

  def searchByVendor(name: String, sortBy: Int): List[Item] = {
    sortList( (new vendorDb).searchByVendor(name),sortBy )
  }
}
