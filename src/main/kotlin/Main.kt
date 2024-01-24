import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val square = Square("Square", 0.0, 0.0)
    val circle = Circle("Circle", 0.0)
    val triangle = Triangle("Triangle", 0.0, 0.0, 0.0)
    val equilateralTriangle = EquilateralTriangle("EquilateralTriangle", 0.0)

    println("Enter length and height for Square:")
    square.setDimensions(scanner.next().toDouble(), scanner.next().toDouble())

    println("Enter radius for Circle:")
    circle.setDimensions(scanner.next().toDouble())

    println("Enter sides A, B, and C for Triangle:")
    triangle.setDimensions(scanner.next().toDouble(), scanner.next().toDouble(), scanner.next().toDouble())

    println("Enter side length for Equilateral Triangle:")
    equilateralTriangle.setDimensions(scanner.next().toDouble())

    println("Shape: ${square.name}")
    square.printDimensions()
    println("Area: ${square.getArea()}\n")

    println("Shape: ${circle.name}")
    circle.printDimensions()
    println("Area: ${circle.getArea()}\n")

    println("Shape: ${triangle.name}")
    triangle.printDimensions()
    println("Area: ${triangle.getArea()}\n")

    println("Shape: ${equilateralTriangle.name}")
    equilateralTriangle.printDimensions()
    println("Area: ${equilateralTriangle.getArea()}")
}

interface Dimensionable {
    fun printDimensions()
}

abstract class Shape(_name: String) : Dimensionable {
    var name = _name

    abstract fun getArea(): Double
}

class Square(_name: String, private var length: Double, private var height: Double) : Shape(_name) {

    init {
        setDimensions(length, height)
    }

    override fun printDimensions() {
        println("Length: $length, Height: $height")
    }

    override fun getArea(): Double {
        return length * height
    }

    fun setDimensions(length: Double, height: Double) {
        this.length = length
        this.height = height
    }
}

class Circle(_name: String, private var radius: Double) : Shape(_name) {

    init {
        setDimensions(radius)
    }

    override fun printDimensions() {
        println("Radius: $radius")
    }

    override fun getArea(): Double {
        return Math.PI * radius * radius
    }

    fun setDimensions(radius: Double) {
        this.radius = radius
    }
}

open class Triangle(_name: String, var sideA: Double, var sideB: Double, var sideC: Double) : Shape(_name) {

    init {
        setDimensions(sideA, sideB, sideC)
    }

    override fun printDimensions() {
        println("Side A: $sideA, Side B: $sideB, Side C: $sideC")
    }

    override fun getArea(): Double {
        val s = (sideA + sideB + sideC) / 2
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
    }

    fun setDimensions(sideA: Double, sideB: Double, sideC: Double) {
        this.sideA = sideA
        this.sideB = sideB
        this.sideC = sideC
    }
}

class EquilateralTriangle(_name: String, private var sideLength: Double) : Triangle(_name, sideLength, sideLength, sideLength) {

    init {
        setDimensions(sideLength)
    }

    override fun printDimensions() {
        println("Side Length: $sideLength")
    }

    fun setDimensions(sideLength: Double) {
        this.sideA = sideLength
        this.sideB = sideLength
        this.sideC = sideLength
        this.sideLength = sideLength
    }
}
