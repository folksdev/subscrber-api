package com.folksdev.subsciber.api.model

// Useful for persisting and integrating with java code and swagger
// Use types for safety
object Period extends Enumeration {
  type Period = Value
  val Weekly = Value(1)
  val BiWeekly = Value(2)
  val Monthly = Value(3)
}
