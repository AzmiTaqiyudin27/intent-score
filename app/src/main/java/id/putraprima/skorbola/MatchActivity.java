package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    private String hometeam;
    private String awayteam;
    private String winner;
    private int homescore;
    private int awayscore;
    private TextView scoreHome;
    private TextView scoreAway;
    private TextView homeText;
    private TextView awayText;
    private ImageView homeLogo;
    private ImageView awayLogo;
    private Button addHome;
    private Button addHome2;
    private Button addHome3;
    private Button addAway;
    private Button addAway2;
    private Button addAway3;
    private Button resetResult;
    private Button cekResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        scoreHome = findViewById(R.id.score_home);
        scoreAway = findViewById(R.id.score_away);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);
        addHome = findViewById(R.id.btn_add_home);
        addHome2 = findViewById(R.id.btn_add_home2);
        addHome3 = findViewById(R.id.btn_add_home3);
        addAway = findViewById(R.id.btn_add_away);
        addAway2 = findViewById(R.id.btn_add_away2);
        addAway3 = findViewById(R.id.btn_add_away3);
        resetResult =  findViewById(R.id.btn_resetresult);
        cekResult = findViewById(R.id.btn_result);

        homescore = 0;
        awayscore = 0;
        scoreHome.setText(String.valueOf(homescore));
        scoreAway.setText(String.valueOf(awayscore));

        Bundle bundle = getIntent().getExtras();
        hometeam = bundle.getString("namahome");
        homeText.setText(hometeam);
        awayteam = bundle.getString("namaaway");
        awayText.setText(awayteam);
        homeLogo.setImageURI(Uri.parse(bundle.getString("homeImg")));
        awayLogo.setImageURI(Uri.parse(bundle.getString("awayImg")));

        addHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 1;
                scoreHome.setText(String.valueOf(homescore));
            }
        });
        addHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 2;
                scoreHome.setText(String.valueOf(homescore));
            }
        });
        addHome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 3;
                scoreHome.setText(String.valueOf(homescore));
            }
        });

        addAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 1;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });
        addAway2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 2;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });
        addAway3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 3;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });
        resetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore =0 ;
                scoreHome.setText(String.valueOf(homescore));

                awayscore = 0;
                scoreAway.setText(String.valueOf(awayscore));

            }
        });
        cekResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                winner = "empty";
                if(homescore > awayscore){
                    winner = hometeam;
                }
                else if (homescore == awayscore){
                    winner = "draw";
                }
                else {
                    winner = awayteam;
                }

                Intent intent = new Intent(MatchActivity.this, ResultActivity.class);
                intent.putExtra("winner", winner);
                startActivity(intent);
            }
        });


        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
}
