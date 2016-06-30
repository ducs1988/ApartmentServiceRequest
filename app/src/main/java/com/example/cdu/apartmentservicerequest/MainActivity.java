package com.example.cdu.apartmentservicerequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when Submit button is clicked
     *
     * @param view
     */
    public void submitForm(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        String name = nameEditText.getText().toString();

        EditText aptEditText = (EditText) findViewById(R.id.apt_edit_text);
        String apt = aptEditText.getText().toString();

        Spinner prioritySpinner = (Spinner) findViewById(R.id.priority_spinner);
        String priority = String.valueOf(prioritySpinner.getSelectedItem());

        Spinner categorySpinner = (Spinner) findViewById(R.id.category_spinner);
        String category = String.valueOf(categorySpinner.getSelectedItem());

        EditText fullDescEditText = (EditText) findViewById(R.id.full_desc_edit_text);
        String fullDesc = fullDescEditText.getText().toString();

        EditText accessEditText = (EditText) findViewById(R.id.access_edit_text);
        String access = accessEditText.getText().toString();

        CheckBox permCheckBox = (CheckBox) findViewById(R.id.permission_checkbox);
        boolean hasPermission = permCheckBox.isChecked();

        String finalMessage = createSubmitForm(name, apt, priority, category, fullDesc, access, hasPermission);

        processMessage(finalMessage);
    }

    /**
     * Display the submitted message, TODO: toggle Intent to sent out email
     *
     * @param finalMessage
     */
    private void processMessage(String finalMessage) {
        TextView summaryTextView = (TextView) findViewById(R.id.summary_text_view);
        summaryTextView.setText(finalMessage);
    }

    /**
     * Construct submit form message
     *
     * @param name
     * @param apt
     * @param priority
     * @param category
     * @param fullDesc
     * @param access
     * @param hasPermission
     * @return
     */
    private String createSubmitForm(String name, String apt, String priority, String category, String fullDesc, String access, boolean hasPermission) {
        String msg = "Name: " + name;
        msg += "\nUnit: " + apt;
        msg += "\nPriority: " + priority;
        msg += "\nCategory: " + category;
        msg += "\nFull Description:";
        msg += "\n" + fullDesc;
        msg += "\nAccess Detail:";
        msg += "\n" + access;
        msg += "\nPermission to access: " + hasPermission;

        return msg;
    }
}
