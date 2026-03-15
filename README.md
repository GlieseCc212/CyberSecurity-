# CyberSecurity-
Prax, I checked your lab files. You have 3 cryptography assignments:
	•	S-DES implementation
	•	S-AES implementation
	•	RSA encryption/decryption

Here are the files for reference:
	•	￼ (Assignment 1 – S-DES)
	•	￼ (Assignment 2 – S-AES)
	•	￼ (Assignment 3 – RSA)

You asked for a README, so here is a clean README.md you can directly put in GitHub.

⸻

🔐 Cryptography Algorithms Implementation

Implementation of fundamental cryptographic algorithms in Java for educational purposes.
This project demonstrates how classical encryption systems work internally, including block ciphers and public-key cryptography.

The implementations focus on understanding the internal operations such as permutations, substitutions, key generation, and modular arithmetic.

⸻

📚 Implemented Algorithms

1️⃣ Simplified Data Encryption Standard (S-DES)

S-DES is a simplified version of the DES block cipher designed for learning purposes.

Key Features
	•	Uses 10-bit key
	•	Encrypts 8-bit plaintext
	•	Two-round Feistel structure
	•	Uses permutations and S-boxes

Steps
	1.	Key Generation
	2.	Initial Permutation
	3.	Round Function
	4.	Swap Halves
	5.	Second Round
	6.	Inverse Permutation

According to the assignment description, S-DES demonstrates how confusion and diffusion are achieved through permutations and substitutions.  ￼

⸻

2️⃣ Simplified Advanced Encryption Standard (S-AES)

S-AES is a reduced version of the AES encryption algorithm used for teaching cryptography concepts.

Key Features
	•	Uses 16-bit plaintext
	•	Uses 16-bit key
	•	Two rounds of encryption
	•	Uses Galois Field GF(2⁴) arithmetic

Encryption Operations
	•	SubNib
	•	ShiftRows
	•	MixColumns
	•	AddRoundKey

The algorithm structure closely mirrors real AES but in a simplified form for educational understanding.  ￼

⸻

3️⃣ RSA Encryption Algorithm

RSA is a public key cryptography algorithm widely used for secure communication.

Key Concepts
	•	Public Key (e, n)
	•	Private Key (d, n)
	•	Encryption
	•	Decryption

Steps

Key Generation
	1.	Choose two prime numbers p and q
	2.	Compute n = p × q
	3.	Compute Euler’s Totient
	4.	Select public exponent e
	5.	Compute private key d

Encryption

C = M^e mod n

Decryption

M = C^d mod n

RSA security is based on the difficulty of factoring large composite numbers.  ￼

⸻

🛠️ Technologies Used
	•	Java
	•	Object Oriented Programming
	•	Modular Arithmetic
	•	Cryptographic Algorithms

⸻

▶️ How to Run

Compile

javac SDES.java
javac SAES.java
javac SimpleRSA.java

Run

java SDES
java SAES
java SimpleRSA


⸻

🎯 Learning Outcomes
	•	Understanding block cipher design
	•	Learning public key cryptography
	•	Implementing encryption and decryption algorithms
	•	Understanding key generation and substitution techniques

⸻

👨‍💻 Author

Pratik Pandurang Pawar
B.Tech AIML
Vishwakarma Institute of Technology, Pune

⸻

💡 If you want, I can also give you a much more impressive GitHub README (with diagrams, badges, and architecture) so it looks like a serious cryptography project instead of just a lab assignment. That will look way better on your portfolio. 🚀
