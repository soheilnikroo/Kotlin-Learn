package ir.soheilnikroo.kotlinbasics

fun main() {
    var soheil = Person("Soheil", "Nikroo")
    var john = Person()
    john.age = 55
    println("john is ${john.age} years old")
    var alex = Person(lastName = "ali")
    alex.stateHobby()

    var myCar = Car()
    println("my brand is ${myCar.myBrand}")

    val user1 = User(1, "Soheil")

    user1.name = "Michel"

    val updatedUser = user1.copy(name = "Ali")

    println(user1.equals(updatedUser))
    println(updatedUser)

    println(updatedUser.component1())
    println(updatedUser.component2())

    val (id, name) = updatedUser
    println("id: $id name:$name")

    var pride = Vechial("A3", "Saipa")
    var teslaCar = ElectricCar("S-Model", "Tesla", 85.0)

    pride.drive(200.0)
    teslaCar.drive(545.0)

    teslaCar.extendRange(400.0)

    val truck1 = Truck(200.0)
    truck1.drive()
    truck1.brake()


    val human = Human(
        "Denis", "Russia",
        70.0, 28.0
    )
    val elephant = Elephant(
        "Rosy", "India",
        5400.0, 25.0
    )

    human.run()
    elephant.run()

    human.breath()
    elephant.breath()

    // val numbers:IntArray=intArrayOf(1,2,3,4,5,6)
    // val numbers=intArrayOf(1,2,3,4,5,6)

    val numbers= arrayOf(1,2,3,4,5,6)

    //println(numbers.contentToString())

    for(element in numbers){
        print(" $element")
    }

    numbers[0]=5
    numbers[3]=33

    println(numbers.contentToString())

    val days = arrayOf("Sun","Mon")

    val months= listOf<String>("Jan","Feb","May")
    println(months)

    val additionalMonths=months.toMutableList()
    val newMonthsList=arrayOf("April","June")
    additionalMonths.addAll(newMonthsList)
    additionalMonths.add("July")
    println(additionalMonths)


    val myDays= mutableListOf<String>("Mon","Tue","Wed")
    myDays.add("Thue")
    myDays.removeAt(1)
    val removeList=mutableListOf<String>("Mon","Wed")
    myDays.removeAll(removeList)
    println(myDays)

    val fruits=setOf("Apple","Oragne","Grape","Apple")
    println(fruits)
    println(fruits.toSortedSet())

    val newFruits=fruits.toMutableList()
    newFruits.add("Water Melon")
    newFruits.add("Pear")
    println(newFruits)
    println(newFruits[0])
    println(newFruits.elementAt(4))


    val daysOfWeek= mapOf(1 to "Monday",2 to "Tuesday",3 to "Wednesday")
    println(daysOfWeek[2])

    for(key in daysOfWeek.keys){
        println("$key is to ${daysOfWeek[key]}")
    }
}

// The syntax of a function - fun stands for function
fun myFunction() {
    // The body of a function
    println("myFunction was called")
}

// This function has two parameters and returns a value of type Int
fun addUp(a: Int, b: Int): Int {
    // the return keyword indicates that this function will return the following value
    // once this function is called and executed
    return (a + b)
}

// Article on Kotlin words https://blog.kotlin-academy.com/kotlin-programmer-dictionary-function-vs-method-vs-procedure-c0216642ee87
// CHALLENGE: create a function that calculates the average and call it
fun avg(a: Double, b: Double): Double {
    return (a + b) / 2
}

class Person(name: String = "Soheil", lastName: String = "Nikroo") {
    // Member Variables - Properties
    var age: Int? = null
    var hobby: String = "watch Netflix"
    var firstName: String? = null

    init {
        this.firstName = name
        println("Intialized a new Person with firstName:$name, lastName:$lastName")
    }

    // Member secondary constructor
    constructor(firstName: String, lastName: String, age: Int) : this(firstName, lastName) {
        this.age = age
    }

    // Member functions - Methods
    fun stateHobby() {
        println("$firstName\'s hobby is $hobby")
    }
}


class Car() {
    lateinit var owner: String;

    val myBrand: String = "BMW"
        get() {
            return field.lowercase()
        }

    init {
        this.owner = "Frank"
    }
}

data class User(val id: Long, var name: String)

// Super class, Parent class, Base class
open class Vechial(val name: String, val brand: String) {
    open var range: Double = 0.0

    fun extendRange(amount: Double) {
        if (amount > 0) {
            range += amount
        }
    }

    open fun drive(distance: Double) {
        println("Drove for $distance KM")
    }
}

// Sub class Child class or Derived class of Vechial
open class ElectricCar(name: String, brand: String, battreyLife: Double) : Vechial(name, brand) {
    override var range = battreyLife * 6


    override fun drive(distance: Double) {
        println("Dorve for $distance KM on electricity")
    }
}

interface Drivable {
    val maxSpeed: Double;
    fun drive(): String
    fun brake() {
        println("The drivable is breaking")
    }
}

class Truck(override val maxSpeed: Double) : Drivable {
    override fun drive(): String {
        return "max speed is: ${maxSpeed}"
    }

    override fun brake() {
        super.brake()
        println("brake inside of truck")
    }
}

// An abstract class cannot be instantiated
// (you cannot create objects of an abstract class).
// However, you can inherit subclasses from can them.
// The members (properties and methods) of an abstract class are non-abstract
// unless you explicitly use the abstract keyword to make them abstract.
abstract class Mammal(
    val name: String, val origin: String,
    val weight: Double
) {   // Concrete (Non Abstract) Properties

    // Abstract Property (Must be overridden by Subclasses)
    abstract var maxSpeed: Double

    // Abstract Methods (Must be implemented by Subclasses)
    abstract fun run()
    abstract fun breath()

    // Concrete (Non Abstract) Method
    fun displayDetails() {
        println(
            "Name: $name, Origin: $origin, Weight: $weight, " +
                    "Max Speed: $maxSpeed"
        )
    }
}

class Human(
    name: String, origin: String, weight: Double,
    override var maxSpeed: Double
) : Mammal(name, origin, weight) {

    override fun run() {
        // Code to run
        println("Runs on two legs")
    }

    override fun breath() {
        // Code to breath
        println("Breath through mouth or nose")
    }
}

class Elephant(
    name: String, origin: String, weight: Double,
    override var maxSpeed: Double
) : Mammal(name, origin, weight) {

    override fun run() {
        // Code to run
        println("Runs on four legs")
    }

    override fun breath() {
        // Code to breath
        println("Breath through the trunk")
    }
}
