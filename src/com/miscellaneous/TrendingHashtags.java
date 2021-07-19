package com.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrendingHashtags {

	public static void main(String[] args) {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Please tweet the tweets:");
			String tweet = reader.readLine();
			Map<String,Long> tweetMap = new LinkedHashMap<String, Long>();

			TrendingHashtags tags = new TrendingHashtags();
			
			while(!"".equals(tweet)){
				
				for(String hashTag:tags.getHashTags(tweet)) {
					long tweetCount = 1;
					
					if(tweetMap.containsKey(hashTag)) 
						tweetCount = tweetMap.get(hashTag) + 1;
					
					tweetMap.put(hashTag, tweetCount);
					
				}
				
				System.out.println("Please tweet(press Enter to exit):");
				tweet = reader.readLine();
			}
			System.out.println(tweetMap);
			tweetMap = tags.sortedMapBasedOnTweetCount(tweetMap);
			tags.printTopNHashTags(tweetMap, 10);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	private HashSet<String> getHashTags(String tweet){
		HashSet<String> hashTags = new LinkedHashSet<>();
		
		Pattern hashTagPattern = Pattern.compile("(#\\S+)");
		Matcher matcher = hashTagPattern.matcher(tweet);
		
		while(matcher.find()) {
			hashTags.add(matcher.group());
		}
		
		return hashTags;
	}
	
	private Map<String,Long> sortedMapBasedOnTweetCount(Map<String,Long> tweetMap){
		Comparator<String> valueComparator = new Comparator<String>(){

			@Override
			public int compare(String k1, String k2) {
				
				int compare = tweetMap.get(k2).compareTo(tweetMap.get(k1));
				return compare == 0 ? 1 : compare;
			}
			
		};
		
		Map<String,Long> sortedTweetMap = new TreeMap<>(valueComparator);
		sortedTweetMap.putAll(tweetMap);
		
		return sortedTweetMap;
	}
	private void printTopNHashTags(Map<String,Long> tweetMap,int n) {
		System.out.println("Top "+n+" hashtags :");
		int i = 1;
		
		for(String tweet:tweetMap.keySet()){
			if(i++ > n)
				break;
			
			System.out.println(tweet);
		}
	}
}
