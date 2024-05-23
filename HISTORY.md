Information is Ripped Directly from [Here]](https://nvlpubs.nist.gov/nistpubs/jres/126/jres.126.024.pdf) for now, just to get the relevant info down


In the late 1990s, the National Institute of Standards and Technology (NIST) was about to decide if it was going to specify a new cryptographic algorithm standard for the protection of U.S. government and commercial data. The current standard was showing signs of age and would not be up to the task of providing strong security much longer.

With the DES in its twilight and SKIPJACK under the key escrow cloud, it was clear that NIST
needed a new symmetric block cipher.

NIST could upgrade its encryption standard to Triple DES. This more secure, but slower, algorithm would likely suffice for a number of years, but it was unclear how the cryptographic community and prospective users would view using an algorithm for which the basic engine could be exhausted.

The alternative was to find an entirely new cryptographic block cipher to be the NIST standard. However, this alternative was not without its own problems. In the charged atmosphere of the U S. government’s key escrow program, it appeared as though NIST was not on the side of the commercial product vendors who wanted to sell their products internationally.

To succeed with the new standard, NIST would have to think and act differently than it did with the cryptographic standards programs of the past. A NIST AES Selection Team was formed.

NIST decided that the cryptographic community would have to be involved from the beginning in the development of the new cryptographic standard. This involvement would actually be a partnership. NIST hoped that such a partnership would lead to acceptance of the final selection.

Initial Concerns

- National Security: One of the initial tasks was to query NSA about its thoughts on this new approach. Fortunately, there was no objection, and NIST proceeded.

- Key Size: The DES, with its fixed-length key size, became only weaker as computational efficiency increased. NIST did not want to have to fight key-size battles again with the AES. How could a key-size controversy be avoided? At what size will no one argue that it should be larger, and at what size will no one argue that the size is excessive?

- Export Control: Even though the DES was a public algorithm, the export of DES products from the United States was strictly controlled. In fact, the U.S. government required that the effective key size of exported products had to be reduced from 56 bits to no more than 40 bits. This reduction of the key size was very unpopular with U.S. vendors, who wanted to sell products overseas.

- Participation of the Cryptographic Community: NIST would be asking for significant contributions of time and effort from the cryptographic community. However, the AES Selection Team did not have funds to pay for external cryptographic research, and even if it did have some funding, the work would likely be awarded only to a single vendor, thus leaving all other parties out of the process. A much better approach seemed to be running a contest whereby candidate algorithms could be submitted for consideration. In addition, the cryptographic community could be invited to evaluate and comment on the candidate algorithms. To the winning candidate, NIST would offer the honor of being selected as a U.S. government–approved cryptographic algorithm, and to the evaluators, NIST would offer interesting topics for their research papers and dissertations, thereby driving advances in the field.

- Algorithm Requirements: A cryptographic algorithm is designed to meet specific requirements (e.g., application, type of cryptographic algorithm, key size, block size, efficiency). Before a candidate algorithm could be developed, these requirements needed to be specified.

- Rules of the Competition: The rules of the competition would need to be fair and specified in
advance. These rules would include the process and deadlines, the specification of a valid submission, and the algorithm evaluation criteria.

Seventy-three participants attended the workshop at NIST in Gaithersburg, Maryland. NIST began by announcing its initial goals for the AES algorithm, including that it should:

(1) be a strong block cipher that would support commonly used modes of operation;
(2) be selected in a fair and open manner;
(3) be usable by both industry and the U.S. government worldwide;
(4) have a variable key size so that security could be increased when needed;
(5) be at least as secure as Triple DES; and
(6) be significantly more efficient than Triple DES.

The following points were made at the workshop.

(1) Key sizes of 128 and 256 bits should be mandatory.
(2) Mandatory block sizes of 128 and 256 bits were discussed, while other sizes could be optional.
(3) Key setup time would be important when considering the efficiency and the agility of the algorithm.
(4) Minor adjustments of candidate algorithms may be allowed, but major redesigns should not be permitted.
(5) Some participants wanted to allow for proprietary, optimized software implementations.

During the round 2 analysis, NIST heard a rumor that in Europe some had predicted that the IBM candidate, MARS, would win the competition. The thinking was that NIST would pick an algorithm designed by an American company and that IBM would be the favorite company because IBM and NIST had worked together on the DES development. However, the AES Selection Team was determined to select the AES based on the merits of the finalists after considering all available information. If the eventual winner happened to be from another country, that would just lend credence to the fairness of the process. 

On October 2, 2000, NIST announced the selection of Rijndael and produced a paper summarizing the entire AES selection process. A significant factor in the selection of Rijndael was its consistently good performance over software, hardware, firmware, and smart card implementations.

On December 6, 2001, NIST announced the approval of the AES as Federal Information Processing Standard (FIPS) 197 in the Federal Register. The five-year process to develop the new standard was complete.