package list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1;i<=10;i++) {
			list.add(i);
		}
		System.out.println(list);
		List<Integer> list1 = list.subList(1,8);
		System.out.println(list1);
		for (int i = 0; i < list1.size(); i++) {
			list1.subList(i, list1.get(i)*10);
			
		}
		System.out.println(list1);
	}

}
