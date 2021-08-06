package filter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OUTfilter {
            static void outMat(String r,double[][] matrix ) throws IOException{
            File file = new File("filtered_"+r+".txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i=0;i<Parameters.getReGest();i++){
                for(int j=0;j<Parameters.getAtGest();j++){
                
                    bufferedWriter.write(matrix[i][j]+"  ");
                }
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        }
   
}
