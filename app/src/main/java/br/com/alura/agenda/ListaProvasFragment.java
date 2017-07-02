package br.com.alura.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.alura.agenda.modelo.Prova;

/**
 * Created by Yan Alves on 12/06/2017.
 */

public class ListaProvasFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //Fragment não possui layout padrão, deve ser definido
        View view = inflater.inflate(R.layout.fragment_lista_provas, container, false);

        List<String> topicosPort = Arrays.asList("Sujeito", "Objeto direto");
        Prova provaPortugues = new Prova("Portugues", "10/06/2017", topicosPort);

        List<String> topicosMat = Arrays.asList("Equação", "Números irracionais");
        Prova provaMatematica = new Prova("Matemática", "10/06/2017", topicosMat);

        List<Prova> provas = Arrays.asList(provaPortugues, provaMatematica);
        //Parametros: Contexto, nome do widget, e a lista que será convertida pelo adapter
        ArrayAdapter<Prova> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, provas);

        ListView lista = (ListView) view.findViewById(R.id.provas_lista);
        //Definindo o adapter para a lista
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Prova prova = (Prova) adapterView.getItemAtPosition(position);
                Toast.makeText(getContext(), "Prova clicada: " + prova, Toast.LENGTH_SHORT).show();
                Intent vaiParadetalhes = new Intent(getContext(), DetalhesProvaActivity.class);
                //putExtra passando a prova para a nova activity (DetalhesProvaActivity)
                vaiParadetalhes.putExtra("prova", prova);
                startActivity(vaiParadetalhes);

            }
        });

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
