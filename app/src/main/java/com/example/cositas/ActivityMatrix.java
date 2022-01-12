package com.example.cositas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityMatrix extends AppCompatActivity {
    private final int count_panels = 3;
    public final int maxSize = 5;

    public final int[] id_panels = {
            R.id.LinearL_wrapper_sum,
            R.id.LinearL_wrapper_mul,
            R.id.LinearL_wrapper_inv
    };

    private final int[][] id_sumRows = {
            {
                    R.id.LinearL_sum_matrix_A_fields_row1,
                    R.id.LinearL_sum_matrix_A_fields_row2,
                    R.id.LinearL_sum_matrix_A_fields_row3,
                    R.id.LinearL_sum_matrix_A_fields_row4,
                    R.id.LinearL_sum_matrix_A_fields_row5
            },
            {
                    R.id.LinearL_sum_matrix_B_fields_row1,
                    R.id.LinearL_sum_matrix_B_fields_row2,
                    R.id.LinearL_sum_matrix_B_fields_row3,
                    R.id.LinearL_sum_matrix_B_fields_row4,
                    R.id.LinearL_sum_matrix_B_fields_row5
            },
            {
                    R.id.LinearL_sum_matrix_C_fields_row1,
                    R.id.LinearL_sum_matrix_C_fields_row2,
                    R.id.LinearL_sum_matrix_C_fields_row3,
                    R.id.LinearL_sum_matrix_C_fields_row4,
                    R.id.LinearL_sum_matrix_C_fields_row5
            }
    };

    private final int[][] id_mulRows = {
            {
                    R.id.LinearL_mul_matrix_A_fields_row1,
                    R.id.LinearL_mul_matrix_A_fields_row2,
                    R.id.LinearL_mul_matrix_A_fields_row3,
                    R.id.LinearL_mul_matrix_A_fields_row4,
                    R.id.LinearL_mul_matrix_A_fields_row5
            },
            {
                    R.id.LinearL_mul_matrix_B_fields_row1,
                    R.id.LinearL_mul_matrix_B_fields_row2,
                    R.id.LinearL_mul_matrix_B_fields_row3,
                    R.id.LinearL_mul_matrix_B_fields_row4,
                    R.id.LinearL_mul_matrix_B_fields_row5
            },
            {
                    R.id.LinearL_mul_matrix_C_fields_row1,
                    R.id.LinearL_mul_matrix_C_fields_row2,
                    R.id.LinearL_mul_matrix_C_fields_row3,
                    R.id.LinearL_mul_matrix_C_fields_row4,
                    R.id.LinearL_mul_matrix_C_fields_row5
            }
    };

    private final int[][] id_invRows = {
            {
                    R.id.LinearL_inv_matrix_1_fields_row1,
                    R.id.LinearL_inv_matrix_1_fields_row2,
                    R.id.LinearL_inv_matrix_1_fields_row3,
                    R.id.LinearL_inv_matrix_1_fields_row4,
                    R.id.LinearL_inv_matrix_1_fields_row5
            },
            {
                    R.id.LinearL_inv_matrix_2_fields_row1,
                    R.id.LinearL_inv_matrix_2_fields_row2,
                    R.id.LinearL_inv_matrix_2_fields_row3,
                    R.id.LinearL_inv_matrix_2_fields_row4,
                    R.id.LinearL_inv_matrix_2_fields_row5
            }
    };

    private final int[][][] id_sumFields = {
            {
                    {
                            R.id.LinearL_sum_matrix_A_field_1_1,
                            R.id.LinearL_sum_matrix_A_field_1_2,
                            R.id.LinearL_sum_matrix_A_field_1_3,
                            R.id.LinearL_sum_matrix_A_field_1_4,
                            R.id.LinearL_sum_matrix_A_field_1_5
                    },
                    {
                            R.id.LinearL_sum_matrix_A_field_2_1,
                            R.id.LinearL_sum_matrix_A_field_2_2,
                            R.id.LinearL_sum_matrix_A_field_2_3,
                            R.id.LinearL_sum_matrix_A_field_2_4,
                            R.id.LinearL_sum_matrix_A_field_2_5
                    },
                    {
                            R.id.LinearL_sum_matrix_A_field_3_1,
                            R.id.LinearL_sum_matrix_A_field_3_2,
                            R.id.LinearL_sum_matrix_A_field_3_3,
                            R.id.LinearL_sum_matrix_A_field_3_4,
                            R.id.LinearL_sum_matrix_A_field_3_5
                    },
                    {
                            R.id.LinearL_sum_matrix_A_field_4_1,
                            R.id.LinearL_sum_matrix_A_field_4_2,
                            R.id.LinearL_sum_matrix_A_field_4_3,
                            R.id.LinearL_sum_matrix_A_field_4_4,
                            R.id.LinearL_sum_matrix_A_field_4_5
                    },
                    {
                            R.id.LinearL_sum_matrix_A_field_5_1,
                            R.id.LinearL_sum_matrix_A_field_5_2,
                            R.id.LinearL_sum_matrix_A_field_5_3,
                            R.id.LinearL_sum_matrix_A_field_5_4,
                            R.id.LinearL_sum_matrix_A_field_5_5
                    }
            },
            {
                    {
                            R.id.LinearL_sum_matrix_B_field_1_1,
                            R.id.LinearL_sum_matrix_B_field_1_2,
                            R.id.LinearL_sum_matrix_B_field_1_3,
                            R.id.LinearL_sum_matrix_B_field_1_4,
                            R.id.LinearL_sum_matrix_B_field_1_5
                    },
                    {
                            R.id.LinearL_sum_matrix_B_field_2_1,
                            R.id.LinearL_sum_matrix_B_field_2_2,
                            R.id.LinearL_sum_matrix_B_field_2_3,
                            R.id.LinearL_sum_matrix_B_field_2_4,
                            R.id.LinearL_sum_matrix_B_field_2_5
                    },
                    {
                            R.id.LinearL_sum_matrix_B_field_3_1,
                            R.id.LinearL_sum_matrix_B_field_3_2,
                            R.id.LinearL_sum_matrix_B_field_3_3,
                            R.id.LinearL_sum_matrix_B_field_3_4,
                            R.id.LinearL_sum_matrix_B_field_3_5
                    },
                    {
                            R.id.LinearL_sum_matrix_B_field_4_1,
                            R.id.LinearL_sum_matrix_B_field_4_2,
                            R.id.LinearL_sum_matrix_B_field_4_3,
                            R.id.LinearL_sum_matrix_B_field_4_4,
                            R.id.LinearL_sum_matrix_B_field_4_5
                    },
                    {
                            R.id.LinearL_sum_matrix_B_field_5_1,
                            R.id.LinearL_sum_matrix_B_field_5_2,
                            R.id.LinearL_sum_matrix_B_field_5_3,
                            R.id.LinearL_sum_matrix_B_field_5_4,
                            R.id.LinearL_sum_matrix_B_field_5_5
                    }
            },
            {
                    {
                            R.id.LinearL_sum_matrix_C_field_1_1,
                            R.id.LinearL_sum_matrix_C_field_1_2,
                            R.id.LinearL_sum_matrix_C_field_1_3,
                            R.id.LinearL_sum_matrix_C_field_1_4,
                            R.id.LinearL_sum_matrix_C_field_1_5
                    },
                    {
                            R.id.LinearL_sum_matrix_C_field_2_1,
                            R.id.LinearL_sum_matrix_C_field_2_2,
                            R.id.LinearL_sum_matrix_C_field_2_3,
                            R.id.LinearL_sum_matrix_C_field_2_4,
                            R.id.LinearL_sum_matrix_C_field_2_5
                    },
                    {
                            R.id.LinearL_sum_matrix_C_field_3_1,
                            R.id.LinearL_sum_matrix_C_field_3_2,
                            R.id.LinearL_sum_matrix_C_field_3_3,
                            R.id.LinearL_sum_matrix_C_field_3_4,
                            R.id.LinearL_sum_matrix_C_field_3_5
                    },
                    {
                            R.id.LinearL_sum_matrix_C_field_4_1,
                            R.id.LinearL_sum_matrix_C_field_4_2,
                            R.id.LinearL_sum_matrix_C_field_4_3,
                            R.id.LinearL_sum_matrix_C_field_4_4,
                            R.id.LinearL_sum_matrix_C_field_4_5
                    },
                    {
                            R.id.LinearL_sum_matrix_C_field_5_1,
                            R.id.LinearL_sum_matrix_C_field_5_2,
                            R.id.LinearL_sum_matrix_C_field_5_3,
                            R.id.LinearL_sum_matrix_C_field_5_4,
                            R.id.LinearL_sum_matrix_C_field_5_5
                    }
            }
    };

    private final int[][][] id_mulFields = {
            {
                    {
                            R.id.LinearL_mul_matrix_A_field_1_1,
                            R.id.LinearL_mul_matrix_A_field_1_2,
                            R.id.LinearL_mul_matrix_A_field_1_3,
                            R.id.LinearL_mul_matrix_A_field_1_4,
                            R.id.LinearL_mul_matrix_A_field_1_5
                    },
                    {
                            R.id.LinearL_mul_matrix_A_field_2_1,
                            R.id.LinearL_mul_matrix_A_field_2_2,
                            R.id.LinearL_mul_matrix_A_field_2_3,
                            R.id.LinearL_mul_matrix_A_field_2_4,
                            R.id.LinearL_mul_matrix_A_field_2_5
                    },
                    {
                            R.id.LinearL_mul_matrix_A_field_3_1,
                            R.id.LinearL_mul_matrix_A_field_3_2,
                            R.id.LinearL_mul_matrix_A_field_3_3,
                            R.id.LinearL_mul_matrix_A_field_3_4,
                            R.id.LinearL_mul_matrix_A_field_3_5
                    },
                    {
                            R.id.LinearL_mul_matrix_A_field_4_1,
                            R.id.LinearL_mul_matrix_A_field_4_2,
                            R.id.LinearL_mul_matrix_A_field_4_3,
                            R.id.LinearL_mul_matrix_A_field_4_4,
                            R.id.LinearL_mul_matrix_A_field_4_5
                    },
                    {
                            R.id.LinearL_mul_matrix_A_field_5_1,
                            R.id.LinearL_mul_matrix_A_field_5_2,
                            R.id.LinearL_mul_matrix_A_field_5_3,
                            R.id.LinearL_mul_matrix_A_field_5_4,
                            R.id.LinearL_mul_matrix_A_field_5_5
                    }
            },
            {
                    {
                            R.id.LinearL_mul_matrix_B_field_1_1,
                            R.id.LinearL_mul_matrix_B_field_1_2,
                            R.id.LinearL_mul_matrix_B_field_1_3,
                            R.id.LinearL_mul_matrix_B_field_1_4,
                            R.id.LinearL_mul_matrix_B_field_1_5
                    },
                    {
                            R.id.LinearL_mul_matrix_B_field_2_1,
                            R.id.LinearL_mul_matrix_B_field_2_2,
                            R.id.LinearL_mul_matrix_B_field_2_3,
                            R.id.LinearL_mul_matrix_B_field_2_4,
                            R.id.LinearL_mul_matrix_B_field_2_5
                    },
                    {
                            R.id.LinearL_mul_matrix_B_field_3_1,
                            R.id.LinearL_mul_matrix_B_field_3_2,
                            R.id.LinearL_mul_matrix_B_field_3_3,
                            R.id.LinearL_mul_matrix_B_field_3_4,
                            R.id.LinearL_mul_matrix_B_field_3_5
                    },
                    {
                            R.id.LinearL_mul_matrix_B_field_4_1,
                            R.id.LinearL_mul_matrix_B_field_4_2,
                            R.id.LinearL_mul_matrix_B_field_4_3,
                            R.id.LinearL_mul_matrix_B_field_4_4,
                            R.id.LinearL_mul_matrix_B_field_4_5
                    },
                    {
                            R.id.LinearL_mul_matrix_B_field_5_1,
                            R.id.LinearL_mul_matrix_B_field_5_2,
                            R.id.LinearL_mul_matrix_B_field_5_3,
                            R.id.LinearL_mul_matrix_B_field_5_4,
                            R.id.LinearL_mul_matrix_B_field_5_5
                    }
            },
            {
                    {
                            R.id.LinearL_mul_matrix_C_field_1_1,
                            R.id.LinearL_mul_matrix_C_field_1_2,
                            R.id.LinearL_mul_matrix_C_field_1_3,
                            R.id.LinearL_mul_matrix_C_field_1_4,
                            R.id.LinearL_mul_matrix_C_field_1_5
                    },
                    {
                            R.id.LinearL_mul_matrix_C_field_2_1,
                            R.id.LinearL_mul_matrix_C_field_2_2,
                            R.id.LinearL_mul_matrix_C_field_2_3,
                            R.id.LinearL_mul_matrix_C_field_2_4,
                            R.id.LinearL_mul_matrix_C_field_2_5
                    },
                    {
                            R.id.LinearL_mul_matrix_C_field_3_1,
                            R.id.LinearL_mul_matrix_C_field_3_2,
                            R.id.LinearL_mul_matrix_C_field_3_3,
                            R.id.LinearL_mul_matrix_C_field_3_4,
                            R.id.LinearL_mul_matrix_C_field_3_5
                    },
                    {
                            R.id.LinearL_mul_matrix_C_field_4_1,
                            R.id.LinearL_mul_matrix_C_field_4_2,
                            R.id.LinearL_mul_matrix_C_field_4_3,
                            R.id.LinearL_mul_matrix_C_field_4_4,
                            R.id.LinearL_mul_matrix_C_field_4_5
                    },
                    {
                            R.id.LinearL_mul_matrix_C_field_5_1,
                            R.id.LinearL_mul_matrix_C_field_5_2,
                            R.id.LinearL_mul_matrix_C_field_5_3,
                            R.id.LinearL_mul_matrix_C_field_5_4,
                            R.id.LinearL_mul_matrix_C_field_5_5
                    }
            }
    };

    private final int[][][] id_invFields = {
            {
                    {
                            R.id.LinearL_inv_matrix_1_field_1_1,
                            R.id.LinearL_inv_matrix_1_field_1_2,
                            R.id.LinearL_inv_matrix_1_field_1_3,
                            R.id.LinearL_inv_matrix_1_field_1_4,
                            R.id.LinearL_inv_matrix_1_field_1_5,
                    },
                    {
                            R.id.LinearL_inv_matrix_1_field_2_1,
                            R.id.LinearL_inv_matrix_1_field_2_2,
                            R.id.LinearL_inv_matrix_1_field_2_3,
                            R.id.LinearL_inv_matrix_1_field_2_4,
                            R.id.LinearL_inv_matrix_1_field_2_5,
                    },
                    {
                            R.id.LinearL_inv_matrix_1_field_3_1,
                            R.id.LinearL_inv_matrix_1_field_3_2,
                            R.id.LinearL_inv_matrix_1_field_3_3,
                            R.id.LinearL_inv_matrix_1_field_3_4,
                            R.id.LinearL_inv_matrix_1_field_3_5,
                    },
                    {
                            R.id.LinearL_inv_matrix_1_field_4_1,
                            R.id.LinearL_inv_matrix_1_field_4_2,
                            R.id.LinearL_inv_matrix_1_field_4_3,
                            R.id.LinearL_inv_matrix_1_field_4_4,
                            R.id.LinearL_inv_matrix_1_field_4_5,
                    },
                    {
                            R.id.LinearL_inv_matrix_1_field_5_1,
                            R.id.LinearL_inv_matrix_1_field_5_2,
                            R.id.LinearL_inv_matrix_1_field_5_3,
                            R.id.LinearL_inv_matrix_1_field_5_4,
                            R.id.LinearL_inv_matrix_1_field_5_5,
                    }
            },
            {
                    {
                            R.id.LinearL_inv_matrix_2_field_1_1,
                            R.id.LinearL_inv_matrix_2_field_1_2,
                            R.id.LinearL_inv_matrix_2_field_1_3,
                            R.id.LinearL_inv_matrix_2_field_1_4,
                            R.id.LinearL_inv_matrix_2_field_1_5,
                    },
                    {
                            R.id.LinearL_inv_matrix_2_field_2_1,
                            R.id.LinearL_inv_matrix_2_field_2_2,
                            R.id.LinearL_inv_matrix_2_field_2_3,
                            R.id.LinearL_inv_matrix_2_field_2_4,
                            R.id.LinearL_inv_matrix_2_field_2_5,
                    },
                    {
                            R.id.LinearL_inv_matrix_2_field_3_1,
                            R.id.LinearL_inv_matrix_2_field_3_2,
                            R.id.LinearL_inv_matrix_2_field_3_3,
                            R.id.LinearL_inv_matrix_2_field_3_4,
                            R.id.LinearL_inv_matrix_2_field_3_5,
                    },
                    {
                            R.id.LinearL_inv_matrix_2_field_4_1,
                            R.id.LinearL_inv_matrix_2_field_4_2,
                            R.id.LinearL_inv_matrix_2_field_4_3,
                            R.id.LinearL_inv_matrix_2_field_4_4,
                            R.id.LinearL_inv_matrix_2_field_4_5,
                    },
                    {
                            R.id.LinearL_inv_matrix_2_field_5_1,
                            R.id.LinearL_inv_matrix_2_field_5_2,
                            R.id.LinearL_inv_matrix_2_field_5_3,
                            R.id.LinearL_inv_matrix_2_field_5_4,
                            R.id.LinearL_inv_matrix_2_field_5_5,
                    }
            }
    };

    public LinearLayout[] panels = new LinearLayout[count_panels];

    public LinearLayout[][] sumRows = new LinearLayout[3][maxSize];
    public ViewGroup[][][] sumFields = new ViewGroup[3][maxSize][maxSize];

    public LinearLayout[][] mulRows = new LinearLayout[3][maxSize];
    public ViewGroup[][][] mulFields = new ViewGroup[3][maxSize][maxSize];

    public LinearLayout[][] invRows = new LinearLayout[2][maxSize];
    public ViewGroup[][][] invFields = new ViewGroup[2][maxSize][maxSize];

    public MyInteger count_sumRows = new MyInteger(2);
    public MyInteger count_sumCols = new MyInteger(2);

    public MyInteger count_mulRows = new MyInteger(2);
    public MyInteger count_mulCommon = new MyInteger(2);
    public MyInteger count_mulCols = new MyInteger(2);

    public MyInteger count_invSize = new MyInteger(2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        int i, j, k;
        for (i = 0; i < count_panels; i++) {
            panels[i] = findViewById(id_panels[i]);
        }

        for (k = 0; k < 3; k++) {
            for (j = 0; j < maxSize; j++) {
                sumRows[k][j] = findViewById(id_sumRows[k][j]);
                mulRows[k][j] = findViewById(id_mulRows[k][j]);

                for (i = 0; i < maxSize; i++) {
                    sumFields[k][j][i] = findViewById(id_sumFields[k][j][i]);
                    mulFields[k][j][i] = findViewById(id_mulFields[k][j][i]);
                }
            }
        }

        for (k = 0; k < 2; k++) {
            for (j = 0; j < maxSize; j++) {
                invRows[k][j] = findViewById(id_invRows[k][j]);

                for (i = 0; i < maxSize; i++) {
                    invFields[k][j][i] = findViewById(id_invFields[k][j][i]);
                }
            }
        }

        new RadioButtonMatrix(findViewById(R.id.radioButton_sum_mat));
        new RadioButtonMatrix(findViewById(R.id.radioButton_mul_mat));
        new RadioButtonMatrix(findViewById(R.id.radioButton_inv_mat));

        new EditSumDimension(this, findViewById(R.id.editTextNumber_sum_rows), 1, maxSize);
        new EditSumDimension(this, findViewById(R.id.editTextNumber_sum_cols), 1, maxSize);

        new EditMulDimension(this, findViewById(R.id.editTextNumber_mul_rows), 1, maxSize);
        new EditMulDimension(this, findViewById(R.id.editTextNumber_mul_common), 1, maxSize);
        new EditMulDimension(this, findViewById(R.id.editTextNumber_mul_cols), 1, maxSize);

        new EditInvDimension(this, findViewById(R.id.editTextNumber_inv_rows), 1, maxSize);

        new ButtonTranspose(findViewById(R.id.imgB_traspose));

        new ButtonSumMatrix(findViewById(R.id.button_matrix_sum));
        new ButtonSumMatrix(findViewById(R.id.button_matrix_sub));

        new ButtonMulMatrix(findViewById(R.id.button_matrix_mul));

        new ButtonInvMatrix(findViewById(R.id.button_matrix_inv));

        new ButtonResetMatrix(findViewById(R.id.button_sum_matrix_A), sumFields[0]);
        new ButtonResetMatrix(findViewById(R.id.button_sum_matrix_B), sumFields[1]);

        new ButtonResetMatrix(findViewById(R.id.button_mul_matrix_A), mulFields[0]);
        new ButtonResetMatrix(findViewById(R.id.button_mul_matrix_B), mulFields[1]);

        new ButtonResetMatrix(findViewById(R.id.button_inv_matrix_1), invFields[0]);

        new ButtonBack(findViewById(R.id.imgB_back));
    }

    private void setVisibility(int index) {
        int i, j, rows, cols;
        LinearLayout[] row;
        ViewGroup[][] fields;

        switch (index) {
            case 0:
                rows = this.count_sumRows.get();
                cols = this.count_sumCols.get();
                row = sumRows[0];
                fields = sumFields[0];
                break;
            case 1:
                rows = this.count_sumRows.get();
                cols = this.count_sumCols.get();
                row = sumRows[1];
                fields = sumFields[1];
                break;
            case 2:
                rows = this.count_sumRows.get();
                cols = this.count_sumCols.get();
                row = sumRows[2];
                fields = sumFields[2];
                break;
            case 3:
                rows = this.count_mulRows.get();
                cols = this.count_mulCommon.get();
                row = mulRows[0];
                fields = mulFields[0];
                break;
            case 4:
                rows = this.count_mulCommon.get();
                cols = this.count_mulCols.get();
                row = mulRows[1];
                fields = mulFields[1];
                break;
            case 5:
                rows = this.count_mulRows.get();
                cols = this.count_mulCols.get();
                row = mulRows[2];
                fields = mulFields[2];
                break;
            case 6:
                rows = this.count_invSize.get();
                cols = this.count_invSize.get();
                row = invRows[0];
                fields = invFields[0];
                break;
            case 7:
                rows = this.count_invSize.get();
                cols = this.count_invSize.get();
                row = invRows[1];
                fields = invFields[1];
                break;
            default:
                return;
        }

        for (j = 0; j < rows; j++) {
            for (i = 0; i < cols; i++) {
                fields[j][i].setVisibility(View.VISIBLE);
            }

            for (i = cols; i < maxSize; i++) {
                fields[j][i].setVisibility(View.GONE);
            }

            row[j].setVisibility(View.VISIBLE);
        }

        for (j = rows; j < maxSize; j++) {
            row[j].setVisibility(View.GONE);
        }
    }

    public void setSumVisibility() {
        setVisibility(0);
        setVisibility(1);
        setVisibility(2);
    }

    public void setMulVisibility() {
        setVisibility(3);
        setVisibility(4);
        setVisibility(5);
    }

    public void setInvVisibility() {
        setVisibility(6);
        setVisibility(7);
    }

    public MyMatrix getMatrix(int index) {
        MyMatrix matrix;

        int rows, cols;
        ViewGroup[][] fields;
        switch (index) {
            case 0:
                rows = this.count_sumRows.get();
                cols = this.count_sumCols.get();
                fields = sumFields[0];
                break;
            case 1:
                rows = this.count_sumRows.get();
                cols = this.count_sumCols.get();
                fields = sumFields[1];
                break;
            case 2:
                rows = this.count_mulRows.get();
                cols = this.count_mulCommon.get();
                fields = mulFields[0];
                break;
            case 3:
                rows = this.count_mulCommon.get();
                cols = this.count_mulCols.get();
                fields = mulFields[1];
                break;
            case 4:
                rows = this.count_invSize.get();
                cols = this.count_invSize.get();
                fields = invFields[0];
                break;
            default:
                return null;
        }

        matrix = new MyMatrix(rows, cols);

        MyDouble temp = new MyDouble(0.0);

        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                EditText edit = (EditText) fields[j][i].getChildAt(0);

                if(temp.parse(edit.getText().toString())) {
                    temp.set(0.0);
                    edit.setText("");
                }

                matrix.set(j, i, temp.get());
            }
        }

        return matrix;
    }

    public void setMatrix(int index, MyMatrix matrix) {
        int rows, cols;
        ViewGroup[][] fields;
        switch (index) {
            case 0:
                rows = this.count_sumRows.get();
                cols = this.count_sumCols.get();
                fields = sumFields[2];
                break;
            case 1:
                rows = this.count_mulRows.get();
                cols = this.count_mulCols.get();
                fields = mulFields[2];
                break;
            case 2:
                rows = this.count_invSize.get();
                cols = this.count_invSize.get();
                fields = invFields[1];
                break;
            default:
                return;
        }

        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                TextView edit = (TextView) fields[j][i].getChildAt(0);
                edit.setText(String.valueOf(matrix.get(j, i)));
            }
        }
    }
}