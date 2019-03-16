# Class-Projects-and-Labs

## CSC 207 Object-Oriented Programming and Data Structure

# The sound of sorting （SortingVisualizer 文件夹）
In folder SortingVisualizer

# Block Chain (block-chain 文件夹)
## Introduction
Blockchains, as a distributed data structure, require careful coordination between the participating computers on the network. As this is not a distributed systems course, we will not address these issues directly. However, the blockchain itself is simply a list with a bit of extra information to ensures its integrity. In this homework, we will develop a blockchain data structure that will allow us to understand the essential operations that blockchain-based application perform.

### The Hash Class
```
  Hash(byte[] data): constructs a new Hash object that contains the given hash (as an array of bytes). 
  byte[] getData(): returns the hash contained in this object. 
  boolean isValid(): returns true if this hash meets the criteria for validity, i.e., its first three indices contain zeroes. 
  String toString(): returns the string representation of the hash as a string of hexadecimal digits, 2 digits per byte. 
 boolean equals(Object other): returns true if this hash is structurally equal to the argument.
```

### The Block Class
```
   Block(int num, int amount, Hash prevHash): creates a new block from the specified parameters, performing the mining operation to discover the nonce and hash for this block given these parameters.
   Block(int num, int amount, Hash prevHash, long nonce): creates a new block from the specified parameters, using the provided nonce and additional parameters to generate the hash for the block. Because the nonce is provided, this constructor does not need to perform the mining operation; it can compute the hash directly.
   int getNum(): returns the number of this block.
   int getAmount(): returns the amount transferred that is recorded in this block.
   long getNonce(): returns the nonce of this block.
   Hash getPrevHash(): returns the hash of the previous block in the blockchain.
   Hash getHash(): returns the hash of this block.
   String toString(): returns a string representation of the block (see below).
```


### BlockChain Class

```
   Block mine(int amount): mines a new candidate block to be added to the list. The returned Block should be valid to add onto this list.
  int getSize(): returns the size of the blockchain. Note that number of the blocks provides a convenient method for quickly determining the size of the chain.
  void append(Block blk): adds this block to the list, throwing an IllegalArgumentException if this block cannot be added to the list (because it is invalid wrt the rest of the blocks).
  boolean removeLast(): removes the last block from the chain, returning true. If the chain only contains a single block, then removeLast does nothing and returns false.
  Hash getHash(): returns the hash of the last block in the chain.
  boolean isValidBlockChain(): walks the blockchain and ensures that its blocks are consistent and valid.
  void printBalances(): prints Alice’s and Bob’s respective balances in the form Alice: <amt>, Bob: <amt> on a single line, e.g., Alice: 300, Bob: 0.
  String toString(): returns a string representation of the BlockChain which is simply the string representation of each of its blocks, earliest to latest, one per line.
```

## BlockChainDriver Class 

Valid commands:
```
    mine: discovers the nonce for a given transaction
    append: appends a new block onto the end of the chain
    remove: removes the last block from the end of the chain
    check: checks that the block chain is valid
    report: reports the balances of Alice and Bob
    help: prints this list of commands
    quit: quits the program
```
## Reference
http://www.cs.grinnell.edu/~osera/courses/csc207/17fa/homework/block-chain.html





