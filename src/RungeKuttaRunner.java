import java.util.ArrayList;


public class RungeKuttaRunner {
    public static void main(String[] args){
        int A = 4;
        double B = 0.154;
        double w = 1.2199778;
        double dt = 0.01030049121;
        double[] T = new double[50000];
        for(int n = 0; n < 49999; n++)
        {
            T[n] = dt * n;
        }
        double[] x = new double[50000];
        double[] v = new double[50000];
        x[0] = 0.1;
        v[0] = 0.1;
        double[] kx1 = new double[50000];
        double[] kv1 = new double[50000];
        double[] kx2 = new double[50000];
        double[] kv2 = new double[50000];
        double[] kx3 = new double[50000];
        double[] kv3 = new double[50000];
        double[] kx4 = new double[50000];
        double[] kv4 = new double[50000];

        //giant for loop for each iteration
        for(int i = 0; i < 49999; i++){
            kx1[i] = v[i] * dt;
            kx2[i] = (v[i] + 0.5*kv1[i]) * dt;
            kx3[i] = (v[i] + 0.5*kv2[i]) * dt;
            kx4[i] = (v[i] + kv3[i]) * dt;
            //setting kv values
            kv1[i] = (x[i] - A*Math.pow(x[i],3) - B*v[i] + Math.cos(w * T[i])) * dt;
            kv2[i] = ((x[i] + 0.5*kx1[i]) - A*Math.pow(x[i]+0.5*kx1[i], 3) - B*(v[i] + 0.5*kv1[i]) + Math.cos(T[i]+0.5*dt)) * dt;
            kv3[i] = ((x[i] + 0.5*kx2[i]) - A*Math.pow(x[i]+0.5*kx2[i], 3) - B*(v[i] + 0.5*kv2[i]) + Math.cos(T[i]+0.5*dt)) * dt;
            kv4[i] = ((x[i] + kx3[i]) - A*Math.pow(x[i]+kx3[i], 3) - B*(v[i]+kv3[i]) + Math.cos(T[i]+dt)) * dt;
            //setting x and v values
            x[i+1] = x[i] + (kx1[i]/6.0) + (kx2[i]/3.0) + (kx3[i]/3.0) + (kx4[i]/6.0);
            v[i+1] = v[i] + (kv1[i]/6.0) + (kv2[i]/3.0) + (kv3[i]/3.0) + (kv4[i]/6.0);




        }
        for(int i = 0; i < 49999; i++){
            System.out.println(x[i] + ",");
        }
    }
}
