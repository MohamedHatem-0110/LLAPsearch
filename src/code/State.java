package code;

public class State {
    int prosperity, materials, food, energy, money_spent;
    static int foodDelay, materialsDelay, energyDelay, mon;
    static int unitPriceFood, unitPriceMaterials, unitPriceEnergy,
            amountRequestFood, delayRequestFood,
            amountRequestMaterials, delayRequestMaterials,
            amountRequestEnergy, delayRequestEnergy,
            priceBUILD1, foodUseBUILD1,
            materialsUseBUILD1, energyUseBUILD1, prosperityBUILD1,
            priceBUILD2, foodUseBUILD2,
            materialsUseBUILD2, energyUseBUILD2, prosperityBUILD2;

    public State(int prosperity, int materials, int food, int energy, int money_spent) {
        this.energy = energy;
        this.prosperity = prosperity;
        this.food = food;
        this.money_spent = money_spent;
        this.materials = materials;
    }

    // RequestFood, RequestMaterials, RequestEnergy: These actions request a
    // delivery of a resource to the town. A delivery increases the level of the
    // resource by
    // a certain amount. However, a deliveries are not immediate, so the increase in
    // the
    // amount of a resource is not necessarily effective in the next step. Hence,
    // each of
    // the three actions is parameterized by two parameters, amount and delay, that
    // will
    // be provided in the problem initialization. During the delay period following
    // the
    // request of a delivery, no other delivery can be requested (for the same or a
    // different
    // resource). Thus, the agent can only wait or build during that time. Delivery
    // actions
    // have no effect on prosperity level
    public State requestFood(int amount, int delay) {
        foodDelay = delayRequestFood;
        return new State(prosperity, materials - 1, food - 1, energy - 1,
                money_spent + unitPriceFood + unitPriceMaterials + unitPriceEnergy);
    }

    public State requestMaterials(int amount, int delay) {
        materialsDelay = delayRequestMaterials;
        return new State(prosperity, materials - 1, food - 1, energy - 1,
                money_spent + unitPriceFood + unitPriceMaterials + unitPriceEnergy);
    }

    public State requestEnergy(int amount, int delay) {
        energyDelay = delayRequestEnergy;
        return new State(prosperity, materials - 1, food - 1, energy,
                money_spent + unitPriceFood + unitPriceMaterials + unitPriceEnergy);
    }

    // build1: This action builds a new building of type 1. Building a new buildiing
    // code
    // requires a certain amount of materials, food, and energy, and increases the
    // prosperity level by a certain amount. The amount of materials, food, and
    // energy
    // required, as well as the increase in prosperity level, are provided in the
    public State build1() {
        System.out.println(money_spent);
        System.out.println(money_spent + priceBUILD1 + foodUseBUILD1 * unitPriceFood
                + materialsUseBUILD1 * unitPriceMaterials + energyUseBUILD1 * unitPriceEnergy);
        return new State(prosperity + prosperityBUILD1, materials - materialsUseBUILD1, food - foodUseBUILD1,
                energy - energyUseBUILD1, money_spent + priceBUILD1 + foodUseBUILD1 * unitPriceFood
                        + materialsUseBUILD1 * unitPriceMaterials + energyUseBUILD1 * unitPriceEnergy);
    }

    public State build2() {
        return new State(prosperity + prosperityBUILD2, materials - materialsUseBUILD2, food - foodUseBUILD2,
                energy - energyUseBUILD2, money_spent + priceBUILD2 + foodUseBUILD2 * unitPriceFood
                        + materialsUseBUILD2 * unitPriceMaterials + energyUseBUILD2 * unitPriceEnergy);
    }

    @Override
    public String toString() {

        return "State{" +
                "prosperity=" + prosperity +
                ", materials=" + materials +
                ", food=" + food +
                ", energy=" + energy +
                ", money_spent=" + money_spent +
                '}';
    }

}
