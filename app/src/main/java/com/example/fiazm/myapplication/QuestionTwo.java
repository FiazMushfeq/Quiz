package com.example.fiazm.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionTwo extends Fragment {
    ReceiveCount receiveCount;
    TextView which_question;
    int add = 0;
    public QuestionTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_question_mc, container, false);
        which_question = getActivity().findViewById(R.id.which_question);
        which_question.setText("#2: (out of 10)");
        TextView question_two = fragmentView.findViewById(R.id.question_text);
        question_two.setText("Which of the following is the smallest country?");
        final RadioGroup choices = fragmentView.findViewById(R.id.answer_group);
        final RadioButton choice_a = fragmentView.findViewById(R.id.choice_a);
        choice_a.setText("Vatican City");
        final RadioButton choice_b = fragmentView.findViewById(R.id.choice_b);
        choice_b.setText("New York");
        final RadioButton choice_c = fragmentView.findViewById(R.id.choice_c);
        choice_c.setText("Monaco");
        final RadioButton choice_d = fragmentView.findViewById(R.id.choice_d);
        choice_d.setText("Tuvalu");
        choices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(choice_a.isChecked()) {
                    Toast.makeText(getContext(), "Right!", Toast.LENGTH_SHORT).show();
                    add = 1;
                }
                else if(choice_b.isChecked()) {
                    Toast.makeText(getContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                }
                else if(choice_c.isChecked()) {
                    Toast.makeText(getContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                }
                else if(choice_d.isChecked()) {
                    Toast.makeText(getContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                }
                turnOffRadioGroup(choices);
                receiveCount.receive(2, add);
            }
        });
        return fragmentView;
    }

    public void turnOffRadioGroup(RadioGroup radioGroup) {
        for(int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(false);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        receiveCount = (QuestionTwo.ReceiveCount)context;
    }

    public interface ReceiveCount {
        void receive(int i, int add);
    }

}
