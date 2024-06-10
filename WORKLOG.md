# Work Log

## Anastasia Lee

### 5/22/24

- Added use cases for AES to presentation
- Updated README
- Added Matrix class, edited it to store bytes instead of doubles
- Added makeState method (first step of encryption)

### 5/23/24

- Attempted to start implementing the evaluation of inverses
- Read to understand Galois Fields better

### 5/24/24

- Hard coded SBox array to be used in the SubBytes method

### 5/28/24

- Completed and tested SubBytes method
- Wrote preliminary version of MixColumns method

### 5/29/24
- Adjusted Matrix toString method so that output is easier to read
- Wrote xTimes and Times3 methods for multiplication in GF(2^8)
- Changed and completed MixColumns method

### 5/30/24
- Wrote AddRoundKey method

### 6/3/24
- Edited wrapper function to allow for string input and key
- File maintenance: removed class files, renamed files
- Added dependencies to makefile
- Edited Driver methods so that the input can be any length, not just 16

### 6/5/24
- Copied over sbox, wrote InvSubBytes method
- Wrote InvShiftRows method
- Copied over xTimes, XOR, AddRoundKey (which is its own inverse) from Encrypt to Decrypt
- Wrote InvMixColumns method as well as Times9, TimesB, TimesD, TimesE methods
- Fixed Times3 method

### 6/9/24
- Attempted to implement new input/output system for Encrypt and Decrypt (edited makefile, Driver, Encrypt, Decrypt, Matrix)
- Updated README
- Added presentation notes to PRESENTATION.md
- Worked on Google Slides presentation
- Recorded video


## Baron Ng

### 5/22/24

- Read and Compiled relevant Background Info on AES
- Placed Info in HISTORY.md

### 5/23/24

- Noted the functions for the algorthm, no details yet
- Simplified the necessary preliminary understanding (ignoring math) in SIMPLIFIED.md

### 5/24/24

- Notes for overarching idea of Cipher(), InvCipher(), KeyExpansion()

### 5/26/24

- Wrote notes for all non-inverse functions except xTimes

### 5/28/24

- Wrote documentation for existing functions
- Finished ShiftRows()

### 5/29/24

- Wrote RotWord() and SubWord()
- Set up KeyExpansion()

### 5/30/24

- Struggling to implement KeyExpansion()

### 5/31/24

- Fixed ShiftRows()
- Fixed AddRoundKey()
- Revised my comprehension of the algorithm
- Restructured methods accurately

### 6/3/24

- Finished KeyExpansion()
- Restructured Encrypt to work with Driver
- Wrote makefile
- Wrote Driver.java

### 6/4/24

- Restructured Decrypt.java to look similar to Encrypt
- Included the Inverse functions

### 6/5/24

- Fixed ShiftRows (again)

### 6/6/24

- Fixed KeyExpansion and Tested

### 6/7/24

- Checked individual functions for Encrypt.java

## Sources
- https://nvlpubs.nist.gov/nistpubs/FIPS/NIST.FIPS.197-upd1.pdf
- https://csrc.nist.gov/CSRC/media/Projects/Cryptographic-Standards-and-Guidelines/documents/examples/AES_Core256.pdf
- https://nvlpubs.nist.gov/nistpubs/jres/126/jres.126.024.pdf
- https://www.di-mgt.com.au/cryptopad.html
- https://www.kiteworks.com/risk-compliance-glossary/aes-256-encryption/