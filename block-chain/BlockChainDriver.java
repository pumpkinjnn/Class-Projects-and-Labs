import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
* The BlockChainDriver is a class that has all the wrapped method for the program
*
* @author  [chavezgi][jinannan]
* @since   2017-09-25 
*/
public class BlockChainDriver {

    /**
     * This is readComand method.
     * 
     * @param nothing
     * @return command, a String that contains the command
     */
    public static String readCommand(){
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        return command;
    }
    
    /**
     * This is the PrintHelp method, print all the possible command
     * 
     * @param nothing
     * @return nothing
     */
    public static void printHelp() {
        System.out.println("Valid commands:");
        System.out.println("   mine: discovers the nonce for a given transaction");
        System.out.println("   append: appends a new block onto the end of the chain");
        System.out.println("   remove: removes the last block from the end of the chain");
        System.out.println("   check: checks that the block chain is valid");
        System.out.println("   report: reports the balances of Alice and Bob");
        System.out.println("   help: prints this list of commands");
        System.out.println("   quit: quits the program");
        System.out.println();
    }
    
    /**
     * This is mineBlk method.
     * 
     * @param BlockChain blk
     * @return nothing 
     */
    public static void mineBlk(BlockChain blk) throws NoSuchAlgorithmException {
        //prompt
        System.out.print("Amount transferred?");
        
        int amount = Integer.parseInt(readCommand());
        Block newblk = blk.mine(amount);
        String out = String.format("amount = %d, nonce = %d", newblk.getAmount(), newblk.getNonce());
        System.out.println(out+"\n");
    }
    
    /**
    * This is appendBlk method.
    * 
    * @param BlockChain blk
    * @return nothing 
    */
    public static void appendBlk(BlockChain blk) throws NoSuchAlgorithmException{
        System.out.print("Amount transferred?");
        int amount = Integer.parseInt(readCommand());
        
        System.out.print("Nonce?");
        long nonce = Long.parseLong(readCommand());
        
        blk.append(new Block(blk.getSize(),amount,blk.getHash(),nonce));
        System.out.println();
    }
    
    /**
    * This is removeBlk method.
    * 
    * @param BlockChain blk
    * @return nothing 
    */
    public static void removeBlk(BlockChain blk){
        if(!blk.removeLast()){
           System.out.println("Warning:Only one block, cannot remove!"+"\n"); 
        }
    }
    
    /**
    * This is checkBlk method.
    * 
    * @param BlockChain blk
    * @return nothing 
    */
    public static void checkBlk(BlockChain blk) throws NoSuchAlgorithmException{
        if(blk.isValidBlockChain()){
            System.out.println("Chain is valid!"+"\n");
        }else{
            System.out.println("Chain is invalid!"+"\n");
        }
    }
    
    /**
    * This is reportBlk method.
    * 
    * @param BlockChain blk
    * @return nothing 
    */
    public static void reportBlk(BlockChain blk){
        blk.printBalances();
    }
    
    
    public static void main(String[] args) throws NumberFormatException, NoSuchAlgorithmException {
        int initial = Integer.parseInt(args[0]);
    	BlockChain blc = new BlockChain(initial);
    	System.out.print(blc.toString());
        while(true){
            //Ask for command
            System.out.print("Command?");
            
            //Read command
            String command = readCommand();
            
            if(command.equals("mine")){
                mineBlk(blc);
            }else if(command.equals("append")){
                appendBlk(blc);
            }else if(command.equals("remove")){
                removeBlk(blc);
            }else if(command.equals("check")){
                checkBlk(blc);
            }else if(command.equals("report")){
                reportBlk(blc);
            }else if(command.equals("help")){
                printHelp();
            }else if(command.equals("quit")){
                break;
            }else{
                System.out.println("Invalid command, please reenter!");
            } 
            //print blocks info
            System.out.print("\n"+blc.toString());
        }
    }
}
