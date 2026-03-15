# CyberSecurity-
Alright Prax — here’s a clean, professional README that looks like something a serious GitHub repo would have. It’s structured, technical, and polished (not the typical “student assignment” vibe). You can paste this directly into README.md.


Cryptographic Algorithms Implementation (Java)

A Java-based implementation of fundamental cryptographic algorithms designed to demonstrate the core principles of symmetric and asymmetric encryption.
This project explores the internal mechanisms of encryption systems including key generation, substitution, permutation, and modular arithmetic.

The implementations are designed for educational and research purposes to help understand how modern encryption algorithms operate at a conceptual level.


Overview

This repository contains implementations of three core cryptographic algorithms:
	•	Simplified Data Encryption Standard (S-DES)
	•	Simplified Advanced Encryption Standard (S-AES)
	•	RSA Public Key Cryptosystem

Each algorithm demonstrates different aspects of cryptography such as Feistel networks, substitution–permutation networks, and asymmetric encryption.


Implemented Algorithms

1. Simplified Data Encryption Standard (S-DES)

S-DES is a simplified block cipher designed to illustrate the internal structure of the Data Encryption Standard (DES). It uses a Feistel network and operates on small bit-sized data blocks to make the algorithm easier to understand.

Characteristics
	•	Block size: 8 bits
	•	Key size: 10 bits
	•	Structure: Feistel network
	•	Rounds: 2

Core Operations
	•	Initial permutation
	•	Key generation using permutation and shifting
	•	Round function (fk)
	•	Substitution using S-Boxes
	•	Half swapping
	•	Inverse permutation

Learning Outcome

The algorithm demonstrates how confusion and diffusion are achieved through substitution and permutation operations.


2. Simplified Advanced Encryption Standard (S-AES)

S-AES is a reduced version of the Advanced Encryption Standard (AES) used for teaching purposes. It illustrates the structure of AES using smaller block sizes and simplified mathematical operations.

Characteristics
	•	Block size: 16 bits
	•	Key size: 16 bits
	•	Number of rounds: 2
	•	Mathematical domain: Galois Field GF(2⁴)

Encryption Steps
	1.	Initial AddRoundKey
	2.	Round 1
	•	SubNib (substitution)
	•	ShiftRows
	•	MixColumns
	•	AddRoundKey
	3.	Round 2
	•	SubNib
	•	ShiftRows
	•	AddRoundKey

Learning Outcome

This implementation highlights how AES achieves strong security through:
	•	Substitution layers
	•	Permutation layers
	•	Finite field arithmetic


3. RSA Public Key Cryptosystem

RSA is one of the most widely used asymmetric encryption algorithms used in modern secure communication systems.

Key Concepts
	•	Public key encryption
	•	Modular exponentiation
	•	Prime number factorization
	•	Euler’s Totient function

Key Generation Process
	1.	Select two prime numbers p and q
	2.	Compute n = p × q
	3.	Compute φ(n) = (p − 1)(q − 1)
	4.	Select public exponent e
	5.	Compute private key d

Encryption

C = M^e mod n

Decryption

M = C^d mod n

Learning Outcome

RSA demonstrates how mathematical hardness problems such as integer factorization provide security in cryptographic systems.

⸻

Project Structure

cryptography-algorithms/
│
├── SDES.java
├── SAES.java
├── SimpleRSA.java
│
└── README.md



Requirements
	•	Java Development Kit (JDK 8 or higher)
	•	Any Java IDE or terminal environment


Compilation

Compile the Java programs using:

javac SDES.java
javac SAES.java
javac SimpleRSA.java

Execution

Run the programs using:

java SDES
java SAES
java SimpleRSA

Each program accepts user input through the console and outputs the corresponding ciphertext and decrypted message.


Educational Objectives

This project helps in understanding:
	•	Fundamentals of symmetric and asymmetric cryptography
	•	Block cipher architecture
	•	Key scheduling techniques
	•	Modular arithmetic in cryptographic systems
	•	Security concepts such as confusion and diffusion

Applications of These Algorithms

The concepts explored in this project are used in many modern systems including:
	•	Secure web communication (HTTPS / TLS)
	•	Digital signatures
	•	Secure email systems
	•	Authentication protocols
	•	Data protection in distributed systems


Author

Pratik Pandurang Pawar
B.Tech – Artificial Intelligence and Machine Learning
Vishwakarma Institute of Technology, Pune


If you want, I can also show you how to make this 10× more impressive on GitHub by adding:
	•	architecture diagrams
	•	algorithm flowcharts
	•	shields.io badges
	•	encryption pipeline diagrams

Those make your repo look like a real research/engineering project, not just a lab submission. 🚀
