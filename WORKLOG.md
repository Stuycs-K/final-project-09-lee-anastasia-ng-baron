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