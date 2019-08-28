package com.example.deneme;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner_Ulke;
    EditText arananKelime_et;
    TextView sonuc_tv;
    Button ceviriButton;
    String dilCifti = "tr-en";
    String arananKelime;
    String yandexKey = "trnsl.1.1.20190620T111447Z.113d01ef11dcf180.b22c1bdcfb706af804021af9905cad5bdea6ad29";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_Ulke = (Spinner)findViewById(R.id.spinnerCountry);
        arananKelime_et = (EditText)findViewById(R.id.editTextArananKelime);
        sonuc_tv = (TextView)findViewById(R.id.textViewSonuc);
        ceviriButton = (Button)findViewById(R.id.buttonCevir);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.country_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Ulke.setAdapter(adapter);
        spinner_Ulke.setOnItemSelectedListener(this);




        ceviriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arananKelime = arananKelime_et.getText().toString();
                String query = null;
                String urlString;
                try {
                    query = URLEncoder.encode(arananKelime,"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                System.out.println(" "+ spinner_Ulke.getSelectedItem().toString());

                if (spinner_Ulke.getSelectedItem().toString() != null) {
                    switch (spinner_Ulke.getSelectedItem().toString()) {
                        case "England":
                            System.out.println("ingilizce çeviri ");

                            dilCifti="tr-en";
                            urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+yandexKey+"&text="+query+"&lang="+dilCifti;
                            new TranslatorBackgroundTask().execute(urlString);

                            break;
                        case "France":
                            System.out.println("fransızca çeviri ");

                            dilCifti="tr-fr";
                            urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+yandexKey+"&text="+query+"&lang="+dilCifti;
                            new TranslatorBackgroundTask().execute(urlString);

                            break;
                        case "Italy":
                            System.out.println("İtalyanca çeviri ");

                            dilCifti="tr-it";
                            urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+yandexKey+"&text="+query+"&lang="+dilCifti;
                            new TranslatorBackgroundTask().execute(urlString);

                            break;
                        case "India":
                            System.out.println("hintçe çeviri ");

                            dilCifti="tr-hi";
                            urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+yandexKey+"&text="+query+"&lang="+dilCifti;
                            new TranslatorBackgroundTask().execute(urlString);

                            break;
                        case "Makedonya":
                            System.out.println("makedonca çeviri ");

                            dilCifti="tr-mk";
                            urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+yandexKey+"&text="+query+"&lang="+dilCifti;
                            new TranslatorBackgroundTask().execute(urlString);

                            break;
                        case "Almanya":
                            System.out.println("almanca çeviri ");

                            dilCifti="tr-de";
                            urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+yandexKey+"&text="+query+"&lang="+dilCifti;
                            new TranslatorBackgroundTask().execute(urlString);

                            break;
                        case "Indonesia":
                            System.out.println("fransızca çeviri ");

                            dilCifti="tr-id";
                            urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+yandexKey+"&text="+query+"&lang="+dilCifti;
                            new TranslatorBackgroundTask().execute(urlString);

                            break;
                        case "Singapore":
                            System.out.println("Malayca çeviri ");

                            dilCifti="tr-ms";
                            urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+yandexKey+"&text="+query+"&lang="+dilCifti;
                            new TranslatorBackgroundTask().execute(urlString);

                            break;
                        case "New Zealand":
                            System.out.println("yeni zelanda(maorice) çeviri ");

                            dilCifti="tr-mi";
                            urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+yandexKey+"&text="+query+"&lang="+dilCifti;
                            new TranslatorBackgroundTask().execute(urlString);

                            break;
                        case "Turkey":
                            System.out.println("türkçe çeviri ");

                            dilCifti="tr-tr";
                            urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+yandexKey+"&text="+query+"&lang="+dilCifti;
                            new TranslatorBackgroundTask().execute(urlString);

                            break;



                        default:
                            break;

                    }
                }

                /*String urlString = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+yandexKey+"&text="+query+"&lang="+dilCifti;
                new TranslatorBackgroundTask().execute(urlString);*/


            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String text = adapterView.getItemAtPosition(position).toString();

        Toast.makeText(adapterView.getContext()," "+text,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    class TranslatorBackgroundTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            String urlString = strings[0];
            StringBuilder jsonString = new StringBuilder();

            try {
                URL yandexUrl = new URL(urlString);
                HttpURLConnection httpURLConnection =  (HttpURLConnection)yandexUrl.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;

                while ((line=bufferedReader.readLine())!= null){
                        jsonString.append(line);
                }
                inputStream.close();
                bufferedReader.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return jsonString.toString();
        }

        @Override
        protected void onPostExecute(String json) {

            JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
            String sonuc = jsonObject.get("text").getAsString();
            sonuc_tv.setText(sonuc);

        }

    }
}
