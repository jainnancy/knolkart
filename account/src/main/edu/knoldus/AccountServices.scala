package main.edu.knoldus

trait AccountServices {
  def addUser(user: User)
  def authenticateUser(userName: String,password: String)
}
