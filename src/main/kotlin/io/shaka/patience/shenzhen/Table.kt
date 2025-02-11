package io.shaka.patience.shenzhen

import io.shaka.Deck
import io.shaka.deal
import io.shaka.shuffle

class Table {
    val players: List<Player>

    constructor(numberOfPlayers: Int){
        val (stocks, _) = Deck()
            .shuffle()
            .deal(52/numberOfPlayers, numberOfPlayers)
        this.players = (0 until numberOfPlayers).map { i-> Player(stock = stocks[i]) }
    }
}
