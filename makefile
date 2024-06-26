default:

	@echo "AES-256 encryption and decryption:"
	@echo "make encrypt ARGS="STRING inputString keyString" -> Encrypts input using key"
	@echo "make encrypt ARGS="FILE inputFile keyFile outputFile" -> Encrypts input using key"
	@echo "make decrypt ARGS="STRING inputString keyString" -> Decrypts input using key"
	@echo "make decrypt ARGS="FILE inputFile keyFile outputFile" -> Decrypts input using key"
	@echo "Key must have length 32 bytes"

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