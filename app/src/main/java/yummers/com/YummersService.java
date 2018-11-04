package yummers.com;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class YummersService extends IntentService {

    public YummersService(){
        super("YummersService");
    }

    protected void onHandleIntent(@Nullable Intent intent){
        Log.d("Yummers 4IT-H ", "Service is running..." );
    }
}
