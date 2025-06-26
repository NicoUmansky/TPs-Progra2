   javac -cp ".;lib/gs-core-2.0.jar;lib/gs-ui-swing-2.0.jar" src/interfaces/*.java src/modelo/*.java src/test/*.java -d bin

    java -cp ".;lib/gs-core-2.0.jar;lib/gs-ui-swing-2.0.jar;bin" test.TestDijkstra