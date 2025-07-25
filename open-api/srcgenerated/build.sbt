lazy val root = (project in file(".")).
  settings(
    organization := "com.rdp.ms_books_catalogue",
    name := "openapiclient",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.11.12",
    scalacOptions ++= Seq("-feature"),
    compile / javacOptions ++= Seq("-Xlint:deprecation"),
    Compile / packageDoc / publishArtifact := false,
    resolvers += Resolver.mavenLocal,
    libraryDependencies ++= Seq(
      "io.swagger" % "swagger-annotations" % "1.5.22" % "compile",
      "org.jboss.resteasy" % "resteasy-client" % "3.1.3.Final" % "compile",
      "org.jboss.resteasy" % "resteasy-multipart-provider" % "4.5.11.Final" % "compile",
      "org.jboss.resteasy" % "resteasy-jackson2-provider" % "4.5.11.Final" % "compile",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.17.1" % "compile",
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.17.1" % "compile",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.17.1" % "compile",
      "com.github.joschi.jackson" % "jackson-datatype-threetenbp" % "2.15.2" % "compile",
      "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.17.1" % "compile",
      "jakarta.annotation" % "jakarta.annotation-api" % "1.3.5" % "compile",
      "org.assertj" % "assertj-core" % "3.23.1" % "test",
      "junit" % "junit" % "5.10.2" % "test",
      "com.novocode" % "junit-interface" % "0.10" % "test"
    )
  )
