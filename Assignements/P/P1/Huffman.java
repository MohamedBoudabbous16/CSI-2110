
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import net.datastructures.*;

import net.datastructures.*;

/**
 * Class Huffman that provides Huffman compression encoding and decoding of files
 * @author Lucia Moura
 *
 */

public class Huffman {

	/**
	 * 
	 * Inner class Huffman Node to Store a node of Huffman Tree
	 *
	 */
	private class HuffmanTreeNode { 
	    private int character;      // character being represented by this node (applicable to leaves)
	    private int count;          // frequency for the subtree rooted at node
	    private HuffmanTreeNode left;  // left/0  subtree (NULL if empty)
	    private HuffmanTreeNode right; // right/1 subtree subtree (NULL if empty)
	    public HuffmanTreeNode(int c, int ct, HuffmanTreeNode leftNode, HuffmanTreeNode rightNode) {
	    	character = c;
	    	count = ct;
	    	left = leftNode;
	    	right = rightNode;
	    }
	    public int getChar() { return character;}
	    public Integer getCount() { return count; }
	    public HuffmanTreeNode getLeft() { return left;}
	    public HuffmanTreeNode getRight() { return right;}
		public boolean isLeaf() { return left==null ; } // since huffman tree is full; if leaf=null so must be right
	}
	
	/**
	 * 
	 * Auxiliary class to write bits to an OutputStream
	 * Since files output one byte at a time, a buffer is used to group each output of 8-bits
	 * Method close should be invoked to flush half filed buckets by padding extra 0's
	 */
	private class OutBitStream {
		OutputStream out;
		int buffer;
		int buffCount;
		public OutBitStream(OutputStream output) { // associates this to an OutputStream
			out = output;
			buffer=0;
			buffCount=0;
		}
		public void writeBit(int i) throws IOException { // write one bit to Output Stream (using byte buffer)
		    buffer=buffer<<1;
		    buffer=buffer+i;
		    buffCount++;
		    if (buffCount==8) { 
		    	out.write(buffer); 
		    	//System.out.println("buffer="+buffer);
		    	buffCount=0;
		    	buffer=0;
		    }
		}
		
		public void close() throws IOException { // close output file, flushing half filled byte
			if (buffCount>0) { //flush the remaining bits by padding 0's
				buffer=buffer<<(8-buffCount);
				out.write(buffer);
			}
			out.close();
		}
		
 	}
	
	/**
	 * 
	 * Auxiliary class to read bits from a file
	 * Since we must read one byte at a time, a buffer is used to group each input of 8-bits
	 * 
	 */
	private class InBitStream {
		InputStream in;
		int buffer;    // stores a byte read from input stream
		int buffCount; // number of bits already read from buffer
		public InBitStream(InputStream input) { // associates this to an input stream
			in = input;
			buffer=0; 
			buffCount=8;
		}
		public int readBit() throws IOException { // read one bit to Output Stream (using byte buffer)
			if (buffCount==8) { // current buffer has already been read must bring next byte
				buffCount=0;
				buffer=in.read(); // read next byte
				if (buffer==-1) return -1; // indicates stream ended
			}
			int aux=128>>buffCount; // shifts 1000000 buffcount times so aux has a 1 is in position of bit to read
			//System.out.println("aux="+aux+"buffer="+buffer);
			buffCount++;
			if ((aux&buffer)>0) return 1; // this checks whether bit buffcount of buffer is 1
			else return 0;
			
		}

	}
	private ArrayList<Integer> buildFrequencyTable(InputStream input) throws IOException {
		ArrayList<Integer> freqTable = new ArrayList<Integer>(257);
		for (int i = 0; i < 257; i++) freqTable.add(i, 0);

		int byteRead;
		while ((byteRead = input.read()) != -1) {
			freqTable.set(byteRead, freqTable.get(byteRead) + 1);
		}
		freqTable.set(256, 1);
		input.close();

		return freqTable;
	}



