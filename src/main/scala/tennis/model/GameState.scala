package tennis.model

sealed abstract class GameState

case class InPlay() extends GameState
case class GameFinished() extends GameState
