package com.example.jogodavelha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.jogodavelha.R;

public class Main extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		View jogarButton = findViewById(R.id.jogar_button);
	    jogarButton.setOnClickListener(this);
	    View aboutButton = findViewById(R.id.about_button);
	    aboutButton.setOnClickListener(this);
	    View exitButton = findViewById(R.id.exit_button);
	    exitButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
	    	case R.id.about_button:
	    		Intent i = new Intent(this, About.class);
	    		startActivity(i);
	    	break;
	    	case R.id.jogar_button:
	    		Intent i1 = new Intent(this, TelaJogo.class);
	    		startActivity(i1);
	    	break;
	    	case R.id.exit_button: 
	    		finish(); 
	    	break;
	    }
		
	}
}
