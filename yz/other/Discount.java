/**
 * File Name: Discount.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:09:44 AM Apr 20, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

/**
 * @author Yaolin Zhang
 * @time 7:09:44 AM Apr 20, 2016
 */
public class Discount {
	private DiscountType type;
	private double minPrice; //The minimum price that entitle the discount
	private double decrease; //Used by DECREASEAMOUNT DiscountType
	
	/**
	 * @author Yaolin Zhang
	 * @param itemPrice - The total prices of items in cart
	 * @param shippingFee - The shipping fee
	 * @return The discount of money that users can get
	 */
	public double getDiscount(double itemPrice, double shippingFee){
		if(itemPrice < minPrice){
			return 0.0;
		}
		double amount = 0.0;
		switch(type){
			case NOSHIPPINGFEE:
				amount = shippingFee;
				break;
			case DECREASEAMOUNT:
				amount = decrease;
				break;
			default:
				break;
		}
		return amount;
	}
}
