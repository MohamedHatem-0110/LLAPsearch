package code;

public class State {
        int prosperity, materials, food, energy, money_spent;
        int foodDelay, materialsDelay, energyDelay;
        static int unitPriceFood, unitPriceMaterials, unitPriceEnergy,
                        amountRequestFood, delayRequestFood,
                        amountRequestMaterials, delayRequestMaterials,
                        amountRequestEnergy, delayRequestEnergy,
                        priceBUILD1, foodUseBUILD1,
                        materialsUseBUILD1, energyUseBUILD1, prosperityBUILD1,
                        priceBUILD2, foodUseBUILD2,
                        materialsUseBUILD2, energyUseBUILD2, prosperityBUILD2;
        static int budget = 100000;
        static int maxResource = 50;

        public State(int prosperity, int materials, int food, int energy, int money_spent) {
                this.energy = energy;
                this.prosperity = prosperity;
                this.food = food;
                this.money_spent = money_spent;
                this.materials = materials;
                this.foodDelay = 0;
                this.materialsDelay = 0;
                this.energyDelay = 0;
        }

        public boolean goal() {
                return prosperity >= 100;
        }

        public State requestFood(int amount, int delay) {

                State newState = new State(prosperity, materials - 1, food - 1, energy - 1,
                                money_spent + unitPriceFood + unitPriceMaterials + unitPriceEnergy);
                newState.foodDelay = delayRequestFood + 1;
                return newState;
        }

        public State requestMaterials(int amount, int delay) {

                State newState = new State(prosperity, materials - 1, food - 1, energy - 1,
                                money_spent + unitPriceFood + unitPriceMaterials + unitPriceEnergy);
                newState.materialsDelay = delayRequestMaterials + 1;
                return newState;
        }

        public State requestEnergy(int amount, int delay) {
                energyDelay = delayRequestEnergy;
                State newState = new State(prosperity, materials - 1, food - 1, energy - 1,
                                money_spent + unitPriceFood + unitPriceMaterials + unitPriceEnergy);
                newState.energyDelay = delayRequestEnergy + 1;
                return newState;
        }

        // build1: This action builds a new building of type 1. Building a new buildiing
        // code
        // requires a certain amount of materials, food, and energy, and increases the
        // prosperity level by a certain amount. The amount of materials, food, and
        // energy
        // required, as well as the increase in prosperity level, are provided in the
        public State build1() {
                State newState = new State(prosperity + prosperityBUILD1, materials - materialsUseBUILD1,
                                food - foodUseBUILD1,
                                energy - energyUseBUILD1, money_spent + priceBUILD1 + foodUseBUILD1 * unitPriceFood
                                                + materialsUseBUILD1 * unitPriceMaterials
                                                + energyUseBUILD1 * unitPriceEnergy);
                newState.energyDelay = energyDelay;
                newState.foodDelay = foodDelay;
                newState.materialsDelay = materialsDelay;
                return newState;
        }

        public State build2() {
                State newState = new State(prosperity + prosperityBUILD2, materials - materialsUseBUILD2,
                                food - foodUseBUILD2,
                                energy - energyUseBUILD2, money_spent + priceBUILD2 + foodUseBUILD2 * unitPriceFood
                                                + materialsUseBUILD2 * unitPriceMaterials
                                                + energyUseBUILD2 * unitPriceEnergy);
                newState.energyDelay = energyDelay;
                newState.foodDelay = foodDelay;
                newState.materialsDelay = materialsDelay;
                return newState;
        }

        public State waitAction() {
                State newState = new State(prosperity, materials - 1, food - 1, energy - 1,
                                money_spent + unitPriceFood + unitPriceEnergy + unitPriceMaterials);
                newState.energyDelay = energyDelay;
                newState.foodDelay = foodDelay;
                newState.materialsDelay = materialsDelay;
                return newState;
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
