package com.foo

import bleep._
import bleep.plugin.nativeimage.NativeImagePlugin

object BuildNative extends BleepScript("build-native") {
  def run(started: Started, commands: Commands, args: List[String]): Unit = {
    val projectName = model.CrossProjectName.fromString("native").get
    
    commands.compile(List(projectName))
    
    val targetPath = os.pwd / "foo-app"
    
    started.logger.info(s"Compiling native binary to $targetPath")
    
    val nativeImage = new NativeImagePlugin(
      project = started.bloopProject(projectName),
      logger = started.logger,
      jvmCommand = java.nio.file.Paths.get(System.getProperty("java.home"), "bin", "java"),
      nativeImageOptions = List("-o", targetPath.toString()),
      env = List.empty
    )
    
    val outputPath = nativeImage.nativeImage()
    
    started.logger.info(s"Generated native binary at $outputPath")
  }
} 