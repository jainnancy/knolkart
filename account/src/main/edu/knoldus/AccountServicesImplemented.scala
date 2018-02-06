package edu.knoldus

class AccountServicesImplemented extends AccountServices {
  val tokenLength = 45

  override def addUser(user: User): String = {
    val newUser = User(user.username,user.password,user.phoneNo)
    "user created"
  }

  override def authenticateUser(username: String, password: String): String ={
    (new GenerateToken).generateToken(tokenLength)
  }

}
