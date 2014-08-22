Download phonegap 1.7.0 from http://phonegap.com/download

Extract to temp folder

Navigate to: temp/phonegap-phonegap-475bfd2/lib/android

Execute the following at a command prompt:

mvn install:install-file -Dfile=cordova-1.7.0.jar -DgroupId=org.apache.cordova -DartifactId=phonegap -Dversion=1.7.0 -Dpackaging=jar
Phonegap (cordova-1.7.0.jar) should now be installed in your local Maven repository

In your project pom, add the following to your POM file:

<dependency>
  <groupId>org.apache.cordova</groupId>
  <artifactId>phonegap</artifactId>
  <version>1.7.0</version>
</dependency>