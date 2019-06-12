package list;


import java.util.LinkedList;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		List1();
		
	}
	public static void List1() {
		List<String> list = new LinkedList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		System.out.println(list);
		
		//获取list集合的下标
		String str = list.get(1);
		System.out.println(str);
		
		for (int i = 0; i < list.size() ;i++) {
			System.out.println(list.get(i));
		}
		String str1 = list.set(2, "two");
		System.out.println(list);
		System.out.println(str1);
		for (int i = 0; i < list.size()/2; i++) {
			list.set(i, list.set(list.size()-1-i, list.get(i)));
		System.out.println(list);
		}
		System.out.println(list);
		
		list.add(1,"2TWO");
		System.out.println(list);
		
		list.remove(2);
		System.out.println(list);
		
		
	}

}
