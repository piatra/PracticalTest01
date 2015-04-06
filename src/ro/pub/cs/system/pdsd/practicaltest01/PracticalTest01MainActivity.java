package ro.pub.cs.system.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		CheckBox ch1 = (CheckBox) findViewById(R.id.checkBox1);
		final EditText et1 = (EditText) findViewById(R.id.editText1);	
		
		CheckBox ch2 = (CheckBox) findViewById(R.id.checkBox2);
		final EditText et2 = (EditText) findViewById(R.id.editText2);	
		
		if (savedInstanceState != null) {
			
			String checked1 = savedInstanceState.getString("checkbox1");
			String checked2 = savedInstanceState.getString("checkbox1");
			String input1 = savedInstanceState.getString("input1");
			String input2 = savedInstanceState.getString("input2");
			
			if (checked1 == "checked") {
				ch1.setChecked(true);
			} else {
				ch1.setChecked(false);
			}
			
			if (checked2 == "checked") {
				ch2.setChecked(true);
			} else {
				ch2.setChecked(false);
			}
			
			et1.setText(input1);
			et1.setText(input2);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
		
		CheckBox ch1 = (CheckBox) findViewById(R.id.checkBox1);
		final EditText et1 = (EditText) findViewById(R.id.editText1);	
		
		CheckBox ch2 = (CheckBox) findViewById(R.id.checkBox2);
		final EditText et2 = (EditText) findViewById(R.id.editText2);	
		
		Button btn = (Button) findViewById(R.id.button1);
		
		et1.setEnabled(false);
		et2.setEnabled(false);
		
		ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

		       @Override
		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
		    	   	et1.setEnabled(isChecked);
		       }
		   }
		); 
		
		ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

		       @Override
		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
		    	   	et2.setEnabled(isChecked);
		       }
		   }
		); 
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(PracticalTest01MainActivity.this, PracticalTest01SecondaryActivity.class);
				
				intent.putExtra("camp1", et1.getText().toString());
				intent.putExtra("camp2", et1.getText().toString());
				
				startActivityForResult(intent, 1);
				
			}
		});
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	protected void onSaveInstanceState(Bundle savedInstance) {
		
		CheckBox ch1 = (CheckBox) findViewById(R.id.checkBox1);
		final EditText et1 = (EditText) findViewById(R.id.editText1);	
		
		CheckBox ch2 = (CheckBox) findViewById(R.id.checkBox2);
		final EditText et2 = (EditText) findViewById(R.id.editText2);	
		
		savedInstance.putString("checkbox1", ch1.isChecked() ? "checked" : "unchecked");
		savedInstance.putString("checkbox2", ch2.isChecked() ? "checked" : "unchecked");
		
		savedInstance.putString("input1", et1.getText().toString());
		savedInstance.putString("input2", et2.getText().toString());
	}
	
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
	  }
}
