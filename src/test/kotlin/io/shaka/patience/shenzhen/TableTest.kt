package io.shaka.patience.shenzhen

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TableTest {
  @Test
  fun `A table can be created with 4 players`(){
    val table = Table(4)
    assertEquals(4, table.players.size)
    assertEquals(13, table.players[1].stock.size)
  }
 }