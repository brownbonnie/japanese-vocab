lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """play-scala-hello-world-tutorial""",
    organization := "com.example",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.5",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      jdbc,
      "mysql" % "mysql-connector-java" % "5.1.41"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
