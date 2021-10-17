package org.example

import org.junit.Test


class ComponentTest{
    @Test
    fun builderTest(){
       val component : Component = Component
           .Builder()
           .setAge(12)
           .setId("w")
           .setName("name").build()

        Component(Component.Builder().setAge(2))
    }
}

class A  


class Component(builder : Builder) {
    var id : String? = null
    var name : String? = null
    var age : Int? = null

    class Builder {
        private var id : String? = null
        private var name : String? = null
        private var age : Int? = null

        fun setId(id : String) = apply { this.id = id}
        fun setName(name : String) = apply { this.name = name}
        fun setAge(age : Int) = apply { this.age = age}
        fun build() = Component(this)

        fun getId() = id
        fun getname() = name
        fun getAge() = age
    }

    init {
       id = builder.getId()
       name = builder.getname()
       age = builder.getAge()
    }
}

