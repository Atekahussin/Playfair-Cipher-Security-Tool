# 🔐 Playfair Cipher Encryption Tool

![Security](https://img.shields.io/badge/Focus-Computer%20Security-red.svg)
![Language](https://img.shields.io/badge/Language-Java-orange.svg)
![KFU](https://img.shields.io/badge/University-King%20Faisal%20University-green.svg)

## 📌 Project Overview
Data protection is a cornerstone of modern computing. This project implements the **Playfair Cipher**, a classic symmetric encryption technique that uses a 5x5 matrix of letters to encrypt pairs of letters (digraphs). It provides a hands-on demonstration of how classical cryptography balances simplicity and security.

## ⚙️ How it Works
The tool follows the standard Playfair algorithm rules:
1. **Key Matrix Generation:** Creates a 5x5 grid based on a user-provided keyword.
2. **Digraph Transformation:** Breaks the plaintext into pairs of letters.
3. **Encryption/Decryption Rules:**
   - Same Row: Shift right/left.
   - Same Column: Shift down/up.
   - Rectangle: Swap corners.

## 🚀 Key Features
- **Dynamic Key Support:** Users can enter any keyword to generate a unique encryption matrix.
- **Bi-directional:** Supports both encryption and decryption of text.
- **Error Handling:** Manages duplicate letters in digraphs (using 'X' as a filler) and handles 'I/J' alignment.

## 🛠️ Tech Stack
- **Programming Language:** Java.
- **Concepts:** Digraph Cryptography, Matrix Manipulation, String Processing.

## 📁 Repository Structure
- `src/`: Contains `PlayfairCipher.java` (The full Java implementation of the algorithm).
- `Documentation/`: Full technical report (PDF) detailing the encryption/decryption process.

## 👥 The Team
Developed by Computer Science students at **King Faisal University**:
- **Atekah Hussain**
- Zainab Alhadhari
- Anfal Alsuhayib
- Maryam Alshabib
- **Supervised by:** Prof. Mona Ali

---
*Developed for the Computer Security Course - KFU.*
---
*Connect with me on LinkedIn for more projects!*
https://www.linkedin.com/in/ateka-hussain/
