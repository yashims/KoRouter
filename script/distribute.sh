#!/bin/bash

# temp release script
set -xv
cd $(dirname $0)/../
./gradlew -p KoRouter copyFramework \
  -Pconfiguration.build.dir="$PWD/Frameworks" \
  -Pkotlin.build.type="RELEASE" 

