```scala
class MyClass(val name: String) {
  private var _value: Int = 0

  def value: Int = _value

  def value_=(newValue: Int): Unit = {
    if (newValue < 0) {
      throw new IllegalArgumentException(s"Value for '$name' cannot be negative. Received: $newValue")
    } else if (newValue > 100) {
        println("Warning: Value is greater than 100. Proceeding with value 100");
        _value = 100
    }
    else {
      _value = newValue
    }
  }
}

object Main extends App {
  val myObject = new MyClass("My Object")
  myObject.value = 10
  println(myObject.value) // Output: 10

  try {
    myObject.value = -5 // Throws IllegalArgumentException
  } catch {
    case e: IllegalArgumentException => println(e.getMessage) //Output: Value for 'My Object' cannot be negative. Received: -5
  }
  myObject.value = 105
  println(myObject.value) //Output: 100
}
```