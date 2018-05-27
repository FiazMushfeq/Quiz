package com.example.fiazm.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFive extends Fragment {
    ReceiveCount receiveCount;
    TextView which_question;
    Button button;
    int add = 0;
    public QuestionFive() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_question_mc, container, false);
        which_question = getActivity().findViewById(R.id.which_question);
        which_question.setText("#5: (out of 10)");
        button = getActivity().findViewById(R.id.button);
        TextView question_one = fragmentView.findViewById(R.id.question_text);
        question_one.setText("Which of the following is the largest country?");
        final RadioGroup choices = fragmentView.findViewById(R.id.answer_group);
        final RadioButton choice_a = fragmentView.findViewById(R.id.choice_a);
        choice_a.setText("Canada");
        final RadioButton choice_b = fragmentView.findViewById(R.id.choice_b);
        choice_b.setText("Russia");
        final RadioButton choice_c = fragmentView.findViewById(R.id.choice_c);
        choice_c.setText("United States");
        final RadioButton choice_d = fragmentView.findViewById(R.id.choice_d);
        choice_d.setText("China");
        choices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(choice_a.isChecked()) {
                    Toast.makeText(getContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                }
                else if(choice_b.isChecked()) {
                    Toast.makeText(getContext(), "Right!", Toast.LENGTH_SHORT).show();
                    add = 1;
                }
                else if(choice_c.isChecked()) {
                    Toast.makeText(getContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                }
                else if(choice_d.isChecked()) {
                    Toast.makeText(getContext(), "Wrong!", Toast.LENGTH_SHORT).show();
                }
                turnOffRadioGroup(choices);
                receiveCount.receive(5, add);
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
        receiveCount = (ReceiveCount)context;
    }

    public interface ReceiveCount {
        void receive(int i, int add);
    }

}
