package org.example

/*
let,apply osv
https://kotlinlang.org/docs/scope-functions.html#function-selection

 */
interface Base {
    fun print()
}


class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(b: Base) : Base by b

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()

    Kunde()

    val p = Person().run {
        this.id=10
    }

    val p2 = Person().also {

    }

    val p3 =Person()
    val hello =with(p3){
        this.id=2
        name="dsdsdsdd"
        "hhjjh"
    }

    println("")

    //also  inline fun <T> T.also(block: (T) -> Unit): T
    //apply inline fun <T> T.apply(block: T.() -> Unit): T

    //let   inline fun <T, R> T.let(block: (T) -> R): R
    //run = let + eith

//    inline fun <T, R> with(receiver: T, block: T.() -> R): R {
//    return receiver.block()
//   }
}

class Person{
    var id : Int?=null
    var name : String?=null
}

class Kunde(val id : Int){
    var person : String?

    constructor() : this(10) {
        println("constuctor()")
        person ="constructor"
    }
    init {
        println("Init")
        person="init"
    }
}

