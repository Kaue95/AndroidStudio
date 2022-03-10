package com.example.mapsapp;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Permissoes {

    public static boolean validarpermn (String[] permissoes, Activity activity, int request){

        if (Build.VERSION.SDK_INT >=23) {
            List<String> ListaPermissoes = new ArrayList<>();

            for (String permissao : permissoes){
                Boolean temPermissao = ContextCompat.checkSelfPermission(activity, permissao) == PackageManager.PERMISSION_GRANTED;
                if (!temPermissao) ListaPermissoes.add(permissao);
            }

            if (ListaPermissoes.isEmpty()) return true;
            String[] novasPermissoes = new String[ListaPermissoes.size()];
            ListaPermissoes.toArray(novasPermissoes);

            ActivityCompat.requestPermissions(activity, novasPermissoes, request);


        }
        return true;
    }
}
