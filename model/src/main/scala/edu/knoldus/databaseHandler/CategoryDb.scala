package main.scala.edu.knoldus.databaseHandler

import main.scala.edu.knoldus.database.{Category, Inventory, Item}

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

class CategoryDb {

  val categoryList = new ListBuffer[Category]

  def addCategory(categoryId: String, categoryName: String): ListBuffer[Category] = {
    val newCategory = Category(categoryId, categoryName)
    categoryList += newCategory
    categoryList
  }

  def searchByCategory(categoryName: String): ListBuffer[Item] = {
    @tailrec
    def search(categoryName: String, resultList: List[Item] = Nil, inventory: List[Item]): List[Item] = {

      inventory match {
        case head :: tail if head.category.categoryName.equalsIgnoreCase(categoryName) =>
          search(categoryName, head :: resultList, tail)
        case _ => List()
      }

    }
    search(categoryName, inventory = (new ItemDb).itemList.toList)
  }

}
