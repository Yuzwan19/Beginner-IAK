package com.smkn2jkt.android.kuliiday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PesanPacul extends AppCompatActivity {


    int kuantitas = 0;

    EditText edt_nama;
    TextView txt_namabarang, txt_kuantitas, txt_banyak, txt_total, txt_jumlah;
    Button btn_minus, btn_plus, btn_bayar;
    CheckBox cb_pacul, cb_gerobak, cb_traktor, cb_topikuli;
    String Gerobak, Pacul, Traktor, TopiKuli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_pacul);
        setupView();

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrement();
            }
        });

            btn_plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    increment();

                }
            });

            btn_bayar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bayar();

                }
            });
    }

    private void setupView(){
        edt_nama = (EditText)findViewById(R.id.edt_nama);
        txt_namabarang = (TextView)findViewById(R.id.txt_namabarang);
        txt_kuantitas = (TextView)findViewById(R.id.txt_kuantitas);
        txt_banyak = (TextView)findViewById(R.id.txt_banyak);
        txt_total = (TextView)findViewById(R.id.txt_total);
        txt_jumlah = (TextView)findViewById(R.id.txt_jumlah);
        btn_minus = (Button)findViewById(R.id.btn_minus);
        btn_plus = (Button)findViewById(R.id.btn_plus);
        btn_bayar = (Button)findViewById(R.id.btn_bayar);
        cb_pacul = (CheckBox) findViewById(R.id.cb_pacul);
        cb_gerobak = (CheckBox) findViewById(R.id.cb_gerobak);
        cb_traktor = (CheckBox) findViewById(R.id.cb_traktor);
        cb_topikuli = (CheckBox) findViewById(R.id.cb_topikuli);
    }

    public void increment() {
        if (kuantitas == 10) {
            return;
        }
        kuantitas = kuantitas + 1;
        tampilKuantitas(kuantitas);
        //txt_banyak.setText(""+kuantitas);
    }



    public void decrement() {
        if (kuantitas == 0) {
            return;
        }
        kuantitas = kuantitas - 1;
        tampilKuantitas(kuantitas);
    }

    private  void tampilKuantitas(int qty){
       txt_banyak.setText(""+qty);
    }

    private void Pacul(){
//        if (ctx.isChecked()) {
//            ctx.setChecked(false);
//
//        } else {
//            ctx.setChecked(true);
//        }
    }

    private void checkGerobak(){
        if(cb_gerobak.isChecked()) {
//            cb_gerobak.setChecked(false);
            Gerobak = "YES";

        } else {
            Gerobak = "NO";
//           /cb_gerobak.setChecked(true);
        }
    }

    private void checkPacul(){
        if(cb_pacul.isChecked()) {
//            cb_pacul.setChecked(false);
            Pacul = "YES";

        } else {
            Pacul = "NO";
//            cb_pacul.setChecked(true);
        }
    }

    private void checkTraktor(){
        if(cb_gerobak.isChecked()) {
//            cb_traktor.setChecked(false);
            Traktor = "YES";

        } else {
            Traktor = "NO";
//           /cb_traktor.setChecked(true);
        }
    }

    private void checkTopiKuli(){
        if(cb_topikuli.isChecked()) {
//            cb_topikuli.setChecked(false);
            TopiKuli = "YES";

        } else {
            TopiKuli = "NO";
//           /cb_topikuli.setChecked(true);
        }
    }


    private void Bayar (){
        checkGerobak();
        checkPacul();
        checkTraktor();
        checkTopiKuli();
        String judul = "----- Barang Bekas -----";
        String nama= "Nama Barang : " + edt_nama.getText().toString();
        int total = kuantitas * 1000;
        String bayar = nama + "\nJumlah : " + kuantitas
                + "\nPacul : " +Pacul
                + "\nGerobak : " +Gerobak
                + "\nTraktor : " +Traktor
                + "\nTopi Kuli :" +TopiKuli
                + "\nHarga : Rp "+ total + ",-";
        txt_jumlah.setText(bayar);
    }
}