package w2.karolewski.randomdine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainView extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_view);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.radius_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG). show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        final ImageButton button = (ImageButton) findViewById(R.id.btnSearch);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String selection = spinner.getSelectedItem().toString();
                Intent intent = new Intent(MainView.this, ResultView.class);
                intent.putExtra("selectedItem", selection);
                startActivity(intent);
            }
        });

    }


}
