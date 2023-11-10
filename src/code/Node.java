package code;

import java.util.ArrayList;

public class Node {
    State state;
    Node parent;
    String operator = "";
    ArrayList<Node> leaves;

    public Node(State state, Node parent, String operator) {
        this.state = state;
        this.parent = parent;
        this.operator = operator;
        this.leaves = new ArrayList<Node>();

    }

    public void expand() {
        if (state.food >= State.foodUseBUILD1 && state.materials >= State.materialsUseBUILD1
                && state.energy >= State.energyUseBUILD1 && (state.money_spent + State.priceBUILD1) <= 100000) {
            leaves.add(new Node(state.build1(), this, "BUILD1"));
        }
        if (state.food >= State.foodUseBUILD2 && state.materials >= State.materialsUseBUILD2
                && state.energy >= State.energyUseBUILD2 && (state.money_spent + State.priceBUILD2) <= 100000) {
            leaves.add(new Node(state.build2(), this, "BUILD2"));
        }

        if (state.foodDelay > 0) {
            state.foodDelay--;
            if (state.foodDelay == 0) {
                state.food = Math.min(state.food + State.amountRequestFood, State.maxResource);
            }

        }

        if (state.materialsDelay > 0) {
            state.materialsDelay--;
            if (state.materialsDelay == 0) {
                state.materials = Math.min(state.materials + State.amountRequestMaterials, State.maxResource);
            }

        }
        if (state.energyDelay > 0) {
            state.energyDelay--;
            if (state.energyDelay == 0) {
                state.energy = Math.min(state.energy + State.amountRequestEnergy, State.maxResource);
            }

        }
        if (state.food >= 1 && state.materials >= 1
                && state.energy >= 1 && (state.money_spent + State.unitPriceFood + State.unitPriceMaterials
                        + State.unitPriceEnergy) <= 100000) {

            if (state.foodDelay > 0 || state.materialsDelay > 0 || state.energyDelay > 0) {
                leaves.add(new Node(state.waitAction(), this, "WAIT"));
            }
            if (state.foodDelay == 0 && state.energyDelay == 0 && state.materialsDelay == 0) {

                if (state.food < 50)
                    leaves.add(
                            new Node(state.requestFood(State.amountRequestFood, State.delayRequestFood), this,
                                    "RequestFood"));
                if (state.energy < 50)
                    leaves.add(
                            new Node(state.requestEnergy(State.amountRequestEnergy, State.delayRequestEnergy), this,
                                    "RequestEnergy"));
                if (state.materials < 50)
                    leaves.add(
                            new Node(state.requestMaterials(State.amountRequestMaterials, State.delayRequestMaterials),
                                    this,
                                    "RequestMaterials"));
            }
        }
        if (state.money_spent >= 100000)
            leaves.clear();

    }

    @Override
    public String toString() {
        return "Node{" +
                "state=" + state +
                ",operator=" + operator +
                '}' + "\n";

    }

    public String solution() {
        String solution = "";
        Node node = this;
        int count = 1;
        int monetaryCost = node.state.money_spent;
        while (node.parent != null) {
            solution = node.operator + "," + solution;
            node = node.parent;
            count++;
        }
        solution = solution.substring(0, solution.length() - 1);
        solution = solution + ";" + monetaryCost + ";" + count;
        return solution;
    }
}
