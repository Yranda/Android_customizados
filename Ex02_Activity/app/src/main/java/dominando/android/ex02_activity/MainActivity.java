package dominando.android.ex02_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Calendar.SHORT;

public class MainActivity extends ActionBarActivity{
    EditText edt;
    ArrayList<String> nomes;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomes = new ArrayList<String>();
        edt = (EditText) findViewById(R.id.editText1);

        ListView listView = (ListView)
                findViewById(R.id.listView1);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nomes);
        listView.setAdapter(adapter);
    }
    public void meuBotaoClick(View v){
        nomes.add(edt.getText().toString());
        edt.setText("");
        adapter.notifyDataSetChanged();
    }
}




  /**   implements View.OnClickListener
    EditText edtTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTexto = (EditText) findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        Button buttonTela2 = (Button) findViewById(R.id.button);
        buttonTela2.setOnClickListener(this);

    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                String texto = edtTexto.getText().toString();
                Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Intent it = new Intent(this, Tela2Activity.class);
                it.putExtra("nome", "Glauber");
                it.putExtra("idade", 30);
                startActivity(it);
                break;
        }
    }
}