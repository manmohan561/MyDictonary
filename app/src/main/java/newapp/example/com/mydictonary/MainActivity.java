package newapp.example.com.mydictonary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String url;
    public TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        t1=findViewById( R.id.t1 );

        url=dictionaryEntries();
    }

    public void requestAoiButtonClick(View v)
    {
        MyDictonaryRequest myDictonaryRequest=new MyDictonaryRequest(this);
        myDictonaryRequest.execute(url);
    }

    private String dictionaryEntries() {

        final String language = "en-gb";
        final String word = "Ace";
        final String fields = "pronunciations";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }
}
