package com.miscellaneous.oracle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ShoppingMart {
	private Map<String, List<String>> relation;

	public ShoppingMart() {
		this.relation = new HashMap<String, List<String>>();
	}
	
	/**
	 * @Description
	 * To add one parent child relation
	 * @param parent - Parent Node name
	 * @param child - child Name
	 */
	public void addRelation(String parent, String child) {
		if(this.relation.get(parent) == null) {
			List<String> children = new LinkedList<String>();
			children.add(child);
			this.relation.put(parent, children);
		} else {
			this.relation.get(parent).add(child);
		}
	}

	/**
	 * @Description
	 * To add one parent to many children relations 
	 * @param parent - Parent Node name
	 * @param children - list of children sent in a String Array
	 */
	public void addRelation(String parent, String[] children) {
		if(this.relation.get(parent) == null) {
			List<String> _children = new LinkedList<String>();
			this.relation.put(parent, _children);
		}
		for(String child: children) {
			this.relation.get(parent).add(child);
		}
	}

	/**
	 * @Description
	 * To return all possible children navigation f
	 * @param parentNode
	 * @return
	 */
	public List<String> findLeaves(String parentNode) {
		List<String> children = this.relation.get(parentNode);
		List<String> returnList = new LinkedList<String>();
		if(children == null) {
			returnList.add(parentNode);
		} else {
			for(String child : children) {
				List<String> subChildren = findLeaves(child);
				for(String subChild : subChildren) {
					returnList.add((parentNode != null) ? parentNode + " > " + subChild : subChild);
				}
			}
		}
		return returnList;
	}
	
	@Override
	public String toString() {
		return this.relation.toString();
	}
}


public class AllParentToLeafNavigations {
	public static void main(String[] args) {
		ShoppingMart sMart = new ShoppingMart();
		sMart.addRelation(null, new String[]{"Men", "Women", "Electronics"});
		sMart.addRelation("Men", new String[]{"Footwear", "Clothes", "Watches"});
		sMart.addRelation("Women", new String[]{"Footwear", "Clothes", "Watches"});
		sMart.addRelation("Electronics", new String[]{"Premium", "Regular"});
		sMart.addRelation("Footwear", new String[]{"Formals", "Sports", "Casuals"});
		sMart.addRelation("Clothes", new String[]{"Trousers", "Shirts"});
		sMart.addRelation("Watches", new String[]{"Mechanical", "Quartz"});
		sMart.addRelation("Formals", new String[]{"Premium", "Regular"});
		sMart.addRelation("Mechanical", new String[]{"Premium", "Regular"});
		System.out.println(sMart.toString());
		
		for(String relation : sMart.findLeaves(null)) {
			System.out.println(relation);
		}
	}
}
