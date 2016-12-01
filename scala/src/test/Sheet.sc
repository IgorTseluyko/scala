val a = 10
val b = 3

def square(x: Double): Double = x * x
square(a)

def _square(x: => Double) = x * x
_square(0.1)

def sum(f: Int => Int, a: Int, b: Int): Int = {f(a + b)}

def cube(x: Int) = x * x * x
sum(x => x * x * x, 10, 10) // sum of cubes from 1 to 10

def filter(xs: List[Int], p: Int => Boolean): List[Int] =
  if (xs.isEmpty) xs
  else if (p(xs.head)) xs.head :: filter(xs.tail, p)
  else filter(xs.tail, p)
def modN(n: Int)(x: Int) = (x % n) == 0
val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
println(filter(nums, modN(2)))
println(filter(nums, modN(3)))


val fruits = List("apple", "orange", "lime")
val numbers = List(1, 2, 3)

val smth = fruits.map(f => f + "AA").reduce((x, y) => x * 2 + y * 2)
println(smth)

val test = fruits.map(f => f * 2)
println(test)

val sum = (a: Int) => (b: Int) => (c: Int) => a + b + c

sum(1)(2)(3)

object MatchTest extends App {
  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case x: Int => "scala.Int"
    case _ => throw new Exception("Not found")
  }
  println(matchTest("two"))
}

MatchTest.matchTest("")





