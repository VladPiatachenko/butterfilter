/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package butterworth;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erlkonig
 */
public class Filter {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Gesture> Gestures=new ArrayList<>();
        Gesture curGest;
        
        for(int g=0;g<Parameters.getAmGest();g++){
            curGest=new Gesture(Input.getGestureName(g),Input.getMatrix(g));
            Gestures.add(curGest);
        }
        
        for(Gesture Current:Gestures){
            double[][] cur=Current.getMatrix();
            double[][] filtered= new double[Parameters.getReGest()][Parameters.getAtGest()];
                for(int i=0;i<Parameters.getReGest();i++){
                    filtered[i]=Kalman.execute(cur[i]);}
                Current.setFilteredMatrix(filtered);
            try {
                OUTfilter.outMat(Current.getName(),Current.getFilteredMatrix());
            } catch (IOException ex) {
                Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
