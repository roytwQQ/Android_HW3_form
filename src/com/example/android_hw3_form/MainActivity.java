package com.example.android_hw3_form;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	private RadioGroup radGroupBlood;
	private RadioButton rad_O,rad_A,rad_B,rad_AB;
	
	private TextView showBlood, showDegree, showName;
	private EditText inputName;

	private Spinner spnPrefer;
	String[] Degrees = new String[] {"", "博士", "碩士", "大學", "高中"};

	
	private RadioGroup.OnCheckedChangeListener radGroupListener=
	    	new RadioGroup.OnCheckedChangeListener(){
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					int  p = group.indexOfChild((RadioButton) findViewById(checkedId));	
					int count = group.getChildCount(); 
					
					if (checkedId == R.id.radio0)
						showBlood.setText(rad_O.getText());
					else if (checkedId == R.id.radio1)
						showBlood.setText(rad_A.getText());
					else if (checkedId == R.id.radio2)
						showBlood.setText(rad_B.getText());
					else if (checkedId == R.id.radio3)
						showBlood.setText(rad_AB.getText());
				}
	    };
	    
    private Spinner.OnItemSelectedListener spnPreferListener=
        	new Spinner.OnItemSelectedListener(){
    			@Override
    			public void onItemSelected(AdapterView<?> parent, View v,
    					int position, long id) {
    				String sel=parent.getSelectedItem().toString();
    				showDegree.setText(sel);					
    			}
    			@Override
    			public void onNothingSelected(AdapterView<?> parent) {
    				// TODO Auto-generated method stub				
    			}			
        };  
        
        TextWatcher watcher=new TextWatcher(){
            public void onTextChanged(    CharSequence text,    int arg1,    int arg2,    int arg3){
            	showName.setText(text);
            }
            public void beforeTextChanged(    CharSequence text,    int arg1,    int arg2,    int arg3){
            }
            public void afterTextChanged(    Editable gitDirEditText){
//              updateUIWithValidation();
            }
          }
        ;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = (EditText) findViewById(R.id.editText1);
        showBlood=(TextView) findViewById(R.id.textView4);
        showDegree=(TextView) findViewById(R.id.textView5);
        showName=(TextView) findViewById(R.id.textView6);
        radGroupBlood=(RadioGroup) findViewById(R.id.radioGroup1); 
        rad_O = (RadioButton) findViewById(R.id.radio0);
        rad_A = (RadioButton) findViewById(R.id.radio1);
        rad_B = (RadioButton) findViewById(R.id.radio2);
        rad_AB = (RadioButton) findViewById(R.id.radio3);
        radGroupBlood.setOnCheckedChangeListener(radGroupListener); 

        inputName.addTextChangedListener(watcher);

        
        spnPrefer = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapterDegree = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Degrees);
        adapterDegree.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPrefer.setAdapter(adapterDegree);
        spnPrefer.setOnItemSelectedListener(spnPreferListener); 
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
}
