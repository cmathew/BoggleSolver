package com.example.cmathew.bogglesolver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("GEEKS");
        dictionary.add("FOR");
        dictionary.add("QUIZ");
        dictionary.add("GO");

        char[][] board = new char[][] { {'G','I','Z'}, {'U','E','K'}, {'Q','S','E'} };
        SolventGreen solvent = new SolventGreen(dictionary);
        HashSet<String> finds = solvent.solveBoardBoyo(board);

        for (String find : finds) {
            Log.v("FIND", find);
        }
    }
}
