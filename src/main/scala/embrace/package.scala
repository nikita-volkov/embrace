package embrace

object `package` {

  implicit class EmbraceAny [ A ] ( val a : A ) extends AnyVal {
    @inline def $ [ Z ] ( f : A => Z ) = f(a)
  }
  implicit class EmbraceTuple2 [ A, B ] ( val a : (A, B) ) extends AnyVal {
    @inline def $$ [ Z ] ( f : (A, B) => Z ) = f.tupled(a)
  }
  implicit class EmbraceTuple3 [ A, B, C ] ( val a : (A, B, C) ) extends AnyVal {
    @inline def $$ [ Z ] ( f : (A, B, C) => Z ) = f.tupled(a)
  }
  implicit class EmbraceTuple4 [ A, B, C, D ] ( val a : (A, B, C, D) ) extends AnyVal {
    @inline def $$ [ Z ] ( f : (A, B, C, D) => Z ) = f.tupled(a)
  }

}