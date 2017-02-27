package com.example.yunalescca.swedishpronunciations.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.yunalescca.swedishpronunciations.*;
import com.example.yunalescca.swedishpronunciations.services.LetterManager;


import java.util.HashMap;

public class ResultActivity extends Tools {
    RelativeLayout first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, bug1, bug2;
    HashMap<String, String> map;
    TextView firstFirst, firstSecond, secondFirst, secondSecond;
    ImageView firstImage, secondImage;

    String text, input, letter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle p = getIntent().getExtras();
        text = p.getString("text");

        initializeItems();

        createMap();


        hideButtons();

        checkInput(text);
    }

    public void initializeItems(){
        first = (RelativeLayout)findViewById(R.id.button_top);
        second = (RelativeLayout)findViewById(R.id.button_top12);
        third = (RelativeLayout)findViewById(R.id.button_top122);
        fourth = (RelativeLayout)findViewById(R.id.button_top1222);
        fifth = (RelativeLayout)findViewById(R.id.button_top1);
        sixth = (RelativeLayout)findViewById(R.id.button_top11);
        seventh= (RelativeLayout)findViewById(R.id.button_top111);
        eighth = (RelativeLayout) findViewById(R.id.button_top1111);
        ninth = (RelativeLayout) findViewById(R.id.button_top11111);

        bug1 = (RelativeLayout) findViewById(R.id.button_top111111);
        bug2 = (RelativeLayout) findViewById(R.id.button_top1111111);

        firstFirst = (TextView)findViewById(R.id.text2);
        firstSecond = (TextView)findViewById(R.id.text);
        firstImage = (ImageView)findViewById(R.id.imageView);

        secondFirst = (TextView)findViewById(R.id.text12);
        secondSecond = (TextView)findViewById(R.id.text32);
        secondImage = (ImageView)findViewById(R.id.imageView12);
    }

    public void onClick1(View v, String letter){
        int temp = 0;
        switch(letter){
            case "a": temp = 0;break;
            case "e": temp = 1;break;
            case "i": temp = 2;break;
            case "o": temp = 3;break;
            case "u": temp = 4;break;
            case "y": temp = 5;break;
            case "å": temp = 6;break;
            case "ä": temp = 7;break;
            case "ö": temp = 8;break;
            default: break;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(LetterFragment.ARG_LETTER_POSITION, temp);
        bundle.putInt(LetterFragment.ARG_LETTER_TYPE, LetterManager.TYPE_ALL);
        Intent intent = new Intent(this, LetterActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void createMap(){
        map = new HashMap<>();
        map.put("glas", "a");
        map.put("fat", "a");
        map.put("masker", "a");
        map.put("sadel", "a");
        map.put("hatt", "a");
        map.put("lampa", "a");

        map.put("ben", "e");
        map.put("tre", "e");
        map.put("ren", "e");
        map.put("elefant", "e");
        map.put("fem", "e");
        map.put("sex", "e");

        map.put("bil", "i");
        map.put("pil", "i");
        map.put("gris", "i");
        map.put("fisk", "i");
        map.put("slips", "i");
        map.put("ring", "i");

        map.put("sol", "o");
        map.put("stol", "o");
        map.put("ko", "o");
        map.put("korv", "o");
        map.put("klocka", "o");
        map.put("bock", "o");

        map.put("hus", "u");
        map.put("mus", "u");
        map.put("sju", "u");
        map.put("uggla", "u");
        map.put("mun", "u");
        map.put("buss", "u");

        map.put("myra", "y");
        map.put("fyr", "y");
        map.put("fyra", "y");
        map.put("yxa", "y");
        map.put("byxor", "y");
        map.put("kyckling", "y");

        map.put("åsna", "å");
        map.put("ål", "å");
        map.put("två", "å");
        map.put("tång", "å");
        map.put("åtta", "å");
        map.put("råtta", "å");

        map.put("träd", "ä");
        map.put("räka", "ä");
        map.put("näsa", "ä");
        map.put("ägg", "ä");
        map.put("hjärta", "ä");
        map.put("tält", "ä");

        map.put("öga", "ö");
        map.put("öra", "ö");
        map.put("smör", "ö");
        map.put("fönster", "ö");
        map.put("ört", "ö");
        map.put("kött", "ö");
    }

    public void checkInput(String text){

        String vowel = "aeiouyåäö";
        input = "";
        for(int i=0; i<text.length(); i++){
            for(int j=0; j<vowel.length(); j++){
                if(text.charAt(i)==(vowel.charAt(j))){
                    if(!input.contains(text.charAt(i)+"")) {
                        input = input + text.charAt(i);
                    }
                }
            }
        }

        if (map.containsKey(text.toLowerCase())) {
            letter = map.get(text).toLowerCase();

            int drawable = checkWord(map.get(text), text);
            first.setVisibility(View.VISIBLE);
            firstFirst.setText(text);
            firstSecond.setText(map.get(text).toUpperCase()+map.get(text));
            firstImage.setBackground(getDrawable(drawable));
            first.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick1(view, letter);
                }
            });
            if(input.length()==1) {
                placeSecond(0);
            }
            if(input.length()==2) {
                placeThird(1);
            }
            if(input.length()==3) {
                placeFourth(2);
            }
            if(input.length()==4) {
                placeFifth(3);
            }
            if(input.length()==5) {
                placeSixth(3);
            }
            if(input.length()==6) {
                placeSeventh(4);
            }
            if(input.length()==7) {
                placeEighth(5);
            }
            if(input.length()==8) {
                placeNinth(6);
            }

        } else createButtons();
    }

    public void hideButtons(){
        first.setVisibility(View.GONE);
        second.setVisibility(View.GONE);
        third.setVisibility(View.GONE);
        fourth.setVisibility(View.GONE);
        fifth.setVisibility(View.GONE);
        sixth.setVisibility(View.GONE);
        seventh.setVisibility(View.GONE);
        eighth.setVisibility(View.GONE);
        ninth.setVisibility(View.GONE);

        bug1.setVisibility(View.GONE);
        bug2.setVisibility(View.GONE);
    }

    public void placeFirst(){
        if(first.getVisibility()!= View.VISIBLE) {
            letter = input;
            first.setVisibility(View.VISIBLE);
            firstSecond.setText((input.charAt(0) + "").toUpperCase() + input.charAt(0));
            firstFirst.setVisibility(View.GONE);
            firstImage.setVisibility(View.GONE);

            first.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick1(view, input.charAt(0) + "");
                }
            });
        }
    }
    public void placeSecond(final int index){
        placeFirst();

        second.setVisibility(View.VISIBLE);
        secondFirst.setText((input.charAt(index)+"").toUpperCase()+input.charAt(index));
        secondSecond.setVisibility(View.GONE);
        secondImage.setVisibility(View.GONE);

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick1(view, input.charAt(index)+"");
            }
        });
    }

    public void placeThird(final int index){
        placeSecond(index - 1);

        third.setVisibility(View.VISIBLE);
        TextView thirdFirst = (TextView)findViewById(R.id.text122);
        TextView thirdSecond = (TextView)findViewById(R.id.text322);
        ImageView thirdImage = (ImageView)findViewById(R.id.imageView122);
        thirdFirst.setText((input.charAt(index)+"").toUpperCase()+input.charAt(index));
        thirdSecond.setVisibility(View.GONE);
        thirdImage.setVisibility(View.GONE);

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick1(view, input.charAt(index)+"");
            }
        });
    }

    public void placeFourth(final int index){
        placeThird(index - 1);

        fourth.setVisibility(View.VISIBLE);
        TextView fourthFirst = (TextView)findViewById(R.id.text1222);
        TextView fourthSecond = (TextView)findViewById(R.id.text3222);
        ImageView fourthImage = (ImageView)findViewById(R.id.imageView1222);
        fourthFirst.setText((input.charAt(index)+"").toUpperCase()+input.charAt(index));
        fourthSecond.setVisibility(View.GONE);
        fourthImage.setVisibility(View.GONE);

        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick1(view, input.charAt(index)+"");
            }
        });
    }

    public void placeFifth(final int index){
        placeFourth(index - 1);

        fifth.setVisibility(View.VISIBLE);
        TextView fifthFirst = (TextView)findViewById(R.id.text1);
        TextView fifthSecond = (TextView)findViewById(R.id.text3);
        ImageView fifthImage = (ImageView)findViewById(R.id.imageView1);
        fifthFirst.setText((input.charAt(index)+"").toUpperCase()+input.charAt(index));
        fifthSecond.setVisibility(View.GONE);
        fifthImage.setVisibility(View.GONE);

        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick1(view, input.charAt(index)+"");
            }
        });
    }
    public void placeSixth(final int index){
        placeFifth(index - 1);

        sixth.setVisibility(View.VISIBLE);
        TextView sixthFirst = (TextView)findViewById(R.id.text11);
        TextView sixthSecond = (TextView)findViewById(R.id.text31);
        ImageView sixthImage = (ImageView)findViewById(R.id.imageView11);
        sixthFirst.setText((input.charAt(index)+"").toUpperCase()+input.charAt(index));
        sixthSecond.setVisibility(View.GONE);
        sixthImage.setVisibility(View.GONE);

        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick1(view, input.charAt(index)+"");
            }
        });
    }
    public void placeSeventh(final int index){
        placeSixth(index - 1);

        seventh.setVisibility(View.VISIBLE);
        TextView seventhFirst = (TextView)findViewById(R.id.text111);
        TextView seventhSecond = (TextView)findViewById(R.id.text311);
        ImageView seventhImage = (ImageView)findViewById(R.id.imageView111);
        seventhFirst.setText((input.charAt(index)+"").toUpperCase()+input.charAt(index));
        seventhSecond.setVisibility(View.GONE);
        seventhImage.setVisibility(View.GONE);

        seventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick1(view, input.charAt(index)+"");
            }
        });
    }
    public void placeEighth(final int index){
        placeSeventh(index - 1);

        eighth.setVisibility(View.VISIBLE);
        TextView eighthFirst = (TextView)findViewById(R.id.text1111);
        TextView eighthSecond = (TextView)findViewById(R.id.text3111);
        ImageView eighthImage = (ImageView)findViewById(R.id.imageView1111);
        eighthFirst.setText((input.charAt(index)+"").toUpperCase()+input.charAt(index));
        eighthSecond.setVisibility(View.GONE);
        eighthImage.setVisibility(View.GONE);

        bug1.setVisibility(View.VISIBLE);

        eighth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick1(view, input.charAt(index)+"");
            }
        });
    }

    public void placeNinth(final int index){
        placeEighth(index - 1);

        ninth.setVisibility(View.VISIBLE);
        TextView ninthFirst = (TextView)findViewById(R.id.text11111);
        TextView ninthSecond = (TextView)findViewById(R.id.text31111);
        ImageView ninthImage = (ImageView)findViewById(R.id.imageView11111);
        ninthFirst.setText((input.charAt(index)+"").toUpperCase()+input.charAt(index));
        ninthSecond.setVisibility(View.GONE);
        ninthImage.setVisibility(View.GONE);

        ninth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick1(view, input.charAt(index)+"");
            }
        });
    }

    public void createButtons(){
        if(input.length() == 1){
            placeFirst();
        } else if(input.length() == 2){
            placeSecond(1);
        } else if(input.length() == 3){
            placeThird(2);
        } else if(input.length() == 4){
            placeFourth(3);
        } else if(input.length() == 5){
            placeFifth(4);
        } else if(input.length() == 6){
            placeSixth(5);
        }else if(input.length() == 7){
            placeSeventh(6);
        }else if(input.length() == 8){
            placeEighth(7);
        }else if(input.length() == 9){
            placeNinth(8);
        }


    }
    public int checkWord(String letter, String word){
        switch(letter){
            case "a":{
                if(word.equals("hatt")){
                    return R.drawable.hatt;
                }
                else if(word.equals("glas")){
                    return R.drawable.glas ;
                }
                else if(word.equals("fat")){
                    return R.drawable.fat ;
                }
                else if(word.equals("sadel")){
                    return R.drawable.sadel ;
                }
                else if(word.equals("masker")){
                    return R.drawable.masker ;
                }
                else if(word.equals("lampa")){
                    return R.drawable.lampa ;
                }
            } break;
            case "e":{
                if(word.equals("ben")){
                    return R.drawable.ben;
                }
                else if(word.equals("tre")){
                    return R.drawable.tre ;
                }
                else if(word.equals("ren")){
                    return R.drawable.ren ;
                }
                else if(word.equals("elefant")){
                    return R.drawable.elefant ;
                }
                else if(word.equals("fem")){
                    return R.drawable.fem ;
                }
                else if(word.equals("sex")){
                    return R.drawable.sex ;
                }
            } break;
            case "i":{
                if(word.equals("bil")){
                    return R.drawable.bil;
                }
                else if(word.equals("pil")){
                    return R.drawable.pil ;
                }
                else if(word.equals("gris")){
                    return R.drawable.gris ;
                }
                else if(word.equals("fisk")){
                    return R.drawable.fisk ;
                }
                else if(word.equals("slips")){
                    return R.drawable.slips ;
                }
                else if(word.equals("ring")){
                    return R.drawable.ring ;
                }
            }break;
            case "o":{
                if(word.equals("sol")){
                    return R.drawable.sol;
                }
                else if(word.equals("stol")){
                    return R.drawable.stol ;
                }
                else if(word.equals("ko")){
                    return R.drawable.ko ;
                }
                else if(word.equals("korv")){
                    return R.drawable.korv ;
                }
                else if(word.equals("klocka")){
                    return R.drawable.klocka ;
                }
                else if(word.equals("bock")){
                    return R.drawable.bock ;
                }
            }break;
            case "u":{
                if(word.equals("hus")){
                    return R.drawable.hus;
                }
                else if(word.equals("mus")){
                    return R.drawable.mus ;
                }
                else if(word.equals("sju")){
                    return R.drawable.sju ;
                }
                else if(word.equals("uggla")){
                    return R.drawable.uggla ;
                }
                else if(word.equals("mun")){
                    return R.drawable.mun ;
                }
                else if(word.equals("buss")){
                    return R.drawable.buss ;
                }
            }break;
            case "y":{
                if(word.equals("myra")){
                    return R.drawable.myra;
                }
                else if(word.equals("fyr")){
                    return R.drawable.fyra ;
                }
                else if(word.equals("fyra")){
                    return R.drawable.fyra ;
                }
                else if(word.equals("yxa")){
                    return R.drawable.yxa ;
                }
                else if(word.equals("byxor")){
                    return R.drawable.byxor ;
                }
                else if(word.equals("kyckling")){
                    return R.drawable.kyckling ;
                }
            }break;
            case "å":{
                if(word.equals("åsna")){
                    return R.drawable.asna;
                }
                else if(word.equals("ål")){
                    return R.drawable.al ;
                }
                else if(word.equals("två")){
                    return R.drawable.tva;
                }
                else if(word.equals("tång")){
                    return R.drawable.tang ;
                }
                else if(word.equals("åtta")){
                    return R.drawable.atta ;
                }
                else if(word.equals("råtta")){
                    return R.drawable.ratta ;
                }
            }break;
            case "ä":{
                if(word.equals("träd")){
                    return R.drawable.trad;
                }
                else if(word.equals("räka")){
                    return R.drawable.raka ;
                }
                else if(word.equals("näsa")){
                    return R.drawable.nasa ;
                }
                else if(word.equals("ägg")){
                    return R.drawable.agg ;
                }
                else if(word.equals("hjärta")){
                    return R.drawable.hjarta ;
                }
                else if(word.equals("tält")){
                    return R.drawable.talt ;
                }
            }break;
            case "ö":{
                if(word.equals("öga")){
                    return R.drawable.oga;
                }
                else if(word.equals("öra")){
                    return R.drawable.ora ;
                }
                else if(word.equals("smör")){
                    return R.drawable.smor ;
                }
                else if(word.equals("fönster")){
                    return R.drawable.fonster ;
                }
                else if(word.equals("ört")){
                    return R.drawable.ort ;
                }
                else if(word.equals("kött")){
                    return R.drawable.kott ;
                }
            }
        } return 0;
    }
}
