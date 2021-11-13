package com.patrickbanez.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.patrickbanez.workoutapp.User.Goal;
import com.patrickbanez.workoutapp.User.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateUserActivity extends AppCompatActivity {
    // Issues the user's identification number associated with their account. I'll be saving this value
    // to a file and read it everytime a user is created so it does not restart everytime the app restarts.
    // Increments with each user;
    private static long UID = 0;

    private final String TITLE = "Create Account";

    private EditText firstNameField;
    private EditText lastNameField;
    private EditText emailField;
    private EditText ageField;
    private EditText heightFeetField;
    private EditText heightInchField;
    private EditText weightField;
    private RadioGroup fitnessGoals;
    private Context context;
    private Intent mainActivity;
    private boolean created;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        setTitle(TITLE);

        firstNameField = findViewById(R.id.firstNameField);
        firstNameField.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

        lastNameField = findViewById(R.id.lastNameField);
        lastNameField.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

        emailField = findViewById(R.id.emailField);
        emailField.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        ageField = findViewById(R.id.ageField);
        ageField.setInputType(InputType.TYPE_CLASS_NUMBER);

        heightFeetField = findViewById(R.id.heightFtField);
        heightFeetField.setInputType(InputType.TYPE_CLASS_NUMBER);

        heightInchField = findViewById(R.id.heightInField);
        heightInchField.setInputType(InputType.TYPE_CLASS_NUMBER);

        weightField = findViewById(R.id.weightField);
        weightField.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        fitnessGoals = (RadioGroup) findViewById(R.id.radioGroup);
        context = getApplicationContext();
        mainActivity = new Intent(this, MainActivity.class);
        created = false;
    }

    public void create(View v) {
        // Verify the required fields are filled correctly
        if (firstNameField.getText().length() < 1 || lastNameField.getText().length() < 1) {
            Toast.makeText(context, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!isEmailValid(emailField.getText().toString())) {
            Toast.makeText(context, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        // Creating user
        String firstName = this.firstNameField.getText().toString();
        String lastName = lastNameField.getText().toString();
        String email = emailField.getText().toString();
        RadioButton radioGoal = (RadioButton) findViewById(fitnessGoals.getCheckedRadioButtonId());
        // Weight loss goal by default
        Goal goal = Goal.WEIGHT_LOSS;
        if (radioGoal.getText().toString().equals(getString(R.string.muscle_building_text))) {
            goal = Goal.MUSCLE_BUILDING;
        } else if (radioGoal.getText().toString().equals(getString(R.string.strength_building_text))) {
            goal = Goal.STRENGTH_BUILDING;
        } else {
            goal = Goal.MAINTENANCE;
        }
        String newUID = "WORK" + Long.toString(UID);
        UID++;
        User newUser = new User(firstName, lastName, email, goal, newUID);

        // Verify user was created
        if (newUser != null && newUser.getFirstName().equals(firstName) && newUser.getLastName().equals(lastName)
                && newUser.getEmail().equals(email)) {
            created = true;
        } else {
            Toast.makeText(getApplicationContext(), "Profile Creation Failed!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Add optional fields to the new user
        String temp = ageField.getText().toString();
        if (!temp.equals("")) {
            int age = Integer.parseInt(temp);
            newUser.setAge(age);
        }

        temp = heightFeetField.getText().toString();
        if (!temp.equals("")) {
            int heightFt = Integer.parseInt(temp);
            newUser.setHeightFt(heightFt);
        }

        temp = heightInchField.getText().toString();
        if (!temp.equals("")) {
            int heightIn = Integer.parseInt(temp);
            newUser.setHeightIn(heightIn);
        }

        temp = weightField.getText().toString();
        if (!temp.equals("")) {
            double weight = Double.parseDouble(temp);
            newUser.setWeight(weight);
        }

        if (created) {
            Toast.makeText(getApplicationContext(), "Profile Created! Your goal is "
                    + newUser.getGoal().toString() + "!", Toast.LENGTH_SHORT).show();
            ((Button)findViewById(R.id.createButton)).setActivated(false);
            Handler handler = new Handler();
            // Wait 1 second after creating user, then go to MainActivity. This can be removed, it just
            // feels like a smoother transition.
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(mainActivity);
                    finish();
                }
            }, 1000);
        }
    }

    // https://stackoverflow.com/questions/6119722/how-to-check-edittexts-text-is-email-address-or-not
    /**
     * method is used for checking valid email id format.
     *
     * @param email
     * @return boolean true for valid false for invalid
     */
    private static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}