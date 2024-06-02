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

KeyExpansion - Takes 32 byte array key and converts it to 60 words array key schedule to be used to make round keys, which are 4 words each, so 15 round key in total; happens prior to Cipher()

Cipher - takes the input, Nr, and the 60 words array key schedule from KeyExpansion
Encryption process
- Takes the original input 16 bytes and applies 4 words (the 1st round key) from the key schedule (lines 2 and 3)(AddRoundKey applies the roundkey to state)
- Then loops through next 13 round keys (for round from 1 to Nr − 1): applying the subBytes, ShiftRows, and MixColumns transformation, then it applies the next round key to the transformed state before looping again
- This way every loop runs the encrypted state through the transformations and the next round key to create an even more encrypted state, thus layering on encryption
- After the loop of layered encryption, subBytes and ShiftRows are applied, and then the LAST round key is applied: AddRoundKey(state, w[4 * Nr...4 * Nr + 3])(The second arg is the last 4 words of the key schedule)
- return the encrypted state

KEY CONCEPT: LAYERED ENCRYPTION

Instead of -> Input x Key
AES does this -> (((((((((((((((Input x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key) x Transformations x Round Key)

