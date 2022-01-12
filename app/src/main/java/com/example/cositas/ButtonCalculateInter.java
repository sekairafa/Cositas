package com.example.cositas;

import android.widget.Button;
import android.widget.Toast;

public class ButtonCalculateInter {
    ActivityInterpolation context;

    public ButtonCalculateInter(Button button) {
        button.setOnClickListener(v -> {
            this.context = (ActivityInterpolation) v.getContext();

            switch (this.context.getRadioIndex(1)) {
                case 0:
                    calculate1DInter();
                    break;
                case 1:
                    calculate2DInter();
                    break;
            }
        });
    }

    public void calculate1DInter() {
        switch (this.context.getRadioIndex(2)) {
            case 0:
                calculate1DNearest();
                break;
            case 1:
                calculate1DLineal();
                break;
            case 2:
                calculate1DCubic();
                break;
        }
    }

    public void calculate2DInter() {
        switch (this.context.getRadioIndex(3)) {
            case 0:
                calculate2DNearest();
                break;
            case 1:
                calculate2DLineal();
                break;
        }
    }

    private double nearest(double x1, double x2, double y1, double y2, double x) {
        return (Math.abs(x - x1) < Math.abs(x - x2))? y1 : y2;
    }

    private double lineal(double x1, double x2, double y1, double y2, double x) {
        return (y2 - y1) / (x2 - x1) * (x - x1) + y1;
    }

    public void calculate1DNearest() {
        try {
            MyPoint[] points = context.get1DPoints(3);
            context.put1D(nearest(points[0].getX(), points[1].getX(), points[0].getY(), points[1].getY(), points[2].getX()));
        }
        catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void calculate1DLineal() {
        try {
            MyPoint[] points = context.get1DPoints(3);
            context.put1D(lineal(points[0].getX(), points[1].getX(), points[0].getY(), points[1].getY(), points[2].getX()));
        }
        catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void calculate1DCubic() {
        try {
            MyPoint[] points = context.get1DPoints(5);

            MyMatrix system = new MyMatrix(4);
            double[] results = new double[4];

            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    system.set(j, i, Math.pow(points[j].getX(), 3.0 - i));
                }

                results[j] = points[j].getY();
            }

            Polynomy poly = new Polynomy(MyMatrix.getSolutions(system, results));

            if (poly.getOrder() == 0) {
                throw new Exception("Indeterminado");
            }

            context.put1D(poly.eval(points[4].getX()));
        }
        catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void calculate2DNearest() {
        try {
            double[] points = context.get2DPoints();
            double[] results = new double[5];

            results[0] = nearest(points[0], points[2], points[4], points[5], points[1]);
            results[4] = nearest(points[0], points[2], points[8], points[9], points[1]);

            results[1] = nearest(points[3], points[7], points[4], points[8], points[6]);
            results[3] = nearest(points[3], points[7], points[5], points[9], points[6]);

            results[2] = nearest(points[3], points[7], results[0], results[4], points[6]);

            context.put2D(results);
        }
        catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void calculate2DLineal() {
        try {
            double[] points = context.get2DPoints();
            double[] results = new double[5];

            results[0] = lineal(points[0], points[2], points[4], points[5], points[1]);
            results[4] = lineal(points[0], points[2], points[8], points[9], points[1]);

            results[1] = lineal(points[3], points[7], points[4], points[8], points[6]);
            results[3] = lineal(points[3], points[7], points[5], points[9], points[6]);

            results[2] = lineal(points[0], points[2], results[1], results[3], points[1]);

            context.put2D(results);
        }
        catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
