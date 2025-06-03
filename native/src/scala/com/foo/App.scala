package com.foo

import fansi._

object App {
  def greeting(name: String) = Str(s"Hello, ") ++ Color.Red(name)

  def main(args: Array[String]): Unit =
    val thread = new Thread(run _, "test")
    thread.start()
    thread.join()

  private def run() = {
    val name = Thread.currentThread().getName()
    println(s"Thread $name: Hello, world!")
    Info.show()
  }
}
