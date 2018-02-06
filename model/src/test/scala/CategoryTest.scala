package test.scala

import main.scala.edu.knoldus.database.{Category, Inventory, Item, Vendor}
import main.scala.edu.knoldus.databaseHandler._
import org.scalatest.FunSuite

import scala.collection.mutable.ListBuffer

class CategoryTest extends FunSuite{

  val categoryObj = new CategoryDb
  test("Check if category is added"){
    val result = categoryObj.addCategory("c1","testCategory")
    assert(result === ListBuffer(Category("c1","testCategory")))
  }

  val vendorObj = new vendorDb
  test("check if new vendor is added"){
    val result = vendorObj.addVendor("v1","testVendor")
    assert(result === ListBuffer(Vendor("v1","testVendor")))
  }

  val itemObj = new ItemDb
  test("check if new item is added"){
    val result = itemObj.addItem("i1","testItem","descriptionadded",1200,15,Category("c1","testCategory"),Vendor("v1","testVendor"))
    assert(result === ListBuffer(Item("i1","testItem","descriptionadded",1200,15,Category("c1","testCategory"),Vendor("v1","testVendor"))))
  }

  val inventoryObj = new InventoryDb
  test("check if inventory is added"){
    pending
    /*val item1 = itemObj.addItem("i1","testItem","descriptionadded",1200,15,Category("c1","testCategory"),Vendor("v1","testVendor"))
    val item2 = itemObj.addItem("i2","testItem2","descriptionadded",1000,8,Category("c1","testCategory"),Vendor("v1","testVendor"))
    val result1 = inventoryObj.addInventory(item1)
    val result2: ListBuffer[Inventory] = inventoryObj.addInventory(item2)

    assert(result2 === ListBuffer(Inventory(item1,item2))*/
  }

}
