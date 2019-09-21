package com.miscellaneous;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Set;

public class Friend {
	private Collection<Friend> friends;
	private String email;

	public Friend(String email) {
		this.email = email;
		this.friends = new ArrayList<Friend>();
	}

	public String getEmail() {
		return email;
	}

	public Collection<Friend> getFriends() {
		return friends;
	}

	public void addFriendship(Friend friend) {
		friends.add(friend);
		friend.getFriends().add(this);
	}

	public boolean canBeConnected(Friend friend) {
		Queue<Friend> friendsQueue = new LinkedBlockingQueue<>();
		Set<String> visitedFriends = new LinkedHashSet<>();
		boolean isConnected = false;

		friendsQueue.add(this);
		visitedFriends.add(this.getEmail());

		while(!friendsQueue.isEmpty()) {
			Friend myFriend = friendsQueue.poll();

			if(myFriend.getEmail().equalsIgnoreCase(friend.getEmail())) {
				isConnected = true ;
				break;
			}else 
				for(Friend fr:myFriend.friends) 
					if(visitedFriends.add(fr.getEmail())) 
						friendsQueue.add(fr);
		}

		return isConnected;
	}

	public static void main(String[] args) {
		Friend a = new Friend("A");
		Friend b = new Friend("B");
		Friend c = new Friend("C");
		Friend d = new Friend("D");

		a.addFriendship(b);
		b.addFriendship(d);
		d.addFriendship(c);

		System.out.println(a.canBeConnected(c));
	}

}
