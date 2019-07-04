/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuraltest2;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Marcin
 */
public class NeuralTest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Network n = new Network(new int[]{2, 3, 1}, new SigmoidFunction(Arrays.asList((double)1)), new Long(0));
        n.setInput(new double[]{1, 2});
        n.calculateNetwork();
        n.printValues();
    }

}
