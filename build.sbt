name := "knolkart-test"

version := "0.1"

scalaVersion := "2.12.4"

coverageEnabled := true

lazy val util = project in file("util")

lazy val account = project in file("account")
lazy val inventory = (project in file("inventory")).dependsOn(util,model)

lazy val model = (project in file("model")).dependsOn(util)
.settings(libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"
)

lazy val accountRef = LocalProject("account")

lazy val inventoryRef = LocalProject("inventory")

lazy val modelRef = LocalProject("model")

lazy val checkout = (project in file("checkout")).dependsOn(inventoryRef)

lazy val checkoutRef = LocalProject("checkout")

lazy val root = (project in file("."))
  .aggregate(inventoryRef,modelRef,checkoutRef,accountRef)
  .dependsOn(inventoryRef,modelRef,checkoutRef,accountRef)