	private HuffmanTreeNode buildEncodingTree(ArrayList<Integer> freqTable) {

		// creates new huffman tree using a priority queue based on the frequency at the root

		/************ your code comes here ************/
		System.out.print("FrequencyTable is=[");
		for (int i = 0; i < freqTable.size(); i++) {
			System.out.print(freqTable.get(i));
			if (i != freqTable.size() - 1) {
				System.out.print(", ");
			}
			if ((i + 1) % 16 == 0 && i != freqTable.size() - 1) {
				System.out.println();
			}
		}
		System.out.println("]");


		HeapPriorityQueue<Integer, HuffmanTreeNode> priorityQueue = new HeapPriorityQueue<>(Comparator.<Integer>naturalOrder());

		for (int i = 0; i < freqTable.size(); i++){
			int freq = freqTable.get(i);
			if (freq>0){
				HuffmanTreeNode leafNode = new HuffmanTreeNode(i, freq, null, null);
				priorityQueue.insert(freq, leafNode);
			}
		}
		while (priorityQueue.size() > 1) {
			HuffmanTreeNode left = priorityQueue.removeMin().getValue();
			HuffmanTreeNode right = priorityQueue.removeMin().getValue();
			HuffmanTreeNode parent = new HuffmanTreeNode(-1, left.getCount() + right.getCount(), left, right);
			priorityQueue.insert(parent.getCount(), parent);
		}

		return priorityQueue.removeMin().getValue();
	}





	/**
	 *
	 * @param encodingTreeRoot - input parameter storing the root of the HUffman tree
	 * @return an ArrayList<String> of length 257 where code.get(i) returns a String of 0-1 correspoding to each character in a Huffman tree
	 *                                                  code.get(i) returns null if i is not a leaf of the Huffman tree
	/**
	 */
	private ArrayList<String> buildEncodingTable(HuffmanTreeNode encodingTreeRoot) {
		ArrayList<String> encodingTable = new ArrayList<String>(257);
		for (int i = 0; i < 257; i++) encodingTable.add(i, null);

		Stack<HuffmanTreeNode> nodeStack = new ArrayStack<>();
		Stack<String> pathStack = new ArrayStack<>();

		nodeStack.push(encodingTreeRoot);
		pathStack.push("");

		while (!nodeStack.isEmpty()) {
			HuffmanTreeNode currentNode = nodeStack.pop();
			String currentPath = pathStack.pop();

			if (currentNode.isLeaf()) {
				int asciiIndex = currentNode.getChar();
				encodingTable.set(asciiIndex, currentPath);
			} else {
				if (currentNode.getLeft() != null) {
					nodeStack.push(currentNode.getLeft());
					pathStack.push(currentPath + "0");
				}
				if (currentNode.getRight() != null) {
					nodeStack.push(currentNode.getRight());
					pathStack.push(currentPath + "1");
				}
			}
		}

		// Output the encoding table
		System.out.print("EncodingTable is=[");
		for (int i = 0; i < encodingTable.size(); i++) {
			System.out.print(encodingTable.get(i));
			if (i != encodingTable.size() - 1) {
				System.out.print(", ");
			}
			if ((i + 1) % 16 == 0 && i != encodingTable.size() - 1) {
				System.out.println();
			}
		}
		System.out.println("]");

		return encodingTable;
	}


	private void encodeData(InputStream input, ArrayList<String> encodingTable, OutputStream output) throws IOException {
		OutBitStream bitStream = new OutBitStream(output);

		int totalBitsWritten = 0;
		int totalBytesRead = 0;

		int byteRead;
		while ((byteRead = input.read()) != -1) {
			totalBytesRead++;

			String code = encodingTable.get(byteRead);
			for (int i = 0; i < code.length(); i++) {
				if (code.charAt(i) == '0') {
					bitStream.writeBit(0);
				} else if (code.charAt(i) == '1') {
					bitStream.writeBit(1);
				}
				totalBitsWritten++;
			}
		}
		String endCode = encodingTable.get(256);
		for (int i = 0; i < endCode.length(); i++) {
			if (endCode.charAt(i) == '0') {
				bitStream.writeBit(0);
			} else if (endCode.charAt(i) == '1') {
				bitStream.writeBit(1);
			}
			totalBitsWritten++;
		}

		bitStream.close();
		int totalBytesWritten = (totalBitsWritten + 7) / 8;
		System.out.println("Number of bytes in input : " + totalBytesRead);
		System.out.println("Number of bytes in output: " + totalBytesWritten);
	}



