package com.example.interfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainContract.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //подключаем фрагмент менненджкр
        getSupportFragmentManager()
                //начинаем перевод
                .beginTransaction()
                //меняем все что есть в контейнере на фрагмент
                .replace(R.id.main_container, MainFragment.newInstance())
                //закидываем инфу
                .commit();
    }

    @Override
    //используем имплементированый метод
    public void openSecondActivity() {
        //указываем намерение
        Intent intent = new Intent(this,SecondActivity.class);
        //стартуем метод по указоному интенту
        startActivity(intent);
    }
}
