package com.example.lab2;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private EditText editTextText;
  private TextView textView,tv_name,tv_winner,tv_mmora,tv_cmora;
  private RadioButton btn_scissor,btn_stone,btn_papper;
  private Button btn_mora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextText = findViewById(R.id.editTextText);
        textView=findViewById(R.id.textView);
        tv_name=findViewById(R.id.tv_name);
        tv_winner=findViewById(R.id.tv_winner);
        tv_mmora=findViewById(R.id.tv_mmora);
        tv_cmora=findViewById(R.id.tv_cmora);
        btn_mora=findViewById(R.id.btn_mora);
        btn_scissor=findViewById(R.id.btn_scissor);
        btn_stone=findViewById(R.id.btn_stone);
        btn_papper=findViewById(R.id.btn_paper);
        btn_mora.setOnClickListener(view ->{
            if(editTextText.length()<1){
                textView.setText("請輸入玩家姓名");
            }
            else{
                tv_name.setText(String.format("名字\n%s",editTextText.getText().toString()));
              if(btn_scissor.isChecked()){
                  tv_mmora.setText("我方出拳\n剪刀");
              }
              else if(btn_stone.isChecked()){
                  tv_mmora.setText("我方出拳\n石頭");
              }
              else{
                  tv_mmora.setText("我方出拳\n布");
              }
              int computer_random=(int)(Math.random()*3);
              if(computer_random == 0 ){
                  tv_cmora.setText("電腦出拳\n剪刀");
              }
              else if(computer_random == 1){
                    tv_cmora.setText("電腦出拳\n石頭");
                }
              else{
                  tv_cmora.setText("電腦出拳\n布");
              }
            if((btn_scissor.isChecked() && computer_random == 2 )||
                btn_stone.isChecked() && computer_random == 0 ||
                btn_papper.isChecked() && computer_random == 1){
                tv_winner.setText("勝利者\n"+editTextText.getText().toString());
                textView.setText("恭喜你獲勝了!");
            }
            else if((btn_scissor.isChecked() && computer_random == 1 )||
                        btn_stone.isChecked() && computer_random == 2 ||
                        btn_papper.isChecked() && computer_random == 0){
                    tv_winner.setText("勝利者\n電腦");
                    textView.setText("可惜,電腦獲勝了!");
            }
            else{
            tv_winner.setText("勝利者\n平手");
            textView.setText("平局,再試一次!");
            }
            }





        });
    }
}