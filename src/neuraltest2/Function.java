/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuraltest2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcin
 */
public abstract class Function {

    protected List<Double> coefficients = new ArrayList<>();

    public Function(List<Double> coefficients){
        this.coefficients = coefficients;
    }
    
    public void addCoefficient(double coefficient) {
        coefficients.add(coefficient);
    }

    public void clearCoefficients() {
        coefficients = new ArrayList<>();
    }

    public abstract double getFunctionValue(double x);

}
