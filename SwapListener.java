name: Build PASF

on:
  push:
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4

      - name: Set up JDK 21
        uses: actions/setup-java@v4
        with:
          java-version: '21'
          distribution: 'temurin'
          cache: maven

      - name: Build paper-26.1
        run: mvn -f paper-26.1/pom.xml package

      - name: Upload jar
        uses: actions/upload-artifact@v4
        with:
          name: pasf-paper26.1-jar
          path: paper-26.1/target/pasf-1.1.0-paper26.1.jar
