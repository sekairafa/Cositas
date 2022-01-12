package com.example.cositas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Polynomy {
    public double[] coefs;
    private final int order;

    public Polynomy (double[] coefs) {
        int order = coefs.length - 1;

        if (order < 0 || coefs[0] == 0.0) {
            this.order = 0;
            return;
        }

        this.order = order;
        this.coefs = new double[this.order + 1];
        System.arraycopy(coefs, 0, this.coefs, 0, this.order + 1);
    }

    public Polynomy (Polynomy poly) {
        this.order = poly.order;
        this.coefs = new double[this.order + 1];
        System.arraycopy(poly.coefs, 0, this.coefs, 0, this.order + 1);
    }

    public int getOrder(){
        return this.order;
    }

    public double eval(double x) {
        double y = 0;
        for (int i = 0; i <= this.order; i++) {
            y += this.coefs[i] * Math.pow(x, this.order - i);
        }
        return y;
    }

    public void normalize() {
        for(int i = 1; i <= this.order; i++) {
            this.coefs[i] /= this.coefs[0];
        }
        this.coefs[0] = 1.0;
    }

    public Polynomy derivate() {
        double[] coefs_;
        if (this.order == 0) {
            coefs_ = new double[1];
            coefs_[0] = 0.0;
        }
        else {
            coefs_ = new double[order];
            for (int i = 0; i < this.order; i++) {
                coefs_[i] = this.coefs[i] * (this.order - i);
            }
        }

        return new Polynomy(coefs_);
    }

    public MyComplex[] roots() {
        MyComplex[] roots_array;

        Polynomy normalized = new Polynomy(this);
        normalized.normalize();
        switch (this.order) {
            case 1:
                roots_array = (normalized.firstOrderRoot());
                break;
            case 2:
                roots_array =(normalized.secondOrderRoots());
                break;
            case 3:
                roots_array = (normalized.thridOrderRoots());
                break;
            case 4:
                roots_array = (normalized.fourthOrderRoots());
                break;
            case 5:
                roots_array = (normalized.fifthOrderRoots());
                break;
            default:
                return null;
        }

        List<MyComplex> roots_list = new ArrayList<>(Arrays.asList(roots_array));

        Collections.sort(roots_list);

        return roots_list.toArray(roots_array);
    }

    private MyComplex[] firstOrderRoot() {
        MyComplex[] roots = new MyComplex[1];
        roots[0] = new MyComplex(-this.coefs[1], 0.0, false);
        return roots;
    }

    private MyComplex[] secondOrderRoots() {
        MyComplex[] roots = new MyComplex[2];

        double real = -this.coefs[1] / 2.0;
        double disc = Math.pow(this.coefs[1], 2.0) - 4 * this.coefs[2];

        if (disc < 0.0) {
            double imag = Math.sqrt(-disc) / 2.0;
            roots[0] = new MyComplex(real, imag, true);
            roots[1] = new MyComplex(real, -imag, true);
        }
        else {
            double _real = Math.sqrt(disc) / 2;
            roots[0] = new MyComplex(real + _real, 0.0, false);
            roots[1] = new MyComplex(real - _real, 0.0, false);
        }

        return roots;
    }

    private MyComplex[] thridOrderRoots() {
        MyComplex[] roots = new MyComplex[3];

        if (this.coefs[this.order] == 0.0) {
            roots = this.roots_reduce_by_real(0.0);
        }
        else {

            double p = this.coefs[2] - Math.pow(this.coefs[1], 2.0) / 3.0;
            double q = 2.0 * Math.pow(this.coefs[1], 3.0) / 27.0 - this.coefs[1] * this.coefs[2] / 3.0 + this.coefs[3];
            double delta = Math.pow(q, 2.0) + 4.0 * Math.pow(p, 3.0) / 27.0;

            if (delta > 0.0) {
                double sDelta = Math.sqrt(delta);
                double u = myCubicRoot((-q + sDelta) / 2.0);
                double v = myCubicRoot((-q - sDelta) / 2.0);

                double real = u + v;
                double imag = Math.sqrt(3.0) * (u - v) / 2.0;

                roots[0] = new MyComplex(real, 0.0, false);
                roots[1] = new MyComplex(-real / 2.0, +imag, true);
                roots[2] = new MyComplex(-real / 2.0, -imag, true);
            } else if (delta == 0.0) {
                if (p == 0.0 && q == 0.0) {
                    roots[0] = new MyComplex(0.0, 0.0, false);
                    roots[1] = new MyComplex(0.0, 0.0, false);
                    roots[2] = new MyComplex(0.0, 0.0, false);
                } else {
                    roots[0] = new MyComplex(3.0 * q / p, 0.0, false);
                    double r_1_2 = -3.0 * q / 2.0 / p;
                    roots[1] = new MyComplex(r_1_2, 0.0, false);
                    roots[2] = new MyComplex(r_1_2, 0.0, false);
                }
            } else { //delta < 0.0
                double real = 2.0 * Math.sqrt(-p / 3.0);
                double theta = Math.acos(3.0 * q / 2.0 / p * Math.sqrt(-3.0 / p));
                roots[0] = new MyComplex(real * Math.cos(theta / 3.0), 0.0, false);
                roots[1] = new MyComplex(real * Math.cos((theta + 2.0 * Math.PI) / 3.0), 0.0, false);
                roots[2] = new MyComplex(real * Math.cos((theta + 4.0 * Math.PI) / 3.0), 0.0, false);
            }

            double diff = -this.coefs[1] / 3.0;
            for (int i = 0; i < 3; i++) {
                roots[i].add(diff);
            }
        }

        return roots;
    }

    private MyComplex[] fourthOrderRoots() {
        MyComplex[] roots = new MyComplex[4];

        if (this.coefs[this.order] == 0.0) {
            roots = this.roots_reduce_by_real(0.0);
        }
        else {
            int i, j;

            double b = this.coefs[1];
            double c = this.coefs[2];
            double d = this.coefs[3];
            double e = this.coefs[4];

            double A = -3.0 * Math.pow(b, 2.0) / 8.0 + c;
            double B = Math.pow(b, 3.0) / 8.0 - b * c / 2.0 + d;
            double G = -3.0 * Math.pow(b, 4.0) / 256.0 + c * Math.pow(b, 2.0) / 16.0 - b * d / 4.0 + e;

            MyComplex[][] delta_4 = new MyComplex[2][];
            double real = -b / 4.0;

            if (B == 0) {
                MyComplex delta_1 = new MyComplex(Math.pow(A, 2.0) - 4.0 * G, 0.0, false);
                MyComplex[] delta_2 = delta_1.nRoot(2);

                for (i = 0; i < 2; i++) {
                    delta_2[i].add(-A).multiply(0.5);
                    delta_4[i] = delta_2[i].nRoot(2);
                }
            }
            else {
                double P = -Math.pow(A, 2.0) / 12.0 - G;
                double Q = -Math.pow(A, 3.0) / 108.0 + A * G / 3.0 - Math.pow(B, 2.0) / 8.0;

                MyComplex delta_R = new MyComplex(Math.pow(Q, 2.0) / 4.0 + Math.pow(P, 3.0) / 27.0, 0.0, false);
                MyComplex R = delta_R.nRoot(2)[0].add(-Q / 2.0);

                MyComplex U = R.nRoot(3)[0];

                MyComplex y;
                if (!U.isComplex() && U.getReal() == 0.0) {
                    y = new MyComplex(-myCubicRoot(Q), 0.0, false);
                }
                else {
                    y = (new MyComplex(-P / 3.0, 0.0, false)).divide(U).add(U);
                }

                y.add(-5.0 / 6.0 * A);

                MyComplex _2y = (new MyComplex(y)).multiply(2.0);

                MyComplex delta_W = (new MyComplex(_2y)).add(A);

                MyComplex W = delta_W.nRoot(2)[0];
                MyComplex _W = (new MyComplex(W)).multiply(-1.0);

                MyComplex _3A2Y = (new MyComplex(3.0 * A, 0.0, false)).add(_2y);

                MyComplex _2BW = (new MyComplex(2.0 * B, 0.0, false)).divide(W);

                MyComplex[] delta_ = new MyComplex[2];

                for (i = 0; i < 2; i++) {
                    delta_[i] = new MyComplex(_2BW);

                    if (i == 1) {
                        delta_[i].multiply(-1.0);
                    }

                    delta_[i].add(_3A2Y);
                    delta_[i].multiply(-1.0);

                    delta_4[i] = delta_[i].nRoot(2);

                    delta_4[i][0].add((i == 0)? W : _W).multiply(0.5);
                    delta_4[i][1].add((i == 0)? W : _W).multiply(0.5);
                }
            }

            for (j = 0; j < 2; j++) {
                for (i = 0; i < 2; i++) {
                    delta_4[j][i].add(real);
                    roots[2*j + i] = new MyComplex(delta_4[j][i]);
                }
            }
        }

        return roots;
    }

    private MyComplex[] fifthOrderRoots() {
        return this.roots_reduce_by_real(this.getRealRoot());
    }

    private double getRealRoot() {
        if (this.coefs[this.order] == 0.0) {
            return 0.0;
        }

        double a = this.coefs[1] / 5.0;
        if ((this.coefs[2] == 10.0*Math.pow(a, 2.0)) && (this.coefs[3] == 10.0*Math.pow(a, 3.0)) && (this.coefs[4] == 5.0*Math.pow(a, 4.0))  && (this.coefs[5] == Math.pow(a, 5.0))) {
            return -a;
        }

        double pivot1 = 0.0;
        double toUp = (this.coefs[this.order] < 0.0)? 1.0 : -1.0;

        double pivot2 = 10.0 * toUp;
        while ((this.eval(pivot2) * toUp) < 0.0) {
            pivot1 = pivot2;
            pivot2 *= 2.0;
        }

        double dx = 0.000000000001;
        while(Math.abs(pivot1 - pivot2) > dx) {
            double average = (pivot1 + pivot2) / 2.0;

            double y1 = this.eval(pivot1);
            double y2 = this.eval(average);

            if (y1 == 0.0) {
                break;
            }
            else if (y2 == 0.0) {
                pivot1 = average;
                break;
            }
            else if(y1 * y2 < 0.0) {
                pivot2 = average;
            }
            else {
                pivot1 = average;
            }
        }

        return this.newton(pivot1);
    }

    private Polynomy ruffini(double root) {
        double[] coefs_ = new double[this.order];

        coefs_[0] = this.coefs[0];

        for (int i = 1; i < this.order; i++) {
            coefs_[i] = this.coefs[i] + root * coefs_[i - 1];
        }

        return new Polynomy(coefs_);
    }

    private double newton(double x0) {
        Polynomy poly_ = this.derivate();
        double x1 = x0;

        for(int i = 0; i < 10000; i++) {
            x0 = x1;
            x1 = x0 - this.eval(x0) / poly_.eval(x0);
        }

        return x1;
    }

    private double myCubicRoot(double val) {
        return ((val < 0.0)? -1.0 : 1.0) * Math.pow(Math.abs(val), 1.0 / 3.0);
    }

    private MyComplex[] roots_reduce_by_real(double real) {
        MyComplex[] roots = new MyComplex[this.order];

        roots[0] = new MyComplex(real, 0.0, false);

        MyComplex[] roots_ = this.ruffini(real).roots();
        System.arraycopy(roots_, 0, roots, 1, this.order - 1);

        return roots;
    }
}
