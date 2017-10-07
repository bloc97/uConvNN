/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.elementwise.activation.kernels;

import com.aparapi.Kernel;
import com.aparapi.Range;

/**
 *
 * @author bowen
 */
public class ReLUBackwardKernel extends Kernel {

    private float[] outputError = new float[0];
    private float[] inputError = new float[0];

    public void call(float[] outputError, float[] inputError) {
        this.outputError = outputError;
        this.inputError = inputError;
        Range range = Range.create(outputError.length);
        execute(range);
    }
    
    @Override
    public void run() {
        int i = getGlobalId();
        
        if (outputError[i] < 0) {
            inputError[i] = 0;
        } else {
            inputError[i] = 1;
        }
    }
    
}
