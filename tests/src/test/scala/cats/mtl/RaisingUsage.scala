package cats
package mtl

import cats.data._
import cats.mtl.instances.raising._
import cats.mtl.instances.eithert._
import cats.mtl.monad.Raising
import cats.syntax.either._

class RaisingUsage extends BaseSuite {

  test("raise") {
    val _ =
      Raising.raise[EitherTStrEitherTInt, Int, Nothing](1)
    val _1 =
      Raising.raise[EitherTStrEitherTInt, String, Nothing]("err")
    val raiseFNoExpectedTypeWithArgsNestedInReader =
      Raising.raiseF[EitherTStrEitherTInt]("err")
    assert(
      raiseFNoExpectedTypeWithArgsNestedInReader == EitherT.fromEither[EitherTIntId][String, Nothing](Either.left("err"))
    )
    //    val askFExpectedTypeWithArgsNestedInReader: EitherTStrInt[Int] =
    //      Raising.askE[EitherStrInt]()
  }


}
