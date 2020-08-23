package de.debuglevel

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("de.debuglevel")
		.start()
}

