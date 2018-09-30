package com.example.fragmenthomework;

import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by ${Aina} on 24.09.2018.
 */
public class EditDialog extends DialogFragment {
    DataTransmitter myDataTransmitter;
    EditText etLogin;
    EditText etEmail;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            myDataTransmitter = (DataTransmitter) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragment1DataListener");
        }
    }

    @NonNull
    public android.app.Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        super.onCreateDialog(saveInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_edit, null);
        etLogin = view.findViewById(R.id.et_Login);
        etEmail = view.findViewById(R.id.et_Mail);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setTitle("fill").setView(view)
                .setPositiveButton("save", (dialog, which) -> {
                    String login = etLogin.getText().toString();
                    String eMail = etEmail.getText().toString();
                    myDataTransmitter.transmitter(login, eMail);

                })

                .setNegativeButton("dismiss", (dialog, which) -> dismiss());
        return adb.show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myDataTransmitter = null;
    }
}
