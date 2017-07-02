package br.com.alura.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import br.com.alura.agenda.modelo.Prova;

public class DetalhesProvaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_prova);

        //Recebendo o intent da ProvasActivity com o metodo getIntent()
        Intent intent = getIntent();
        //Objeto prova recebendo o que foi enviado pelo intent com o método getSerializableExtra
        Prova prova = (Prova) intent.getSerializableExtra("prova");

        //Criação dos objetos do XML
        TextView materia = (TextView) findViewById(R.id.detalhes_prova_materia);
        TextView data = (TextView) findViewById(R.id.detalhes_prova_data);
        ListView listaTopicos = (ListView) findViewById(R.id.detalhes_prova_topicos);

        //Método setText para definir o conteudo do TextView materia
        materia.setText(prova.getMateria());
        //Método setText para definir o conteudo do TextView data
        data.setText(prova.getData());


        //Criação de um arrayadapter chamado adapeter de Strings, com o conteudo do objeto provas, que foi recebido via intent.getSerializableExtra
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prova.getTopicos());
        //Método setAdapter para preencher a ListView listaTopicos com o adapter
        listaTopicos.setAdapter(adapter);
    }
}
