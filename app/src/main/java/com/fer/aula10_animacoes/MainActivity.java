package com.fer.aula10_animacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView arrow, cortinaL, cortinaR, gengar;
    Random r;
    int anguloInicial = 0, anguloFinal = 270, qtdVoltas = 10;
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
                        anguloInicial = anguloFinal%360;
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                arrow.startAnimation(imagem);
            }
        });
    }
}