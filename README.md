# Bioformatics-toolbox

Implementations of basic methods from the field of sequence and structural
bioinformatics for mff course with id NDBI044


First five assignments have been programmed in Java (repository Bionformatics_toolbox_2nd).
Java 8 or later is necessary for compilation. 
The user selects from the menu using numbers in terminal.


1. FASTA parser (select number 1)

Data are extracted from fasta file with examples of molecules.
The user can see all possible molecule names from that file. 
Second menu with following options:
	1. Return whether the given subsequence occurs in the file
	   (case-insensitive)
	2. Return sequence length for given sequence
	3. Return information about selected molecule 
	   - name, amino acid sequence and its length

2. Measuring sequence similarity using Hamming distance (select number 2)

Data are extracted from the same fasta file mentioned above. 
In this part, the user should select two molecules to calculate 
their Hamming distance (the number of positions in which these 
sequences differ). If the molecules differ in lenght, 
error message "lengths are different" is shown. 

3. Sequence alignment using edit distance (select number 3)

If the user wants to see the sequence alignment and edit distance value, 
she/he should write down two sequences. Optimal alignmentns are obtained
by dynamic programming (function ed) and backtracking (procedure backtracking).

4. Processing multiple sequence alignment (select number 4)

Originally, the program is using msa.txt file with sequence of DNA binding domain. 
Hovewer, it can be changed inside class MsaRun -- msaParser. 
There are four options to choose in this section:
	1. Retrieve sequence by ID - show whole sequence according to its identifier.
	In case of DNA binding domain, there are five sequences - DICA_ECOLI, IMMF_BPPH1, 
	RPC_BPPH1, RPC_BPP2 and RPC2_BPP22.
	2. Retrieve given column from the MSA - return column based on its numeric index. 
	3. Retrieve sum of pairs score of a column based on its index
	4. Retrieve sum of pairs score of whole MSA file 

5. Conservation determination from multiple aligned sequences (select number 5)

Originally, the program is using msa.txt file with sequence of DNA binding domain. 
Hovewer, this can be changed inside class ConservationScoreRun -- msaPArser. 
The numeric index of column is necessary for this task. Result is a conservative
score for given column using minimum entropy (see third source).
 
# Sources
1. Chen, H. (2005). Prediction of solvent accessibility and sites of deleterious mutations from protein sequence. Nucleic Acids Research, 33(10), 3193–3199.

Internet sources:

	2. http://siret.ms.mff.cuni.cz/hoksza/courses/bioinformatics
	3. http://www.cse.chalmers.se/~kemp/teaching/UMF018/2010-2011/sequence2.pdf
