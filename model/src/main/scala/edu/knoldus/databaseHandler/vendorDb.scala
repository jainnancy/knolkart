package main.scala.edu.knoldus.databaseHandler

import main.scala.edu.knoldus.database.{Item, Vendor}

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

class vendorDb {

  val vendorList = new ListBuffer[Vendor]

  def addVendor(vendorId: String, vendorName: String): ListBuffer[Vendor] = {
    val newVendor = Vendor(vendorId,vendorName)
    vendorList += newVendor
    vendorList
  }

  def searchByVendor(vendorName: String): List[Item] = {
    @tailrec
    def search(vendorName: String, resultList: List[Item], inventory: List[Item]): List[Item] = {

      inventory match {
        case head :: tail if head.vendorInfo.vendorName.equalsIgnoreCase(vendorName) =>
          search(vendorName, head :: resultList, tail)
        case _ => List()
      }

    }
    search(vendorName, List(), (new ItemDb).itemList.toList)
  }
}
