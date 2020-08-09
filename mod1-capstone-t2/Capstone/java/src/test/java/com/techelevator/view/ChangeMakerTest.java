package com.techelevator.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.techelevator.ChangeMaker;



public class ChangeMakerTest {
	
	@Test
	public void changeTest0 () {
		ChangeMaker cm = new ChangeMaker();
		
		BigDecimal money1 = new BigDecimal("0.65");
		cm.change(money1);
		
		List<Integer> actualChange = new ArrayList<Integer>();
		actualChange.add(cm.getQuarters());
		actualChange.add(cm.getDimes());
		actualChange.add(cm.getNickels());
		
		List<Integer> expectedChange = new ArrayList<Integer>();
		expectedChange.add(2);
		expectedChange.add(1);
		expectedChange.add(1);
		
		Assert.assertEquals(expectedChange, actualChange);
	
		//	//	//	//	//	//	//	//	//	//	//	//	//	//
	}
	
	@Test
	public void changeTest1 () {
		ChangeMaker cm = new ChangeMaker();
		
		BigDecimal money = new BigDecimal("11.35");
		cm.change(money);
		
		List<Integer> actualChange = new ArrayList<Integer>();
		actualChange.add(cm.getQuarters());
		actualChange.add(cm.getDimes());
		actualChange.add(cm.getNickels());
		
		List<Integer> expectedChange = new ArrayList<Integer>();
		expectedChange.add(45);
		expectedChange.add(1);
		expectedChange.add(0);
		
		Assert.assertEquals(expectedChange, actualChange);
	
		//	//	//	//	//	//	//	//	//	//	//	//	//	//
	}
	
	@Test
	public void changeTest2 () {
		ChangeMaker cm = new ChangeMaker();
		
		BigDecimal money = new BigDecimal("75.20");
		cm.change(money);
		
		List<Integer> actualChange = new ArrayList<Integer>();
		actualChange.add(cm.getQuarters());
		actualChange.add(cm.getDimes());
		actualChange.add(cm.getNickels());
		
		List<Integer> expectedChange = new ArrayList<Integer>();
		expectedChange.add(300);
		expectedChange.add(2);
		expectedChange.add(0);
		
		Assert.assertEquals(expectedChange, actualChange);
	
		//	//	//	//	//	//	//	//	//	//	//	//	//	//
	}
	
	@Test
	public void changeTest3 () {
		ChangeMaker cm = new ChangeMaker();
		
		BigDecimal money1 = new BigDecimal("22.65");
		cm.change(money1);
		
		List<Integer> actualChange = new ArrayList<Integer>();
		actualChange.add(cm.getQuarters());
		actualChange.add(cm.getDimes());
		actualChange.add(cm.getNickels());
		
		List<Integer> expectedChange = new ArrayList<Integer>();
		expectedChange.add(90);
		expectedChange.add(1);
		expectedChange.add(1);
		
		Assert.assertEquals(expectedChange, actualChange);
	
		//	//	//	//	//	//	//	//	//	//	//	//	//	//
	}
	
	@Test
	public void changeTest4 () {
		ChangeMaker cm = new ChangeMaker();
		
		BigDecimal money1 = new BigDecimal("0.10");
		cm.change(money1);
		
		List<Integer> actualChange = new ArrayList<Integer>();
		actualChange.add(cm.getQuarters());
		actualChange.add(cm.getDimes());
		actualChange.add(cm.getNickels());
		
		List<Integer> expectedChange = new ArrayList<Integer>();
		expectedChange.add(0);
		expectedChange.add(1);
		expectedChange.add(0);
		
		Assert.assertEquals(expectedChange, actualChange);
	
		//	//	//	//	//	//	//	//	//	//	//	//	//	//
	}
	
	@Test
	public void changeTest5 () {
		ChangeMaker cm = new ChangeMaker();
		
		BigDecimal money1 = new BigDecimal("0.05");
		cm.change(money1);
		
		List<Integer> actualChange = new ArrayList<Integer>();
		actualChange.add(cm.getQuarters());
		actualChange.add(cm.getDimes());
		actualChange.add(cm.getNickels());
		
		List<Integer> expectedChange = new ArrayList<Integer>();
		expectedChange.add(0);
		expectedChange.add(0);
		expectedChange.add(1);
		
		Assert.assertEquals(expectedChange, actualChange);
	
		//	//	//	//	//	//	//	//	//	//	//	//	//	//
	}
	
	@Test
	public void changeTest6 () {
		ChangeMaker cm = new ChangeMaker();
		
		BigDecimal money1 = new BigDecimal("0.35");
		cm.change(money1);
		
		List<Integer> actualChange = new ArrayList<Integer>();
		actualChange.add(cm.getQuarters());
		actualChange.add(cm.getDimes());
		actualChange.add(cm.getNickels());
		
		List<Integer> expectedChange = new ArrayList<Integer>();
		expectedChange.add(1);
		expectedChange.add(1);
		expectedChange.add(0);
		
		Assert.assertEquals(expectedChange, actualChange);
	
		//	//	//	//	//	//	//	//	//	//	//	//	//	//
	}
	
	@Test
	public void changeTest7 () {
		ChangeMaker cm = new ChangeMaker();
		
		BigDecimal money1 = new BigDecimal("0.85");
		cm.change(money1);
		
		List<Integer> actualChange = new ArrayList<Integer>();
		actualChange.add(cm.getQuarters());
		actualChange.add(cm.getDimes());
		actualChange.add(cm.getNickels());
		
		List<Integer> expectedChange = new ArrayList<Integer>();
		expectedChange.add(3);
		expectedChange.add(1);
		expectedChange.add(0);
		
		Assert.assertEquals(expectedChange, actualChange);
	
		//	//	//	//	//	//	//	//	//	//	//	//	//	//
	}
	
	@Test
	public void changeTest8 () {
		ChangeMaker cm = new ChangeMaker();
		
		BigDecimal money1 = new BigDecimal("0.95");
		cm.change(money1);
		
		List<Integer> actualChange = new ArrayList<Integer>();
		actualChange.add(cm.getQuarters());
		actualChange.add(cm.getDimes());
		actualChange.add(cm.getNickels());
		
		List<Integer> expectedChange = new ArrayList<Integer>();
		expectedChange.add(3);
		expectedChange.add(2);
		expectedChange.add(0);
		
		Assert.assertEquals(expectedChange, actualChange);
	
		//	//	//	//	//	//	//	//	//	//	//	//	//	//
	}
}
