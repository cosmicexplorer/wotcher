package wotcher

sealed trait Query

object FilePathQuery extends Query
object FileContentQuery extends Query
object SymbolQuery extends Query
