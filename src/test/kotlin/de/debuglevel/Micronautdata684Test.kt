package de.debuglevel

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import javax.inject.Inject

@MicronautTest
class Micronautdata684Test {
    @Inject
    lateinit var fruitRepository: FruitRepository

    @Test
    fun testDeleteAll() {
        // Debug: Just ensure that the repository is empty before the test
        assert(fruitRepository.findAll().count() == 0)

        // Arrange
        fruitRepository.save(Fruit(null, mutableListOf("apple", "malus domestica")))
        assertEquals(fruitRepository.findAll().count(), 1)

        // Act & Assert
        assertDoesNotThrow { fruitRepository.deleteAll() }
        assertEquals(fruitRepository.count(), 0)
    }

    @Test
    fun testDeleteAllWorkaround() {
        // Just ensure that the repository is empty before the test
        assert(fruitRepository.findAll().count() == 0)

        // Arrange
        fruitRepository.save(Fruit(null, mutableListOf("apple", "malus domestica")))
        assertEquals(fruitRepository.findAll().count(), 1)

        // Act
        fruitRepository.findAll().forEach { fruitRepository.delete(it) }

        // Assert
        assertEquals(fruitRepository.count(), 0)
    }
}