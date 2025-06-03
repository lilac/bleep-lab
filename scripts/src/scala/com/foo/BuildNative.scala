package com.foo

import bleep._
import bleep.plugin.nativeimage.NativeImagePlugin

object BuildNative extends BleepScript("build-native") {
  def run(started: Started, commands: Commands, args: List[String]): Unit = {
    val projectName = model.CrossProjectName.fromString("cli").get
    
    commands.compile(List(projectName))
    
    val nativeImage = new NativeImagePlugin(
      project = started.bloopProject(projectName),
      logger = started.logger,
      jvmCommand = java.nio.file.Paths.get(System.getProperty("java.home"), "bin", "java"),
      env = List("PATH" -> System.getenv("PATH"))
    )
    
    val outputPath = nativeImage.nativeImage()
    
    started.logger.info(s"Generated native binary at $outputPath")
  }
} 