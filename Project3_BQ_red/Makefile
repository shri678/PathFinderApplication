run: 
	javac BaseGraph.java
	javac MakeGraph.java
	javac LocationDW.java
	javac GraphADT.java
	javac -cp .:gs-core-2.0.jar LocationReaderDW.java
	javac DijkstraGraphAE.java
	javac PathFinderBackendBD.java
	javac EdgeDW.java
	javac PathFinderFrontendFD.java
	javac EdgeAbstract.java
	javac PathFinderApp.java
	java -cp .:gs-core-2.0.jar PathFinderApp
runDataWranglerTests:
	javac LocationDW.java
	javac EdgeDW.java
	javac -cp .:gs-core-2.0.jar LocationReaderDW.java
	javac -cp .:junit5.jar:gs-core-2.0.jar DataWranglerTests.java
	java -jar junit5.jar -cp .:junit5.jar:gs-core-2.0.jar --select-class=DataWranglerTests

runAlgorithmEngineerTests:
	javac PathFinderFrontendFD.java
	javac PathFinderBackendFD.java
	javac DijkstraGraphAE.java
	javac -cp .:junit5.jar AlgorithmEngineerTests.java
	java -jar junit5.jar -cp . --select-class=AlgorithmEngineerTests
runBackendDeveloperTests:
	javac LocationBD.java
	javac EdgeBD.java
	javac LocationReaderBD.java
	javac BaseGraph.java
	javac PathFinderBackendBD.java
	javac -cp .:junit5.jar:gs-core-2.0.jar BackendDeveloperTests.java
	java -jar junit5.jar -cp .:junit5.jar:gs-core-2.0.jar --select-class=BackendDeveloperTests
runFrontendDeveloperTests:
	javac PathFinderFrontendFD.java
	javac PathFinderBackendFD.java
	javac -cp .:junit5.jar FrontendDeveloperTests.java
	java -jar junit5.jar -cp . --select-class=FrontendDeveloperTests
clean:
	rm -f *.class

