/*
 * Copyright (C) 2016 Felipe Roscoche
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Felipe Roscoche
 * @website roscoche.com
 * 
 */
package imagepatternrecognition;

import static com.googlecode.javacv.cpp.opencv_core.CV_8U;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateMat;
import static com.googlecode.javacv.cpp.opencv_core.cvSplit;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PatternRecognition {
public static void interpolar(int[] novo){
        int min,max=0,n;
        //Procura no vetor inteiro se há algum ponto repetido
        //Se houver, os interpolará à direita.
        for(int i=0;i<novo.length-1;i++){
            //Se houver pontos repetidos, vai contá-los e redefiní-los
            if(novo[i]==novo[i+1]){
                //Define o minimo da interpolação e reseta o numero de elementos
                min=novo[i];
                n=0;
                //Acha a quantidade de membros repetidos e define o maximo da
                //interpolação
                for(int j=i;novo[j]==novo[j+1]&&j<novo.length-2;j++){
                    max=novo[j+2];
                    n++;
                }
                //Redefine os pontos da interpolação
                double passo=(double)(max-min)/(n+1);
                for(int j=i+1;j<=i+n;j++){
                    int incremento=(int)((double)passo*(j-i));
                    novo[j]=novo[j]+incremento;
                }
                //pula os membros ja redefinidos
                i+=n;
            }
        }
     
    }
    public static int[] calculaHistograma(CvMat src) {
        int histo[]=new int[256];
        int val;
        for (int i = 0; i < src.rows(); i++) {
            for (int j = 0; j < src.cols(); j++) {
                val=(int)src.get(i, j);
                histo[val]++;
                }
        }
        return histo;
    }
    
    public int[] equalizaHistograma(int[] hist,int escalas){
        int equalizado[]=new int[hist.length];
        float prj[]=new float[hist.length];
        float sk[]=new float[hist.length];
        int g=escalas-1;
        int soma = IntStream.of(hist).sum();
        
        for(int i=0;i<hist.length;i++){
            prj[i]=(float) hist[i]/soma;
            if(i>0) sk[i]=prj[i]+sk[i-1];
            else sk[i]=prj[i];
            equalizado[i]=round((sk[i]*(float)g));
        }
        return equalizado;
    }
    public void equalizaImagem(CvMat src,CvMat dst,int escalas){
        int hist[]=calculaHistograma(src);
        int equalizado[]=new int[hist.length];
        float prj[]=new float[hist.length];
        float sk[]=new float[hist.length];
        int referencia[]=new int[hist.length];
        int g=escalas-1;
        int soma = IntStream.of(hist).sum();
        for(int i=0;i<referencia.length;i++){
            referencia[i]=-1;
        }
        for(int i=0;i<hist.length;i++){
            prj[i]=(float) hist[i]/soma;
            if(i>0) sk[i]=prj[i]+sk[i-1];
            else sk[i]=prj[i];
            equalizado[round((sk[i]*(float)g))]+=hist[i];
            referencia[i]=round((sk[i]*(float)g));
        }
    }
    public static void completarVetor(int[] novo){
        for(int i=novo.length-2;i>=0;i--){
            while(novo[i]==-1){
                novo[i]=novo[i+1];
                i--;
            }
        }
    }
    public double[] calculaPercentileLBP(CvMat src,int quadrantesX,int quadrantesY){
        double[] valoresPercentil=calculaPercentil(src, quadrantesX, quadrantesY);
        double[] valoresLBP=calculaLBP(src, quadrantesX, quadrantesY);
        double[] valoresBoth=new double[valoresLBP.length+valoresPercentil.length];
        System.arraycopy(valoresPercentil,0,valoresBoth,0,valoresPercentil.length);
        System.arraycopy(valoresLBP,0,valoresBoth,valoresPercentil.length,valoresLBP.length);
        return valoresBoth;
    }
    public double calculaDistanciaEuclidiana(double[] caracteristicaA,double[] caracteristicaB){
        if(caracteristicaA.length!=caracteristicaB.length){
            System.out.println("Vetor de caracteristicas com tamanhos diferentes, impossivel comparar!");
            return -1;
        }
        double[] resultAll=new double[caracteristicaA.length];
        double distanciaPontual;
        for(int i=0;i<resultAll.length;i++){
                distanciaPontual=caracteristicaA[i]-caracteristicaB[i];
                resultAll[i]=distanciaPontual*distanciaPontual;
        }
        return sqrt(DoubleStream.of(resultAll).sum());
}
    public double[] calculaPercentil(CvMat src,int quadrantesX,int quadrantesY){
        
        int[] histograma=new int[256];
        int i,j,count,pixelsQuadrante,inicioX,inicioY,fimX,fimY;
        int[] P=new int[11];
        
        double[] values=new double[quadrantesX*quadrantesY*10];
        double[] F=new double[10];
        double percentagem;
        
        //Caso a imagem de entrada tenha 3 canais, opta-se por realizar uma
        //solução recursiva, aplicando o calculo de percentil para cada canal se
        if(src.channels()==3){
            int numValores=quadrantesX*quadrantesY*10;
            CvMat red,green,blue;
            red=cvCreateMat(src.rows(),src.cols(),CV_8U);
            green=red.clone();
            blue=red.clone();
            cvSplit(src,blue,green,red,null);
            double[] caracteristicasRed=calculaPercentil(red,quadrantesX,quadrantesY);
            double[] caracteristicasGreen=calculaPercentil(green,quadrantesX,quadrantesY);
            double[] caracteristicasBlue=calculaPercentil(blue,quadrantesX,quadrantesY);
            double[] caracteristicasAll=new double[numValores*3];
            System.arraycopy(caracteristicasRed,0,caracteristicasAll, 0,caracteristicasRed.length);
            System.arraycopy(caracteristicasGreen,0,caracteristicasAll, caracteristicasRed.length,caracteristicasGreen.length);
            System.arraycopy(caracteristicasBlue,0,caracteristicasAll, caracteristicasRed.length+caracteristicasGreen.length,caracteristicasBlue.length);
            return caracteristicasAll;
        }
        for(int currquadY=0;currquadY<quadrantesY;currquadY++){
            for(int currquadX=0;currquadX<quadrantesX;currquadX++){
                
                //Setando variáveis
                count=0;
                Arrays.fill(histograma, 0);
                Arrays.fill(P, -1);
                int stop=0;
                //Definindo começo e fim do quadrante
                inicioX=(int)(((double)src.cols()/(double)quadrantesX)*(double)currquadX);
                fimX=(int)(((double)src.cols()/(double)quadrantesX)*(double)(currquadX+1));
                inicioY=(int)(((double)src.rows()/(double)quadrantesY)*(double)currquadY);
                fimY=(int)(((double)src.rows()/(double)quadrantesY)*((double)currquadY+1));
                pixelsQuadrante=(fimX-inicioX)*(fimY-inicioY);

                //Calculando Histograma para o Quadrante
                for(i=inicioY;i<fimY;i++){
                    for(j=inicioX;j<fimX;j++){
                        histograma[(int)src.get(i, j)]++;
                    }
                }
                //Calculando o percentil do quadrante
                for(i=0;i<256;i++){
                    count+=histograma[i];
                    percentagem=(double) ((double)count/(double)pixelsQuadrante);
                    if(P[0]==-1&&percentagem>0) {
                        if(i==0) P[0]=i;
                        else P[0]=i-1;
                    }
                    
                    for(int looper=10;looper>stop;looper--){
                        if(percentagem>=(double)looper/10 &&P[looper]==-1){
                            P[looper]=i;
                            stop=looper;
                        }
                    }
                }
                completarVetor(P);
                //Define se o percentil deve ser equalizado ou interpolado
                //P=equalizaHistograma(P,256);
                //interpolar(P);
                
                //Atribuindo resultados e resetando variáveis
                for(i=0;i<10;i++){
                    F[i]=(double)(P[i+1]-P[i])/255;
                    values[currquadY*quadrantesX*10+currquadX*10+i]=F[i];    
                }
            }
        }
        return values;
    }
    public double[] calculaLBP(CvMat src,int quadrantesX,int quadrantesY){
    
        int i,j,pixelsQuadrante,inicioX,inicioY,fimX,fimY;
        int[] histograma=new int[256];
        double[] result=new double[256*quadrantesX*quadrantesY];
        //Copia a imagem origem e a seta para o padrao binario dela mesma.
        CvMat dst;
        if(src.channels()>1){
                dst=cvCreateMat(src.rows(),src.cols(),CV_8U);
                cvCvtColor(src, dst, CV_BGR2GRAY);
                src=dst.clone();
        }
        else dst=src.clone();
        
        dst=lbp(dst);
        for(int currquadY=0;currquadY<quadrantesY;currquadY++){
            for(int currquadX=0;currquadX<quadrantesX;currquadX++){
                //Definindo começo e fim do quadrante
                inicioX=(int)(((double)src.cols()/(double)quadrantesX)*(double)currquadX);
                fimX=(int)(((double)src.cols()/(double)quadrantesX)*(double)(currquadX+1));
                inicioY=(int)(((double)src.rows()/(double)quadrantesY)*(double)currquadY);
                fimY=(int)(((double)src.rows()/(double)quadrantesY)*((double)currquadY+1));
                pixelsQuadrante=(fimX-inicioX)*(fimY-inicioY);
                //Calculando Histograma para o Quadrante
                for(i=inicioY;i<fimY;i++){
                    for(j=inicioX;j<fimX;j++){
                        histograma[(int)dst.get(i, j)]++;
                    }
                }
                for(i=0;i<histograma.length;i++){
                    result[currquadY*quadrantesX*256+currquadX*256+i]=(double) histograma[i]/pixelsQuadrante;   
                }
                Arrays.fill(histograma, 0);
            }
        }
        return result;
    }
        
    public CvMat lbp(CvMat src){
        CvMat dst=src.clone();
        int i,j;
        int decimal=0;
        for(i=1;i<dst.rows()-1;i++){
            for(j=1;j<dst.cols()-1;j++){
                if(src.get(i-1,j-1)>=src.get(i,j)) decimal+=128;
                if(src.get(i-1,j)>=src.get(i,j)) decimal+=64;
                if(src.get(i-1,j+1)>=src.get(i,j)) decimal+=32;
                if(src.get(i,j-1)>=src.get(i,j)) decimal+=16;
                if(src.get(i,j+1)>=src.get(i,j)) decimal+=8;
                if(src.get(i+1,j-1)>=src.get(i,j)) decimal+=4;
                if(src.get(i+1,j)>=src.get(i,j)) decimal+=2;
                if(src.get(i+1,j+1)>=src.get(i,j)) decimal+=1;
                dst.put(i,j,decimal);
                decimal=0;
            }
        }
        return dst;
    }
    public static void negativar(CvMat src,CvMat dst) {
        
        int val;
        
        for (int i = 0; i < src.rows(); i++) {
            for (int j = 0; j < src.cols(); j++) {
                val=(int)src.get(i, j);
                dst.put(i,j,255-val);
                }
        }
        
    }

}
