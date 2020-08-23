package de.debuglevel

import java.util.*
import javax.persistence.*

@Entity
data class Fruit(
    @Id
    @GeneratedValue
    var id: UUID?,
    @ElementCollection(fetch = FetchType.EAGER)
    var names: MutableList<String>
)