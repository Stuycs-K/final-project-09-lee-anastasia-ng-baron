default:

	@echo "make encrypt ARGS="type inputFile keyFile outputFile" -> Encrypts input using key"
	@echo "make decrypt ARGS="type inputFile keyFile outputFile" -> Decrypts input using key"
	@echo "output type options are byte, hex, ASCII"

encrypt: Encrypt.class Matrix.class Driver.class

	@java Driver encrypt $(ARGS)

decrypt: Decrypt.class Matrix.class Driver.class

	@java Driver decrypt $(ARGS)

Encrypt.class: Encrypt.java

	@javac Encrypt.java

Decrypt.class: Decrypt.java

	@javac Decrypt.java

Matrix.class: Matrix.java

	@javac Matrix.java

Driver.class: Driver.java

	@javac Driver.java

clean:

	@rm *.class