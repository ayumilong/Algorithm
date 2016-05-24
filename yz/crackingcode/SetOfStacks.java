/**
 * File Name: SetOfStacks.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:14:03 PM Oct 5, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

import java.util.LinkedList;

/**
 * @author Yaolin Zhang
 * @time 10:14:03 PM Oct 5, 2015
 */
public class SetOfStacks {
	private LinkedList<MyStack> stacks;
	private int threshold;
	private int curStack;

	public SetOfStacks(int threshold) {
		stacks = new LinkedList<>();
		this.threshold = threshold;
		this.curStack = 0;
		
		stacks.add(new MyStack(threshold));
	}
	
	public int getCurStack(){
		return this.curStack + 1;
	}

	public int getThreshold(){
		return this.threshold;
	}
	
	public Integer popAt(int index){
		if(index < 0 || index > curStack){
			return null;
		}
		Integer result = stacks.get(index).pop();
		if(index != curStack && stacks.get(index).isEmpty()){
			stacks.remove(index);
			--curStack;
		}
		return result;
	}
	
	public Integer pop() {
		Integer result = stacks.get(curStack).pop();
		if (result == null) {
			if (curStack != 0) {
				stacks.remove(curStack);
				--curStack;
				return stacks.get(curStack).pop();
			}else{
				return null;
			}
		}
		return result;
	}

	public boolean push(int val) {
		if (!stacks.get(curStack).push(val)) {
			stacks.add(new MyStack(threshold));
			++curStack;
			stacks.get(curStack).push(val);
		}
		return true;
	}
	
	public Integer peek(){
		Integer result = stacks.get(curStack).peek();
		if(result == null){
			if(curStack == 0){
				return null;
			}
			return stacks.get(curStack - 1).peek();
		}
		return result;
	}
}
