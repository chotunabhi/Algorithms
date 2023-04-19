package com.org.optum;

import java.util.Arrays;
import java.util.HashMap;

public class TravellingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] a = {7,3,7,3,1,3,4,1};
		Integer[] a = {5,2,1,1,3,2,1,1,3,9};
//		Integer[] a = {7,5,2,7,2,7,4,7};
		System.out.println(minimumVacationDays(a));
	}
	
	public static int minimumVacationDays(Integer[] a) {
		long distinctCities = Arrays.asList(a)
								.stream()
								.distinct()
								.count();
		
		HashMap<Integer, Integer> hMap = new HashMap<>();
		int left = 0, right = a.length - 1,j = -1,i = 0;
		
		while(i < a.length ) {
			while(j < a.length) {
				j++;
				
				if(j < a.length && hMap.size() < distinctCities)
					hMap.put(a[j], hMap.getOrDefault(a[j], 0) + 1);
				
				if(hMap.size() == distinctCities && right - left > j - i) {
					left = i;
					right = j;
					break;
				}
			}
			
			while(hMap.size() == distinctCities) {
				if(hMap.getOrDefault(a[i], 0) == 1)
					hMap.remove(a[i]);
				else
					hMap.put(a[i], hMap.getOrDefault(a[i], 0) - 1);
				
				i++;
				
				if(hMap.size() == distinctCities && right - left > j - i) {
					left = i;
					right = j;
				}
			}
			
			if(hMap.getOrDefault(a[i], 0) == 1)
				hMap.remove(a[i]);
			else
				hMap.put(a[i], hMap.getOrDefault(a[i], 0) - 1);
			
			i++;
		}
		
		return right - left + 1;
	}

}
