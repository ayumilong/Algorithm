/**
 * File Name: TinyUrl.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:25:29 PM Apr 21, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:25:29 PM Apr 21, 2016
 */
public class TinyUrl {
	public static void main(String args[]){
		TinyUrl tu = new TinyUrl();
		
		
		
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String s = scan.nextLine();
			int left = s.indexOf('\"');
			int right = s.indexOf('\"', left + 1);
			String long_url = s.substring(left + 1, right + 1);
			String short_key = "";
			int secondLeft = s.indexOf('\"', right + 1);
			int secondRight = 0;
			if(secondLeft != -1){
				secondRight = s.indexOf('\"', secondLeft + 1);
				short_key = s.substring(secondLeft + 1, secondRight);
			}
			
			String type = s.substring(0, left - 1);
			if(type.equals("createCustom")){
				System.out.println(tu.createCustom(long_url, short_key));
			}else if(type.equals("shortToLong")){
				System.out.println(tu.shortToLong(long_url));
			}else{
				System.out.println(tu.longToShort(long_url));
			}
			System.out.println(short_key);
		}
		
		scan.close();
	}
    private final String tinyUrl = "http://tiny.url/";
    private static long URL_ID = 0;
    private final int TINY_LENGTH = 6;
    private final String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private HashMap<Long, String> id2url = new HashMap<>();
    private HashMap<String, Long> url2id = new HashMap<>();
    
    private HashMap<String, String> short2long = new HashMap<>();
    private HashMap<String, String> long2short = new HashMap<>();
    
    private HashSet<Long> usedId = new HashSet<>();
    
    /**
     * @param long_url a long url
     * @param a short key
     * @return a short url starts with http://tiny.url/
     */
    String createCustom(String long_url, String short_key) {
        // Write your code here
        if(isNormalKey(short_key)){
            long id = getId(short_key);
            if(id2url.containsKey(id) && !long_url.equals(id2url.get(id))){
                return "error";
            }
            if(url2id.containsKey(long_url) && url2id.get(long_url) != id){
                return "error";
            }
            if(id2url.containsKey(id) || url2id.containsKey(long_url)){
                return tinyUrl + short_key;
            }
            usedId.add(id);
            id2url.put(id, long_url);
            url2id.put(long_url, id);
            return tinyUrl + short_key;
        }
        if(url2id.containsKey(long_url)){
            return "error";
        }
        if(short2long.containsKey(short_key) && !long_url.equals(short2long.get(short_key))){
            return "error";
        }
        if(long2short.containsKey(long_url) && !short_key.equals(long2short.get(long_url))){
            return "error";
        }
        short2long.put(short_key, long_url);
        long2short.put(long_url, short_key);
        return tinyUrl + short_key;
    }
    
    private boolean isNormalKey(String short_key){
        int len = short_key.length();
        if(len != TINY_LENGTH){
            return false;
        }
        for(int i = 0; i < TINY_LENGTH; ++i){
            if(!chars.contains(short_key.charAt(i) + "")){
                return false;
            }
        }
        return true;
    }
    
    private long toBase62(char c){
        if(c >= '0' && c <='9'){
            return c - '0';
        }
        if(c >= 'a' && c <= 'z'){
            return c - 'a' + 10;
        }
        return c - 'A' + 36;
    }
    
    private long getId(String short_url){
        long result = 0;
        for(int i  = 0; i < short_url.length(); ++i){
            result = result * 62 + toBase62(short_url.charAt(i));
        }
        return result;
    }
    
    private String getShortUrl(long id){
        String short_url = "";
        while(id > 0){
            short_url = chars.charAt((int)(id % 62)) + short_url;
            id /= 62;
        }
        while(short_url.length() < TINY_LENGTH){
            short_url = '0' + short_url;
        }
        return short_url;
    }

    /**
     * @param long_url a long url
     * @return a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        // Write your code here
        if(long2short.containsKey(long_url)){
            return tinyUrl + long2short.get(long_url);
        }
        if(url2id.containsKey(long_url)){
            return tinyUrl + getShortUrl(url2id.get(long_url));
        }
        ++URL_ID;
        while(usedId.contains(URL_ID)){
            ++URL_ID;
        }
        String short_key = getShortUrl(URL_ID);
        id2url.put(URL_ID, long_url);
        url2id.put(long_url, URL_ID);
        return tinyUrl + short_key;
    }

    /**
     * @param short_url a short url starts with http://tiny.url/
     * @return a long url
     */
    public String shortToLong(String short_url) {
        // Write your code here
        String short_key = short_url.substring(tinyUrl.length());
        if(short2long.containsKey(short_key)){
            return short2long.get(short_key);
        }
        long id = getId(short_key);
        return id2url.get(id);
    }
}
