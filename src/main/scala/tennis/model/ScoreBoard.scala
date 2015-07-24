package tennis.model

case class ScoreBoard(score1: Score = Love(), score2: Score = Love()) {

  def playerOneScored(): ScoreBoard = {
    score1 match {
      case Love() => this.copy(score1 = Fifteen())
      case Fifteen() => this.copy(score1 = Thirty())
      case Thirty() if score2 != Fourty() => this.copy(score1 = Fourty())
      case Thirty() if score2 == Fourty() => ScoreBoard(Deuce(), Deuce())
      case Fourty() => this.copy(score1 = GameWon())
    }
  }

  def playerTwoScored(): ScoreBoard = {
    score2 match {
      case Love() => this.copy(score2 = Fifteen())
      case Fifteen() => this.copy(score2 = Thirty())
      case Thirty() if score1 != Fourty() => this.copy(score2 = Fourty())
      case Thirty() if score1 == Fourty() => ScoreBoard(Deuce(), Deuce())
      case Fourty() => this.copy(score2 = GameWon())
    }
  }

  def getScore(): (Score, Score) = {
    (score1, score2)
  }

  def getState(): GameState = {
    InPlay()
  }
}
