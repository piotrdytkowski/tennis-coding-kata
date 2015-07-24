package tennis.model

case class ScoreBoard(score1: Score, score2: Score, gameState: GameState = InPlay()) {

  def playerOneScored(): ScoreBoard = {
    if (getState() == InPlay()) score1 match {
      case Love() => this.copy(score1 = Fifteen())
      case Fifteen() => this.copy(score1 = Thirty())
      case Thirty() if score2 != Fourty() => this.copy(score1 = Fourty())
      case Thirty() if score2 == Fourty() => ScoreBoard(Deuce(), Deuce())
      case Fourty() => this.copy(score1 = GameWon(), gameState = GameFinished())
    } else {
      ???
    }
  }

  def playerTwoScored(): ScoreBoard = {
    if (getState() == InPlay()) score2 match {
      case Love() => this.copy(score2 = Fifteen())
      case Fifteen() => this.copy(score2 = Thirty())
      case Thirty() if score1 != Fourty() => this.copy(score2 = Fourty())
      case Thirty() if score1 == Fourty() => ScoreBoard(Deuce(), Deuce())
      case Fourty() => this.copy(score2 = GameWon(), gameState = GameFinished())
    } else {
      ???
    }
  }

  def getScore(): (Score, Score) = {
    (score1, score2)
  }

  def getState(): GameState = {
    gameState
  }
}
