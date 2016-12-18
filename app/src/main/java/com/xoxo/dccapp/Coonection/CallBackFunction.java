package com.xoxo.dccapp.Coonection;



import java.io.InputStream;
import java.util.List;

/**
 * Created by danieloduonye on 12/18/16.
 */

public interface CallBackFunction {
    void success(InputStream stream);
    void error();
}
