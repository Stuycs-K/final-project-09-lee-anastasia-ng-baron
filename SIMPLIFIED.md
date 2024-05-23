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

### Things I have no idea what it is

Galois Field