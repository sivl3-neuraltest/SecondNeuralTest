/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuraltest2;

import java.util.Random;

/**
 *
 * @author Marcin
 */
public class Network {

    int[] sizes;
    double[][] neurons;
    double[][][] weights;
    Function activationFunction;
    int w, h, d;
    

    public Network(int[] sizes, Function activationFunction, Long randomDoubleGeneratorSeed) {
        this.activationFunction = activationFunction;
        //rdg = randomDoubleGenerator
        Random rDG = new Random(randomDoubleGeneratorSeed);
        this.sizes = sizes;
        neurons = new double[sizes.length][];
        weights = new double[sizes.length - 1][][];

        for (w = 0; w < sizes.length; w++) {
            neurons[w] = new double[sizes[w]];
            if (w + 1 < sizes.length) {
                weights[w] = new double[sizes[w]][];
                for (h = 0; h < sizes[w]; h++) {
                    weights[w][h] = new double[sizes[w + 1]];
                    for (d = 0; d < sizes[w + 1]; d++) {
                        //weights[w][h][d] = rDG.nextDouble();
                        weights[w][h][d] = h;
                    }
                }
            }

        }
    }

    public void printWeights() {
        for (w = 0; w + 1 < sizes.length; w++) {
            for (h = 0; h < sizes[w]; h++) {
                System.out.print("{");
                for (d = 0; d < sizes[w + 1]; d++) {
                    System.out.print(weights[w][h][d] + ",");
                }
                System.out.print("}");
            }
            System.out.println("");
        }
    }

    public void printValues() {
        for (int h = 0; h < neurons.length; h++) {
            for (int w = 0; w < neurons[h].length; w++) {
                System.out.print(neurons[h][w] + "\t");
            }
            System.out.println("");
        }
    }

    public void setInput(double[] input) {
        /*Wolniejsza wersja
        for(h=0; h<input.length; h++){
            neurons[0][h] = input[h];
        }*/
        //Szybsza wersja
        neurons[0] = input;
    }

    public void calculateNetwork() {
        double[][] newValues;
        for (w = 0; w + 1 < sizes.length; w++) {
            double[][] values = {neurons[w]};
            newValues = new double[1][];
            newValues[0] = new double[neurons[w + 1].length];

            Matrix.multiply(values, weights[w], newValues, false);

            //Tutaj h nie oznacza wysokosci, uzyte aby zminimalizowac ilosc uzywanych zmiennych
            for (h = 0; h < neurons[w + 1].length; h++) {
                newValues[0][h] = activationFunction.getFunctionValue(newValues[0][h]);
            }
                neurons[w + 1] = newValues[0];
        }

    }
}
