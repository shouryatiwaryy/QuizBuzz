package com.example.android.simplequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Galileo was an Italian astronomer who developed?",
            "Who is the father of Geometry ?",
            "Who was known as Iron man of India ?",
            "The first woman in space was ?",
            "Who is the Flying Sikh of India ?",
            "The Indian to beat the computers in mathematical wizardry is",
            "Who is Larry Pressler ?",
            "Michael Jackson is a distinguished person in the field of ?",
            "The first Indian to swim across English channel was ?",
            "Who was the first Indian to make a movie?",
            "Who is known as the ' Saint of the gutters ?",
            "Who invented the famous formula E=mc^2",
            "Who is elected as president of us 2016",
            "Who was the founder of company Microsoft",
            "Who was the founder of company Apple ?",
            "Who was the founder of company Google ?",
            "Who is know as god of cricket ?",
            "who has won ballon d'or of 2015 ?",
            "who has won ballon d'or of 2014 ?",
            "the Founder of the most famous gaming platform steam is ?"


    };
    String answers[] = {"Telescope","Euclid","Sardar Vallabhbhai Patel","Valentina Tereshkova","Milkha singh","Shakunthala Devi","Politician","Pop Music","Mihir Sen","Dhundiraj Govind Phalke"
            , "Mother Teresa", "Albert Einstein", "Donald Trump", "Bill Gates", "Steve Jobs", "Larry Page", "Sachin Tendulkar","Lionel Messi" ,"Cristiano Ronaldo", "Gabe Newell"
    };
    String opt[] = {
            "Telescope", "Airoplane", "Electricity", "Train",
            "Aristotle", "Euclid", "Pythagoras", "Kepler",
            "Govind Ballabh Pant", "Jawaharlal Nehru", "Subhash Chandra Bose", "Sardar Vallabhbhai Patel",
            "Valentina Tereshkova", "Sally Ride", "Naidia Comenci", "Tamara Press",
            "Mohinder Singh", "Joginder Singh", "Ajit Pal Singh", "Milkha singh",
            "Ramanujam", "Rina Panigrahi", "Raja Ramanna", "Shakunthala Devi",
            "Politician", "Painter", "Actor", "Tennis player",
            "Pop Music", "Jounalism", "Sports", "Acting",
            "V. Merchant", "P. K. Banerji", "Mihir Sen", "Arati Saha",
            "Dhundiraj Govind Phalke", " Asha Bhonsle", " Ardeshir Irani", "V. Shantaram",
            "B.R.Ambedkar", "Mother Teresa", "Mahatma Gandhi", "Baba Amte",
            "Albert Einstein", "Galilio", "Sarvesh", "Bill Gates",
            "Donald Trump", "Hilary Clinton", "Jhon pol", "Barack Obama",
            "Bill Gates", "Bill Clinton", "Jhon rio", "Steve jobs",
            "Steve Jobs", "Steve Washinton", "Bill Gates", "Jobs Wills",
            "Steve Jobs", "Bill Gates", "Larry Page", "Sundar Pichai",
            "Sachin Tendulkar", "Kapil Dev", "Virat Koli", "Dhoni",
            "Lionel Messi", "Cristiano Ronaldo", "Neymar", "Kaka",
            "Neymar", "Lionel Messi", "Cristiano Ronaldo", "Kaka",
            "Bill Cliton", "Bill Williams", "Gabe Newell", "Bill Gates"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("MyName");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}