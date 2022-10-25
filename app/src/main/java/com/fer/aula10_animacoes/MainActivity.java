package com.fer.aula10_animacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView arrow, cortinaL, cortinaR, gengar;
    Random r;
    int anguloInicial = 0, anguloFinal = 270, qtdVoltas = 10, count = 0;
    Animation bounce, dir, esq, fadein, fadeout, rotation, zoomin,zoomout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrow = findViewById(R.id.imgFlecha);
        cortinaL = findViewById(R.id.imgCortinaEsq);
        cortinaR = findViewById(R.id.imgCortinaDir);
        gengar = findViewById(R.id.imgGengar);
        bounce = AnimationUtils.loadAnimation(this,R.anim.bounce);
        rotation = AnimationUtils.loadAnimation(this,R.anim.rotation);
        fadein = AnimationUtils.loadAnimation(this,R.anim.fadein);
        fadeout = AnimationUtils.loadAnimation(this,R.anim.fadeout);
        zoomin = AnimationUtils.loadAnimation(this,R.anim.zoomin);
        zoomout = AnimationUtils.loadAnimation(this,R.anim.zoomout);
        esq = AnimationUtils.loadAnimation(this,R.anim.esq_dir);
        dir = AnimationUtils.loadAnimation(this,R.anim.dir_esq);

        r = new Random();
        //Animação da Seta
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anguloFinal = anguloInicial % 360;
                anguloInicial = r.nextInt(360*qtdVoltas)+360;
                RotateAnimation imagem = new RotateAnimation(
                        anguloFinal, anguloInicial,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f);
                imagem.setFillAfter(true);
                imagem.setInterpolator(new AccelerateDecelerateInterpolator());
                imagem.setDuration(3000);
                imagem.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        anguloFinal = anguloInicial%360;
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                arrow.startAnimation(imagem);
            }
        });
        //Animação da Cortina
        //todo: validar
        cortinaL.animate().translationX(-600*3).setDuration(3000);
        cortinaR.animate().translationX(600*3).setDuration(3000);

        //Animação do Gengar
        gengar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 0) gengar.startAnimation(bounce);
                else if(count == 1) gengar.startAnimation(rotation);
                else if(count == 2) gengar.startAnimation(fadein);
                else if(count == 3) gengar.startAnimation(fadeout);
                else if(count == 4) gengar.startAnimation(zoomin);
                else if(count == 5) gengar.startAnimation(zoomout);
                else if(count == 6) gengar.startAnimation(dir);
                else if(count == 7) gengar.startAnimation(esq);
                count++;
                if(count > 7) count=0;
            }
        });
    }
}