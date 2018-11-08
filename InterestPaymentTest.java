package com.in.ice.service;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Test;
import com.in.ice.bean.Payment;

public class InterestPaymentTest {

	Payment curr_payment=new Payment(5,new BigDecimal(1512.25));
	InterestPayment interestPayment=new InterestPayment(curr_payment);

	@Test
	public void testUpdatePayment_True() {
		Payment payment=new Payment(6,new BigDecimal(1512.25));
		assertTrue(interestPayment.updatePayment(payment));
	}

	@Test
	public void testUpdatePayment_False() {
		Payment payment=new Payment(25,new BigDecimal(2314));
		assertFalse(interestPayment.updatePayment(payment));
	}
	
	@Test
	public void testUpdatePayment_Bug(){
		// We should have taken care of a negative day number. In this case it is returning true, but the expected is false
		Payment payment=new Payment(-1,new BigDecimal(2314));
		assertFalse(interestPayment.updatePayment(payment));
	}
}
