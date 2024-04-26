import scala.collection.mutable.ListBuffer

object GenerateParenthesis extends App {
  def generateParenthesis(n: Int): List[String] = {
    val validParentheses = new ListBuffer[String]
    def isValidParentheses(str: String): Boolean = {
      def balance(chars: List[Char], count: Int): Boolean = {
        if (chars.isEmpty) count == 0
        else if (chars.head == '(') balance(chars.tail, count + 1)
        else if (chars.head == ')' && count > 0) balance(chars.tail, count - 1)
        else false
      }
      balance(str.toList, 0)
    }
    def dfs(lCount: Int, rCount: Int, s: String): Unit = {
      if (lCount == 0 && rCount == 0) validParentheses.append(s)
      if (lCount > 0) dfs(lCount - 1, rCount, s + "(")
      if (lCount < rCount) dfs(lCount, rCount - 1, s + ")")
    }
    dfs(n, n, "")
    validParentheses.toList
  }
}
