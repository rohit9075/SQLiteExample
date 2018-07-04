package com.rohit.sqliteexample.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class InputValidation {

     private Context context;

        public InputValidation(Context context) {
            this.context = context;
        }
        public boolean isEditTextFilled(EditText editText, String message) {
            String value = editText.getText().toString().trim();
            if (value.isEmpty()) {
                editText.setError(message);
                hideKeyboardFrom(editText);
                return false;
            }
            return true;
        }
        public boolean isEditTextEmail(EditText editText, String message) {
            String value = editText.getText().toString().trim();
            if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
                editText.setError(message);
                hideKeyboardFrom(editText);
                return false;
            }  //            textInputLayout.setErrorEnabled(false);

            return true;
        }

        public boolean isMobileNumberCorrect(EditText editText, String message) {
            String mobileNo = editText.getText().toString().trim();
            if (mobileNo.isEmpty()||(mobileNo.length()!=10)) {
                editText.setError(message);
                hideKeyboardFrom(editText);
                return false;
            }


            return true;
        }


        public boolean isEditTextMatches(EditText editText1, EditText editText2, String message) {
            String value1 = editText1.getText().toString().trim();
            String value2 = editText2.getText().toString().trim();
            if (!value1.contentEquals(value2)) {
                editText2.setError(message);
                hideKeyboardFrom(editText2);
                return false;
            }

            return true;
        }

        private void hideKeyboardFrom(View view) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }

    public boolean isTextInputEditTextFilled(EditText editText, String message) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            editText.setError(message);
            hideKeyboardFrom(editText);
            return false;
        }

        return true;
    }





}
