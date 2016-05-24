/**
 * File Name: RecommendDiscount.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 6:56:48 AM Apr 20, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 6:56:48 AM Apr 20, 2016
 */

public class RecommendDiscount {
	/**
	 * @author Yaolin Zhang
	 * @param discounts - A list of discounts that users entitled at the time of transaction
	 * @param itemPrice - The total price of items in cart
	 * @param shippingFee - The shipping fee based on shipping method that users selected
	 * @return The best Discount that users can get
	 */
	public Discount recommend(List<Discount> discounts, double itemPrice, double shippingFee){
		Discount discount = null;
		double max = 0.0;
		for(Discount dis : discounts){
			double cur = dis.getDiscount(itemPrice, shippingFee);
			max = max > cur ? max : cur;
		}
		return discount;
	}
}
