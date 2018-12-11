import java.util.HashMap;
import java.util.Map;

class Test {

	public static void main(String[] args) {
		System.out.println("Hello world");
		Map<Character, Integer> map = new HashMap<>();
		map.put('c', 1);
		map.put('c', 2);
		System.out.println(map.toString());
		System.out.println(map.get('c'));
		System.out.println(map.get('c'));
	}

}
