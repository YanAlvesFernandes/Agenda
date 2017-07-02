package br.com.alura.agenda.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.telephony.SmsMessage;
import android.widget.Toast;

import br.com.alura.agenda.dao.AlunoDAO;

/**
 * Created by Yan Alves on 23/07/2016.
 */
public class SMSReceiver extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {
        Object[] pdus = (Object[]) intent.getSerializableExtra("pdus");
        byte[] pdu = (byte[]) pdus[0];
        String formato = (String) intent.getSerializableExtra("format");

        SmsMessage sms = SmsMessage.createFromPdu(pdu, formato);
        String telefone = sms.getDisplayOriginatingAddress();
        AlunoDAO dao = new AlunoDAO(context);
        if (dao.eAluno(telefone)) {
            Toast.makeText(context, "Chegou um SMS de aluno", Toast.LENGTH_LONG).show();
/*          Para reproduzir outro arquivo de som:
            MediaPlayer mp = MediaPlayer.create(context, android.R.raw.msg);
            mp.start();*/
        }
        dao.close();
    }
}
