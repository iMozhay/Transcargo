package design.mozhay.transcargo.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import design.mozhay.transcargo.R;

public class SplashScreenActivity extends AppCompatActivity implements Animator.AnimatorListener {

    ImageView mLogo;
    ImageView mMozhayLogo;
    Animator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        mLogo = findViewById(R.id.logo_app);
        mMozhayLogo = findViewById(R.id.logo_mozhay);

        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.logo_animator);
        animator.setTarget(mLogo);
        animator.addListener(this);

        mAnimator = AnimatorInflater.loadAnimator(this, R.animator.mozhay_animator);
        mAnimator.setTarget(mMozhayLogo);

        mAnimator.start();
        animator.start();
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        Intent intent = new Intent(
                SplashScreenActivity.this, MainActivity.class
        );
        startActivity(intent);
        finish();
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

}
