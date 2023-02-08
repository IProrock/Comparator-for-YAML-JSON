run-dist:
	./build/install/app/bin/app

run-dist-valid:
	./build/install/app/bin/app ./src/main/resources/file1.json ./src/main/resources/file2.json

run-dist-invalid:
	./build/install/app/bin/app ./src/main/resources/missingfile1.json ./src/main/resources/file2.json

report:
	./gradlew jacocoTestReport