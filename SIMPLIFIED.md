# Preliminary Understanding

### IO and Bits

The input and output are blocks: a sequence of 128 bits
A key is used as an input as well : 256 bits long for AES 256

if we have 128 bits,

Block: r_0, r_1, r_2 ... r_127

or 

Block: a_0, a_1, ... a_15

where a = 8 bytes = 1 byte

### The State

In the state array, denoted by s, each individual byte has two indices: a row index r in the range 0 ≤ r < 4 and a column index c in the range 0 ≤ c < 4.

An individual byte of the state is denoted by either s_r,c or s[r, c].

Input, State, and Output arrays are 4 by 4

### Array of Words

A word is a sequence of four bytes; a block consists of four words. (NO CONNECTION TO ENGLISH, they are just redefining "word")

The four columns of the state array are each a word.

s[r,c] btw

v1 = 
s0,0
s1,0
s2,0
s3,0

v2 = 
s0,1
s1,1
s2,1
s3,1

v3 = 
s0,2
s1,2
s2,2
s3,2

v4 = 
s0,3
s1,3
s2,3
s3,3

# Mathematical Preliminaries

## Galois Field

## Addition 

## Multiplication

# The Algorithm

Cipher()
InvCipher()

Round - Sequence of transformation, each round requiring a round key
Round key - a block represented as four words (16 bytes)

KeyExpansion()

Takes the block cipher as an input and generates the round keys as output.

Input: Array of words, denoted by _key_
Output: expanded array of words, denoted by _w_, called the _key schedule_

The block ciphers AES-128, AES-192, and AES-256 differ in three respects: 

1) The length of the key
2) The number of rounds, which determines the size of the required key schedule
3) The specifcation of the recursion within KeyExpansion()

For each algorithm, the number of rounds is denoted by Nr, and the number of words of the key is denoted by _Nk_.

![Alt text](/images/image.png)

The three inputs to Cipher() are: 

1) the data input in, which is a block represented as a lineararray of 16 bytes
2) the number of rounds Nr for the instance
3) the round keys

## Cipher()

SubBytes()
ShiftRows()
MixColumns()
AddRoundKey()

### SubBytes()

SBox()

### ShiftRows()

### MixColumns()

### AddRoundKey()

## KeyExpansion()

RotWord()
SubWord()

## InvCipher()

InvSubBytes()
InvShiftRows()
InvMixColumns()
AddRoundKey()

### InvShiftRows()

### InvSubBytes()

InvSBox()

### InvMixColumns()

### AddRoundKey()

AddRoundKey() is its own inverse.

## EqInvCipher()

Equivalent Inverse Cipher is apparently more efficient than just Inverse Cipher.
Idk the difference yet.

KeyExpansionEIC()

# Implementation Considerations

AES supports key size 128, 192, and 256
NK = 4, 6, 8 respectively

No keying restrictions when the key is generated appropriately.

Future revisions could include more flexibility with the allowed values for key length, block size, and number of rounds.

(Some more stuff, 6.4 and 6.5)