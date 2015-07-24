package tennis.model

import tennis.UnitTest

class TennisGameSpec extends UnitTest {

  val p1 = Player(1)
  val p2 = Player(2)

  "A tennis game" should "start with the score love - love" in {
    val game = TennisGame(p1, p2)
    game.getScore() should be (Love(), Love())
  }

  it should "start with the status InPlay" in {
    val game = TennisGame(p1, p2)
    game.getState() should be (InPlay())
  }

  it should "record player score" in {
    val game = TennisGame(p1, p2)
    val possibleScores: Array[(Array[Player], (Score, Score))] = Array(
      (Array(p1), (Fifteen(), Love())),
      (Array(p1, p1), (Thirty(), Love())),
      (Array(p1, p1, p1), (Fourty(), Love()))
    )
    assertScores(possibleScores)
  }

  def assertScores(data: Array[(Array[Player], (Score, Score))]): Unit = {
    data.foreach(row => {
      var game = TennisGame(p1, p2)
      row._1.foreach(p => game = game.achievePoint(p))
      game.getScore() should be (row._2)
    })
  }
}
