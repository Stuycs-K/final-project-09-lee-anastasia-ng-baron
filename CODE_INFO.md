AES256()

- state: two dimension array of 16 bytes, 4x4
- w: word array for the key schedule
- Nr: The number of rounds, 14 for AES-256
- Nk: The number of 32-bit words in the key, 8 for AES-256
- key: array of Nk words that comprise the key; 256 bits for AES-256
- KeyExpansion()
- - Rcon: Word array for round constant
- - 
- Cipher()
- - in: array of 16 bytes
- - out: array of 16 bytes
- 
- MixColumns()
- ShiftRows()
- SBox()
- SubWord()
- RotWord()
- xTimes()

Word - four bytes, aka a row or a column
Block - four words, aka the 4x4 matrix