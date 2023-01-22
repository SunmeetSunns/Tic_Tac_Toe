package com.example.tic_tac_toe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;


public class WinDialog extends Dialog  {
    private final String message;
    private final MainActivity mainActivity;
    public WinDialog(@NonNull Context context, String message,MainActivity mainActivity) {
        super(context);
        this.message=message;
        this.mainActivity=mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_ayout);
        final TextView msgText =findViewById(R.id.message);
        final Button StartAgnButton=findViewById(R.id.StartAgnBtn);
        msgText.setText(message);
        StartAgnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restartMatch();
                dismiss();

            }
        });
    }
}
