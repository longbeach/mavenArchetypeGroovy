/**
* CF : This script will be executed upon creating a project from this archetype
* https://maven.apache.org/archetype/maven-archetype-plugin/advanced-usage.html
* It will delete a folder called configuration.xml if the value for the "configurable" property
* is set to true
*/

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

println "artifactId: " + artifactId
println "request: " + request
println "archetypeArtifactId: " + request.getArchetypeArtifactId()
println "archetypeGroupId: " + request.getArchetypeGroupId()
println "archetypeVersion: " + request.getArchetypeVersion()
println "archetypeName: " + request.getArchetypeName()
println "artifactId: " + request.getArtifactId()
println "groupId: " + request.getGroupId()
println "version: " + request.getVersion()

Path projectPath = Paths.get(request.outputDirectory, request.artifactId)
Properties properties = request.properties
String configurableProperty = properties.get("configurable")
println "configurableProperty : " + configurableProperty

if (!configurableProperty.equals("yes")) {
   println "Deleting the configuration.xml file"
   
   Path configPath = projectPath.resolve("src/main/resources/META-INF")   
   String configurationFile = "configuration.xml";    
   Path cxfConfigPath = configPath.resolve(configurationFile)
   println "cxfConfigPath " + cxfConfigPath  
   Files.deleteIfExists cxfConfigPath
}