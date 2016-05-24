/**
 * File Name: IPForbidden.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 6:19:22 AM Apr 6, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 6:19:22 AM Apr 6, 2016
 */
public class IPForbidden {
	private static class Rule{
		boolean type;
		String address;
		int mask;
		Rule(boolean t, String addr, int m){
			type = t;
			address = addr;
			mask = m;
		}
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		scan.nextLine();
		Rule[] rules = new Rule[N];
		for(int i = 0; i < N; ++i){
			String[] cur = scan.nextLine().split(" ");
			String[] ip = cur[1].split("/");
			if(ip.length == 2){//A mask address
				int mask = Integer.parseInt(ip[1]);
				rules[i] = new Rule(cur[0].equals("allow"), ip[0], mask);
			}else{//A IP address
				rules[i] = new Rule(cur[0].equals("allow"), ip[0], -1);
			}
		}
		for(int i = 0; i < M; ++i){
			String ipAddr = scan.nextLine();
			if(isMatch(rules, ipAddr)){//allow
				System.out.println("YES");
			}else{//deny
				System.out.println("NO");
			}
		}
		
		scan.close();
	}
	
	public static boolean isMatch(Rule[] rules, String ipAddr){
		for(Rule r : rules){
			if(r.mask == -1){//A IP address rule
				if(r.address.equals(ipAddr)){
					return r.type;
				}
			}else{//A IP mask address
				String[] addr1 = r.address.split("\\.");
				String[] addr2 = ipAddr.split("\\.");
				if(addr1.length != 4){//Invalid rule
					continue;
				}
				if(addr2.length != 4){
					return false; //Invalid address, deny
				}
				
				long iAddr1 = 0;
				long iAddr2 = 0;
				int shift = 24;
				for(int i = 0; i < 4; ++i){
					iAddr1 += (Integer.parseInt(addr1[i]) << shift);
					iAddr2 += (Integer.parseInt(addr2[i]) << shift);
					shift -= 8;
				}
				boolean match = true;
				for(int i = 0; i < r.mask; ++i){
					long cur1 = iAddr1 & (1 << (31 - i));
					long cur2 = iAddr2 & (1 << (31 - i));
					if(cur1 != cur2){
						match = false;
						break;
					}
				}
				if(match){
					return r.type;
				}
			}
		}
		return true;
	}
}
