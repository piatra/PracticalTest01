package ro.pub.cs.system.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 
public class PracticalTest01SecondaryActivity extends Activity {
 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_practical_test01_secondary);
    
    Button btn1 = (Button) findViewById(R.id.button1);
    Button btn2 = (Button) findViewById(R.id.button2);
    
    btn1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			setResult(RESULT_CANCELED, new Intent());
			finish();
		}
	});
    
    btn2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			setResult(RESULT_OK, new Intent());
			finish();
		}
	});
    
    Intent intent = getIntent();
    
    String s1 = intent.getStringExtra("camp1");
    String s2 = intent.getStringExtra("camp1");
    
    EditText et1 = (EditText) findViewById(R.id.editText1);
    EditText et2 = (EditText) findViewById(R.id.editText1);
    
    et1.setText(s1);
    et2.setText(s2);
  }
 
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
    return true;
  }
 
}