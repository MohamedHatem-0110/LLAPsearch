package code;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LLAPSearch extends GenericSearch {

	private static List<Integer> extractAllInts(String initStr) {
		List<Integer> allInts = new ArrayList<>();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(initStr);
		while (matcher.find()) {
			allInts.add(Integer.parseInt(matcher.group()));
		}
		return allInts;
	}

	public static void qingFunction(String strategy, ArrayList<Node> leaves) {
		if (strategy.equals("BF")) {
			queue.addAll(leaves);
		} else if (strategy == "DF") {
			queue.addAll(0, leaves);
		} else if (strategy == "ID") {
			queue.addAll(0, leaves);
		} else if (strategy == "UC") {
			if (queue.isEmpty()) {
				queue.add(leaves.get(0));
				leaves.remove(0);
			}
			for (int i = 0; i < leaves.size(); i++) {
				for (int j = 0; j < queue.size(); j++) {
					if (leaves.get(i).state.money_spent < queue.get(j).state.money_spent) {
						queue.add(j, leaves.get(i));
						break;
					}
				}
			}
		} else if (strategy == "GR1") {
			queue.addAll(leaves);
		} else if (strategy == "GR2") {
			queue.addAll(leaves);
		} else if (strategy == "AS1") {
			queue.addAll(leaves);
		} else if (strategy == "AS2") {
			queue.addAll(leaves);
		} else {
			System.out.println("Invalid strategy");
		}
	}

	public static String solve(String initialState, String strategy, boolean visualization) {
		State s0 = initialization(initialState, strategy, visualization);
		Node node = new Node(s0, null, null);
		// queue = new ArrayList<Node>();
		// queue.add(node);
		// while (!queue.isEmpty()) {
		// Node n = queue.remove(0);
		// if (n.state.goal()) {
		// return n.solution();
		// }
		// n.expand();
		// qingFunction(strategy, n.leaves);
		// }

		// return "The output actions do not lead to a goal state.";

		node.expand();
		System.out.println(node.leaves);

		Node node2 = node.leaves.get(0);
		System.out.println(node2.state.foodDelay + "xxxx");
		node2.expand();

		System.out.println(node2.leaves);
		Node node3 = node2.leaves.get(0);
		node3.expand();

		System.out.println(node3.leaves);
		Node node4 = node3.leaves.get(0);
		node4.expand();
		System.out.println(node4.leaves);
		System.out.println("Node 1 " + node);
		System.out.println("Node 2 " + node2);
		System.out.println("Node 3 " + node3);
		System.out.println("Node 4 " + node4);
		System.out.println(node4.solution());
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
