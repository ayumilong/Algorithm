/**
 * File Name: IPAddressValidation.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:54:41 PM Apr 3, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;
import java.util.regex.*;

/**
 * @author Yaolin Zhang
 * @time 9:54:41 PM Apr 3, 2016
 */
public class IPAddressValidation {
    public static final String IPV4_REGEX = "(25[0-5]|2[0-4]\\d|[0-1]\\d\\d|[0-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]\\d\\d|[0-9]?\\d)){3}";
    public static final String IPV6_REGEX = "\\A(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}\\z";
    
    public static String check(String ip){
        if(Pattern.compile(IPV4_REGEX, Pattern.CASE_INSENSITIVE | Pattern.DOTALL).matcher(ip).matches())
            return "IPv4";
        else if(Pattern.compile(IPV6_REGEX,Pattern.CASE_INSENSITIVE | Pattern.DOTALL).matcher(ip).matches())
            return "IPv6";
        else
            return "Neither";
        
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
		while (N > 0) {
			--N;
            String str = sc.nextLine();
            System.out.println(check(str));
        }
        sc.close();
    }
	
    static String[] check_IP(String[] s) {
        String[] results = new String[s.length];
        for(int i = 0; i < s.length; ++i){
            if(isValidIpv4(s[i])){
                results[i] = "IPv4";
            }else if(isValidIpv6(s[i])){
                results[i] = "IPv6";
            }else{
                results[i] = "Neither";
            }
        }
        return results;
    }

    static boolean isValidIpv4(String addr){
        String ipv4Regex = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3}).(\\d{1,3})$";
        Pattern p = Pattern.compile(ipv4Regex);
        Matcher m = p.matcher(addr);
        if(!m.find()){
            return false;
        }
        String[] groups = addr.split("\\.");
        for(int i = 0; i <= 3; ++i){
            String cur = groups[i];
            if(cur == null || cur.length() == 0){
                return false;
            }
            int num = 0;
            try{
                num = Integer.parseInt(cur);
            }catch(NumberFormatException e){
                return false;
            }
            if(num > 255){
                return false;
            }
            if(cur.length() > 1 && cur.startsWith("0")){
                return false;
            }
        }
        return true;
    }
    
    static boolean isValidIpv6(String addr){
        boolean hasCompressedZeroes = addr.contains("::");
        if(hasCompressedZeroes && (addr.indexOf("::") != addr.lastIndexOf("::"))){
            return false;
        }
        if((addr.startsWith(":") && !addr.startsWith("::")) || (addr.endsWith(":") && !addr.endsWith("::"))){
            return false;
        }
        String[] groups = addr.split(":");
        if(hasCompressedZeroes){
            List<String> curList = new ArrayList<String>(Arrays.asList(groups));
            if(addr.endsWith("::")){
                curList.add("");
            }else if(addr.startsWith("::") && !curList.isEmpty()){
                curList.remove(0);
            }
            groups = curList.toArray(new String[curList.size()]);
        }
        if(groups.length > 8){
            return false;
        }
        int validGroups = 0;
        int emptyGroups = 0;
        for(int i = 0; i < groups.length; ++i){
            String cur = groups[i];
            if(cur.length() == 0){
                ++emptyGroups;
                if(emptyGroups > 1){
                    return false;
                }
            }else{
                emptyGroups = 0;
                if(cur.contains(".")){
                    if(!addr.endsWith(cur)){
                        return false;
                    }
                    if(i > groups.length - 1 || i > 6){
                        return false;
                    }
                    if(!isValidIpv4(cur)){
                        return false;
                    }
                    validGroups += 2;
                    continue;
                }
                if(cur.length() > 4){
                    return false;
                }
                int num = 0;
                try{
                    num = Integer.valueOf(cur, 16).intValue();
                }catch(NumberFormatException e){
                    return false;
                }
                if(num < 0 || num > 0xffff){
                    return false;
                }
            }
            ++validGroups;
        }
        if(validGroups < 8 && !hasCompressedZeroes){
            return false;
        }
        return true;
    }
}


