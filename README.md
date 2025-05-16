# DNA Analyzer - Java Console Application

_A command-line Java application originally developed for a CS &141 assignment, now being refactored to apply modern programming practices._

## About This Project

This project was initially written for an early Java programming course. The original assignment focused on file input, basic string processing, pattern recognition, and logic-based decision making. It analyzes DNA sequences from a text file and determines if a sequence is likely to encode a protein.

This version is being revisited and refactored to improve code structure, readability, and flexibility while applying principles like modularization and potentially an MVC-based separation of logic.

## Features

- Reads DNA sequence input from a user-specified text file
- Processes nucleotide strings, codons, and mass percentages
- Checks protein-coding validity based on multiple biological rules
- Outputs results to a user-specified file
- Simple text interface using Java's `Scanner` and `PrintStream`

## Tech Stack

- Java 17+
- Command-line interface (CLI)

## Planned Enhancements

- Modularize logic into distinct classes (e.g., Analyzer, Region, View)
- Improve method names, comments, and code clarity
- Add user feedback for invalid nucleotide characters or malformed sequences
- Support lowercase sequences in input
- Display junk character (`-`) counts
- Export output in alternative formats like `.csv` or `.json`
- Introduce unit tests for mass and codon logic
- Optionally support batch file processing

## Installation & Usage

### Prerequisites
- Java 17 or later (Java 22+ recommended)

### Clone the Repository

```bash
git clone https://github.com/your-username/dna-analyzer.git
cd dna-analyzer
```

### Compile the Source Code

```bash
javac -d out src/DNALab.java
```

### Run the Application

```bash
java -cp out DNALab
```

> Note: Output will be saved to a user-specified file. Input files must be formatted with alternating lines for region name and nucleotide sequence.

## Author

**Dylan Canfield**

