package com.foo

import munit.FunSuite

class AppTest extends FunSuite {
  test("works") {
    assertEquals(App.greeting("a").plainText, "Hello, a")
  }
}
