[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/ecp4su41)
# THIS DOCUMENT IS REQUIRED
## Group Info
Anastasia Lee, Baron Ng

Group Name: Cryptic BarLee

Topic: Advanced Encryption Standard (AES) - ECB Mode

## Overview
Our project is an implementation of the Advanced Encryption Standard (AES) encryption and decryption algorithms, specifically AES-256 in the Electronic Codebook (ECB) mode. The robust key length (256 bits) of AES-256 makes it the most secure encryption algorithm available today. Since it is nearly impossible to break through brute force attacks, there is no cracking algorithm, but we implemented the decryption algorithm which requires the key.

## Instructions
Use the makefile recipes below to use the encrypt and decrypt functions. Note that the two options for each mode are STRING and FILE, and for STRING, the output is printed to terminal, while for FILE, the output is written to the specified output file.

"make encrypt ARGS="STRING inputString keyString" -> Encrypts input using key"

"make encrypt ARGS="FILE inputFile keyFile outputFile" -> Encrypts input using key"

"make decrypt ARGS="STRING inputString keyString" -> Decrypts input using key"

"make decrypt ARGS="FILE inputFile keyFile outputFile" -> Decrypts input using key"

Note that the key must be 32 bytes.

[Presentation Video](https://drive.google.com/file/d/1QkKnEOoTEcPQaIxCbf6bHsYU6dHmPiJU/view?usp=sharing)
[Presentation Slides](https://docs.google.com/presentation/d/1nhmdrG2L3amadkLpIs5oIHMFsc172JzwVckqLFe0w5A/edit?usp=sharing)