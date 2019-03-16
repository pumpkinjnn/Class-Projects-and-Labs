/**
* The Hash class is a wrapper class for byte array.
*
* @author  [chavezgi][jinannan]
* @since   2017-09-25 
*/
import java.util.Arrays;

public class Hash {

    private byte[] data;

    /**
     * This is the constructor.
     * 
     * @param data, byte array.
     */
    public Hash(byte[] data) {
        this.data = data;
    }

    /**
     * This is the gatData method .
     * 
     * @param nothing
     * @return the data field
     */
    public byte[] getData() {
        return this.data;
    }

    /**
     * This is the isValid method, check if the first three positions are 0
     * 
     * @param nothing
     * @return isValid, check is the first three is 0.
     */
    public boolean isValid() {
        for (int i = 0; i < 3; i++) {
            if(data[i] != 0) return false;
        } 
        return true;
    }

    /**
     * This is the toString method, convert data to string
     * 
     * @param nothing
     * @return hexValue, a string that represts the data (byte array)
     */
    public String toString() {
        String hexValue = "";
        for (byte b : data) {
            hexValue += String.format("%02x", Byte.toUnsignedInt(b));
        }
        return hexValue;
    }
    
    /**
     * This is the equals method, check if two byte array is equal
     * 
     * @param Object(byte array) other
     * @return true if the two byte array is the same, or false otherwise
     */
    public boolean equals(Object other) {
        if (!(other instanceof Hash)) return false;
        Hash o = (Hash) other;
        return Arrays.equals(data, o.data);
    }
 
}
