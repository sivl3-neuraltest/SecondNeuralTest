/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuraltest2;

import java.util.List;

/**
 *
 * @author Marcin
 */
public class SigmoidFunction extends Function{
    
    public SigmoidFunction(List<Double> coefficients){
        super(coefficients);
    }
    
    @Override
    public double getFunctionValue(double x) {
        return (double) (1/(1+Math.pow((double)Math.E, (double)coefficients.get(0) * -1 * x)));
    }
    
}
