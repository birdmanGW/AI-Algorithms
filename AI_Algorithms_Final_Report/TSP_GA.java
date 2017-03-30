/*
* TSP_GA.java
* Create a tour and evolve a solution
*/

package tsp;

public class TSP_GA {

    public static void main(String[] args) {

        // Create and add our [20] cities
        City city = new City(60, 200);
        TourManager.addCity(city);
        City city2 = new City(180, 200);
        TourManager.addCity(city2);
        City city3 = new City(80, 180);
        TourManager.addCity(city3);
        City city4 = new City(140, 180);
        TourManager.addCity(city4);
        City city5 = new City(20, 160);
        TourManager.addCity(city5);
        City city6 = new City(100, 160);
        TourManager.addCity(city6);
        City city7 = new City(200, 160);
        TourManager.addCity(city7);
        City city8 = new City(140, 140);
        TourManager.addCity(city8);
        City city9 = new City(40, 120);
        TourManager.addCity(city9);
        City city10 = new City(100, 120);
        TourManager.addCity(city10);
        City city11 = new City(180, 100);
        TourManager.addCity(city11);
        City city12 = new City(60, 80);
        TourManager.addCity(city12);
        City city13 = new City(120, 80);
        TourManager.addCity(city13);
        City city14 = new City(180, 60);
        TourManager.addCity(city14);
        City city15 = new City(20, 40);
        TourManager.addCity(city15);
        City city16 = new City(100, 40);
        TourManager.addCity(city16);
        City city17 = new City(200, 40);
        TourManager.addCity(city17);
        City city18 = new City(20, 20);
        TourManager.addCity(city18);
        City city19 = new City(60, 20);
        TourManager.addCity(city19);
        City city20 = new City(160, 20);
        TourManager.addCity(city20);

        int popSize = 1000;
        Population pop;
        int i, j, avg1 = 0, avg2 = 0;

        for (j = 0; j < 20; j++) {

            // Initialize population
            pop = new Population(popSize, true);
            System.out.println("Initial distance: " + j + " : " + pop.getFittest().getDistance());

            // Evolve population for 100 generations
            pop = GA.evolvePopulation(pop);
            for (i = 0; i < popSize; i++) {
                pop = GA.evolvePopulation(pop);
            }

            avg1 = avg1 + pop.getFittest().getDistance();

            // Print final results
            //System.out.println("Finished");
            //System.out.println("Final distance: " + pop.getFittest().getDistance());
            //System.out.println("Solution:");
            //System.out.println(pop.getFittest());
        }

        System.out.println("Average Dist. using 2-Point Crossover: " + avg1 / 20);

        //Change crossover method to Uniform Crossover
        GA.setCrossover(true);

        for (j = 0; j < 20; j++) {

            // Initialize population
            pop = new Population(popSize, true);
            System.out.println("Initial distance " + j + " : " + pop.getFittest().getDistance());

            // Evolve population for 100 generations
            pop = GA.evolvePopulation(pop);
            for (i = 0; i < popSize; i++) {
                pop = GA.evolvePopulation(pop);
            }

            avg2 = avg2 + pop.getFittest().getDistance();

            // Print final results
            //System.out.println("Finished");
            //System.out.println("Final distance: " + pop.getFittest().getDistance());
            //System.out.println("Solution:");
            //System.out.println(pop.getFittest());
        }

        System.out.println("Average Dist. using Uniform Crossover: " + avg2 / 20);
    }
}