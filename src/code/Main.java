package code;

public class Main {
    public static void main(String[] args) {
        String initialState2 = "30;" +
                "30,25,19;" +
                "90,120,150;" +
                "9,2;13,1;11,1;" +
                "3195,11,12,10,34;" +
                "691,7,8,6,15;";
        String init = "50;" +
                "22,22,22;" +
                "50,60,70;" +
                "30,2;19,1;15,1;" +
                "300,5,7,3,20;" +
                "500,8,6,3,40;";
        /*
         * // Initial variables
         * initialProsperity = 50;
         * initialFood = 22;
         * initialMaterials = 22;
         * initialEnergy = 22;
         * 
         * // Unit prices
         * unitPriceFood = 50;
         * unitPriceMaterials = 60;
         * unitPriceEnergy = 70;
         * 
         * // Amount requests
         * amountRequestFood = 30;
         * delayRequestFood = 2;
         * amountRequestMaterials = 19;
         * delayRequestMaterials = 1;
         * amountRequestEnergy = 15;
         * delayRequestEnergy = 1;
         * 
         * // Building prices and uses
         * priceBuild1 = 300;
         * foodUseBuild1 = 5;
         * materialsUseBuild1 = 7;
         * energyUseBuild1 = 3;
         * prosperityBuild1 = 20;
         * priceBuild2 = 500;
         * foodUseBuild2 = 8;
         * materialsUseBuild2 = 6;
         * energyUseBuild2 = 3;
         * prosperityBuild2 = 40;
         * 
         */

        String solution = LLAPSearch.solve(init, "BF", false);
        System.out.println(solution);

    }
}
