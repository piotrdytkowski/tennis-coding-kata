package tennis.model

sealed abstract class Score

case class Love() extends Score
case class Fifteen() extends Score
case class Thirty() extends Score
case class Fourty() extends Score
case class Advantage() extends Score
case class Deuce() extends Score
case class GameWon() extends Score
