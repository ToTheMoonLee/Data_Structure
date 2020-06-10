package practice.leetcode.easy;

/**
 * efanged IP address replaces every period "." with "[.]".
 *
 *
 *
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 */
public class $1108DefangingAnIPAddress {

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }

    /**
     * my solution of this problem
     * @param address
     * @return
     */
    static String defangIPaddr(String address) {
        address = address.replace(".","[.]");
        return address;
    }
}