	private void decodeData(ObjectInputStream input, HuffmanTreeNode encodingTreeRoot, FileOutputStream output) throws IOException {

		InBitStream inputBitStream = new InBitStream(input);

		int totalBitsRead = 0;
		int totalBytesWritten = 0;

		HuffmanTreeNode currentNode = encodingTreeRoot;
		int bit;
		while (true) {
			bit = inputBitStream.readBit();
			if (bit == -1) {
				break;
			}
			totalBitsRead++;
			if (bit == 0) {
				currentNode = currentNode.getLeft();
			} else if (bit == 1) {
				currentNode = currentNode.getRight();
			} else {
				throw new IOException("Invalid bit value: " + bit);
			}
			if (currentNode == null) {
				throw new IOException("Invalid bit sequence - current node is null");
			}
			if (currentNode.isLeaf()) {
				int decoded = currentNode.getChar();
				if (decoded == 256) {
					break;
				}
				output.write(decoded);
				totalBytesWritten++;
				currentNode = encodingTreeRoot;
			}
		}
		output.flush();
		output.close();

		int totalBytesRead = (totalBitsRead + 7) / 8;
		System.out.println("Number of bytes in input : " + totalBytesRead);
		System.out.println("Number of bytes in output: " + totalBytesWritten);
	}


	/**
	 * Method that implements Huffman encoding on plain input into encoded output
	 * @param input - this is the file to be encoded (compressed)
	 * @param codedOutput - this is the Huffman encoded file corresponding to input
	 * @throws IOException indicates problems with input/output streams
	 */
	public void encode(String inputFileName, String outputFileName) throws IOException {
		System.out.println("\nEncoding "+inputFileName+ " " + outputFileName);
		
		// prepare input and output files streams
		FileInputStream input = new FileInputStream(inputFileName);
		FileInputStream copyinput = new FileInputStream(inputFileName); // create copy to read input twice
		FileOutputStream out = new FileOutputStream(outputFileName);
 		ObjectOutputStream codedOutput= new ObjectOutputStream(out); // use ObjectOutputStream to print objects to file
 		
		ArrayList<Integer> freqTable= buildFrequencyTable(input); // build frequencies from input
		//System.out.println("FrequencyTable is="+freqTable);
		HuffmanTreeNode root= buildEncodingTree(freqTable); // build tree using frequencies
		ArrayList<String> codes= buildEncodingTable(root);  // buildcodes for each character in file
		//System.out.println("EncodingTable is="+codes);
		codedOutput.writeObject(freqTable); //write header with frequency table
		encodeData(copyinput,codes,codedOutput); // write the Huffman encoding of each character in file
	}
	
    /**
     * Method that implements Huffman decoding on encoded input into a plain output
     * @param codedInput  - this is an file encoded (compressed) via the encode algorithm of this class 
     * @param output      - this is the output where we must write the decoded file  (should original encoded file)
     * @throws IOException - indicates problems with input/output streams
     * @throws ClassNotFoundException - handles case where the file does not contain correct object at header
     */
	public void decode (String inputFileName, String outputFileName) throws IOException, ClassNotFoundException {
		System.out.println("\nDecoding "+inputFileName+ " " + outputFileName);
		// prepare input and output file streams
		FileInputStream in = new FileInputStream(inputFileName);
 		ObjectInputStream codedInput= new ObjectInputStream(in);
 		FileOutputStream output = new FileOutputStream(outputFileName);
		@SuppressWarnings("unchecked")
		ArrayList<Integer> freqTable = (ArrayList<Integer>) codedInput.readObject(); //read header with frequency table
		//System.out.println("FrequencyTable is="+freqTable);
		HuffmanTreeNode root= buildEncodingTree(freqTable);
		decodeData(codedInput, root, output);
	}
	
	
}
	
    