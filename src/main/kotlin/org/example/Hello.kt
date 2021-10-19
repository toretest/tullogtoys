package org.example

import org.eclipse.rdf4j.RDF4JException
import org.eclipse.rdf4j.model.*
import org.eclipse.rdf4j.model.impl.SimpleValueFactory
import org.eclipse.rdf4j.model.util.ModelBuilder
import org.eclipse.rdf4j.model.vocabulary.FOAF
import org.eclipse.rdf4j.model.vocabulary.RDF
import org.eclipse.rdf4j.query.QueryResults
import org.eclipse.rdf4j.rio.RDFFormat
import org.eclipse.rdf4j.rio.Rio
import java.net.URL

fun main(args: Array<String>) {
    A().a()
}

class A {
    fun a() {
        val filename = "test.ttl"
        val map1 = mutableMapOf<Resource,List<Statement>>()
        val inputStream = A::class.java.getResourceAsStream("/$filename")
        val model = Rio.parse(inputStream, "", RDFFormat.TURTLE)

        val ref =model.groupBy { it.subject}.map { map1.put(it.key,it.value) }
        println("")

            //.forEach {
                //resource, list ->  map1.plus(Pair(resource,list))
            //println(it.key.stringValue())
        }

    /*

        val vf: ValueFactory = SimpleValueFactory.getInstance()
        val uri = vf.createIRI("http://example.org/Picasso")
        val filter = model.filter { it.subject == uri }
            .groupBy { it.`object` }
        val baseURI = "http://example.org/test.ttl"
        val format = RDFFormat.TURTLE
        try {
            QueryResults.parseGraphBackground(inputStream, baseURI, format).let {

                while (it.hasNext()) {
                    val statement = it.next()
                    println(statement.subject.stringValue())
                }
            }
        } catch (e: RDF4JException) {
            // handle unrecoverable error
        } finally {
            inputStream.close()
        }
    }
    */

}



fun mainb(args: Array<String>) {
    // A().a()
    val documentUrl: URL =
        URL("https://github.com/bjonnh/rdf4k/blob/master/src/test/resources/example-data-artists.ttl")
    val inputStream = documentUrl.openStream()
    val baseURI = documentUrl.toString()
    val format = RDFFormat.TURTLE
    try {
        QueryResults.parseGraphBackground(inputStream, baseURI, format).let {
            while (it.hasNext()) {
                val statement = it.next()
                println(statement.subject.stringValue())
            }
        }
    } catch (e: RDF4JException) {
        // handle unrecoverable error
    } finally {
        inputStream.close()
    }



    println("Hello, World")

    val factory: ValueFactory = SimpleValueFactory.getInstance()
    val bob = factory.createIRI("http://example.org/bob")
    val name = factory.createIRI("http://example.org/name")
    val bobsName = factory.createLiteral("Bob")
    val nameStatement = factory.createStatement(bob, name, bobsName)

    val builder = ModelBuilder()

// set some namespaces

// set some namespaces
    builder.setNamespace("ex", "http://example.org/").setNamespace(FOAF.NS)

    builder.namedGraph("ex:graph1") // add a new named graph to the model
        .subject("ex:john") // add  several statements about resource ex:john
        .add(FOAF.NAME, "John") // add the triple (ex:john, foaf:name "John") to the named graph
        .add(FOAF.AGE, 42)
        .add(FOAF.MBOX, "john@example.org")
        .add(FOAF.MBOX, 123.3)

// add a triple to the default graph

// add a triple to the default graph
    builder.defaultGraph().add("ex:graph1", RDF.TYPE, "ex:Graph")

// return the Model object

// return the Model object
    val m = builder.build()
}

