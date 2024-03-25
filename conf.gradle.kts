tasks.register<Copy>("replaceConf") {
    group = "templating"
    description = "Generates project properties from template"
    from("src/main/resources/template")
    into("src/main/resources")
    expand(project.properties)
    outputs.upToDateWhen { false }
}

tasks.named("build").get().dependsOn("replaceConf")
