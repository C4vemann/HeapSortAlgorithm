To run this program:
	1. Open the command line on your computer 
	2. Go to the directory where file is saved
	3. Either copy and paste or write the following into the command line to compile the program: 
		
						javac AssignmentA3_1.java

	4. Enter the following command in the command line to run the program: 

						java AssignmentA3_1 <file_path>

		* Where <file_path> is the location where your input file is saved
		* If the input file is in the same directory as the program than just the file name is also accepted

		ex. java AssignmentA3_1 input.txt
		ex. java AssignmentA3_1 /home/%USER%/Desktop/input.txt
		ex. java AssignmentA3_1 C:/user/%USER%/Desktop/input.txt

Output:
	A single line of text in the command line that presents a sorted list of key,value pairs represented as:
		* key = number of characters in a persons name
		* pairs = a list of peoples names that have the same number characters in their name

	Form:
		{#=[name,...], #=[name,...], ...} 