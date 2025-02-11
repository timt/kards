package io.shaka.patience.shenzhen

import io.shaka.Card

data class TableauPile(val cards: List<Card> = emptyList()) {
    fun addCard(card: Card): TableauPile{
        if (cards.isNotEmpty() && card.suit.color == cards.last().suit.color) {
            throw IllegalArgumentException("Card ($card) colors must be alternated")
        }
        if (cards.isNotEmpty() && card.rank.defaultOrder != cards.last().rank.defaultOrder - 1) {
            throw IllegalArgumentException("Card ($card) must be one rank lower than the last card in the pile")
        }
        return this.copy(cards = cards + card)
    }
}