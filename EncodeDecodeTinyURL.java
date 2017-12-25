package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/* #535. Encode and Decode TinyURL
 * href: https://leetcode.com/problems/encode-and-decode-tinyurl/description/ */
public class EncodeDecodeTinyURL {
    
    HashMap<String, String> map = new HashMap();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String result = "http://tinyurl.com/" + Integer.toHexString( longUrl.hashCode() );
        map.put(result, longUrl);
        System.out.println(result);
        return result;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl){
        return map.get(shortUrl);
    }

    
    @Test
    public void test(){
        test("https://leetcode.com/problems/design-tinyurl");
    }
    
    public void test(String str){
        assertEquals(str, decode( encode(str) ));
    }
}
