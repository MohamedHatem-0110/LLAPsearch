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
        if (State.foodDelay > 0) {
            State.foodDelay--;
            System.out.println(State.foodDelay);
            if (State.foodDelay == 0) {
                state.food += State.amountRequestFood;
            }
        }

        if (State.materialsDelay > 0) {
            State.materialsDelay--;
            if (State.materialsDelay == 0) {
                state.materials += State.amountRequestMaterials;
            }
        }
        if (State.energyDelay > 0) {
            State.energyDelay--;
            if (State.energyDelay == 0) {
                state.energy += State.amountRequestEnergy;
            }
        }
        if (state.food >= State.foodUseBUILD1 && state.materials >= State.materialsUseBUILD1
                && state.energy >= State.energyUseBUILD1) {
            leaves.add(new Node(state.build1(), this, "build1"));
        }
        if (state.food >= State.foodUseBUILD2 && state.materials >= State.materialsUseBUILD2
                && state.energy >= State.energyUseBUILD2) {
            leaves.add(new Node(state.build2(), this, "build2"));
        }
        if (state.food > 1 && state.materials > 1
                && state.energy > 1) {
            if (State.delayRequestFood > 0)
                leaves.add(
                        new Node(state.requestFood(State.amountRequestFood, State.delayRequestFood), this,
                                "requestFood"));
            if (State.delayRequestEnergy > 0)
                leaves.add(
                        new Node(state.requestFood(State.amountRequestEnergy, State.delayRequestEnergy), this,
                                "requestEnergy"));

            if (State.delayRequestMaterials > 0)
                leaves.add(
                        new Node(state.requestFood(State.amountRequestMaterials, State.delayRequestMaterials), this,
                                "requestMaterials"));
        }

    }

    @Override
    public String toString() {
        return "Node{" +
                "state=" + state +
                ",operator=" + operator +
                ", leaves=" + leaves
                + '}' + "\n";

    }
}
