import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.ByteBuffer;;

/**
* The Block class is a class that has all the field and method for the block.
*
* @author  [chavezgi][jinannan]
* @since   2017-09-25 
*/
public class Block {

    private int num;
    private int amount;
    private Hash prevHash;
    private long nonce;
    private Hash hash;
    
    /**
     * This is the constructor. Mines for the nonce
     * 
     * @param int num, int amount, Hash prevHash.
     * @return a block object
     */
    public Block(int num, int amount, Hash prevHash) throws NoSuchAlgorithmException {
        this.num = num;
        this.amount = amount;
        this.prevHash = prevHash;
        this.nonce = 0;
        MessageDigest md = MessageDigest.getInstance("sha-256");
        
        //mining and hash
        while(true){
            md.update(ByteBuffer.allocate(4).putInt(this.num).array());
            md.update(ByteBuffer.allocate(4).putInt(this.amount).array());
            if(prevHash != null) md.update(prevHash.getData());
            md.update(ByteBuffer.allocate(8).putLong(this.nonce).array());
            Hash curHash = new Hash(md.digest());
            if(curHash.isValid()){
                this.hash = curHash;
                return;
            }
            this.nonce ++;
        }
    }
    
    /**
     * This is the constructor. Simply calculate the Hash.
     * 
     * @param int num, int amount, Hash prevHash.long nonce
     * @return a block object
     */
    public Block(int num, int amount, Hash prevHash, long nonce) throws NoSuchAlgorithmException {
        this.num = num;
        this.amount = amount;
        this.prevHash = prevHash;
        this.nonce = nonce;
        
        //Hashing
        MessageDigest md = MessageDigest.getInstance("sha-256");
        md.update(ByteBuffer.allocate(4).putInt(this.num).array());
        md.update(ByteBuffer.allocate(4).putInt(this.amount).array());
        if(prevHash != null) md.update(prevHash.getData());
        md.update(ByteBuffer.allocate(8).putLong(this.nonce).array());
        this.hash = new Hash(md.digest());
    }
    
    /**
     * These are the get methods.
     * 
     * @param nothing
     * @return the specified data field
     */
    public int getNum() {
        return this.num;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public long getNonce() {
        return this.nonce;
    }
    
    public Hash getPrevHash() {
        return this.prevHash;
    }
    
    public Hash getHash() {
        return this.hash;
    }
    
    /**
     * This is the toString method. Convert this block object to string representation
     * 
     * @param nothing
     * @return a string that contains each field of the block class in a certain format
     */
    public String toString() {
       String preHash = prevHash == null? "null":prevHash.toString();
       return String.format("Block %d (Amount: %d, Nonce: %d, prevHash: %s, hash: %s)", num,amount,nonce,preHash,hash.toString());
    }
    
}

