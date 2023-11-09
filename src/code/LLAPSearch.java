package code;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import code.Node;
import java.util.regex.Matcher;

public class LLAPSearch {

	private static List<Integer> extractAllInts(String initStr) {
		List<Integer> allInts = new ArrayList<>();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(initStr);
		while (matcher.find()) {
			allInts.add(Integer.parseInt(matcher.group()));
		}
		return allInts;
	}

	public static String solve(String initialState, String strategy, boolean visualization) {
		State s0 = initialization(initialState, strategy, visualization);
		System.out.println(s0);
		Node node = new Node(s0, null, null);
		node.expand();
		System.out.println(node.leaves);
		Node node2 = new Node(node.leaves.get(2).state, node, node.leaves.get(2).operator);
		node2.expand();
		System.out.println(node2.leaves);
		return null;

	}

	public static State initialization(String initialState, String strategy, boolean visualization) {

		List<Integer> allInts = extractAllInts(initialState);
		State state = new State(allInts.get(0), allInts.get(1), allInts.get(2), allInts.get(3), 0);

		State.unitPriceFood = allInts.get(4);
		State.unitPriceMaterials = allInts.get(5);
		State.unitPriceEnergy = allInts.get(6);

		State.amountRequestFood = allInts.get(7);
		State.delayRequestFood = allInts.get(8);
		State.amountRequestMaterials = allInts.get(9);
		State.delayRequestMaterials = allInts.get(10);
		State.amountRequestEnergy = allInts.get(11);
		State.delayRequestEnergy = allInts.get(12);
		State.priceBUILD1 = allInts.get(13);
		State.foodUseBUILD1 = allInts.get(14);
		State.materialsUseBUILD1 = allInts.get(15);
		State.energyUseBUILD1 = allInts.get(16);
		State.prosperityBUILD1 = allInts.get(17);
		State.priceBUILD2 = allInts.get(18);
		State.foodUseBUILD2 = allInts.get(19);
		State.materialsUseBUILD2 = allInts.get(20);
		State.energyUseBUILD2 = allInts.get(21);
		State.prosperityBUILD2 = allInts.get(22);
		System.out.println(allInts);

		// System.out.println(allInts);

		// System.out.println(state);
		return state;
	}

}
