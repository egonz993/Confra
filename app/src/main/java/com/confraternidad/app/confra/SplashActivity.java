package com.confraternidad.app.confra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private StorageReference mStorage = FirebaseStorage.getInstance().getReference();

    private final int DURACION_SPLASH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            new Handler().postDelayed(() -> {
                if (getIntent().getStringExtra("INTERNET") != null) {
                    String URL = getIntent().getStringExtra("INTERNET");
                    gotoURL(URL);
                }else if (getIntent().getStringExtra("APLICACION") != null) {
                    finish();
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.putExtra("PAGE", getIntent().getStringExtra("APLICACION"));
                    startActivity(intent);
                }
                else {
                    finish();
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
            }, DURACION_SPLASH);
    }

    private void gotoURL(String URL){

        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(getResources().getColor(R.color.colorPrimary));

        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(URL));
    }



    private void createDatabaseContactos(){

        Map<String, Object> mapM = new HashMap<>();
        mapM.put("posicion", "00");
        mapM.put("categoria", "ministerios");
        mapM.put("titulo", "Titulo");
        mapM.put("uidLider", "2suBVbdZU3Y6HOGH3YyZ0uTAhUy1");

        for(int i = 1; i<= 8 ; i++){
            String uid = UUID.randomUUID().toString();
            mDatabase.child("contactos").child(uid).setValue(mapM);
        }

        Map<String, Object> mapE = new HashMap<>();
        mapE.put("posicion", "00");
        mapE.put("categoria", "especialistas");
        mapE.put("titulo", "Titulo");
        mapE.put("uidLider", "2suBVbdZU3Y6HOGH3YyZ0uTAhUy1");

        for(int i = 1; i<= 3 ; i++){
            String uid = UUID.randomUUID().toString();
            mDatabase.child("contactos").child(uid).setValue(mapE);
        }
    }
    private void createDatabaseServicios(){
        newVideo("24 de marzo de 2020","Celebración en semana","2020/03/24","https://www.youtube.com/watch?v=As3JjQ8tSBo");
        newVideo("¿Como ser feliz en tiempos de crisis?","Celebración en semana","2020/03/25","https://www.youtube.com/watch?v=IkSEztmL3X4");
        newVideo("La mirada hacia el futuro","Celebración en semana","2020/03/26","https://www.youtube.com/watch?v=IPl5SkJSnHM");
        newVideo("Celebración Domingo 29-03-2020","Celebración en semana","2020/03/29","https://www.youtube.com/watch?v=zmrY5s3pHcs");
        newVideo("Celebración 02-04-2020","Servicios Domingos","2020/04/02","https://www.youtube.com/watch?v=9TgAzBrzMAU");
        newVideo("1 Evangelismo","Propósitos para vivir en tiempos de pandemia","2020/04/05","https://www.youtube.com/watch?v=E2IbFr9YYq0");
        newVideo("2 Adoración","Propósitos para vivir en tiempos de pandemia","2020/04/10","https://www.youtube.com/watch?v=G3ljlMEGZvI");
        newVideo("3 Comunidad","Propósitos para vivir en tiempos de pandemia","2020/04/12","https://www.youtube.com/watch?v=ohRNGJuvwFk");
        newVideo("4 Discipulado","Propósitos para vivir en tiempos de pandemia","2020/04/16","https://www.youtube.com/watch?v=u_MG70ctUqI");
        newVideo("5 Servicio","Propósitos para vivir en tiempos de pandemia","2020/04/19","https://www.youtube.com/watch?v=K_cuLC-QtLg");
        newVideo("3 razones por las cuales Dios permite momentos de crisis","Celebración en semana","2020/04/23","https://www.youtube.com/watch?v=curz0B7NvlA");
        newVideo("#1 Dios Creador","Mirando el retrovisor","2020/04/26","https://www.youtube.com/watch?v=4qxFwpneYIc");
        newVideo("#2 Arca de salvación","Mirando el retrovisor","2020/04/30","https://www.youtube.com/watch?v=WT7ahLuslvk");
        newVideo("#3 Pan en tiempo de escasez","Mirando el retrovisor","2020/05/03","https://www.youtube.com/watch?v=MpuDyY4x2wk");
        newVideo("La oración","Mirando el retrovisor","2020/05/07","https://www.youtube.com/watch?v=8z6tiMcXW_k");
        newVideo("El Temor","Mirando el retrovisor","2020/05/10","https://www.youtube.com/watch?v=HK7YNtoo1eU");
        newVideo("Amando a una prostituta ¿Tu que eliges?","Celebración en semana","2020/05/14","https://www.youtube.com/watch?v=Tgc2QO-jeO4");
        newVideo("Plagas para liberar","Mirando el retrovisor","2020/05/17","https://www.youtube.com/watch?v=RAFvZIt0TQU");
        newVideo("El Dios que hace lo imposible","Mirando el retrovisor","2020/05/21","https://www.youtube.com/watch?v=6ufxvvP6VJg");
        newVideo("5 Lecciones canto de victoria","Mirando el retrovisor","2020/05/24","https://www.youtube.com/watch?v=DN5Tt8T33po");
        newVideo("Agüita Pa mi Gente","Mirando el retrovisor","2020/05/28","https://www.youtube.com/watch?v=0AH-wKWcuJs");
        newVideo("Soporte vital","Mirando el retrovisor","2020/05/31","https://www.youtube.com/watch?v=ialb_b8LoBs");
        newVideo("Pan del cielo","Mirando el retrovisor","2020/06/04","https://www.youtube.com/watch?v=P2jU6Lr0EeY");
        newVideo("Sanidad milagrosa","Mirando el retrovisor","2020/06/07","https://www.youtube.com/watch?v=yZO1MLn8H0A");
        newVideo("Habilidades de el futuro","Celebración en vivo","2020/06/11","https://www.youtube.com/watch?v=YuhZiFamd40");
        newVideo("Los lentes de la fe","Mirando el retrovisor","2020/06/14","https://www.youtube.com/watch?v=9RFJH4gI1pg");
        newVideo("¿Como disfrutar de la presencia de Dios?","Celebración en vivo","2020/06/18","https://www.youtube.com/watch?v=xX_tZHiKE3U");
        newVideo("El Dios que detiene pandemias mortales","Mirando el retrovisor","2020/06/21","https://www.youtube.com/watch?v=7vr8q7GXZKU");
        newVideo("Medicina del Cielo","Celebración en vivo","2020/06/25","https://www.youtube.com/watch?v=3-3IRTavrhQ");
        newVideo("Cuando Dios te bendice nada te maldice","Mirando el retrovisor","2020/06/28","https://www.youtube.com/watch?v=ZCgaCNr_Whk");
        newVideo("La palabra de Dios no está en cuarentena","Vigilia","2020/06/28","https://www.youtube.com/watch?v=Hd_PpdzdjZ8");
        newVideo("En búsqueda de la felicidad","Celebración en vivo","2020/07/02","https://www.youtube.com/watch?v=RcX6LebFkCo");
        newVideo("Un nuevo aliento","Servicios Domingos","2020/07/05","https://www.youtube.com/watch?v=2I-r5GQlVMA");

    }
    private void newVideo(String title, String description, String date, String link){

        String uid = UUID.randomUUID().toString();

        Map<String, Object> map = new HashMap<>();
        map.put("date", date);
        map.put("title", title);
        map.put("description", description);
        map.put("link", link);

        mDatabase.child("servicios").child(uid).setValue(map);
    }

    private void createDatabasePeticiones(){

        for(int i = 1; i<= 3 ; i++){
            Calendar rightNow = Calendar.getInstance();
            int year = rightNow.get(Calendar.YEAR);
            int month = rightNow.get(Calendar.MONTH)+1;
            int day = rightNow.get(Calendar.DAY_OF_MONTH);
            int hour = rightNow.get(Calendar.HOUR_OF_DAY);
            int min = rightNow.get(Calendar.MINUTE);
            int sec = rightNow.get(Calendar.SECOND);

            String dateTime;
            if(month<10){
                dateTime = year + "/0" + month + "/" + day + " " + hour + ":" + min + ":" + sec;
            }else{
                dateTime = year + "/" + month + "/" + day + " " + hour + ":" + min + ":" + sec;
            }

            Map<String, Object> mapPeticiones = new HashMap<>();
            mapPeticiones.put("idUsuario", mFirebaseAuth.getCurrentUser().getUid());
            mapPeticiones.put("fecha_hora", dateTime);
            mapPeticiones.put("titulo", "Peticion "+i);
            mapPeticiones.put("peticion", "Descripcion");
            mapPeticiones.put("leido", "no");
            mapPeticiones.put("destino", mFirebaseAuth.getCurrentUser().getUid());


            String uid = UUID.randomUUID().toString();
            mDatabase.child("peticiones").child(uid).setValue(mapPeticiones);
        }
    }
}