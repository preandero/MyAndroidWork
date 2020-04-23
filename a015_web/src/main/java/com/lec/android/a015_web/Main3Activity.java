package com.lec.android.a015_web;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/* XML, JSON 파싱 연습
 *
 * ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/53576c67506a736135346359696467/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/53576c67506a736135346359696467/json/stationInfo/1/5/서울

 */

public class Main3Activity extends AppCompatActivity {

    EditText editText;
    TextView tvResult;
    Button btnXML, btnJSON, btnParse;

    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editText = findViewById(R.id.editText);
        tvResult = findViewById(R.id.tvResult);
        btnXML = findViewById(R.id.btnXML);
        btnJSON = findViewById(R.id.btnJSON);
        btnParse = findViewById(R.id.btnParse);


        btnXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            request("http://swopenAPI.seoul.go.kr/api/subway/53576c67506a736135346359696467/xml/stationInfo/1/5/" + URLEncoder.encode(editText.getText().toString(), "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        btnJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            request("http://swopenAPI.seoul.go.kr/api/subway/53576c67506a736135346359696467/json/stationInfo/1/5/" + URLEncoder.encode(editText.getText().toString(), "UTF-8"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            }
        });

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void request(String urlStr) throws IOException {
        final StringBuilder sb = new StringBuilder();

        BufferedReader reader = null;
        HttpURLConnection conn = null;

        URL url = new URL(urlStr);
        conn = (HttpURLConnection) url.openConnection();

        if (conn != null) {
            conn.setConnectTimeout(5000); // timeout 시간 설정. 경과하면 SocketTimeoutException 발생
            conn.setUseCaches(false); // 캐시 사용 안함.
            conn.setRequestMethod("GET"); // GET 방식 request

            conn.setDoInput(true); // URLConnection 을 입력으로 사용. (true), (false) -> 출력용

            int responseCode = conn.getResponseCode(); // 성공하면 200

            if (responseCode == HttpURLConnection.HTTP_OK) {

                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = null;
                while (true) {
                    line = reader.readLine();
                    if (line == null) break;
                    sb.append(line + "\n");

                }

                if (reader != null) reader.close();
                if (conn != null) conn.disconnect();

            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvResult.setText("응답결과: " + sb.toString());
                }
            });


        }


    }



}
