package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnackStock {
	private Map<String, Integer> snackStockHash = new HashMap<String, Integer>();
	
	public Map<String, Integer> snackStock(List<String> input, int stock) {
		for (int i = 0; i < input.size(); i++)
		snackStockHash.put(input.get(i).toString(), stock);
		return snackStockHash;
	}
	
	public Integer subtractSnack(String input) {
		return snackStockHash.put(input, snackStockHash.get(input)-1);
	}
	
	public Integer getSnackLeft(String input) {
		return snackStockHash.get(input);
	}
	
	public Map<String, Integer> getSnackStockHash() {
		return snackStockHash;
	}
}
