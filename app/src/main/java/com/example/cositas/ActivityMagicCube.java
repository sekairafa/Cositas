package com.example.cositas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class ActivityMagicCube extends AppCompatActivity {

    EditOrderCube txt_order_val;

    ButtonGenerate button_generate;

    LinearLayout linear_matrix;

    TextView[][] fields;;

    private Typeface typeface;

    LinearLayout.LayoutParams params_field;

    public MyInteger myOrder = new MyInteger(3);

    private int[][] matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_cube);

        txt_order_val = new EditOrderCube(this, findViewById(R.id.editTextNumber_select), 3, 10);

        button_generate = new ButtonGenerate(findViewById(R.id.button_generate));

        linear_matrix = findViewById(R.id.LinearL_matrix);

        new ButtonSelectMagic(findViewById(R.id.imgB_plus), 10, true);
        new ButtonSelectMagic(findViewById(R.id.imgB_minus), 3, false);

        typeface = ResourcesCompat.getFont(this, R.font.alice);

        int px_dp1 = px(1);
        params_field = new LinearLayout.LayoutParams(px(30), px(25));
        params_field.setMargins(px_dp1, px_dp1, px_dp1, px_dp1);

        new ButtonBack(findViewById(R.id.imgB_back));

        displayMatrix();
    }

    private int px(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public void displayMatrix() {
        this.linear_matrix.removeAllViews();

        int order = this.myOrder.get();
        this.fields = new TextView[order][order];

        for (int j = 0; j < order; j++) {
            LinearLayout row = new LinearLayout(new ContextThemeWrapper(this, R.style.layout_wrapper_magic_row), null, 0);

            for (int i = 0; i < order; i++) {
                TextView txt = new TextView(new ContextThemeWrapper(this, R.style.magic_field), null, 0);
                txt.setLayoutParams(this.params_field);
                txt.setTypeface(this.typeface);

                row.addView(txt);

                this.fields[j][i] = txt;
            }

            this.linear_matrix.addView(row);
        }
    }

    public void generate() {
        int n = this.myOrder.get();
        this.matrix = (n % 2 == 0)? this.getEven(n) : this.getOdd(n);

        Random rand = new Random();
        int count = rand.nextInt(4);
        for (int i = 0; i < count; i++) {
            rotate(n);
        }

        if (rand.nextInt(4) % 2 == 0) {
            reflex(n, true);
        }

        if (rand.nextInt(4) % 2 == 0) {
            reflex(n, false);
        }

        put();
    }

    private void rotate(int n) {
        int[][] matrix = new int[n][n];

        int i, j;

        for(j = 0; j < n; j++) {
            for(i = 0; i < n; i++) {
                matrix[j][i] = this.matrix[j][i];
            }
        }

        for(j = 0; j < n; j++) {
            for(i = 0; i < n; i++) {
                this.matrix[i][n - j - 1] = matrix[j][i];
            }
        }
    }

    private void reflex(int n, boolean isV) {
        if (isV) {
            reflexV(n);
        }
        else {
            reflexH(n);
        }
    }

    private void reflexV(int n) {
        int temp;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n / 2; i++) {
                temp = this.matrix[j][i];
                this.matrix[j][i] = this.matrix[j][n - i - 1];
                this.matrix[j][n - i - 1] = temp;
            }
        }
    }

    private void reflexH(int n) {
        int temp;
        for (int j = 0; j < n / 2; j++) {
            for (int i = 0; i < n; i++) {
                temp = this.matrix[j][i];
                this.matrix[j][i] = this.matrix[n - j - 1][i];
                this.matrix[n - j - 1][i] = temp;
            }
        }
    }

    private int[][] getEven(int n) {
        return (n % 4 == 0)? this.getEven_4(n) : this.getEven_n4(n);
    }

    private int[][] getEven_4(int n) {
        Random rand = new Random();
        return (rand.nextInt(2) == 0)? this.getEven_4_1(n) : this.getEven_4_2(n);
    }

    private int[][] getEven_4_1(int n) {
        int[][] matrix = new int[n][n];

        int i, j, gap = n / 4;

        for (j = 0; j < n; j++) {
            for (i = 0; i < n; i++) {
                matrix[j][i] = j * n + i + 1;
            }
        }

        for (j = 0; j < gap; j++) {
            for (i = gap; i < n - gap; i++) {
                this.swap(matrix, n, j, i);
                this.swap(matrix, n, i, j);
            }
        }

        return matrix;
    }

    private int[][] getEven_4_2(int n) {
        boolean[][] matrix_1 = new boolean[n / 2][n];
        int[][] matrix_2 = new int[n][n];

        boolean[] row = new boolean[n];

        int i, j;

        for(i = 0; i < n; i++) {
            row[i] = (((i + 1) / 2) % 2) == 0;
        }

        for (j = 0; j < n / 2; j++) {
            for(i = 0; i < n; i++) {
                matrix_1[j][i] = row[i];
            }
        }

        for (j = 0; j < n / 2; j++) {
            for(i = 0; i < n; i++) {
                matrix_1[j][i] ^= row[j];
            }
        }

        for (j = 0; j < n; j++) {
            for (i = 0; i < n; i++) {
                matrix_2[j][i] = j * n + i + 1;
            }
        }

        for (j = 0; j < n / 2; j++) {
            for(i = 0; i < n; i++) {
                if (matrix_1[j][i]) {
                    this.swap(matrix_2, n, j, i);
                }
            }
        }

        return matrix_2;
    }

    private int[][] getEven_n4(int n) {
        int N = n / 2;
        int k = n / 4 + 1;

        int[][] matrix_1 = getOdd_1(N);
        int[][] matrix_2 = new int[N][N];
        int[][] matrix_3 = new int[n][n];

        setZero(matrix_3, n);

        int i, j, i_, j_;

        for (j = 0; j < k; j++) {
            for (i = 0; i < N; i++) {
                matrix_2[j][i] = 1;
            }
        }

        for (i = 0; i < N; i++) {
            matrix_2[j][i] = 2;
        }

        int N_ = N / 2;
        int temp = matrix_2[j][N_];
        matrix_2[j][N_] = matrix_2[j - 1][N_];
        matrix_2[j - 1][N_] = temp;

        for (j = j + 1; j < N; j++) {
            for (i = 0; i < N; i++) {
                matrix_2[j][i] = 3;
            }
        }

        for (j = 0; j < N; j++) {
            for (i = 0; i < N; i++) {
                i_ = 2 * i;
                j_ = 2 * j;

                temp = 4 * matrix_1[j][i];

                switch (matrix_2[j][i]) {
                    case 1:
                        matrix_3[j_][i_] = temp;
                        matrix_3[j_][i_+1] = temp - 3;
                        matrix_3[j_+1][i_] = temp - 2;
                        matrix_3[j_+1][i_+1] = temp - 1;
                        break;
                    case 2:
                        matrix_3[j_][i_] = temp - 3;
                        matrix_3[j_][i_+1] = temp;
                        matrix_3[j_+1][i_] = temp - 2;
                        matrix_3[j_+1][i_+1] = temp - 1;
                        break;
                    case 3:
                        matrix_3[j_][i_] = temp - 3;
                        matrix_3[j_][i_+1] = temp;
                        matrix_3[j_+1][i_] = temp - 1;
                        matrix_3[j_+1][i_+1] = temp - 2;
                        break;
                }
            }
        }

        return matrix_3;
    }

    private void swap(int[][] matrix, int n, int j, int i) {
        int i_, j_, temp;

        j_ = n - j - 1;
        i_ = n - i - 1;

        temp = matrix[j][i];
        matrix[j][i] = matrix[j_][i_];
        matrix[j_][i_] = temp;
    }

    private int[][] getOdd(int n) {
        Random rand = new Random();
        return (rand.nextInt(2) == 0)? this.getOdd_1(n) : this.getOdd_2(n);
    }

    private int[][] getOdd_1(int n) {
        int[][] matrix = new int[n][n];
        setZero(matrix, n);

        int K = n * n + 1;
        int j = 0, j_;
        int i = n / 2, i_;

        for (int k = 1; k < K; k++) {
            i_ = i;
            j_ = j;

            if(matrix[j][i] != 0) {
                i++;
                j--;
            }

            if(i == n) {
                i = 0;
            }

            if(j == -1) {
                j = n - 1;
            }

            if(matrix[j][i] != 0) {
                i = i_;
                j = j_ + 1;
            }

            if(j == n) {
                j = 0;
            }

            matrix[j][i] = k;
        }

        return matrix;
    }

    private int[][] getOdd_2(int n) {
        int N = 2 * n - 1;
        int[][] matrix_1 = new int[N][N];
        int[][] matrix_2 = new int[n][n];

        setZero(matrix_1, N);
        setZero(matrix_2, n);

        int K = n * n + 1;
        int j = 0, j_;
        int i = N / 2, i_;
        int count = 0;

        i_ = i;
        j_ = j;
        for (int k = 1; k  < K; k++) {
            matrix_1[j][i] = k;

            if(++count == n) {
                i = i_ - 1;
                j = j_ + 1;

                i_ = i;
                j_ = j;

                count = 0;
            }
            else {
                i++;
                j++;
            }
        }

        int temp;
        int gap = (n-1) / 2;

        for (j = 0; j < gap; j++) {
            for (i = 0; i < N; i++) {
                temp = matrix_1[j][i];
                if (temp != 0) {
                    matrix_1[j + n][i] = temp;
                }
            }
        }

        for (j = N - gap; j < N; j++) {
            for (i = 0; i < N; i++) {
                temp = matrix_1[j][i];
                if (temp != 0) {
                    matrix_1[j - n][i] = temp;
                }
            }
        }

        for (i = 0; i < gap; i++) {
            for (j = 0; j < N; j++) {
                temp = matrix_1[j][i];
                if (temp != 0) {
                    matrix_1[j][i + n] = temp;
                }
            }
        }

        for (i = N - gap; i < N; i++) {
            for (j = 0; j < N; j++) {
                temp = matrix_1[j][i];
                if (temp != 0) {
                    matrix_1[j][i - n] = temp;
                }
            }
        }

        for(j = 0; j < n; j++) {
            for(i = 0; i < n; i++) {
                matrix_2[j][i] = matrix_1[j + gap][i + gap];
            }
        }

        return matrix_2;
    }

    private int getMagicK(int n) {
        return n * (n * n + 1) / 2;
    }

    private void setZero(int[][] matrix, int n) {
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < n; i++) {
                matrix[j][i] = 0;
            }
        }
    }

    private void put() {
        for(int j = 0; j < this.myOrder.get(); j++) {
            for(int i = 0; i < this.myOrder.get(); i++) {
                this.fields[j][i].setText(String.valueOf(this.matrix[j][i]));
            }
        }
    }
}