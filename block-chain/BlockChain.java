import java.security.NoSuchAlgorithmException;

/**
* The BlockChina class.
*
* @author  [chavezgi][jinannan]
* @since   2017-09-25 
*/
public class BlockChain {
    private Node first;
    private Node last;

    /**
    * The Node class, serves as the linkedlistnode
    *
    * @author  [chavezgi][jinannan]
    * @since   2017-09-25 
    */
    private class Node{
        private Block block;
        private Node next; 

        public Node(Block block){
            this.block = block;
            this.next = null;
        }
    }

    /**
     * This is the constructor.
     * 
     * @param int initial, the amount of the first block
     * @return nothing
     */
    public BlockChain(int inital) throws NoSuchAlgorithmException{
        Node firstBlock = new Node(new Block(0,inital,null));
        this.first = firstBlock;
        this.last = firstBlock;
        //System.out.println("blockChain constructed!");
    }

    /**
     * This is mine method. Mines for the new block
     * 
     * @param int mount
     * @return a block that has the right nonce
     */
    public Block mine(int amount) throws NoSuchAlgorithmException{
        return new Block(this.last.block.getNum()+1,amount,this.last.block.getHash());
    }

    /**
     * This is getSize method.
     * 
     * @param nothing
     * @return size, the number of blocks in the blockchain
     */
    public int getSize(){
        return last.block.getNum()+1;
    }

    /**
     * This is append method. Append a new block to the last
     * 
     * @param Block blk
     * @return nothing
     * @throws NoSuchAlgorithmException 
     */
    public void append(Block blk) throws NoSuchAlgorithmException{
    	//Check if the block is valid
    	if(blk.getPrevHash().equals(this.last.block.getHash())&&
    		blk.getHash().isValid()) {
        this.last.next = new Node(blk);
        this.last = this.last.next;
    	}else {
    		throw new IllegalArgumentException("Invalid amount or nonce");
    	}
    }

    /**
     * This is removeLast method. Remove the last block
     * @param nothing
     * @return ifRemoved, a bool value 
     */
    public boolean removeLast(){
        if(this.last.block.getNum() == 0) return false;
        Node cur = this.first;
        while(cur.next.next != null){
            cur = cur.next;
        }
        this.last = cur;
        last.next = null;
        return true;
    }

    /**
     * This is getHash method.
     * 
     * @param nothing
     * @return the Hash field of the last block 
     */
    public Hash getHash(){
        return this.last.block.getHash();
    }

    /**
     * This is isValidBlockChain method.
     * There are three things to check.
     * 1. If in every block, the given num, amount, nonce, and preHash produces the same Hash
     * 2. If preHash is equal to the Hash or previous block
     * 3. If the balance of anna >= 0
     * 
     * @param nothing
     * @return the Hash field of the last block 
     */
    public boolean isValidBlockChain() throws NoSuchAlgorithmException{
        Node cur = this.first;
        int annaBalance = 0;
        while(true){
            Block curBlk = cur.block;
            annaBalance += curBlk.getAmount();
            if (annaBalance < 0){
                return false;
            }

            //The expected block, every field should be as same as curBlk
            Block expect = new Block(curBlk.getNum(),curBlk.getAmount(),curBlk.getPrevHash(),curBlk.getNonce());
            //Check if hashValue is correct
            if(!curBlk.getHash().equals(expect.getHash())) {
                //System.out.println("Hash is wrong!");
                return false;
            }
            //Check if the next block's prevHash is equal to this block's hash
            if (cur.next != null) {
                cur = cur.next;
            }else{
                break;
            }
            if(!cur.block.getPrevHash().equals(expect.getHash())) return false;
        }
        return true;
    }

    /**
     * This is printBalance method. Prints the balance of Alice and Bob.
     * 
     * @param nothing
     * @return nothing
     */
    public void printBalances(){
        Node cur = this.first;
        int annaBalance = 0;
        while(cur != null){
            annaBalance += cur.block.getAmount();
            cur = cur.next;
        }
        String out = String.format("Alice: %d, Bob: %d", annaBalance, 300-annaBalance);
        System.out.println(out+"\n");
    }

    /**
     * This is toString method. Prints the entire BlcokChain.
     * 
     * @param nothing
     * @return out, a string of the entire blockchain
     */
    public String toString(){
        Node cur = this.first;
        String out = "";
        while(cur != null){
            out += cur.block.toString()+"\n";
            cur = cur.next;
        }
        return out;
    }

}
