package de.debuglevel

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.*

@Repository
interface FruitRepository : CrudRepository<Fruit, UUID> {
}