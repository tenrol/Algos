import java.util.Arrays;
import java.lang.Math;

public class IceCreamParlor {

	public static int indexOf(int[] menu, int value, int exludeThis) {
		for (int i = 0; i < menu.length; i++) {
			if (menu[i] == value && i != exludeThis) {
				return  i;
			}
		}
		return -1;
	}

	public static int[] getIndicesFromValues(int[] menu, int value1, int value2) {
		int index1 = indexOf(menu, value1, -1);
		int index2 = indexOf(menu, value2, index1);
		int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
		return indices;
	}

	public static int[] findChoices(int[] menu, int money) {
		int[] sortedMenu = menu.clone();
		Arrays.sort(sortedMenu);
		for (int i = 0; i < sortedMenu.length; i++) {
			int complement = money - sortedMenu[i];
			int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);
			if (location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
				int[] indices = getIndicesFromValues(menu, sortedMenu[i], complement);
				return indices;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] iceCreams = new int[] {1, 3, 4, 5, 6, 7, 8, 9, 7};
		System.out.println(Arrays.toString(findChoices(iceCreams, 6)));
	}
}