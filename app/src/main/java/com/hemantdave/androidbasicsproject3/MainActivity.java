package com.hemantdave.androidbasicsproject3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LinearLayout optionHolder;
    TextView questionHolder;
    String[] questions,answers,option_for_0th,option_for_1st,option_for_2nd,option_for_3rd,option_for_4th,option_for_5th,option_for_6th;
    RadioGroup grp;
    CheckBox answer_1_options_1,answer_1_options_2,answer_1_options_3,answer_1_options_4;
    ArrayList<String> checkedboxes=new ArrayList<>();
    EditText answer_0;
    Button score;
    int number=0,gameScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         optionHolder=(LinearLayout)findViewById(R.id.optionHolder);
         questions = getResources().getStringArray(R.array.Questions);
         answers = getResources().getStringArray(R.array.Answers);
         grp=new RadioGroup(getApplicationContext());
         score=(Button)findViewById(R.id.Score);

        /* This is the reference to questions residing in Q&As.xml*/
         option_for_0th=getResources().getStringArray(R.array.option_for_0th_question);
         option_for_1st=getResources().getStringArray(R.array.option_for_1st_question);
         option_for_2nd=getResources().getStringArray(R.array.option_for_2nd_question);
         option_for_3rd=getResources().getStringArray(R.array.option_for_3rd_question);
         option_for_4th=getResources().getStringArray(R.array.option_for_4th_question);
         option_for_5th=getResources().getStringArray(R.array.option_for_5th_question);
         option_for_6th=getResources().getStringArray(R.array.option_for_6th_question);

        score.setText("Score: 0");
         updateView();
    }

        /*Updating the Score*/
    public void updateScore(Boolean proceed){

        if(proceed){   /*Score is increased on ri8t answer*/
            gameScore++;
            score.setText("Score: "+gameScore);

        }else{      /* Reducing the Score on wrong answer*/
            gameScore--;
            score.setText("Score: "+gameScore);

        }


    }
    /*Checking answer*/
    public void checkAnswers(View v){

        switch (number){
            case 0:  /*Checking the answers for question 0*/
                int firstQuestionReply=Integer.parseInt(answer_0.getText().toString());

               if(firstQuestionReply!=0) {
                   if (firstQuestionReply == Integer.parseInt(answers[0])) {

                       updateScore(true);
                   } else {
                       if (gameScore > 0) {

                           updateScore(false);
                       }
                   }
               }
                break;
            case 1:  /*Checking the answers for question 1*/
                List<String> answer = new ArrayList<String>(Arrays.asList(answers[1].split(",")));
                if(checkedboxes.containsAll(answer)){

                    updateScore(true);
                }else{
                    if(gameScore>0) {

                        updateScore(false);
                    }
                }

                break;
            case 2:  /*Checking the answers for question 2*/
                int imageResponse=grp.getCheckedRadioButtonId();
                if(imageResponse==0){

                    updateScore(true);
                }else{
                    if(gameScore>0) {

                        updateScore(false);
                    }
                }
                break;


            case 3:  /*Checking the answers for question 3*/
                int thirdQuestionReply=grp.getCheckedRadioButtonId();
                if(thirdQuestionReply==0){

                    updateScore(true);
                }else{
                    if(gameScore>0) {

                        updateScore(false);
                    }
                }
                break;

            case 4: /*Checking the answers for question 4*/
                int fourthQuestionReply=grp.getCheckedRadioButtonId();
                if(fourthQuestionReply==1){

                    updateScore(true);
                }else{
                    if(gameScore>0) {

                        updateScore(false);
                    }
                }
                break;

            case 5:  /*Checking the answers for question 5*/
                int fifthQuestionReply=grp.getCheckedRadioButtonId();
                if(fifthQuestionReply==1){

                    updateScore(true);
                }else{
                    if(gameScore>0) {

                        updateScore(false);
                    }
                }
                break;
            case 6: /*Checking the answers for question 6*/
                int sixthQuestionReply=grp.getCheckedRadioButtonId();
                if(sixthQuestionReply==2){

                    updateScore(true);
                }else{
                    if(gameScore>0) {

                        updateScore(false);
                    }
                }
                break;

        }

    }
    /*Updating the View to nextQuestion*/
    public void nextQuestion(View v){
        number++;
        updateView();

    }
    /*Update view with options based on the number variable*/
    public void updateView(){
        final int optionindex=0;
        if(number<6) {
            questionHolder = (TextView) findViewById(R.id.questionTV);
            questionHolder.setText("Q.No."+number+"-> "+questions[number]);
            switch (number) {
                case 0:  /*Question 1 views*/
                    grp.removeAllViews();
                    optionHolder.removeAllViews();
                    answer_0 = new EditText(getApplicationContext());
                    answer_0.setText("0");
                    optionHolder.addView(answer_0);

                    break;

                case 1: /* Question 2 Views*/
                    grp.removeAllViews();
                    optionHolder.removeAllViews();


                    answer_1_options_1 = new CheckBox(getApplicationContext());
                    answer_1_options_1.setText(option_for_1st[optionindex]);
                    answer_1_options_1.setId(optionindex);
                    answer_1_options_1.setTextColor(Color.BLACK);
                    answer_1_options_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if(isChecked){
                                    checkedboxes.add(answer_1_options_1.getText().toString());
                                }else{
                                    checkedboxes.remove(optionindex);
                                }
                        }
                    });
                    optionHolder.addView(answer_1_options_1);

                    answer_1_options_2 = new CheckBox(getApplicationContext());
                    answer_1_options_2.setText(option_for_1st[optionindex+1]);
                    answer_1_options_2.setId(optionindex+1);
                    answer_1_options_2.setTextColor(Color.BLACK);
                    answer_1_options_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(isChecked){
                                checkedboxes.add(answer_1_options_2.getText().toString());
                            }else{
                                checkedboxes.remove(optionindex+1);
                            }
                        }
                    });
                    optionHolder.addView(answer_1_options_2);

                    answer_1_options_3 = new CheckBox(getApplicationContext());
                    answer_1_options_3.setText(option_for_1st[optionindex+2]);
                    answer_1_options_3.setId(optionindex+2);
                    answer_1_options_3.setTextColor(Color.BLACK);
                    answer_1_options_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(isChecked){
                                checkedboxes.add(answer_1_options_3.getText().toString());
                            }else{
                                checkedboxes.remove(optionindex+2);
                            }
                        }
                    });
                    optionHolder.addView(answer_1_options_3);

                    answer_1_options_4 = new CheckBox(getApplicationContext());
                    answer_1_options_4.setText(option_for_1st[optionindex+3]);
                    answer_1_options_4.setId(optionindex+3);
                    answer_1_options_4.setTextColor(Color.BLACK);
                    answer_1_options_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(isChecked){
                                checkedboxes.add(answer_1_options_4.getText().toString());
                            }else{
                                checkedboxes.remove(optionindex+3);
                            }
                        }
                    });
                    optionHolder.addView(answer_1_options_4);


                    break;


                case 2: /* Question 3 Views*/

                    grp.removeAllViews();
                    optionHolder.removeAllViews();

                    ImageView option_img = new ImageView(getApplicationContext());
                    option_img.setMaxHeight(200);
                    option_img.setImageResource(R.drawable.duck);
                    RadioButton answer_2_option_1 = new RadioButton(getApplicationContext());
                    answer_2_option_1.setId(optionindex);
                    answer_2_option_1.setText("Yes");
                    grp.addView(answer_2_option_1);
                    RadioButton answer_2_option_2 = new RadioButton(getApplicationContext());
                    answer_2_option_2.setId(optionindex+1);
                    answer_2_option_2.setText("No");
                    grp.addView(answer_2_option_2);
                    optionHolder.addView(grp);
                    optionHolder.addView(option_img);

                    break;
                case 3: /* Question 4 Views*/
                    grp.removeAllViews();
                    optionHolder.removeAllViews();


                    RadioButton answer_3_option_1 = new RadioButton(getApplicationContext());
                    answer_3_option_1.setText(option_for_3rd[optionindex]);
                    answer_3_option_1.setId(optionindex);
                    grp.addView(answer_3_option_1);


                    RadioButton answer_3_option_2 = new RadioButton(getApplicationContext());
                    answer_3_option_2.setText(option_for_3rd[optionindex+1]);
                    answer_3_option_2.setId(optionindex+1);
                    grp.addView(answer_3_option_2);


                    RadioButton answer_3_option_3 = new RadioButton(getApplicationContext());
                    answer_3_option_3.setText(option_for_3rd[optionindex+2]);
                    answer_3_option_3.setId(optionindex+2);
                    grp.addView(answer_3_option_3);


                    RadioButton answer_3_option_4 = new RadioButton(getApplicationContext());
                    answer_3_option_4.setText(option_for_3rd[optionindex+3]);
                    answer_3_option_4.setId(optionindex+3);
                    grp.addView(answer_3_option_4);
                    optionHolder.addView(grp);
                    break;

                case 4: /* Question 5 Views*/
                    grp.removeAllViews();
                    optionHolder.removeAllViews();

                    RadioButton answer_4_option_1 = new RadioButton(getApplicationContext());
                    answer_4_option_1.setText(option_for_4th[optionindex]);
                    answer_4_option_1.setId(optionindex);
                    grp.addView(answer_4_option_1);


                    RadioButton answer_4_option_2 = new RadioButton(getApplicationContext());
                    answer_4_option_2.setText(option_for_4th[optionindex+1]);
                    answer_4_option_2.setId(optionindex+1);
                    grp.addView(answer_4_option_2);


                    RadioButton answer_4_option_3 = new RadioButton(getApplicationContext());
                    answer_4_option_3.setText(option_for_4th[optionindex+2]);
                    answer_4_option_3.setId(optionindex+2);
                    grp.addView(answer_4_option_3);


                    RadioButton answer_4_option_4 = new RadioButton(getApplicationContext());
                    answer_4_option_4.setText(option_for_4th[optionindex+3]);
                    answer_4_option_4.setId(optionindex+3);
                    grp.addView(answer_4_option_4);
                    optionHolder.addView(grp);
                    break;

                case 5: /* Question 6 Views*/
                    grp.removeAllViews();
                    optionHolder.removeAllViews();

                    RadioButton answer_5_option_1 = new RadioButton(getApplicationContext());
                    answer_5_option_1.setText(option_for_5th[optionindex]);
                    answer_5_option_1.setTag(option_for_5th[optionindex]);
                    grp.addView(answer_5_option_1);

                    RadioButton answer_5_option_2 = new RadioButton(getApplicationContext());
                    answer_5_option_2.setText(option_for_5th[optionindex+1]);
                    answer_5_option_2.setTag(option_for_5th[optionindex+1]);
                    grp.addView(answer_5_option_2);

                    RadioButton answer_5_option_3 = new RadioButton(getApplicationContext());
                    answer_5_option_3.setText(option_for_5th[optionindex+2]);
                    answer_5_option_3.setTag(option_for_5th[optionindex+2]);
                    grp.addView(answer_5_option_3);

                    RadioButton answer_5_option_4 = new RadioButton(getApplicationContext());
                    answer_5_option_4.setText(option_for_5th[optionindex+3]);
                    answer_5_option_4.setTag(option_for_5th[optionindex+3]);
                    grp.addView(answer_5_option_4);
                    optionHolder.addView(grp);


                    break;
                case 6: /* Question 7 Views*/
                    grp.removeAllViews();
                    optionHolder.removeAllViews();

                    RadioButton answer_6_option_1 = new RadioButton(getApplicationContext());
                    answer_6_option_1.setText(option_for_6th[optionindex]);
                    answer_6_option_1.setTag(option_for_6th[optionindex]);
                    grp.addView(answer_6_option_1);

                    RadioButton answer_6_option_2 = new RadioButton(getApplicationContext());
                    answer_6_option_2.setText(option_for_6th[optionindex+1]);
                    answer_6_option_2.setTag(option_for_6th[optionindex+1]);
                    grp.addView(answer_6_option_2);

                    RadioButton answer_6_option_3 = new RadioButton(getApplicationContext());
                    answer_6_option_3.setText(option_for_6th[optionindex+2]);
                    answer_6_option_3.setTag(option_for_6th[optionindex+2]);
                    grp.addView(answer_6_option_3);

                    RadioButton answer_6_option_4 = new RadioButton(getApplicationContext());
                    answer_6_option_4.setText(option_for_6th[optionindex+3]);
                    answer_6_option_4.setTag(option_for_6th[optionindex+3]);
                    grp.addView(answer_6_option_4);

                    optionHolder.addView(grp);
                    break;

            }
        }else{
            number=0;
            Toast.makeText(MainActivity.this, "Reached End Moving to Question 1 again", Toast.LENGTH_LONG).show();
            updateView();
        }
    }

}
