package tennis.model

sealed abstract class GameState

case class InPlay() extends GameState
