import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GenerateParenthesisTest extends AnyFlatSpec with Matchers {
  import GenerateParenthesis.generateParenthesis
  "generateParenthesis" should "return valid parentheses" in {
    val n = 3
    val expected = List("((()))", "(()())", "(())()", "()(())", "()()()")
    generateParenthesis(n) should contain theSameElementsAs expected
  }

  it should "return an empty list for n = 0" in {
    generateParenthesis(0) shouldBe empty
  }

  it should "return an empty list for negative n" in {
    generateParenthesis(-3) shouldBe empty
  }
}
